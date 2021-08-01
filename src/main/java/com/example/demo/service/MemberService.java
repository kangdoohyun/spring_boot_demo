package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public boolean getAvailableLoginIdCheck(String loginId) {
		Member member = getMemberByLoginId(loginId);
		if(member != null) {
			return false;
		}
		return true;
	}
	
	public Member getMemberByNickname(String nickname) {
		return memberRepository.getMemberByNickname(nickname);
	}

	public boolean getAvailableNicknameCheck(String nickname) {
		Member member = getMemberByNickname(nickname);
		if(member != null) {
			return false;
		}
		return true;
	}
	
	public Member getMemberByEmail(String email) {
		return memberRepository.getMemberByEmail(email);
	}

	public boolean getAvailableEmailCheck(String email) {
		Member member = getMemberByEmail(email);
		if(member != null) {
			return false;
		}
		return true;
	}

	public void joinMember(String loginId, String loginPw, String name, String nickname, String email,
			String cellphoneNo) {
		memberRepository.joinMember(loginId, loginPw, name, nickname, email, cellphoneNo);
	}
}
