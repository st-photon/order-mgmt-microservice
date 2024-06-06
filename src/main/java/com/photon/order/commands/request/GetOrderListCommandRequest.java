package com.photon.order.commands.request;

import com.photon.infrastructure.invoker.request.CommandRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOrderListCommandRequest extends CommandRequest {

    private int userId;
}
