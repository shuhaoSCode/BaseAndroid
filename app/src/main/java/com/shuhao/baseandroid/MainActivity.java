package com.shuhao.baseandroid;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shuhao.libs.common.CommonActivity;
import com.shuhao.libs.utils.DialogPool;
import com.shuhao.libs.utils.L;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends CommonActivity {

    @BindView(R.id.main_list)
    ListView main_list;

    @Override
    protected void onCreate() {
        List<String> commonList = new ArrayList<>();
        commonList.add("普通Dialog创建");
        commonList.add("使用DialogPool创建Dialog");
        commonList.add("阿斯蒂芬");
        commonList.add("阿斯蒂芬");
        commonList.add("as");
        L.list(commonList);
        L.e("报错啦 哈哈哈哈哈");
        L.v("嘿嘿嘿");
        new Thread(new Runnable() {
            @Override
            public void run() {
                L.d("子线程~");
            }
        }).start();

        main_list.setAdapter(new CommonAdapter<String>(this, R.layout.main_list, commonList) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.list_text, item);
            }
        });

        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        new DemoDialog(mContext).show();
                        break;
                    case 1:
                        DialogPool.getDialog(DemoDialog.class, mContext).show();
                        break;
                    case 2:

                        break;

                }
            }
        });
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
}
