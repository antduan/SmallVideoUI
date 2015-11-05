/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-26	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.fragment;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

import java.util.List;

import android.view.View;
import android.widget.ListView;

import com.nhaarman.listviewanimations.appearance.simple.RotateBottomAnimationAdapter;
import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.adapter.BaseListAdapter;
import com.xinwei.smallvideo.adapter.BaseListAdapter.OnLoadMoreListener;
import com.xinwei.smallvideo.bean.PublishedWorkInfo;
import com.xinwei.smallvideo.constant.ConstantValue;
import com.xinwei.smallvideo.holder.FragmentHomeResourcesHolder;
import com.xinwei.smallvideo.http.protocol.LoadPublishedWorksProtocol;
import com.xinwei.smallvideo.widget.LoadingPage.LoadResult;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 主页——第一个界面
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */
public class HomeFragment extends BaseFragment implements
		OnLoadMoreListener<PublishedWorkInfo>
{
	// 加载的列表
	private List<PublishedWorkInfo> publishedWorkList;
	
	private int currentNum = 0;
	
	public HomeFragment(BaseActivity activity)
	{
		super(activity);
	}
	
	public HomeFragment()
	{
		super();
	}
	
	@Override
	protected LoadResult loadData()
	{
		LoadPublishedWorksProtocol protocol = new LoadPublishedWorksProtocol();
		
		publishedWorkList = protocol.getPublishWorkInfo(currentNum);
		
		currentNum = currentNum + 10;
		
		if (publishedWorkList == null)
		{
			return LoadResult.ERROR;
		}
		if (publishedWorkList.size() <= 0)
		{
			return LoadResult.EMPTY;
		}
		return LoadResult.SUCCEED;
	}
	
	@Override
	protected View createLoadedView()
	{
		View view = mActivity.inflate(R.layout.fragment_home_layout);
		ListView contentListView = (ListView) view
				.findViewById(R.id.home_fragment_list_view);
		
		PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) view
				.findViewById(R.id.fragment_ptr_home_ptr_frame);
		initPtrFrameLayout(ptrFrameLayout);
		
		BaseListAdapter<PublishedWorkInfo> mAdapter = new BaseListAdapter<PublishedWorkInfo>(
				mActivity, publishedWorkList, FragmentHomeResourcesHolder.class);
		mAdapter.setOnLoadMoreListener(this);
		
		RotateBottomAnimationAdapter swingBottomInAnimationAdapter = new RotateBottomAnimationAdapter(
				mAdapter);
		swingBottomInAnimationAdapter.setAbsListView(contentListView);
		
		assert swingBottomInAnimationAdapter.getViewAnimator() != null;
		swingBottomInAnimationAdapter.getViewAnimator().setInitialDelayMillis(
				ConstantValue.INITIAL_DELAY_MILLIS);
		
		contentListView.setAdapter(swingBottomInAnimationAdapter);
		
		return view;
	}
	
	private void initPtrFrameLayout(final PtrFrameLayout ptrFrameLayout)
	{
		final StoreHouseHeader header = new StoreHouseHeader(mActivity);
		header.setPadding(0, mActivity.dip2px(15), 0, mActivity.dip2px(15));
		header.initWithString(ConstantValue.PULL_STRING);
		
		ptrFrameLayout.setDurationToCloseHeader(2000);
		ptrFrameLayout.setHeaderView(header);
		ptrFrameLayout.addPtrUIHandler(header);
		ptrFrameLayout.setPtrHandler(new PtrHandler()
		{
			@Override
			public boolean checkCanDoRefresh(PtrFrameLayout frame,
					View content, View header)
			{
				return PtrDefaultHandler.checkContentCanBePulledDown(
						ptrFrameLayout, content, header);
			}
			
			@Override
			public void onRefreshBegin(PtrFrameLayout frame)
			{
				ptrFrameLayout.postDelayed(new Runnable()
				{
					@Override
					public void run()
					{
						ptrFrameLayout.refreshComplete();
					}
				}, 1500);
			}
		});
	}
	
	@Override
	public List<PublishedWorkInfo> OnLoadMore(int starIndex)
	{
		LoadPublishedWorksProtocol protocol = new LoadPublishedWorksProtocol();
		protocol.getPublishWorkInfo(currentNum);
		return null;
	}
}
