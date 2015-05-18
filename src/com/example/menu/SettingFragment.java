package com.example.menu;

import java.util.HashMap;
import java.util.List;

import com.example.adapter.myOnKeyListener;
import com.example.adapter.myProgressDialog;
import com.example.network.DoSend;
import com.example.sqlite.DBController;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class SettingFragment extends Fragment 
{
	/* 取得默认的蓝牙适配器 */
	private BluetoothAdapter	_bluetooth = BluetoothAdapter.getDefaultAdapter();

	private View rootView;
	private Context context;
    private DBController controller;//数据库操作的业务逻辑类
    private List<HashMap<String, String>> messageList;//任务表的数据集
	private ListView listView;
	private ImageView SuggestionSubmit;
	private EditText editContent;
	private String suggestion;
	private myProgressDialog progressDialog = null;
	private ImageView DeviceController;
	private ImageView DriveController;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) 
	{
		context=getActivity();
		controller = new DBController(context, 1);
		messageList = controller.queryMessage();//每次进来都要重复查询的
		rootView = inflater.inflate(R.layout.fragment_setting, container, false);
		SuggestionSubmit = (ImageView)rootView.findViewById(R.id.SuggestionSubmit);
		SuggestionSubmit.setOnClickListener(new myOnClickListener());
		editContent = (EditText)rootView.findViewById(R.id.editContent);
		DeviceController = (ImageView)rootView.findViewById(R.id.DeviceController);
		DeviceController.setOnClickListener(new myOnClickListener());
		DriveController = (ImageView)rootView.findViewById(R.id.DriveController);
		DriveController.setOnClickListener(new myOnClickListener());
		return rootView;
	}


	private class myOnClickListener implements OnClickListener
	{
		@Override
		public void onClick(View arg0) {
			switch(arg0.getId())
			{
			case R.id.SuggestionSubmit:
				clickSuggestionSubmit();
				break;
			case R.id.DeviceController:
				clickDeviceController();
				break;
			case R.id.DriveController:
				clickDriveController();
				break;
			}
		}
	}
	private void clickSuggestionSubmit()
	{
		suggestion = editContent.getText().toString();
		showDialog();
		new myThread().start();
	}
	private void clickDeviceController()
	{
		if(_bluetooth.isEnabled())
		{
			_bluetooth.disable();
		}
		else
		{
			_bluetooth.enable();
			String str = "123456789";
			Toast.makeText(context, new String(str.getBytes()), Toast.LENGTH_SHORT).show();
		}
	}
	private void clickDriveController()
	{//逻辑是暂时的
		Intent enabler = new Intent(context, DiscoveryActivity.class);
		startActivity(enabler);
	}
	

	private class myThread extends Thread
	{

		@Override
		public void run() {
			if(suggestion == null || suggestion.equals(""))
			{
				mhandler.obtainMessage(0, "请输入意见之后再发送哦").sendToTarget();
				return;
			}
			DoSend.sendMail(suggestion);
			mhandler.obtainMessage(1, "发送成功，感谢您的支持").sendToTarget();
			super.run();
		}
	}
	Handler mhandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Toast.makeText(context, msg.obj.toString(), Toast.LENGTH_SHORT).show();
			editContent.setText("");
			progressDialog.dismiss();
		}
		
	};
	
	private void showDialog()
	{
		progressDialog = myProgressDialog.createDialog(context);
		progressDialog.setCancelable(false);
		progressDialog.setOnKeyListener(new myOnKeyListener());
		progressDialog.setMessage("拼命发送中...");
		progressDialog.show();
	}
}
