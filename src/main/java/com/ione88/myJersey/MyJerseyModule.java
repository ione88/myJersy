package com.ione88.myJersey;

import com.google.inject.AbstractModule;
import com.ione88.myJersey.service.DnsProductAvailableService;
import com.ione88.myJersey.service.DnsProductService;
import com.ione88.myJersey.service.Impl.DnsProductAvailableServiceImpl;
import com.ione88.myJersey.service.Impl.DnsProductServiceImpl;
import com.ione88.myJersey.service.Impl.YandexNewsServiceImpl;
import com.ione88.myJersey.service.YandexNewsService;

import javax.sql.DataSource;

public class MyJerseyModule extends AbstractModule {
    DataSource dataSource;
    MyJerseyModule(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    protected void configure() {
        bind(YandexNewsService.class).to(YandexNewsServiceImpl.class);
        bind(DnsProductService.class).to(DnsProductServiceImpl.class);
        bind(DnsProductAvailableService.class).to(DnsProductAvailableServiceImpl.class);

        bind(DataSource.class).toInstance(dataSource);

    }
}
