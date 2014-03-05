package com.org.financemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ExpenseItem extends Activity {
	
	public static final String EXTRA_ITEM_NAME = "ITEM_NAME";
	public static final String EXTRA_AMOUNT = "AMOUNT";
	public static final String EXTRA_AMOUNT_BY_CASH = "AMOUNT_BY_CASH";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expense_item);
		
		if(getIntent().hasExtra(EXTRA_ITEM_NAME)) {
			EditText txtItemName = (EditText) findViewById(R.id.txtItemName);
			txtItemName.setText(getIntent().getStringExtra(EXTRA_ITEM_NAME));
			
			EditText txtAmount= (EditText) findViewById(R.id.txtAmount);
			txtAmount.setHint("Amount Spent");
		} else {
			RadioGroup rdAmountGroup = (RadioGroup) findViewById(R.id.rdAmountGroup);
			rdAmountGroup.setVisibility(RadioGroup.GONE);
		}
			
	}
	
	public void done(View v) {
		EditText txtItemName = (EditText) findViewById(R.id.txtItemName);
		EditText txtAmount = (EditText) findViewById(R.id.txtAmount);
		
		String itemName = txtItemName.getText().toString();
		String amount = txtAmount.getText().toString();
		
		if(itemName.isEmpty() || amount.isEmpty()) {
			Toast.makeText(getApplicationContext(), "Enter all the fields", Toast.LENGTH_SHORT).show();
			return;
		}
		
		Intent resultIntent = new Intent();
		resultIntent.putExtra(EXTRA_ITEM_NAME, itemName);
		resultIntent.putExtra(EXTRA_AMOUNT, Integer.parseInt(amount));
		RadioButton rdCash = (RadioButton) findViewById(R.id.rdCash);
		resultIntent.putExtra(EXTRA_AMOUNT_BY_CASH, rdCash.isChecked());
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	}
}
