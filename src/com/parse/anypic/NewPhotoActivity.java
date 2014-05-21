package com.parse.anypic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.parse.ParseFile;

/*
 * NewPhotoActivity contains two fragments that handle
 * data entry and capturing a photo.
 * The Activity manages the overall photo data.
 */
public class NewPhotoActivity extends Activity {

	private Photo photo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		photo = new Photo();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);

		// Begin with main data entry view,
		// NewPhotoFragment
		setContentView(R.layout.activity_new_meal);
		FragmentManager manager = getFragmentManager();
		Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

		if (fragment == null) {
			fragment = new NewPhotoFragment();
			manager.beginTransaction().add(R.id.fragmentContainer, fragment)
					.commit();
		}
	}

	public Photo getCurrentPhoto() {
		return photo;
	}

}
