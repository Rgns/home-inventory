package com.rg.homeinventory.dto;

import com.rg.homeinventory.entities.Brand;
import com.rg.homeinventory.entities.Category;
import lombok.*;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrand {

    @NotNull(message = "old brand name cannot be null")
    String oldBrandName;

    @NotNull(message = "new brand name cannot be null")
    String newBrandName;
}
