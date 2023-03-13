package com.wy.member.model;

import java.sql.*;
import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDAOImple implements MemberDAO {
	
	private SqlSessionTemplate sqlMap;

	public SqlSessionTemplate getSqlMap() {
		return sqlMap;
	}
	public void setSqlMap(SqlSessionTemplate sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	public int memberJoin(MemberDTO dto) {
		int count=sqlMap.insert("memberJoin",dto);
		return count;
	}
	
	public int idCheck(String id) {
		MemberDTO dto=sqlMap.selectOne("idCheck",id);
		int count=0;
		if(dto!=null)count++;
		return count;
	}
	
	public int loginCheck(String id, String userpwd) {
		String savepwd=sqlMap.selectOne("loginCheck",id);
		if(savepwd!=null){
			if(savepwd.equals(userpwd)) {
				return LOGIN_OK;
			}else {
				return NOT_PWD;
			}
		}else {
			return NOT_ID;
		}
	}
	
	public String getUserInfo(String id) {
		String name=sqlMap.selectOne("getUserInfo",id);
		return name;
	}

}
