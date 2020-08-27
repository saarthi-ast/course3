package com.udacity.course3.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantDTO {
    private String name;
    private BigDecimal price;
}
