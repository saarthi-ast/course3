package com.udacity.course3.data.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "delivery.findByName", query = "Select p from Delivery p where p.name=:name")
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Column(name = "address_full", length = 500)
    private String address;

    private LocalDateTime deliveryTime;

    @Type(type = "yes_no")
    @Column(columnDefinition = "boolean default false")
    private Boolean deliveryComplete;

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Plant> plants;
}
