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

	// Contacts Table Columns names
	protected static final String KEY_ID = "id";
	protected static final String KEY_NAME = "name";
	protected static final String KEY_PH_NO = "phone_number";
	
	//Products Table Column names
	protected static final String PRO_ID = "id";
	protected static final String PRO_NAME = "name";
	protected static final String PRO_IMG = "img";
	protected static final String PRO_CDATE = "cdate";
	protected static final String PRO_MDATE = "mdate";
	protected static final String PRO_RE_PRICE = "retail_price";
	protected static final String PRO_WH_PRICE = "whosale_price";
	protected static final String PRO_STATUS = "status";

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
				+ PRO_ID + " INTEGER PRIMARY KEY," + PRO_NAME + " VARCHAR,"
				+ PRO_IMG + " VARCHAR," + PRO_CDATE + " INTEGER," 
				+ PRO_MDATE + " INTEGER," + PRO_WH_PRICE + " FLOAT,"
				+ PRO_RE_PRICE + " FLOAT," + PRO_STATUS + " BOOL DEFAULT 1" + ")";
		db.execSQL(CREATE_PRODUCTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);

		// Create tables again
		onCreate(db);
	}

	

}
