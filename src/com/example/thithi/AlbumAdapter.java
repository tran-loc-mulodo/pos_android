package com.example.thithi;


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumAdapter extends BaseAdapter{
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
		
	List<Contact> mcontacts ;
	public AlbumAdapter(Context context,List<Contact> contacts )
	{
//		mVector = vectorPhotoOtherUser;
		mContext = context;
//		mImage=new ImageLoader(mContext);
		mcontacts = contacts;
	}
	
	/*
	 * get item size in adapter
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
//		return mVector.getPropertyCount();
		return mcontacts.size();
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
	
				 convertView = inflator.inflate(R.layout.gridview_product , null);
				 view.imgChoice = (ImageView) convertView
						.findViewById(R.id.imgGridview);
//				 view.imgChoice.setImageResource(hinh[position]);
				 
				// Set name for image
				  view.txtNameofCake = (TextView) convertView.findViewById(R.id.kindofcake);
				  view.txtNameofCake.setText(mcontacts.get(position)._name);
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
		 public ImageView imgChoice;
		 public TextView txtNameofCake;
	}

}
