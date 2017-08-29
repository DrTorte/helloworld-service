package nz.co.skytv.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.logging.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    private static final Logger logger = Logger.getLogger(MainControllerTest.class.getName());

    private MockMvc mockMvc;

    @InjectMocks
    private MainController mainController;

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up MainControllerTest...");
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testRedirectToSwagger() throws Exception {
        logger.info("Testing testRedirectToSwagger()...");
        this.mockMvc.perform(get("/")).andExpect(redirectedUrl("swagger-ui.html"));
    }
}
