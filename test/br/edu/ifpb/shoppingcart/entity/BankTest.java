package br.edu.ifpb.shoppingcart.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifpb.shoppingcart.entity.Bank;
import br.edu.ifpb.shoppingcart.entity.Customer;
import br.edu.ifpb.shoppingcart.entity.PaymentMethod;

public class BankTest {

	Bank operator;
	Customer customer;
	
	@Before
	public void initialize() {
		customer = new Customer();
		customer.setId(1);
		customer.setName("João");
		this.operator = new Bank(customer,new BigDecimal("10000.00"));
		this.operator.setPaymentMethod(PaymentMethod.CREDITCARD);
	}
	
	@Test
	public void testaCreditoDoCliente() {
		assertNotNull(this.operator.getCustomer());
		assertEquals(new BigDecimal("10000.00"), this.operator.getCustomerCredit(customer));
	}
	
	@Test
	public void testaSaqueDoPagamento() {
		this.operator.withdraw(new BigDecimal("5000.00"));		
		assertEquals(new BigDecimal("5000.00"),this.operator.getCustomerCredit(customer));
	}
}
