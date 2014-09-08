package com.example.plainnotes.data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class noteitem {
	
	private String key;
	private String text;
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public static noteitem get_new()
	{
		Locale l = new Locale("en_US");
		Locale.setDefault(l);
		String pattern="yyyy-MM-dd HH:mm:ss Z";
		SimpleDateFormat simple_date= new SimpleDateFormat(pattern);
		String key=simple_date.format(new Date());
		noteitem note = new noteitem();
		note.setKey(key);
		note.setText("");
		return note;
	}
	@Override
	public String toString() {
		return this.getText();
	}
}
