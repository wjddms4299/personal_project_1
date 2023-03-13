package com.wy.controller;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wy.member.model.*;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDao;
	
	@RequestMapping(value="/memberJoin.do",method=RequestMethod.GET)
	public String memberJoinForm() {
		return "member/memberJoin";
	}
	
	@RequestMapping(value="/memberJoin.do",method=RequestMethod.POST)
	public ModelAndView memberJoinSubmit(MemberDTO dto) {
		
		int result=memberDao.memberJoin(dto);
		String msg=result>0?"회원가입을 축하합니다!":"회원가입에 실패하였습니다. 고객센터에 문의바랍니다!";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("goUrl","index.do");
		mav.setViewName("member/memberMsg");
		return mav;
	}
	
	@RequestMapping(value="/idCheck.do",method=RequestMethod.GET)
	public String idCheckForm() {
		return "member/idCheck";
	}
	
	@RequestMapping(value="/idCheck.do",method=RequestMethod.POST)
	public ModelAndView idCheckSubmit(@RequestParam("")String id) {
		
		int result=memberDao.idCheck(id);
		
		ModelAndView mav=new ModelAndView();
		
		switch(result) {
		case 0:
			mav.addObject("msg","사용 가능한 아이디입니다.");
			mav.addObject("id",id);
			mav.setViewName("member/idCheckOk");break;
		case 1:
			mav.addObject("msg","이미 등록되어있는 아이디입니다.");
			mav.addObject("goUrl","idCheck.do");
			mav.setViewName("member/memberMsg");break;
		default:
			mav.addObject("msg","아이디 검사에 실패하였습니다. 고객센터에 문의 바랍니다.");
			mav.setViewName("member/idCheckOk");break;
		}
		
		return mav;
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public ModelAndView loginForm(@CookieValue(value="saveid",defaultValue="")String saveid) {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("userid",saveid);
		mav.setViewName("member/login");
		return mav;
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public ModelAndView loginSubmit(String userid,String userpwd,@RequestParam(value="saveid",required=false)String saveid,HttpSession session,HttpServletResponse res) {
		
		int result=memberDao.loginCheck(userid,userpwd);
		
		ModelAndView mav=new ModelAndView();
		
		if(result==memberDao.LOGIN_OK) {
			String username=memberDao.getUserInfo(userid);
			session.setAttribute("sid", userid);
			
			if(saveid==null) {
				Cookie ck=new Cookie("saveid",userid);
				ck.setMaxAge(0);
				res.addCookie(ck);
			}else {
				Cookie ck=new Cookie("saveid",userid);
				ck.setMaxAge(60*60*24*30);
				res.addCookie(ck);
			}
			
			mav.addObject("msg",username+"님 환영합니다!");
			mav.setViewName("member/loginOk");
		}else if(result==memberDao.NOT_ID || result==memberDao.NOT_PWD) {
			mav.addObject("msg","ID 또는 비밀번호가 잘못되었습니다.");
			mav.addObject("goUrl","login.do");
			mav.setViewName("member/memberMsg");
		}
		
		return mav;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		session.invalidate();
		
		return "redirect:/index.do";
	}

}
