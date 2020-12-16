package br.edu.ifpb.shoppingcart.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

	
	private int id;
	private String name;
	private int age;
	private Gender gender;
	private Map<AddressType, Address> addresses;	
	
	
	
	
}
