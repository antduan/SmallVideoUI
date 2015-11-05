/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-28	| Administrator 	| 	create the file                       
 */

package com.xinwei.smallvideo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinwei.smallvideo.activity.BaseActivity;
import com.xinwei.smallvideo.bean.FragmentMyListInfo;
import com.xinwei.smallvideoui.R;

/**
 * 
 * 我的界面
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author Administrator
 * 
 */

public class FragmentMyAdapter extends BaseAdapter
{
	private List<FragmentMyListInfo> menuList;
	
	private BaseActivity myContext;
	
	public FragmentMyAdapter(BaseActivity context)
	{
		super();
		this.myContext = context;
		
		menuList = new ArrayList<FragmentMyListInfo>();
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
		
		FragmentMyListInfo fragmentMyListInfo = menuList.get(position);
		
		if (convertView == null)
		{
			viewCache = new ViewCache();
			convertView = myContext
					.inflate(R.layout.fragment_my_layout_list_item);
			viewCache.menuIcon = (ImageView) convertView
					.findViewById(R.id.fragment_my_list_item_image);
			viewCache.menuName = (TextView) convertView
					.findViewById(R.id.fragment_my_list_item_text);
			viewCache.menuContent = (TextView) convertView
					.findViewById(R.id.fragment_my_list_item_text_content);
			
			viewCache.itemTopBlank = (TextView) convertView
					.findViewById(R.id.fragment_my_list_item_head);
			
			convertView.setTag(viewCache);
			
		}
		else
		{
			viewCache = (ViewCache) convertView.getTag();
		}
		
		TextView menuText = viewCache.menuName;
		ImageView menuIcon = viewCache.menuIcon;
		TextView mentTextContent = viewCache.menuContent;
		TextView itemBlank = viewCache.itemTopBlank;
		
		menuText.setText(fragmentMyListInfo.getMenuName());
		menuIcon.setBackgroundResource(fragmentMyListInfo.getResouceID());
		mentTextContent.setText(fragmentMyListInfo.getContent());
		
		if (fragmentMyListInfo.isShowTopBlack())
		{
			itemBlank.setVisibility(View.VISIBLE);
		}
		else
		{
			itemBlank.setVisibility(View.GONE);
		}
		
		return convertView;
	}
	
	public void updateMenu(List<FragmentMyListInfo> updateMenuList)
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
		
		private TextView menuContent;
		
		private TextView itemTopBlank;
	}
	
}
