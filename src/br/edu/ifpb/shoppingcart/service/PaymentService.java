package br.edu.ifpb.shoppingcart.service;

import java.math.BigDecimal;

import br.edu.ifpb.shoppingcart.entity.Bank;
import br.edu.ifpb.shoppingcart.entity.Customer;


public class PaymentService {
	
	private Bank creditOperator;	
	
	
	public PaymentService(Bank bank) {
		this.creditOperator = bank;
	}
	
	@SuppressWarnings("unchecked")
	public PaymentService() {
		//Mock Database data
//		Map<AddressType, Address> addresses = (Map<AddressType, Address>) new 
//		HashMap<AddressType, Address>();
//		addresses.put(AddressType.HOME, new Address("Rua um", "200", "444"));		
//		customer = new Customer(1,"Genesis", 33, Gender.MALE,addresses);
//		credit = new Credit(customer, new BigDecimal("2300.00"));

	}
	
	
	public void pay(Customer customer, BigDecimal totalValue) {
		if(hasCredit(customer,totalValue)) {
			creditOperator.withdraw(totalValue);
		}
	}
	
	public boolean hasCredit(Customer customer, BigDecimal total) {
		BigDecimal creditInWallet = BigDecimal.ZERO;
		if(creditOperator.getWallet().containsKey(customer.getId())) {		
		creditInWallet = creditOperator.getWallet().get(customer.getId());
		}
		return (creditInWallet.compareTo(total) == 1 ? true : false);
	}

}
