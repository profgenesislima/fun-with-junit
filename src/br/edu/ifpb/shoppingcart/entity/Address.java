package br.edu.ifpb.shoppingcart.entity;

import lombok.Data;

@Data
public class Address{
	
	private String street;
	private String number;
	private String zipCode;
	private String description;
	
	
	public Address(String street, String number, String zipCode) {
		super();
		this.street = street;
		this.number = number;
		this.zipCode = zipCode;
	}
	
	
}
