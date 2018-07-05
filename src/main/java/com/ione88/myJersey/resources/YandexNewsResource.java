
package com.ione88.myJersey.resources;

import com.google.inject.Inject;
import com.ione88.myJersey.model.YandexNews;
import com.ione88.myJersey.service.YandexNewsService;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

}
