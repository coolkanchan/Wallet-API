package com.ewallet.api.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}