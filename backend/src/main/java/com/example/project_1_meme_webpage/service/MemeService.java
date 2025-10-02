package com.example.project_1_meme_webpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.project_1_meme_webpage.entity.Meme;
import com.example.project_1_meme_webpage.repository.MemeRepository;

public class MemeService {
    @Autowired
    private MemeRepository memeRepo;

    public List<Meme> getAllMemes() {
        return memeRepo.findAll();
    }

    public Meme postMeme(Meme meme) {
        return memeRepo.save(meme);
    }
}
