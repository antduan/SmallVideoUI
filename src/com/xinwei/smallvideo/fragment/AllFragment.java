/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-9	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.fragment;

import android.view.View;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.widget.LoadingPage.LoadResult;
import com.xinwei.smallvideoui.R;

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

public class AllFragment extends BaseFragment
{
	// 基类Activity
	private BaseActivity myActivity;
	
	public AllFragment(BaseActivity activity)
	{
		super(activity);
		myActivity = activity;
	}
	
	public AllFragment()
	{
		super();
	}
	
	@Override
	protected LoadResult loadData()
	{
		return null;
	}
	
	@Override
	protected View createLoadedView()
	{
		View view = myActivity.inflate(R.layout.fragment_home_layout);
		return view;
	}
	
}
