package com.example.project_1_meme_webpage.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.project_1_meme_webpage.dto.MemeDTO;
import com.example.project_1_meme_webpage.entity.Meme;
import com.example.project_1_meme_webpage.pojos.ImgflipApiResponsePOJO;
import com.example.project_1_meme_webpage.repository.MemeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemeService {
    @Autowired
    private MemeRepository memeRepo;

    final Random random = new Random();
    final RestTemplate restTemplate = new RestTemplate();

    public ImgflipApiResponsePOJO fetchFromImgflip() {
        String url = "https://api.imgflip.com/get_memes";
        return restTemplate.getForObject(url, ImgflipApiResponsePOJO.class);
    }

    public MemeDTO getRandomMeme() {
        ImgflipApiResponsePOJO response = fetchFromImgflip();
        if (response != null && response.isSuccess()) {
            List<ImgflipApiResponsePOJO.Meme> memes = response.getData().getMemes();
            ImgflipApiResponsePOJO.Meme meme = memes.get(random.nextInt(memes.size()));
            return new MemeDTO(meme.getUrl(), "Top: " + meme.getName(), "Bottom: LOL 😂");
        }

        return new MemeDTO(
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
