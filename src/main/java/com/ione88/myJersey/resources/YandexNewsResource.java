
package com.ione88.myJersey.resources;

import com.google.inject.Inject;
import com.ione88.myJersey.models.YandexNews;
import com.ione88.myJersey.services.YandexNewsService;

import javax.ws.rs.*;
import java.util.ArrayList;

@Path("/news")
public class YandexNewsResource {
    @Inject
    private YandexNewsService yandexNewsService;

    @PUT
    @Path("add")
    @Produces("application/json")
    @Consumes("application/json")
    public YandexNews createYandexNews(YandexNews yandexNews) {
        return yandexNewsService.createYandexNews(yandexNews);
    }

    // Добавить строку поиска и кнопку
    @GET
    @Path("/{type: [main,Zen,region]*}")
    @Produces("application/json")
    public ArrayList<YandexNews> showYandexNewsByType(@PathParam("type") String type) {
        return yandexNewsService.findYandexNewsByType(type);
    }
    @GET
    @Path("/{type}/{id}")
    @Produces("application/json")
    public ArrayList<YandexNews> showYandexNewsById(@PathParam("id") int id) {
        return yandexNewsService.findYandexNewsById(id);
    }
    @GET
    @Path("/")
    @Produces("application/json")
    public ArrayList<YandexNews> showYandexNewsAll() {
        return yandexNewsService.findYandexNews();
    }

    @GET
    @Path("/{type}")
    @Produces("application/json")
    public ArrayList<YandexNews> showYandexNewsByErrorType(@PathParam("type") String type) {
        return yandexNewsService.findYandexNews();
    }
}
