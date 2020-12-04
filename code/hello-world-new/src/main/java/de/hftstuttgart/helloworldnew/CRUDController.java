package de.hftstuttgart.helloworldnew;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDController {

    private Logger logger = LoggerFactory.getLogger(CRUDController.class);
	ArrayList<String> listOfStrings = new ArrayList<String>();

    @GetMapping("/strings")
	public String getAllStrings(){

        logger.info("returning {}",listOfStrings);
		return listOfStrings.toString();
	}

	@PutMapping("/strings/{newString}")
	public String addNewString(@PathVariable String newString){

        logger.info("adding {}",newString);
		listOfStrings.add(newString);
		return newString+" added";
    }
    
    @DeleteMapping("/strings/{stringToDelete}")
	public String deleteString(@PathVariable String stringToDelete){

		logger.debug("trying to delete {}",stringToDelete);
		logger.info("list prior to deletion {}", listOfStrings.toString());
		listOfStrings.remove(stringToDelete);
		logger.debug("list after deletion {}" , listOfStrings.toString());
		return stringToDelete+" probably deleted";
	}
    
}
