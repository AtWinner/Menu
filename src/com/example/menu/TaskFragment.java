package com.example.menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.GeofenceClient;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.navisdk.BNaviPoint;
import com.baidu.navisdk.BaiduNaviManager;
import com.baidu.navisdk.BaiduNaviManager.OnStartNavigationListener;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.NE_RoutePlan_Mode;
import com.example.adapter.ListViewCompat;
import com.example.adapter.SlideView;
import com.example.adapter.SlideView.OnSlideListener;
import com.example.data.linkToLogo;
import com.example.model.MessageItem;
import com.example.sqlite.DBController;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TaskFragment extends Fragment implements OnItemClickListener, OnClickListener,
OnSlideListener  {
	public static Double La;//当前经度
	public static Double Lo;//当前维度
	public static String Address;
	private View rootView;
	private Context context;
	private ListViewCompat mListView;
	private List<MessageItem> mMessageItems = new ArrayList<MessageItem>();
	private SlideView mLastSlideViewWithStatusOn;
    private DBController controller;//数据库操作的业务逻辑类
    private List<HashMap<String, String>> taskList;//任务表的数据集
    private LayoutInflater inflater;
    
	public TaskFragment(List<HashMap<String, String>> taskList)
    {
    	this.taskList = taskList;
    }

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		((ViewGroup) rootView.getParent()).removeView(rootView);
	}


	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) 
	{
		if(rootView == null)
		{
			rootView = inflater.inflate(R.layout.fragment_task, container, false);
			mListView = (ListViewCompat) rootView.findViewById(R.id.list);
			context = getActivity();
			this.inflater = inflater;
			controller = new DBController(context, 1);
			taskList =  controller.queryTask();//每次进来都要重复查询的
			initView();
		}
		mListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if(La == null)
				{
					Toast.makeText(context, "无法获取您的位置，请到宽阔地带", Toast.LENGTH_SHORT).show();
					return false;
				}
				BNaviPoint startPoint = new BNaviPoint(Lo, La, Address, BNaviPoint.CoordinateType.BD09_MC);
		        BNaviPoint endPoint = new BNaviPoint(mMessageItems.get(position).TaskAddressLa, mMessageItems.get(position).TaskAddressLo,
		        		mMessageItems.get(position).TaskAddress, BNaviPoint.CoordinateType.BD09_MC);
		        launchNavigator2(startPoint, endPoint);
				 Log.e("TAG", "onItemClick position=" + position);
				return false;
			}
		});
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(context, ((TextView)arg1.findViewById(R.id.itemID)).getText(), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context, DetailActivity.class);
				intent.putExtra("ID", ((TextView)arg1.findViewById(R.id.itemID)).getText());
				startActivity(intent);
				
			}
		});
		return rootView;
	 }
	
