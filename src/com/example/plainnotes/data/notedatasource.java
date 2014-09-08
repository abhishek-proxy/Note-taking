package com.example.plainnotes.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import android.content.Context;
import android.content.SharedPreferences;

public class notedatasource {
	private static final String prefkey="notes";
	private SharedPreferences noteprefs;

	public notedatasource(Context context){
		
		noteprefs= context.getSharedPreferences(prefkey,Context.MODE_PRIVATE);
	}
	public List<noteitem> findAll(){
		
		Map<String, ?>notemaps=noteprefs.getAll();
		SortedSet<String> keys=new TreeSet<String>(notemaps.keySet());
		List<noteitem> notelist= new ArrayList<noteitem>();
		for (String key: keys) {
			noteitem note=new noteitem();
			note.setKey(key);
			note.setText((String) notemaps.get(key));
			notelist.add(note);
		}
		return notelist;
	 
	}

	public boolean update(noteitem note)
	{
		SharedPreferences.Editor editor = noteprefs.edit();
		editor.putString(note.getKey(),note.getText());
		editor.commit();
		
		return true;
		
	}
	public boolean remove(noteitem note){	
		if(noteprefs.contains(note.getKey())){
			SharedPreferences.Editor editor = noteprefs.edit();
			editor.remove(note.getKey());
			editor.commit();		
		}
		return true;
	}
}