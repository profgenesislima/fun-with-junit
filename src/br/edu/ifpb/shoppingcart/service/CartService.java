package br.edu.ifpb.shoppingcart.service;

import br.edu.ifpb.shoppingcart.entity.Customer;
import br.edu.ifpb.shoppingcart.entity.PaymentMethod;
import br.edu.ifpb.shoppingcart.entity.ShoppingCart;

public class CartService {

	private ShoppingCart cart;
	private Customer customer;
	private PaymentMethod paymentMethod;
	
	
	
	
	public CartService(ShoppingCart cart, Customer customer, PaymentMethod paymentMethod) {
		super();
		this.cart = cart;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
		
	}


	public boolean checkout() {
		if(paymentMethod != null  && cart.getItems().size() > 0 && customer.getAddresses().size() > 0) {
			return true;
		}
	
		return false;
	}


	public ShoppingCart getCart() {
		return cart;
	}


	public Customer getCustomer() {
		return customer;
	}


	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	
	
}
