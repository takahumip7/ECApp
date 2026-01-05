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
@Table(name = "order_address")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderAddress {

	/** 配送先ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** 注文ID */
	@Column(name = "order_id", nullable = false)
	private Long orderId;
	
	/** 郵便番号 */
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	
	/** 都道府県 */
	@Column(nullable = false)
	private String prefecture;
	
	/** 住所 */
	@Column(nullable = false)
	private String address1;
	
	/** 建物名 */
	private String address2;
	
	/** 作成日次 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	/** 更新日次 */
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
