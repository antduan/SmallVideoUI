package com.xinwei.smallvideo.fragment;

import com.xinwei.smallvideo.activity.BaseActivity;

public class FragmentFactory
{
	// 每一个ID对应一个界面
	public static final int ALL = 0;
	
	public static final int CLASSIFY = 1;
	
	public static final int RECOMMEND = 2;
	
	public static final int MY = 3;
	
	public static final int MESSAGE = 4;
	
	public static BaseFragment createFragment(int subId, BaseActivity context)
	{
		BaseFragment fragment = null;
		switch (subId)
		{
		// 根据ID创建对应界面
			case ALL:
				fragment = new HomeFragment(context);
				break;
			case CLASSIFY:
				fragment = new HotRankFragment(context);
				break;
			case RECOMMEND:
				fragment = new RecommendFragment(context);
				break;
			case MY:
				fragment = new MyFragment(context);
				break;
			case MESSAGE:
				fragment = new MessageFragment(context);
				break;
			default:
				break;
		}
		return fragment;
	}
	
}
