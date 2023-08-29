package com.proectltd.gasstationsproject.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuelPriceDTO {
    private double minPrice;
    private double maxPrice;
    private double medianPrice;
}
