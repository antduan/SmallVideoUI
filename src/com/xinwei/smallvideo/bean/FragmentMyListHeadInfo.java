/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-29	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.bean;

import java.io.Serializable;

/**
 * 
 * 类简要描述
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class FragmentMyListHeadInfo implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -215970505735868536L;
	
	private String userName;
	
	private String userIconPath;
	
	private String userNameContent;
	
	// 关注人数
	private String focusNumber;
	
	// 好友人数
	private String friendNumber;
	
	// 发表作品数
	private String workNumber;
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getUserIconPath()
	{
		return userIconPath;
	}
	
	public void setUserIconPath(String userIconPath)
	{
		this.userIconPath = userIconPath;
	}
	
	public String getUserNameContent()
	{
		return userNameContent;
	}
	
	public void setUserNameContent(String userNameContent)
	{
		this.userNameContent = userNameContent;
	}
	
	public String getFocusNumber()
	{
		return focusNumber;
	}
	
	public void setFocusNumber(String focusNumber)
	{
		this.focusNumber = focusNumber;
	}
	
	public String getFriendNumber()
	{
		return friendNumber;
	}
	
	public void setFriendNumber(String friendNumber)
	{
		this.friendNumber = friendNumber;
	}
	
	public String getWorkNumber()
	{
		return workNumber;
	}
	
	public void setWorkNumber(String workNumber)
	{
		this.workNumber = workNumber;
	}
	
}
