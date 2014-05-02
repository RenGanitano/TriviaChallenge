package com.example.mobileproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Score extends Activity {

	TextView txtScore;
	EditText editName;
	Button btnSave, tryBtn, ldrBtn;
	
	private SQLiteDatabase db = null;
	private DatabaseOpenHelper dbHelper = null;
	String name;
	String score= "";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
		
		dbHelper = new DatabaseOpenHelper(this);
		db = dbHelper.getWritableDatabase();
		

		txtScore = (TextView) findViewById(R.id.txtScore);
		editName = (EditText) findViewById(R.id.editName);
		btnSave = (Button) findViewById(R.id.btnSaveScore);
		tryBtn =  (Button)findViewById(R.id.TryBtn);

		
		btnSave.setOnClickListener(listener1);
		tryBtn.setOnClickListener(new listener2());
		
		txtScore.setText("Your score: " + Game.score);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void getData(){
		if((editName.getText().toString()).equals("")){
			name = "You";
		}else{
		name = editName.getText().toString();
		}
		int a = Game.score;
		score = ""+a;
		
	}

	Button.OnClickListener listener1 = new Button.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			getData();
			insertUsers(name, score);
			Game.score = 0;
			Intent intent = new Intent(Score.this, Start.class);
			startActivity(intent);
			finish();
		}
	};
	
	public class listener2 implements OnClickListener{
		public void onClick(View v){
			getData();
			insertUsers(name, score);
			Game.score = 0;
			Intent inte = new Intent(Score.this, Game.class);
			startActivity(inte);
		}
	}
	
	
	private void insertUsers(String nm, String scr) {
		ContentValues values = new ContentValues();

		values.put("username", nm);
		values.put("score", scr);
		db.insert("userScore", null, values);
	}

}
