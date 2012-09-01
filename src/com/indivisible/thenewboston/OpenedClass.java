package com.indivisible.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass
		extends Activity
		implements OnClickListener, OnCheckedChangeListener {

	TextView tvTest, tvQuestion;
	Button bReturn;
	RadioGroup rgSelectionList;
	String gotBread, setData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initVars();
		
		//// can only have one bundle?? says to comment out in tuts
		//Bundle gotBasket = getIntent().getExtras();							// get extras out of passed intent
		//gotBread = gotBasket.getString("food");								// get string out of bundle extras
		//tvQuestion.setText(gotBread);										// set text to received string
	}

	private void initVars() {
		// TODO Auto-generated method stub
		tvQuestion = (TextView) findViewById(R.id.tvQuestion);
		tvTest = (TextView) findViewById(R.id.tvTest);
		rgSelectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		bReturn = (Button) findViewById(R.id.bReturn);
		
		rgSelectionList.setOnCheckedChangeListener(this);
		bReturn.setOnClickListener(this);
		
		setData = "none";				// he didn't do this but is no radio chosen what gets passed??
	}

	public void onClick(View v) {
		// Only one button:
		Intent person = new Intent();
		//// can only have one bundle?? says to comment out (toggle between) in tuts
		Bundle backpack = new Bundle();
		backpack.putString("ans", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);			// resultCode for intent passed back
		finish();								// finish us this class and return to Data.java
	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case R.id.rCrazy:
			setData = "Probably right!";
			break;
		case R.id.rSexy:
			setData = "Definitly right!";
			break;
		case R.id.rBoth:
			setData = "Spot on!";
			break;
		}
		tvTest.setText(setData);
	}
	
	

}
