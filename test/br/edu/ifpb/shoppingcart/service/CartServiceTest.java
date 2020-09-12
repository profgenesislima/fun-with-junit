package br.edu.ifpb.shoppingcart.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifpb.shoppingcart.entity.Address;
import br.edu.ifpb.shoppingcart.entity.AddressType;
import br.edu.ifpb.shoppingcart.entity.Customer;
import br.edu.ifpb.shoppingcart.entity.PaymentMethod;
import br.edu.ifpb.shoppingcart.entity.Product;
import br.edu.ifpb.shoppingcart.entity.ShoppingCart;

public class CartServiceTest {

	CartService cartService;
	ShoppingCart cart;
	Customer customer;
	Product product;
	Map<AddressType, Address> addresses = new HashMap<AddressType, Address>();
	
	
	@Before
	@SuppressWarnings("unchecked")
	public void initialize(){
		cart = new ShoppingCart();
		
		customer = new Customer();
		customer.setName("Pedro");
		customer.setAddresses(addresses);
		
		product = new Product();
		product.setName("LEGO");
		
		addresses.put(AddressType.HOME,new Address("Rua um", "200", "444"));
		
	}
	
	
	@Test
	public void testaFechamentoDaCompra() {
	
		cart.add(product, 2);		
		CartService cs = new CartService(cart,customer,PaymentMethod.CREDITCARD);	
		assertTrue(cs.checkout());
	}
	
	@Test	
	public void testaResumodaCompraPosFechamento() {
		
		customer.setName("Pedro");
			
		customer.setAddresses(addresses);
		
		cart.add(product, 2);
		CartService cs = new CartService(cart,customer,PaymentMethod.DEBITCARD);	
		assertTrue(cs.checkout());
		assertEquals("Pedro", cs.getCustomer().getName());
		assertTrue(cs.getCart().getItems().size() > 0 );
		assertEquals("LEGO", cs.getCart().getItems().get(0).getProduct().getName());
	}
	
	@Test
	public void testaCarrinhoSemproduto() {
		ShoppingCart cart = new ShoppingCart();		
		CartService cs = new CartService(cart, customer, PaymentMethod.IFPAY);
		assertFalse(cs.checkout());
	}
	
	
	
}
