package in.raseel.pillu;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import in.raseel.pillu.ActionsFragment.ActionSelectionListener;

public class SelectorActivity extends Activity implements
		ActionSelectionListener {
	
	public static String[] mActionsArray;
	
	private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	
	private FragmentManager mFragmentManager;
	private FrameLayout mActionsFrameLayout, mDetailsFrameLayout;
	
	//private DetailsFragment mDetailsFragment;
	private final DetailsFragment mDetailsFragment = new DetailsFragment();
	private final AlphabetFragment mAlphabetFragment = new AlphabetFragment();
	private final AnimalsFragment mAnimalsFragment = new AnimalsFragment();
	private final ColorsFragment mColorsFragment = new ColorsFragment();


	
	private static final String TAG = "Pillu";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, getClass().getSimpleName() + ": entered onCreate()");
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		mActionsArray = getResources().getStringArray(R.array.Actions);
		
		setContentView(R.layout.activity_selector);
		
		mActionsFrameLayout = (FrameLayout) findViewById(R.id.actions);
		mDetailsFrameLayout = (FrameLayout) findViewById(R.id.details);
		
		mFragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.actions, new ActionsFragment());
		//fragmentTransaction.addToBackStack(null);
		Log.i(TAG, "Action Frame Added");
		//fragmentTransaction.commit();
		
		fragmentTransaction.add(R.id.details, mDetailsFragment );
		//fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
		mFragmentManager.executePendingTransactions();
		
		//setLayout();
		
		mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
			public void onBackStackChanged() {
				Log.i(TAG, "BackStack Changed, Listener invoked");
				//setLayout();
			}
		});
		//mDetailsFragment = (DetailsFragment)getFragmentManager().findFragmentById(R.id.details);
	}
	
	private void setLayout() {
		Log.i(TAG, "Entered on setLayout()");
		if(!mDetailsFragment.isAdded() && !mAlphabetFragment.isAdded()) {
			Log.i(TAG, "Since DetailsFragment is not yet Added, Layout has only Actions");
			mActionsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams
					(MATCH_PARENT, MATCH_PARENT));
			mDetailsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams
					(0, MATCH_PARENT));

		} else if (mDetailsFragment.isAdded() || mAlphabetFragment.isAdded()){
			Log.i(TAG, "Since DetailsFragment is added, the Layout is two-pane");
			mActionsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams
					(0, MATCH_PARENT, 1f));
			mDetailsFrameLayout.setLayoutParams(new LinearLayout.LayoutParams
					(0, MATCH_PARENT, 2f));
		}
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
		Log.i(TAG, "Index Selected is : " + index);
		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		switch (index) {
		case 0:
			fragmentTransaction.replace(R.id.details, mColorsFragment);
			break;
		case 3:
			// This case is a little Mad. Definitely needs to be replaced.
			//fragmentTransaction.add(R.id.details, mDetailsFragment );
			fragmentTransaction.replace(R.id.details, mDetailsFragment );
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
			mFragmentManager.executePendingTransactions();
			if(mDetailsFragment.getShownIndex() != index) {
				mDetailsFragment.showSomeText(index);
			}
			// Look Ma! No break;
			return;
		case 1:
			fragmentTransaction.replace(R.id.details, mAlphabetFragment);
			break;
		case 2:
			fragmentTransaction.replace(R.id.details, mAnimalsFragment);
			break;
		}
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
		mFragmentManager.executePendingTransactions();
		
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
