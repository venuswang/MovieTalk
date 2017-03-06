package cn.scau.edu.ssm.movietalk.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.scau.edu.ssm.movietalk.po.MActorExt;
import cn.scau.edu.ssm.movietalk.po.MActorVO;
import cn.scau.edu.ssm.movietalk.po.MAdmin;
import cn.scau.edu.ssm.movietalk.po.MAdminExtend;
import cn.scau.edu.ssm.movietalk.po.MFilmpic;
import cn.scau.edu.ssm.movietalk.po.MListExt;
import cn.scau.edu.ssm.movietalk.po.MListVO;
import cn.scau.edu.ssm.movietalk.po.MMactor;
import cn.scau.edu.ssm.movietalk.po.MMtag;
import cn.scau.edu.ssm.movietalk.po.MMtype;
import cn.scau.edu.ssm.movietalk.po.MPicactor;
import cn.scau.edu.ssm.movietalk.po.MTag;
import cn.scau.edu.ssm.movietalk.po.MType;
import cn.scau.edu.ssm.movietalk.po.MyResult;
import cn.scau.edu.ssm.movietalk.po.PasswordExt;
import cn.scau.edu.ssm.movietalk.po.TagVO;
import cn.scau.edu.ssm.movietalk.po.TypeVO;
import cn.scau.edu.ssm.movietalk.service.MAdminService;
import cn.scau.edu.ssm.movietalk.service.MFriendLinkService;
import cn.scau.edu.ssm.movietalk.service.MListService;
import cn.scau.edu.ssm.movietalk.service.MRealiseDairyService;
import cn.scau.edu.ssm.movietalk.service.MUserService;
import cn.scau.edu.ssm.movietalk.service.NoticeService;
import cn.scau.edu.ssm.movietalk.tool.CommonTool;
import cn.scau.edu.ssm.movietalk.validator.ValidGroup2;
import cn.scau.edu.ssm.movietalk.validator.ValidGroup3;
import cn.scau.edu.ssm.movietalk.validator.ValidGroup4;
import cn.scau.edu.ssm.movietalk.validator.ValidGroup5;

