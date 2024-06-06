package com.photon.order.services;

import com.photon.infrastructure.invoker.result.CommandResult;
import com.photon.infrastructure.services.BaseService;
import com.photon.order.commands.request.GetOrderListCommandRequest;
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
public class OrderQueryServiceImpl extends BaseService implements OrderQueryService{

    private final OrderRepository orderRepository;

    @Override
    public List<Order> fetchAllOrders(int userId) {
        GetOrderListCommandRequest getOrderListCommandRequest = new GetOrderListCommandRequest();
        getOrderListCommandRequest.setUserId(userId);
        CommandResult commandResult = getCommandInvoker().invokeCommand(getOrderListCommandRequest);
        return (List<Order>) commandResult.getResponse();
    }

    @Override
    public Order fetchOrder(UUID orderId) {
        return orderRepository.findByOrderId(orderId);
    }
}
