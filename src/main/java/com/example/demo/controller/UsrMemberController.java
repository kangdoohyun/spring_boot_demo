package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberRoleService;
import com.example.demo.service.MemberService;
import com.example.demo.util.ScriptUtil;

@Controller
@RequestMapping("/usr/member")
public class UsrMemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRoleService memberRoleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String showLogin() {
		return "usr/member/login";
	}
	@GetMapping("/join")
	public String showJoin() {
		return "usr/member/join";
	}
	
	@GetMapping("/doLogin")
	public void doLogin(String loginId, String loginPw, HttpServletResponse response, HttpSession session) {
		if(loginId == null || loginId.isEmpty()) {
			ScriptUtil.historyBack(response, "아이디를 입력해주세요.");
			return;
		}
		if(loginPw == null || loginPw.isEmpty()) {
			ScriptUtil.historyBack(response, "비밀번호를 입력해주세요.");
			return;
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			ScriptUtil.historyBack(response, "존재하지 않는 아이디입니다.");
			return;
		}
		
		if(passwordEncoder.matches(member.getLoginPw(), loginPw)) {
			ScriptUtil.historyBack(response, "비밀번호를 확인해주세요.");
			return;
		}
		
		session.setAttribute("nickname", member.getNickname());
		
		ScriptUtil.locationReplace(response, "환영합니다.", "/usr/article/list");
	}
	
	@GetMapping("/doLogout")
	public void doLogout(String loginId, String loginPw, HttpServletResponse response, HttpSession session) {
		if(session.getAttribute("nickname") != null) {
			session.removeAttribute("nickname");
			ScriptUtil.locationReplace(response, "로그아웃 되었습니다.", "/usr/article/list");
			return;
		}
		
		ScriptUtil.historyBack(response, "로그인상태가 아닙니다.");
	}
	
	@GetMapping("/doJoin")
	public void doJoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo, HttpServletResponse response) {
		if(loginId == null || loginId.isEmpty()) {
			ScriptUtil.historyBack(response, "아이디를 입력해주세요.");
			return;
		}
		if(loginPw == null || loginPw.isEmpty()) {
			ScriptUtil.historyBack(response, "비밀번호를 입력해주세요.");
			return;
		}
		if(name == null || name.isEmpty()) {
			ScriptUtil.historyBack(response, "이름을 입력해주세요.");
			return;
		}
		if(nickname == null || nickname.isEmpty()) {
			ScriptUtil.historyBack(response, "닉네임을 입력해주세요.");
			return;
		}
		if(email == null || email.isEmpty()) {
			ScriptUtil.historyBack(response, "이메일을 입력해주세요.");
			return;
		}
		if(cellphoneNo == null || cellphoneNo.isEmpty()) {
			ScriptUtil.historyBack(response, "전화번호를 입력해주세요.");
			return;
		}
		
		boolean availableLoginId = memberService.getAvailableLoginIdCheck(loginId);
		
		if(!availableLoginId) {
			ScriptUtil.historyBack(response, "사용할 수 없는 아이디입니다.");
			return;
		}
		
		boolean availableNickname = memberService.getAvailableNicknameCheck(nickname);
		
		if(!availableNickname) {
			ScriptUtil.historyBack(response, "사용할 수 없는 닉네임입니다.");
			return;
		}
		
		boolean availableEmail = memberService.getAvailableEmailCheck(email);
		
		if(!availableEmail) {
			ScriptUtil.historyBack(response, "사용할 수 없는 이메일입니다.");
			return;
		}

		boolean enabled = true;
		String role = "ROLE_USER";
		
		int id = memberService.joinMember(loginId, loginPw, name, nickname, email, cellphoneNo, enabled, role);
		memberRoleService.setAuthority(id, 1);
		
		ScriptUtil.locationReplace(response, "회원가입에 성공했습니다. 로그인 페이지로 이동합니다.", "usr/member/login");
	}
}
