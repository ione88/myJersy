package com.ione88.myJersey.service.Impl;

import com.ione88.myJersey.model.DnsProductAvailable;
import com.ione88.myJersey.service.DnsProductAvailableService;
import org.apache.commons.dbutils.QueryRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DnsProductAvailableServiceImpl implements DnsProductAvailableService {
    private DataSource dataSource;

    @Inject
    public DnsProductAvailableServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DnsProductAvailable createDnsProductAvailable(DnsProductAvailable dnsProductAvailable) {
        try {
            new QueryRunner(dataSource).update
                    ("INSERT INTO dns_product_available (`created`, `updated`, code, city, shop, count, waiting_days) VALUES (CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),?, ?, ?, ?, ? )" +
                                    "ON DUPLICATE KEY UPDATE `updated`=CURRENT_TIMESTAMP(), count=?, waiting_days=?",
                            dnsProductAvailable.getCode(), dnsProductAvailable.getCity(), dnsProductAvailable.getShop(), dnsProductAvailable.getCount(), dnsProductAvailable.getWaitingDays(),
                            dnsProductAvailable.getCount(), dnsProductAvailable.getWaitingDays());
        } catch (SQLException sqle) {
            System.out.println("Ошибка добавления товара DNS в базу даных\n"+sqle);
        }
        return dnsProductAvailable;
    }

}
