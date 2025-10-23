package com.example.tourizm.repository;

import com.example.tourizm.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {}