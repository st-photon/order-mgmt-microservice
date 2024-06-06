package com.photon.order.commands;

import com.photon.infrastructure.invoker.Command;
import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.annotation.CommandRequestType;
import com.photon.infrastructure.invoker.result.CommandResult;
import com.photon.order.commands.request.GetOrderListCommandRequest;
import com.photon.order.entity.Order;
import com.photon.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GetOrderListCommand")
@CommandRequestType("com.photon.order.commands.request.GetOrderListCommandRequest")
@Slf4j
@RequiredArgsConstructor
public class GetOrderListCommand implements Command {

    private final OrderRepository orderRepository;

    @Override
    public CommandResult execute(CommandRequest commandRequest) {
        GetOrderListCommandRequest getOrderListCommandRequest = (GetOrderListCommandRequest) commandRequest;
        final List<Order> orderList = orderRepository.findOrders(getOrderListCommandRequest.getUserId());
        return getCommandResult(orderList);
    }
}
