package com.rg.homeinventory.model;

import com.rg.homeinventory.enums.BrandName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemFilter {

    private String name;
    private BrandName brandName;
    private String itemCategory;
}
