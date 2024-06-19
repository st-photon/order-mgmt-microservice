package com.photon.consumers.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "product-service")
public interface ProductConsumer {

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable UUID id);
}
