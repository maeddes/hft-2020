package de.hftstuttgart.helloworldnew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReferencesController {

    private Logger logger = LoggerFactory.getLogger(ReferencesController.class);

    @GetMapping("/log_something")
    public ResponseEntity<String> logErrorMessageFromReferences() {
        logger.error("References error log message");
        return new ResponseEntity<>("Log Test", HttpStatus.OK);
    }
    
}
