package com.example.space.mapper;

import com.example.space.dto.AddRocketRequestDto;
import com.example.space.entity.Rocket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface RocketMapper {
    RocketMapper INSTANCE = Mappers.getMapper(RocketMapper.class);

    @Mapping(source = "rocket_id", target = "rocketName")
    Rocket dtoToModelRocket(AddRocketRequestDto rocketRequestDto);
}
