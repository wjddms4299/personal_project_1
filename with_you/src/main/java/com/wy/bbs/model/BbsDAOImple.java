package com.wy.bbs.model;

import org.mybatis.spring.SqlSessionTemplate;

public class BbsDAOImple implements BbsDAO {
	
	private SqlSessionTemplate sqlMap;

	public SqlSessionTemplate getSqlMap() {
		return sqlMap;
	}
	public void setSqlMap(SqlSessionTemplate sqlMap) {
		this.sqlMap = sqlMap;
	}

}
