package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.Member;

@Mapper
public interface MemberRepository {

	public Member getMemberByLoginId(@Param("loginId") String loginId);

	public Member getMemberByNickname(@Param("nickname") String nickname);

	public Member getMemberByEmail(@Param("email") String email);

	public void joinMember(@Param("loginId") String loginId, @Param("loginPw") String loginPw,
			@Param("name") String name, @Param("nickname") String nickname, @Param("email") String email,
			@Param("cellphoneNo") String cellphoneNo);

}
