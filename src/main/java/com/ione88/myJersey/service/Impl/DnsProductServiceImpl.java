package com.ione88.myJersey.service.Impl;

import com.ione88.myJersey.model.DnsProduct;
import com.ione88.myJersey.service.DnsProductService;
import org.apache.commons.dbutils.QueryRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DnsProductServiceImpl implements DnsProductService {
    private DataSource dataSource;

    @Inject
    public DnsProductServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DnsProduct createDnsProduct(DnsProduct dnsProduct){
        try {
            new QueryRunner(dataSource).update
                    ("INSERT INTO dns_product (code, name, price, description, parametrs_json, url) VALUES (?, ?, ?, ?, ?, ?)" +
                                    "ON DUPLICATE KEY UPDATE name = ?, price = ?, description = ?, parametrs_json = ?, url = ?",
                            dnsProduct.getCode(), dnsProduct.getName(), dnsProduct.getPrice(), dnsProduct.getDescription(), dnsProduct.getParametrsJson(), dnsProduct.getUrl(),
                                                  dnsProduct.getName(), dnsProduct.getPrice(), dnsProduct.getDescription(), dnsProduct.getParametrsJson(), dnsProduct.getUrl());
        } catch (SQLException sqle) {
            System.out.println("Ошибка добавления товара DNS в базу даных\n"+sqle);
        }
        return dnsProduct;
    }

}
