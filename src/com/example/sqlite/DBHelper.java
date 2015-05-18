package com.example.sqlite;

import com.example.data.initData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBHelper extends SQLiteOpenHelper {
	private final static String DB_NAME ="test.db";//数据库名
	private final static int VERSION = 1;//版本号

	 //自带的构造方法
	 public DBHelper(Context context, String name, CursorFactory factory,
	   int version) 
	 {
		 super(context, name, factory, version);
	 }
	 //版本变更时
	 public DBHelper(Context cxt, int version) 
	 {
		 this(cxt,DB_NAME, null, version);
	 }
	@Override
	public void onCreate(SQLiteDatabase db) {
		String createSql = "Create Table NeedInfo ("+
				"ID integer primary key autoincrement,"+
				"TitleName varchar(100),"+
				"TaskRequirement varchar(1000),"+
				"Heavy float,"+
				"OtherWelfare varchar(1000),"+
				"TaskAddress varchar(1000),"+
				"TaskAddressLa decimal(10,6),"+//纬度
				"TaskAddressLo decimal(10,6),"+//经度
				"BeginDate varchar(36),"+
				"EndDate varchar(36),"+
				"Telephone varchar(20),"+
				"Stars integer,"+
				"Charges float,"+
				"IsRealname BLOB,"+
				"ImageName varchar(500),"+
				"start integer,"+
				"end integer,"+
				"Introduce varchar(2000)"+
				");";
		db.execSQL(createSql);
		createSql= "Create Table MessageInfo ("+
				"ID integer,"+
				"TitleName varchar(100),"+
				"TaskRequirement varchar(1000),"+
				"Heavy float,"+
				"OtherWelfare varchar(1000),"+
				"TaskAddress varchar(1000),"+
				"TaskAddressLa decimal(10,6),"+//纬度
				"TaskAddressLo decimal(10,6),"+//经度
				"BeginDate varchar(36),"+
				"EndDate varchar(36),"+
				"Telephone varchar(20),"+
				"Stars integer,"+
				"Charges float,"+
				"IsRealname BLOB,"+
				"ImageName varchar(500),"+
				"start integer,"+
				"end integer"+
				");";
		db.execSQL(createSql);
		createSql= "Create Table Comment ("+
				"TaskID integer,"+
				"OrderPos int,"+
				"ImageName varchar(100),"+
				"Content varchar(5000)"+
				");";
		db.execSQL(createSql);
		for(String insertSql : initData.getInitSql())
		{
			db.execSQL(insertSql);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
		//TODO
	}
}
