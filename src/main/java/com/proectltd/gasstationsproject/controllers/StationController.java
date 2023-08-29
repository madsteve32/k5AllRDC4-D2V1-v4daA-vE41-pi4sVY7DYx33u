package com.proectltd.gasstationsproject.controllers;

import com.proectltd.gasstationsproject.models.Station;
import com.proectltd.gasstationsproject.services.impl.StationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stations")
@AllArgsConstructor
public class StationController {


    private final StationServiceImpl stationService;

    @GetMapping("/list")
    public Iterable<Station> list() {
        return stationService.list();
    }

    @GetMapping("/listByName/{name}")
    public List<Station> findStationsByName(@PathVariable String name) {
        return stationService.findByName(name);
    }

    @GetMapping("/median/{fuelType}")
    public FuelPriceDTO getMedianFuelPrice(@PathVariable String fuelType) {
        return stationService.getFuelPriceStatistics(fuelType);
    }
}
