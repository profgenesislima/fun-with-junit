package br.edu.ifpb.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Item {
	
	private Product product;
	private int quantity;

}
