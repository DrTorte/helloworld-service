package nz.co.skytv.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
    private MockMvc mockRoot;

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Before
    public void setup(){
        mockRoot = MockMvcBuilders.standaloneSetup(new MainController()).build();
    }

    @Test
    public void testHomePage() throws Exception {
        LOG.debug("Testing homepage is index.jsp");
        mockRoot.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
}
