package com.photon.order.validator;

import com.photon.infrastructure.AbstractBaseDataValidator;
import com.photon.infrastructure.exceptions.ApiDataValidationException;
import com.photon.infrastructure.exceptions.model.ApiDataError;
import com.photon.order.request.PlaceOrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderApiDataValidator extends AbstractBaseDataValidator {

    public void validatePlaceOrderRequestData(PlaceOrderRequest placeOrderRequest) {
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
