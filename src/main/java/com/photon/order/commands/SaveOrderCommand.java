package com.photon.order.commands;

import com.photon.infrastructure.invoker.Command;
import com.photon.infrastructure.invoker.annotation.CommandRequestType;
import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;
import com.photon.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("SaveOrderCommand")
@Slf4j
@RequiredArgsConstructor
@CommandRequestType("com.photon.order.commands.request.SaveOrderCommandRequest")
public class SaveOrderCommand implements Command {

    private final OrderRepository orderRepository;

    @Override
    public CommandResult execute(CommandRequest commandRequest) {
        return null;
    }
}
