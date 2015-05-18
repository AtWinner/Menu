package com.example.sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBController {
	private DBHelper helper = null;
	public DBController(Context cxt, int version)
	{
		helper = new DBHelper(cxt, version);
	}
	/**
	 * 备用插入方法
	 */
	public void insertNeedInfo()
	{
		String insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('搜秀城购物广场', "
				+ "'20公里，环街骑行，提供衣物旗帜，自备车辆。提供热水，洗浴等',"
				+ "0,"
				+ "'提供午餐',"
				+ "'北京市朝阳区三丰北里',"
				+"114.559658,"
				+"38.066247,"
				+"'2015.03.02',"
				+"'2015.03.07',"
				+"'13513511669',"
				+ "3,"
				+ "300,"
				+ "1,"
				+ "'hehe',"
				+ "0,"
				+ "1)";
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(insertSql);
	}
	/**
	 * 
	 * @param TitleName 标题
	 * @param TaskRequirement 任务需求
	 * @param Heavy 负重
	 * @param OtherWelfare 其他福利
	 * @param TaskAddress 任务地址
	 * @param Stars 星星数
	 * @param Charges 佣金
	 * @param IsRealname 是否实名认证
	 * @param ImageName logo图片名称
	 * @param start 标红开始位置
	 * @param end 标红结束位置
	 */
	public void insert(String TitleName,String TaskRequirement,String Heavy,String OtherWelfare,String TaskAddress,String  Stars, String Charges, String IsRealname, String ImageName, String start, String end)
	{
		String insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress, Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('"+TitleName+"', "
				+ "'"+TaskRequirement+"',"
				+ Heavy +","
				+ "'"+OtherWelfare+"',"
				+ "'"+TaskAddress+"',"
				+ Stars+","
				+ Charges+","
				+ IsRealname+","
				+ "'"+ImageName+"',"
				+ start + ","
				+ end + ")";
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(insertSql);
	}
	 public List<HashMap<String, String>> queryTask()
	 {
	        List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
	        SQLiteDatabase db = helper.getWritableDatabase();
	        try
	        {
	            String sql="select * from NeedInfo";
	            Cursor cur=db.rawQuery(sql, new String[]{});
	            int length = 17;
	            while(cur.moveToNext())
	            {
	            	HashMap<String, String> map = new HashMap<String, String>();
		            for(int i=0; i < length; i++)
		            {
		            	map.put(cur.getColumnName(i), cur.getString(i));
		            }
		            list.add(map);
	            }
	            cur.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return list;        
	 }
	 /**
	  * 通过ID查询任务明细
	  * @param ID
	  * @return
	  */
	 public HashMap<String, String> queryTaskByID(String ID)
	 {
		 HashMap<String, String> map = new HashMap<String, String>();
		 SQLiteDatabase db = helper.getWritableDatabase();
		 try
	     {
			 String sql="select * from NeedInfo where ID = "+ID;
			 Cursor cur=db.rawQuery(sql, new String[]{});
			 int length = 17;
			 cur.moveToNext();
			 for(int i=0; i < length; i++)
	         {
				 map.put(cur.getColumnName(i), cur.getString(i));
	         }
			 cur.close();
	     }
		 catch(Exception e)
		 {
			 return null;
		 }
		 return map;
	 }
	 /**
	  * 通过ID查询评论
	  * @param ID
	  * @return
	  */
	 public List<HashMap<String, String>> queryCommentByID(String ID)
	 {
		 List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
		 SQLiteDatabase db = helper.getWritableDatabase();
		 
		 try
	     {
			 String sql="select * from Comment where TaskID = "+ID + " order by OrderPos";
			 Cursor cur=db.rawQuery(sql, new String[]{});
			 int length = 3;
			 while(cur.moveToNext())
	         {
				 HashMap<String, String> map = new HashMap<String, String>();
				 for(int i=0; i < length; i++)
		         {
					 map.put(cur.getColumnName(i), cur.getString(i));
		         }
				 list.add(map);
	         }
			 cur.close();
	     }
		 catch(Exception e)
		 {
			 return null;
		 }
		 return list;
	 }
	 
	 public List<HashMap<String, String>> queryMessage()
	 {
	        List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
	        SQLiteDatabase db = helper.getWritableDatabase();
	        try
	        {
	            String sql="select * from MessageInfo";
	            Cursor cur=db.rawQuery(sql, new String[]{});
	            int length = 17;
	            while(cur.moveToNext())
	            {
	            	HashMap<String, String> map = new HashMap<String, String>();
		            for(int i=0; i < length; i++)
		            {
		            	map.put(cur.getColumnName(i), cur.getString(i));
		            }
		            list.add(map);
	            }
	            cur.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return list;        
	 }
	 public void execSql(String SQL)
	 {
		 SQLiteDatabase db = helper.getWritableDatabase();
		 db.execSQL(SQL);
	 }
	 /**
	  * 领取任务时使用
	  * @param ID 任务在NeedInfo中的ID
	  */
	 public void insertIntoMessageInfo(int ID)
	 {
		 String sql = "insert into MessageInfo select * from NeedInfo where ID = '" + ID + "';";
		 execSql(sql);
		 sql = "delete from NeedInfo where ID = '" + ID + "';";
		 execSql(sql);
	 }
	 /**
	  * 选择拒绝任务时使用，删除数据库中数据，但是表单中的数据还要手动处理
	  * @param ID
	  */
	 public void RefuseNeed(int ID)
	 {
		 String sql = "delete from NeedInfo where ID = '" + ID + "';";
		 execSql(sql);
	 }
}
