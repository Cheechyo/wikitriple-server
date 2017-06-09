package edu.cheechyo.wikitriple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Cheechyo on 2017-06-08.
 */
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter{
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        super.configureViewResolvers(registry);
//        registry.jsp().prefix("/WEB-INF/views/");
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
