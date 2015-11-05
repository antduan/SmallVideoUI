/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-10	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.holder;

import android.widget.ImageView;
import android.widget.TextView;

import com.xinwei.smallvideo.activity.BaseActivity;

/**
 * 
 * 获取左侧抽屉顶部View的Holder
 * 
 * <p>
 * 获取左侧抽屉顶部View并返回
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class DrawerHeaderHolder
{
	// 基类Activity
	private BaseActivity mActivity;
	
	// 个人头像
	private ImageView myIconImage;
	
	// 欢迎语言
	private TextView welcomeTextView;
	
	public DrawerHeaderHolder(BaseActivity activity)
	{
		super();
		this.mActivity = activity;
	}
	
	/**
	 * 获取所要添加的View
	 */
	public void getView()
	{
		
	}
	
}
