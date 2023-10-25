package com.adberilgen.weather.service;

import com.adberilgen.weather.dto.WeatherDto;
import com.adberilgen.weather.dto.WeatherResponse;
import com.adberilgen.weather.model.WeatherEntity;
import com.adberilgen.weather.repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String API_URL = "http://api.weatherstack.com/current?access_key=e36c2fd8b5a1a0919445d0a3f00576aa&query=";

    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate, RestTemplate restTemplate1) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherDto getWeatherByCityName(String city) {
        Optional<WeatherEntity> weatherEntityOptional = weatherRepository.findFirstByRequestedCityNameOrderByUpdatedTimeDesc(city);
        if (weatherEntityOptional.isPresent()) {
            return WeatherDto.convert(getWeatherFromWeatherStack(city));
        }
        return WeatherDto.convert(weatherEntityOptional.get());
    }

    public WeatherEntity getWeatherFromWeatherStack(String city) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(API_URL + city, String.class);

        try {
            WeatherResponse weatherResponse = objectMapper.readValue(responseEntity.getBody(), WeatherResponse.class);
            return saveWeatherEntity(city, weatherResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private WeatherEntity saveWeatherEntity(String city, WeatherResponse weatherResponse) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        WeatherEntity weatherEntity = new WeatherEntity(city,
                weatherResponse.location().name(),
                weatherResponse.location().country(),
                weatherResponse.current().tempature(),
                LocalDateTime.now(),
                LocalDateTime.parse(weatherResponse.location().localTime(), dateTimeFormatter)
        );
        return weatherRepository.save(weatherEntity);
    }
}