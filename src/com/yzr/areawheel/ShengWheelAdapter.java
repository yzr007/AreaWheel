package com.yzr.areawheel;

import java.util.Arrays;
import java.util.List;

import android.content.Context;

public class ShengWheelAdapter implements WheelAdapter {
	/**
	 * ʡ
	 */
	private List<String> items_p;
	public ShengWheelAdapter(Context context) {
		this.items_p = Arrays.asList(context.getResources().getStringArray(R.array.province_item));
	}

	@Override
	public int getItemsCount() {
		// TODO Auto-generated method stub
		return items_p==null?0:items_p.size();
	}

	@Override
	public String getItem(int index) {
		// TODO Auto-generated method stub
		return items_p.get(index);
	}

	@Override
	public int getMaximumLength() {
		// TODO Auto-generated method stub
		return 0;
	}

}
