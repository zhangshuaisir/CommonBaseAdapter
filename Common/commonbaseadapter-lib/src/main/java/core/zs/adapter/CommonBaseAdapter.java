package core.zs.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用的BaseAdapter。<br/>
 * 属于重构的一种，将重用的逻辑规划到基类中，将需要重写的接口设计为抽象接口。<br/>
 * 
 * @author ZhangShuai.
 * 
 * @create 2017-4-11  下午1:28:01
 * @param <T>
 */
public abstract class CommonBaseAdapter<T> extends BaseAdapter {

	private final Context mContext;

	protected List<T> mDatas;

	private final int mLayoutId;

	public CommonBaseAdapter(Context context, List<T> data, int layoutId) {
		mContext = context;
		mDatas = data;
		mLayoutId = layoutId;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.getInstance(mContext, convertView,
				parent,
				mLayoutId);
		convert(holder, position);
		return holder.getConvertView();
	}

	/**
	 * 根据Bean的数据项设置数据。
	 * 
	 * @param holder
	 *            ViewHolder
	 * @param position
	 *            Item View的位置。
	 */
	public abstract void convert(ViewHolder holder,
			int position);


}
