package com.techshop.product.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techshop.product.entity.Product;
import com.techshop.product.services.ProductServices;

@RestController
@RequestMapping ("/product/")
public class ProductRest {
	
	@Autowired
	private ProductServices productServices;
	
	@PostConstruct
	public void init() {
		
		List<Product> products = new ArrayList<Product> ();
		products.add(new Product("Asus core i5 10094", "Computador de gama media", 1500000, 10));
		products.add(new Product("Asus core i3 10094", "Computador de gama baja", 1000000, 5));
		products.add(new Product("Teclado Gamer RGB", "Teclado Gamer RGB", 200000, 8));
		products.add(new Product("Mouse logitech G502", "Mouse logitech G502", 205000, 3));
		products.add(new Product("Amplificador Wifi", "Amplificador Wifi", 70000, 15));
		productServices.saveAll(products);

	}
	
	@GetMapping
	private ResponseEntity<List<Product>> getAllProducts (){
		return ResponseEntity.ok(productServices.findAll());
	};
	
	
	@PostMapping("update")
	private ResponseEntity<Product> update(@RequestBody Product product){
	try {
		return ResponseEntity.created(new URI("/product/update/")).body(productServices.save(product));
	} catch (URISyntaxException e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	};

}
