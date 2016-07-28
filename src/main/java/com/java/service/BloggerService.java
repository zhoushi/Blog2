package com.java.service;

import com.java.entity.Blogger;

/**
 * ����Service�ӿ�
 * @author Administrator
 *
 */
public interface BloggerService {

	/**
	 * ͨ���û����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Blogger getByUserName(String userName);
	
	public Blogger find();
}
