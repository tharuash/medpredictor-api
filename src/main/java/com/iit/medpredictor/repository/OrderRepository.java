package com.iit.medpredictor.repository;

import com.iit.medpredictor.entity.Order;
import com.iit.medpredictor.entity.projection.OrderDTO;
import com.iit.medpredictor.entity.type.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository< Order, Long >
{

	@Query( value = "select o.med_type as medicine, o.year as year, o.month as month, o.quantity as quantity, o.is_predicted as isPredicted, o.note as note" +
			" from orders o " +
			"where o.med_type = :#{#medicine?.ordinal()} " +
			"order by o.year desc, o.month desc fetch first 2 rows only",  nativeQuery = true )
	List< OrderDTO > findLatestOrders( @Param( "medicine" ) Medicine medicine );
}
