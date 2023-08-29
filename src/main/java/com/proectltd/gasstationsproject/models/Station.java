package com.proectltd.gasstationsproject.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "street")
    private String street;

    @Column(name = "place")
    private String place;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    @Column(name = "dist")
    private Double dist;

    @Column(name = "diesel")
    private Double diesel;

    @Column(name = "e5")
    private Double e5;

    @Column(name = "e10")
    private Double e10;

    @Column(name = "is_open")
    private Boolean isOpen;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "post_code")
    private String postCode;
}
