package com.cognizant.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.cognizant.domain.Order;

@Repository
public class OrderDAO {
	public List<Order> buildorders() {
		return Stream.of(new Order(101, "Mobile", 50000, 1), new Order(102, "Book", 999, 2),
				new Order(278, "Book", 1466, 3), new Order(953, "Jeans", 4499, 1)).collect(Collectors.toList());
	}
}