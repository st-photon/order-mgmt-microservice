package com.photon.order.api;

import com.photon.core.Response;
import com.photon.order.request.PlaceOrderRequest;
import com.photon.order.services.OrderCommandService;
import com.photon.order.services.OrderQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/orders")
@Tag(name = "OrderApiResource")
public class OrderApiResource {

    private final OrderQueryService orderQueryService;

    private final OrderCommandService orderCommandService;

    @PostMapping("/placeOrder")
    public Response placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
        return orderCommandService.placeOrder(placeOrderRequest);
    }
}
