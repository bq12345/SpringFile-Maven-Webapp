/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import javax.servlet.http.HttpServletRequest;

import org.bq.dao.UserDAO;
import org.bq.model.User;
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
public class GetAction {
	@Autowired
	private UserDAO dao;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/getUser.do")
	public String get(@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, ModelMap model) {
		User u = dao.getUser(id);
		model.addAttribute("user", u);
		return "update";
	}
}
