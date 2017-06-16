package nz.co.skytv.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import java.util.logging.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class v1ControllerTest {
    private static final Logger logger = Logger.getLogger(MainControllerTest.class.getName());

    private MockMvc mockMvc;

    @Spy
    private ObjectMapper objectMapper;

    @InjectMocks
    private v1Controller v1Controller = new v1Controller();

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up v1ControllerTest...");
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(v1Controller).build();
    }

    @Test
    public void testMessage() throws Exception {
        // prepare the test request
        MockHttpServletRequestBuilder mockRequest = get("/v1/message")
                .contentType(MediaType.APPLICATION_JSON)
                ;

        // invoke the mock service using the test request
        MvcResult response = this.mockMvc
                .perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        // verify the response body
        String responseBodyAsString = response.getResponse().getContentAsString();
        Assert.isTrue(!responseBodyAsString.isEmpty(), "Response body cannot be empty");
        logger.info("Response body: "+responseBodyAsString);

        JsonNode json = objectMapper.readTree(responseBodyAsString);
        Assert.isTrue(json.hasNonNull("data"), "Response body must have data");
    }
}
