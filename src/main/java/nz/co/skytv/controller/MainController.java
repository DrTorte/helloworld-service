package nz.co.skytv.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> redirectToSwagger() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "swagger-ui.html");
        ResponseEntity<Object> response = new ResponseEntity<Object>(headers, HttpStatus.FOUND);
        return response;
    }
}
