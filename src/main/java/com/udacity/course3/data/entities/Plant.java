package com.udacity.course3.data.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.course3.data.dto.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long Id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @Column(name = "price", precision = 12, scale = 4)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
