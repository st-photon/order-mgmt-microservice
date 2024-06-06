package com.photon.order.api;

import com.photon.core.Response;
import com.photon.order.entity.Order;
import com.photon.order.request.PlaceOrderRequest;
import com.photon.order.services.OrderCommandService;
import com.photon.order.services.OrderQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public List<Order> fetchOrders(@RequestParam int userId) {
        return this.orderQueryService.fetchAllOrders(userId);
    }

    @GetMapping("/{orderId}")
    public Order fetchOrderById(@PathVariable UUID orderId) {
        return this.orderQueryService.fetchOrder(orderId);
    }
}
