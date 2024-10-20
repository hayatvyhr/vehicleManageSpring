package com.example.cars.Repository;

import com.example.cars.Entity.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<vehicle, Integer> {
}
