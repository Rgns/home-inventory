package com.rg.homeinventory.entities;

import lombok.*;

@AllArgsConstructor
@Data
@Setter
@Getter
@NoArgsConstructor
public class AdditionalDetails {
    private String description;
    private String comments;
    private String review;
    private int rating;
}
