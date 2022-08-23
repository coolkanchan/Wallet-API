package com.ewallet.api.VO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WalletVO extends BaseEntityVO {

	private String name;

	private String currency;

	private Double balance;

	private LocalDateTime created;

}