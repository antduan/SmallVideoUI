/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-6-18	| duanbokan 	| 	create the file                       
 */

package com.xinwei.smallvideo.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

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

public class ViewUtils
{
	
	public static void removeSelfFromParent(View view)
	{
		if (view != null)
		{
			ViewParent parent = view.getParent();
			if (parent != null && parent instanceof ViewGroup)
			{
				ViewGroup group = (ViewGroup) parent;
				group.removeView(view);
			}
		}
	}
	
	public static void requestLayoutParent(View view, boolean isAll)
	{
		ViewParent parent = view.getParent();
		while (parent != null && parent instanceof View)
		{
			if (!parent.isLayoutRequested())
			{
				parent.requestLayout();
				if (!isAll)
				{
					break;
				}
			}
			parent = parent.getParent();
		}
	}
	
	public static boolean isTouchInView(MotionEvent ev, View v)
	{
		int[] vLoc = new int[2];
		v.getLocationOnScreen(vLoc);
		float motionX = ev.getRawX();
		float motionY = ev.getRawY();
		return motionX >= vLoc[0] && motionX <= (vLoc[0] + v.getWidth())
				&& motionY >= vLoc[1] && motionY <= (vLoc[1] + v.getHeight());
	}
	
	public static <T> T findViewById(View layout, int id)
	{
		return (T) layout.findViewById(id);
	}
	
	public static void dip2px()
	{
		
	}
	
	public static void px2dip()
	{
		
	}
	
}
