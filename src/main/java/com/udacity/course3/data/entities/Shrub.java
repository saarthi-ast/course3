package com.udacity.course3.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
public class Shrub extends Plant{
    private long width;
    private long height;
}
