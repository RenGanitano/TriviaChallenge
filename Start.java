package com.example.mobileproject;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Start extends Activity {

	Button btn, ldrBtn;
	String[] columns = {"_id", "username", "score"};


	private SQLiteDatabase db = null;
	private DatabaseOpenHelper dbHelper = null;
	public ListView listview;
	private ArrayList<String> itemArrey;
	private ArrayAdapter<String> items;
	EditText etInput;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		
		listview = (ListView)findViewById(R.id.listView1);
		dbHelper = new DatabaseOpenHelper(this);
		db = dbHelper.getWritableDatabase();

		btn = (Button) findViewById(R.id.btnStart);
		btn.setOnClickListener(new listener1());
		
		ldrBtn = (Button) findViewById(R.id.ldrBtn);
		ldrBtn.setOnClickListener(new listener2());
		
		
	}


	public class listener2 implements OnClickListener{
		public void onClick(View v){
			Intent inte = new Intent(Start.this, Leaderboard.class);
			startActivity(inte);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class listener1 implements OnClickListener {

		public void onClick(View v) {
			//Intent intent = new Intent(Start.this, Game.class);
			Intent intent = new Intent(Start.this, Game.class);
			startActivity(intent);
		}
	}

}
