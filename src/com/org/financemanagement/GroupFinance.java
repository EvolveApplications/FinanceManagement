package com.org.financemanagement;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class GroupFinance extends ListActivity {
	
	private static final int GET_SHEET= 101;
	
	ArrayAdapter<String> adapter;
	private ArrayList<String> sheetNamelist = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_finance);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sheetNamelist);
		setListAdapter(adapter);
	}
	
	public void createNewSheet(View v) {
		startActivityForResult(new Intent(this, GroupSheet.class), GET_SHEET);
	}
	
	private void addNewSheet(String sheetName) {
		sheetNamelist.add(sheetName);
		adapter.notifyDataSetChanged();
	}
	
	@Override
	public void onActivityResult(int requestCode, int  resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			if(requestCode == GET_SHEET)
				addNewSheet(data.getStringExtra(GroupSheet.EXTRA_SHEET_NAME));
		}
	}

}
