import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.capgemini" })
public class AppConfig {

	// for setter injection
	

//	@Bean(name = "customerService") 
//	  public CustomerService getCustomerService() {
//	  CustomerServiceImpl service = new CustomerServiceImpl();
//	//  service.setCustomerRepository(getCustomerRepository());
//	  
//	  return service; 
	
//	  }
	  
	/*
	 * @Bean(name = "customerService") public CustomerService getCustomerService() {
	 * CustomerServiceImpl service = new
	 * CustomerServiceImpl(getCustomerRepository()); return service; }
	 */
	  
	  //No need when we use autowiring(here we used Repository also)
	/*
	 * @Bean(name = "customerRepository") public CustomerRepository
	 * getCustomerRepository() { return new HibernateCustomerRepositoryImpl(); }
	 */
}
