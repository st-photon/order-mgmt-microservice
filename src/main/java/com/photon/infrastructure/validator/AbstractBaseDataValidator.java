package com.photon.infrastructure.validator;

import com.photon.infrastructure.exceptions.ApiDataValidationException;
import com.photon.infrastructure.exceptions.model.ApiDataError;
import com.photon.infrastructure.exceptions.model.BusinessDataError;

import java.util.List;

public abstract class AbstractBaseDataValidator {

    protected void throwApiDataValidationException(List<ApiDataError> apiDataErrorList) {
        if(apiDataErrorList != null && !apiDataErrorList.isEmpty()) {
            throw new ApiDataValidationException(apiDataErrorList);
        }
    }

    protected void throwBusinessDataValidationException(BusinessDataError businessDataError){

    }
}
