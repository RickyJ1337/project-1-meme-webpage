package com.example.project_1_meme_webpage.pojos;

import java.util.List;

public class ImgflipApiResponsePOJO {
    private boolean success;
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class Data {
        private List<Meme> memes;

        public List<Meme> getMemes() {
            return memes;
        }

        public void setMemes(List<Meme> memes) {
            this.memes = memes;
        }
    }

    public static class Meme {
        private String id;
        private String name;
        private String url;
        private int width;
        private int height;
        private int box_count;
        
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public int getWidth() {
            return width;
        }
        public void setWidth(int width) {
            this.width = width;
        }
        public int getHeight() {
            return height;
        }
        public void setHeight(int height) {
            this.height = height;
        }
        public int getBox_count() {
            return box_count;
        }
        public void setBox_count(int box_count) {
            this.box_count = box_count;
        }

    }
}
