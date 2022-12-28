package com.rg.homeinventory.entities;


import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class Product {

    @Id
    private UUID productId;
    private String name;
    private String category;
    private Date expireDate;
    private String brandName;
}
