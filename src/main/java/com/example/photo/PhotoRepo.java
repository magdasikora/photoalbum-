package com.example.photo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface PhotoRepo extends JpaRepository<Photo, Long> {

}
