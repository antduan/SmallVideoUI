/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-29	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.activity;

import com.xinwei.smallvideoui.R;

/**
 * 
 * 设置界面
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class SettingActivity extends BaseActivity
{
	@Override
	protected void initLoadView()
	{
		setContentView(R.layout.activity_setting);
	}
	
	@Override
	protected void setTitleBar(String titleString)
	{
		super.setTitleBar("设置");
	}
	
}
