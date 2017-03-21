package cn.scau.edu.ssm.movietalk.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.edu.ssm.movietalk.exception.MyException;
import cn.scau.edu.ssm.movietalk.po.MAdminExtend;
import cn.scau.edu.ssm.movietalk.po.MListExt;
import cn.scau.edu.ssm.movietalk.po.MListVO;
import cn.scau.edu.ssm.movietalk.po.MLongReviewExt;
import cn.scau.edu.ssm.movietalk.po.MLongReviewVO;
import cn.scau.edu.ssm.movietalk.po.MRealiseDairy;
import cn.scau.edu.ssm.movietalk.po.MReviewReplyVO;
import cn.scau.edu.ssm.movietalk.po.MShortReviewExt;
import cn.scau.edu.ssm.movietalk.po.MShortReviewVO;
import cn.scau.edu.ssm.movietalk.po.MTagExt;
import cn.scau.edu.ssm.movietalk.po.MTypeExt;
import cn.scau.edu.ssm.movietalk.po.MUser;
import cn.scau.edu.ssm.movietalk.po.MyResult;
import cn.scau.edu.ssm.movietalk.service.MAdminService;
import cn.scau.edu.ssm.movietalk.service.MListService;
import cn.scau.edu.ssm.movietalk.service.MLongReviewService;
import cn.scau.edu.ssm.movietalk.service.MRealiseDairyService;
import cn.scau.edu.ssm.movietalk.service.MReviewReplyService;
import cn.scau.edu.ssm.movietalk.service.MShortReviewService;
import cn.scau.edu.ssm.movietalk.service.MStoreService;
import cn.scau.edu.ssm.movietalk.service.MTagService;
import cn.scau.edu.ssm.movietalk.service.MTypeService;
import cn.scau.edu.ssm.movietalk.service.MUserService;
import cn.scau.edu.ssm.movietalk.tool.CommonTool;
import cn.scau.edu.ssm.movietalk.tool.IPTool;
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
	@Autowired
	private MUserService mUserService;
	@Autowired
	private CommonTool commonTool;
	@Autowired
	private IPTool iPTool;
	@Autowired
	private MRealiseDairyService mRealiseDairyService;
	@Autowired
	private MListService mListService;
	@Autowired
	private MStoreService mStoreService;
	@Autowired
	private MShortReviewService mShortReviewService;
	@Autowired
	private MLongReviewService mLongReviewService;
	@Autowired
	private MReviewReplyService mReviewReplyService;
	@Autowired
	private MTypeService mTypeService;
	@Autowired
	private MTagService mTagService;
	
	/**
	 * @summary: 后台界面重定向
	 */
	@RequestMapping(value="/manager",method={RequestMethod.GET,RequestMethod.POST})
	public String manager() throws Exception{
		return "admin";
	}
	
	/**
	 * 用户首页登录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/user",method={RequestMethod.GET,RequestMethod.POST})
	public String user() throws Exception{
		return "customer";
	}
	
	/**
	 * @summary: 用户首页跳转
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/index",method={RequestMethod.GET,RequestMethod.POST})
	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/index.jsp").forward(request, response);
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
			// 更新ip和登录时间  start 
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String logintime = sdf.format(date);
			String loginip = request.getRemoteAddr();
			MAdminExtend record = new MAdminExtend();
			record.setLoginIp(loginip);
			record.setLoginTime(logintime);
			record.setUname(mAdminExtend.getUname());
			mAdminService.updateAdminByName(record);
			// 更新ip和登录时间  end
			myResult.setResult(true);
			myResult.setMessage("校验成功");
		} else {
			myResult.setResult(false);
			myResult.setMessage("用户名或者密码错误");
		}
		return myResult;
	}
	
	@RequestMapping(value="/ulogin", method={RequestMethod.POST})
	public @ResponseBody MyResult ulogin(HttpServletRequest request, MUser user) throws Exception {
		MyResult result = new MyResult();
		// 检验是否存在该用户
		int uid = mUserService.selectUid(user);
		if(uid == -1) {
			result.setMessage("用户账号或密码错误");
			result.setResult(false);
			return result;
		} else {
		// 存在的话记录ip和ip来源
			HttpSession session = request.getSession();
			session.setAttribute("uid", uid);
			session.setAttribute("username", user.getUname());
			String ip = commonTool.getIpAddress(request);
			String logintime = commonTool.getCurrentTime();
			MUser u = new MUser();
			u.setId(uid);
			u.setLoginIp(ip);
			u.setLoginTime(logintime);
			mUserService.updateUid(u);
			try {
				String address = iPTool.getAddress("ip=" + ip, "utf-8");
				if(address != null && address.length() > 25) {
					String[] ipMessage = address.split("_+_");
					MRealiseDairy dairy = new MRealiseDairy();
					dairy.setIp(ip);
					dairy.setLogintime(logintime);
					dairy.setUid(uid);
					dairy.setCountry(ipMessage[0]);
					dairy.setArea(ipMessage[1]);
					dairy.setRegion(ipMessage[2]);
					dairy.setCity(ipMessage[3]);
					dairy.setCounty(ipMessage[4]);
					dairy.setIsp(ipMessage[5]);
					mRealiseDairyService.insertIsp(dairy);
				}
			} catch(Exception e) {
				System.out.println("查询ip失败 : " + e);
			}
		}
		result.setMessage("登录成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/error",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody MyResult error(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String requestType = request.getHeader("X-Requested-With");
		MyResult result = new MyResult();
	    if (requestType != null && requestType.equals("XMLHttpRequest")) {
	        result.setResult(false);
	        result.setMessage("服务器出错,请联系管理员");
	    } else {
	    	// request.getRequestDispatcher("/jsp/501_page.jsp").forward(request, response);
	    	throw new MyException("中转出错");
	    }
	    return result;
	}
	
	/**
	 * 获取首页的影片信息
	 * @param page
	 * @param size
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/query_all_film/{list_page}/{list_size}",method={RequestMethod.POST})
	public @ResponseBody MListVO query_all_film(@PathVariable("list_page") int page, @PathVariable("list_size") int size, HttpServletRequest request) throws Exception {
		String listName = request.getParameter("list_name");
		MListVO listVO = mAdminService.queryList(page, size, listName);
		return listVO;
	}
	
	@RequestMapping(value="/query_short_common/{list_page}/{list_size}",method={RequestMethod.POST})
	public @ResponseBody MShortReviewVO query_short_common(@PathVariable("list_page") int page, @PathVariable("list_size") int size, HttpServletRequest request) throws Exception {
		Integer mid = Integer.parseInt(request.getParameter("mid"));
		HttpSession session = request. getSession();
		Integer uid = (Integer)session.getAttribute("uid");
		MShortReviewVO shortReview = mShortReviewService.getShortReviwe(page, size, mid);
		if(uid != null) {
			String username = (String)session.getAttribute("username");
			List<MShortReviewExt> shortReviews = shortReview.getShrotReview();
			for(int i = 0; i < shortReviews.size(); i++) {
				String suppose = (String)session.getAttribute(username + "_+_" + shortReviews.get(i).getId());
				if(suppose == null) {
					shortReviews.get(i).setSuppose(false);
				} else {
					shortReviews.get(i).setSuppose(true);
				}
			}
		}
		return shortReview;
	}
	
	@RequestMapping(value="/query_long_common/{list_page}/{list_size}",method={RequestMethod.POST})
	public @ResponseBody MLongReviewVO query_long_common(@PathVariable("list_page") int page, @PathVariable("list_size") int size, HttpServletRequest request) throws Exception {
		Integer mid = Integer.parseInt(request.getParameter("mid"));
		MLongReviewVO longReview = mLongReviewService.getLongReview(page, size, mid);
		return longReview;
	}
	
	@RequestMapping(value="/all_long_reviews/{list_page}/{list_size}",method={RequestMethod.GET})
	public String all_long_reviews(Model model, @PathVariable("list_page") int page, @PathVariable("list_size") int size) throws Exception {
		MLongReviewVO longReview = mLongReviewService.getAllReviews(page, size);
		model.addAttribute("longReview", longReview);
		return "all_long_review";
	}
	
	@RequestMapping(value="/query_review_reply/{list_page}/{list_size}",method={RequestMethod.POST})
	public @ResponseBody MReviewReplyVO query_review_reply(@PathVariable("list_page") int page, @PathVariable("list_size") int size, HttpServletRequest request) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("lid"));
		MReviewReplyVO reply = mReviewReplyService.queryAllReply(page, size, id);
		return reply;
	}
	
	@RequestMapping(value="/uregist",method={RequestMethod.POST})
	public @ResponseBody MyResult uregist(HttpServletRequest request, MUser user) throws Exception {
		MyResult result = new MyResult();
		// 检验名称是否唯一
		int exist_name = mUserService.checkUser(user.getUname());
		if(exist_name > 0) {
			result.setMessage("该名称已经被注册过,请更换");
			result.setResult(false);
			return result;
		}
		String ip = commonTool.getIpAddress(request);
		String logintime = commonTool.getCurrentTime();
		user.setAddtime(logintime);
		user.setLoginIp(ip);
		user.setLoginTime(logintime);
		user.setRepnum(0);
		int uid = mUserService.insertUid(user);
		HttpSession session = request.getSession();
		session.setAttribute("uid", uid);
		session.setAttribute("username", user.getUname());
		try {
			String address = iPTool.getAddress("ip=" + ip, "utf-8");
			if(address != null && address.length() > 25) {
				String[] ipMessage = address.split("_+_");
				MRealiseDairy dairy = new MRealiseDairy();
				dairy.setIp(ip);
				dairy.setLogintime(logintime);
				dairy.setUid(uid);
				dairy.setCountry(ipMessage[0]);
				dairy.setArea(ipMessage[1]);
				dairy.setRegion(ipMessage[2]);
				dairy.setCity(ipMessage[3]);
				dairy.setCounty(ipMessage[4]);
				dairy.setIsp(ipMessage[5]);
				mRealiseDairyService.insertIsp(dairy);
			}
		} catch(Exception e) {
			System.out.println("查询ip失败 : " + e);
		}
		result.setMessage("注册成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/query_film_by_id/{id}",method={RequestMethod.GET})
	public String query_film_by_id(HttpServletRequest request, Model model, @PathVariable("id") int id) throws Exception {
		MListExt list = mListService.queryUserList(id);
		HttpSession session = request.getSession();
		Integer uid = (Integer)session.getAttribute("uid");
		if(uid == null || session.getAttribute("username") == null) {
			list.setIscollect(false);
		} else {
			list.setIscollect(mStoreService.isCollect(uid, list.getId()));
		}
		model.addAttribute("list", list);
		return "film_detail";
	}
	
	@RequestMapping(value="/query_long_review_by_id/{id}",method={RequestMethod.GET})
	public String query_long_review_by_id(HttpServletRequest request, Model model, @PathVariable("id") int id) throws Exception {
		MLongReviewExt longReview = mLongReviewService.getSingleLongReview(id);
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username != null) {
			String suppose = (String)session.getAttribute(username+"_+_suppose_+_"+id);
			String anti = (String)session.getAttribute(username+"_+_anti_+_"+id);
			if(suppose == null) {
				longReview.setApprove(false);
			} else {
				longReview.setApprove(true);
			}
			if(anti == null) {
				longReview.setAnti(false);
			} else {
				longReview.setAnti(true);
			}
		}
		model.addAttribute("longReview", longReview);
		return "review_detail";
	}
	
	@RequestMapping(value="/all_tag", method={RequestMethod.GET})
	public String all_tag(Model model) throws Exception {
		List<MTypeExt> types = mTypeService.queryAllType();
		List<MTagExt> tags = mTagService.queryAllTag();
		model.addAttribute("types", types);
		model.addAttribute("tags", tags);
		return "all_film_tag";
	}
	
	@RequestMapping(value="/all_film_by_tagid/{list_page}/{list_size}/{tagid}", method={RequestMethod.GET})
	public String all_film_by_tagid(@PathVariable("list_page") int page, @PathVariable("list_size") int size, Model model,@PathVariable("tagid") int id) throws Exception {
		MListVO listVO = mAdminService.queryListByTag(page, size, id);
		listVO.setTagid(id);
		model.addAttribute("list", listVO);
		return "all_film_by_tag";
	}
	
	@RequestMapping(value="/all_film_by_typeid/{list_page}/{list_size}/{typeid}", method={RequestMethod.GET})
	public String all_film_by_typeid(@PathVariable("list_page") int page, @PathVariable("list_size") int size, Model model,@PathVariable("typeid") int id) throws Exception {
		MListVO listVO = mAdminService.queryListByType(page, size, id);
		listVO.setTypeid(id);
		model.addAttribute("list", listVO);
		return "all_film_by_type";
	}
	
}
