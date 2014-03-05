package com.org.financemanagement;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class GroupExpenseDetails extends ListActivity {
	
	private static final int GET_EXPENSE= 1;
	
	ArrayAdapter<String> adapter;
	private ArrayList<String> expenseNamelist = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_expense_details);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, expenseNamelist);
		setListAdapter(adapter);
	}
	
	public void createNewExpense(View v) {
		startActivityForResult(new Intent(this, GroupExpense.class), GET_EXPENSE);
	}
	
	private void addNewexpense(String sheetName) {
		expenseNamelist.add(sheetName);
		adapter.notifyDataSetChanged();
	}
	
	@Override
	public void onActivityResult(int requestCode, int  resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			if(requestCode == GET_EXPENSE)
				addNewexpense(data.getStringExtra(GroupExpense.EXTRA_EXPENSE_NAME));
		}
	}

}
