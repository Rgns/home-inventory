package com.rg.homeinventory.entities;

import com.rg.homeinventory.enums.InventoryStatus;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class InventoryDetails {

    @Id
    private UUID productId;
    private Date lastPurchased;
    private InventoryStatus inventoryStatus;
    private Quantity quantity;
}
