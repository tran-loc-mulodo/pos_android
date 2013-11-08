package com.example.thithi.adapter;


import java.util.List;

import com.example.thithi.Contact;
import com.example.thithi.Product;
import com.example.thithi.R;
import com.example.thithi.R.id;
import com.example.thithi.R.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailAdapter extends BaseAdapter{
//	int[]hinh={R.drawable.cake_01,R.drawable.cake_02,R.drawable.cake_03
//			,R.drawable.cake_04,R.drawable.cake_05,R.drawable.cake_06
//			,R.drawable.cake_01,R.drawable.cake_02,R.drawable.cake_03
//			,R.drawable.cake_04,R.drawable.cake_05,R.drawable.cake_06
//		  };
	String[]ten={"1T2","1T2","1T2","1T2","1T2","1T2",
			"1T5","1T5","1T5","1T5","1T5","1T5"};
//	private VectorPhotoOtherUser mVector;
	private Context mContext;
//	private ImageLoader imageLoader;
	private ImageView mImage;
	private TextView mNameCake;
		
	List<Product> nproducts ;
	public DetailAdapter(Context context,List<Product> products )
	{
//		mVector = vectorPhotoOtherUser;
		mContext = context;
//		mImage=new ImageLoader(mContext);
		nproducts = products;
	}
	
	/*
	 * get item size in adapter
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
//		return mVector.getPropertyCount();
		return nproducts.size();
	}

	/*
	 * get item in adapter
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
//		return mVector.getProperty(index);
//		return mcontacts[position];
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * Init view 
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder view;
		 LayoutInflater inflator = LayoutInflater.from(mContext);	
			if (convertView == null) {
				  view = new ViewHolder();		
	
				 convertView = inflator.inflate(R.layout.listview_item , null);
//				 view.imgChoice = (ImageView) convertView.findViewById(R.id.imgGridview);
//				 view.imgChoice.setImageResource(hinh[position]);
				 
				// Set name for image
				 view.txtNameofCakeBill = (TextView) convertView.findViewById(R.id.nameofproductBill);
				  view.txtNameofCakeBill.setText(nproducts.get(position)._name);
				  convertView.setTag(view);
			} else {
				  view = (ViewHolder)convertView.getTag();
			}
			
		return convertView;
		
	}

	/*
	 * Class view holder
	 */
	 public static class ViewHolder {
		 public TextView txtNameofCakeBill;
	}

}
