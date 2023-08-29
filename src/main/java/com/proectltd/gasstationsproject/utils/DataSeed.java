package com.proectltd.gasstationsproject.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proectltd.gasstationsproject.models.Station;
import com.proectltd.gasstationsproject.services.impl.StationServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataSeed {
    @Bean
    CommandLineRunner runner(StationServiceImpl stationService) {
        return args -> {
            // Read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Station>> typeReference = new TypeReference<List<Station>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/gasstations.json");
            try {
                List<Station> stations = mapper.readValue(inputStream, typeReference)
                        .stream()
                        .filter(Station::getIsOpen)
                        .collect(Collectors.toList());

                stationService.save(stations);
                System.out.println("Stations saved!");
            } catch (IOException e) {
                System.out.println("Unable to save stations: " + e.getMessage());
            }
        };
    }
}
