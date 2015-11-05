/*
 * Copyright 2010 Beijing Xinwei, Inc. All rights reserved.
 * History:
 * -----------------------------------------------------------------------------
 * -
 * Date | Who | What
 * 2015-4-20 | duanbokan | create the file
 */

package com.xinwei.smallvideo.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xinwei.smallvideoui.R;

/**
 * 
 * android常用工具
 * 
 * <p>
 * Android一些常用工具
 * </p>
 * 
 * @author duanbokan
 * 
 */

public class PublicUtil
{
	// http请求超时时间
	private int HTTP_CON_TIME_OUT = 10 * 1000;
	
	// 单例对象
	private static PublicUtil instance;
	
	// Toast提示
	private Toast toastCustom;
	
	public static synchronized PublicUtil getInstance()
	{
		if (instance == null)
		{
			instance = new PublicUtil();
		}
		return instance;
	}
	
	/**
	 * 获取AppName
	 * 
	 * @param context
	 * @return
	 */
	public String getApplicationName(Context context)
	{
		PackageManager packageManager = null;
		ApplicationInfo applicationInfo = null;
		try
		{
			packageManager = context.getApplicationContext()
					.getPackageManager();
			applicationInfo = packageManager.getApplicationInfo(
					context.getPackageName(), 0);
		}
		catch (PackageManager.NameNotFoundException e)
		{
			applicationInfo = null;
		}
		String applicationName = (String) packageManager
				.getApplicationLabel(applicationInfo);
		return applicationName;
	}
	
