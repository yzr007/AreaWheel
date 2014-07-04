package com.yzr.areawheel;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	AreaWheel areaWheel;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setFinishOnTouchOutside(false);
		LinearLayout ll = (LinearLayout) this.getLayoutInflater().inflate(
				R.layout.activity_main, null);
		LayoutInflater inflater = LayoutInflater.from(this);
		final View timepickerview = inflater.inflate(R.layout.areawheel, null);
		ScreenInfo screenInfo = new ScreenInfo(this);
		areaWheel = new AreaWheel(this, timepickerview);
		areaWheel.screenheight = screenInfo.getHeight();

		areaWheel.initAreaPicker();
		ll.addView(timepickerview);
		setContentView(ll);
		findViewById(R.id.myArea).setOnClickListener(this);
		getWindow().setGravity(Gravity.BOTTOM);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.myArea:
			Toast.makeText(this, areaWheel.getArea(), Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}

	}

}
