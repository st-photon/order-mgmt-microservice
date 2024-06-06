package com.photon.order.commands;

import com.photon.infrastructure.invoker.Command;
import com.photon.infrastructure.invoker.annotation.CommandRequestType;
import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;
import com.photon.order.commands.request.GetOrderDetailCommandRequest;
import com.photon.order.entity.Order;
import com.photon.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("GetOrderDetailCommand")
@Slf4j
@RequiredArgsConstructor
@CommandRequestType("com.photon.order.commands.request.GetOrderDetailCommandRequest")
public class GetOrderDetailCommand implements Command {

    private final OrderRepository orderRepository;

    @Override
    public CommandResult execute(CommandRequest commandRequest) {
        GetOrderDetailCommandRequest getOrderDetailCommandRequest = (GetOrderDetailCommandRequest) commandRequest;
        Order order = this.orderRepository.findByOrderId(getOrderDetailCommandRequest.getOrderId());
        return getCommandResult(order);
    }
}
