package de.hftstuttgart.helloworldnew;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldNewApplication {

	private Logger logger = LoggerFactory.getLogger(HelloWorldNewApplication.class);
	ArrayList<String> listOfStrings = new ArrayList<String>();

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/")
	public String sayHello(){

		return "Hello, Happy HfT Students!";
	}

	@RequestMapping("/test")
	public String sayHelloFromOtherEndpoint(){

		logger.info("sayHelloFromOtherEndpoint invoked");
		return "Hello, from the Request Endpoint!";
	}

	@GetMapping("/personalizedFromNowOn/{name}")
	public String sayPersonalized(@PathVariable String name){

		logger.info("sayHelloFromOtherEndpoint invoked with parameter {}",name);
		return "Hello, very dear "+name;
	}

	@GetMapping("/strings")
	public String getAllStrings(){

		return listOfStrings.toString();
	}

	@PutMapping("/strings/{newString}")
	public String addNewString(@PathVariable String newString){

		listOfStrings.add(newString);
		return newString+" added";
	}

	@PutMapping("/strings/{firstName}/{lastName}")
	public String addNewCustomer(@PathVariable String firstName, @PathVariable String lastName) {

		logger.info("Adding a new customer to the database with Name {} {}", firstName, lastName);
		Customer newCustomer = new Customer(firstName,lastName);
		customerRepository.save(newCustomer);
		logger.info("saved");
		
		return newCustomer + "added";

	}

	@GetMapping("/getAllCustomers")
	public String getAllCustomers() {

		List<String> customers = new ArrayList<String>();

		// for(Customer customer : repo.findAll()) customers.add(customer.toString());
		customerRepository.findAll().forEach(customer -> customers.add(customer.toString()));

		return customers.toString();
		
	}	

	@DeleteMapping("/strings/{stringToDelete}")
	public String deleteString(@PathVariable String stringToDelete){

		logger.debug("trying to delete {}",stringToDelete);
		logger.info("list prior to deletion {}", listOfStrings.toString());
		listOfStrings.remove(stringToDelete);
		logger.debug("list after deletion {}" , listOfStrings.toString());
		return stringToDelete+" probably deleted";
	}

 	public static void main(String[] args) {
		SpringApplication.run(HelloWorldNewApplication.class, args);
	}

}

