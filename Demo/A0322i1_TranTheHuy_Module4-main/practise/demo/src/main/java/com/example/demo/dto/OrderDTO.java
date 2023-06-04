package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.enums.EOrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Long id;

    private String email;

    private String phone;

    private String recipientName; // lee su bin

    private String street; // street

    private String district; // Son Tra

    private String city; // da nang

    private String countryName; // VN

    private String postalCode; //90002

    private String note; // allow null

    private EOrderStatus status = EOrderStatus.PENDING;

    private Long userId;

    private List<Product> cart;

    private Double total;

    private LocalDateTime createDate;
}
