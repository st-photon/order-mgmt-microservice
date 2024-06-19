package com.photon.consumers.product;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductDTO {

    private UUID id;

    private String name;

    private Double price;

    private String imageURL;

    private String description;

    private String brand;
}
