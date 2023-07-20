package com.example.space.service;

import com.example.space.dto.AddRocketRequestDto;
import com.example.space.entity.Rocket;
import com.example.space.mapper.RocketMapper;
import com.example.space.repository.RocketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RocketServiceImpl implements RocketService {
    private final RestTemplate restTemplate;
    private final RocketRepository rocketRepository;

    @Override
    public void saveRocket(AddRocketRequestDto rocketRequestDto) {
        String url = "https://api.spacexdata.com/v3/rockets";
        ResponseEntity<List<AddRocketRequestDto>> forEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AddRocketRequestDto>>() {
                }
        );
        List<AddRocketRequestDto> rocketRequestDtoList = forEntity.getBody();
        rocketRequestDtoList.stream().
                map(RocketMapper.INSTANCE::dtoToModelRocket).
                forEach(rocketRepository::save);
    }
}
