package com.hello;

import com.config.SwaggerConfig;
import com.security.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by User on 4/12/17.
 */
@SpringBootApplication
@Import({ SwaggerConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter();
    }

}
