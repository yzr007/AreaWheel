package com.yzr.areawheel;

import java.util.Arrays;
import java.util.List;

import android.content.Context;


public class ShiWheelAdapter implements WheelAdapter {
	private List<String> items_c;
	public ShiWheelAdapter(Context context,int ArrayId) {
		this.items_c = Arrays.asList(context.getResources().getStringArray(ArrayId));
	}

	@Override
	public int getItemsCount() {
		// TODO Auto-generated method stub
		return items_c==null?0:items_c.size();
	}

	@Override
	public String getItem(int index) {
		// TODO Auto-generated method stub
		if(index>=items_c.size()){
			index=items_c.size()-1;
		}
		return items_c.get(index);
	}

	@Override
	public int getMaximumLength() {
		// TODO Auto-generated method stub
		return 0;
	}

}
