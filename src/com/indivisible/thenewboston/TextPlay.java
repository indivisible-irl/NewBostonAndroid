package com.indivisible.thenewboston;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener {

	Button bTryCmd;
	ToggleButton tbPass;
	EditText input;
	TextView display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		initViews();		
		
		tbPass.setOnClickListener(this);
		bTryCmd.setOnClickListener(this);
	}

	private void initViews() {
		// TODO Auto-generated method stub
		bTryCmd = (Button) findViewById(R.id.bResults);
		tbPass = (ToggleButton) findViewById(R.id.tbPassword);
		input = (EditText) findViewById(R.id.etCommands);
		display = (TextView) findViewById(R.id.tvResults);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.bResults:
				Random rand = new Random();
				String check = input.getText().toString();			// get text from box
				display.setText(check);
				if (check.contentEquals("left")){
					display.setGravity(Gravity.LEFT);
				} else if (check.contentEquals("center")){
					display.setGravity(Gravity.CENTER);
				} else if (check.contentEquals("right")){
					display.setGravity(Gravity.RIGHT);
				} else if (check.contentEquals("blue")){
					display.setTextColor(Color.BLUE);
				} else if (check.contentEquals("WTF")){
					display.setText("WTF");
					display.setTextSize(rand.nextInt(75));
					display.setTextColor(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
					switch (rand.nextInt(3)){
						case 0:
							display.setGravity(Gravity.LEFT);
							break;
						case 1:
							display.setGravity(Gravity.CENTER);
							break;
						case 2:
							display.setGravity(Gravity.RIGHT);
							break;
					}
				} else {
					display.setText("invalid");
					display.setGravity(Gravity.CENTER);
					display.setTextColor(Color.BLACK);
				}
				break;
			case R.id.tbPassword:
				if (tbPass.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else {
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				break;
		} // end onClick switch
	} // end onClick

	
}
