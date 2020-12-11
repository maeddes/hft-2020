package de.hftstuttgart.helloworldnew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class BasicController {

	private Logger logger = LoggerFactory.getLogger(BasicController.class);	

	@Value("${message:has_not_been_set}")
	private String message;

	@GetMapping("/")
	public String sayHello(){

		return "Hello, Happy HfT Students!";
	}

	@GetMapping("/message")
	public String getMessage(){

		return this.message;
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
