package com.indivisible.thenewboston;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.WallpaperManager;

public class Camera extends Activity implements View.OnClickListener{
	
	ImageButton ib;
	Button b;
	ImageView iv;
	Intent intent;
	final static int cameraData = 0;
	Bitmap bmp;
	WallpaperManager wpm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initViews();
		// set bmp so not null if setting bgrnd and no pic yet
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
	}

	private void initViews() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById(R.id.ivPhoto);
		ib = (ImageButton) findViewById(R.id.ibTakePic);
		b = (Button) findViewById(R.id.bSetBgrnd);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
		@SuppressWarnings("unused")
		WallpaperManager wpm = WallpaperManager.getInstance(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.bSetBgrnd:
			try {
				//getApplicationContext().setWallpaper(bmp);	<-- depreciated
				wpm.setBitmap(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.ibTakePic:
			intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent, cameraData);
			
			break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}

}
