package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity 
{
	private EditText UserName;
	private EditText Password;
	private Button Login;
	private CheckBox IsRemember;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activirt_login);
		init();
		bindEvent();
	}
	private void init()
	{
		UserName = (EditText)findViewById(R.id.UserName);
		Password = (EditText)findViewById(R.id.Password);
		Login = (Button)findViewById(R.id.btnLogin);
		IsRemember =(CheckBox)findViewById(R.id.IsRemember);
	}
	private void bindEvent()
	{
		Login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.e(Password.getText().toString(), UserName.getText().toString());
				if(Password.getText().toString().equals("110021") && UserName.getText().toString().toUpperCase().equals("MAOSHICHANG"))
				{
					if(IsRemember.isChecked())
					{
						SharedPreferences mSharedPreferences = getSharedPreferences("UserInfo", Activity.MODE_PRIVATE);
						Editor editor = mSharedPreferences.edit();
						editor.putString("name", UserName.getText().toString());
						editor.putString("password", Password.getText().toString());
						editor.commit();
					}
					Intent intent=new Intent();  
					intent.setClass(Login.this, MainActivity.class);
					startActivity(intent);  
					Login.this.finish();
				}
				else
				{
					Toast.makeText(Login.this,  "用户名或密码错误", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
}
