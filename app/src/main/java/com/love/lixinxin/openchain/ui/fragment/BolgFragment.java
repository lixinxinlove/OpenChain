package com.love.lixinxin.openchain.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.love.lixinxin.openchain.R;


public class BolgFragment extends Fragment {

    private String title;
    private static final String ARG_PARAM = "title";


    private TextView tv;

    public BolgFragment() {
    }

    public static BolgFragment newInstance(String title) {
        BolgFragment fragment = new BolgFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, title);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bolg, container, false);
        // Inflate the layout for this fragment

        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        tv = (TextView) view.findViewById(R.id.tv);
    }

    private void initData() {
        tv.setText(title);
    }

}
