package com.ione88.myJersey.services.impl;

import com.ione88.myJersey.models.YandexNews;
import com.ione88.myJersey.services.YandexNewsService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class YandexNewsServiceImpl implements YandexNewsService {
    private DataSource dataSource;

    @Inject
    public YandexNewsServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public YandexNews createYandexNews(YandexNews yandexNews) {
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
    }

    ResultSetHandler<ArrayList<YandexNews>> news = new ResultSetHandler<ArrayList<YandexNews>>() {
        public ArrayList<YandexNews> handle(ResultSet rs) throws SQLException {
            ArrayList<YandexNews> results = new ArrayList<YandexNews>();
            while (rs.next()) {
                YandexNews yandex = new YandexNews();
                yandex.setId((Integer) rs.getObject(1));
                yandex.setCreated((Date) rs.getObject(2));
                yandex.setUpdated((Date) rs.getObject(3));
                yandex.setTitle((String) rs.getObject(4));
                yandex.setType((String) rs.getObject(5));
                yandex.setUrl((String) rs.getObject(6));
                results.add(yandex);
            }
            return results;
        }
    };

    @Override
    public ArrayList<YandexNews> findYandexNewsByType(String type) {
        ArrayList<YandexNews> yandexNews = new ArrayList<YandexNews>();
        try {
            yandexNews = new QueryRunner(dataSource).query
                    ("SELECT * FROM yandex_news WHERE type=?", news, type);
        } catch (Exception e) {
            System.out.println("Ошибка выбора новости из базы даных\n" + e);
        } finally {
            return filter(yandexNews);
        }
    }

    @Override
    public ArrayList<YandexNews> findYandexNews() {
        ArrayList<YandexNews> yandexNews = new ArrayList<YandexNews>();
        try {
            yandexNews = new QueryRunner(dataSource).query
                    ("SELECT * FROM yandex_news ", news);
        } catch (Exception e) {
            System.out.println("Ошибка выбора новости из базы даных\n" + e);
        } finally {
            return yandexNews;
        }
    }

    @Override
    public ArrayList<YandexNews> findYandexNewsById(int id) {
        ArrayList<YandexNews> yandexNews = new ArrayList<YandexNews>();
        try {
            yandexNews = new QueryRunner(dataSource).query
                    ("SELECT * FROM yandex_news WHERE id=?", news, id);
        } catch (Exception e) {
            System.out.println("Ошибка выбора новости из базы даных\n" + e);
        } finally {
            return filter(yandexNews);
        }
    }

    private ArrayList<YandexNews> filter(ArrayList<YandexNews> yandexNews) {
        return  (0 == yandexNews.size()) ? findYandexNews(): yandexNews;
    }
}
