package com.photon.order.repository;

import com.photon.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o FROM Order o WHERE o.orderPlacedBy = :userId")
    List<Order> findOrders(@Param("userId") int userId);

    @Query("SELECT o FROM Order o WHERE o.id = :orderId")
    Order findByOrderId(@Param("orderId") UUID orderId);
}
