/*      						
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * 
 * History:
 * ------------------------------------------------------------------------------
 * Date    	|  Who  		|  What  
 * 2015-10-30	| Administrator 	| 	create the file                       
 */

package com.xinwei.smallvideo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.xinwei.smallvideoui.R;

/**
 * 
 * 进入应用时的闪屏界面
 * 
 * <p>
 * 类详细描述
 * </p>
 * 
 * @author Administrator
 * 
 */

public class SplashActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		mHandler.postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		}, 3000);
	}
	
	private Handler mHandler = new Handler()
	{
		public void handleMessage(android.os.Message msg)
		{
			
		};
	};
}
