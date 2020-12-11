package de.hftstuttgart.HelloWorldClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class HelloWorldClientApplication {

	@GetMapping("/")
    public String getStrings(){

		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8091/strings";
		ResponseEntity<String> response 
			= restTemplate.getForEntity(fooResourceUrl, String.class);
		return response.getBody().toString();

	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldClientApplication.class, args);
	}

}
