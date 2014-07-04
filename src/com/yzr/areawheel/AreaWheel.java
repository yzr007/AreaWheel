package com.yzr.areawheel;

import android.content.Context;
import android.view.View;

/**
 * 省市二级联动轮子控件
 * 
 * @author yzr E-mail: yangzr1990@gmail.com
 * @version 创建时间：2014年7月2日 上午11:01:03
 */
public class AreaWheel {

	private View view;
	private WheelView wv_province;
	private WheelView wv_city;
	public int screenheight;
	private Context context;
/**
 * 城市列表
 */
	private final int[] ARRAY_CITY = new int[] { R.array.beijin_province_item,
			R.array.tianjin_province_item, R.array.heibei_province_item,
			R.array.shanxi1_province_item, R.array.neimenggu_province_item,
			R.array.liaoning_province_item, R.array.jilin_province_item,
			R.array.heilongjiang_province_item, R.array.shanghai_province_item,
			R.array.jiangsu_province_item, R.array.zhejiang_province_item,
			R.array.anhui_province_item, R.array.fujian_province_item,
			R.array.jiangxi_province_item, R.array.shandong_province_item,
			R.array.henan_province_item, R.array.hubei_province_item,
			R.array.hunan_province_item, R.array.guangdong_province_item,
			R.array.guangxi_province_item, R.array.hainan_province_item,
			R.array.chongqing_province_item, R.array.sichuan_province_item,
			R.array.guizhou_province_item, R.array.yunnan_province_item,
			R.array.xizang_province_item, R.array.shanxi2_province_item,
			R.array.gansu_province_item, R.array.qinghai_province_item,
			R.array.ningxia_province_item, R.array.xinjiang_province_item,
			R.array.hongkong_province_item, R.array.aomen_province_item,
			R.array.taiwan_province_item };

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public AreaWheel(Context context, View view) {
		super();
		this.view = view;
		this.context = context;
		setView(view);
	}

	/**
	 * 初始化
	 * 
	 * @author yzr E-mail: yangzr1990@gmail.com
	 * @version 创建时间：2014年7月3日 上午10:48:30
	 * 
	 */
	public void initAreaPicker() {

		// 省
		wv_province = (WheelView) view.findViewById(R.id.province);
		wv_province.setAdapter(new ShengWheelAdapter(context));// 设置省的显示数据
		wv_province.setCyclic(true);// 可循环滚动
		wv_province.setLabel("省");// 添加文字
		wv_province.setCurrentItem(0);// 初始化时显示的数据 起始位置

		// 市
		wv_city = (WheelView) view.findViewById(R.id.month);
		wv_city.setAdapter(new ShiWheelAdapter(context,
				R.array.beijin_province_item));
		wv_city.setCyclic(false);
		wv_city.setLabel("市");
		wv_city.setCurrentItem(0);

		// 添加省监听 确定市item
		OnWheelChangedListener wheelListener_provnce = new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {

				wv_city.setShiAdapter(new ShiWheelAdapter(context,
						ARRAY_CITY[newValue]));

			}
		};

		wv_province.addChangingListener(wheelListener_provnce);

		// 根据屏幕密度来指定选择器字体的大小
		int textSize = 0;

		textSize = (screenheight / 100) * 4;
		wv_province.TEXT_SIZE = textSize;
		wv_city.TEXT_SIZE = textSize;

	}

	public String getArea() {
		return wv_province.getAdapter().getItem(wv_province.getCurrentItem())+"    "+
				wv_city.getAdapter().getItem(wv_city.getCurrentItem());
	}
}
