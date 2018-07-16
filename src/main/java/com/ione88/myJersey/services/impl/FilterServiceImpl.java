package com.ione88.myJersey.services.impl;

import com.google.gson.Gson;
import com.ione88.myJersey.services.FilterService;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import org.apache.commons.dbutils.QueryRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

public class FilterServiceImpl implements FilterService {
    private DataSource dataSource;

    @Inject
    public FilterServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ContainerRequest modifyRequest(ContainerRequest containerRequest) {
        try {
            new QueryRunner(dataSource).update
                    ("INSERT INTO logger (created, type, event) VALUES (CURRENT_TIMESTAMP(), ?, ?)",
                            "INFO",new Gson().toJson(containerRequest.getPath())+new Gson().toJson(containerRequest.getMethod()));
        } catch (SQLException sqle) {
            System.out.println("Ошибка добавления log в базу даных\n"+sqle);
        }
        return containerRequest;
    }

    @Override
    public ContainerResponse modifyResponse(ContainerResponse containerResponse) {
        return containerResponse;
    }
}
