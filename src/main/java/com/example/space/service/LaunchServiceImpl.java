package com.example.space.service;

import com.example.space.dto.AddLaunchRequestDto;
import com.example.space.dto.AddRocketRequestDto;
import com.example.space.mapper.LaunchMapper;
import com.example.space.mapper.RocketMapper;
import com.example.space.repository.LaunchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LaunchServiceImpl implements LaunchService {
    private final RestTemplate restTemplate;
    private final LaunchRepository launchRepository;

    @Override
    public void saveLaunch(AddLaunchRequestDto launchRequestDto, String model) {
        String url = "https://api.spacexdata.com/v3/launches?rocket_id=" + model;
        ResponseEntity<List<AddLaunchRequestDto>> forEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AddLaunchRequestDto>>() {
                }
        );
        List<AddLaunchRequestDto> launchRequestDtoList = forEntity.getBody();
        launchRequestDtoList.stream().
                map(LaunchMapper.INSTANCE::dtoToModelLaunch).
                forEach(launchRepository::save);
    }
}
