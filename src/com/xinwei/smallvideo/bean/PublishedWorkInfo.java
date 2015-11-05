/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-28	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.bean;

import java.io.Serializable;

/**
 * 
 * 主页使用的发表的作品详情
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class PublishedWorkInfo implements Serializable
{
	private static final long serialVersionUID = 932780927463841202L;
	
	// 用户名
	private String userName;
	
	// 用户性别
	private int userSex;
	
	// 用户头像
	private String userIconPath;
	
	// 信心值
	private String heartNumber;
	
	// 热度值
	private int hotNumber;
	
	// 作品名称
	private String workName;
	
	// 作品详情
	private String workContent;
	
	// 多少人看好
	public String sayGoodNumber;
	
	// 多少人加入
	public String joinNumber;
	
	// 曝光度
	public String showTimes;
	
	// 类型：1——new 2——hot 0——normal
	public int workTypes;
	
	// 是否收藏
	public boolean isCollected;
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public int getUserSex()
	{
		return userSex;
	}
	
	public void setUserSex(int userSex)
	{
		this.userSex = userSex;
	}
	
	public String getUserIconPath()
	{
		return userIconPath;
	}
	
	public void setUserIconPath(String userIconPath)
	{
		this.userIconPath = userIconPath;
	}
	
	public String getHeartNumber()
	{
		return heartNumber;
	}
	
	public void setHeartNumber(String heartNumber)
	{
		this.heartNumber = heartNumber;
	}
	
	public int getHotNumber()
	{
		return hotNumber;
	}
	
	public void setHotNumber(int hotNumber)
	{
		this.hotNumber = hotNumber;
	}
	
	public String getWorkName()
	{
		return workName;
	}
	
	public void setWorkName(String workName)
	{
		this.workName = workName;
	}
	
	public String getWorkContent()
	{
		return workContent;
	}
	
	public void setWorkContent(String workContent)
	{
		this.workContent = workContent;
	}
	
	public String getSayGoodNumber()
	{
		return sayGoodNumber;
	}
	
	public void setSayGoodNumber(String sayGoodNumber)
	{
		this.sayGoodNumber = sayGoodNumber;
	}
	
	public String getJoinNumber()
	{
		return joinNumber;
	}
	
	public void setJoinNumber(String joinNumber)
	{
		this.joinNumber = joinNumber;
	}
	
	public String getShowTimes()
	{
		return showTimes;
	}
	
	public void setShowTimes(String showTimes)
	{
		this.showTimes = showTimes;
	}
	
	public int getWorkTypes()
	{
		return workTypes;
	}
	
	public void setWorkTypes(int workTypes)
	{
		this.workTypes = workTypes;
	}
	
	public boolean isCollected()
	{
		return isCollected;
	}
	
	public void setCollected(boolean isCollected)
	{
		this.isCollected = isCollected;
	}
	
}
