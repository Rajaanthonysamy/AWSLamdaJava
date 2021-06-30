package com.cognizant;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cognizant.repository.OrderDAO;
import com.cognizant.domain.Order;
@SpringBootApplication
public class AwslamdaApplication {

	@Autowired
	public OrderDAO ordersdao;
	
	@Bean
public Supplier<List<Order>> orders()
{
	return () ->ordersdao.buildorders();
}
	@Bean
public Function<String, List<Order>> findbyordername()
{
	return (input) ->ordersdao.buildorders().stream().filter(order -> order.getName().equals(input)).collect(Collectors.toList());
}
	public static void main(String[] args) {
		SpringApplication.run(AwslamdaApplication.class, args);
	}
	

}
