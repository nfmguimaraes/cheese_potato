package com.example.cheese_and_potato;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity implements OnItemClickListener {
	
	private ArrayAdapter<Task> aa;
	
	public static ArrayList<Task> taskList = new ArrayList<Task>();
	public Task task = new Task();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView)findViewById(R.id.listView1);
        
    	if(taskList.isEmpty() ){
    		
    		taskList = Task.loadTaskFile(taskList, getApplicationContext());
    		
    		aa = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, taskList);
            listView1.setAdapter(aa);
    	}
    	else{

            aa = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, taskList);
            listView1.setAdapter(aa);
            
            
    	}
    	
    	listView1.setOnItemClickListener((OnItemClickListener) this);  
    

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
                addNewTask(null);
                return true;
            //case R.id.action_compose:
                //composeMessage();
                //return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }    

    public void onItemClick(AdapterView<?> adapter, View arg1, int position, long arg3) {  
        
    	Task cadastro = (Task) adapter.getAdapter().getItem(position);  
    	
    	Intent intent = new Intent(this, DetailsActivity.class);
    	//intent.putextra
    	startActivity(intent);        
    }  
    
    /** Called when the user clicks the add task button */
    public void addNewTask(View view){
    	Intent intent = new Intent(this, Add.class);	
    	startActivity(intent);
    }
    
    public void detailsTask(View view){


    }
}








