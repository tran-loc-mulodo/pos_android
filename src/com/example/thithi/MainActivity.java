package com.example.thithi;

import java.util.List;

import com.example.thithi.adapter.DetailAdapter;
import com.example.thithi.fragment.DetailFrag;
import com.example.thithi.fragment.ListFrag;
import com.example.thithi.fragment.LoginFragment;
import com.example.thithi.fragment.ReportFragment;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	/********
	 * Var fragments
	 */
	private ListFrag listFragment;
	private DetailFrag detailFragment;
	private CreateProductFrag createProductFragment;
	private LoginFragment loginFragment;
	private ReportFragment reportFragment;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startFragmentProduct();
        startFragmentBill();
        startFragmentReport();
    }
	
	public void startFragmentProduct() {

		listFragment = new ListFrag();
		getFragmentManager().beginTransaction()
				.replace(R.id.contentArea, listFragment)
				.addToBackStack("List").commit();
	}
	
	public void startFragmentBill() {

		detailFragment = new DetailFrag();
		
		getFragmentManager().beginTransaction()
				.replace(R.id.billArea, detailFragment)
				.addToBackStack("Bill").commit();
	}
	
	public void startFragmentCreateProduct() {

		createProductFragment = new CreateProductFrag();
		getFragmentManager().beginTransaction()
				.replace(R.id.contentArea, createProductFragment)
				.addToBackStack("Import product").commit();
	}
	
	public void startFragmentLogin() {

		loginFragment = new LoginFragment();
		getFragmentManager().beginTransaction()
				.replace(R.id.contentArea, loginFragment)
				.addToBackStack("Import product").commit();
	}
	
	public void startFragmentReport() {

		reportFragment = new ReportFragment();
		getFragmentManager().beginTransaction()
				.replace(R.id.contentArea, reportFragment)
				.addToBackStack("Report").commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	startFragmentLogin();
	            return true;
	        case R.id.action_home:
	        	startFragmentProduct();
	            return true;
	        case R.id.action_create:
	        	startFragmentCreateProduct();
	            return true;
	        case R.id.action_report:
	        	startFragmentReport();
	            return true;    
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
