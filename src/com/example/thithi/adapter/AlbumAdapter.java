package com.example.thithi.adapter;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thithi.Product;
import com.example.thithi.R;

public class AlbumAdapter extends BaseAdapter{

//	private VectorPhotoOtherUser mVector;
	private Context mContext;
//	private ImageLoader imageLoader;
	private ImageView mImage;
	private TextView mNameCake;
	int mposition;
		
	List<Product> mproducts ;
	public AlbumAdapter(Context context,List<Product> products )
	{
//		mVector = vectorPhotoOtherUser;
		mContext = context;
//		mImage=new ImageLoader(mContext);
		mproducts = products;
	}
	
	/*
	 * get item size in adapter
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
//		return mVector.getPropertyCount();
		return mproducts.size();
	}

	/*
	 * get item in adapter
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
//		return mVector.getProperty(index);
//		return mproducts[position];
		return mproducts.get(position);
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
//				 byte[] decodedByte = Base64.decode(mproducts.get(position)._img, 0);
//				   Bitmap bm = BitmapFactory.decodeByteArray(decodedByte, 0,
//				     decodedByte.length);
//				   view.imgChoice;
//				 try 
//				 {
//				     // get input stream
//					 AssetManager assetManager = getAssets();
//
//					    InputStream istr = assetManager.open(fileName);
//				     InputStream ims = getAssets().open("avatar.jpg");
//				     // load image as Drawable
//				     Drawable d = Drawable.createFromStream(ims, null);
//				     // set image to ImageView
//				     mImage.setImageDrawable(d);
//				 }
//				 catch(IOException ex) 
//				 {
//				     return null;
//				 }
//				   view.imgChoice.setImageResource(Integer.parseInt(mproducts.get(position)._img));
				// load image
			        try {
			            // get input stream
			        	mposition = position;
//			        	Toast.makeText(mContext, mposition+"", Toast.LENGTH_SHORT).show();
			            InputStream ims = mContext.getAssets().open(mproducts.get(position)._img);
			            // load image as Drawable
			            Drawable d = Drawable.createFromStream(ims, null);
			            // set image to ImageView
			            view.imgChoice.setImageDrawable(d);
			            
			        }
			        catch(IOException ex) {
			            Log.d("load image", "loi nhe");
			        }
//				 Log.d("link  hinh", url_image);
				// Set name for image
				   
				  view.txtNameofCake = (TextView) convertView.findViewById(R.id.kindofcake);
				  view.txtNameofCake.setText(mproducts.get(position)._name);
				  
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
