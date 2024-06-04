package com.photon.order.services;

import com.photon.core.OrderStatusEnum;
import com.photon.core.Response;
import com.photon.order.entity.Order;
import com.photon.order.entity.OrderItem;
import com.photon.order.entity.OrderStatus;
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

    @Transactional
    @Override
    public Response placeOrder(PlaceOrderRequest placeOrderRequest) {
        final Order order = newInstance(placeOrderRequest);
        final Order dbOrder = this.orderRepository.saveAndFlush(order);
        return Response.of(dbOrder.getId());
    }

    private Order newInstance(PlaceOrderRequest placeOrderRequest) {
        final Order order = new Order();
        order.setStatuses(createDefaultOrderStatus());
        order.setItems(placeOrderRequest.getItems().stream().map(this::createOrderItem).toList());
        return order;
    }

    private OrderItem createOrderItem(PlaceOrderRequest.PlaceOrderItemRequest item) {
        final OrderItem orderItem = new OrderItem();
        orderItem.setBrand(item.getBrand());
        orderItem.setName(item.getName());
        orderItem.setDescription(item.getDescription());
        orderItem.setName(item.getName());
        return orderItem;
    }

    private List<OrderStatus> createDefaultOrderStatus(){
        final List<OrderStatus> orderStatuses = new ArrayList<>();
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setActive(true);
        orderStatus.setSortOrder(1);
        orderStatus.setStatus(OrderStatusEnum.PLANNING);
        orderStatuses.add(orderStatus);
        return orderStatuses;
    }
}
