package com.example.demo.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private String name;

    private Double price;

    private Double weight;

    private String description;

    private String imageName;

    private Long categoryId;
}
