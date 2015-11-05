package com.xinwei.smallvideo.holder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.activity.PublishedWorkInfoActivity;
import com.xinwei.smallvideo.bean.PublishedWorkInfo;
import com.xinwei.smallvideoui.R;

public class FragmentHomeResourcesHolder extends BaseHolder<PublishedWorkInfo>
{
	// 用户性别
	private ImageView userSexImage;
	
	// 用户名
	private TextView userName;
	
	// 用户头像
	private ImageView userIconPath;
	
	// 信心值
	private TextView heartNumber;
	
	// 热度值
	private ProgressBar hotNumber;
	
	// 作品名称
	private TextView workName;
	
	// 作品详情
	private TextView workContent;
	
	// 多少人看好
	public TextView sayGoodNumber;
	
	// 多少人加入
	public TextView joinNumber;
	
	// 曝光度
	public TextView showTimes;
	
	// 类型：1——new 2——hot 0——normal
	public ImageView workTypes;
	
	// 是否收藏
	public ImageView isCollected;
	
	public FragmentHomeResourcesHolder(BaseActivity activity,
			PublishedWorkInfo t)
	{
		super(activity, t);
	}
	
	@Override
	public void onClick(View view)
	{
		if (view.getId() == R.id.fragment_home_list_relative)
		{
			// 跳转到详情界面
			Intent intent = new Intent(mActivity,
					PublishedWorkInfoActivity.class);
			mActivity.startActivity(intent);
		}
	}
	
	@Override
	protected View initView()
	{
		// 初始化界面View
		View view = mActivity.inflate(R.layout.fragment_home_list_item);
		
		// 初始化界面
		userSexImage = (ImageView) view
				.findViewById(R.id.fragment_home_list_user_sex_image);
		
		userName = (TextView) view
				.findViewById(R.id.fragment_home_list_text_user_name);
		
		heartNumber = (TextView) view
				.findViewById(R.id.fragment_home_list_text_hot_number);
		
		hotNumber = (ProgressBar) view
				.findViewById(R.id.fragment_home_list_hot_number);
		
		workName = (TextView) view
				.findViewById(R.id.fragment_home_list_text_work_name);
		
		workContent = (TextView) view
				.findViewById(R.id.fragment_home_list_text_work_content);
		
		sayGoodNumber = (TextView) view
				.findViewById(R.id.fragment_home_list_text_watch_num);
		
		joinNumber = (TextView) view
				.findViewById(R.id.fragment_home_list_text_join_number);
		
		showTimes = (TextView) view
				.findViewById(R.id.fragment_home_list_text_show_number);
		
		workTypes = (ImageView) view
				.findViewById(R.id.fragment_home_list_right_label);
		
		userIconPath = (ImageView) view
				.findViewById(R.id.fragment_my_list_view_item_user_icon);
		
		return view;
	}
	
	@SuppressWarnings ("deprecation")
	@Override
	protected void refreshView()
	{
		if (t.getUserSex() == 1)
		{
			// 男生
			userSexImage
					.setBackgroundResource(R.drawable.main_page_list_item_user_girl);
		}
		else
		{
			// 男生
			userSexImage.setBackgroundDrawable(mActivity.getResources()
					.getDrawable(R.drawable.main_page_list_item_user_girl));
		}
		userName.setText(t.getUserName());
		heartNumber.setText(t.getHeartNumber());
		hotNumber.setProgress(t.getHotNumber());
		
		workName.setText(t.getWorkName());
		workContent.setText(t.getWorkContent());
		sayGoodNumber.setText(t.getSayGoodNumber() + "人觉得很赞");
		joinNumber.setText(t.getJoinNumber() + "人加入");
		showTimes.setText("已经曝光" + t.getShowTimes() + "次");
		if (t.getWorkTypes() == 0)
		{
			// 普通
			workTypes.setBackgroundResource(0);
		}
		else if (t.getWorkTypes() == 1)
		{
			// new
			workTypes
					.setBackgroundResource(R.drawable.home_fragment_list_icon_new);
			
		}
		else if (t.getWorkTypes() == 2)
		{
			// hot
			workTypes
					.setBackgroundResource(R.drawable.home_fragment_list_icon_hot);
		}
		
		// ImageLoader 加载头像
	}
	
}
