package nz.co.skytv.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nz.co.skytv.model.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "v1 Controller", description = "Controller that serves v1 endpoints", produces = "application/json")
public class v1Controller {
    private static final Logger LOG = LoggerFactory.getLogger(v1Controller.class);

    @ApiOperation(value = "Returns a hello message",notes = "Returns a hello message.")
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "The request was successful."),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Failed to retrieve data from database"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "The request could not be understood by the server"),
    })
    @RequestMapping(value = "/message",method = RequestMethod.GET)
    @ResponseBody
    public GenericResponse<String> message() {
        return new GenericResponse<String>().withData("hello world");
    }
}
