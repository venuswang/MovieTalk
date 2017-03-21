package cn.scau.edu.ssm.movietalk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.edu.ssm.movietalk.po.MLongReview;
import cn.scau.edu.ssm.movietalk.po.MReviewReply;
import cn.scau.edu.ssm.movietalk.po.MShortReview;
import cn.scau.edu.ssm.movietalk.po.MStore;
import cn.scau.edu.ssm.movietalk.po.MStoreVO;
import cn.scau.edu.ssm.movietalk.po.MyResult;
import cn.scau.edu.ssm.movietalk.service.MLongReviewService;
import cn.scau.edu.ssm.movietalk.service.MReviewReplyService;
import cn.scau.edu.ssm.movietalk.service.MShortReviewService;
import cn.scau.edu.ssm.movietalk.service.MStoreService;
import cn.scau.edu.ssm.movietalk.tool.CommonTool;

@Controller
@RequestMapping(value="/custom")
public class UserController {
	@Autowired
	private MStoreService mStoreService;
	@Autowired
	private MShortReviewService mShortReviewService;
	@Autowired
	private CommonTool commonTool;
	@Autowired
	private MLongReviewService mLongReviewService;
	@Autowired
	private MReviewReplyService mReviewReplyService;
	
	
	@RequestMapping(value="/user_exit",method={RequestMethod.POST, RequestMethod.GET})
	public String userExit(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("uid");
		session.removeAttribute("username");
		return "customer_exit";
	}
	
