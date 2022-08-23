package com.ewallet.api.controller;


import com.ewallet.api.VO.WalletVO;
import com.ewallet.api.entity.*;
import com.ewallet.api.service.WalletService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Wallet")
@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://172.20.208.1:3000", "http://localhost:3000"})
@Slf4j
public class WalletContoller {

	private final WalletService walletService;

	@ApiOperation(value = "Get Wallet by Wallet id")
	@GetMapping("/{id}")
	public WalletVO getWallet(@PathVariable("id") Long id) {
		log.info("method indise Wallet Contoller  to invoke getWallet");
		return walletService.getWallet(id);
	}

	@ApiOperation(value = "Create a Wallet for a Customer by Customer id")
	@PostMapping("/create")
	public WalletVO create(@RequestParam(name = "id") Long id, @RequestParam Currency currency, @RequestParam String name) {
		log.info("method indise Wallet Contoller  to invoke create");
		return walletService.create(id, currency, name);
	}

	@ApiOperation(value = "TopUp / Withdraw from a Wallet by Wallet id ")
	@PutMapping("/update/{id}")
	public WalletVO updateBalance(@PathVariable("id") Long id, @RequestParam TransactionType type, @RequestParam Double amount) {
		log.info("method indise Wallet Contoller  to invoke updateBalance");
		return walletService.updateBalance(id, amount, type);
	}

	@ApiOperation(value = "Get All Wallets")
	@GetMapping("/list")
	public List<WalletVO> getAll() {
		log.info("method indise Wallet Contoller  to invoke getAll");
		return walletService.getAll();
	}


}