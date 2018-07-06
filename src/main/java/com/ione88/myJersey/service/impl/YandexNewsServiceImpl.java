package com.ione88.myJersey.service.impl;

import com.ione88.myJersey.model.YandexNews;
import com.ione88.myJersey.service.YandexNewsService;
import org.apache.commons.dbutils.QueryRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

public class YandexNewsServiceImpl implements YandexNewsService {
    private DataSource dataSource;

    @Inject
    public YandexNewsServiceImpl( DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public YandexNews createYandexNews(YandexNews yandexNews){
        try {
            new QueryRunner(dataSource).update
                    ("INSERT INTO yandex_news (`created`, `updated`, title, url, type) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), ?, ?, ?)" +
                                    "ON DUPLICATE KEY UPDATE `updated` = CURRENT_TIMESTAMP(), url = ?",
                            yandexNews.getTitle(), yandexNews.getUrl(), yandexNews.getType(),
                            yandexNews.getUrl());
        } catch (SQLException sqle) {
            System.out.println("Ошибка добавления новости в базу даных\n" + sqle);
        }
        return yandexNews;
    };

}
