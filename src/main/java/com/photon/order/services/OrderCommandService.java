package com.photon.order.services;

import com.photon.core.Response;
import com.photon.order.request.PlaceOrderRequest;

public interface OrderCommandService {

    Response placeOrder(PlaceOrderRequest placeOrderRequest);
}
