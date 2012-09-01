package com.indivisible.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data
		extends Activity
		implements View.OnClickListener {

	EditText etSend;
	Button bSA, bSAFR;
	TextView tvGot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		etSend = (EditText) findViewById(R.id.etSend);
		bSA = (Button) findViewById(R.id.bSA);
		bSAFR = (Button) findViewById(R.id.bSAFR);
		tvGot = (TextView) findViewById(R.id.tvGot);
		bSA.setOnClickListener(this);
		bSAFR.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.bSA:
			String bread = etSend.getText().toString();					// data to pass
			Bundle basket = new Bundle();								// bundle to pass it in
			basket.putString("food", bread);							// key, value pair
			Intent myIntent = new Intent(Data.this, OpenedClass.class);	// intent - context, going to
			myIntent.putExtras(basket);									// add bundle to intent
			startActivity(myIntent);									// start intent
			break;
		case R.id.bSAFR:
			Intent myIntent2 = new Intent(Data.this, OpenedClass.class);
			startActivityForResult(myIntent2, 0);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			tvGot.setText(data.getStringExtra("ans"));
		} else {
			tvGot.setText("Something went horribly wrong");
		}
	}
	
	

}
