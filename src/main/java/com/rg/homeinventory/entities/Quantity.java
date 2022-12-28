package com.rg.homeinventory.entities;

import com.rg.homeinventory.enums.QuantityUnit;
import lombok.*;

@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class Quantity {
    private int value;
    private QuantityUnit unit;
}
