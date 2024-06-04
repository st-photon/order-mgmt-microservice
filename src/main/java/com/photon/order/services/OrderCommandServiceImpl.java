package com.photon.order.services;

import com.photon.core.OrderStatusEnum;
import com.photon.core.Response;
import com.photon.customer.entity.Customer;
import com.photon.customer.entity.CustomerShippingAddress;
import com.photon.order.entity.Order;
import com.photon.order.entity.OrderItem;
import com.photon.order.entity.OrderStatus;
import com.photon.order.helpers.OrderRequestHelper;
import com.photon.order.repository.OrderRepository;
import com.photon.order.request.PlaceOrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;

    private final OrderRequestHelper orderRequestHelper;

    @Transactional
    @Override
    public Response placeOrder(PlaceOrderRequest placeOrderRequest) {
        final Order order = orderRequestHelper.newInstance(placeOrderRequest);
        final Order dbOrder = this.orderRepository.saveAndFlush(order);
        return Response.of(dbOrder.getId());
    }
}
