package com.example.space.service;

import com.example.space.dto.AddLaunchRequestDto;
import com.example.space.dto.AddRocketRequestDto;

public interface LaunchService {
    void saveLaunch(AddLaunchRequestDto launchRequestDto, String model);

}