	@RequestMapping(value="/cancel_collect",method={RequestMethod.POST})
	public @ResponseBody MyResult cancelCollect(HttpServletRequest request, MStore store) throws Exception {
		MyResult result = new MyResult();
		HttpSession session = request.getSession();
		Integer uid = (Integer)session.getAttribute("uid");
		if(uid == null) {
			result.setMessage("用户没有登录");
			result.setResult(false);
			return result;
		}
		store.setUid(uid);
		int count = mStoreService.cancelCollect(store);
		if(count == 0) {
			result.setMessage("用户没有权限");
			result.setResult(false);
			return result;
		}
		result.setMessage("取消收藏成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/add_collect",method={RequestMethod.POST})
	public @ResponseBody MyResult addCollect(HttpServletRequest request, MStore store) throws Exception {
		MyResult result = new MyResult();
		HttpSession session = request.getSession();
		Integer uid = (Integer)session.getAttribute("uid");
		if(uid == null) {
			result.setMessage("用户没有登录");
			result.setResult(false);
		}
		store.setUid(uid);
		mStoreService.addCollect(store);
		result.setMessage("添加收藏成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/short_common_save",method={RequestMethod.POST})
	public @ResponseBody MyResult short_common_save(HttpServletRequest request, MShortReview shortReview) throws Exception {
		MyResult result = new MyResult();
		Integer uid = (Integer)request.getSession().getAttribute("uid");
		String rtime = commonTool.getCurrentTime();
		shortReview.setRtime(rtime);
		shortReview.setUid(uid);
		shortReview.setUsenum(0);
		mShortReviewService.insertShortReview(shortReview);
		result.setMessage("添加影片短评成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/long_common_save",method={RequestMethod.POST})
	public @ResponseBody MyResult long_common_save(HttpServletRequest request, MLongReview longReview) throws Exception {
		MyResult result = new MyResult();
		Integer uid = (Integer)request.getSession().getAttribute("uid");
		String rtime = commonTool.getCurrentTime();
		longReview.setRtime(rtime);
		longReview.setUid(uid);
		longReview.setUnuse(0);
		longReview.setUsenum(0);
		mLongReviewService.insertLongReview(longReview);
		result.setMessage("添加影片影评成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/add_approve",method={RequestMethod.POST})
	public @ResponseBody MyResult add_approve(HttpServletRequest request) throws Exception {
		MyResult result = new MyResult();
		String id = request.getParameter("id");
		if(id == null) {
			result.setMessage("点赞失败,缺少相关参数");
			result.setResult(false);
			return result;
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		session.setAttribute(username+"_+_"+id, "true");
		mShortReviewService.AddSuppose(Integer.parseInt(id));
		result.setMessage("点赞成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/cancel_approve",method={RequestMethod.POST})
	public @ResponseBody MyResult cancel_approve(HttpServletRequest request) throws Exception {
		MyResult result = new MyResult();
		String id = request.getParameter("id");
		if(id == null) {
			result.setMessage("取消点赞失败,缺少相关参数");
			result.setResult(false);
			return result;
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		session.removeAttribute(username+"_+_"+id);
		mShortReviewService.cancelSuppose(Integer.parseInt(id));
		result.setMessage("取消点赞成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/l_approve_add",method={RequestMethod.POST})
	public @ResponseBody MyResult l_approve_add(HttpServletRequest request) throws Exception {
		MyResult result = new MyResult();
		String id = request.getParameter("id");
		if(id == null) {
			result.setMessage("添加点赞失败,缺少相关参数");
			result.setResult(false);
			return result;
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		session.setAttribute(username+"_+_suppose_+_"+id, "true");
		mLongReviewService.addLongSuppose(Integer.parseInt(id));
		result.setMessage("添加点赞成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/l_anti_add",method={RequestMethod.POST})
	public @ResponseBody MyResult l_anti_add(HttpServletRequest request) throws Exception {
		MyResult result = new MyResult();
		String id = request.getParameter("id");
		if(id == null) {
			result.setMessage("添加无用失败,缺少相关参数");
			result.setResult(false);
			return result;
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		session.setAttribute(username+"_+_anti_+_"+id, "true");
		mLongReviewService.addLongAnti(Integer.parseInt(id));
		result.setMessage("添加无用成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/l_approve_cancel",method={RequestMethod.POST})
	public @ResponseBody MyResult l_approve_cancel(HttpServletRequest request) throws Exception {
		MyResult result = new MyResult();
		String id = request.getParameter("id");
		if(id == null) {
			result.setMessage("取消点赞失败,缺少相关参数");
			result.setResult(false);
			return result;
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		session.removeAttribute(username+"_+_suppose_+_"+id);
		mLongReviewService.cancelLongSuppose(Integer.parseInt(id));
		result.setMessage("取消点赞成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/l_anti_cancel",method={RequestMethod.POST})
	public @ResponseBody MyResult l_anti_cancel(HttpServletRequest request) throws Exception {
		MyResult result = new MyResult();
		String id = request.getParameter("id");
		if(id == null) {
			result.setMessage("取消无用失败,缺少相关参数");
			result.setResult(false);
			return result;
		}
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		session.removeAttribute(username+"_+_anti_+_"+id);
		mLongReviewService.cancelLongAnti(Integer.parseInt(id));
		result.setMessage("取消无用成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/review_reply_delete",method={RequestMethod.POST})
	public @ResponseBody MyResult review_reply_delete(HttpServletRequest request) throws Exception {
		MyResult result = new MyResult();
		String id = request.getParameter("id");
		if(id == null || id.trim().equals("")) {
			result.setMessage("删除评论失败,缺少相关参数");
			result.setResult(false);
			return result;
		}
		Integer uid = (Integer)request.getSession().getAttribute("uid");
		int count = mReviewReplyService.deleteReply(Integer.parseInt(id), uid);
		if(count == 0) {
			result.setMessage("删除评论失败,可能是没有权限,可能是该记录不存在");
			result.setResult(false);
			return result;
		}
		result.setMessage("删除评论成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/review_reply_save",method={RequestMethod.POST})
	public @ResponseBody MyResult review_reply_save(HttpServletRequest request, MReviewReply reply) throws Exception {
		MyResult result = new MyResult();
		Integer uid = (Integer)request.getSession().getAttribute("uid");
		String rtime = commonTool.getCurrentTime();
		reply.setUid(uid);
		reply.setRtime(rtime);
		int count = mReviewReplyService.insertReply(reply);
		if(count == 0) {
			result.setMessage("添加评论失败");
			result.setResult(false);
			return result;
		}
		result.setMessage("添加评论成功");
		result.setResult(true);
		return result;
	}
	
	@RequestMapping(value="/all_movie_collect/{list_page}/{list_size}",method={RequestMethod.GET})
	public String all_movie_collect(Model model, HttpServletRequest request, @PathVariable("list_page") int page, @PathVariable("list_size") int size) throws Exception {
		Integer uid = (Integer)request.getSession().getAttribute("uid");
		MStoreVO mstore = mStoreService.queryStore(page, size, uid);
		model.addAttribute("mstore", mstore);
		return "all_movie_collect";
	}
}
