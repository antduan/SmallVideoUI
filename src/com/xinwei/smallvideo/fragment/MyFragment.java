/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-9	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.R.menu;
import android.view.View;
import android.widget.ListView;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.adapter.FragmentMyAdapter;
import com.xinwei.smallvideo.bean.FragmentMyListInfo;
import com.xinwei.smallvideo.holder.FragmentMyMenuHolder;
import com.xinwei.smallvideo.holder.MenuHeaderHolder;
import com.xinwei.smallvideo.widget.LoadingPage.LoadResult;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 我的界面
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class MyFragment extends BaseFragment
{
	List<FragmentMyListInfo> myMenuList;
	
	private FragmentMyAdapter myMenuAdapter;
	
	private FragmentMyMenuHolder menuHeaderHolder;
	
	public MyFragment(BaseActivity activity)
	{
		super(activity);
		myMenuAdapter = new FragmentMyAdapter(activity);
	}
	
	public MyFragment()
	{
		super();
	}
	
	@Override
	protected LoadResult loadData()
	{
		myMenuList = new ArrayList<FragmentMyListInfo>();
		myMenuList.add(new FragmentMyListInfo("新的好友",
				R.drawable.tabbar_compose_friend, "", 0, true));
		myMenuList.add(new FragmentMyListInfo("我的收藏 ",
				R.drawable.tabbar_compose_weibo, "", 1, false));
		myMenuList.add(new FragmentMyListInfo("我的相册",
				R.drawable.tabbar_compose_camera, "", 2, true));
		myMenuList.add(new FragmentMyListInfo("我的点评",
				R.drawable.tabbar_compose_shooting, "", 3, false));
		myMenuList.add(new FragmentMyListInfo("我的赞",
				R.drawable.tabbar_compose_transfer, "", 4, false));
		myMenuList.add(new FragmentMyListInfo("赞我的",
				R.drawable.tabbar_compose_voice, "", 5, true));
		myMenuList.add(new FragmentMyListInfo("光头强",
				R.drawable.tabbar_compose_review, "", 6, false));
		myMenuList.add(new FragmentMyListInfo("喜洋洋",
				R.drawable.tabbar_compose_lbs, "", 7, false));
		
		if (myMenuList == null)
		{
			return LoadResult.ERROR;
		}
		if (myMenuList.size() <= 0)
		{
			return LoadResult.EMPTY;
		}
		return LoadResult.SUCCEED;
		
	}
	
	@Override
	protected View createLoadedView()
	{
		View view = mActivity.inflate(R.layout.fragment_my_layout);
		
		ListView contentListView = (ListView) view
				.findViewById(R.id.fragment_my_list_view);
		
		// 左侧菜单栏头部
		menuHeaderHolder = new FragmentMyMenuHolder(mActivity);
		contentListView.addHeaderView(menuHeaderHolder.getRootView());
		contentListView.setAdapter(myMenuAdapter);
		myMenuAdapter.updateMenu(myMenuList);
		menuHeaderHolder.updateView();
		return view;
	}
}
