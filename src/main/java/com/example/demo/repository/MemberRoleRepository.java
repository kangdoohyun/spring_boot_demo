package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberRoleRepository {

	public void setAuthority(@Param("memberId") int memberId, @Param("roleId") int roleId);
	
}
