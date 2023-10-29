package com.adberilgen.weather.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {
    public static String API_URL;
    public static String API_KEY;
    public static String ACCESS_KEY_PARAM = "?access_key=";
    public static String QUERY_KEY_PARAM = "&query==";

    @Value("${weather-stack.api-url}")
    public static void setApiUrl(String apiUrl) {
        Constants.API_URL = apiUrl;
    }

    @Value("${weather-stack.api-key}")
    public static void setApiKey(String apiKey) {
        Constants.API_KEY = apiKey;
    }
}