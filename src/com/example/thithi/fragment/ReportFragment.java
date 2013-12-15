package com.example.thithi.fragment;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.thithi.MainActivity;
import com.example.thithi.Product;
import com.example.thithi.R;
import com.example.thithi.SQLProducts;
import com.example.thithi.R.id;
import com.example.thithi.R.layout;
import com.example.thithi.dialog.DatePickerDialogFragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressLint("SimpleDateFormat")
public class ReportFragment extends Fragment implements OnClickListener {

	private static final String TAG = ReportFragment.class.getName();
	private RelativeLayout ReportPageLayout;
	private EditText ed_report_date;
	private LinearLayout linear_report_date;
	private Button btn_report , btn_current_date;
	private String date;
	static final int DATE_DIALOG_ID = 999;
	private SQLProducts productdb;
	
	private Handler mHandler ;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	/*
	 * init fragment contains view and event
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initLayout(inflater);
		initEvent();
		inthandlerDay();
		return ReportPageLayout;
	}

	/*
	 * init event
	 */
	private void initEvent() {
		// TODO Auto-generated method stub
		btn_report.setOnClickListener(this);
		linear_report_date.setOnClickListener(this);
		ed_report_date.setOnClickListener(this);
		btn_current_date.setOnClickListener(this);
		
	}
	
	/*
	 * init handle receive value
	 */
	@SuppressLint("HandlerLeak")
	private void inthandlerDay()
	{
		mHandler = new Handler(){
		        @Override
		        public void handleMessage(Message m){
		            /** Creating a bundle object to pass currently set date to the fragment */
		            Bundle b = m.getData();
		            ed_report_date.setText( b.getInt("set_day")+"/"+(b.getInt("set_month")+1)
		            		+"/"+  b.getInt("set_year"));
		            date=(b.getInt("set_year")+"/"+(b.getInt("set_month")+1)
		            		+"/"+  b.getInt("set_day"));
		        }
		    };
	}

	/*
	 * init layout
	 */
	private void initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		ReportPageLayout = (RelativeLayout) inflater.inflate(R.layout.report,
				null);
		linear_report_date = (LinearLayout) ReportPageLayout
				.findViewById(R.id.linear_report_date);
		ed_report_date = (EditText) ReportPageLayout
				.findViewById(R.id.ed_report_date);
		btn_current_date = (Button) ReportPageLayout
				.findViewById(R.id.btn_current_date);
		btn_report = (Button) ReportPageLayout.findViewById(R.id.btn_report);
		
		productdb = new SQLProducts(getActivity());
	}

	/*
	 * event click
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btn_report) {
//			Toast.makeText(getActivity(), spinner_category.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//			((MainActivity) getActivity()).startFragmentBill();
//			
//			String Category = spinner_category.getSelectedItem().toString();
//			String Name = ed_product_add_name.getText().toString();
//			String Image = spinner_image.getSelectedItem().toString();
//			Float whoPrice =  Float.parseFloat(ed_product_add_who_price.getText().toString());
//			Float retailPrice =  Float.parseFloat(ed_product_add_retail_price.getText().toString());
	        /**
	         * CRUD Operations
	         * */
	        // Inserting Contacts
//	        Log.d("Insert: ", "Inserting ..");
//	        productdb.addProduct(new Product(Category , Name , Image , whoPrice , retailPrice));
	        // For comment
//	        List<Product> products = productdb.getAllProducts();       
		}
		
		/*
		 * event button delete text birthday
		 */
		if (v == btn_current_date) {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss a");
//			String strDate = sdf.format(c.getTime());
			long msTime = System.currentTimeMillis();
			Date curDateTime = new Date(msTime);
			String strDate = sdf.format(curDateTime);
			Date date;
			long millis;
			try {
				date = sdf.parse(strDate);
				millis = date.getTime();
				Toast.makeText(getActivity(), millis+ "test", Toast.LENGTH_SHORT).show();
				ed_report_date.setText(strDate); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // You will need try/catch around this
			
		}
		
		/*
		 * event button delete text birthday
		 */
		if (v == linear_report_date) {
			ed_report_date.setText("");
		}
		
		/*
		 * event button birthday
		 */
		if (v == ed_report_date)
		{
            Bundle b = new Bundle();
            SimpleDateFormat year = new SimpleDateFormat("yyyy");
    		SimpleDateFormat month = new SimpleDateFormat("MM");
    		SimpleDateFormat day = new SimpleDateFormat("dd");
    	
            b.putInt("set_day", Integer.parseInt( day.format(new Date())));
            b.putInt("set_month",Integer.parseInt( month.format(new Date())));
            b.putInt("set_year", Integer.parseInt( year.format(new Date())));
            DatePickerDialogFragment datePicker = new DatePickerDialogFragment();
            datePicker.mHandler = mHandler;

            /** Setting the bundle object on datepicker fragment */
            datePicker.setArguments(b);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(datePicker, "date_picker");
            ft.commit();
		}

	}
	
	


}
