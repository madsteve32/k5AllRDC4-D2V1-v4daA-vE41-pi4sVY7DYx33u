package com.proectltd.gasstationsproject.repositories;

import com.proectltd.gasstationsproject.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {

    List<Station> findByName(String name);
}
