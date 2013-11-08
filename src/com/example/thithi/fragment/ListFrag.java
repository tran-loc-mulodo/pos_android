package com.example.thithi.fragment;

import java.util.List;

import com.example.thithi.Product;
import com.example.thithi.R;
import com.example.thithi.SQLProducts;
import com.example.thithi.R.id;
import com.example.thithi.R.layout;
import com.example.thithi.adapter.AlbumAdapter;
import com.example.thithi.adapter.DetailAdapter;


import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListFrag extends Fragment implements OnClickListener {
	
	private static final String TAG = ListFragment.class.getName();
	private RelativeLayout ListProductLayout;
	private GridView gv;
	private TextView tv_banhkem , tv_banhngot , tv_khac;
	private List<Product> products;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		String param = "Banh kem";
		initLayout(inflater);
		loadGridviewData(param);
		initEvent();
		// Loading spinner data from database
		
		return ListProductLayout;
	}
	
	/*
	 * init event
	 */
	private void initEvent() {
		// TODO Auto-generated method stub
		tv_banhkem.setOnClickListener(this);
		tv_banhngot.setOnClickListener(this);
		tv_khac.setOnClickListener(this);
	}
	
	/*
	 * init layout
	 */
	private void initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		ListProductLayout = (RelativeLayout) inflater.inflate(R.layout.list_fragment,null);
		gv = (GridView)ListProductLayout.findViewById(R.id.gridView1);
		tv_banhkem = (TextView)ListProductLayout.findViewById(R.id.tabBanhKem);
		tv_khac = (TextView)ListProductLayout.findViewById(R.id.tabKhac);
		tv_banhngot = (TextView)ListProductLayout.findViewById(R.id.tabBanhNgot); 
		
	}
	
	/*
	 * event click
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == tv_banhkem) {
			String param = "Banh kem";
			loadGridviewData(param);
		}
		if(v == tv_banhngot){
			
			String param = "Banh ngot";
			Toast.makeText(getActivity(), param, Toast.LENGTH_SHORT).show();
			loadGridviewData(param);
		}
		if(v == tv_khac){
			String param = "Khac";
			loadGridviewData(param);
		}
	}

	
	/**
	 * Function to load the gridview data from SQLite database
	 * */
	private void loadGridviewData(String param) {
		// database handler
		
		SQLProducts productdb = new SQLProducts(getActivity());
		
		products = productdb.getAllProducts(param); 
		 
		for (Product cn : products) {
            String log = "Id: "+cn.getID() +" ,Category: " + cn.getCategory() +" ,Name: " + cn.getName() + " ,Image: " + cn.getImage();
            // Writing Contacts to log
            Log.d("Name loc test : ", log);
        
        }
		
		gv.setAdapter(new AlbumAdapter(getActivity() , products));
		Log.d("log product", products.size()+"");
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				Log.e("AAA","AAAA");
				
				DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(
						R.id.billArea);
				Toast.makeText(getActivity().getApplicationContext(), products.get(position).getID()+products.get(position)._name, Toast.LENGTH_SHORT).show();
//				frag.products.
				Product a = new Product();
				a.setProduct(99, "CAKTGORY", "TEST PRODUCT", 1);
				frag.products.add(a);
				DetailAdapter locAc = new DetailAdapter(getActivity() , products);
				frag.lv.setAdapter(locAc);
//				frag.setText(position+"");
//				if (frag != null && frag.isInLayout()) {
//					frag.setText("loc test nhe");
//				}
			}
		});
	
	}

}
