package nz.co.skytv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration  // application.properties is used by default, if it exists
//@PropertySource(value = "classpath:build.properties")
@PropertySources({
        @PropertySource(value = "file:helloworld-service.properties"),
        @PropertySource(value = "classpath:build.properties")
})
public class Properties {
    @Value("${info.app.name}")
    private String name;

    @Value("${info.app.version}")
    private String version;

    @Value("${info.app.description}")
    private String description;

    @Value("${info.env}") // possible usages: local,dev, sit, pl, prod
    private String env;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public String getEnv() {return env;}
}
