package com.example.space.repository;

import com.example.space.entity.Launch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaunchRepository extends JpaRepository<Launch,Integer> {

}
