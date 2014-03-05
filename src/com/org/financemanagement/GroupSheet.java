package com.org.financemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class GroupSheet extends Activity {
	
	public static final String EXTRA_SHEET_NAME = "SHEET_NAME";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_sheet);
	}
	
	public void setSheet(View v) {
		EditText txtSheetName = (EditText) findViewById(R.id.txtSheetName);
		Intent resultIntent = new Intent();
		resultIntent.putExtra(EXTRA_SHEET_NAME, txtSheetName.getText().toString());
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	}
	
	public void showPersonDetails(View v) {
		startActivity(new Intent(this, GroupPersonDetails.class));
	}
	
	public void showExpenseDetails(View v) {
		startActivity(new Intent(this, GroupExpenseDetails.class));
	}

}
