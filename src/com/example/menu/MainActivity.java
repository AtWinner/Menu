package com.example.menu;

import java.util.HashMap;
import java.util.List;

import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.GeofenceClient;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.navisdk.BaiduNaviManager;
import com.baidu.navisdk.BNaviEngineManager.NaviEngineInitListener;
import com.example.adapter.MyDialog;
import com.example.sqlite.DBController;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private int BeforePosition = -1;
	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	
	private TaskFragment taskFragment;
	private UsercenterFragment usercenterFragment;
	private MessageFragement messageFragment;
    private DBController controller;//数据库操作的业务逻辑类
    
    private boolean mIsEngineInitSuccess = false;
    public LocationClient mLocationClient;
	public Vibrator mVibrator;
	private LocationMode tempMode =  LocationMode.Hight_Accuracy;
	private String tempcoor="gcj02";
	private AlertDialog dialog;
    private NaviEngineInitListener mNaviEngineInitListener = new NaviEngineInitListener() {
		public void engineInitSuccess() {
			mIsEngineInitSuccess = true;
		}

		public void engineInitStart() {
		}

		public void engineInitFail() {
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();
		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		controller = new DBController(MainActivity.this, 1);//获取数据库操作象
		List<HashMap<String, String>> taskList = controller.queryTask();//任务表的数据集
		taskFragment = new TaskFragment(taskList);
		
		usercenterFragment = new UsercenterFragment();
		messageFragment = new MessageFragement();
		checkKey();
		onNavigationDrawerItemSelected(1);
		mLocationClient =  ((LocationApplication)getApplication()).mLocationClient;
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(tempMode);//设置定位模式
		option.setCoorType(tempcoor);//返回的定位结果是百度经纬度，默认值gcj02
		option.setScanSpan(1000);//设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true);
		mLocationClient.setLocOption(option);
		mLocationClient.start();
		
	}

	@Override
	protected void onStop() {
		mLocationClient.stop();
		super.onStop();
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		if(BeforePosition == position && position != 5)
		{
			return;
		}
		if(position != 5)
		{
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager
			.beginTransaction()
			.replace(R.id.container,
					PlaceholderFragment.newInstance(position + 1)).commit();
		}
		else
		{
//			MyDialog dialog = new MyDialog(MainActivity.this, R.style.MyDialog);
//			dialog.setContentView(R.layout.my_dialog);
//			dialog.show();
			if(dialog == null)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
	            LayoutInflater inflater = getLayoutInflater();
	            builder.setTitle("退出账号");
	            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
	                @Override
	                public void onClick(DialogInterface arg0, int arg1) {
	        			Intent intent=new Intent();  
	        			intent.setClass(MainActivity.this, Login.class);
	        			startActivity(intent);  
	        			MainActivity.this.finish();
	                }
	            });
	             
	            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
	                 
	                @Override
	                public void onClick(DialogInterface arg0, int arg1) {
	                }
	            });
	             
	            dialog = builder.create();
			}
            dialog.show();
		}
		switch (position) {
		case 0:
			if(BeforePosition != -1)
			{
				FragmentTransaction ft0 = getSupportFragmentManager().beginTransaction();
				ft0.replace(R.id.container, usercenterFragment);
				ft0.commit();
			}
			break;
		case 1:
			FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
			ft1.replace(R.id.container, taskFragment);
			ft1.commit();
			break;
		case 2:
			FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
			ft2.replace(R.id.container, messageFragment);
			ft2.commit();
			break;
		case 3:
			SettingFragment settingFragment = new SettingFragment();
			FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
			ft3.replace(R.id.container, settingFragment);
			ft3.commit();
			break;
		case 4:
			AnnouncementFragment announcementFragment = new AnnouncementFragment();
			FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
			ft4.replace(R.id.container, announcementFragment);
			ft4.commit();
			break;
		default:

			break;
		}

		BeforePosition = position;
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			mTitle = getString(R.string.title_section5);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void checkKey()
    {
    	BaiduNaviManager.getInstance().initEngine(MainActivity.this, getSdcardDir(), mNaviEngineInitListener, new LBSAuthManagerListener()  
        {  
            @Override  
            public void onAuthResult(int status,String msg)  
            {  
                String str = null;  
                if(0 == status)  
                {  
                    str = "key校验成功!";  
                }else  
                {  
                    str = "key校验失败, " + msg;  
                }  
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();  
            }  
        });  
    }
	private String getSdcardDir() {
		if (Environment.getExternalStorageState().equalsIgnoreCase(
				Environment.MEDIA_MOUNTED)) {
			return Environment.getExternalStorageDirectory().toString();
		}
		return null;
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			TextView textView = (TextView) rootView
					.findViewById(R.id.section_label);
			textView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
