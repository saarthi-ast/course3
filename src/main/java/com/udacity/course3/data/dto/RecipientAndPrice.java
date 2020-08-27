package com.udacity.course3.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientAndPrice {
    private String name;
    private BigDecimal price;
}
