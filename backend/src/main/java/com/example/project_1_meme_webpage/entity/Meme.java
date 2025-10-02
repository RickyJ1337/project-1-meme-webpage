package com.example.project_1_meme_webpage.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Meme {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String topText;
    private String bottomText;

    public Meme() {}

    public Meme(String url, String topText, String bottomText) {
        this.url = url;
        this.topText = topText;
        this.bottomText = bottomText;
    }

    public Long getId() { return id; }
    public String getImageUrl() { return url; }
    public void setImageUrl(String url) { this.url = url; }
    public String getTopText() { return topText; }
    public void setTopText(String topText) { this.topText = topText; }
    public String getBottomText() { return bottomText; }
    public void setBottomText(String bottomText) { this.bottomText = bottomText; }
}
