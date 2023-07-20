package com.example.space.mapper;

import com.example.space.dto.AddLaunchRequestDto;
import com.example.space.dto.AddRocketRequestDto;
import com.example.space.entity.Launch;
import com.example.space.entity.Rocket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LaunchMapper {

    LaunchMapper INSTANCE = Mappers.getMapper(LaunchMapper.class);

    @Mapping(source = "mission_name", target = "missionName")
    @Mapping(source = "launch_year", target = "launchYear")
    @Mapping(source = "links.reddit_campaign", target = "links")
    Launch dtoToModelLaunch(AddLaunchRequestDto launchRequestDto);
}
