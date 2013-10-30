package com.example.thithi;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateProductFrag extends Fragment implements OnClickListener{
	private static final String TAG = CreateProductFrag.class.getName();
	private LinearLayout CreatePageLayout;
	// Spinner element
	Spinner spinner;

	// Add button
	Button btnAdd;

	// Input text
	EditText inputLabel;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		View view = inflater.inflate(R.layout.createproduct_fragment, container, false);
//		return view;
		initLayout(inflater);
		return CreatePageLayout;
	}

	/*
	 * init layout
	 */
	private void initLayout(LayoutInflater inflater) {
		// TODO Auto-generated method stub
//		CreateProductFrag = (LinearLayout) inflater.inflate(R.layout.createproduct_fragment,
//				null);
		// Spinner element
//		spinner = (Spinner) LinearPageLayout.findViewById(R.id.spinner);

		// add button
//		btnAdd = (Button) view.findViewById(R.id.btn_add);

		// new label input field
//		inputLabel = (EditText) view.findViewById(R.id.input_label);
		loadSpinnerData();
		
//		edlogin_email = (EditText) LoginPageLayout
//				.findViewById(R.id.edlogin_email);
//		edlogin_pass = (EditText) LoginPageLayout
//				.findViewById(R.id.edlogin_pass);
//		btn_login = (Button) LoginPageLayout.findViewById(R.id.btn_login);
//		btn_register = (Button) LoginPageLayout.findViewById(R.id.btn_register);
//		linear_login_eraser_email = (LinearLayout) LoginPageLayout
//				.findViewById(R.id.linear_login_eraser_email);
//		linear_login_eraser_password = (LinearLayout) LoginPageLayout
//				.findViewById(R.id.linear_login_eraser_password);
//		edlogin_email.setText("koko@gmail.com");
//		edlogin_pass.setText("123456");
	}
	
	public void setText(String item) {
		TextView view = (TextView) getView().findViewById(R.id.captain);
		view.setText(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/**
	 * Function to load the spinner data from SQLite database
	 * */
	private void loadSpinnerData() {
		// database handler
		
		String[]ten={"1T2","1T2","1T2","1T2","1T2","1T2",
				"1T5","1T5","1T5","1T5","1T5","1T5"};
		

		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, ten);

		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner.setAdapter(dataAdapter);
	}
}
