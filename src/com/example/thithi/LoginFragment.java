package com.example.thithi;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import android.app.Fragment;
import android.graphics.LinearGradient;
import android.os.Bundle;
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

public class LoginFragment extends Fragment implements OnClickListener {

	private static final String TAG = LoginFragment.class.getName();
	private RelativeLayout LoginPageLayout;
	private EditText edlogin_email, edlogin_pass , ed_product_add_name;
	private Button btn_login, btn_register;
	private LinearLayout linear_login_eraser_email,
			linear_login_eraser_password;
	// Spinner element
	private Spinner spinner_category , spinner_image;

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
		// Loading spinner data from database
		loadSpinnerData();
		return LoginPageLayout;
	}

	/*
	 * init event
	 */
	private void initEvent() {
		// TODO Auto-generated method stub
		btn_login.setOnClickListener(this);
		btn_register.setOnClickListener(this);
		linear_login_eraser_email.setOnClickListener(this);
		linear_login_eraser_password.setOnClickListener(this);

	}

	/*
	 * init layout
	 */
	private void initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		LoginPageLayout = (RelativeLayout) inflater.inflate(R.layout.login,
				null);
		ed_product_add_name = (EditText) LoginPageLayout
				.findViewById(R.id.ed_product_add_name);
		edlogin_pass = (EditText) LoginPageLayout
				.findViewById(R.id.edlogin_pass);
		btn_login = (Button) LoginPageLayout.findViewById(R.id.btn_login);
		btn_register = (Button) LoginPageLayout.findViewById(R.id.btn_register);
		linear_login_eraser_email = (LinearLayout) LoginPageLayout
				.findViewById(R.id.linear_login_eraser_email);
		linear_login_eraser_password = (LinearLayout) LoginPageLayout
				.findViewById(R.id.linear_login_eraser_password);
		
		spinner_category = (Spinner) LoginPageLayout.findViewById(R.id.product_add_caterogy);
		spinner_image = (Spinner) LoginPageLayout.findViewById(R.id.product_add_image);
	}

	/*
	 * event click
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*if (v == btn_register) {
			((MainActivity) getActivity()).startFragmentRegister();

			// e.show(((MainActivity)getActivity()).getFragmentManager(), TAG);
		}
		if (v == linear_login_eraser_email) {
			edlogin_email.setText("");

		}
		if (v == linear_login_eraser_password) {
			edlogin_pass.setText("");

		}*/

		if (v == btn_login) {
			Toast.makeText(getActivity(), spinner_category.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
			((MainActivity) getActivity()).startFragmentBill();
			
			String Category = spinner_category.getSelectedItem().toString();
			String Name = ed_product_add_name.getText().toString();
			String Image = spinner_image.getSelectedItem().toString();
			SQLProducts productdb = new SQLProducts(getActivity());
	        /**
	         * CRUD Operations
	         * */
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
	     

		}

	}
	
	/**
	 * Function to load the spinner data from SQLite database
	 * */
	private void loadSpinnerData() {
		// database handler
		
		String[]ten={"Banh kem","Banh ngot","Khac"};
		String[]image={"cake_01.png","cake_02.png","cake_03.png",
				"cake_04.png","cake_05.png","cake_06.png"
					};
		
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
				android.R.layout.simple_spinner_item, ten);

		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner_category.setAdapter(dataAdapter);
		
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapterImage = new ArrayAdapter<String>(getActivity().getApplicationContext(),
				android.R.layout.simple_spinner_item, image);

		// Drop down layout style - list view with radio button
		dataAdapterImage
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner_image.setAdapter(dataAdapterImage);
	
	}


}
