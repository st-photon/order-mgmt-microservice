package com.photon.order.commands.request;

import com.photon.infrastructure.invoker.request.CommandRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetOrderDetailCommandRequest extends CommandRequest {

    private UUID orderId;
}
