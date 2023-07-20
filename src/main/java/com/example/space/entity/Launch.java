package com.example.space.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "launches")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Launch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "launch_id")
    private int launchId;
    @Column(name = "mission_name")
    private String missionName;
    @Column(name = "launch_year")
    private String launchYear;
    @Column(name = "links")
    private String links;
}
