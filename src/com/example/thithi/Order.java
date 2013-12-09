package com.example.thithi;

import java.util.List;

import android.R.bool;
import android.widget.Toast;

public class Order {
	//private variables
		int _id;
		public String _name;
		int _qty;
		int _cdate;
		int _mdate;
		Float _total_price;
		bool _status;
		
		// Empty constructor
		public Order(){
			
		}
		
		// constructor
		public Order(int id,  String name, int qty){
			this._id = id;
			this._name = name;
			this._qty = qty;
		}
		
		// constructor
		public Order(String name, Float total_price){
			this._name = name;
			this._total_price = total_price;
		}
		
		// constructor
		public Order(String name,  int qty){
			this._name = name;
			this._qty = qty;
		}
				
		// constructor
		public Order(int id,  String name){
			this._id = id;
			this._name = name;
		}
		
		// constructor
		public Order(String name){
			this._name = name;
		}
				
		
		
		// getting ID
		public int getID(){
			return this._id;
		}
		
		// setting id
		public void setID(int id){
			this._id = id;
		}
		
		// getting name
		public String getName(){
			return this._name;
		}
		
		// setting name
		public void setName(String name){
			this._name = name;
		}
		
		// getting quantity
		public int getQuantity(){
			return this._qty;
		}
		
		// setting quantity
		public void setQuantity(int qty){
			this._qty = qty;
		}
		
		// getting create date
		public int getCreateDate(){
			return this._cdate;
		}
		
		// setting create date
		public void setCreateDate(int cdate){
			this._cdate = cdate;
		}
		
		// getting modify date
		public int getModifyDate(){
			return this._mdate;
		}
		
		// setting modify date
		public void setModifyDate(int mdate){
			this._mdate = mdate;
		}
		
		// getting total price
		public Float getTotalPrice(){
			return this._total_price;
		}
		
		// setting total price
		public void setTotalPrice(Float Total_price){
			this._total_price = Total_price;
		}
		
		// getting status
		public bool getStatus(){
			return this._status;
		}
		
		// setting status
		public void setStatus(bool status){
			this._status = status;
		}

//		public void setProduct(int id, String category , String name,  int qty){
//			this._id = id;
//			this._name = name;
//			this._qty = qty;
//		}
//		
//		public void setProduct(Order aproducts){
//			
//			this._id = aproducts._id;
//			this._name = aproducts._name;
//			this._qty = 1;
//			
//		}
}
