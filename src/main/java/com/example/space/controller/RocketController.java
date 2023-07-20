package com.example.space.controller;

import com.example.space.dto.AddRocketRequestDto;
import com.example.space.service.RocketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rockets")
public class RocketController {
    private final RocketService rocketService;

    @GetMapping
    public void saveRocket(AddRocketRequestDto rocketRequestDto) {
        rocketService.saveRocket(rocketRequestDto);
    }
}
