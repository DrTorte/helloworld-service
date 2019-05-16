package nz.co.skytv.controller;

import io.swagger.annotations.*;
import nz.co.skytv.client.FunctionClient;
import nz.co.skytv.model.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "v1 Controller", description = "Controller that serves v1 endpoints", produces = "application/json")
public class v1Controller {
    private static final Logger logger = LoggerFactory.getLogger(v1Controller.class);

    @Autowired
    private FunctionClient functionClient;

    @Value("${test.variable:helloworld-service}")
    private String appname;

    @ApiOperation(value = "Returns a hello message",notes = "Returns a hello message.")
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "The request was successful."),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Failed to retrieve data from database"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "The request could not be understood by the server"),
    })
    @RequestMapping(value = "/message",method = RequestMethod.GET)
    @ResponseBody
    public GenericResponse<String> message() {
        return new GenericResponse<String>().withData("this is the "+appname+" app!!");
    }

    @ApiOperation(value = "Turns the input into upper case",notes = "Calls helloworld-function for this.")
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "The request was successful."),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Failed to retrieve data from database"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "The request could not be understood by the server"),
    })
    @RequestMapping(value = "/upper",method = RequestMethod.GET)
    @ResponseBody
    public GenericResponse<String> toUpperCase(
            @ApiParam(value = "Input",defaultValue = "hello", required = true) @RequestParam(value = "input") String input){
        return new GenericResponse<String>().withData(functionClient.toUpperCase(input));
    }
}
