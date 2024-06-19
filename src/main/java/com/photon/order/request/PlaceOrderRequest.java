package com.photon.order.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PlaceOrderRequest {

    private Double subTotal;

    private Long totalQty;

    private List<PlaceOrderItemRequest> items = new ArrayList<>();

    private CustomerRequest customerRequest;

    private int userId;

    @Data
    public static class PlaceOrderItemRequest {

        private UUID productId;

        private Long qty;
    }

    @Data
    public static class CustomerRequest {

        private String firstName;

        private String middleName;

        private String lastName;

        private String address1;

        private String address2;

        private String address3;

        private String contactNumber;

        private String mobileNumber;

        private String zipCode;

        private String district;

        private String state;

        private String additionalComment;

        private String addressType;
    }
}
