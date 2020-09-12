package br.edu.ifpb.shoppingcart.entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Product {
	
	private String name;
	private BigDecimal price;
	private String description;
	

}
