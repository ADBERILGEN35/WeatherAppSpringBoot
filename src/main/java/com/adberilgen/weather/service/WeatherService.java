package com.adberilgen.weather.service;

import com.adberilgen.weather.dto.WeatherDto;
import com.adberilgen.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherDto getWeatherByCityName(String city) {

        return null;
    }
}