/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-28	| Administrator 	| 	create the file                       
 */

package com.xinwei.smallvideo.bean;

import java.io.Serializable;

/**
 * 
 * 我的界面菜单
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author Administrator
 * 
 */

public class FragmentMyListInfo implements Serializable
{
	private static final long serialVersionUID = 723232959782706154L;
	
	// 菜单名称
	private String menuName;
	
	// 菜单图像
	private int resouceID;
	
	// 菜单后边文字
	private String content;
	
	// 菜单的ID
	private int menuID;
	
	// 是否展示空白
	private boolean isShowTopBlack;
	
	public FragmentMyListInfo(String menuName, int resouceID, String content,
			int menuID, boolean isShowTopBlack)
	{
		super();
		this.menuName = menuName;
		this.resouceID = resouceID;
		this.content = content;
		this.menuID = menuID;
		this.isShowTopBlack = isShowTopBlack;
	}
	
	public String getMenuName()
	{
		return menuName;
	}
	
	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}
	
	public int getResouceID()
	{
		return resouceID;
	}
	
	public void setResouceID(int resouceID)
	{
		this.resouceID = resouceID;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public int getMenuID()
	{
		return menuID;
	}
	
	public void setMenuID(int menuID)
	{
		this.menuID = menuID;
	}
	
	public boolean isShowTopBlack()
	{
		return isShowTopBlack;
	}
	
	public void setShowTopBlack(boolean isShowTopBlack)
	{
		this.isShowTopBlack = isShowTopBlack;
	}
	
}
