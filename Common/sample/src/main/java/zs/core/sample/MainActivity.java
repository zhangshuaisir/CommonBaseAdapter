package zs.core.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import core.zs.adapter.CommonBaseAdapter;
import core.zs.adapter.ViewHolder;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    List<Bean> mDatas = new ArrayList<Bean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        initDatas();
        setupListAdapter();
    }

    private void setupListAdapter() {
        mListView.setAdapter(new CommonBaseAdapter<Bean>(this, mDatas, R.layout.item_layout) {
            @Override
            public void convert(ViewHolder holder, int position) {
                Bean bean = getItem(position);
                ((TextView) holder.getView(R.id.nameTxt)).setText(bean.getName());
                ((TextView) holder.getView(R.id.ageTxt)).setText(bean.getAge()+"");
            }
        });
    }

    private void initDatas() {

        for (int i = 0; i < 20; i++) {
            Bean bean = new Bean();
            bean.setName("张帅哥" + i);
            bean.setAge(i);
            mDatas.add(bean);
        }

    }


}


class Bean {
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
