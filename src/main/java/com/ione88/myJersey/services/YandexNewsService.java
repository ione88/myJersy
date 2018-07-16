package com.ione88.myJersey.services;

import com.ione88.myJersey.models.YandexNews;

import java.util.ArrayList;

public interface YandexNewsService {
    YandexNews createYandexNews(YandexNews yandexNews);
    ArrayList<YandexNews> findYandexNewsByType(String type);
    ArrayList<YandexNews> findYandexNewsById(int Id);
    ArrayList<YandexNews> findYandexNews();
}
