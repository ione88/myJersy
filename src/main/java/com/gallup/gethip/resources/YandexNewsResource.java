
package com.gallup.gethip.resources;

import com.gallup.gethip.DataSourceManager;
import com.gallup.gethip.model.Employee;
import com.gallup.gethip.model.YandexNews;
import com.j256.ormlite.dao.Dao;

import javax.ws.rs.*;
import java.sql.SQLException;

// The Java class will be hosted at the URI path "/employee"
@Path("/news")
public class YandexNewsResource {

    // TODO: update the class to suit your needs
    
    // The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "application/json"
    @Produces("application/json")
    	public YandexNews getIt(@QueryParam("id") String id) {
		YandexNews news = null;
    	try {
			news = getDao().queryForId(id);
			if(news == null){
				// throw error message
				return news;
			}else{
				return news;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw error message
		}
    	return news;
        
    }

    private Dao<YandexNews, String> getDao(){
    	Dao<YandexNews, String> dao = DataSourceManager.getInstance().getDao(YandexNews.class);
    	return dao;
    }
}
