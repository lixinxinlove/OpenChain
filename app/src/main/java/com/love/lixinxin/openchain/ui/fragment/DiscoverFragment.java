package com.love.lixinxin.openchain.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.love.lixinxin.openchain.R;

public class DiscoverFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "title";
    private String title;


    private LinearLayout ll;
    private TextView tv;
    private Button btn;

    private LinearLayout.LayoutParams params;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    public static DiscoverFragment newInstance(String param1) {
        DiscoverFragment fragment = new DiscoverFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initView(view);
        initData();
        initEvent();
        return view;
    }

    private void initView(View view) {
        ll = (LinearLayout) view.findViewById(R.id.ll);
        tv = (TextView) view.findViewById(R.id.tv);
        btn = (Button) view.findViewById(R.id.btn);
    }

    private void initData() {
        tv.setText(title);
        params = (LinearLayout.LayoutParams) ll.getLayoutParams();
    }


    float downY;
    float moveY;

    private void initEvent() {
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        moveY = event.getY() - downY;
                        params.setMargins(0, (int) moveY / 2, 0, -(int) moveY / 2);
                        ll.setLayoutParams(params);
                        break;
                    case MotionEvent.ACTION_UP:
                        params.setMargins(0, 0, 0, 0);
                        ll.setLayoutParams(params);
                        break;
                }

                return true;
            }
        });


        btn.setOnClickListener(this);
      //  tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Toast.makeText(getActivity(), "点击的Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv:
                Toast.makeText(getActivity(), "点击的TextView", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
