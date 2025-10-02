package com.example.project_1_meme_webpage.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.project_1_meme_webpage.entity.Meme;
import com.example.project_1_meme_webpage.repository.MemeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemeService {
    @Autowired
    private MemeRepository memeRepo;

    public Meme getRandomMeme() {
        final Random random = new Random();
        final RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.imgflip.com/get_memes";
        
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null && (boolean) response.get("success")) {
            Map<String, Object> data = (Map<String, Object>) response.get("data");
            List<Map<String, Object>> memes = (List<Map<String, Object>>) data.get("memes");

            Map<String, Object> memeData = memes.get(random.nextInt(memes.size()));

            String imageUrl = (String) memeData.get("url");
            String name = (String) memeData.get("name");

            String topText = "Top: " + name;
            String bottomText = "Bottom: LOL 😂";

            return new Meme(imageUrl, topText, bottomText);
        }

        return new Meme(
            "https://via.placeholder.com/400x300.png?text=No+Meme",
            "Couldn’t fetch from Imgflip",
            "Try again later!"
        );
    }

    public List<Meme> getAllMemes() {
        return memeRepo.findAll();
    }

    public Meme postMeme(Meme meme) {
        return memeRepo.save(meme);
    }
}
