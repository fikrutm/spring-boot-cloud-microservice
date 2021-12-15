package com.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.demo.user.entity.User;
import com.demo.user.response.UserType;
import com.demo.user.srevice.UserService;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication  implements CommandLineRunner {

	
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		
		userService.saveUser( new User("Smith", "Row" ,UserType.INDIVIDUAL));
		userService.saveUser( new User("Frank", "Hoey" ,UserType.INDIVIDUAL));
		userService.saveUser( new User("Craig", "Ferndeninand" ,UserType.INDIVIDUAL));
		userService.saveUser( new User("Rando", "Fargo" ,UserType.INDIVIDUAL));
		
	}
	
	
	  
}
