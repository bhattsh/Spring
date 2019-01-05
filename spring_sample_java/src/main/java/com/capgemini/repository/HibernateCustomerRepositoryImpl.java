package com.capgemini.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.model.Customer;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see com.capgemini.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll()
	{
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		
		customer.setFirstName("shubham");
		customer.setLastName("bhatt");
		
		customers.add(customer);
		
		return customers;
	}
}
