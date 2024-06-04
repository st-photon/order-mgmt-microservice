package com.photon.order.entity;

import com.photon.core.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "OrderStatus")
@Table(name = "order_status")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    private Order order;

    @Column(name = "sort_order", nullable = false)
    @Basic(optional = false)
    private int sortOrder;

    @Column(name = "is_active", nullable = false)
    @Basic(optional = false)
    private boolean isActive;

    @Column(name = "status", nullable = false)
    @Basic(optional = false)
    private OrderStatusEnum status;
}
