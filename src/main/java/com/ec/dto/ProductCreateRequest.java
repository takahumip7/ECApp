package com.ec.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateRequest {

	/** 商品名 */
	private String name;
	
	/** 商品説明 */
	private String description;
	
	/** 価格 */
	private int price;
	
	/** 在庫数 */
	private int stock;
}
