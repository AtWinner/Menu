package com.example.menu;

import java.util.HashMap;
import java.util.List;

import com.example.sqlite.DBController;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MessageFragement extends Fragment {
	private View rootView;
	private Context context;
    private DBController controller;//数据库操作的业务逻辑类
    private List<HashMap<String, String>> messageList;//任务表的数据集
	private ListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) 
	{
		context=getActivity();
		controller = new DBController(context, 1);
		messageList = controller.queryMessage();//每次进来都要重复查询的
		if(messageList.size() == 0)
		{//没有消息
			rootView = inflater.inflate(R.layout.fragment_message_none, container, false);
		}
		else
		{//有消息
			rootView = inflater.inflate(R.layout.fragment_message_have, container, false);
			listView = (ListView)rootView.findViewById(R.id.listMessage);
			listView.setAdapter(new MessageAdapter());
		}
		return rootView;
	 }

	
	
	
	private class MessageAdapter extends BaseAdapter
	{
		private LayoutInflater inFlater;
		ViewHolder holder = null;
		
		@Override
		public int getCount() {
			return messageList.size();
		}

		@Override
		public Object getItem(int arg0) {
			return messageList.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View contentView, ViewGroup arg2) {
			final int thisPosition = arg0;
			if(contentView == null)
			{
				inFlater = LayoutInflater.from(context);
				contentView = inFlater.inflate(R.layout.list_item_message, null);// 生成条目对象
				holder = new ViewHolder();
				holder.itemMessageLogo = (ImageView)contentView.findViewById(R.id.itemMessageLogo);
				holder.itemMessageRightLine1 = (TextView)contentView.findViewById(R.id.itemMessageRightLine1);
				holder.itemMessageRightLine2 = (TextView)contentView.findViewById(R.id.itemMessageRightLine2);
				holder.itemMessageRightLine3 = (TextView)contentView.findViewById(R.id.itemMessageRightLine3);
				
				contentView.setTag(holder);
			}
			else
			{
				holder = (ViewHolder)contentView.getTag();
			}
			HashMap<String, String> hashMap = messageList.get(thisPosition);
			if(hashMap.size()>10)
			{
				holder.itemMessageRightLine1.setText("您接受了一条来自【"+hashMap.get("TitleName")+"】的任务");
				holder.itemMessageRightLine2.setText("可获得报酬"+hashMap.get("Charges")+"元，需骑行"+hashMap.get("TaskRequirement").substring(Integer.valueOf(hashMap.get("start")), Integer.valueOf(hashMap.get("end")))+"公里。");
				holder.itemMessageRightLine3.setText("联系电话："+hashMap.get("Telephone"));
			}
			return contentView;
		}
		private class ViewHolder
		{
			public ImageView itemMessageLogo;
			public TextView itemMessageRightLine1;
			public TextView itemMessageRightLine2;
			public TextView itemMessageRightLine3;
		}
	}
}
