package com.rg.homeinventory.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;


@Setter
@Getter@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @NotNull(message = "item category cannot be null")
    private String itemCategory;
}
