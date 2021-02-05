package net.codejava.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.grocery.dao.*;

@Configuration
@ComponentScan(basePackages="net.codejava")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

    @Bean
    public DataSource getDS() {
        DriverManagerDataSource data = new DriverManagerDataSource();
        data.setDriverClassName("com.mysql.jdbc.Driver");
        data.setUrl("jdbc:mysql://localhost:3306/123Grocery");
        data.setUsername("root");
        data.setPassword("hashamali641");
         
        return data;
    }
     
    @Bean
    public cust getcust() {
        return new customer(getDS());
    }
    
    @Bean
    public prod getprod() {
        return new product(getDS());
    }
    
    @Bean
    public ord getord() {
        return new order(getDS());
    }
}
