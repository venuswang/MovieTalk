package cn.scau.edu.ssm.movietalk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.edu.ssm.movietalk.po.MAdminExtend;
import cn.scau.edu.ssm.movietalk.po.MyResult;
import cn.scau.edu.ssm.movietalk.service.MAdminService;
import cn.scau.edu.ssm.movietalk.validator.ValidGroup1;

/**
 * 通用接口的controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/common")
public class CommonController {
	@Autowired
	private MAdminService mAdminService; 
	
	/**
	 * @summary: 后台界面重定向
	 */
	@RequestMapping(value="/manager",method={RequestMethod.GET,RequestMethod.POST})
	public String manager() throws Exception{
		return "admin";
	}
	
	/**
	 * @summary: 传入后台的用户名和密码，查询用户是否存在
	 * @param mAdminExtend
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mlogin",method={RequestMethod.POST})
	public @ResponseBody MyResult mlogin(HttpServletRequest request, @Validated(value={ValidGroup1.class}) MAdminExtend mAdminExtend, BindingResult result) throws Exception{
		MyResult myResult = new MyResult();
		if(result.hasErrors())
		{
			List<ObjectError> errors = result.getAllErrors();
			StringBuffer errorInfos = new StringBuffer();
			for(ObjectError error : errors)
			{
				errorInfos.append(error.getDefaultMessage()).append(',');
			}
			myResult.setResult(false);
			myResult.setMessage(errorInfos.toString());
			return myResult;
		}
		boolean isAdmin = mAdminService.checkMadmin(mAdminExtend);
		if(isAdmin) {
			HttpSession session = request.getSession();
			session.setAttribute("madmin", "true");
			session.setAttribute("username", mAdminExtend.getUname());
			myResult.setResult(true);
			myResult.setMessage("校验成功");
		} else {
			myResult.setResult(false);
			myResult.setMessage("用户名或者密码错误");
		}
		return myResult;
	}
}
