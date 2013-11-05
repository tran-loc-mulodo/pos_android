package com.example.thithi;

import java.util.ArrayList;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFrag extends Fragment{
	private LinearLayout BillProductLayout;
	private ListView lv;
    
    String []ten={ "kim hee sun","kim nam joo",
					"kim so eun","kim tae hee",
					"kim chi","kimbap", 
					"kim hee sun","kim nam joo",
					"kim so eun","kim tae hee",
					"kim chi","kimbap"
    
    };

//    int []hinh={ R.drawable.kimheesun,R.drawable.kimnamjoo,
//	   	R.drawable.kimsoeun,R.drawable.kimtaehee,
//	   	R.drawable.kimchi,R.drawable.kimbap, 
//	   	
//	   	R.drawable.kimheesun,R.drawable.kimnamjoo,
//	   	R.drawable.kimsoeun,R.drawable.kimtaehee,
//	   	R.drawable.kimchi,R.drawable.kimbap
//    };
    ArrayList<motnguoidep> ds = new ArrayList<motnguoidep>();

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
//		loadGridviewData(param);
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
		
		ds.add(new motnguoidep(R.drawable.kimbap, "kimbap"));
        ds.add(new motnguoidep(R.drawable.kimchi, "kimchi"));
        ds.add(new motnguoidep(R.drawable.kimheesun, "kimheesun"));
        ds.add(new motnguoidep(R.drawable.kimnamjoo, "kimnamjoo"));
        ds.add(new motnguoidep(R.drawable.kimsoeun, "kimsoeun"));
        ds.add(new motnguoidep(R.drawable.kimtaehee, "kimtaehee"));
        
        Toast.makeText(getActivity(), "Loc test bii", Toast.LENGTH_SHORT).show();
        
//        lv.setAdapter(new myadapter(this,ten));     //cach 1
        lv.setAdapter(new myadapter1(getActivity().getApplicationContext()));      //cach 2
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
	
		class myadapter extends ArrayAdapter{
			Context context;
			

			public myadapter(Context context,String [] ten)
			{
				super(context,R.layout.listview_item,ten);
				this.context=context;
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// dung layoutinflater lấy đọc cấu trúc và nội dung của từng hàng listview
				LayoutInflater inf=(LayoutInflater)
						context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View rowview=inf.inflate(R.layout.listview_item,parent, false);
				
				//ánh xạ từng hàng listview , cập nhật thông tin
				TextView textview=(TextView)rowview.findViewById(R.id.textView1);
				ImageView imageview=(ImageView)rowview.findViewById(R.id.imageView1);
				
//				textview.setText(ten[position]);
//				imageview.setImageResource(hinh[position]);
				
				return rowview;
			}
		
		}
		
		//cach 2
		
		public static class View_Mot_O
		{
			ImageView imageview;
			TextView textview;
		}
		class myadapter1 extends BaseAdapter{
			Context context;
			
			myadapter1(Context c)
			{
				context=c;
			}
			
			public int getCount() {
				// TODO Auto-generated method stub
				
				return ds.size();
			}

			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return ds.get(arg0);
			}

			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}

			public View getView(int arg0, View arg1, ViewGroup arg2) {
				// TODO Auto-generated method stub
				View_Mot_O mot_o;
				LayoutInflater inf= ((Activity)context).getLayoutInflater();
				if(arg1==null)  
				{  
					mot_o = new View_Mot_O();  
					arg1 = inf.inflate(R.layout.listview_item, null);  
					mot_o.textview = (TextView) arg1.findViewById(R.id.textView1);  
					mot_o.imageview = (ImageView)arg1.findViewById(R.id.imageView1);  
					arg1.setTag(mot_o);  
				}  
				else
					mot_o=(View_Mot_O)arg1.getTag();
				
				
				
				mot_o.imageview.setImageResource(ds.get(arg0).hinh);
				mot_o.textview.setText(ds.get(arg0).ten);
				
				return arg1;
			}
			
		}
}
