package com.photon.order.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlaceOrderRequest {

    private Double subTotal;

    private Long totalQty;

    private List<PlaceOrderItemRequest> items = new ArrayList<>();

    @Data
    public static class PlaceOrderItemRequest {

        private String brand;

        private Long qty;

        private String description;

        private String name;

        private double price;
    }
}
