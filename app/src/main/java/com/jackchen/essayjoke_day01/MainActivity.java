package com.jackchen.essayjoke_day01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hc.baselibrary.ioc.CheckNet;
import com.hc.baselibrary.ioc.OnClick;
import com.hc.baselibrary.ioc.ViewById;
import com.hc.baselibrary.ioc.ViewUtils;


public class MainActivity extends AppCompatActivity {


    @ViewById(R.id.test_tv)
    TextView test_tv ;
    @ViewById(R.id.test_iv)
    ImageView test_iv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewUtils.inject(this);

        test_tv.setText("这里是用baselibrary注解的");

    }


    /**
     * 由于我们自己在ViewUtils中把点击事件已经try cache了，所以无论什么异常情况，程序都不会崩溃，最多是一个bug而已
     * 比如下边的 i=2/0 , 然后打印 i 的值 ，下边点击会没有反应，但是程序不会崩溃，这样就很好，体验就会很好，但是
     * 调试会比较麻烦，需要去看打印的警告 ，需要把控制台的级别点到 Warn 。
     * @param view
     */
    @OnClick({R.id.test_tv , R.id.test_iv})
    @CheckNet   // 表示如果没有网，就不要执行该方法了 ，而是直接打印没有网的toast
    public void onClick(View view){
        int i = 2/1 ;
        Toast.makeText(MainActivity.this , "执行结果是 -> " +i , Toast.LENGTH_SHORT).show();
    }
}
