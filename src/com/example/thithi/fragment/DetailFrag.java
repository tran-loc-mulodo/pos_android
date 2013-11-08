package com.example.thithi.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.thithi.Product;
import com.example.thithi.R;
import com.example.thithi.SQLProducts;
import com.example.thithi.motnguoidep;
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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DetailFrag extends Fragment{
	private LinearLayout BillProductLayout;
	public ListView lv;
	public List<Product> products;
//    


//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//	}

//	@Override
//	public void onActivityCreated(Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState);
//
//	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//		String param = "Banh kem";
		initLayout(inflater);
		loadListviewData();
//		initEvent();
		// Loading spinner data from database
		
		return BillProductLayout;
	}
	
	/*
	 * init layout
	 */
	private void initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		BillProductLayout = (LinearLayout) inflater.inflate(R.layout.detail_fragment,null);
		lv = (ListView)BillProductLayout.findViewById(R.id.listView1);
		
        
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
		
		SQLProducts productdb = new SQLProducts(getActivity());
		
		products = productdb.getProductsBill(); 
		 
//		for (Product cn : products) {
//            String log = "Id: "+cn.getID() +" ,Category: " + cn.getCategory() +" ,Name: " + cn.getName() + " ,Image: " + cn.getImage();
//            // Writing Contacts to log
//            Log.d("Name loc test : ", log);
//        
//        }
		
		lv.setAdapter(new DetailAdapter(getActivity() , products));
		Log.d("log product", products.size()+"");
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				Log.e("AAA","AAAA");
				
				DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(
						R.id.billArea);
//				frag.setText(position+"");
//				if (frag != null && frag.isInLayout()) {
//					frag.setText("loc test nhe");
//				}
			}
		});
	
	}
}
