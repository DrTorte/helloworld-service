package nz.co.skytv.controller;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainControllerTest {

    @MockBean
    private RemoteService remoteService;

    @Autowired
    private Reverser reverser;

    @Test
    public void exampleTest() {
        // RemoteService has been injected into the reverser bean
        given(this.remoteService.someCall()).willReturn("mock");
        String reverse = reverser.reverseSomeCall();
        assertThat(reverse).isEqualTo("kcom");
    }

    /*
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
        //String body = this.restTemplate.getForObject("/", String.class);
        //assertThat(body).isEqualTo("Hello World");
    }
    */
}
