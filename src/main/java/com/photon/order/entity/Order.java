package com.photon.order.entity;

import com.photon.core.TxnStatus;
import com.photon.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity(name = "Order")
@Table(name = "b_order")
@Getter
@Setter
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderItem> items = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderStatus> statuses = new ArrayList<>();

    @Column(name = "order_number", nullable = false, unique = true)
    @Basic(optional = false)
    private String orderNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "sub_total", nullable = false)
    @Basic(optional = false)
    private Double subTotal;

    @Column(name = "grand_total", nullable = false)
    @Basic(optional = false)
    private Double grandTotal;

    @Column(name = "total_qty", nullable = false)
    @Basic(optional = false)
    private Long totalQty;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDate createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(name = "order_placed_by", nullable = false)
    @Basic(optional = false)
    private int orderPlacedBy;

    @Column(name = "order_placed_at", nullable = false)
    @Basic(optional = false)
    private LocalDateTime orderPlacedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "saga_txn_status", nullable = false)
    @Basic(optional = false)
    private TxnStatus txnStatus;
}
