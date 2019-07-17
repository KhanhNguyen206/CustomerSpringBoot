package com.khanhnn.customer;

import com.khanhnn.customer.model.Province;
import com.khanhnn.customer.service.CustomerService;
import com.khanhnn.customer.service.ProvinceService;
import com.khanhnn.customer.service.impl.CustomerServiceImpl;
import com.khanhnn.customer.service.impl.ProvinceServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	public CustomerService customerService(){
		return  new CustomerServiceImpl();
	}

	@Bean
	public ProvinceService provinceService(){
		return new ProvinceServiceImpl();
	}

}
