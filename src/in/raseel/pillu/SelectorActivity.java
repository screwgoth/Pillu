package in.raseel.pillu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.content.pm.ActivityInfo;
import android.view.Menu;

public class SelectorActivity extends Activity {
	
	public static String[] mActionsArray;
	private DetailsFragment mDetailsFragment;
	
	private static final String TAG = "Pillu";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.activity_selector);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selector, menu);
		return true;
	}

}
