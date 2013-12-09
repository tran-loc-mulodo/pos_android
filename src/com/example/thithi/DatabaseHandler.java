package com.example.thithi;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	protected static final int DATABASE_VERSION = 1;

	// Database Name
	protected static final String DATABASE_NAME = "contactsManager";

	// Contacts table name
	protected static final String TABLE_CONTACTS = "contacts";
	
	// Products table name
	protected static final String TABLE_PRODUCTS = "products";
	
	// Product table name for choose product to buy
	protected static final String TABLE_PRODUCTS_NEMO = "products_nemo";
	
	// Order Detail table name
	protected static final String TABLE_ORDER = "order_bill";
	protected static final String TABLE_ORDER_DETAIL = "order_detail";

	// Contacts Table Columns names
	protected static final String KEY_ID = "id";
	protected static final String KEY_NAME = "name";
	protected static final String KEY_PH_NO = "phone_number";
	
	//Products Table Column names
	protected static final String PRO_ID = "id";
	protected static final String PRO_CATEGORY = "category";
	protected static final String PRO_NAME = "name";
	protected static final String PRO_IMG = "img";
	protected static final String PRO_QU_TY = "quantity";
	protected static final String PRO_CDATE = "cdate";
	protected static final String PRO_MDATE = "mdate";
	protected static final String PRO_RE_PRICE = "retail_price";
	protected static final String PRO_WH_PRICE = "whosale_price";
	protected static final String PRO_STATUS = "status";
	
	//Products Table Column names
	protected static final String PRONEMO_ID = "id";
	protected static final String PRONEMO_CATEGORY = "category";
	protected static final String PRONEMO_NAME = "name";
	protected static final String PRONEMO_IMG = "img";
	protected static final String PRONEMO_QU_TY = "quantity";
	protected static final String PRONEMO_CDATE = "cdate";
	protected static final String PRONEMO_MDATE = "mdate";
	protected static final String PRONEMO_RE_PRICE = "retail_price";
	protected static final String PRONEMO_WH_PRICE = "whosale_price";
	protected static final String PRONEMO_STATUS = "status";
	
	//Table for order
	//Products Table Column names
	protected static final String ORDER_ID = "id";
	protected static final String ORDER_NAME = "name";
	protected static final String ORDER_TOTAL_PRICE = "total_price";
	protected static final String ORDER_CDATE = "cdate";
	protected static final String ORDER_MDATE = "mdate";
	
	//Order detail Table Column names
	protected static final String ORDER_DETAIL_ID = "id";
	protected static final String ORDER_DETAIL_ORDER_ID = "order_id";
	protected static final String ORDER_DETAIL_PRODUCT_ID = "product_id";
	protected static final String ORDER_DETAIL_CATEGORY = "category";
	protected static final String ORDER_DETAIL_NAME = "name";
	protected static final String ORDER_DETAIL_IMG = "img";
	protected static final String ORDER_DETAIL_QU_TY = "quantity";
	protected static final String ORDER_DETAIL_CDATE = "cdate";
	protected static final String ORDER_DETAIL_MDATE = "mdate";
	protected static final String ORDER_DETAIL_PRICE = "price";
	protected static final String ORDER_DETAIL_STATUS = "status";
		
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_PH_NO + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
		
		String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
				+ PRO_ID + " INTEGER PRIMARY KEY," + PRO_CATEGORY + " VARCHAR,"
				+ PRO_NAME + " VARCHAR," + PRO_IMG + " VARCHAR," + PRO_QU_TY + " INTEGER," 
				+ PRO_CDATE + " INTEGER," + PRO_MDATE + " INTEGER," + PRO_WH_PRICE + " FLOAT,"
				+ PRO_RE_PRICE + " FLOAT," + PRO_STATUS + " BOOL DEFAULT 1" + ")";
		db.execSQL(CREATE_PRODUCTS_TABLE);
		
		//create table order product nemo
		String CREATE_PRODUCTS_NEMO_TABLE = "CREATE TABLE " + TABLE_PRODUCTS_NEMO + "("
				+ PRONEMO_ID + " INTEGER PRIMARY KEY," + PRONEMO_CATEGORY + " VARCHAR,"
				+ PRONEMO_NAME + " VARCHAR," + PRONEMO_IMG + " VARCHAR," + PRONEMO_QU_TY + " INTEGER," 
				+ PRONEMO_CDATE + " INTEGER," + PRONEMO_MDATE + " INTEGER," + PRONEMO_WH_PRICE + " FLOAT,"
				+ PRONEMO_RE_PRICE + " FLOAT," + PRONEMO_STATUS + " BOOL DEFAULT 1" + ")";
		db.execSQL(CREATE_PRODUCTS_NEMO_TABLE);
		
		//create table order
		String CREATE_ORDER_TABLE = "CREATE TABLE " + TABLE_ORDER + "("
				+ ORDER_ID + " INTEGER PRIMARY KEY," + ORDER_NAME + " TEXT,"
				+ ORDER_TOTAL_PRICE + " LONG," + ORDER_CDATE + " INTEGER," + ORDER_MDATE + " INTEGER" + ")";
		db.execSQL(CREATE_ORDER_TABLE);
		
		//create table order detail
		String CREATE_ORDER_DETAIL_TABLE = "CREATE TABLE " + TABLE_ORDER_DETAIL + "("
				+ ORDER_DETAIL_ID + " INTEGER PRIMARY KEY," + ORDER_DETAIL_ORDER_ID + " INTEGER ," + ORDER_DETAIL_PRODUCT_ID 
				+ " INTEGER ," + ORDER_DETAIL_CATEGORY + " VARCHAR,"
				+ ORDER_DETAIL_NAME + " VARCHAR," + ORDER_DETAIL_IMG + " VARCHAR," + ORDER_DETAIL_QU_TY + " INTEGER," 
				+ ORDER_DETAIL_CDATE + " DOUBLE," + ORDER_DETAIL_MDATE + " DOUBLE," + ORDER_DETAIL_PRICE + " FLOAT,"
				+ ORDER_DETAIL_STATUS + " BOOL DEFAULT 1" + ")";
		db.execSQL(CREATE_ORDER_DETAIL_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS_NEMO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER_DETAIL);
		// Create tables again
		onCreate(db);
	}

	

}
