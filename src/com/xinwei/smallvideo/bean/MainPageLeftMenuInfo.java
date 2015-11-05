/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-27	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.bean;

/**
 * 
 * 左侧标题栏对象
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class MainPageLeftMenuInfo
{
	private String name;
	
	private int resourceID;
	
	private int menuID;
	
	public MainPageLeftMenuInfo(String name, int resourceID, int menuID)
	{
		super();
		this.name = name;
		this.resourceID = resourceID;
		this.menuID = menuID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getResourceID()
	{
		return resourceID;
	}
	
	public int getMenuID()
	{
		return menuID;
	}
	
	public void setMenuID(int menuID)
	{
		this.menuID = menuID;
	}
	
	public void setResourceID(int resourceID)
	{
		this.resourceID = resourceID;
	}
	
	@Override
	public String toString()
	{
		return "MainPageLeftMenuInfo [name=" + name + ", resourceID="
				+ resourceID + ", menuID=" + menuID + "]";
	}
	
}
