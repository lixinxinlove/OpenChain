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
    private BolgFragment bolgFragment3;
    private BolgFragment bolgFragment4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bolgFragment1 = new BolgFragment();
        bolgFragment2 = new BolgFragment();
        bolgFragment3 = new BolgFragment();
        bolgFragment4 = new BolgFragment();

        fragments = new ArrayList<>();
        fragments.add(bolgFragment1);
        fragments.add(bolgFragment2);
        fragments.add(bolgFragment3);
        fragments.add(bolgFragment4);

        titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        titles.add("购物");

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
