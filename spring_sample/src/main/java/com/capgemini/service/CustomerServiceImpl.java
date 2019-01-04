package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Customer;
import com.capgemini.repository.CustomerRepository;
import com.capgemini.repository.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();

	/* (non-Javadoc)
	 * @see com.sapgemini.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
