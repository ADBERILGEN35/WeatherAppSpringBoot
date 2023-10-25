package com.adberilgen.weather.repository;

import com.adberilgen.weather.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, String> {

    //Son kaydın ne zaman atıldığını bulmak için kullanılan sorgu
    Optional<WeatherEntity> findFirstByRequestCityNameOrderByUpdatedTimeDesc(String city);
}