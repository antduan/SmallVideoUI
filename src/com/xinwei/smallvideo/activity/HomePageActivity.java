/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-24	| Administrator 	| 	create the file                       
 */

package com.xinwei.smallvideo.activity;

import android.support.v4.view.ViewPager;

import com.xinwei.smallvideo.adapter.HomePagerAdapter;
import com.xinwei.smallvideo.widget.PagerSlidingTabStrip;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 类简要描述
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author Administrator
 * 
 */

public class HomePageActivity extends BaseActivity
{
	// ViewPager上边指示器，指示当前选中界面
	private PagerSlidingTabStrip mPageTabs;
	
	// ViewPager切换界面
	private ViewPager mPager;
	
	// 放置界面的容器
	private HomePagerAdapter mAdapter;
	
	@Override
	protected void initLoadView()
	{
		setContentView(R.layout.activity_home_page);
		initView();
	}
	
	/**
	 * 初始化界面
	 */
	private void initView()
	{
		// 滑动页面
		mPageTabs = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabs);
		mPager = (ViewPager) findViewById(R.id.home_page_view_page);
		mAdapter = new HomePagerAdapter(this, getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		
		mPageTabs.setViewPager(mPager);
		mPageTabs.setOnPageChangeListener(mAdapter);
	}
}
