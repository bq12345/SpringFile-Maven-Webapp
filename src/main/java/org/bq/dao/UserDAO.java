/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.dao;

import java.util.List;

import org.bq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class UserDAO {
	@Autowired
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void addUser(User user) {
		this.getMongoTemplate().insert(user);
	}

	public List<User> queryAll() {
		return this.getMongoTemplate().findAll(User.class);
	}

	public User getUser(String id) {
		return this.getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), User.class);
	}

	public void updateUser(String id, User u) {
		this.getMongoTemplate().updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("name", u.getName()).set("age", u.getAge()),
				User.class);
	}

	public void remove(String id) {
		this.getMongoTemplate().remove(new Query(Criteria.where("id").is(id)),
				User.class);
	}
}
