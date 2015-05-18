package com.example.adapter;

import com.example.menu.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class MyDialog extends Dialog {
	private Context context;
	public MyDialog(Context context) {
		super(context);
		this.context = context;
	}
	public MyDialog(Context context, int theme){
        super(context, theme);
        this.context = context;
    }
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.my_dialog);
    }

}
