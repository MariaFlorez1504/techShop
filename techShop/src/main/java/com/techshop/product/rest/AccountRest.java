package com.techshop.product.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techshop.product.entity.Account;
import com.techshop.product.services.AccountServices;

@RestController
@RequestMapping ("/account/")
public class AccountRest {
	
	
	@Autowired
	private AccountServices accountServices;
	
	@PostConstruct
	public void init() {	
		accountServices.deleteAll();
	}
	
	@GetMapping("all/")
	private ResponseEntity<List<Account>> getAllProducts (){
		return ResponseEntity.ok(accountServices.findAll());
	};
	
	@PostMapping 
	private ResponseEntity<Account> saveAccount(@RequestBody Account account){
		try {
			return ResponseEntity.created(new URI("/account/save/")).body(accountServices.save(account));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	};
	
	@GetMapping("{id}")
	private ResponseEntity<List<Account>> getProductsByClient (@PathVariable int id){
		return ResponseEntity.ok(accountServices.findAllByClient(id));
	};
	
	@DeleteMapping("/delete")
	private ResponseEntity<List<Account>> deleteProduct(@RequestBody Account account){
		accountServices.delete(account);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
}
