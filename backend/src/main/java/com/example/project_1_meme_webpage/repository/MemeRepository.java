package com.example.project_1_meme_webpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project_1_meme_webpage.entity.Meme;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long>{
    
}
