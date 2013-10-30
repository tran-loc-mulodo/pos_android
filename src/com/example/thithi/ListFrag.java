package com.example.thithi;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListFrag extends Fragment {
	GridView gv;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_fragment, container, false);
		gv = (GridView)view.findViewById(R.id.gridView1);
		
		DatabaseHandler db = new DatabaseHandler(getActivity());
		List<Contact> contacts = db.getAllContacts();       
		 
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//            Toast.makeText(getActivity().getApplicationContext(), cn.getName(), Toast.LENGTH_SHORT).show();
                // Writing Contacts to log
        Log.d("Name: ", log);
        
        }
        
		gv.setAdapter(new AlbumAdapter(getActivity() , contacts));
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				Log.e("AAA","AAAA");
				
				DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(
						R.id.billArea);
				frag.setText(position+"");
				if (frag != null && frag.isInLayout()) {
					frag.setText("loc test nhe");
				}
			}
		});
		
		
		return view;
	}

	@Override
	  public void onResume() {
	     Log.e("DEBUG", "onResume of HomeFragment");
	     super.onResume();
	     Toast.makeText(getActivity(), "show ra nha", Toast.LENGTH_SHORT).show();
	  }

	  @Override
	  public void onPause() {
	     Log.e("DEBUG", "OnPause of HomeFragment");
	     super.onPause();
	     Toast.makeText(getActivity(), "show on pause", Toast.LENGTH_SHORT).show();
	  }

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Toast.makeText(getActivity(), "show on start", Toast.LENGTH_SHORT).show();
	}
	
	
	

//	@Override
//	public void onListItemClick(ListView l, View v, int position, long id) {
//		String item = (String) getListAdapter().getItem(position);
//		DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(
//				R.id.frag_capt);
//		if (frag != null && frag.isInLayout()) {
//			frag.setText(getCapt(item));
//		}
//	}

//	private String getCapt(String ship) {
//		if (ship.toLowerCase().contains("enterprise")) {
//			return "Johnathan Archer";
//		}
//		if (ship.toLowerCase().contains("star trek")) {
//			return "James T. Kirk";
//		}
//		if (ship.toLowerCase().contains("next generation")) {
//			return "Jean-Luc Picard";
//		}
//		if (ship.toLowerCase().contains("deep space 9")) {
//			return "Benjamin Sisko";
//		}
//		if (ship.toLowerCase().contains("voyager")) {
//			return "Kathryn Janeway";
//		}
//		return "???";
//	}

/////////////class đại dien cho  1 ô //////    
//public static class View_Mot_O
//{
//public ImageView imageview;
//public TextView textview;
//}
///////ket thuc class View_Mot_O///////////

/*public class myadapter extends BaseAdapter
{
Context context;
public myadapter(Context c)
{
	context=c;
}

public int getCount() {
	// TODO Auto-generated method stub
	return hinh.length;
}

public Object getItem(int position) {
	// TODO Auto-generated method stub
	return hinh[position];
}

public long getItemId(int arg0) {
	// TODO Auto-generated method stub
	return 0;
}

public View getView(int arg0, View convertView, ViewGroup arg2) {
	// TODO Auto-generated method stub
	View_Mot_O mot_o;
	LayoutInflater layoutinflater= ((Activity)context).getLayoutInflater();
	convertView = layoutinflater.inflate(R.layout.list_fragment, null);
	if(convertView==null)  
	{  
		mot_o = new View_Mot_O();  

//		mot_o.textview = (TextView) arg1.findViewById(R.id.textView1);
		
		mot_o.imageview = (ImageView)convertView.findViewById(R.id.imageView1);
//		mot_o.imageview.getLayoutParams().width = 200;
		
		convertView.setTag(mot_o);  
	}  
	else
		mot_o=(View_Mot_O)convertView.getTag();
	
	
//	mot_o.imageview.getLayoutParams().width = 200;
	mot_o.imageview.setImageResource(hinh[arg0]);
//	if (arg0 %2 == 0)
//	arg1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_left));
//	else 
//		arg1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_right));
	mot_o.textview.setText(ten[arg0]);
	
	return convertView;
}

}*/
}
