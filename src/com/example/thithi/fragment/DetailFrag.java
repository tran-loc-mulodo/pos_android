package com.example.thithi.fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.thithi.MainActivity;
import com.example.thithi.Order;
import com.example.thithi.OrderDetail;
import com.example.thithi.OrderDetailNemo;
import com.example.thithi.Product;
import com.example.thithi.R;
import com.example.thithi.SQLProducts;
import com.example.thithi.R.drawable;
import com.example.thithi.R.id;
import com.example.thithi.R.layout;
import com.example.thithi.adapter.AlbumAdapter;
import com.example.thithi.adapter.DetailAdapter;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DetailFrag extends Fragment implements OnClickListener{
	private RelativeLayout BillProductLayout;
	public ListView lv;
	public Product productItem = new Product();
	public List<Product> productBill = new ArrayList<Product>();
	public DetailAdapter adapterBill;
	public Button btn_save_bill , btn_cancel_bill ;
	private SQLProducts productdb;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		productdb = new SQLProducts(getActivity());
		initLayout(inflater);
		loadListviewData();
		initEvent();
		
		return BillProductLayout;
	}
	
	/*
	 * init event
	 */
	private void initEvent() {
		// TODO Auto-generated method stub
		btn_save_bill.setOnClickListener(this);
//		btn_register.setOnClickListener(this);

	}
	
	/*
	 * init layout
	 */
	private void initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		BillProductLayout = (RelativeLayout) inflater.inflate(R.layout.detail_fragment,null);
		lv = (ListView)BillProductLayout.findViewById(R.id.listView1);
		btn_save_bill = (Button)BillProductLayout.findViewById(R.id.BillProductLayout_btn_bill_save);
        
//        lv.setAdapter(new myadapter(this,ten));     //cach 1
//        lv.setAdapter(new myadapter1(getActivity().getApplicationContext()));      //cach 2
//		tv_banhkem = (TextView)ListProductLayout.findViewById(R.id.tabBanhKem);
//		tv_khac = (TextView)ListProductLayout.findViewById(R.id.tabKhac);
//		tv_banhngot = (TextView)ListProductLayout.findViewById(R.id.tabBanhNgot); 
		
	}

//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		View view = inflater.inflate(R.layout.detail_fragment, container, false);
//		return view;
//	}

//	public void setText(String item) {
//		TextView view = (TextView) getView().findViewById(R.id.captain);
//		view.setText(item);
//	}
	
	//cach 1
	
	/**
	 * Function to load the listview data from SQLite database
	 * */
	private void loadListviewData() {
		// database handler
		
//		SQLProducts productdb = new SQLProducts(getActivity());
//		SQLOrderDetailNemo orderdetaildb = new SQLOrderDetailNemo(getActivity());
		
		productBill = productdb.getProductsNemoBill(); 
		adapterBill = new DetailAdapter(getActivity() , productBill); 
//		for (Product cn : products) {
//            String log = "Id: "+cn.getID() +" ,Category: " + cn.getCategory() +" ,Name: " + cn.getName() + " ,Image: " + cn.getImage();
//            // Writing Contacts to log
//            Log.d("Name loc test : ", log);
//        
//        }
		
		lv.setAdapter(adapterBill);
		//Log.d("log product", productsBill.size()+"");
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(
						R.id.billArea);
//				frag.setText(position+"");
//				if (frag != null && frag.isInLayout()) {
//					frag.setText("loc test nhe");
//				}
			}
		});
	
	}
	
//	public void setProductToBill(){
//		
//		
//			for ( int i=0 ; i < productsBill.size() ; i++) {
//				Log.e("AAA", productsBill.get(i).getName());
//				
//	        
//	        }
//			adapterBill.notifyDataSetChanged();
//		
//		
//		
//	}

	/*
	 * event click
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btn_save_bill) {
			String orderName = "Khac hang thuong";
			float total_price = 15.0f; 
			long id = productdb.addNewOrder(new Order(orderName, total_price));
			for (Product pn : this.productBill) {
	            // Writing Contacts to log
				int orderid = (int) id;
				Calendar c = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
//				String strDate = sdf.format(c.getTime());
				long msTime = System.currentTimeMillis();
				
				Date curDateTime = new Date(msTime);
				String strDate = sdf.format(curDateTime);
				int product_id = pn.getID();
				String category = pn.getCategory();
				String product_name = pn.getName();
				int qty = pn.getQuantity();
				Float price = pn.getRetailPrice();
				productdb.addNewOrderDetail(new OrderDetail(orderid ,product_id, category, product_name, qty, msTime , msTime , price));
				
				//Delete all product in table product nemo
				productdb.deleteProductNemo();
	        }
			
		}
		

		/*if (v == btn_login) {
			Toast.makeText(getActivity(), spinner_category.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
			((MainActivity) getActivity()).startFragmentBill();
			
			String Category = spinner_category.getSelectedItem().toString();
			String Name = ed_product_add_name.getText().toString();
			String Image = spinner_image.getSelectedItem().toString();
			SQLProducts productdb = new SQLProducts(getActivity());
	       
	        // Inserting Contacts
	        Log.d("Insert: ", "Inserting ..");
	        productdb.addProduct(new Product(Category , Name , Image));
	        
	     // Reading all contacts
	        Log.d("Reading: ", "Reading all contacts..");
	        List<Product> products = productdb.getAllProducts();       
	 
	        for (Product cn : products) {
	            String log = "Id: "+cn.getID() +" ,Category: " + cn.getCategory() +" ,Name: " + cn.getName() + " ,Image: " + cn.getImage();
	            // Writing Contacts to log
	            Log.d("Name loc test : ", log);
	        
	        }
	     

		}*/
		((MainActivity) getActivity()).startFragmentBill();
	}
}
