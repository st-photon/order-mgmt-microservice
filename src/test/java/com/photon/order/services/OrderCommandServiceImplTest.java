package com.photon.order.services;

import com.photon.core.Response;
import com.photon.order.entity.Order;
import com.photon.order.entity.OrderItem;
import com.photon.order.helpers.OrderRequestHelper;
import com.photon.order.repository.OrderRepository;
import com.photon.order.validator.OrderApiDataValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderCommandServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderApiDataValidator orderApiDataValidator;

    @Mock
    private OrderRequestHelper orderRequestHelper;

    @InjectMocks
    private OrderCommandServiceImpl commandService;

    @Test
    @DisplayName("should place order")
    public void shouldPlaceOrder() {
        //arrange
        String orderId = "db69d6af-1343-486a-83d7-6a8c58377df6";
        Mockito.doNothing().when(orderApiDataValidator).validatePlaceOrderRequestData(Mockito.any());
        Order order = new Order();
        order.setId(UUID.fromString(orderId));
        //Mockito.doReturn(order).when(orderRequestHelper).newInstance(any());
        Mockito.when(orderRequestHelper.newInstance(any())).thenReturn(order);
        Mockito.when(orderRepository.saveAndFlush(any())).thenReturn(order);

        //act
        Response response = commandService.placeOrder(any());

        //assert
        verify(orderApiDataValidator, times(1)).validatePlaceOrderRequestData(any());
        verify(orderRequestHelper, times(1)).newInstance(any());
        Assertions.assertEquals(orderId, String.valueOf(response.getId()));
    }
}
