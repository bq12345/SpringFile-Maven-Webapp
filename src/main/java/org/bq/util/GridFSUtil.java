/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class GridFSUtil {
	@Autowired
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	public void removeImage(String id) throws IOException {
		GridFS gfsPhoto = new GridFS(this.mongoTemplate.getDb(), "image");
		gfsPhoto.remove(id);
	}
	public void saveImage(File f, String id) throws IOException {
		GridFS gfsPhoto = new GridFS(this.mongoTemplate.getDb(), "image");
		GridFSInputFile gfsFile = gfsPhoto.createFile(f);
		gfsFile.setFilename(id);
		gfsFile.save();
	}

	public void loadImage(String id, OutputStream os) throws IOException {
		GridFS gfsPhoto = new GridFS(this.mongoTemplate.getDb(), "image");
		GridFSDBFile imageForOutput = gfsPhoto.findOne(id);
		imageForOutput.writeTo(os);
	}
}
