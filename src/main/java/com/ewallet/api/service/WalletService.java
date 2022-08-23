package com.ewallet.api.service;

import com.ewallet.api.VO.WalletAssemblerVO;
import com.ewallet.api.VO.WalletVO;
import com.ewallet.api.entity.*;
import com.ewallet.api.repository.CustomerRepository;
import com.ewallet.api.repository.TransactionRepository;
import com.ewallet.api.repository.WalletRepository;
import com.ewallet.api.service.exception.types.ResourceNotFound;
import com.ewallet.api.service.exception.types.TransactionNotAllowed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletService {

	private final WalletRepository walletRepository;
	private final WalletAssemblerVO walletAssembler;
	private final CustomerRepository customerRepository;
	private final TransactionRepository transactionRepository;

	public WalletVO create(Long id, Currency currency, String name) {
		log.info("method indise Wallet Service  to invoke create");
		Wallet wallet = new Wallet();
		wallet.setName(name);
		wallet.setCurrency(currency);
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id, Customer.class));
		wallet.setCustomer(customer);
		walletRepository.save(wallet);
		return walletAssembler.toModel(wallet);
	}

	public WalletVO getWallet(Long id) {
		log.info("method indise Wallet Service  to invoke getWallet");
		return walletAssembler.toModel(walletRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id, Wallet.class)));
	}

	public List<WalletVO> getAll() {
		log.info("method indise Wallet Service  to invoke getAll");
		return walletAssembler.toModel(walletRepository.findAll());
	}

	public WalletVO updateBalance(Long id, Double amount, TransactionType type) {
		log.info("method indise Wallet Service  to invoke updateBalance");
		Wallet wallet = walletRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id, Wallet.class));
		Transaction transaction = new Transaction();
		transaction.setTransactionType(type);
		transaction.setWallet(wallet);
		transaction.setAmount(amount);
		if (type == TransactionType.CREDIT) {
			amount = Math.abs(amount);
		}
		else if (type == TransactionType.DEBIT) {
			amount = -1 * Math.abs(amount);
		}
		if (wallet.getBalance() + amount >= 0) {
			wallet.setBalance(wallet.getBalance() + amount);
		}
		else {
			throw new TransactionNotAllowed(id, "Insufficient Funds", Wallet.class);
		}
		walletRepository.save(wallet);
		transactionRepository.save(transaction);
		return walletAssembler.toModel(wallet);
	}

}
