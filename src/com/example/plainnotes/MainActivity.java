package com.example.plainnotes;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.example.plainnotes.data.notedatasource;
import com.example.plainnotes.data.noteitem;

public class MainActivity extends ListActivity {

	private notedatasource datasource;
	List<noteitem> noteslist ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		datasource = new notedatasource(this);
		refreshDisplay();
		Log.i("test", "reached to main");
	}

	private void refreshDisplay() {
		
		noteslist=datasource.findAll();
		ArrayAdapter<noteitem> adapter=new ArrayAdapter<noteitem>(this, android.R.layout.simple_list_item_1, 0,noteslist);
		setListAdapter(adapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
