package com.photon.order.validator;

import com.photon.infrastructure.validator.AbstractBaseDataValidator;
import com.photon.infrastructure.exceptions.model.ApiDataError;
import com.photon.order.entity.Order;
import com.photon.order.request.PlaceOrderRequest;
import com.photon.order.services.OrderQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderApiDataValidator extends AbstractBaseDataValidator {

    //private final OrderQueryService orderQueryService;

    public void validatePlaceOrderRequestData(PlaceOrderRequest placeOrderRequest) {
        //Order order1 = orderQueryService.fetchOrder(UUID.randomUUID());
        final List<ApiDataError> errors = new ArrayList<>();
        if(placeOrderRequest.getSubTotal() == null) {
            ApiDataError apiDataError = ApiDataError.of();
            apiDataError.setFieldName("subTotal");
            apiDataError.setFieldErrorMessage("subTotal field must not be empty");
            errors.add(apiDataError);
        }
        if(placeOrderRequest.getTotalQty() == null) {
            ApiDataError apiDataError = ApiDataError.of();
            apiDataError.setFieldName("totalQty");
            apiDataError.setFieldErrorMessage("totalQty field must not be empty");
            errors.add(apiDataError);
        }
        throwApiDataValidationException(errors);
    }
}
