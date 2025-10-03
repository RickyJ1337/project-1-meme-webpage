package com.example.project_1_meme_webpage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_1_meme_webpage.dto.MemeDTO;
import com.example.project_1_meme_webpage.entity.Account;
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
    public MemeDTO getRandomMeme() {
        MemeDTO randomMeme = memeService.getRandomMeme();
        return randomMeme;
    }
    
    @PostMapping("/account/register")
    public Account registerAccount(@RequestBody Account account) {
        Account registeredAccount = accountService.registerAccount(account);
        return registeredAccount;
    }

    @PostMapping("/account/login")
    public Account postMethodName(@RequestBody Account account) {
        //TODO: process POST request
        Account loggedInAccount = accountService.loginAccount(account);
        return loggedInAccount;
    }
    
    

    @PostMapping
    public Meme postMeme(@RequestBody Meme meme) {
        Meme postedMeme = memeService.postMeme(meme);
        return postedMeme;
    }

}