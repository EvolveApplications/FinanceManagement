package com.org.financemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreditCardLimit extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitivity_creditcard_limit);
	}
	
	public void setCreditCardLimit(View v) {
		EditText txtCreditCardLimit = (EditText) findViewById(R.id.txtCreditCardLimit);
		FinanceManager.creditCardLimit = Integer.parseInt(txtCreditCardLimit.getText().toString());
		setDueDate();
	}
	
	public void setDueDate() {
		EditText txtDueDate = (EditText) findViewById(R.id.txtDueDate);
		FinanceManager.dueDate = txtDueDate.getText().toString();
		setResult(Activity.RESULT_OK, new Intent());
		finish();
	}
}
