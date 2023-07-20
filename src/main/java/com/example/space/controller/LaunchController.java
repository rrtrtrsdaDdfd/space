package com.example.space.controller;

import com.example.space.dto.AddLaunchRequestDto;
import com.example.space.service.LaunchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/launchs")
public class LaunchController {
    private final LaunchService launchService;

    @GetMapping("/{model}")
    public void saveLaunch(AddLaunchRequestDto launchRequestDto, @PathVariable String model) {
        launchService.saveLaunch(launchRequestDto, model);
    }
}
