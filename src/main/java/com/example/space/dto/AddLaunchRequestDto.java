package com.example.space.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddLaunchRequestDto {
    private String mission_name;
    private String launch_year;
    @JsonProperty("links")
    private Links links;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Links {
        private String reddit_campaign;
    }
}
