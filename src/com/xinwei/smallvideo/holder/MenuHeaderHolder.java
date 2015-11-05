package com.xinwei.smallvideo.holder;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.activity.LoginActivity;
import com.xinwei.smallvideo.utils.PublicUtil;
import com.xinwei.smallvideo.widget.CircleBitmapDisplayer;
import com.xinwei.smallvideoui.R;

public class MenuHeaderHolder
{
	// 用户头像地址
	private String userIconPath = "";
	
	private BaseActivity mActivity;
	
	// 用户头像
	private ImageView userIcon;
	
	// 用户名
	private TextView screenName;
	
	// 欢迎内容
	private TextView screenContent;
	
	// ImageLoader加载参数
	private DisplayImageOptions options;
	
	public MenuHeaderHolder(BaseActivity mActivity)
	{
		this.mActivity = mActivity;
		
		options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.cacheOnDisk(true).displayer(new CircleBitmapDisplayer())
				.build();
	}
	
	public View getRootView()
	{
		View view = mActivity
				.inflate(R.layout.main_page_slide_drawer_list_head);
		userIcon = (ImageView) view
				.findViewById(R.id.main_page_slide_user_icon);
		screenName = (TextView) view
				.findViewById(R.id.main_pager_slider_screen_name);
		screenContent = (TextView) view
				.findViewById(R.id.main_pager_slider_screen_content);
		
		// 使用ImageLoader加载头像
		// ImageLoader.getInstance().displayImage(userIconPath, userIcon,
		// options);
		
		userIcon.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(mActivity, LoginActivity.class);
				mActivity.startActivity(intent);
			}
		});
		return view;
	}
	
}
