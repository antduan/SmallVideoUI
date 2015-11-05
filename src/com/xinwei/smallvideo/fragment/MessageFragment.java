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
import com.xinwei.smallvideo.bean.FragmentMessageInfo;
import com.xinwei.smallvideo.constant.ConstantValue;
import com.xinwei.smallvideo.holder.FragmentMessageResourceHolder;
import com.xinwei.smallvideo.http.protocol.LoadMessageProtocol;
import com.xinwei.smallvideo.widget.LoadingPage.LoadResult;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 消息界面
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class MessageFragment extends BaseFragment implements
		OnLoadMoreListener<FragmentMessageInfo>
{
	// 数据源
	private List<FragmentMessageInfo> messageInfoList;
	
	public MessageFragment(BaseActivity activity)
	{
		super(activity);
	}
	
	public MessageFragment()
	{
		super();
	}
	
	@Override
	protected LoadResult loadData()
	{
		LoadMessageProtocol protocol = new LoadMessageProtocol();
		
		messageInfoList = protocol.getMessageList();
		
		if (messageInfoList == null)
		{
			return LoadResult.ERROR;
		}
		if (messageInfoList.size() <= 0)
		{
			return LoadResult.EMPTY;
		}
		return LoadResult.SUCCEED;
	}
	
	@Override
	protected View createLoadedView()
	{
		View view = mActivity.inflate(R.layout.fragment_message_layout);
		ListView contentListView = (ListView) view
				.findViewById(R.id.fragment_message_list_view);
		PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) view
				.findViewById(R.id.fragment_message_ptr_frame_layout);
		initPtrFrameLayout(ptrFrameLayout);
		
		BaseListAdapter<FragmentMessageInfo> mAdapter = new BaseListAdapter<FragmentMessageInfo>(
				mActivity, messageInfoList, FragmentMessageResourceHolder.class);
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
	public List<FragmentMessageInfo> OnLoadMore(int starIndex)
	{
		LoadMessageProtocol protocol = new LoadMessageProtocol();
		List<FragmentMessageInfo> messageList = protocol.getMessageList();
		return messageList;
	}
}
