package com.love.lixinxin.openchain.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.love.lixinxin.openchain.R;
import com.love.lixinxin.openchain.ui.fragment.DiscoverFragment;
import com.love.lixinxin.openchain.ui.fragment.MyFragment;
import com.love.lixinxin.openchain.ui.fragment.NewsFragment;
import com.love.lixinxin.openchain.widget.MyFragmentTabHost;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener, View.OnClickListener {

    private MyFragmentTabHost mTabHost;
    private View mAddBt;
    private Class[] fragments = {NewsFragment.class, MyFragment.class, null, DiscoverFragment.class, MyFragment.class};


    private String[] text = {"综合", "动弹", "", "发现", "我的"};
    private String[] tag = {"0", "1", "2", "3", "4"};
    private int[] drawables = {
            R.drawable.tab_icon_new,
            R.drawable.tab_icon_tweet,
            R.drawable.tab_icon_new,
            R.drawable.tab_icon_explore,
            R.drawable.tab_icon_me
    };

    private PopupWindow popWnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initTabs();
        initEvent();

    }


    private void initView() {
        mAddBt = findViewById(R.id.quick_option_iv);
        mTabHost = (MyFragmentTabHost) findViewById(android.R.id.tabhost);
    }

    private void initData() {
        popWnd = new PopupWindow(this);
    }

    private void initEvent() {
        mTabHost.setOnTabChangedListener(this);
        mAddBt.setOnClickListener(this);
    }


    private void initTabs() {


        // 初始化底部FragmentTabHost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl);

        //去掉分割线
        mTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < 5; i++) {
            // 1. 创建一个新的选项卡
            TabHost.TabSpec tab = mTabHost.newTabSpec(tag[i]);

            View indicator = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            Drawable drawable = this.getResources().getDrawable(drawables[i]);
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
            if (i == 2) {
                indicator.setVisibility(View.INVISIBLE);
                mTabHost.setNoTabChangedTag(tag[i]);
            }
            title.setText(text[i]);
            tab.setIndicator(indicator);

            Bundle bundle = new Bundle();
            bundle.putString("title", "content: " + text[i]);
            // 2. 把新的选项卡添加到TabHost中
            mTabHost.addTab(tab, fragments[i], bundle);
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals("0")) {
            Toast.makeText(this, "点击的是" + tabId, Toast.LENGTH_SHORT).show();
        } else if (tabId.equals("1")) {
            Toast.makeText(this, "点击的是" + tabId, Toast.LENGTH_SHORT).show();
        } else if (tabId.equals("2")) {
            Toast.makeText(this, "点击的是" + tabId, Toast.LENGTH_SHORT).show();
        } else if (tabId.equals("3")) {
            Toast.makeText(this, "点击的是" + tabId, Toast.LENGTH_SHORT).show();
        } else if (tabId.equals("4")) {
            Toast.makeText(this, "点击的是" + tabId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quick_option_iv:
                showPopWnd();
                break;
        }
    }


    private void showPopWnd() {
        View contentView;
        contentView = View.inflate(this, R.layout.pop_view, null);


        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWnd.dismiss();
            }
        });

        popWnd.setContentView(contentView);
        popWnd.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popWnd.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

        popWnd.setOutsideTouchable(true);
        popWnd.setFocusable(false);
        popWnd.showAtLocation(mAddBt, Gravity.BOTTOM, 0, 0);
    }


}
