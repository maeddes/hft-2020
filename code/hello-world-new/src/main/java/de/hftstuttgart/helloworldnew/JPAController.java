package de.hftstuttgart.helloworldnew;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JPAController {

    private Logger logger = LoggerFactory.getLogger(JPAController.class);

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public String getAllCustomers() {

		List<String> customers = new ArrayList<String>();

		// for(Customer customer : repo.findAll()) customers.add(customer.toString());
		customerRepository.findAll().forEach(customer -> customers.add(customer.toString()));

		return customers.toString();
		
	}	

	@PutMapping("/customer/{firstName}/{lastName}")
	public String addNewCustomer(@PathVariable String firstName, @PathVariable String lastName) {

		logger.info("Adding a new customer to the database with Name {} {}", firstName, lastName);
		Customer newCustomer = new Customer(firstName,lastName);
		customerRepository.save(newCustomer);
		logger.info("saved");
		
		return newCustomer + "added";

	}

    
}
