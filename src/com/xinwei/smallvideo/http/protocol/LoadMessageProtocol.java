/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-30	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.http.protocol;

import java.util.ArrayList;
import java.util.List;

import com.xinwei.smallvideo.bean.FragmentMessageInfo;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 获取Message
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class LoadMessageProtocol
{
	
	private int resourceID[] = { R.drawable.tabbar_compose_camera,
			R.drawable.tabbar_compose_friend, R.drawable.tabbar_compose_idea,
			R.drawable.tabbar_compose_lbs, R.drawable.tabbar_compose_photo,
			R.drawable.tabbar_compose_review,
			R.drawable.tabbar_compose_shooting,
			R.drawable.tabbar_compose_transfer,
			R.drawable.tabbar_compose_voice,
			R.drawable.tabbar_compose_wbcamera, R.drawable.tabbar_compose_weibo };
	
	/**
	 * 获取消息列表
	 * 
	 * @return
	 */
	public List<FragmentMessageInfo> getMessageList()
	{
		List<FragmentMessageInfo> messageInfoList = new ArrayList<FragmentMessageInfo>();
		for (int i = 0; i < 10; i++)
		{
			FragmentMessageInfo messageInfo = new FragmentMessageInfo();
			messageInfo.setLastMessageDate("16:30");
			messageInfo.setMessageContent("赶紧砍树，赶紧干活");
			messageInfo.setMessageTitle("光头发的消息");
			messageInfo.setResourceID(resourceID[i]);
			messageInfo.setMessageNumber(i);
			messageInfoList.add(messageInfo);
		}
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return messageInfoList;
	}
}
