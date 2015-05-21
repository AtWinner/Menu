package com.example.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FoundActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_found);
		ImageView foundImage = (ImageView)findViewById(R.id.foundImage);
		foundImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(FoundActivity.this, FoundDetailActivity.class);
				startActivity(intent);
				
			}
		});
	}
	
}
