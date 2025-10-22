package com.test.warehouse.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_variants")
public class Variants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String size;
    private Double price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items items;
}
