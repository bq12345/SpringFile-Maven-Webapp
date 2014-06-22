/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author °×Ç¿
 * @version 1.0
 */
@Document
public class User {
	@Id
	private String id;
	private String name;
	private int age;
	private String image;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User(String id, String name, int age, String image) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.image = image;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age
				+ ", image=" + image + "]";
	}

}
