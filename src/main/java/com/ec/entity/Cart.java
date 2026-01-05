package com.ec.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cart {

	/** カートID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** ユーザーID */
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	/** 作成日次 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	/** 更新日次 */
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
