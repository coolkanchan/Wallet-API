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
@Table(schema = "public", name = "customers")
public class Customer extends BaseEntity {

	@Column(unique = true, nullable = false)
	private String email;

	private String name;

	@Builder.Default
	private LocalDateTime joined = LocalDateTime.now();

	private String password;

	@ToString.Exclude
	@OneToMany(mappedBy = "customer")
	private List<Wallet> wallets;
}