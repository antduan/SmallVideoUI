/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-8	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xinwei.smallvideo.widget.LoadingPage;
import com.xinwei.smallvideo.widget.LoadingPage.LoadResult;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 基类Activity
 * 
 * <p>
 * 基类Activity
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class BaseActivity extends ActionBarActivity
{
	private LayoutInflater mInflater;
	
	protected ActionBar mActionBar;
	
	// 标题中间的文字
	protected TextView titleBarText;
	
	protected ImageButton titleBarTmageBtn;
	
	protected Handler mHandler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			onHandleMessage(msg);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		mActionBar = getSupportActionBar();
		
		initLoadView();
		initActionBar();
	}
	
	/**
	 * 初始化界面
	 */
	protected void initLoadView()
	{
		LoadingPage page = new LoadingPage(this)
		{
			@Override
			public LoadResult load()
			{
				return BaseActivity.this.load();
			}
			
			@Override
			public View createLoadedView()
			{
				return BaseActivity.this.createLoadedView();
			}
		};
		setContentView(page);
		page.show();
	}
	
	protected void init()
	{
		
	}
	
	protected View createLoadedView()
	{
		return null;
	}
	
	protected LoadResult load()
	{
		return null;
	}
	
	/**
	 * 初始化标题
	 */
	protected void initActionBar()
	{
		mActionBar.setDisplayHomeAsUpEnabled(true);
		
		ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View titleView = inflater.inflate(
				R.layout.activity_base_person_action_bar_title, null);
		mActionBar.setCustomView(titleView, lp);
		
		mActionBar.setDisplayShowHomeEnabled(false);// 去掉导航
		mActionBar.setDisplayShowTitleEnabled(false);// 去掉标题
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		mActionBar.setDisplayShowCustomEnabled(true);
		
		titleBarTmageBtn = (ImageButton) mActionBar.getCustomView()
				.findViewById(R.id.activity_base_title_bar_image);
		
		titleBarText = (TextView) mActionBar.getCustomView().findViewById(
				R.id.activity_base_title_bar_title);
		
		titleBarTmageBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				
				finish();
				out2Left();
			}
		});
		
		setTitleBar("");
		
		/*
		 * int titleId = Resources.getSystem().getIdentifier("action_bar_title",
		 * "id", "android"); TextView actTitle = (TextView)
		 * findViewById(titleId); actTitle.setOnClickListener(new
		 * OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * } }); actTitle.setTextColor(Color.WHITE);
		 * mActionBar.setHomeButtonEnabled(true);
		 * mActionBar.setIcon(android.R.color.transparent);
		 * mActionBar.setDisplayHomeAsUpEnabled(true);
		 * mActionBar.setDisplayShowHomeEnabled(true);
		 */
	}
	
	/**
	 * 修改当前标题
	 * 
	 * @param titleString
	 */
	protected void setTitleBar(String titleString)
	{
		titleBarText.setText(titleString);
	}
	
	/**
	 * 由子类实现如何处理事件
	 * 
	 * @param msg
	 */
	protected void onHandleMessage(Message msg)
	{
		
	}
	
	public boolean post(Runnable run)
	{
		return mHandler.post(run);
	}
	
	/**
	 * 获取颜色值
	 * 
	 * @param resId
	 * @return
	 */
	public int getColor(int resId)
	{
		return getThemeContext().getResources().getColor(resId);
	}
	
	/**
	 * 获取LayoutInflater对象
	 * 
	 * @param resId
	 * @return
	 */
	public View inflate(int resId)
	{
		if (null == mInflater)
		{
			mInflater = LayoutInflater.from(getThemeContext());
		}
		return mInflater.inflate(resId, null);
	}
	
	/**
	 * 获取Drawable文件
	 * 
	 * @param drawableID
	 * @return
	 */
	public Drawable getMyDrawable(int drawableID)
	{
		return getResources().getDrawable(drawableID);
	}
	
	/**
	 * 获取Android上下文
	 * 
	 * @return
	 */
	protected Context getThemeContext()
	{
		return this;
	}
	
	/**
	 * 左侧退出动画
	 */
	public void out2Left()
	{
		overridePendingTransition(R.anim.new_dync_no,
				R.anim.new_dync_out_to_left);
	}
	
	/**
	 * 动画
	 */
	public void int4Right()
	{
		overridePendingTransition(R.anim.new_dync_in_from_right,
				R.anim.new_dync_no);
	}
	
	/**
	 * dip转换px
	 * 
	 * @param dip
	 * @return
	 */
	public int dip2px(int dip)
	{
		final float scale = getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}
	
	/**
	 * px转换dip
	 * 
	 * @param px
	 * @return
	 */
	public int px2dip(int px)
	{
		final float scale = getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}
	
}
