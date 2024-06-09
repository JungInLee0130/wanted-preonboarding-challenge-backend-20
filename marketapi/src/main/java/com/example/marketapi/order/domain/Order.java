package com.example.marketapi.order.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 주문번호

    @Column(name = "seller_name")
    private String sellerName; // 판매자이름

    @Column(name = "purchaser_name")
    private String purchaserName; // 구매자
    
    @Column(name = "product_id")
    private Long productId; // 제품번호

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    private Order(String sellerName, String purchaserName, Long productId) {
        this.sellerName = sellerName;
        this.purchaserName = purchaserName;
        this.productId = productId;
    }
}
