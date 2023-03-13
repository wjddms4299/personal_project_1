package com.wy.member.model;

import java.util.*;

public interface MemberDAO {
	
	final public static int NOT_ID=1;
	final public static int NOT_PWD=2;
	final public static int LOGIN_OK=3;
	final public static int ERROR=-1;
	
	public int memberJoin(MemberDTO dto);
	
	public int idCheck(String id);
	
	public int loginCheck(String userid, String userpwd);
	
	public String getUserInfo(String userid);

}
