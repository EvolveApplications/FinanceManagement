package com.org.financemanagement;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class PersonalExpense extends Activity {

	private static final int GET_ITEM = 101;
	private static final int UPDATE_ITEM = 102;
	
	private static final String CASH_BALANCE = "Cash Balance";
	private static final String CREDIT_CARD_BALANCE = "Credit Card Balance";
	
	LinearLayout linLay;
	LayoutParams layParam;
	
	HashMap<String, ProgressBar> itemBalance = new HashMap<String, ProgressBar>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		linLay = new LinearLayout(this);
		linLay.setOrientation(LinearLayout.VERTICAL);
		linLay.setPadding(20, 20, 30, 30);
		layParam = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		
		setView();
	}
	
	private void setView() {
		setNewExpense(CASH_BALANCE, FinanceManager.monthlyIncome - FinanceManager.creditCardLimit);
		updateExpense(CASH_BALANCE, FinanceManager.monthlyIncome - FinanceManager.creditCardLimit);
		setNewExpense(CREDIT_CARD_BALANCE, FinanceManager.creditCardLimit);
		updateExpense(CREDIT_CARD_BALANCE, FinanceManager.creditCardLimit);
		
		Button btnAddNewExpense = new Button(this);
		btnAddNewExpense.setText("Add New Expense");
		btnAddNewExpense.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivityForResult(new Intent(getApplicationContext(), ExpenseItem.class), GET_ITEM);
			}
		});
		linLay.addView(btnAddNewExpense);
		
		ScrollView scrVw = new ScrollView(this);
		scrVw.addView(linLay);
		addContentView(scrVw, layParam);
	}

	private void setNewExpense(final String itemName, int value) {
		TextView lblItemName = new TextView(this);
		lblItemName.setPadding(0, 0, 10, 10);
		lblItemName.setText(itemName);
		
		ProgressBar prgBrBalance = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
		prgBrBalance.setPadding(0, 0, 10, 10);
		prgBrBalance.setMax(value);
		itemBalance.put(itemName, prgBrBalance);
		
		linLay.addView(lblItemName);
		linLay.addView(prgBrBalance);
		
		if(itemName.equals(CASH_BALANCE) || itemName.equals(CREDIT_CARD_BALANCE))
			return;
		
		lblItemName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intentUpdate = new Intent(getApplicationContext(), ExpenseItem.class);
				intentUpdate.putExtra(ExpenseItem.EXTRA_ITEM_NAME, itemName);
				startActivityForResult(intentUpdate, UPDATE_ITEM);
			}
		});
	}
	
	private void updateExpense(String itemName, int value) {
		ProgressBar prgBar = itemBalance.get(itemName);
		prgBar.setProgress(prgBar.getProgress() + value);
	}
	
	private void updateBalance(boolean byCash, int value) {
		ProgressBar prgBar = byCash ? itemBalance.get(CASH_BALANCE):itemBalance.get(CREDIT_CARD_BALANCE);
		prgBar.setProgress(prgBar.getProgress() - value);
	}
	
	@Override
	public void onActivityResult(int requestCode, int  resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			if(requestCode == GET_ITEM) {
				setNewExpense(data.getExtras().getString(ExpenseItem.EXTRA_ITEM_NAME), 
						data.getExtras().getInt(ExpenseItem.EXTRA_AMOUNT));
			} else if(requestCode == UPDATE_ITEM) {
				int value = data.getExtras().getInt(ExpenseItem.EXTRA_AMOUNT);
				updateExpense(data.getExtras().getString(ExpenseItem.EXTRA_ITEM_NAME), value);
				updateBalance(data.getExtras().getBoolean(ExpenseItem.EXTRA_AMOUNT_BY_CASH), value);
			}
		}
	}
}
