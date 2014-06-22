/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import java.io.File;
import java.util.UUID;

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
public class AddAction {
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

	@RequestMapping(value = "/addUser.do")
	public String add(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "age", required = true) String age,
			HttpServletRequest request, ModelMap model) {
		System.out.println("¿ªÊ¼");
		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		String s = UUID.randomUUID().toString();
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
			User u = new User();
			u.setId(s);
			u.setAge(Integer.parseInt(age));
			u.setImage(s);
			u.setName(name);
			dao.addUser(u);
			gridFS.saveImage(targetFile, s);
			targetFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("users", dao.queryAll());
		return "redirect:/result.jsp";
	}
}
