package com.example.menu;

import java.util.HashMap;
import java.util.List;

import com.example.adapter.ZoomOutPageTransformer;
import com.example.data.linkToLogo;
import com.example.sqlite.DBController;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends FragmentActivity {
//	private TextView DetailTitleTask;
//	private TextView DetailTitleTime;
//	private TextView DetailTitleWelfare;
//	private TextView DetailTitleNote;
//	private ImageView btnAcceptTask;
	private ViewPager TaskBodyPager;
	private final int PagesCount = 3;//保存页面数量
	private SectionsPagerAdapter mSectionsPagerAdapter;
	private String ID;
	private HashMap<String, String> taskMap;
	private List<HashMap<String, String>> CommentMap;
	private DBController controller ;
	private int screenWidth;       // 屏幕宽  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		screenWidth  = getWindowManager().getDefaultDisplay().getWidth();
		TaskBodyPager = (ViewPager)findViewById(R.id.TaskBodyPager);
		TaskBodyPager.setPageTransformer(true, new ZoomOutPageTransformer());
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		TaskBodyPager.setAdapter(mSectionsPagerAdapter);
		ID = getIntent().getStringExtra("ID");
		controller = new DBController(DetailActivity.this, 1);
		taskMap = controller.queryTaskByID(ID);
		CommentMap = controller.queryCommentByID(ID);
//		DetailTitleTask = (TextView)findViewById(R.id.DetailTitleTask);
//		DetailTitleTime = (TextView)findViewById(R.id.DetailTitleTime);
//		DetailTitleWelfare = (TextView)findViewById(R.id.DetailTitleWelfare);
//		DetailTitleNote = (TextView)findViewById(R.id.DetailTitleNote);
//		btnAcceptTask = (ImageView)findViewById(R.id.btnAcceptTask);
//		bindEvent();
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
			View rootView;
			 switch(Index)
		     {
		        case 0:
		        	rootView = inflater.inflate(R.layout.fragment_my_task, container, false);
		        	setMyTask(rootView);
		        	break;
		        case 1:
		        	rootView = inflater.inflate(R.layout.fragment_my_task_store, container, false);
		        	setStoreInfo(rootView);
		        	break;
		        default:
		        	rootView = inflater.inflate(R.layout.fragment_my_task_comment, container, false);
		        	setReply(rootView);
		        	break;
		    }
	        
	        Context context = getActivity();
//	        ImageView fragmentImage = (ImageView)rootView.findViewById(R.id.fragmentImage);
//	        Button btnIn = (Button)rootView.findViewById(R.id.btnIn);
	       
	        return rootView;
		}
		/**
		 * 设置任务详情fragment
		 */
		private void setMyTask(View rootView)
		{
			TextView DetailTitleTask = (TextView)rootView.findViewById(R.id.DetailTitleTask);
			TextView DetailTitleTime = (TextView)rootView.findViewById(R.id.DetailTitleTime);
			TextView DetailTitleWelfare = (TextView)rootView.findViewById(R.id.DetailTitleWelfare);
			TextView DetailTitleNote = (TextView)rootView.findViewById(R.id.DetailTitleNote);
			ImageView btnAcceptTask = (ImageView)rootView.findViewById(R.id.btnAcceptTask);
			DetailTitleTask.setText(taskMap.get("TaskRequirement"));
			DetailTitleTime.setText(taskMap.get("BeginDate")+"  -  "+taskMap.get("EndDate"));
			DetailTitleWelfare.setText("￥"+taskMap.get("Charges"));
			btnAcceptTask.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					try
					{
						controller.insertIntoMessageInfo(Integer.valueOf(ID));
						Toast.makeText(DetailActivity.this, "       成功接受任务\n请在信息详细中查看", Toast.LENGTH_SHORT).show();
					}
					catch(Exception e)
					{
						Toast.makeText(DetailActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
					}
				}
			});
		}
		/**
		 * 设置店铺信息
		 * @param rootView
		 */
		private void setStoreInfo(View rootView)
		{
			ImageView btnStoreCollect = (ImageView)rootView.findViewById(R.id.btnStoreCollect);
			btnStoreCollect.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Toast.makeText(DetailActivity.this, "店铺收藏成功", Toast.LENGTH_SHORT).show();
				}
			});
		}
		private void setReply(View rootView)
		{
			LinearLayout LinearComment = (LinearLayout)rootView.findViewById(R.id.LinearComment);
			if(CommentMap == null ||CommentMap.size() <=0 )
			{
				TextView text = new TextView(DetailActivity.this);
				text.setText("还没有评论，快来抢沙发吧");
				LayoutParams textParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				textParams.topMargin=100;
				text.setLayoutParams(textParams);
				text.setGravity(Gravity.CENTER);
				text.setTextColor(R.color.myGreen);
				LinearComment.addView(text);
			}
			else
			{
				linkToLogo link = new linkToLogo();
				for(int i = 0; i < CommentMap.size(); i++)
				{
					LinearLayout LinearItem = new LinearLayout(DetailActivity.this);
					LinearLayout.LayoutParams params = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
					LinearItem.setLayoutParams(params);
					LinearItem.setOrientation(LinearLayout.HORIZONTAL);
					//展现头像
					ImageView Head = new ImageView(DetailActivity.this);
					LinearLayout.LayoutParams headParams = new LayoutParams(screenWidth / 5, screenWidth / 5);
					Head.setLayoutParams(headParams);
//					Head.setImageResource(R.drawable.head2);
					Head.setImageResource(link.getImage(CommentMap.get(i).get("ImageName")));
					LinearItem.addView(Head);
					//头像右侧的框框
					LinearLayout LinearRight = new LinearLayout(DetailActivity.this);
					LinearLayout.LayoutParams RightParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
					LinearRight.setLayoutParams(RightParams);
					LinearRight.setOrientation(LinearLayout.VERTICAL);
					LinearItem.addView(LinearRight);
					LinearRight.setPadding(10, 10, 10, 10);
					//用户名
					TextView Name = new TextView(DetailActivity.this);
					String textInner = CommentMap.get(i).get("Content");
//					Log.e("textInner", textInner);
					Name.setText(textInner);
					LinearRight.addView(Name);
					//评价详情
					LinearComment.addView(LinearItem);
					
					LinearLayout border = new LinearLayout(DetailActivity.this);
					LayoutParams borderParams = new LayoutParams(LayoutParams.MATCH_PARENT, 3);
					borderParams.topMargin=50;
					borderParams.bottomMargin = 50;
					border.setLayoutParams(borderParams);
					border.setBackgroundColor(Color.BLACK);
					LinearComment.addView(border);
				}
			}
			
		}
		
		
	}

}
