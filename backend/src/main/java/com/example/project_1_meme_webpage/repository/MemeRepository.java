package com.example.project_1_meme_webpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_1_meme_webpage.entity.Meme;

public interface MemeRepository extends JpaRepository<Meme, Long>{
    
}
