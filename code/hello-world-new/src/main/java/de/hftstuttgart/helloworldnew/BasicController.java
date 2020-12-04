package de.hftstuttgart.helloworldnew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	private Logger logger = LoggerFactory.getLogger(BasicController.class);	

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
    
}
