package com.example.cheese_and_potato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
    
	//public final static String ADD_TASK = "com.example.myfirstapp.ADD_TASK";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_add:
                add_task(null);
                return true;
            //case R.id.action_compose:
                //composeMessage();
                //return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }    

    /** Called when the user clicks the add task button */
    public void add_task(View view){
    	Intent intent = new Intent(this, Add.class);	
    	startActivity(intent);
    }
}








