package com.rg.homeinventory.dto;

import com.rg.homeinventory.entities.Category;
import lombok.*;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategory {

    @NotNull(message = "old category cannot be null")
    Category oldCategory;

    @NotNull(message = "new category cannot be null")
    Category newCategory;
}
