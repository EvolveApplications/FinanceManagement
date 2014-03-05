package com.org.financemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalFinance extends Activity {
	
	private static final int GET_MONTHLY_INCOME= 101;
	private static final int GET_CREDIT_CARD_LIMIT = 102;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_finance);
	}
	
	public void assignMonthlyIncome(View v) {
		startActivityForResult(new Intent(this, MonthlyIncome.class), GET_MONTHLY_INCOME);
	}
	
	public void assignCreditCardLimit(View v) {
		startActivityForResult(new Intent(this, CreditCardLimit.class), GET_CREDIT_CARD_LIMIT);
	}
	
	public void showExpense(View v) {
		if(FinanceManager.creditCardLimit == 0 || FinanceManager.monthlyIncome == 0) {
			Toast.makeText(getApplicationContext(), "Set Income and Credit Limit", Toast.LENGTH_SHORT).show();
			return;
		}
		startActivity(new Intent(this, PersonalExpense.class));
	}
	
	private void showMonthlyIncome() {
		TextView lblMonthlyIncome = (TextView) findViewById(R.id.dispMonthlyIncome);
		lblMonthlyIncome.setText(Integer.toString(FinanceManager.monthlyIncome));
	}
	
	private void showCreditCardLimit() {
		TextView lblCreditCardLimit = (TextView) findViewById(R.id.dispCreditCardLimit);
		lblCreditCardLimit.setText(Integer.toString(FinanceManager.creditCardLimit));
		
		ProgressBar prgCreditCardLimit = (ProgressBar) findViewById(R.id.prgBrCreditCardLimit);
		prgCreditCardLimit.setMax(FinanceManager.creditCardLimit);
		prgCreditCardLimit.setProgress(FinanceManager.creditCardLimit);
	}
	
	@Override
	public void onActivityResult(int requestCode, int  resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			if(requestCode == GET_MONTHLY_INCOME)
				showMonthlyIncome();
			if(requestCode == GET_CREDIT_CARD_LIMIT)
				showCreditCardLimit();
		}
	}

}


