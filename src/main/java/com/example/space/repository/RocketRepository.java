package com.example.space.repository;

import com.example.space.entity.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RocketRepository  extends JpaRepository<Rocket,Integer> {

}
