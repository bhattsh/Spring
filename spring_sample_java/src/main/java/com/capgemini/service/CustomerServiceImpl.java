package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.model.Customer;
import com.capgemini.repository.CustomerRepository;

@Service("customerService")
@Scope("singleton")
public class CustomerServiceImpl implements CustomerService {

//	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl()
	{
		
	}

	//for constructor injection
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("constructor injection");
		this.customerRepository = customerRepository;
	}

	//for setter injection
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("setter injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
