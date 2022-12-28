package com.rg.homeinventory.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @NotNull(message = "brandName category cannot be null")
    private String brandName;
}
