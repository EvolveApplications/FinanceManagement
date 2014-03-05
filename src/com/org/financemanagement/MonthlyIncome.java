package com.org.financemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MonthlyIncome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monthly_income);
	}
	
	public void setMonthlyIncome(View v) {
		EditText txtMonthlyIncome = (EditText) findViewById(R.id.txtMonthlyIncome);
		FinanceManager.monthlyIncome = Integer.parseInt(txtMonthlyIncome.getText().toString());
		setResult(Activity.RESULT_OK, new Intent());
		finish();
	}

}
