/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.bq.dao.UserDAO;
import org.bq.model.User;
import org.bq.util.GridFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author °×Ç¿
 * @version 1.0
 */
@Controller
public class UpdateAction {
	@Autowired
	private UserDAO dao;
	@Autowired
	private GridFSUtil gridFS;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public GridFSUtil getGridFS() {
		return gridFS;
	}

	public void setGridFS(GridFSUtil gridFS) {
		this.gridFS = gridFS;
	}

	@RequestMapping(value = "/updateUser.do")
	public String update(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "age", required = true) String age,
			HttpServletRequest request, ModelMap model) {
		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
			User u = dao.getUser(id);
			u.setAge(Integer.parseInt(age));
			u.setImage(u.getImage());
			u.setName(name);
			dao.updateUser(id, u);
			gridFS.removeImage(id);
			gridFS.saveImage(targetFile, u.getImage());
			targetFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("users", dao.queryAll());
		return "redirect:/result.jsp";
	}
}
