package com.example.menu;

import java.util.HashMap;
import java.util.List;

import com.example.sqlite.DBController;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UsercenterFragment extends Fragment {
	private View rootView;
	private RelativeLayout Bottom;
	private TextView StateText;
	private Context context;
	private ImageView Circle;
	private int State;
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) 
	{
		if(rootView == null)
		{
			rootView = inflater.inflate(R.layout.fragment_usercenter, container, false);
			context = getActivity();
			Bottom = (RelativeLayout)rootView.findViewById(R.id.Bottom);
			StateText = (TextView)rootView.findViewById(R.id.StateText);
			Circle = (ImageView)rootView.findViewById(R.id.Circle);
			Bottom.setOnClickListener(new myOnclick());
			State = 0;
		}
		return rootView;
	}
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		((ViewGroup) rootView.getParent()).removeView(rootView);
	}
	
	private class myOnclick implements OnClickListener
	{
		@Override
		public void onClick(View arg0) {
			int id = arg0.getId();
			switch (id) {
			case R.id.Bottom:
				clickBottom();
				break;

			}
		}
	}
	@SuppressLint("NewApi")
	private void clickBottom()
	{
		if(State % 2 ==0)
		{
			//开始运动
			Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.loading_dialog_tips);
	        LinearInterpolator lin = new LinearInterpolator();
			operatingAnim.setInterpolator(lin);
			Circle.startAnimation(operatingAnim);
			StateText.setText("再次点击结束");
			State++;
		}
		else
		{
			Circle.clearAnimation();
			StateText.setText("点击开始");
			State++;
		}
	}
}
