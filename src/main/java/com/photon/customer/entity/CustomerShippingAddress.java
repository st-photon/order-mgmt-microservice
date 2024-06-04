package com.photon.customer.entity;

import com.photon.core.AddressType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CustomerShippingAddress {

    @Column(name = "address_1", nullable = false)
    @Basic(optional = false)
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "address_3")
    private String address3;

    @Column(name = "pin_code", nullable = false)
    @Basic(optional = false)
    private String pinCode;

    @Column(name = "district", nullable = false)
    @Basic(optional = false)
    private String district;

    @Column(name = "state", nullable = false)
    @Basic(optional = false)
    private String state;

    @Column(name = "contact_number", nullable = false)
    @Basic(optional = false)
    private String contactNumber;

    @Column(name = "additional_comment")
    private String comment;

    @Column(name = "address_type", nullable = false)
    @Basic(optional = false)
    private AddressType addressType;
}
