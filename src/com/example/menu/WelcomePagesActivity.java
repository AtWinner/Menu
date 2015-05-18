package com.example.menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomePagesActivity extends FragmentActivity {

	private final int PagesCount = 3;//保存页面数量

	private ViewPager bodyPager;
	private SectionsPagerAdapter mSectionsPagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_pages);
		bodyPager = (ViewPager)findViewById(R.id.bodyPager);
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		bodyPager.setAdapter(mSectionsPagerAdapter);
	}
	
	
	@SuppressLint("ValidFragment")
	private class FragmentPage extends Fragment
	{
		private int Index;
		public FragmentPage(int index)
		{
			Index = index;
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

	        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);
	        Context context = getActivity();
	        ImageView fragmentImage = (ImageView)rootView.findViewById(R.id.fragmentImage);
	        Button btnIn = (Button)rootView.findViewById(R.id.btnIn);
	        switch(Index)
	        {
	        case 0:
	        	btnIn.setVisibility(View.INVISIBLE);
	        	fragmentImage.setImageResource(R.drawable.welcome_image1);
	        	break;
	        case 1:
	        	btnIn.setVisibility(View.INVISIBLE);
	        	fragmentImage.setImageResource(R.drawable.welcome_image2);
	        	break;
	        case 2:
	        	btnIn.setVisibility(View.VISIBLE);
	        	fragmentImage.setImageResource(R.drawable.welcome_image3);
	        	setClick(btnIn);
	        	break;
	        }
	        return rootView;
		}
		private void setClick(Button btnIn)
		{
			btnIn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					SharedPreferences mSharedPreferences = getSharedPreferences("IsFirst", Activity.MODE_PRIVATE);
					Editor editor = mSharedPreferences.edit();
					editor.putString("HaveUsed", "1");
					editor.commit();
					Intent intent=new Intent();  
					intent.setClass(WelcomePagesActivity.this, Login.class);
					startActivity(intent);  
					WelcomePagesActivity.this.finish();
				}
			});
		}
	}
	
	
	private class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new FragmentPage(0);
			case 1:
				return new FragmentPage(1);
			default:
				return new FragmentPage(2);
			
			}
		}

		@Override
		public int getCount() {
			return PagesCount;
		}
	}
}
