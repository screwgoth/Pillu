package in.raseel.pillu;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class ColorsFragment extends Fragment {
	
	public ColorsFragment() {
		
	}
	private static final String TAG = "Pillu";

	private GridView mColorGridView = null;
	private ArrayList<Integer> mThumbIdsColors = new ArrayList<Integer>(
			Arrays.asList(R.drawable.yellow, R.drawable.red,
					R.drawable.green, R.drawable.orange,R.drawable.blue));
	
	@Override
	public void onAttach(Activity activity) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");
		return inflater.inflate(R.layout.colors_fragment, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
		mColorGridView = (GridView) getActivity().findViewById(R.id.colorsGridview);
		mColorGridView.setAdapter(new CustomImageAdaptor(this.getActivity(), mThumbIdsColors));
		mColorGridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
				
				Intent colotIntent = new Intent(getActivity(), ColorDetailActivity.class);
				colotIntent.putExtra("POS", (int)id);
				Log.i(TAG, "Strarting the ColorDetail Activity");
				startActivity(colotIntent);
				
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

	@Override
	public void onDetach() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDetach()");
		super.onDetach();
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.i(TAG, getClass().getSimpleName() + ":entered onDestroyView()");
		super.onDestroyView();
	}
	
}