package com.photon.order.services;

import com.photon.order.entity.Order;

import java.util.List;
import java.util.UUID;

public interface OrderQueryService {

    List<Order> fetchAllOrders(int userId);

    Order fetchOrder(UUID orderId);
}
