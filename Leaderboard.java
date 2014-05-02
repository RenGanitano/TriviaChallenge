package com.example.mobileproject;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Leaderboard extends Activity {
	private SQLiteDatabase db = null;
	private DatabaseOpenHelper dbHelper = null;
	public ListView listview;
	String[] columns = {"_id", "username", "score"};
	Button bckBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leader_board);
		
		bckBtn = (Button)findViewById(R.id.hmsBtn);
		listview = (ListView)findViewById(R.id.listView1);
		dbHelper = new DatabaseOpenHelper(this);
		db = dbHelper.getWritableDatabase();

		bckBtn.setOnClickListener(new listener1());
		showList();
	}

	public void showList(){
		Cursor cursor = readUsers();
		String[] from = {"username", "score"};
		int[] to = {R.id.Uname, R.id.Uscore};
			
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_layout, cursor, from, to);
	    listview.setAdapter(adapter);
		
	}

	public class listener1 implements OnClickListener{
		public void onClick(View v){
			finish();
		}
	}
	private Cursor readUsers() {
		
		return db.query("userScore", columns, null, null, null, null,"score desc");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaderboard, menu);
		return true;
	}

}
