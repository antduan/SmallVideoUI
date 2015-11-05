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
 * 分类界面
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class HotRankFragment extends BaseFragment
{
	private BaseActivity myBaseActivity;
	
	public HotRankFragment(BaseActivity activity)
	{
		super(activity);
		myBaseActivity = activity;
	}
	
	public HotRankFragment()
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
		View view = myBaseActivity.inflate(R.layout.fragment_hot_rank_layout);
		return view;
	}
	
}
