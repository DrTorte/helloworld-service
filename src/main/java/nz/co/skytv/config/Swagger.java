package nz.co.skytv.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Configures swagger documentation for the project.
 *
 * @author Amir Moharam
 */
@EnableSwagger2
@Configuration
@ComponentScan(basePackages = "nz.co.skytv")
public class Swagger {

    @Autowired
    private Properties properties;

    /**
     * initializes Springfox configuration for swagger specification 2.0.
     *
     * @return The {@link Docket} object
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(paths())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false);
    }

    /**
     *  API Info as it should appear on swagger-ui web page.
     *
     * @return The {@link ApiInfo} object
     */
    private ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title(properties.getName())
                .description(properties.getDescription())
                .license("version " + properties.getVersion())
                .licenseUrl("#");

        return builder.build();
    }

    /**
     * Defines what patterns should be included in the swagger documentations.
     *
     * @return The {@link Predicate} object
     */
    private Predicate<String> paths() {
        return or(regex("/v1.*"));
    }
}
