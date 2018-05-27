package com.jwt.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home.jsp";
	}
	
	@RequestMapping(value="/test.do")
	public String test(){
		
		logger.info("test 호출");
		return "test.jsp";
	}
	
	@RequestMapping(value="/hello.do")
	public String test2(){
		logger.info("test2 호출");
		
		return "hello.html";
	}
	
	@RequestMapping(value="/angular.do")
	public String angular(){
		logger.info("angular 호출");
		
		return "ag_test.html";
	}
	
	
	@RequestMapping(value="/json.do")
	public ModelAndView json(){
		logger.info("test2 호출");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("key","value");
		mv.addObject("key2", "value2");
		
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	
}
