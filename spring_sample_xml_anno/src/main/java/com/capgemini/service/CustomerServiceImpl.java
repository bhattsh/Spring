package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Customer;
import com.capgemini.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	/*
	 * @Autowired 
	 * private CustomerRepository customerRepository ;
	 */
	
	 private CustomerRepository customerRepository ;
	
	 @Autowired
	 public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	//@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		 System.out.println("hello setter injection using autowired");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
