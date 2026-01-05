package com.ec.entity;

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
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderItem {
	
	/** 注文商品ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** 注文ID */
	@Column(nullable = false)
	private Long orderId;
	
	/** 商品ID */
	@Column(nullable = false)
	private Long productId;
	
	/** 商品名 */
	@Column(nullable = false)
	private String productTitle;
	
	/** 数量 */
	@Column(nullable = false)
	private int amount;
	
	/** 価格 */
	@Column(nullable = false)
	private int price;
	
	/** 小計 */
	@Column(name = "sub_total", nullable = false)
	private int subTotal;

}
