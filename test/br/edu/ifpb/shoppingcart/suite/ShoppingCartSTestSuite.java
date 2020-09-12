package br.edu.ifpb.shoppingcart.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.ifpb.shoppingcart.entity.BankTest;
import br.edu.ifpb.shoppingcart.entity.ShoppingCartTest;
import br.edu.ifpb.shoppingcart.service.CartServiceTest;
import br.edu.ifpb.shoppingcart.service.PaymentServiceTest;

@RunWith(Suite.class)

@SuiteClasses({
	CartServiceTest.class,
	ShoppingCartTest.class,
	BankTest.class,
	PaymentServiceTest.class
})
public class ShoppingCartSTestSuite {

}
