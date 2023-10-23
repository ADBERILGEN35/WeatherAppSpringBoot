package com.adberilgen.weather.dto;

public record WeatherDto(
        String cityName,
        String country,
        Integer temperature
) {
}