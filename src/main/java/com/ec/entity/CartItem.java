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
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CartItem {

	/** カート商品ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** カートID */
	@Column(name = "cart_id", nullable = false)
	private Long cartId;
	
	/** 商品ID */
	@Column(name = "product_id", nullable = false)
	private Long productId;
	
	/** 数量 */
	@Column(nullable = false)
	private int amount;
	
	/** 価格 */
	@Column(nullable = false)
	private int price;
	
	/** 作成日次 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	/** 更新日次 */
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
