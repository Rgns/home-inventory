package com.rg.homeinventory.entities;



import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Item {

    @Id
    private UUID itemId;

    @NotNull(message = "itemDetails cannot be null")
    private Product itemDetails;
    private AdditionalDetails additionalDetails;
    @NotNull(message = "inventoryDetails cannot be null")
    private InventoryDetails inventoryDetails;
}
