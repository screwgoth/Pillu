package in.raseel.pillu;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;



public class CustomImageAdaptor extends BaseAdapter {
	private static final int PADDING = 20;
	private static final int WIDTH = 250;
	private static final int HEIGHT = 250;
	
	private Context mContext;
	private List<Integer> mThumbIds;
	
	public CustomImageAdaptor(Context c, List<Integer>ids) {
		mContext = c;
		mThumbIds = ids;
	}
	
	@Override
	public int getCount() {
		return mThumbIds.size();
	}
	@Override
	public Object getItem(int position) {
		return null;
	}
	@Override
	public long getItemId(int position) {
		return mThumbIds.get(position);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = (ImageView) convertView;

		// if convertView's not recycled, initialize some attributes
		if (imageView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
			imageView.setPadding(PADDING, PADDING, PADDING, PADDING);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		}

		imageView.setImageResource(mThumbIds.get(position));
		return imageView;
	}
	
}