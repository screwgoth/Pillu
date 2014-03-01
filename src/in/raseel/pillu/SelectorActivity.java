package in.raseel.pillu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import in.raseel.pillu.ActionsFragment.ActionSelectionListener;

public class SelectorActivity extends Activity implements
		ActionSelectionListener {
	
	public static String[] mActionsArray;
	private DetailsFragment mDetailsFragment;
	
	private static final String TAG = "Pillu";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, getClass().getSimpleName() + ": entered onCreate()");
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		mActionsArray = getResources().getStringArray(R.array.Actions);
		
		setContentView(R.layout.activity_selector);
		
		mDetailsFragment = (DetailsFragment)getFragmentManager().findFragmentById(R.id.details);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(TAG, getClass().getSimpleName() + ": entered onCreateOptionsMenu()");
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selector, menu);
		return true;
	}

	@Override
	public void onSelection(int index) {
		Log.i(TAG, getClass().getSimpleName() + ": entered onSelection()");
		if(mDetailsFragment.getShownIndex() != index) {
			mDetailsFragment.showSomeText(index);
		}
		
	}
	
	@Override
	protected void onDestroy() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
		super.onResume();
	}

	@Override
	protected void onStart() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
		super.onStop();
	}


}
