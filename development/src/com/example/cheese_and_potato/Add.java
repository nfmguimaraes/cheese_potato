package com.example.cheese_and_potato;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;

public class Add extends Activity {

	public Task newTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_save:
			
			EditText editTitle = (EditText)findViewById(R.id.editTitle);
			EditText editDesc  = (EditText)findViewById(R.id.editDesc);
			EditText editIDate  = (EditText)findViewById(R.id.editIDate);
			EditText editFDate  = (EditText)findViewById(R.id.editFDate);
			EditText editMail  = (EditText)findViewById(R.id.editEmail);
			Switch 	 editXMail  = (Switch)findViewById(R.id.switchEmail);
			
			newTask = new Task(editTitle, editDesc, editIDate, editFDate, editMail, editXMail);
			MainActivity.taskList.add(newTask);

			Task.saveTaskFile(MainActivity.taskList, getApplicationContext() );
	 		
			NavUtils.navigateUpFromSameTask(this);
		}
		return super.onOptionsItemSelected(item);
	}

	

}








