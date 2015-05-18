package com.example.adapter;

import com.example.menu.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class DrawerListViewAdapter extends BaseAdapter {
	private String[] titleString;
	ViewHolder holder = null;
	private int resource;// 绑定的一个条目界面的id
	private LayoutInflater inFlater;
	
	public DrawerListViewAdapter(Context context,  int res, String[] title)
	{
		resource = res;
		inFlater = LayoutInflater.from(context);
		titleString = title;
	}
	
	@Override
	public int getCount() {
		return titleString.length;
	}
	@Override
	public Object getItem(int position) {
		return titleString[position];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public View getView(int position, View contentView, ViewGroup parent)  
	{
		contentView = inFlater.inflate(resource, null);// 生成条目对象
		holder = new ViewHolder();
		holder.textTitle = (TextView)contentView.findViewById(R.id.textTitle);
		holder.ImageArrow = (ImageView)contentView.findViewById(R.id.ImageArrow);
		holder.ImageCircle = (ImageView)contentView.findViewById(R.id.ImageCircle);
		holder.mySwitch = (Switch)contentView.findViewById(R.id.mySwitch);
		
		contentView.setTag(holder);
		holder.textTitle.setText(titleString[position]);
		switch(position)
		{
		case 0:
			holder.ImageArrow.setVisibility(View.VISIBLE);
			holder.ImageCircle.setVisibility(View.GONE);
			holder.mySwitch.setVisibility(View.GONE);
			break;
		case 1:
			holder.ImageArrow.setVisibility(View.VISIBLE);
			holder.ImageCircle.setVisibility(View.GONE);
			holder.mySwitch.setVisibility(View.GONE);
			break;
		case 2:
			holder.ImageArrow.setVisibility(View.GONE);
			holder.ImageCircle.setVisibility(View.VISIBLE);
			holder.mySwitch.setVisibility(View.GONE);
			break;
		case 3:
			holder.ImageArrow.setVisibility(View.GONE);
			holder.ImageCircle.setVisibility(View.GONE);
			holder.mySwitch.setVisibility(View.VISIBLE);
			break;
		case 4:
			holder.ImageArrow.setVisibility(View.VISIBLE);
			holder.ImageCircle.setVisibility(View.GONE);
			holder.mySwitch.setVisibility(View.GONE);
			break;
		case 5:
			holder.ImageArrow.setVisibility(View.GONE);
			holder.ImageCircle.setVisibility(View.GONE);
			holder.mySwitch.setVisibility(View.GONE);
			break;
		}
		return contentView;
	}
	
	private class ViewHolder
	{
		public TextView textTitle;
		public ImageView ImageArrow;
		public ImageView ImageCircle;
		public Switch mySwitch;
	}
}
