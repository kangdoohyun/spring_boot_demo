package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import com.example.demo.util.ScriptUtil;

@Controller
@RequestMapping("/adm/member")
public class AdmMemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("/info")
	public String shoInfo() {
		return "adm/member/info";
	}
}
