package br.edu.ifpb.shoppingcart.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Bank {

	private Customer customer;
	private PaymentMethod paymentMethod;

	private Map<Integer,BigDecimal> wallet;
 

	public Bank(Customer customer, BigDecimal cash) {
		super();
		this.customer = customer;	
		wallet = new HashMap<Integer, BigDecimal>();
		wallet.put(customer.getId(),cash);
	}
	
	
	
	public BigDecimal getCustomerCredit(Customer customer) {
		return wallet.get(customer.getId());
	}
	
	public BigDecimal withdraw(BigDecimal amount) {
		BigDecimal value =  wallet.get(customer.getId()).subtract(amount);
		wallet.remove(customer.getId());
		wallet.put(customer.getId(), value);
		return wallet.get(customer.getId());
		
}
	
	
	
	
	
	
}
