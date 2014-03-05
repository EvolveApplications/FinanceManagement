package com.org.financemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GroupPerson extends Activity {
	
	public static final String EXTRA_PERSON_NAME = "PERSON_NAME";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitivity_group_person);
	}
	
	public void setPerson(View v) {
		EditText txtPersonName = (EditText) findViewById(R.id.txtPersonName);
		Intent resultIntent = new Intent();
		resultIntent.putExtra(EXTRA_PERSON_NAME, txtPersonName.getText().toString());
		setResult(Activity.RESULT_OK, resultIntent);
		finish();
	}
	
}
