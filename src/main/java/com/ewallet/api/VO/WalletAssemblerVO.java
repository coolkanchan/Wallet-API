package com.ewallet.api.VO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ewallet.api.entity.Wallet;

import java.util.*;

@Service
@RequiredArgsConstructor
public class WalletAssemblerVO {


	public List<WalletVO> toModel(List<Wallet> entities) {
		if (entities == null) {
			return null;
		}

		List<WalletVO> list = new ArrayList<WalletVO>(entities.size());
		for (Wallet wallet : entities) {
			list.add(toModel(wallet));
		}

		return list;
	}

	public WalletVO toModel(Wallet entity) {
		WalletVO dto = new WalletVO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setBalance(entity.getBalance());
		dto.setCurrency(entity.getCurrency().toString());
		dto.setCreated(entity.getCreated());
		return dto;
	}
}
