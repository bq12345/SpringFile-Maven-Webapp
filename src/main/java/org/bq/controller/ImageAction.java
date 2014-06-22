/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bq.util.GridFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author °×Ç¿
 * @version 1.0
 */
@Controller
public class ImageAction {
	@Autowired
	private GridFSUtil gridFS;

	public GridFSUtil getGridFS() {
		return gridFS;
	}

	public void setGridFS(GridFSUtil gridFS) {
		this.gridFS = gridFS;
	}

	@RequestMapping(value = "/getImage.do")
	public void image(@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, HttpServletResponse res, ModelMap model)
			throws IOException {
		OutputStream stream = res.getOutputStream();
		gridFS.loadImage(id, stream);
		stream.flush();
		stream.close();
	}
}
