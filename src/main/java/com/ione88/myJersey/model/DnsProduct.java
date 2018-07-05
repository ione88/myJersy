package com.ione88.myJersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DnsProduct {

    private int id;
    private int code;
    private int price;
    private String url;
    private String description;
    private String name;
    private String parametrsJson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParametrsJson() {
        return parametrsJson;
    }

    public void setParametrsJson(String parametrsJson) {
        this.parametrsJson = parametrsJson;
    }

}
