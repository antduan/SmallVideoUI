/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-27	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.sax.StartElementListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.activity.SettingActivity;
import com.xinwei.smallvideo.bean.MainPageLeftMenuInfo;
import com.xinwei.smallvideo.utils.PublicUtil;
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

public class MainPageLeftMenuAdapter extends BaseAdapter implements
		OnClickListener
{
	private List<MainPageLeftMenuInfo> menuList;
	
	private BaseActivity myContext;
	
	public MainPageLeftMenuAdapter(BaseActivity context)
	{
		super();
		this.myContext = context;
		
		menuList = new ArrayList<MainPageLeftMenuInfo>();
	}
	
	@Override
	public int getCount()
	{
		return menuList.size();
	}
	
	@Override
	public Object getItem(int position)
	{
		return menuList.get(position);
	}
	
	@Override
	public long getItemId(int position)
	{
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup)
	{
		ViewCache viewCache = null;
		
		MainPageLeftMenuInfo mainPageLeftMenuInfo = menuList.get(position);
		
		if (convertView == null)
		{
			viewCache = new ViewCache();
			convertView = myContext
					.inflate(R.layout.main_page_slide_drawer_list_item);
			viewCache.menuIcon = (ImageView) convertView
					.findViewById(R.id.main_page_slide_list_item_image);
			viewCache.menuName = (TextView) convertView
					.findViewById(R.id.main_page_slide_list_item_text);
			viewCache.relativeLayout = (RelativeLayout) convertView
					.findViewById(R.id.main_page_slide_list_item_relative);
			convertView.setTag(viewCache);
			
		}
		else
		{
			viewCache = (ViewCache) convertView.getTag();
		}
		
		TextView menuText = viewCache.menuName;
		ImageView menuIcon = viewCache.menuIcon;
		RelativeLayout relativeLayout = viewCache.relativeLayout;
		
		menuText.setText(mainPageLeftMenuInfo.getName());
		menuIcon.setBackgroundResource(mainPageLeftMenuInfo.getResourceID());
		relativeLayout.setId(mainPageLeftMenuInfo.getMenuID());
		
		relativeLayout.setOnClickListener(this);
		
		return convertView;
	}
	
	public void updateMenu(List<MainPageLeftMenuInfo> updateMenuList)
	{
		if (updateMenuList != null && updateMenuList.size() > 0)
		{
			menuList = updateMenuList;
			notifyDataSetChanged();
		}
	}
	
	private class ViewCache
	{
		private ImageView menuIcon;
		
		private TextView menuName;
		
		private RelativeLayout relativeLayout;
	}
	
	@Override
	public void onClick(View view)
	{
		switch (view.getId())
		{
			case 0:
				// 我的收藏
				PublicUtil.getInstance().showCustomToast(myContext,
						"别费劲了，只有我的设置可以点击", 1);
				break;
			case 1:
				// 猜你喜欢
				PublicUtil.getInstance().showCustomToast(myContext,
						"别费劲了，只有我的设置可以点击", 1);
				break;
			case 2:
				// 提供素材
				PublicUtil.getInstance().showCustomToast(myContext,
						"别费劲了，只有我的设置可以点击", 1);
				break;
			case 3:
				// 联系我们
				PublicUtil.getInstance().showCustomToast(myContext,
						"别费劲了，只有我的设置可以点击", 1);
				break;
			case 4:
				// 我的设置
				Intent intent = new Intent();
				intent.setClass(myContext, SettingActivity.class);
				myContext.startActivity(intent);
				myContext.int4Right();
				break;
			
			default:
				break;
		}
	}
}
