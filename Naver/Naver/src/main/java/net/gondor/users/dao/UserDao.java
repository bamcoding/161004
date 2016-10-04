package net.gondor.users.dao;

import net.gondor.users.vo.UserVO;

/**
 * 가입, 로그인
 * @author Lee
 *
 */
public interface UserDao {
	public int joinUser(UserVO userVO);

	public UserVO getUserBy(UserVO user);

	public int countUserId(String id); 
	
	public int addPoint(String id, int value);
}
