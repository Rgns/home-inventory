package com.rg.homeinventory.entities;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String category;
    private Date expireDate;
    private String brandName;
}
