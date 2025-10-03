package com.example.project_1_meme_webpage.dto;

public class MemeDTO {
    private String url;
    private String topText;
    private String bottomText;

    public MemeDTO(String url, String topText, String bottomText) {
        this.url = url;
        this.topText = topText;
        this.bottomText = bottomText;
    }

    public String getUrl() {
        return url;
    }

    public String getTopText() {
        return topText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }
}
