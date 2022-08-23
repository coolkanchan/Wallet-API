package com.ewallet.api.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(schema = "public", name = "wallets")
public class Wallet extends BaseEntity {

	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Currency currency;

	@Builder.Default
	private Double balance = 0D;

	@Builder.Default
	private LocalDateTime created = LocalDateTime.now();

	private String details;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	@ToString.Exclude
	private Customer customer;

	@ToString.Exclude
	@OneToMany(mappedBy = "wallet")
	private List<Transaction> transactions;

}