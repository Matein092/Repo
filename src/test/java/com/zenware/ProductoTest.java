package com.zenware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zenware.Producto;

class ProductoTest {

	@Test
	void applyTaxes_valid() {
		Producto product = new Producto(2L, "football shoes", 20000);
		product.applyTaxes(35);	
		assertEquals(27000, product.getPrice(), 0.001);
		}
	
	@Test
	void applyTaxes_Exception() {
		Producto product = new Producto(3L, "Sandals", 15000);
		assertThrows(IllegalArgumentException.class, () ->{
			product.applyTaxes(65);
		});
	}

}
