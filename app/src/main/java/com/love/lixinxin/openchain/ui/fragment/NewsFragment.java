package com.love.lixinxin.openchain.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.love.lixinxin.openchain.R;
import com.love.lixinxin.openchain.ui.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NewsFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;

    private List<Fragment> fragments;
    private List<String> titles;


    private BolgFragment bolgFragment1;
    private BolgFragment bolgFragment2;
    private OneFragment oneFragment;
    private TweFragment tweFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titles = new ArrayList<>();
        titles.add("资讯");
        titles.add("博客");
        titles.add("问答");
        titles.add("活动");


        bolgFragment1 = BolgFragment.newInstance(titles.get(0));
        bolgFragment2 = BolgFragment.newInstance(titles.get(1));
        oneFragment = OneFragment.newInstance(titles.get(2));
        tweFragment = TweFragment.newInstance(titles.get(3));

        fragments = new ArrayList<>();
        fragments.add(bolgFragment1);
        fragments.add(bolgFragment2);
        fragments.add(oneFragment);
        fragments.add(tweFragment);


        fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragments, titles);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_news, container, false);

        initView(view);
        initData();
        initEvent();

        return view;

    }

    private void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
    }

    private void initData() {

        for (int i = 0; i < titles.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initEvent() {

    }

}
