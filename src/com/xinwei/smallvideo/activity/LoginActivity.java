package com.xinwei.smallvideo.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinwei.smallvideo.country.CharacterParserUtil;
import com.xinwei.smallvideo.country.CountryActivity;
import com.xinwei.smallvideo.country.CountrySortModel;
import com.xinwei.smallvideo.country.GetCountryNameSort;
import com.xinwei.smallvideoui.R;

public class LoginActivity extends BaseActivity
{
	
	private String TAG = "XINWEI";
	
	private RelativeLayout relative_choseCountry;
	
	private EditText editText_countryNum;
	
	private TextView tv_countryName;
	
	private TextView loginPassWord;
	
	private TextView loginPhoneNumber;
	
	private GetCountryNameSort countryChangeUtil;
	
	private CharacterParserUtil characterParserUtil;
	
	private List<CountrySortModel> mAllCountryList;
	
	String beforText = null;
	
	@Override
	protected void initLoadView()
	{
		setContentView(R.layout.activity_login);
		
		initLoginView();
		initCountryList();
		setListener();
	}
	
	/**
	 * 初始化界面布局
	 */
	private void initLoginView()
	{
		relative_choseCountry = (RelativeLayout) findViewById(R.id.rala_chose_country);
		editText_countryNum = (EditText) findViewById(R.id.edt_chosed_country_num);
		tv_countryName = (TextView) findViewById(R.id.tv_chosed_country);
		loginPassWord = (TextView) findViewById(R.id.activity_login_et_password);
		loginPhoneNumber = (TextView) findViewById(R.id.activity_login_et_usertel);
		
		mAllCountryList = new ArrayList<CountrySortModel>();
		countryChangeUtil = new GetCountryNameSort();
		characterParserUtil = new CharacterParserUtil();
		
	}
	
	/**
	 * 初始化国家码
	 */
	private void initCountryList()
	{
		String[] countryList = getResources().getStringArray(
				R.array.country_code_list_ch);
		
		for (int i = 0, length = countryList.length; i < length; i++)
		{
			String[] country = countryList[i].split("\\*");
			
			String countryName = country[0];
			String countryNumber = country[1];
			String countrySortKey = characterParserUtil.getSelling(countryName);
			CountrySortModel countrySortModel = new CountrySortModel(
					countryName, countryNumber, countrySortKey);
			String sortLetter = countryChangeUtil
					.getSortLetterBySortKey(countrySortKey);
			if (sortLetter == null)
			{
				sortLetter = countryChangeUtil
						.getSortLetterBySortKey(countryName);
			}
			
			countrySortModel.sortLetters = sortLetter;
			mAllCountryList.add(countrySortModel);
		}
		
	}
	
	/**
	 * 添加监听
	 */
	private void setListener()
	{
		relative_choseCountry.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, CountryActivity.class);
				startActivityForResult(intent, 12);
			}
		});
		
		editText_countryNum.addTextChangedListener(new TextWatcher()
		{
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count)
			{
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after)
			{
				beforText = s.toString();
			}
			
			@Override
			public void afterTextChanged(Editable s)
			{
				String contentString = editText_countryNum.getText().toString();
				
				CharSequence contentSeq = editText_countryNum.getText();
				
				Log.i(TAG, "contentString :" + contentString.length());
				
				if (!contentString.contains("+"))
				{
					editText_countryNum.setText(beforText);
				}
				else
				{
					if (contentString.length() > 1)
					{
						List<CountrySortModel> fileterList = (ArrayList<CountrySortModel>) countryChangeUtil
								.search(contentString, mAllCountryList);
						
						if (fileterList.size() == 1)
						{
							tv_countryName.setText(fileterList.get(0).countryName);
						}
						else
						{
							tv_countryName
									.setText(getResources()
											.getString(
													R.string.activity_login_select_country_code_erro));
							
							if (contentString.equals("+1"))
							{
								tv_countryName.setText("United States");
								return;
							}
						}
					}
					else
					{
						if (contentString.length() == 0)
						{
							editText_countryNum.setText(beforText);
							tv_countryName.setText(getResources().getString(
									R.string.activity_login_select_form_list));
						}
						else if (contentString.length() == 1
								&& contentString.equals("+"))
						{
							tv_countryName.setText(getResources().getString(
									R.string.activity_login_select_form_list));
						}
					}
				}
				
				if (contentSeq instanceof Spannable)
				{
					Spannable spannable = (Spannable) contentSeq;
					Selection.setSelection(spannable, contentSeq.length());
				}
			}
		});
		
		editText_countryNum
				.setOnFocusChangeListener(new OnFocusChangeListener()
				{
					@Override
					public void onFocusChange(View arg0, boolean isFocused)
					{
						loginPhoneNumber.setSelected(isFocused);
					}
				});
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch (requestCode)
		{
			case 12:
				if (resultCode == RESULT_OK)
				{
					Bundle bundle = data.getExtras();
					String countryName = bundle.getString("countryName");
					String countryNumber = bundle.getString("countryNumber");
					
					editText_countryNum.setText(countryNumber);
					tv_countryName.setText(countryName);
					
				}
				break;
			
			default:
				break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	protected void setTitleBar(String titleString)
	{
		// 设置标题字体
		super.setTitleBar("登陆");
	}
	
}
