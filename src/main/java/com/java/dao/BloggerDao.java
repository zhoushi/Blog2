package com.java.dao;

import com.java.entity.Blogger;

/**
 * 管理员
 * @author Administrator
 *
 */
public interface BloggerDao {

	/**
	 * ͨ���û����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	public Blogger find();
}
