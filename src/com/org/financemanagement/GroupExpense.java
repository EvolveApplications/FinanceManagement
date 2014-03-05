package com.org.financemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GroupExpense extends Activity {
	
	public static final String EXTRA_EXPENSE_NAME = "EXPENSE_NAME";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitivity_group_expense);
	}
	
	public void setGroupExpense(View v) {
		EditText txtGroupExpenseName= (EditText) findViewById(R.id.txtGroupExpenseName);
		Intent resultIntent = new Intent();
		resultIntent.putExtra(EXTRA_EXPENSE_NAME, txtGroupExpenseName.getText().toString());
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	}
	
}
