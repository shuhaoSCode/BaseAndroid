package com.shuhao.baseandroid;

import com.shuhao.libs.common.CommonActivity;
import com.shuhao.libs.utils.DialogPool;
import com.shuhao.libs.utils.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class MainActivity extends CommonActivity {

    @Override
    protected void onCreate() {
        List<String> dasd = new ArrayList<>();
        dasd.add("阿斯蒂芬");
        dasd.add("耳环芬");
        dasd.add("阿而同样蒂芬");
        dasd.add("阿斯蒂芬");
        dasd.add("as");
        L.list(dasd);
        L.e("报错啦 哈哈哈哈哈");
        new Thread(new Runnable() {
            @Override
            public void run() {
                L.d("子线程~");
            }
        }).start();
    }

    @OnClick(R.id.main_button)
    void mainButton() {
        DialogPool.getDialog(DemoDialog.class, this).show();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
}
