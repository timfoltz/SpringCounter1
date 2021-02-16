package com.tim.counter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		session.setAttribute("name", name);
	}
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		if( session.getAttribute("count") != null) { 
		Integer count = (Integer) session.getAttribute("count");
		session.setAttribute("count", count = count + 1);
		System.out.println("first if " + count);
		model.addAttribute("count",count);
		return "index.jsp";} 
		
		else {System.out.println("in else");
		session.setAttribute("count", 0);
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count",count);
		return "index.jsp";
		}
		
	}
	
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		if( session.getAttribute("count") != null) { 
			Integer count = (Integer) session.getAttribute("count");
			
			System.out.println("first if " + count);
			model.addAttribute("count",count);
		return "counter.jsp";}
		
		else {System.out.println("in else");
		session.setAttribute("count", 0);
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count",count);
		return "counter.jsp";}
	}
		
		
		@RequestMapping("/counterDouble")
		public String counterDouble(Model model, HttpSession session) {
			if( session.getAttribute("count") != null) { 
				Integer count = (Integer) session.getAttribute("count");
				session.setAttribute("count", count = count + 2);
				System.out.println("first if " + count);
				model.addAttribute("count",count);
				return "redirect:counter";}
				
			
			else {System.out.println("in else");
			session.setAttribute("count", 0);
			Integer count = (Integer) session.getAttribute("count");
			model.addAttribute("count",count);
			return "counter.jsp";}
		}
		
		@RequestMapping("/reset")
		public String reset(Model model, HttpSession session) {
			 
			session.setAttribute("count", null);
			Integer count = (Integer) session.getAttribute("count");
			model.addAttribute("count",count);
			return "redirect:/";
			}
		
	}

			
		
		

	


