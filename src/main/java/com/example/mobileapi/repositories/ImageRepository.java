package com.example.mobileapi.repositories;

import com.example.mobileapi.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
