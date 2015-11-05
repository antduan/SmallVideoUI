/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-26	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.adapter;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.fragment.BaseFragment;
import com.xinwei.smallvideo.fragment.FragmentFactory;
import com.xinwei.smallvideo.widget.PagerSlidingTabStrip.IconTabProvider;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 类简要描述
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class MainPageAdapter extends FragmentPagerAdapter implements
		OnPageChangeListener , IconTabProvider
{
	// Android上下文
	private BaseActivity myContext;
	
	// 标题的名称
	private String[] tabsTitleName;
	
	// 对应的Fragment页面
	private BaseFragment[] mFragments;
	
	// 每一页的图片
	private Drawable[] iconPageRes;
	
	// 每一页的图片_ID
	private int[] iconPageResID;
	
	// 当前页面
	private int mCurrentIndex;
	
	public MainPageAdapter(BaseActivity context, FragmentManager fm)
	{
		super(fm);
		myContext = context;
		
		// 获取标题名称
		tabsTitleName = myContext.getResources().getStringArray(
				R.array.main_page_tabs_title_name);
		
		// 每一个标题对应一个页面
		mFragments = new BaseFragment[tabsTitleName.length];
		
		// 初始化底部菜单栏图标
		iconPageRes = new Drawable[3];
		
		iconPageRes[0] = myContext
				.getMyDrawable(R.drawable.main_page_bottom_tab_home_selector);
		iconPageRes[1] = myContext
				.getMyDrawable(R.drawable.main_page_bottom_tab_add_selector);
		iconPageRes[2] = myContext
				.getMyDrawable(R.drawable.main_page_bottom_tab_my_selector);
		
		iconPageResID = new int[3];
		iconPageResID[0] = R.drawable.main_page_bottom_tab_home_selector;
		iconPageResID[1] = R.drawable.main_page_bottom_tab_add_selector;
		iconPageResID[2] = R.drawable.main_page_bottom_tab_my_selector;
	}
	
	@Override
	public CharSequence getPageTitle(int position)
	{
		// 返回当前界面标题
		return tabsTitleName[position];
	}
	
	@Override
	public void onPageScrollStateChanged(int state)
	{
		// ViewPager滑动状态改变的回调
	}
	
	@Override
	public void onPageScrolled(int index, float offset, int offsetPx)
	{
		// ViewPager滑动时的回调
	}
	
	@Override
	public void onPageSelected(int index)
	{
		// ViewPager页面被选中的回调
		if (index < mFragments.length)
		{
			if (mFragments[index] != null)
			{
				mFragments[index].show();
			}
			else
			{
				mCurrentIndex = index;
			}
		}
	}
	
	@Override
	public Fragment getItem(int position)
	{
		// 判断当前显示界面是否为空，为空则进行创建
		if (mFragments[position] == null
				|| !(mFragments[position] instanceof BaseFragment))
		{
			// 根据ID创建fragment界面
			mFragments[position] = FragmentFactory.createFragment(position,
					myContext);
		}
		// 当前界面不为空,直接展示
		if (position == mCurrentIndex)
		{
			mCurrentIndex = -1;
			mFragments[position].show();
		}
		
		return mFragments[position];
	}
	
	@Override
	public int getCount()
	{
		return tabsTitleName.length;
	}
	
	/*
	 * 获取自定义菜单界面
	 * 
	 * @see com.xinwei.smallvideo.widget.PagerSlidingTabStrip.IconTabProvider#
	 * getPersonalTabView(int)
	 */
	@Override
	public View getPersonalTabView(int position)
	{
		View view = myContext.inflate(R.layout.main_page_person_tab_view);
		ImageView tabImage = (ImageView) view
				.findViewById(R.id.main_page_tab_imageview);
		TextView tabTextView = (TextView) view
				.findViewById(R.id.main_page_tab_textview);
		
		switch (position)
		{
			case 0:
				tabImage.setBackgroundDrawable(iconPageRes[0]);
				tabTextView.setText(tabsTitleName[0]);
				break;
			case 1:
				tabImage.setBackgroundDrawable(iconPageRes[1]);
				tabTextView.setText(tabsTitleName[1]);
				break;
			case 2:
				tabImage.setBackgroundDrawable(iconPageRes[2]);
				tabTextView.setText(tabsTitleName[2]);
				break;
			default:
				break;
		}
		
		return view;
	}
	
	public int getIconResId(int index)
	{
		
		int resourceID = 0;
		switch (index)
		{
			case 0:
				resourceID = 0;
				break;
			case 1:
				resourceID = 1;
				break;
			case 2:
				resourceID = 2;
				break;
			default:
				break;
		}
		
		return iconPageResID[resourceID];
	}
	
}
