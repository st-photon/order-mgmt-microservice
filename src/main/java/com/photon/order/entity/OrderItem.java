package com.photon.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "OrderItem")
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @Column(name = "p_name", nullable = false)
    @Basic(optional = false)
    private String name;

    @Column(name = "p_description", nullable = false)
    @Basic(optional = false)
    private String description;

    @Column(name = "p_brand", nullable = false)
    @Basic(optional = false)
    private String brand;

    @Column(name = "p_price", nullable = false)
    @Basic(optional = false)
    private double price;

}
