package com.masachi.model;

import java.util.ArrayList;

/**
 * Created by masachi on 2017/7/13.
 */
public class News {
    private String code;
    private String message;
    private ArrayList<NewsItem> news;

    public News(){
        news = new ArrayList<NewsItem>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<NewsItem> getNews() {
        return news;
    }

    public void setNews(ArrayList<NewsItem> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "News{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", news=" + news +
                '}';
    }

    class NewsItem{
        private String date;
        private String title;
        private String url;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "NewsItem{" +
                    "date='" + date + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
