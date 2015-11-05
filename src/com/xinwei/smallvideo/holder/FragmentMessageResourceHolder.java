/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-30	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.bean.FragmentMessageInfo;
import com.xinwei.smallvideo.utils.PublicUtil;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 加载消息数据
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class FragmentMessageResourceHolder extends
		BaseHolder<FragmentMessageInfo>
{
	private ImageView messageIcon;
	
	private TextView messageName;
	
	private TextView messageContent;
	
	private TextView messageDate;
	
	// 小红点
	private ImageView readBoll;
	
	public FragmentMessageResourceHolder(BaseActivity activity,
			FragmentMessageInfo t)
	{
		super(activity, t);
	}
	
	@Override
	public void onClick(View arg0)
	{
		PublicUtil.getInstance().showCustomToast(mActivity, "点不进去，点不进去，点不进去。。",
				1);
	}
	
	@Override
	protected View initView()
	{
		View view = mActivity.inflate(R.layout.fragment_message_list_item);
		
		// 初始化界面
		messageIcon = (ImageView) view
				.findViewById(R.id.fragment_message_list_item_image);
		messageName = (TextView) view
				.findViewById(R.id.fragment_message_list_item_text);
		
		messageContent = (TextView) view
				.findViewById(R.id.fragment_message_list_item_text_content);
		
		messageDate = (TextView) view
				.findViewById(R.id.fragment_message_list_item_date);
		
		readBoll = (ImageView) view
				.findViewById(R.id.fragment_message_list_item_text_message_number);
		
		return view;
	}
	
	@Override
	protected void refreshView()
	{
		// 更新界面
		if (t.getMessageNumber() > 2)
		{
			readBoll.setVisibility(View.VISIBLE);
		}
		else
		{
			readBoll.setVisibility(View.GONE);
		}
		
		messageIcon.setBackgroundResource(t.getResourceID());
		messageName.setText(t.getMessageTitle());
		messageContent.setText(t.getMessageContent());
		messageDate.setText(t.getLastMessageDate());
	}
	
}
