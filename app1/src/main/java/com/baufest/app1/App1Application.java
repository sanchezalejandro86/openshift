package com.baufest.app1;

import com.baufest.app1.model.SimpleBean;
import com.baufest.app1.repository.SimpleBeanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class App1Application extends SpringBootServletInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private SimpleBeanRepository simpleBeanRepository;

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App1Application.class);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		this.simpleBeanRepository.save(new SimpleBean(1L,"Ale"));
		this.simpleBeanRepository.save(new SimpleBean(2L,"Juan"));
	}
}

