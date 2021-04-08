package com.iit.medpredictor.repository;

import com.iit.medpredictor.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository< Order, Long >
{
	List<Order> findLast100ByOrderByYearAscAndMonthAsc();
}
