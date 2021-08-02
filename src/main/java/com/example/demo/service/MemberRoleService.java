package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;
import com.example.demo.dto.Role;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemberRoleRepository;

@Service
public class MemberRoleService {
	@Autowired
	private MemberRoleRepository memberRoleRepository;
	
	public void setAuthority(int memberId, int roleId) {
		memberRoleRepository.setAuthority(memberId, roleId);
	}
}
