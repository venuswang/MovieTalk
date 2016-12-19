package cn.scau.edu.ssm.movietalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 管理员后台的controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/admin")
public class ManagerController {
	
	@RequestMapping(value="/admin_index",method={RequestMethod.POST, RequestMethod.GET})
	public String adminIndex() throws Exception {
		return "admin_index";
	}
}
