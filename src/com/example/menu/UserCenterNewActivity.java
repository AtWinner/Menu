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
import android.view.ViewGroup; 
import android.widget.ImageView;

public class UserCenterNewActivity extends FragmentActivity {

	private final int PagesCount = 3;//保存页面数量

	private ViewPager bodyPager;
	private SectionsPagerAdapter mSectionsPagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usercenter_new);
		bodyPager = (ViewPager)findViewById(R.id.usercenterPager);
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

	        View rootView = inflater.inflate(R.layout.fragment_usercenter_pages, container, false);
	        Context context = getActivity();
	        ImageView fragmentImage = (ImageView)rootView.findViewById(R.id.fragmentImageUsercenter);
	        switch(Index)
	        {
	        case 0:
	        	fragmentImage.setImageResource(R.drawable.usercenter_photo);
	        	break;
	        case 1:
	        	fragmentImage.setImageResource(R.drawable.usercenter_cf);
	        	break;
	        case 2:
	        	fragmentImage.setImageResource(R.drawable.usercenter_friends);
	        	break;
	        }
	        return rootView;
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
