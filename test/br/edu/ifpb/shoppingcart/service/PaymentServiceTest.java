package br.edu.ifpb.shoppingcart.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifpb.shoppingcart.entity.Address;
import br.edu.ifpb.shoppingcart.entity.AddressType;
import br.edu.ifpb.shoppingcart.entity.Bank;
import br.edu.ifpb.shoppingcart.entity.Customer;
import br.edu.ifpb.shoppingcart.entity.PaymentMethod;

public class PaymentServiceTest {

	PaymentService paymentService;
	Bank creditOperator;
	Customer customer;
	Map<AddressType, Address> addresses;
	
	@Before
	@SuppressWarnings("unchecked")
	public void initialize() {
		
		customer = new Customer();
		customer.setId(1);
		customer.setName("Pedro");
		creditOperator = new Bank(customer, new BigDecimal("5000.00"));
		creditOperator.setPaymentMethod(PaymentMethod.IFPAY);
		addresses = (Map<AddressType, Address>) new 
				HashMap<AddressType, Address>();
				addresses.put(AddressType.HOME, 
				new Address("Rua um", "200", "444"));
				
				paymentService = new PaymentService(creditOperator);
		
	}
	
	
	@Test
	public void testaClienteTemCredito() {	
		
		assertTrue(paymentService.hasCredit(customer,new BigDecimal("2300.00")));			   	
		
	}
	
	@Test
	public void testaBaixaCreditoCliente() {
		customer = new Customer();
		customer.setId(1);
		customer.setName("Pedro");
		
		Bank operator = new Bank(customer, new BigDecimal("5000.00"));
		operator.setPaymentMethod(PaymentMethod.CREDITCARD);
		PaymentService service = new PaymentService(operator);
		
				
		
		service.pay(customer, new BigDecimal("1000.00"));
		
		assertEquals(new BigDecimal("4000.00"), operator.getCustomerCredit(customer));
		
		
		
		
		
		
		
		
		
	}
}
