package edu.eci.cvds.parcial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParcialApplicationTests {
	StockService st;
	@BeforeEach
	void prepare(){
		st = new StockService(new SubscriberLog(), new SubscriberWarning());

	}

	@Test
	void addProductTest() {
		Product product = new Product();
		product.setId("1");
		product.setName("Xbox");
		product.setCategory("Console");
		product.setPrice(1200);
		product.setQuantity(100);
		assertTrue(st.addProduct(product));
	}
	@Test
	void addProductTest_shouldNotAddTheSameId(){
		Product product1 = new Product();
		product1.setId("1");
		product1.setName("Xbox");
		product1.setCategory("Console");
		product1.setPrice(1200);
		product1.setQuantity(100);
		this.st.addProduct(product1);
		Product product2 = new Product();
		product2.setId("1");
		product2.setName("Ps4");
		product2.setCategory("Console");
		product2.setPrice(1000);
		product2.setQuantity(200);
		assertFalse(this.st.addProduct(product2));
	}
	@Test
	void addProductTest_ShouldNotAddProductsWithNegativeValues(){
		Product product1 = new Product();
		product1.setId("1");
		product1.setName("Xbox");
		product1.setCategory("Console");
		product1.setPrice(-1200);
		product1.setQuantity(-100);
		assertFalse(this.st.addProduct(product1));
	}
	@Test
	void modifyStock(){
		Product product1 = new Product();
		product1.setId("1");
		product1.setName("Xbox");
		product1.setCategory("Console");
		product1.setPrice(1200);
		product1.setQuantity(100);
		this.st.addProduct(product1);
		assertTrue(st.modifyStock("1",99));

	}
	@Test
	void modifyStock_shouldNotModifyInexistentProduct(){
		assertFalse(st.modifyStock("1",99));
	}
	@Test
	void modifyStock_shouldNotPutNegativeQuantities(){
		Product product1 = new Product();
		product1.setId("1");
		product1.setName("Xbox");
		product1.setCategory("Console");
		product1.setPrice(1200);
		product1.setQuantity(100);
		this.st.addProduct(product1);
		assertFalse(st.modifyStock("1",-99));
	}

}