	/**
	 * 判断是否有SD卡
	 * 
	 * @return
	 */
	public boolean isHasSdcard()
	{
		String status = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		if (status.equals(Environment.MEDIA_MOUNTED))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/***
	 * 自定义带背景的Toast
	 * 
	 * @param context
	 *            上下文
	 * @param content
	 *            显示的内容
	 * @param toastLength
	 *            Toast显示的时间 0代表系统默认短时间 1代表系统默认长时间
	 */
	
	public void showCustomToast(Context context, String content, int toastLength)
	{
		if (toastCustom != null)
		{
			toastCustom.cancel();
			toastCustom = null;
		}
		toastCustom = new Toast(context.getApplicationContext());
		LayoutInflater inflate = (LayoutInflater) context
				.getApplicationContext().getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
		View view = inflate.inflate(R.layout.personal_toast_dailog, null);
		TextView toast_tv = (TextView) view
				.findViewById(R.id.coogame_toast_content);
		toast_tv.setText(content);
		toastCustom.setView(view);
		toastCustom.setDuration(toastLength);
		toastCustom.show();
	}
	
	/***
	 * 获取栈顶Activity
	 * 
	 * @param context
	 * @return
	 */
	public String getTopActivity(Context context)
	{
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService("activity");
		List<RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
		if (runningTasks != null)
		{
			ComponentName topActivity = runningTasks.get(0).topActivity;
			return topActivity.getClassName();
		}
		else
		{
			return "";
		}
		
	}
	
	/***
	 * 获取屏幕尺寸及密度
	 * 
	 * @param context
	 * @return
	 */
	public DisplayMetrics getDisplayMetrics(Context context)
	{
		Resources mResources;
		if (context == null)
		{
			mResources = Resources.getSystem();
			
		}
		else
		{
			mResources = context.getResources();
		}
		DisplayMetrics mDisplayMetrics = mResources.getDisplayMetrics();
		return mDisplayMetrics;
	}
	
	/***
	 * 计算百分比
	 * 
	 * @param x
	 * @param total
	 * @return
	 */
	public String getPercent(int x, int total)
	{
		String result = "";
		double x_double = x * 1.0;
		double tempresult = x_double / total;
		// 百分比格式，后面不足2位的用0补齐 ##.00%
		DecimalFormat df1 = new DecimalFormat("0.00%");
		result = df1.format(tempresult);
		return result;
	}
	
	/***
	 * XML解析函数
	 * 
	 * @param inputStream
	 * @return
	 */
	public HashMap<String, String> parseXml(InputStream inputStream)
	{
		HashMap<String, String> hashMap = null;
		boolean flag = true;
		try
		{
			XmlPullParser pullParser = Xml.newPullParser();
			pullParser.setInput(inputStream, "UTF-8");
			int event = pullParser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT)
			{
				switch (event)
				{
					case XmlPullParser.START_DOCUMENT:
						hashMap = new HashMap<String, String>();
						break;
					case XmlPullParser.START_TAG:
						flag = true;
						String name = pullParser.getName();
						if ("VERSIONCODE".equalsIgnoreCase(name)
								&& flag == true)
						{
							hashMap.put("versionCode", pullParser.nextText()
									.trim());
						}
						else if ("FILENAME".equalsIgnoreCase(name)
								&& flag == true)
						{
							hashMap.put("fileName", pullParser.nextText()
									.trim());
						}
						else if ("LOADURL".equalsIgnoreCase(name)
								&& flag == true)
						{
							hashMap.put("loadUrl", pullParser.nextText().trim());
						}
						break;
					case XmlPullParser.END_TAG:
						flag = false;
						break;
				}
				event = pullParser.next();
			}
		}
		catch (XmlPullParserException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return hashMap;
	}
	
	/**
	 * HTTP使用Post方式请求
	 * 
	 * @param URL
	 *            访问的url
	 * @param params
	 *            参数
	 * @return
	 */
	public String httpPost(String URL, List<BasicNameValuePair> params)
	{
		HttpPost httpPost = new HttpPost(URL);
		String returnString = "";
		HttpParams httpParameters = new BasicHttpParams();
		
		try
		{
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(
					params, "utf-8");
			httpPost.setEntity(urlEncodedFormEntity);
			HttpConnectionParams.setConnectionTimeout(httpParameters,
					HTTP_CON_TIME_OUT);
			HttpClient httpClient = new DefaultHttpClient(httpParameters);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			InputStream inputStream = httpEntity.getContent();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					inputStream);
			ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(50);
			int current = 0;
			while ((current = bufferedInputStream.read()) != -1)
			{
				byteArrayBuffer.append(current);
			}
			returnString = EncodingUtils.getString(
					byteArrayBuffer.toByteArray(), "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return returnString;
		
	}
	
	public int dip2px(Context context, float dipValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}
	
	public int px2dip(Context context, float pxValue)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
	
	/**
	 * 将Bitmap转换为圆角
	 * 
	 * @param bitmap
	 * @return
	 */
	public Bitmap getRoundedCornerBitmap(Bitmap bitmap)
	{
		Bitmap output = null;
		if (bitmap != null)
		{
			output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
					Config.ARGB_8888);
			Canvas canvas = new Canvas(output);
			
			final int color = 0xff424242;
			final Paint paint = new Paint();
			final Rect rect = new Rect(0, 0, bitmap.getWidth(),
					bitmap.getHeight());
			final RectF rectF = new RectF(rect);
			final float roundPx = 12;
			
			paint.setAntiAlias(true);
			canvas.drawARGB(0, 0, 0, 0);
			paint.setColor(color);
			canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
			
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			canvas.drawBitmap(bitmap, rect, rect, paint);
		}
		
		return output;
	}
	
	/***
	 * 缩放或扩大图片大小
	 * 
	 * @param targetBitmap
	 * @param resultWidth
	 * @param resultHeight
	 * @return
	 */
	public Bitmap getScaleBitmap(Bitmap targetBitmap, float resultWidth,
			float resultHeight)
	{
		Bitmap resultBitmap = null;
		
		if (targetBitmap != null)
		{
			try
			{
				// 设置头像默认大小
				Matrix matrix = new Matrix();
				float w = resultWidth / targetBitmap.getWidth();
				float h = resultHeight / targetBitmap.getHeight();
				matrix.postScale(w, h);// 获取缩放比例
				resultBitmap = Bitmap.createBitmap(targetBitmap, 0, 0,
						targetBitmap.getWidth(), targetBitmap.getHeight(),
						matrix, true); // 根据缩放比例获取新的位图
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return resultBitmap;
	}
	
}
