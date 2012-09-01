package com.indivisible.thenewboston;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends Activity {

	int myNum;
	Button addButton, subButton;
	TextView totalText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        
        myNum = 0;
        addButton = (Button) findViewById(R.id.b_add);
        subButton = (Button) findViewById(R.id.b_sub);
        totalText = (TextView) findViewById(R.id.tv_total);
        
        addButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// add one to total
				myNum += 1;
				totalText.setText("Your total is " + myNum);
			}
		});
        subButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// subtract one from total
				myNum -= 1;
				totalText.setText("Your total is " + myNum);
			}
		});
    }  // end onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calc, menu);
        return true;
    }
}
