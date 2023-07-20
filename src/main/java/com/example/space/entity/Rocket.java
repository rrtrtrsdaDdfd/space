package com.example.space.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rocket")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Rocket {
    @Id
    @Column(name = "rocket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rocketId;
    @Column(name = "rocket_name")
    private String rocketName;
}
