package com.rg.homeinventory.entities;

import com.rg.homeinventory.enums.InventoryStatus;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class InventoryDetails {

    private Date lastPurchased;
    private InventoryStatus inventoryStatus;
    private Quantity quantity;
}
