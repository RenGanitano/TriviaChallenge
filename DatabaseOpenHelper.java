package com.example.mobileproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	String CREATE_TABLE1 = "CREATE TABLE userScore ( _id INTEGER,  username TEXT, score TEXT)";
	
	
		final private static String NAME = "user_db";
		final private static Integer VERSION = 1;
		final private Context context;
		
		public DatabaseOpenHelper(Context context) {
			super(context, NAME, null, VERSION);
			this.context = context;
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
	
			db.execSQL(CREATE_TABLE1);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}
		
		void deleteDatabase ( ) {
			context.deleteDatabase(NAME);
		}

}
