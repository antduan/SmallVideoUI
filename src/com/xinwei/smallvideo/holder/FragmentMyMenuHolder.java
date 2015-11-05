/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-28	| Administrator 	| 	create the file                       
 */

package com.xinwei.smallvideo.holder;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.utils.PublicUtil;
import com.xinwei.smallvideo.widget.CircleBitmapDisplayer;
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

public class FragmentMyMenuHolder
{
	private BaseActivity mActivity;
	
	// 用户头像
	private ImageView userIcon;
	
	// 用户名
	private TextView userName;
	
	// 用户标签
	private TextView userNameContent;
	
	// 关注人数
	private TextView focusText;
	
	// 好友人数
	private TextView friendText;
	
	// 发表作品数目
	private TextView workText;
	
	// ImageLoader加载参数
	private DisplayImageOptions options;
	
	public FragmentMyMenuHolder(BaseActivity activity)
	{
		this.mActivity = activity;
		
		options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.cacheOnDisk(true).displayer(new CircleBitmapDisplayer())
				.build();
	}
	
	public View getRootView()
	{
		View view = mActivity.inflate(R.layout.fragment_my_list_head);
		userIcon = (ImageView) view
				.findViewById(R.id.fragment_my_list_head_user_icon);
		userName = (TextView) view
				.findViewById(R.id.fragment_my_list_header_user_name);
		userNameContent = (TextView) view
				.findViewById(R.id.fragment_my_list_header_user_name_content);
		
		focusText = (TextView) view
				.findViewById(R.id.fragment_my_list_header_focus);
		friendText = (TextView) view
				.findViewById(R.id.fragment_my_list_header_friends);
		workText = (TextView) view
				.findViewById(R.id.fragment_my_list_header_works);
		
		// 使用ImageLoader加载头像
		// ImageLoader.getInstance().displayImage(userIconPath, userIcon,
		// options);
		
		userIcon.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// 登陆
				PublicUtil.getInstance().showCustomToast(mActivity,
						"别点我，点我我就把你吃掉", 1);
			}
		});
		return view;
	}
	
	/**
	 * 更新用户界面
	 * 
	 * @param listHeadInfo
	 */
	public void updateView()
	{
		userName.setText("蚂蚁梦想家");
		userNameContent.setText("没错，这就是我的签名，喜羊羊美羊羊灰太狼");
		focusText.setText("239");
		friendText.setText("258");
		workText.setText("1683");
	}
	
}
