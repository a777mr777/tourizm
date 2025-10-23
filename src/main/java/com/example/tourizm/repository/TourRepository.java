package com.example.tourizm.repository;

import com.example.tourizm.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {}