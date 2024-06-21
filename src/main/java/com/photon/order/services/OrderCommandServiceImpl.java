package com.photon.order.services;

import com.photon.consumers.product.ProductConsumer;
import com.photon.consumers.saga.SagaConsumer;
import com.photon.core.Response;
import com.photon.infrastructure.invoker.CommandInvoker;
import com.photon.infrastructure.services.BaseService;
import com.photon.order.entity.Order;
import com.photon.order.helpers.OrderRequestHelper;
import com.photon.order.repository.OrderRepository;
import com.photon.order.request.PlaceOrderRequest;
import com.photon.order.validator.OrderApiDataValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

// https://medium.com/@kiarash.shamaii/getting-started-with-apache-camel-using-springboot-86a42b1adc1d

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCommandServiceImpl extends BaseService implements OrderCommandService {

    private final OrderRepository orderRepository;

    private final OrderRequestHelper orderRequestHelper;

    private final OrderApiDataValidator orderApiDataValidator;

    private final SagaConsumer sagaConsumer;

    @Transactional
    @Override
    public Response placeOrder(PlaceOrderRequest placeOrderRequest) {
        ResponseEntity<String> responseEntity = sagaConsumer.startOrderFlow();
        return Response.of(UUID.randomUUID());
        //this.orderApiDataValidator.validatePlaceOrderRequestData(placeOrderRequest);
        //final Order order = orderRequestHelper.newInstance(placeOrderRequest);
        //final Order dbOrder = this.orderRepository.saveAndFlush(order);
        //return Response.of(dbOrder.getId());
    }
}
