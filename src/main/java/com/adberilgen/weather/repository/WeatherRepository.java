package com.adberilgen.weather.repository;

import com.adberilgen.weather.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntity, String> {
}