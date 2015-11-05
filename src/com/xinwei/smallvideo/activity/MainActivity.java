/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-26	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.xinwei.smallvideo.adapter.MainPageLeftMenuAdapter;
import com.xinwei.smallvideo.bean.MainPageLeftMenuInfo;
import com.xinwei.smallvideo.fragment.BaseFragment;
import com.xinwei.smallvideo.fragment.HomeFragment;
import com.xinwei.smallvideo.fragment.HotRankFragment;
import com.xinwei.smallvideo.fragment.MessageFragment;
import com.xinwei.smallvideo.fragment.MyFragment;
import com.xinwei.smallvideo.holder.MenuHeaderHolder;
import com.xinwei.smallvideo.utils.PublicUtil;
import com.xinwei.smallvideo.widget.ActionBarDrawerToggle;
import com.xinwei.smallvideo.widget.DrawerArrowDrawable;
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
public class MainActivity extends BaseActivity
{
	private static final String TAG = "MainActivity";
	
	// 图片
	private ImageView homeImageView, hotRankImageView, messageImageView,
			myImageView, addImageView;
	
	// 主页
	private BaseFragment homeFragment;
	
	private FrameLayout homeFrameLayout;
	
	// 热门
	private BaseFragment hotRankFragment;
	
	private FrameLayout hotRankFrameLayout;
	
	// 消息
	private BaseFragment messageFragment;
	
	private FrameLayout messageFrameLayout;
	
	// 我的
	private BaseFragment myFragment;
	
	private FrameLayout myFrameLayout;
	
	private long exitTime = 0;
	
	// 左侧弹出界面开关
	private ActionBarDrawerToggle mDrawerToggle;
	
	// 左侧弹出界面时，动画
	private DrawerArrowDrawable drawerArrow;
	
	// 左侧抽屉
	private DrawerLayout myDrawerLayout;
	
	// DrawerLayout需要添加
	private ListView mDrawerListView;
	
	private MenuHeaderHolder menuHeaderHolder;
	
	// 左侧菜单Item
	private MainPageLeftMenuAdapter menuAdapter;
	
	// 左侧菜单
	private List<MainPageLeftMenuInfo> menuList;
	
	@Override
	protected void initLoadView()
	{
		setContentView(R.layout.activity_main);
		
		initView();
		
		setOnListener();
	}
	
	/**
	 * 初始化界面
	 */
	private void initView()
	{
		homeFrameLayout = (FrameLayout) findViewById(R.id.main_page_bottom_frame_home);
		hotRankFrameLayout = (FrameLayout) findViewById(R.id.main_page_bottom_frame_hot_rank);
		messageFrameLayout = (FrameLayout) findViewById(R.id.main_page_bottom_frame_message);
		myFrameLayout = (FrameLayout) findViewById(R.id.main_page_bottom_frame_my);
		
		homeImageView = (ImageView) findViewById(R.id.main_page_bottom_frame_home_image);
		hotRankImageView = (ImageView) findViewById(R.id.main_page_bottom_frame_hot_rank_image);
		messageImageView = (ImageView) findViewById(R.id.main_page_bottom_frame_message_image);
		myImageView = (ImageView) findViewById(R.id.main_page_bottom_frame_my_image);
		addImageView = (ImageView) findViewById(R.id.main_page_bottom_add);
		
		// 初始化默认界面为主页
		setHomeClick();
		
		menuAdapter = new MainPageLeftMenuAdapter(MainActivity.this);
		
		menuList = new ArrayList<MainPageLeftMenuInfo>();
		menuList.add(new MainPageLeftMenuInfo("我的收藏",
				R.drawable.main_page_left_menu_ico_favorite, 0));
		menuList.add(new MainPageLeftMenuInfo("猜你喜欢",
				R.drawable.main_page_left_menu_ico_new, 1));
		menuList.add(new MainPageLeftMenuInfo("提供素材",
				R.drawable.main_page_left_menu_ico_upload, 2));
		menuList.add(new MainPageLeftMenuInfo("联系我们",
				R.drawable.main_page_left_menu_ico_feedback, 3));
		menuList.add(new MainPageLeftMenuInfo("我的设置",
				R.drawable.main_page_left_menu_ico_setting, 4));
	}
	
