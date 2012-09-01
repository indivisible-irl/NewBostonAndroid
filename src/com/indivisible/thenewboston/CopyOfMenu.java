package com.indivisible.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CopyOfMenu extends ListActivity{

	String[] classes = { "CalcActivity",
			"TextPlay",
			"Email",
			"Camera",
			"Data",
			"app0"
		};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(
				CopyOfMenu.this, android.R.layout.simple_list_item_1, classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Class<?> ourClass = null;
		try {
			String nextClass = classes[position];
			ourClass = Class.forName("com.indivisible.thenewboston." + nextClass);
			Intent ourIntent = new Intent(CopyOfMenu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			Toast toast = Toast.makeText(CopyOfMenu.this, "Not a suitable class", Toast.LENGTH_SHORT);
			toast.show();
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {			// long ref to Menu as we made a "Menu"
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//return super.onOptionsItemSelected(item);  removed because we're not passing up to super
		switch(item.getItemId()){
		case R.id.aboutUs:
			
			break;
		case R.id.prefs:
			
			break;
		}
		return false; 	// arbitrary? just set to fit method shell?
	}
	
	


}
