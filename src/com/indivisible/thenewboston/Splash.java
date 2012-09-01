package com.indivisible.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {
	
	MediaPlayer hunterSound;
	SharedPreferences getPrefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		if (getPrefs.getBoolean("splash", true)){
			setContentView(R.layout.splash);
		} else {
			Intent openCalc = new Intent("com.indivisible.thenewboston.MENU");
			startActivity(openCalc);
		}
		
		hunterSound = MediaPlayer.create(Splash.this, R.raw.hunter);
		
		// Preference storage and retrieval added tut #57
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		if (getPrefs.getBoolean("splashMusic", true)){
			hunterSound.start();
		}
		
		Thread timer = new Thread(){
			public void run(){
				try {
					sleep(1000);															// modded
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openCalc = new Intent("com.indivisible.thenewboston.MENU");
					startActivity(openCalc);
				}
			}
		}; // end timer
		timer.start();
	} // end onCreate()

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		hunterSound.release();
		finish();
	}

} // end class
