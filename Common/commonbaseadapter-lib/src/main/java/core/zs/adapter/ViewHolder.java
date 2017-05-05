package core.zs.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 通用的ViewHolder。<br/>
 * 与CommonBaseAdapter一起使用，简化view查找的流程。<br/>
 * 
 * @author ZhangShuai.
 * 
 * @create 2017-4-11 下午1:27:47
 */
public class ViewHolder {

	private SparseArray<View> mViews;

	private final Context mContext;

	private final View mConvertView;

	private ViewHolder(Context context, ViewGroup parent,
					   int layoutId) {
		mViews = new SparseArray<View>();
		mContext = context;
		mConvertView = LayoutInflater.from(mContext).inflate(layoutId, parent,
				false);
		mConvertView.setTag(this);
	}

	/**
	 * 获取ViewHolder的实例。
	 * 
	 * @param context
	 *            Context实例。
	 * @param convertView
	 *            待转换的view。
	 * @param parent
	 *            Item view的父View。
	 * @param layoutId
	 *            Item View对应的资源id。
	 * @return 构造出的ViewHolder。
	 */
	public static ViewHolder getInstance(Context context, View convertView,
										 ViewGroup parent, int layoutId) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId);
		}
		return (ViewHolder) convertView.getTag();
	}

	/**
	 * 获取Item View中的子View。
	 * 
	 * @param viewId
	 *            view的id。
	 * @return 查找到的view。
	 */
	public View getView( int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return mViews.get(viewId);
	}

	/**
	 * 获取ConvertView.
	 * 
	 * @return 根据外部调用生成的ConvertView。
	 */
	public View getConvertView() {
		return mConvertView;
	}
}
