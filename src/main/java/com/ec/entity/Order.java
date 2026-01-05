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
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {

	/** 注文ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** 注文番号 */
	@Column(name = "order_number", nullable = false, unique = true)
	private String orderNumber;
	
	/** ユーザーID */
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	/** 合計金額 */
	@Column(nullable = false)
	private int total;
	
	/** 注文ステータス */
	@Column(nullable = false)
	private String status;
	
	/** 作成日次 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	/** 更新日次 */
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