//	@Override
//	public void onResume() {
//		super.onResume();
//		taskList =  controller.queryTask();//每次进来都要重复查询的
//		initView();
//	}
	   private void initView() {

	        for (int i = 0; i < taskList.size(); i++) {
	            MessageItem item = new MessageItem();
	            HashMap<String, String> map = taskList.get(i);
	            item.iconRes = R.drawable.wechat_icon;
	            item.Charges = Double.valueOf(map.get("Charges"));
	            item.Heavy = Double.valueOf(map.get("Heavy"));
	            item.ID = map.get("ID");
	            item.ImageName = map.get("ImageName");
	            item.IsRealname = Integer.parseInt(map.get("IsRealname"));
	            item.OtherWelfare = map.get("OtherWelfare");
	            item.Stars= Integer.parseInt(map.get("Stars"));
	            item.TaskAddress = map.get("TaskAddress");
	            item.TaskRequirement = map.get("TaskRequirement");
	            item.TitleName = map.get("TitleName");
	            item.start = Integer.parseInt(map.get("start"));
	            item.end = Integer.parseInt(map.get("end"));
	            item.BeginDate = map.get("BeginDate");
	            item.EndDate = map.get("EndDate");
	            item.TaskAddressLa = Double.parseDouble(map.get("TaskAddressLa"));
	            item.TaskAddressLo = Double.parseDouble(map.get("TaskAddressLo"));
	            item.Telephone = map.get("Telephone");
	            mMessageItems.add(item);
	        }
	        mListView.setAdapter(new SlideAdapter());
	        mListView.setOnItemClickListener(this);
	    }
	   
	@Override
	public void onSlide(View view, int status) {
		 if (mLastSlideViewWithStatusOn != null && mLastSlideViewWithStatusOn != view) {
	            mLastSlideViewWithStatusOn.shrink();
		 }
		 if (status == SLIDE_STATUS_ON) {
	            mLastSlideViewWithStatusOn = (SlideView) view;
		 }
	}
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.holder) {
            Log.e("", "onClick v=" + v);
        }
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
		
	}


	private class SlideAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        SlideAdapter() {
            super();
            mInflater = inflater;
        }

        @Override
        public int getCount() {
            return mMessageItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mMessageItems.get(position);
        }

        @Override 
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) 
        {
        	final int thisPosition = position;
            ViewHolder holder;
            SlideView slideView = (SlideView) convertView;
            if (slideView == null) {
                View itemView = mInflater.inflate(R.layout.list_item, null);

                slideView = new SlideView(context);
                slideView.setContentView(itemView);

                holder = new ViewHolder(slideView);
                slideView.setOnSlideListener(TaskFragment.this);
                slideView.setTag(holder);
            } else {
                holder = (ViewHolder) slideView.getTag();
            }
            MessageItem item = mMessageItems.get(position);
            item.slideView = slideView;
            item.slideView.shrink();

            holder.icon.setImageResource(0x7f020069);
            holder.deleteHolder.setOnClickListener(TaskFragment.this);
            holder.titleText.setText(item.TitleName);
            holder.itemID.setText(item.ID);
            
            holder.textViewHeavy.setText(item.Heavy == 0 ? "无" : (String.valueOf(item.Heavy) + "kg"));
            holder.textViewHeavy.setTextColor(Color.RED);
            
            holder.textViewOtherWelfare.setText(item.OtherWelfare);
            if(item.OtherWelfare.equals("无"))
            {
            	holder.textViewOtherWelfare.setTextColor(Color.BLACK);
            }
            else
            {
            	holder.textViewOtherWelfare.setTextColor(Color.RED);
            }
            
            holder.textViewTaskAddress.setText(item.TaskAddress);
            
            SpannableString ss = new SpannableString(item.TaskRequirement);
            ss.setSpan(new ForegroundColorSpan(Color.RED), item.start, item.end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.textViewTaskRequirement.setText(ss);
            
            holder.textViewCharges.setText(String.valueOf(item.Charges));
            holder.textViewCharges.setTextColor(Color.RED);
            if(item.IsRealname == 1)
            {
            	holder.IsRealName.setText("实名认证");
            	holder.IsRealName.setTextColor(Color.rgb(68, 139, 203));
            }
            else
            {
            	holder.IsRealName.setText("");
            }
            holder.TopLayout.setOnClickListener(new OnClickListener() {//点击删除触发的事件
				@Override
				public void onClick(View arg0) {
					try
					{
						controller.RefuseNeed(Integer.valueOf(mMessageItems.get(thisPosition).ID));
						mMessageItems.remove(thisPosition);
						notifyDataSetChanged();
						Toast.makeText(context, "取消成功", Toast.LENGTH_SHORT).show();
					}
					catch(Exception e)
					{
						Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
					}
				}
			});
            holder.BottomLayout.setOnClickListener(new OnClickListener() {//点击接受时触发的事件
				
				@Override
				public void onClick(View arg0) {
					try
					{
						controller.insertIntoMessageInfo(Integer.valueOf(mMessageItems.get(thisPosition).ID));//执行数据库数据的转移
						mMessageItems.remove(thisPosition);//删除ListView中的数据
						notifyDataSetChanged();
						Toast.makeText(context, "       成功接受任务\n请在信息详细中查看", Toast.LENGTH_SHORT).show();
					}
					catch(Exception e)
					{
						Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
					}
				}
			});
            //设置星标
            holder.starsImage.setImageResource(getStars(item.Stars));
            holder.icon.setImageResource(new linkToLogo().getImage(item.ImageName));
            return slideView;
        }
    }
	
	private int getStars(int stars)
	{
		int Image = 0;
		switch (stars) {
			case 1:
				Image = R.drawable.star1;
				break;
			case 2:
				Image = R.drawable.star2;
				break;
			case 3: 
				Image = R.drawable.star3;
				break;
			case 4:
				Image = R.drawable.star4;
				break;
			case 5:
				Image = R.drawable.star5;
				break;
		}
		 return Image;
	}
	    /**
	     * 指定导航起终点启动GPS导航.起终点可为多种类型坐标系的地理坐标。
	     * 前置条件：导航引擎初始化成功
	     */
	private void launchNavigator2(BNaviPoint startPoint, BNaviPoint endPoint){
	    	
	        //这里给出一个起终点示例，实际应用中可以通过POI检索、外部POI来源等方式获取起终点坐标
	        
	        BaiduNaviManager.getInstance().launchNavigator((Activity) context,
	                startPoint,                                      //起点（可指定坐标系）
	                endPoint,                                        //终点（可指定坐标系）
	                NE_RoutePlan_Mode.ROUTE_PLAN_MOD_MIN_TIME,       //算路方式
	                true,                                            //真实导航
	                BaiduNaviManager.STRATEGY_FORCE_ONLINE_PRIORITY, //在离线策略
	                new OnStartNavigationListener() {                //跳转监听
	                    
	                    @Override
	                    public void onJumpToNavigator(Bundle configParams) {
	                        Intent intent = new Intent(context, BNavigatorActivity.class);
	                        intent.putExtras(configParams);
	                        startActivity(intent);
	                    }
	                    
	                    @Override
	                    public void onJumpToDownloader() {
	                    }
	                });
	    }
	private static class ViewHolder {
        public ImageView icon;
        public TextView titleText;
        public ViewGroup deleteHolder;
        public TextView textViewTaskRequirement;
        public TextView textViewHeavy;
        public TextView textViewOtherWelfare;
        public TextView textViewTaskAddress;
        public TextView textViewCharges;
        public TextView IsRealName;
        public RelativeLayout TopLayout;
        public RelativeLayout BottomLayout;
        public ImageView starsImage;
        public TextView itemID;
        ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.icon);
            deleteHolder = (ViewGroup)view.findViewById(R.id.holder);
            titleText = (TextView)view.findViewById(R.id.titleText);
            textViewTaskAddress = (TextView)view.findViewById(R.id.textViewTaskAddress);
            textViewTaskRequirement = (TextView)view.findViewById(R.id.textViewTaskRequirement);
            textViewHeavy = (TextView)view.findViewById(R.id.textViewHeavy);
            textViewOtherWelfare = (TextView)view.findViewById(R.id.textViewOtherWelfare);
            textViewCharges = (TextView)view.findViewById(R.id.textViewCharges);
            IsRealName = (TextView)view.findViewById(R.id.IsRealName);
            TopLayout  =(RelativeLayout)view.findViewById(R.id.TopLayout);
            BottomLayout = (RelativeLayout)view.findViewById(R.id.BottomLayout);
            starsImage = (ImageView)view.findViewById(R.id.starsImage);
            itemID = (TextView)view.findViewById(R.id.itemID);
        }
    }
	
}
