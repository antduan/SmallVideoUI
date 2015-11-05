/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-28	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.http.protocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xinwei.smallvideo.bean.PublishedWorkInfo;

/**
 * 
 * 加载已经发布的信息
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class LoadPublishedWorksProtocol
{
	/***
	 * 获取发布的信息
	 * 
	 * @return
	 */
	public List<PublishedWorkInfo> getPublishWorkInfo(int startNum)
	{
		List<PublishedWorkInfo> publishedWorkList = new ArrayList<PublishedWorkInfo>();
		
		Random random = new Random();
		for (int i = startNum; i < startNum + 10; i++)
		{
			PublishedWorkInfo info = new PublishedWorkInfo();
			info.setUserName("蚂蚁梦想家");
			info.setUserSex(1);
			info.setHeartNumber("60");
			info.setHotNumber(80);
			info.setWorkName("我的作品");
			info.setWorkContent("没错，你看到的就是我作品的详细信息，爱投不投");
			info.setShowTimes("35660");
			info.setSayGoodNumber("19850");
			info.setJoinNumber("256328");
			if (i == startNum)
			{
				info.setWorkTypes(1);
			}
			else if (i == startNum + 1)
			{
				info.setWorkTypes(2);
			}
			else
			{
				info.setWorkTypes(0);
			}
			publishedWorkList.add(info);
		}
		
		// 模拟网络请求耗时
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return publishedWorkList;
	}
}
