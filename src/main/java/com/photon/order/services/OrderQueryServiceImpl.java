package com.photon.order.services;

import com.photon.order.entity.Order;
import com.photon.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class OrderQueryServiceImpl implements OrderQueryService{

    private final OrderRepository orderRepository;

    @Override
    public List<Order> fetchAllOrders(int userId) {
        return orderRepository.findOrders(userId);
    }

    @Override
    public Order fetchOrder(UUID orderId) {
        return orderRepository.findByOrderId(orderId);
    }
}
