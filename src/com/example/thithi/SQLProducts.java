package com.example.thithi;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLProducts extends DatabaseHandler {

	public SQLProducts(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new product
	void addProduct(Product product) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(PRO_CATEGORY, product.getCategory()); // Product  Category
		values.put(PRO_NAME, product.getName()); // Product  Name
		values.put(PRO_IMG, product.getImage()); // Product Image

		// Inserting Row
		db.insert(TABLE_PRODUCTS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	Product getProduct(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_PRODUCTS, new String[] { PRO_ID, PRO_CATEGORY ,
				PRO_NAME, PRO_IMG }, PRO_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Product product = new Product(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3));
		// return product
		return product;
	}
	
	// Getting All Contacts
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Product product = new Product();
				product.setID(Integer.parseInt(cursor.getString(0)));
				product.setCategory(cursor.getString(1));
				product.setName(cursor.getString(2));
				product.setImage(cursor.getString(3));
//				product.setQuantity(Integer.parseInt(cursor.getString(4)));
				// Adding product to list
				productList.add(product);
			} while (cursor.moveToNext());
		}

		// return contact list
		return productList;
	}
	
	// Getting Products with category
		public List<Product> getAllProducts(String cateName) {
			List<Product> productList = new ArrayList<Product>();
			// Select All Query
			String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS + " WHERE " + PRO_CATEGORY + " ='" + cateName + "'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Product product = new Product();
					product.setID(Integer.parseInt(cursor.getString(0)));
					product.setCategory(cursor.getString(1));
					product.setName(cursor.getString(2));
					product.setImage(cursor.getString(3));
//					product.setQuantity(Integer.parseInt(cursor.getString(4)));
					// Adding product to list
					productList.add(product);
				} while (cursor.moveToNext());
			}

			// return contact list
			return productList;
		}
		
		// Getting Products for bill
		public List<Product> getProductsBill() {
			List<Product> productList = new ArrayList<Product>();
			// Select All Query
			String selectQuery = "SELECT " +PRO_ID + " , " +PRO_CATEGORY + " , " + PRO_NAME + " , " + PRO_QU_TY 
								+ " FROM " + TABLE_PRODUCTS;

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Product product = new Product();
					product.setID(Integer.parseInt(cursor.getString(0)));
					product.setCategory(cursor.getString(1));
					product.setName(cursor.getString(2));
					product.setQuantity(1);
//					product.setQuantity(Integer.parseInt(cursor.getString(4)));
					// Adding product to list
					productList.add(product);
				} while (cursor.moveToNext());
			}

			// return contact list
			return productList;
		}
	
	// Updating single product
	public int updateProduct(Product product) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(PRO_NAME, product.getName());
		values.put(PRO_IMG, product.getImage());

		// updating row
		return db.update(TABLE_PRODUCTS, values, PRO_ID + " = ?",
				new String[] { String.valueOf(product.getID()) });
	}

	// Deleting single product
	public void deleteProduct(Product product) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_PRODUCTS , PRO_ID + " = ?",
				new String[] { String.valueOf(product.getID()) });
		db.close();
	}


	// Getting products Count
	public int getProductsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_PRODUCTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
