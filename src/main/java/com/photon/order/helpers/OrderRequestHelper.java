package com.photon.order.helpers;

import com.photon.core.AddressType;
import com.photon.core.OrderStatusEnum;
import com.photon.customer.entity.Customer;
import com.photon.customer.entity.Address;
import com.photon.order.entity.Order;
import com.photon.order.entity.OrderItem;
import com.photon.order.entity.OrderStatus;
import com.photon.order.request.PlaceOrderRequest;
import com.photon.order.utils.OrderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderRequestHelper {

    public Order newInstance(PlaceOrderRequest placeOrderRequest) {
        final Order order = new Order();
        order.setStatuses(createDefaultOrderStatus());
        order.setOrderNumber(OrderUtils.generateOrderNumber());
        order.setItems(placeOrderRequest.getItems().stream().map(this::createOrderItem).toList());
        order.setCustomer(createCustomer(placeOrderRequest.getCustomerRequest()));
        return order;
    }

    private Customer createCustomer(PlaceOrderRequest.CustomerRequest customerRequest) {
        final Customer customer = new Customer();
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setMobileNumber(customerRequest.getMobileNumber());
        final Address address = new Address();
        address.setAddress1(customerRequest.getAddress1());
        address.setComment(customerRequest.getAdditionalComment());
        address.setContactNumber(customerRequest.getContactNumber());
        address.setAddress2(customerRequest.getAddress2());
        address.setAddress3(customerRequest.getAddress3());
        address.setZipCode(customerRequest.getZipCode());
        address.setDistrict(customerRequest.getDistrict());
        address.setState(customerRequest.getState());
        address.setAddressType(AddressType.getByName(customerRequest.getAddressType()));
        customer.setShippingAddress(address);
        return customer;
    }

    private OrderItem createOrderItem(PlaceOrderRequest.PlaceOrderItemRequest item) {
        final OrderItem orderItem = new OrderItem();
        orderItem.setBrand(item.getBrand());
        orderItem.setName(item.getName());
        orderItem.setDescription(item.getDescription());
        orderItem.setName(item.getName());
        return orderItem;
    }

    private List<OrderStatus> createDefaultOrderStatus(){
        final List<OrderStatus> orderStatuses = new ArrayList<>();
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setActive(true);
        orderStatus.setSortOrder(1);
        orderStatus.setStatus(OrderStatusEnum.PLANNING);
        orderStatuses.add(orderStatus);
        return orderStatuses;
    }
}
