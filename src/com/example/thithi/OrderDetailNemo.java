package com.example.thithi;

import java.util.List;

import android.R.bool;
import android.widget.Toast;

public class OrderDetailNemo {
	//private variables
		int _id;
		String _category;
		public String _name;
		int _qty;
		int _cdate;
		Float _whosale_price;
		Float _retail_price;
		bool _status;
		
		// Empty constructor
		public OrderDetailNemo(){
			
		}
		
		// constructor
		public OrderDetailNemo(int id, String category , String name, int qty , Float wh_price , Float re_price){
			this._id = id;
			this._category = category;
			this._name = name;
			this._qty = qty;
			this._whosale_price = wh_price;
			this._retail_price = re_price;
		}
		
		// constructor
		public OrderDetailNemo(int id, String category , String name, int qty , Float wh_price ){
			this._id = id;
			this._category = category;
			this._name = name;
			this._qty = qty;
			this._whosale_price = wh_price;
		}
		
		// constructor
		public OrderDetailNemo(int id, String category , String name,  int qty){
			this._id = id;
			this._category = category;
			this._name = name;
			this._qty = qty;
		}
				
		// constructor
		public OrderDetailNemo(int id, String category , String name){
			this._id = id;
			this._category = category;
			this._name = name;
		}
		
		// constructor
		public OrderDetailNemo(String category , String name,  int qty){
			this._category = category;
			this._name = name;
			this._qty = qty;
		}
		
		// constructor
		public OrderDetailNemo(String category , String name){
			this._category = category;
			this._name = name;
		}
				
		// constructor
		public OrderDetailNemo(String name){
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
		
		// getting category
		public String getCategory(){
			return this._category;
		}
		
		// setting name
		public void setCategory(String category){
			this._category = category;
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
		
		// getting whosale price
		public Float getWhosallePrice(){
			return this._whosale_price;
		}
		
		// setting whosale price
		public void setWhosallePrice(Float Wholesale_price){
			this._whosale_price = Wholesale_price;
		}
		
		// getting retail price
		public Float getRetailPrice(){
			return this._whosale_price;
		}
		
		// setting retail price
		public void setRetailPrice(Float Wholesale_price){
			this._whosale_price = Wholesale_price;
		}
		
		// getting status
		public bool getStatus(){
			return this._status;
		}
		
		// setting status
		public void setStatus(bool status){
			this._status = status;
		}

		public void addOrderDetailObject(int id, String category , String name,  int qty){
			this._id = id;
			this._category = category;
			this._name = name;
			this._qty = qty;
		}
		
		public void addOrderDetailObject(OrderDetailNemo order_dt){
			
			this._id = order_dt._id;
			this._category = order_dt._category;
			this._name = order_dt._name;
			this._qty = 1;
			
		}
}
