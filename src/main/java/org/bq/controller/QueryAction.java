/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.controller;

import org.bq.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author °×Ç¿
 * @version 1.0
 */
@Controller
public class QueryAction {
	@Autowired
	private UserDAO dao;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/query.do")
	public String query(ModelMap model) {
		model.addAttribute("users", dao.queryAll());
		return "result";
	}
}
