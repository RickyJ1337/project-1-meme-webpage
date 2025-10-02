package com.example.project_1_meme_webpage.controller;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_1_meme_webpage.entity.Meme;
import com.example.project_1_meme_webpage.service.AccountService;
import com.example.project_1_meme_webpage.service.MemeService;

@RestController
@RequestMapping("/api/memes")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private MemeService memeService;
    
    @Autowired
    private AccountService accountService;

    @GetMapping("/random")
    public Meme getRandomMeme(@RequestParam String param) {
        List<Meme> currentMemeList = memeService.getAllMemes();
        if (currentMemeList.isEmpty()) {
            return new Meme(
                "https://via.placeholder.com/400x300.png?text=No+Memes",
                "Database is empty!",
                "Please add some memes 🤷"
            );
        }
        Random random = new Random();
        Meme randomMeme = currentMemeList.get(random.nextInt(currentMemeList.size()));
        return randomMeme;
    }
    
    @PostMapping
    public Meme postMeme(@RequestBody Meme meme) {
        Meme postedMeme = memeService.postMeme(meme);
        return postedMeme;
    }

}