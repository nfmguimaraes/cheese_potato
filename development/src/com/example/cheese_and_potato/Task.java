package com.example.cheese_and_potato;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.widget.EditText;


public class Task {
	
	//private static final int serialVersionUID = 1L;
	
	public static int taskFileCount;
	
	
	private String title, desc, email;
	private boolean emailX;
	
	/** Constructor */
	public Task() {
		
	}
	
	public void setTitle(EditText title){
		this.title = title.getText().toString();
	}
	
	public void setDesc(EditText desc){
		this.desc = desc.getText().toString();
	}
	
	public void setEmail(EditText email){
		this.email = email.getText().toString();
	}
	public static ArrayList<Task> loadTasks(){
		// load de todas as tasks do ficheiro para um array
		
		return MainActivity.taskList;
	}
	
	public static void saveTask(Task newTask)  {
	
//Add task to array		
		MainActivity.taskList.add(newTask);
		
//save to file
	    ObjectOutputStream fileOut;
		try {
			fileOut = new ObjectOutputStream(new FileOutputStream("taskList.dat"));
			fileOut.writeObject(MainActivity.taskList);
		    fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//Se tudo correu bem incrementa taskFileCount

	}


}
