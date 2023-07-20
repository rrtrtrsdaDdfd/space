package com.example.space.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .requestFactory(this::getRequestFactory)
                .build();
    }

    private HttpComponentsClientHttpRequestFactory getRequestFactory() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        // Устанавливаем таймауты
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        return requestFactory;
    }

    // Метод для обработки ошибок при проверке HTTPS статуса
    private boolean isHttpsUrlReachable(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            // Если статус 200 (OK), значит HTTPS работает
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false; // Ошибка, HTTPS недоступен
        }
    }
}

