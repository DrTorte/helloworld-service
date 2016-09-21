package nz.co.skytv.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @ApiOperation(value = "Returns the homepage",notes = "returns the home page when the root context is requested.")
    @RequestMapping(method = RequestMethod.GET)
    public String homePage(){
        return "index";
    }
}
