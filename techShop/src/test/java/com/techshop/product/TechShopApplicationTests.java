package com.techshop.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techshop.product.entity.Account;
import com.techshop.product.entity.Product;
import com.techshop.product.services.AccountServices;
import com.techshop.product.services.ProductServices;


@SpringBootTest
class TechShopApplicationTests {
	
	@Autowired
	private AccountServices accountServices;
	
	@Autowired
	private ProductServices productServices;
	
	@Test //Revisar que la carga de datos sea la correcta
	public void testSize() {
		accountServices.deleteAll();
		assertThat(accountServices.findAll()).isEmpty();
		assertThat(productServices.findAll()).isNotEmpty();
	}
	
	@Test //Revisar que se pueda guardar datos
	public void saveAccount() {
		accountServices.deleteAll();
		Account account = new Account(productServices.findAll().get(1).getName(),1,1500000,1036);
		accountServices.save(account);
		assertThat(accountServices.findAll()).isNotEmpty();
		accountServices.delete(account);
	}
	
	@Test ///Revisar que se pueda guardar varios datos
	public void saveManyProductsToClient() {
		accountServices.deleteAll();
		Account account1 = new Account(productServices.findAll().get(1).getName(),1,1500000,1036);
		accountServices.save(account1);
		Account account2 = new Account(productServices.findAll().get(2).getName(),1,1500000,1036);
		accountServices.save(account2);
		Account account3 = new Account(productServices.findAll().get(3).getName(),1,1500000,1036);
		accountServices.save(account3);
		assertThat(accountServices.findAll().size()).isEqualTo(3);
		
	}
	
	@Test //Validar que solo guarde pedido si la cantidad es mayo a cero
	public void saveZeroProductToClient() {
		accountServices.deleteAll();
		Account account = new Account(productServices.findAll().get(1).getName(),0,1500000,1036);
		accountServices.save(account);
		assertThat(accountServices.findAll()).isEmpty();
	}
	
	@Test //Cambiar cantidad de un producto
	public void updateAccount() {
		accountServices.deleteAll();
		Account account = new Account(productServices.findAll().get(1).getName(),1,1500000,1036);
		accountServices.save(account);
		assertThat(account.getQuantityOrdered()).isEqualTo(1);
		account.setQuantityOrdered(4);
		accountServices.save(account);
		assertThat(account.getQuantityOrdered()).isEqualTo(4);

	}
	
	@Test //Guardar varias veces el mismo producto
	public void ProductsEquals() {
		accountServices.deleteAll();
		Account account = new Account(productServices.findAll().get(1).getName(),1,1500000,1036);
		accountServices.save(account);
		account = new Account(productServices.findAll().get(1).getName(),2,1500000,1036);
		accountServices.save(account);
		assertThat(account.getQuantityOrdered()).isEqualTo(3);
	}
	
	@Test //Actualizar inventario
	public void updateStock() {
		Product product = productServices.findAll().get(0);
		assertThat(product.getQuantityAvailable()).isEqualTo(10);
		product.setQuantityAvailable(9);
		productServices.save(product);
		assertThat(product.getQuantityAvailable()).isEqualTo(9);
	}

}
