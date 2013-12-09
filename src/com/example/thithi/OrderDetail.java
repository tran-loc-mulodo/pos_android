package com.example.thithi;

import java.util.List;

import android.R.bool;
import android.widget.Toast;

public class OrderDetail {
	//private variables
		int _id;
		int _order_id;
		int _product_id;
		String _category;
		public String _name;
		public String _img;
		int _qty;
		long _cdate;
		long _mdate;
		Float _price;
		bool _status;
		
		// Empty constructor
		public OrderDetail(){
			
		}
		
		// constructor
		public OrderDetail(int id, String category , String name, String img , int qty){
			this._id = id;
			this._category = category;
			this._name = name;
			this._img = img;
			this._qty = qty;
		}
		
		// constructor
		public OrderDetail(int id, int order_id , int product_id , String category , String name,  int qty , Float price ){
			this._id = id;
			this._order_id = order_id;
			this._product_id = product_id;
			this._category = category;
			this._name = name;
			this._qty = qty;
			this._price = price;
		}
		
		// constructor
		public OrderDetail(int order_id, int product_id , String category , String name,  int qty , long cdate , long mdate , Float price ){
			this._order_id = order_id;
			this._product_id = product_id;
			this._category = category;
			this._name = name;
			this._qty = qty;
			this._cdate = cdate;
			this._mdate = mdate;
			this._price = price;
		}
		
		// constructor
		public OrderDetail(int order_id, int product_id , String category , String name,  int qty , int cdate , Float price ){
			this._order_id = order_id;
			this._product_id = product_id;
			this._category = category;
			this._name = name;
			this._qty = qty;
			this._cdate = cdate;
			this._price = price;
		}
		
		// constructor
		public OrderDetail(int order_id, int product_id , String category , String name,  int qty , Float price ){
			this._order_id = order_id;
			this._product_id = product_id;
			this._category = category;
			this._name = name;
			this._qty = qty;
			this._price = price;
		}
		
		// constructor
		public OrderDetail(int product_id, String category , String name,  int qty , Float price ){
			this._product_id = product_id;
			this._category = category;
			this._name = name;
			this._qty = qty;
			this._price = price;
		}
				
		// constructor
		public OrderDetail(int id, String category , String name,  int qty){
			this._id = id;
			this._category = category;
			this._name = name;
			this._qty = qty;
		}
				
		// constructor
		public OrderDetail(int id, String category , String name, String img){
			this._id = id;
			this._category = category;
			this._name = name;
			this._img = img;
		}
		
		// constructor
		public OrderDetail(String category , String name, String img){
			this._category = category;
			this._name = name;
			this._img = img;
		}
									
				
		// constructor
		public OrderDetail(String name, String img){
			this._name = name;
			this._img = img;
		}
		
		// getting ID
		public int getID(){
			return this._id;
		}
		
		// setting id
		public void setID(int id){
			this._id = id;
		}
		
		// getting Order ID
		public int getOrderID(){
			return this._order_id;
		}
		
		// setting Order id
		public void setOrderID(int orderId){
			this._order_id = orderId;
		}
		
		// getting Product ID
		public int getProductID(){
			return this._product_id;
		}
		
		// setting Product id
		public void setProductID(int productid){
			this._product_id = productid;
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
		
		// getting image
		public String getImage(){
			return this._img;
		}
		
		// setting image
		public void setImage(String image){
			this._img = image;
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
		public long getCreateDate(){
			return this._cdate;
		}
		
		// setting create date
		public void setCreateDate(int cdate){
			this._cdate = cdate;
		}
		
		// getting modify date
		public long getModifyDate(){
			return this._mdate;
		}
		
		// setting modify date
		public void setModifyDate(int mdate){
			this._mdate = mdate;
		}
		
		// getting price
		public Float getPrice(){
			return this._price;
		}
		
		// setting price
		public void setPrice(Float price){
			this._price = price;
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
//			this._category = category;
//			this._name = name;
//			this._qty = qty;
//		}
//		
//		public void setProduct(OrderDetail aproducts){
//			
//			this._id = aproducts._id;
//			this._category = aproducts._category;
//			this._name = aproducts._name;
//			this._qty = 1;
//			
//		}
}
