package com.proectltd.gasstationsproject.services.impl;

import com.proectltd.gasstationsproject.controllers.FuelPriceDTO;
import com.proectltd.gasstationsproject.models.Station;
import com.proectltd.gasstationsproject.repositories.StationRepository;
import com.proectltd.gasstationsproject.services.StationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Iterable<Station> list() {
        return stationRepository.findAll();
    }

    @Transactional
    public Iterable<Station> save(List<Station> stations) {
        return stationRepository.saveAll(stations);
    }

    @Transactional
    public List<Station> findByName(String name) {
        List<Station> stations = stationRepository.findByName(name);

        if (stations.isEmpty()) {
            throw new RuntimeException("No gas stations found with this name.");
        }

        return stations;
    }

    public FuelPriceDTO getFuelPriceStatistics(String fuelType) {
        List<Double> pricesForFuelType = stationRepository.findAll()
                .stream()
                .map(station -> getPriceForFuelType(station, fuelType))
                .collect(Collectors.toList());

        if (pricesForFuelType.isEmpty()) {
            throw new RuntimeException("No prices found for the specified fuel type.");
        }

        double minPrice = pricesForFuelType.stream()
                .filter(Objects::nonNull)
                .min(Double::compareTo).orElse(0.0);
        double maxPrice = pricesForFuelType.stream()
                .filter(Objects::nonNull)
                .max(Double::compareTo).orElse(0.0);

        double medianPrice;
        int size = pricesForFuelType.size();

        if (size % 2 == 0) {
            medianPrice = (pricesForFuelType.get(size / 2 - 1) + pricesForFuelType.get(size / 2) / 2.0);
        } else {
            medianPrice = pricesForFuelType.get(size / 2);
        }

        return new FuelPriceDTO(minPrice, maxPrice, medianPrice);
    }

    private Double getPriceForFuelType(Station station, String fuelType) {
        switch (fuelType.toLowerCase()) {
            case "diesel":
                return station.getDiesel();
            case "e5":
                return station.getE5();
            case "e10":
                return station.getE10();
            default:
                throw new IllegalArgumentException("Invalid fuel type: " + fuelType);
        }
    }
}
