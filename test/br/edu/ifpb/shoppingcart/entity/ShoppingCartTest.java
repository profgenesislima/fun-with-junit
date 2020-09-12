package br.edu.ifpb.shoppingcart.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifpb.shoppingcart.entity.Product;
import br.edu.ifpb.shoppingcart.entity.ShoppingCart;

public class ShoppingCartTest {

	ShoppingCart cart = new ShoppingCart();
	Product product = new Product();

	
	@Before
	public void initialize() {
		product.setName("LEGO Duplo");
		product.setDescription("Blocks for kids creativity development.");
	}
	
	@Test
	public void testaProdutoInseridoComSucesso() {
		cart.add(product, 10);
		assertTrue(cart.getItems().size() == 1);
		assertEquals("LEGO Duplo", cart.getItems().get(0).getProduct().getName());
		assertTrue(cart.getItems().get(0).getQuantity() == 10);
	}
	
	
	
	@After
	public void finalize() {
		cart.getItems().clear();
	}
	
	@Test
	public void testaValorCarrinhoVazio() {
		assertTrue(cart.getItems().size() == 0);
		assertEquals(BigDecimal.ZERO, cart.getTotal());
	}
	
	
	//Use mockito to test method without external access
//	@Test
//	public void testaProductEncontrado() {
//		Product p = new Product();
//		p.setName("Hot Wheels");
//		cart.add(product, 10);
//		cart.add(p, 2);		
//		Item item = cart.findProduct(p);
//		assertTrue(cart.getItems().size() == 2);
//		assertEquals("Hot Wheels", item.getProduct().getName());
//
//	}
//	
	@Test
	public void testaProdutoAtualizado() {
		cart.add(product, 1);
		assertTrue(cart.getItems().size() == 1);
		
		assertEquals(true, cart.updateQuantity(product, 12));
		
		assertTrue(cart.getItems().get(0).getQuantity() == 12);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testaProdutoAtualizacaoProdutoNaoExistente() {
		Product p = new Product();
		cart.updateQuantity(p, 12);
		assertEquals(false, cart.updateQuantity(p, 12));
	}
	
	@Test
	public void testaProdutoRemovido() {
		Product p = new Product();
		p.setName("Hot Wheels");	
		
		cart.add(product, 10);
		
		assertTrue(cart.getItems().size() == 1);
		
		cart.add(p, 2);
		
		int tamanhoAntesRemocao = cart.getItems().size();

		cart.remove(p);

		assertTrue(cart.getItems().size() < tamanhoAntesRemocao);
		assertEquals("LEGO Duplo",cart.getItems().get(0).getProduct().getName());
		
	}
	
	@Test
	public void testaValorTotalDaCompra() {
		Product p = new Product();
		p.setName("Hot Wheels");
		cart.add(product, 10);
		cart.add(p, 2);
		
		product.setPrice(new BigDecimal(200.00));
		p.setPrice(new BigDecimal(150.00));
		assertTrue(cart.getItems().size() == 2);
		assertEquals(new BigDecimal(2300.00), cart.getTotal());
		
	}
	
	@Test
	public void testaCarrinhoComQuantitativoNegativo() {
		
		Product p = new Product();
		p.setName("Hot Wheels");
		cart.add(product, -1);
		
		assertTrue(cart.getItems().size() == 0);
		
	}
	
	@Test
	public void testaCarrinhoSemProduto() {
		cart.add(null, 1);
		assertTrue(cart.getItems().size() == 0);
	}
	
	
	@Test
	public void testaRemoverProdutoCarrinhoVazio() {
		Product p = new Product();
		p.setName("Hot Wheels");
		cart.add(p, 2);
		
		assertTrue(cart.getItems().size() == 1);

		cart.remove(p);
		
		assertTrue(cart.getItems().size() == 0);
		
	}
	
	
}