/**
 * 管理员后台的controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/admin")
public class ManagerController {
	@Autowired
	private MAdminService mAdminService;
	@Autowired
	private MFriendLinkService mFriendLinkService;
	@Autowired
	private MListService mListService;
	@Autowired
	private MUserService mUserService;
	@Autowired
	private MRealiseDairyService mRealiseDairyService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private CommonTool commonTool;
	
	@RequestMapping(value="/admin_index",method={RequestMethod.POST, RequestMethod.GET})
	public String adminIndex(Model model) throws Exception {
		int adminCount = mAdminService.countMadmin();
		int linkCount = mFriendLinkService.countMFriendLink();
		int listCount = mListService.countMlist();
		int userCount = mUserService.countMuser();
		model.addAttribute("adminCount", adminCount);
		model.addAttribute("linkCount", linkCount);
		model.addAttribute("listCount", listCount);
		model.addAttribute("userCount", userCount);
		return "admin_index";
	}
	
	@RequestMapping(value="/admin_login_out",method={RequestMethod.POST, RequestMethod.GET})
	public String adminLoginOut(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("madmin");
		session.removeAttribute("username");
		return "admin_login_out";
	}
	
	@RequestMapping(value="/admin_message",method={RequestMethod.POST, RequestMethod.GET})
	public String adminMessage(Model model, HttpServletRequest request) throws Exception {
		String username = (String)request.getSession().getAttribute("username");
		MAdmin admin = mAdminService.getAdmin(username);
		model.addAttribute("mAdmin", admin);
		return "admin_message";
	}
	
	@RequestMapping(value="/admin_message_edit",method={RequestMethod.POST, RequestMethod.GET})
	public String adminMessageEdit(Model model, HttpServletRequest request) throws Exception {
		String username = (String)request.getSession().getAttribute("username");
		MAdmin admin = mAdminService.getAdmin(username);
		model.addAttribute("mAdmin", admin);
		return "admin_message_edit";
	}
	
	@RequestMapping(value="/admin_pass_edit",method={RequestMethod.POST, RequestMethod.GET})
	public String adminPassEdit() throws Exception {
		return "admin_pass_edit";
	}
	
	@RequestMapping(value="/edit_message_save",method={RequestMethod.POST})
	public @ResponseBody MyResult edit_message_save(HttpServletRequest request, @Validated(value={ValidGroup2.class}) MAdminExtend mAdminExtend, BindingResult result) throws Exception {
		if(result.hasErrors())
		{
			MyResult myResult = new MyResult();
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
		String username = (String)request.getSession().getAttribute("username");
		String uname = mAdminExtend.getUname();
		if(uname == null || uname.length() > 32 || !uname.trim().equals(username.trim())){
			MyResult myResult = new MyResult();
			myResult.setResult(false);
			myResult.setMessage("uname字段错误");
			return myResult;
		}
		MyResult myResult = mAdminService.updateAdmin(mAdminExtend);
		return myResult;
	}
	
	@RequestMapping(value="/edit_pass_save",method={RequestMethod.POST})
	public @ResponseBody MyResult edit_pass_save(HttpServletRequest request, @Validated(value={ValidGroup3.class}) PasswordExt passwordExt, BindingResult result) throws Exception {
		if(result.hasErrors())
		{
			MyResult myResult = new MyResult();
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
		String username = (String)request.getSession().getAttribute("username");
		username = (username  == null ? "": username);
		String originalPasswordTrim = passwordExt.getOriginalPassword().trim();
		String currentPassword = passwordExt.getCurrentPassword();
		String currentPasswordTrim = currentPassword.trim();
		String confirmPassword = passwordExt.getConfirmPassword();
		String confirmPasswordTrim = confirmPassword.trim();
		if(!currentPassword.equals(confirmPassword)) {
			MyResult myResult = new MyResult();
			myResult.setResult(false);
			myResult.setMessage("密码和确认密码不一致");
			return myResult;
		}
		if(currentPasswordTrim.length() != currentPassword.length() || confirmPasswordTrim.length() != confirmPassword.length()) {
			MyResult myResult = new MyResult();
			myResult.setResult(false);
			myResult.setMessage("密码和确认密码前后不能包含空格字符");
			return myResult;
		}
		int admin_id = mAdminService.getAdminIdByUserPassword(username, originalPasswordTrim);
		if(admin_id == -1) {
			MyResult myResult = new MyResult();
			myResult.setResult(false);
			myResult.setMessage("原始密码错误");
			return myResult;
		}
		MAdminExtend mAdminExtend = new MAdminExtend();
		mAdminExtend.setId(admin_id);
		mAdminExtend.setPword(currentPasswordTrim);
		MyResult myResult = mAdminService.updateAdmin(mAdminExtend);
		return myResult;
	}
	
	@RequestMapping(value="/admin_tag/{tag_page}/{tag_size}",method={RequestMethod.POST, RequestMethod.GET})
	public String admin_tag(@PathVariable("tag_page") int page, @PathVariable("tag_size") int size, HttpServletRequest request, Model model) throws Exception {
		String tagName = request.getParameter("tag_name");
		TagVO tagVO = mAdminService.queryTag(page, size, tagName);
		model.addAttribute("tagVO", tagVO);
		return "admin_tag";
	}
	
	@RequestMapping(value="/admin_type/{type_page}/{type_size}",method={RequestMethod.POST, RequestMethod.GET})
	public String admin_type(@PathVariable("type_page") int page, @PathVariable("type_size") int size, HttpServletRequest request, Model model) throws Exception {
		String tagName = request.getParameter("type_name");
		TypeVO typeVO = mAdminService.queryType(page, size, tagName);
		model.addAttribute("typeVO", typeVO);
		return "admin_type";
	}
	
	@RequestMapping(value="/admin_actor/{actor_page}/{actor_size}",method={RequestMethod.POST, RequestMethod.GET})
	public String admin_singer(@PathVariable("actor_page") int page, @PathVariable("actor_size") int size, HttpServletRequest request, Model model) throws Exception {
		String actorName = request.getParameter("actor_name");
		MActorVO actorVO = mAdminService.queryActor(page, size, actorName);
		model.addAttribute("actorVO", actorVO);
		return "admin_actor";
	}
	
	@RequestMapping(value="/admin_list/{list_page}/{list_size}",method={RequestMethod.POST, RequestMethod.GET})
	public String admin_list(@PathVariable("list_page") int page, @PathVariable("list_size") int size, HttpServletRequest request, Model model) throws Exception {
		String listName = request.getParameter("list_name");
		MListVO listVO = mAdminService.queryList(page, size, listName);
		model.addAttribute("listVO", listVO);
		return "admin_list";
	}
	
	@RequestMapping(value="/actor_add_save",method={RequestMethod.POST})
	public String actor_add_save(MActorExt mActorExt, @RequestParam(value="picfile",required=true) MultipartFile pic) throws Exception {
		String pic_name = "";
		if(pic != null && pic.getOriginalFilename() != null && pic.getOriginalFilename().length() > 0) 
		{
			
			String path = "E:/picture/";
			String pic_oriname = pic.getOriginalFilename();
			int index = pic_oriname.lastIndexOf(".");
			if(index == -1)
			{
				pic_name = "default.jpg";
			} else{
				pic_name = UUID.randomUUID()+pic_oriname.substring(index);
				File file = new File(path+pic_name);
				if(!file.exists())
				{
					file.createNewFile();
				}
				pic.transferTo(file);
			}
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String addtime = sdf.format(date);
		mActorExt.setAddtime(addtime);
		// 增加mAcotr
		int aid = mAdminService.addActor(mActorExt);
		//增加mPicture
		MPicactor mp = new MPicactor();
		mp.setAid(aid);
		mp.setPicname(pic_name);
		mAdminService.addApicture(mp);
		return "forward:admin_actor/1/10";
	}
	
	@RequestMapping(value="/list_add_save",method={RequestMethod.POST})
	public String list_add_save(MListExt mListExt, @RequestParam(value="picfile",required=true) MultipartFile pic) throws Exception {
		//添加影片
		String addtime = commonTool.getCurrentTime();
		mListExt.setAddtime(addtime);
		mListExt.setMtype((byte) 0);
		int listId = mListService.insertMlist(mListExt);
		//添加影片图片
		String pic_name = "";
		if(pic != null && pic.getOriginalFilename() != null && pic.getOriginalFilename().length() > 0) 
		{
			
			String path = "E:/picture/";
			String pic_oriname = pic.getOriginalFilename();
			int index = pic_oriname.lastIndexOf(".");
			if(index == -1)
			{
				pic_name = "default.jpg";
			} else{
				pic_name = UUID.randomUUID()+pic_oriname.substring(index);
				File file = new File(path+pic_name);
				if(!file.exists())
				{
					file.createNewFile();
				}
				pic.transferTo(file);
			}
		}
		MFilmpic filmPic = new MFilmpic();
		filmPic.setMid(listId);
		filmPic.setPicname(pic_name);
		mListService.insertFilPic(filmPic);
		//添加影片标签
		MMtag filtag = new MMtag();
		filtag.setMid(listId);
		filtag.setTagid(new Integer(mListExt.getTagid()));
		mListService.insertFilTag(filtag);
		//添加影片演员
		String filids = mListExt.getActorid();
		if(filids.length() > 1) {
			filids = filids.substring(1);
			String[] actorids = filids.split(",");
			List<MMactor> mactor = new ArrayList<MMactor>();
			for(String actorid : actorids) {
				if(actorid.trim().equals("")) {
					continue;
				}
				MMactor actor = new MMactor();
				actor.setMid(listId);
				actor.setAid(new Integer(actorid));
				mactor.add(actor);
			}
			mListService.insertfilActor(mactor);
		}
		//添加影片类型
		String typeids = mListExt.getTypeid();
		if(typeids.length() > 1) {
			typeids = typeids.substring(1);
			String[] filTypes = typeids.split(",");
			List<MMtype> mtype = new ArrayList<MMtype>();
			for(String typeid : filTypes) {
				if(typeid.trim().equals("")) {
					continue;
				}
				MMtype type = new MMtype();
				type.setMid(listId);
				type.setTid(new Integer(typeid));
				mtype.add(type);
			}
			mListService.insertFilType(mtype);
		}
		return "forward:admin_list/1/10";
	}
	
	
	@RequestMapping(value="/add_tag_save",method={RequestMethod.POST})
	public @ResponseBody MyResult add_tag_save(HttpServletRequest request) throws Exception {
		String tag_name = request.getParameter("tag_name");
		if(tag_name == null || tag_name.trim().equals("")) {
			MyResult result = new MyResult();
			result.setResult(false);
			result.setMessage("标签不能为空");
			return result;
		}
		return mAdminService.addTag(tag_name);
	}
	
	@RequestMapping(value="/add_type_save",method={RequestMethod.POST})
	public @ResponseBody MyResult add_type_save(HttpServletRequest request) throws Exception {
		String type_name = request.getParameter("type_name");
		if(type_name == null || type_name.trim().equals("")) {
			MyResult result = new MyResult();
			result.setResult(false);
			result.setMessage("类型不能为空");
			return result;
		}
		return mAdminService.addType(type_name);
	}
	
	@RequestMapping(value="/edit_tag_save",method={RequestMethod.POST})
	public @ResponseBody MyResult edit_tag_save(@Validated(value={ValidGroup4.class}) MTag mTag, BindingResult result) throws Exception {
		if(result.hasErrors())
		{
			MyResult myResult = new MyResult();
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
		return mAdminService.updateTag(mTag);
	}
	
	@RequestMapping(value="/edit_type_save",method={RequestMethod.POST})
	public @ResponseBody MyResult edit_type_save(@Validated(value={ValidGroup5.class}) MType mType, BindingResult result) throws Exception {
		if(result.hasErrors())
		{
			MyResult myResult = new MyResult();
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
		return mAdminService.updateType(mType);
	}
	
	@RequestMapping(value="/actor_edit_save",method={RequestMethod.POST})
	public String actor_edit_save(MActorExt mActorExt, @RequestParam(value="picfile",required=true) MultipartFile pic) throws Exception {
		if(pic != null && pic.getOriginalFilename() != null && pic.getOriginalFilename().length() > 0) 
		{
			String pic_name = "";
			String path = "E:/picture/";
			String pic_oriname = pic.getOriginalFilename();
			int index = pic_oriname.lastIndexOf(".");
			if(index == -1)
			{
				pic_name = "default.jpg";
			} else{
				pic_name = mActorExt.getPicName();
				File file = new File(path+pic_name);
				if(!file.exists())
				{
					file.createNewFile();
				}
				pic.transferTo(file);
			}
		}
		mAdminService.updateActor(mActorExt);
		return "redirect:admin_actor/1/10";
	}
	
	@RequestMapping(value="/list_edit_save", method={RequestMethod.POST})
	public String list_edit_save(MListExt listExt, @RequestParam(value="picfile",required=true) MultipartFile pic) throws Exception {
		// 更新图片
		if(pic != null && pic.getOriginalFilename() != null && pic.getOriginalFilename().length() > 0) 
		{
			String pic_name = "";
			String path = "E:/picture/";
			String pic_oriname = pic.getOriginalFilename();
			int index = pic_oriname.lastIndexOf(".");
			if(index == -1)
			{
				pic_name = "default.jpg";
			} else{
				pic_name = listExt.getPicname();
				File file = new File(path+pic_name);
				if(!file.exists())
				{
					file.createNewFile();
				}
				pic.transferTo(file);
			}
		}
		// 更新影片基本内容(update)
		mListService.updateMlist(listExt);
		// 更新影片标签(update)
		MMtag filmTag = new MMtag();
		filmTag.setMid(listExt.getId());
		filmTag.setTagid(new Integer(listExt.getTagid()));
		mListService.updateFilTag(filmTag);
		// 更新影片演员(delete insert)
		String filids = listExt.getActorid();
		if(filids.length() >= 1) {
			if(filids.startsWith(","))
				filids = filids.substring(1);
			String[] actorids = filids.split(",");
			List<MMactor> mactor = new ArrayList<MMactor>();
			for(String actorid : actorids) {
				if(actorid.trim().equals("")) {
					continue;
				}
				MMactor actor = new MMactor();
				actor.setMid(listExt.getId());
				actor.setAid(new Integer(actorid));
				mactor.add(actor);
			}
			mListService.updatefilActor(mactor);
		}
		// 更新影片类型(delete insert)
		String typeids = listExt.getTypeid();
		if(typeids.length() >= 1) {
			if(typeids.startsWith(","))
				typeids = typeids.substring(1);
			String[] filTypes = typeids.split(",");
			List<MMtype> mtype = new ArrayList<MMtype>();
			for(String typeid : filTypes) {
				if(typeid.trim().equals("")) {
					continue;
				}
				MMtype type = new MMtype();
				type.setMid(listExt.getId());
				type.setTid(new Integer(typeid));
				mtype.add(type);
			}
			mListService.updateFilType(mtype);
		}
		return "redirect:admin_list/1/10";
	}
	
	@RequestMapping(value="/del_tag_save",method={RequestMethod.POST})
	public @ResponseBody MyResult del_tag_save(@Validated(value={ValidGroup4.class}) MTag mTag, BindingResult result) throws Exception {
		if(result.hasErrors())
		{
			MyResult myResult = new MyResult();
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
		return mAdminService.deleteTag(mTag); 
	}
	
	@RequestMapping(value="/del_type_save",method={RequestMethod.POST})
	public @ResponseBody MyResult del_type_save(@Validated(value={ValidGroup5.class}) MType mType, BindingResult result) throws Exception {
		if(result.hasErrors())
		{
			MyResult myResult = new MyResult();
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
		return mAdminService.deleteType(mType);
	}
	
	
	@RequestMapping(value="/del_actor_save",method={RequestMethod.POST})
	public @ResponseBody MyResult del_actor_save(@RequestParam(required=true) int id, @RequestParam(required=true) int aid) throws Exception {
		mAdminService.deleteApincture(aid);
		mAdminService.deleteActor(id);
		MyResult result = new MyResult();
		result.setResult(true);
		result.setMessage("删除成功");
		return result;
	}
	
	@RequestMapping(value="/del_list_save",method={RequestMethod.POST})
	public @ResponseBody MyResult del_list_save(@RequestParam(required=true) int id) throws Exception {
		mListService.deleteList(id);
		MyResult result = new MyResult();
		result.setResult(true);
		result.setMessage("删除成功");
		return result;
	}
	
	@RequestMapping(value="/query_all_actor",method={RequestMethod.POST, RequestMethod.GET})
	public  @ResponseBody List<Map> query_all_actor() throws Exception {
		return mAdminService.query_all_actor();
	}
	
	@RequestMapping(value="/query_all_type",method={RequestMethod.POST, RequestMethod.GET})
	public  @ResponseBody List<Map> query_all_type() throws Exception {
		return mAdminService.query_all_type();
	}
	
	@RequestMapping(value="/query_all_tag",method={RequestMethod.POST, RequestMethod.GET})
	public  @ResponseBody List<Map> query_all_tag() throws Exception {
		return mAdminService.query_all_tag();
	}
	
	@RequestMapping(value="/get_sex_isp",method={RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Map<String, ArrayList> SexIsp() throws Exception {
		Map map = new HashMap();
		List sex_lists = mUserService.selectSex();
		List isp_lists = mRealiseDairyService.selectIsp();
		map.put("sex", sex_lists);
		map.put("isp", isp_lists);
		return map;
	}
	
	@RequestMapping(value="/edit_list_query", method={RequestMethod.POST})
	public @ResponseBody MListExt edit_list_query(@RequestParam(value="id",required=true) int listid) throws Exception {
		return mListService.queryList(listid);
	}
	
}
