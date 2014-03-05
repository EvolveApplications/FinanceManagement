package com.org.financemanagement;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class GroupPersonDetails extends ListActivity {
	
	private static final int GET_PERSON= 1;
	
	ArrayAdapter<String> adapter;
	private ArrayList<String> personNamelist = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_person_details);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personNamelist);
		setListAdapter(adapter);
	}
	
	public void createNewPerson(View v) {
		startActivityForResult(new Intent(this, GroupPerson.class), GET_PERSON);
	}
	
	private void addNewPerson(String sheetName) {
		personNamelist.add(sheetName);
		adapter.notifyDataSetChanged();
	}
	
	@Override
	public void onActivityResult(int requestCode, int  resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK) {
			if(requestCode == GET_PERSON)
				addNewPerson(data.getStringExtra(GroupPerson.EXTRA_PERSON_NAME));
		}
	}

}
