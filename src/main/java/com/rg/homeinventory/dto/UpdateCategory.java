package com.rg.homeinventory.dto;

import lombok.*;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategory {

    @NotNull(message = "old category cannot be null")
    String oldCategory;

    @NotNull(message = "new category cannot be null")
    String newCategory;
}
