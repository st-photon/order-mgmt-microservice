package com.photon.customer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "Customer")
@Table(name = "customer")
@Getter
@Setter
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @Column(name = "order_number", nullable = false, unique = true)
    @Basic(optional = false)
    private String orderNumber;

    @Column(name = "first_name", nullable = false)
    @Basic(optional = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Basic(optional = false)
    private String lastName;

    @Column(name = "mobile_number", nullable = false)
    @Basic(optional = false)
    private String mobileNumber;

    @Embedded
    private CustomerShippingAddress customerShippingAddress;
}
