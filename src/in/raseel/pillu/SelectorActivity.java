package in.raseel.pillu;

import in.raseel.pillu.SelectorActivity;
import in.raseel.pillu.R;
import in.raseel.pillu.ColorsFragment;
import in.raseel.pillu.AlphabetFragment;
import in.raseel.pillu.AnimalsFragment;
import in.raseel.pillu.MainLayout;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class SelectorActivity extends FragmentActivity {
	
	private static final String TAG = "Pillu";

    // The MainLayout which will hold both the sliding menu and our main content
    // Main content will holds our Fragment respectively
    MainLayout mainLayout;
    
    // ListView menu
    private ListView lvMenu;
    private String[] lvMenuItems;
    
    public static String[] mActionsArray;
    
    // Menu button
    Button btMenu;
    
    // Title according to fragment
    TextView tvTitle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inflate the mainLayout
        mainLayout = (MainLayout)this.getLayoutInflater().inflate(R.layout.activity_selector, null);
        setContentView(mainLayout);
        
        // Init menu
        
        lvMenuItems = getResources().getStringArray(R.array.Actions);
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
//        lvMenu.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, lvMenuItems));
        lvMenu.setAdapter(new ArrayAdapter<String>(this,
                R.layout.custom_list_view, lvMenuItems));
        lvMenu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }
            
        });
        
        
        // Get menu button
        btMenu = (Button) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });
        
        // Get title textview
        tvTitle = (TextView) findViewById(R.id.activity_main_content_title);
        
        
        // Add FragmentMain as the initial fragment       
        FragmentManager fm = SelectorActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        Fragment detailsFragment = new DetailsFragment();
        ft.add(R.id.activity_main_content_fragment, detailsFragment);
        ft.commit();   
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.selector, menu);
        return true;
    }

    public void toggleMenu(View v){
        mainLayout.toggleMenu();
    }
    
    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
    	Log.i(TAG, "Clicked position : " + position);
        String selectedItem = lvMenuItems[position];
        String currentItem = tvTitle.getText().toString();
        
        // Do nothing if selectedItem is currentItem
        if(selectedItem.compareTo(currentItem) == 0) {
            mainLayout.toggleMenu();
            return;
        }
            
        FragmentManager fm = SelectorActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        
        if(selectedItem.compareTo("Colors") == 0) {
        	Log.i(TAG, "Invoking the ColorsFragment");
        	fragment = new ColorsFragment();
        } else if (selectedItem.compareTo("Alphabets") == 0) {
        	Log.i(TAG, "Invoking the AlphabetsFragment");
        	fragment = new AlphabetFragment();
        } else if (selectedItem.compareTo("Animals") == 0) {
        	Log.i(TAG, "Invoking the AnimalsFragment");
        	fragment = new AnimalsFragment();
        } 
        
        if(fragment != null) {
            // Replace current fragment by this new one
            ft.replace(R.id.activity_main_content_fragment, fragment);
            ft.commit();
            
            // Set title accordingly
            tvTitle.setText(selectedItem);
        }
        
        // Hide menu anyway
        mainLayout.toggleMenu();
    }
    
    @Override
    public void onBackPressed() {
        if (mainLayout.isMenuShown()) {
            mainLayout.toggleMenu();
        }
        else {
            super.onBackPressed();
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