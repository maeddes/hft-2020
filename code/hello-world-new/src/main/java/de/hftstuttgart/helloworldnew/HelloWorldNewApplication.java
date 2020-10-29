package de.hftstuttgart.helloworldnew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldNewApplication {

	@GetMapping("/")
	public String sayHello(){

		return "Hello, Happy HfT Students!";
	}

	@RequestMapping("/test")
	public String sayHelloFromOtherEndpoint(){

		return "Hello, from the Request Endpoint!";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldNewApplication.class, args);
	}

}
