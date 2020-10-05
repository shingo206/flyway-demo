package com.example.flywaydemo.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;

    @OneToMany(targetEntity = PurchaseOrderItem.class, orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_purchase_order_item"))
    private List<PurchaseOrderItem> purchaseOrderItemList = new ArrayList<>();
}
