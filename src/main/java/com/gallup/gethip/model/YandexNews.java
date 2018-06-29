package com.gallup.gethip.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@DatabaseTable(tableName="yandex_news")
public class YandexNews {

	@DatabaseField(generatedId = true, columnName = "id")
	private int id;

	@DatabaseField(columnName = "updated")
	private Date updated;

	@DatabaseField(columnName = "title")
	private String title;

	@DatabaseField(columnName = "url")
	private String url;

	@DatabaseField(columnName = "type")
	private String type;

	public YandexNews(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUpdate() {
		return updated;
	}

	public void setUpdate(Date update) {
		this.updated = updated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
