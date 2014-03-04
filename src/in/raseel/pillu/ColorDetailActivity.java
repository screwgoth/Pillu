package in.raseel.pillu;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class ColorDetailActivity extends Activity {
	
	public static final String TAG = "Pillu";
	int mImageId;
	
	ImageButton mColorButton = null;
	Button mbackButton = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.color_detail);
	
		mColorButton = (ImageButton) findViewById(R.id.colorButton);
		mbackButton = (Button) findViewById(R.id.backButton);
		
		Intent intent = getIntent();
		mImageId = intent.getIntExtra("POS", 0);
		
		switch (mImageId) {
		case R.drawable.yellow:
			mColorButton.setImageResource(R.drawable.yellow_detail);
			break;
		case R.drawable.red:
			mColorButton.setImageResource(R.drawable.apple);
			break;
		}
		
		mColorButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i(TAG, "Clicked");
				MediaPlayer mp = null;
				switch(mImageId) {
				case R.drawable.yellow:
					Log.i(TAG, "Yellow button clicked");
					mp = MediaPlayer.create(getApplicationContext(), R.raw.background);
				}
				mp.start();			
			}
		});
		
		mbackButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i(TAG, "Back button pressed");
				finish();
			}
		});

	}
	
	@Override
	public void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	public void onResume() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	public void onStop() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}

}
