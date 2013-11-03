package com.example.thithi;

import android.os.Environment;

public class MainApplication {

	
	private final static String TAG = MainApplication.class.getName();
	private static MainApplication singleton;
	public static String OAuthkey,UserID , UserName;
	public static String UrlServer = "http://thithi.vn/api/";
//	public static String UrlServer = "http://192.168.0.116:8888/API_LMB/api/";
	public static String strPathSDCard = Environment
			.getExternalStorageDirectory().toString() + "/LMB_UploadImage";
	public static int intButton = 0;
	
	public static MainApplication getInstance(){
		return singleton;
	}
}
