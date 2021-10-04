package com.techshop.product.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.techshop.product.entity.Account;
import com.techshop.product.repository.AccountInterface;

@Service
public class AccountServices implements AccountInterface{

	@Autowired
	private AccountInterface accountInterface;
	
	public List<Account> findAllByClient(int id) {
		
		List<Account> accountByClient = new ArrayList<Account>();
		List<Account> account = accountInterface.findAll();
		
		for (int i=0; i<account.size(); i++) {
			if(account.get(i).getIdClient() == id) {
				accountByClient.add(account.get(i));
			}
		}
		return accountByClient;
	}
	
	@Override
	public <S extends Account> S save(S entity) {
		
		if (entity.getQuantityOrdered()>0) {
		List<Account> account = accountInterface.findAll();
		
		for (int i=0; i<account.size(); i++) {
			//Si el id del cliente es el mismo se revisa si se debe actualizar la orden
			if(account.get(i).getIdClient() == entity.getIdClient()) {
				
				//Si el nombre del producto es el mismo y sus ids son diferentes, se actualiza el monto de ese producto
				if (account.get(i).getNameProduct().equals(entity.getNameProduct()) && account.get(i).getId() != entity.getId()) { 
					
					
						entity.setQuantityOrdered(account.get(i).getQuantityOrdered()+entity.getQuantityOrdered());
						entity.setId(account.get(i).getId());
					
					
				}
			}
		}
		
			return accountInterface.save(entity);
		} 
		else {
			return null;
		}
	}
	@Override
	public List<Account> findAll() {
		return accountInterface.findAll();
	}

	@Override
	public List<Account> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return accountInterface.findAll(sort);
	}

	@Override
	public List<Account> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return accountInterface.findAllById(ids);
	}

	@Override
	public <S extends Account> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return accountInterface.saveAll(entities);
	}

	@Override
	public void flush() {
		accountInterface.flush();
	}

	@Override
	public <S extends Account> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Account> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		accountInterface.deleteById(id);
	}

	@Override
	public void delete(Account entity) {
		accountInterface.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		accountInterface.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		accountInterface.deleteAll(entities);
		
	}

	@Override
	public void deleteAll() {
		accountInterface.deleteAll();
		
	}

	@Override
	public <S extends Account> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Account> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Optional<Account> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
