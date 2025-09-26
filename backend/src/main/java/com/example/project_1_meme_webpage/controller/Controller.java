package com.example.project_1_meme_webpage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public Controller() {
    }
    @GetMapping("/hello") 
    public String hello() {
        return "<h1>Hello World!</h1>";
    }
    @PostMapping("/tweet")
    public String sendTweet(@RequestParam String tweet, Model model) {
        //TODO: process POST request
        model.addAttribute("tweet", tweet);
        return """
               <html>\r
                   <head>\r
                       <link href="tweet.css" type="text/css" rel="stylesheet"/>\r
                       <title>Tweet Submitted!</title>\r
                   </head>\r
                   <body>\r
                       <h1>Your Tweet:</h1>\r
                       <p><span th:text="${tweet}"></span></p>\r
                   </body>\r
               </html>""";
    }
    
    /*
    @PostMapping
    public String changeString() {
        return "<h1>Changed string!</h1>";
    }
    @RequestMapping(value = "/account/username", method = RequestMethod.POST) 
    public ResponseEntity<?> createAccountHandler () */

}