package com.udacity.course3.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Flower extends Plant {

    private String color;

}
