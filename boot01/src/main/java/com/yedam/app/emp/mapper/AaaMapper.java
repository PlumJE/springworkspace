package com.yedam.app.emp.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	@Insert("INSERT INTO tbl_aaa VALUES(#{value})")	// 자주쓰는 Mybatis 테스트방식
	public int insert(String value);
}
