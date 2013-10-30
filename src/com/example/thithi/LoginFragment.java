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
	private EditText edlogin_email, edlogin_pass;
	private Button btn_login, btn_register;
	private LinearLayout linear_login_eraser_email,
			linear_login_eraser_password;
	// Spinner element
	private Spinner spinner;

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
		edlogin_email = (EditText) LoginPageLayout
				.findViewById(R.id.edlogin_email);
		edlogin_pass = (EditText) LoginPageLayout
				.findViewById(R.id.edlogin_pass);
		btn_login = (Button) LoginPageLayout.findViewById(R.id.btn_login);
		btn_register = (Button) LoginPageLayout.findViewById(R.id.btn_register);
		linear_login_eraser_email = (LinearLayout) LoginPageLayout
				.findViewById(R.id.linear_login_eraser_email);
		linear_login_eraser_password = (LinearLayout) LoginPageLayout
				.findViewById(R.id.linear_login_eraser_password);
		spinner = (Spinner) LoginPageLayout.findViewById(R.id.spinner);
//		edlogin_email.setText("koko@gmail.com");
//		edlogin_pass.setText("123456");
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
			Toast.makeText(getActivity(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
			((MainActivity) getActivity()).startFragmentBill();
//			String Url = MainApplication.UrlServer
//					+ "users/getAuthenticate.xml";
			String Email = edlogin_email.getText().toString();
			DatabaseHandler db = new DatabaseHandler(getActivity());
	        
	        /**
	         * CRUD Operations
	         * */
	        // Inserting Contacts
	        Log.d("Insert: ", "Inserting ..");
	        db.addContact(new Contact(Email, "9100000000"));
	        
	     // Reading all contacts
	        Log.d("Reading: ", "Reading all contacts..");
	        List<Contact> contacts = db.getAllContacts();       
	 
	        for (Contact cn : contacts) {
	            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
	            Toast.makeText(getActivity().getApplicationContext(), cn.getName(), Toast.LENGTH_SHORT).show();
	                // Writing Contacts to log
	        Log.d("Name: ", log);
	        
	        }
	     // Creating adapter for spinner
//			ArrayAdapter<Contact> dataAdapter = new ArrayAdapter<Contact>(getActivity(),
//					android.R.layout.simple_spinner_item, contacts);
//
//			// Drop down layout style - list view with radio button
//			dataAdapter
//					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//			// attaching data adapter to spinner
//			spinner.setAdapter(dataAdapter);
//			String Pass = edlogin_pass.getText().toString();
//			try {
//				Pass = Utility.convertToMD5(edlogin_pass.getText().toString());
//			} catch (NoSuchAlgorithmException e) {
//
//			} catch (UnsupportedEncodingException e) {
//
//			}

			// Log.e("kiju",Utility.checkInternet(getActivity())+ "") ;
			// if (Utility.checkInternet(getActivity()))
			// {
			
			// }else {
			// Error_dialog dialog = new Error_dialog("Error Internet",
			// "Can not connect to internet", "");
			// dialog.show(getActivity().getFragmentManager(), TAG);
			// }

		}

	}
	
	/**
	 * Function to load the spinner data from SQLite database
	 * */
	private void loadSpinnerData() {
		// database handler
		
		String[]ten={"Banh kem","Banh ngot","Khac"};
		

		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
				android.R.layout.simple_spinner_item, ten);

		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner.setAdapter(dataAdapter);
	}
	
	


}
