package nz.co.skytv.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FunctionClientImpl implements FunctionClient{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String toUpperCase(String input){
        return restTemplate.getForObject("put address of the function here", String.class);
    }
}
