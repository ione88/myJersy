package com.ione88.myJersey.configs;

import com.google.inject.AbstractModule;
import com.ione88.myJersey.services.DnsProductAvailableService;
import com.ione88.myJersey.services.DnsProductService;
import com.ione88.myJersey.services.FilterService;
import com.ione88.myJersey.services.impl.DnsProductAvailableServiceImpl;
import com.ione88.myJersey.services.impl.DnsProductServiceImpl;
import com.ione88.myJersey.services.impl.FilterServiceImpl;
import com.ione88.myJersey.services.impl.YandexNewsServiceImpl;
import com.ione88.myJersey.services.YandexNewsService;

import javax.sql.DataSource;

public class MyJerseyModule extends AbstractModule {
    DataSource dataSource;
    public MyJerseyModule(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    protected void configure() {
        bind(YandexNewsService.class).to(YandexNewsServiceImpl.class);
        bind(DnsProductService.class).to(DnsProductServiceImpl.class);
        bind(DnsProductAvailableService.class).to(DnsProductAvailableServiceImpl.class);
        bind(FilterService.class).to(FilterServiceImpl.class);

        bind(DataSource.class).toInstance(dataSource);

    }
}
