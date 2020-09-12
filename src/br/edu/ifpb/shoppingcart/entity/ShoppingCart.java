package br.edu.ifpb.shoppingcart.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {
	private List<Item> items = new ArrayList<Item>();
	
	public void add(Product product,int quantity) {	
		if(product != null && quantity > 0)
		items.add(new Item(product,quantity));			
		}
	
	public boolean updateQuantity(Product product, int quantity) {
		Item item = this.findProduct(product);
		if(item != null){
			item.setQuantity(quantity);			
			return true;
		}
		return false;
	}
	
	public void remove(Product product) {
		//com Lambda ficaria:
		//items.remove(findProduct(product));
		
		for(Item item:items) {
			if(item.getProduct().equals(product)) {
			   Item found = item;
			   items.remove(found);
			   break;
			}

		}
	}
	
	public BigDecimal getTotal() {
    BigDecimal total = BigDecimal.ZERO;
		for (Item item : items) {
		total  = total.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
		return total;
	}


	private Item findProduct(Product product) {
		return items.stream().filter(i -> i.getProduct().equals(product)).findAny().get();
	}
	
	public List<Item> getItems() {
		return this.items;
	}
}
