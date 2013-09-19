package com.example.cheese_and_potato;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import android.content.Context;
import android.widget.EditText;
import android.widget.Switch;


public class Task implements Serializable {

	private static final long serialVersionUID = 2649190928739888560L;
	private static String FILENAME = "teste";
	
	public static int taskFileCount;
	
	private String title;
	private String desc;
	private String mail;
	private String iDate;
	private String fDate;
	private String xMail;
	
	/** Constructor */
	public Task() {}
	
	public Task(EditText title, EditText desc, EditText iDate, EditText fDate, EditText mail, Switch xMail){
		this.title = title.getText().toString();
		this.desc  = desc.getText().toString();
		this.mail  = mail.getText().toString();
		this.iDate = iDate.getText().toString();
		this.fDate = fDate.getText().toString();
		this.xMail = xMail.getText().toString();
	}
	
	public static void saveTaskFile(ArrayList<Task> taskList, Context context)  {
		
		FileOutputStream outputStream;			
		try {
			outputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
			
			ObjectOutputStream out = new ObjectOutputStream(outputStream); 
			out.writeObject(MainActivity.taskList);
			out.close();
			outputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Task> loadTaskFile(ArrayList<Task> taskList, Context context){
		
		FileInputStream inputStream;
		try {
			inputStream = context.openFileInput(FILENAME);
			ObjectInputStream in = new ObjectInputStream(inputStream); 
			
			taskList = (ArrayList<Task>) in.readObject();
			in.close();
			inputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskList;
	}
	
	public String toString() {
        return this.title;
    }

}
