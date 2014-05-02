package com.example.mobileproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity {

	private static int i = 0;
	private static int count = 0;

	SharedPreferences sharedPreferences;
	ArrayList<Integer> ques = new ArrayList<Integer>();
	HashMap<Integer, String> riddles = new HashMap<Integer, String>();
	HashMap<String, String> answers = new HashMap<String, String>();	
	Random r;
	static int score = 0;
	static int set = 0;
	int ii = 0;
	String answer = "";

	TextView txtRiddle;
	EditText editAnswer;
	Button btnSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.riddle);

		txtRiddle = (TextView) findViewById(R.id.txtRiddle);
		editAnswer = (EditText) findViewById(R.id.editAnswer);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(listener1);

		riddleSet();

		Random r = new Random();
		ii = r.nextInt(15);
		ques.add(ii);

		while (ques.contains(ii)) {
			if (ques.contains(ii)) {
				ques.add(ii);
				break;
			} else {
				ii = r.nextInt();
			}
		}

		txtRiddle.setText(riddles.get(ii));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void riddleSet() {

		riddles.put(
				0,
				"I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost everybody.");
		riddles.put(1,
				"What goes round the house and in the house but never touches the house?");
		riddles.put(2,
				"What is it that you can keep after giving it to someone else?");
		riddles.put(3, "What gets wet when drying?");
		riddles.put(
				4,
				"What comes once in a minute, twice in a moment, but never in a thousand years?");
		riddles.put(5,
				"The more you take, the more you leave behind. What are they?");
		riddles.put(6,
				"Brothers and sisters have I none but that man's father is my father's son.");
		riddles.put(
				7,
				"Who spends the day at the window, goes to the table for meals and hides at night?");
		riddles.put(8, "I bind it and it walks. I loose it and it stops.");
		riddles.put(
				9,
				"I went to the city, I stopped there, I never went there, and I came back again.");
		riddles.put(
				10,
				"What is that which goes with a carriage, comes with a carriage, is of no use to a carriage, and yet the carriage cannot go without it?");
		riddles.put(
				11,
				"It's been around for millions of years, but it's no more than a month old. What is it?");
		riddles.put(12,
				"What belongs to you but others use it more than you do?");
		riddles.put(13, "What is is that you will break even when you name it?");
		riddles.put(14,
				"What is it the more you take away the larger it becomes?");

		// //

		answers.put(
				"I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost everybody.",
				"pencil lead");
		answers.put(
				"What goes round the house and in the house but never touches the house?",
				"the sun");
		answers.put(
				"What is it that you can keep after giving it to someone else?",
				"your word");
		answers.put("What gets wet when drying?", "a towel");
		answers.put(
				"What comes once in a minute, twice in a moment, but never in a thousand years?",
				"letter m");
		answers.put(
				"The more you take, the more you leave behind. What are they?",
				"footsteps");
		answers.put(
				"Brothers and sisters have I none but that man's father is my father's son.",
				"son");
		answers.put(
				"Who spends the day at the window, goes to the table for meals and hides at night?",
				"fly");
		answers.put("I bind it and it walks. I loose it and it stops.",
				"sandals");
		answers.put(
				"I went to the city, I stopped there, I never went there, and I came back again.",
				"watch");
		answers.put(
				"What is that which goes with a carriage, comes with a carriage, is of no use to a carriage, and yet the carriage cannot go without it?",
				"noise");
		answers.put(
				"It's been around for millions of years, but it's no more than a month old. What is it?",
				"moon");
		answers.put("What belongs to you but others use it more than you do?",
				"name");
		answers.put("What is is that you will break even when you name it?",
				"silence");
		answers.put("What is it the more you take away the larger it becomes?",
				"hole");

	}

	Button.OnClickListener listener1 = new Button.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			count++;
			if (count == 5) {
				count = 0;
				if (answers.get(txtRiddle.getText().toString()).toString()
						.toLowerCase()
						.contains(editAnswer.getText().toString())
						&& !editAnswer.getText().toString().equals("")) {
					score = score + 50;
					Toast ire = Toast.makeText(Game.this, "Correct" + ii,
							Toast.LENGTH_SHORT);
					ire.show();
				} else {
					Toast ire = Toast.makeText(Game.this, "Wrong" + ii,
							Toast.LENGTH_SHORT);
					ire.show();
				}

				Intent intent = new Intent(Game.this, Score.class);
				startActivity(intent);
				finish();
			} else {
				if (answers.get(txtRiddle.getText().toString()).toString()
						.toLowerCase()
						.contains(editAnswer.getText().toString())
						&& !editAnswer.getText().toString().equals("")) {
					score = score + 50;
					Toast ire = Toast.makeText(Game.this, "Correct" + ii,
							Toast.LENGTH_SHORT);
					ire.show();
				} else {
					Toast ire = Toast.makeText(Game.this, "Wrong" + ii,
							Toast.LENGTH_SHORT);
					ire.show();
				}
				Intent intent = new Intent(Game.this, Game.class);
				startActivity(intent);
				finish();
			}
		}
	};
}
