package com.xinwei.smallvideo.fragment;

import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.utils.ViewUtils;
import com.xinwei.smallvideo.widget.LoadingPage;
import com.xinwei.smallvideo.widget.LoadingPage.LoadResult;

public abstract class BaseFragment extends Fragment
{
	protected BaseActivity mActivity;
	
	protected LoadingPage mContentView;
	
	protected int index = 1;
	
	protected int pageSize = 10;
	
	protected HashMap<String, String> params;
	
	public BaseFragment(BaseActivity activity)
	{
		mActivity = activity;
		mContentView = new LoadingPage(mActivity)
		{
			@Override
			public LoadResult load()
			{
				return BaseFragment.this.loadData();
			}
			
			@Override
			public View createLoadedView()
			{
				return BaseFragment.this.createLoadedView();
			}
		};
	}
	
	public BaseFragment()
	{
		super();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		ViewUtils.removeSelfFromParent(mContentView);
		return mContentView;
	}
	
	public void update()
	{
	}
	
	public void show()
	{
		if (mContentView != null)
		{
			mContentView.show();
		}
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
	}
	
	protected abstract LoadResult loadData();
	
	protected abstract View createLoadedView();
}
