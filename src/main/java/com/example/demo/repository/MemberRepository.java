package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Member;
import com.example.demo.dto.Role;

@Mapper
public interface MemberRepository {

	public Member getMemberByLoginId(@Param("loginId") String loginId);

	public Member getMemberByNickname(@Param("nickname") String nickname);

	public Member getMemberByEmail(@Param("email") String email);

	public int joinMember(@Param("loginId") String loginId, @Param("loginPw") String loginPw,
			@Param("name") String name, @Param("nickname") String nickname, @Param("email") String email,
			@Param("cellphoneNo") String cellphoneNo, @Param("enabled") boolean enabled, @Param("role") String role);

	public int getLastInsertId();

}
