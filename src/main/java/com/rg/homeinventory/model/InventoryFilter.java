package com.rg.homeinventory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InventoryFilter {

   // private String name;
    //private String brandName;
    //private String itemCategory;
    private String inventoryStatus;
    private Date lastPurchased;
    //private Date expireDate;
}