	@Override
	protected void initActionBar()
	{
		// 标题栏
		mActionBar = getSupportActionBar();
		mActionBar.setIcon(android.R.color.transparent);
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mActionBar.setHomeButtonEnabled(true);
		
		// 左侧菜单栏头部
		menuHeaderHolder = new MenuHeaderHolder(this);
		
		// 左侧导航抽屉布局
		mDrawerListView = (ListView) findViewById(R.id.main_page_left_slide_list);
		
		mDrawerListView.addHeaderView(menuHeaderHolder.getRootView());
		mDrawerListView.setFooterDividersEnabled(false);
		mDrawerListView.setAdapter(menuAdapter);
		menuAdapter.updateMenu(menuList);
		
		
		// 初始化布局
		myDrawerLayout = (DrawerLayout) findViewById(R.id.main_page_drawer_layout);
		
		// 初始化抽屉
		drawerArrow = new DrawerArrowDrawable(this)
		{
			@Override
			public boolean isLayoutRtl()
			{
				return false;
			}
		};
		// 左侧导航抽屉标题
		mDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout,
				drawerArrow, R.string.main_page_drawer_open,
				R.string.main_page_drawer_close)
		{
			@Override
			public void onDrawerOpened(View drawerView)
			{
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
			}
			
			@Override
			public void onDrawerClosed(View drawerView)
			{
				super.onDrawerClosed(drawerView);
				invalidateOptionsMenu();
			}
			
		};
		
		myDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerToggle.syncState();
	}
	
	/**
	 * 添加按键监听
	 */
	private void setOnListener()
	{
		homeFrameLayout.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				setHomeClick();
			}
		});
		
		hotRankFrameLayout.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// 实例化Fragment页面
				hotRankFragment = new HotRankFragment(MainActivity.this);
				// 得到Fragment事务管理器
				FragmentTransaction fragmentTransaction = getSupportFragmentManager()
						.beginTransaction();
				// 替换当前的页面
				fragmentTransaction.replace(R.id.main_page_real_page_view,
						hotRankFragment);
				// 事务管理提交
				fragmentTransaction.commit();
				
				// 展示界面
				hotRankFragment.show();
				
				// 改变选中状态
				homeImageView.setSelected(false);
				hotRankImageView.setSelected(true);
				messageImageView.setSelected(false);
				myImageView.setSelected(false);
				
				mActionBar.setTitle("热门");
			}
		});
		
		messageFrameLayout.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// 实例化Fragment页面
				messageFragment = new MessageFragment(MainActivity.this);
				// 得到Fragment事务管理器
				FragmentTransaction fragmentTransaction = getSupportFragmentManager()
						.beginTransaction();
				// 替换当前的页面
				fragmentTransaction.replace(R.id.main_page_real_page_view,
						messageFragment);
				// 事务管理提交
				fragmentTransaction.commit();
				
				// 展示界面
				messageFragment.show();
				
				// 改变选中状态
				homeImageView.setSelected(false);
				hotRankImageView.setSelected(false);
				messageImageView.setSelected(true);
				myImageView.setSelected(false);
				
				mActionBar.setTitle("消息");
			}
		});
		
		myFrameLayout.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// 实例化Fragment页面
				myFragment = new MyFragment(MainActivity.this);
				// 得到Fragment事务管理器
				FragmentTransaction fragmentTransaction = getSupportFragmentManager()
						.beginTransaction();
				// 替换当前的页面
				fragmentTransaction.replace(R.id.main_page_real_page_view,
						myFragment);
				// 事务管理提交
				fragmentTransaction.commit();
				
				// 展示界面
				myFragment.show();
				
				// 改变选中状态
				homeImageView.setSelected(false);
				hotRankImageView.setSelected(false);
				messageImageView.setSelected(false);
				myImageView.setSelected(true);
				
				mActionBar.setTitle("我的");
			}
		});
		
		addImageView.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, PublishMyWorkActivity.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId() == android.R.id.home)
		{
			if (myDrawerLayout.isDrawerOpen(mDrawerListView))
			{
				myDrawerLayout.closeDrawer(mDrawerListView);
			}
			else
			{
				myDrawerLayout.openDrawer(mDrawerListView);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public void onBackPressed()
	{
		if (myDrawerLayout.isDrawerOpen(mDrawerListView))
		{
			myDrawerLayout.closeDrawer(mDrawerListView);
		}
		else
		{
			if ((System.currentTimeMillis() - exitTime) > 2000)
			{
				PublicUtil.getInstance().showCustomToast(
						getApplicationContext(), "再按一次退出程序", 1);
				exitTime = System.currentTimeMillis();
			}
			else
			{
				finish();
			}
		}
	}
	
	/**
	 * 主页按钮按下的效果
	 */
	private void setHomeClick()
	{
		// 实例化Fragment页面
		homeFragment = new HomeFragment(MainActivity.this);
		// 得到Fragment事务管理器
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		// 替换当前的页面
		fragmentTransaction
				.replace(R.id.main_page_real_page_view, homeFragment);
		// 事务管理提交
		fragmentTransaction.commit();
		
		homeFragment.show();
		
		// 改变选中状态
		homeImageView.setSelected(true);
		hotRankImageView.setSelected(false);
		messageImageView.setSelected(false);
		myImageView.setSelected(false);
		
		mActionBar.setTitle("主页");
	}
}
