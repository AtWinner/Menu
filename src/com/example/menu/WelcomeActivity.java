package com.example.menu;

import java.util.Timer;
import java.util.TimerTask;

import com.example.adapter.GetScreenSize;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class WelcomeActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activity_welcome);
		int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽  
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();      // 屏幕高
		screenHeight = GetScreenSize.getUsefulScreenHeight(WelcomeActivity.this, screenHeight);
        Intent intent=new Intent();  
		SharedPreferences mSharedPreferencesHaveUsed = getSharedPreferences("IsFirst", Activity.MODE_PRIVATE);
		String HaveUsed = mSharedPreferencesHaveUsed.getString("HaveUsed", "");
    	SharedPreferences mSharedPreferences = getSharedPreferences("UserInfo", Activity.MODE_PRIVATE);
    	String name = mSharedPreferences.getString("name", ""); 
    	String password = mSharedPreferences.getString("password", ""); 
    	if(HaveUsed.equals(""))
    	{
    		intent.setClass(WelcomeActivity.this, WelcomePagesActivity.class);
    	}
    	else if(name.equals(""))
    	{
    		intent.setClass(WelcomeActivity.this, Login.class);
    	}
    	else
    	{
			Toast.makeText(WelcomeActivity.this,  "已经为您自动登录", Toast.LENGTH_SHORT).show();
    		intent.setClass(WelcomeActivity.this, MainActivity.class);
    	}
        startActivity(intent);  
        WelcomeActivity.this.finish();
	}
	/**
	 * 暂时废弃了
	 */
	private void delete()
	{
        ImageView imageview = (ImageView)findViewById(R.id.imageWelcome1);  
        ImageView imageviewUP = (ImageView)findViewById(R.id.imageWelcome2);  
        
        //获取图片所显示的ClipDrawble对象  
        final ClipDrawable drawable = (ClipDrawable)imageview.getDrawable();  
        final Handler handler = new Handler()  
        {  
            public void handleMessage(Message msg)  
            {  
                if(msg.what == 0x1233)  
                {  
                    //修改ClipDrawable的level值  
                    drawable.setLevel(drawable.getLevel() +150);  
                }  
            }  
        }; 
        final Timer timer = new Timer();  
        timer.schedule(new TimerTask()  
        {  
            public void run()  
            {  
                Message msg = new Message();  
                msg.what = 0x1233;  
                //发送消息,通知应用修改ClipDrawable对象的level值  
                handler.sendMessage(msg);  
                //取消定时器  
                if(drawable.getLevel() >= 10000)  
                {  
                    timer.cancel();  
                }  
            }  
        },0,25);  

        final ClipDrawable drawableUP = (ClipDrawable)imageviewUP.getDrawable();  
        final Handler handlerUP = new Handler()  
        {  
            public void handleMessage(Message msg)  
            {  
                if(msg.what == 0x1233)  
                {  
                    //修改ClipDrawable的level值  
                    drawableUP.setLevel(drawableUP.getLevel() +150);  
                }  
            }  
        };  
        final Timer timerUP = new Timer();  
        timerUP.schedule(new TimerTask()  
        {  
            public void run()  
            {  
                Message msg = new Message();  
                msg.what = 0x1233;  
                //发送消息,通知应用修改ClipDrawable对象的level值  
                handlerUP.sendMessage(msg);  
                //取消定时器  
                if(drawableUP.getLevel() >= 10000)  
                {  
                    timerUP.cancel();  
                }  
            }   
        },2100,25);

        Animation operatingAnim = AnimationUtils.loadAnimation(WelcomeActivity.this, R.anim.loading_dialog_tips);
        LinearInterpolator lin = new LinearInterpolator();
		operatingAnim.setInterpolator(lin);
		final ImageView SunYellow = (ImageView)findViewById(R.id.sun_yellow);
		SunYellow.startAnimation(operatingAnim);
		final Handler handlerSun = new Handler()
		{
			public void handleMessage(Message msg)
			{
				SunYellow.setAlpha(SunYellow.getAlpha()+1);
			}
		};
        final Timer timeSun = new Timer();
        timeSun.schedule(new TimerTask() {
			@Override
			public void run() {
				Message msg = new Message();  
                msg.what = 0x1233;  
                //发送消息,通知应用修改ClipDrawable对象的level值
                handlerSun.sendMessage(msg);  
                //取消定时器  
                if(SunYellow.getAlpha() >= 255)  
                {  
                    timeSun.cancel();  
                }  
			}
		}, 4200, 25);
		
		ImageView LineYellow = (ImageView)findViewById(R.id.LineYellow);
		final ClipDrawable drawableLine = (ClipDrawable)LineYellow.getDrawable();  
        final Handler handlerLine = new Handler()  
        {  
            public void handleMessage(Message msg)  
            {  
                if(msg.what == 0x1233)  
                {  
                    //修改ClipDrawable的level值  
                    drawableLine.setLevel(drawableLine.getLevel() +150);  
                }  
            }  
        };  
        final Timer timerLine = new Timer();  
        timerLine.schedule(new TimerTask()  
        {  
            public void run()  
            {
                Message msg = new Message();  
                msg.what = 0x1233;  
                //发送消息,通知应用修改ClipDrawable对象的level值
                handlerLine.sendMessage(msg);  
                //取消定时器  
                if(drawableLine.getLevel() >= 10000)  
                {  
                    timerLine.cancel();  
                }  
            }   
        },4200,25);
		
        new Handler().postDelayed(new Runnable()  
        {  
            @Override  
            public void run()  
            {  
                // TODO Auto-generated method stub  
            	
            }  
        }, 6500);  
	}

}
