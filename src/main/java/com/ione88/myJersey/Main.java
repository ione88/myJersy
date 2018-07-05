
package com.ione88.myJersey;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ione88.myJersey.db.DataSourceModule;
import com.ione88.myJersey.db.DataSourceMySQL;
import com.ione88.myJersey.resources.YandexNewsResource;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.sql.DataSource;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;


public class Main {

    private static int getPort(int defaultPort) {
        //grab port from environment, otherwise fall back to default port 9998
        String httpPort = System.getProperty("jersey.test.port");
        if (null != httpPort) {
            try {
                return Integer.parseInt(httpPort);
            } catch (NumberFormatException e) {
            }
        }
        return defaultPort;
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(getPort(8080)).build();
    }

    public static final URI BASE_URI = getBaseURI();

    protected static HttpServer startServer() throws IOException {

        Injector injectorSQL = Guice.createInjector(new DataSourceModule());
        DataSourceMySQL dataSourceMySQL = injectorSQL.getInstance(DataSourceMySQL.class);
        DataSource dataSource = dataSourceMySQL.getDataSource();

        System.out.println("Starting grizzly...");

        Injector injector = Guice.createInjector(new MyJerseyModule(dataSource));
        YandexNewsResource yandexNewsResource = injector.getInstance(YandexNewsResource.class);

        ResourceConfig resourceConfig = new PackagesResourceConfig("com.ione88.myJersey.resources");
        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(resourceConfig, injector);

        return GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig, ioc);
    }

    public static void main(String[] args) throws IOException {
        // Grizzly 2 initialization
        HttpServer httpServer = startServer();

        System.out.println("Jersey app started with \nHit enter to stop it...");

        System.in.read();
        httpServer.stop();
    }
}
