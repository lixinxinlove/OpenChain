package com.love.lixinxin.openchain.ui.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.love.lixinxin.openchain.R;

import java.io.FileNotFoundException;

public class MyFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM = "title";

    private String title;


    private ImageView iv;
    private Button btnImg;


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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        initView(view);
        initData();
        initEvent();
        return view;
    }

    private void initView(View view) {
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(title);

        btnImg = (Button) view.findViewById(R.id.btn_img);
        iv = (ImageView) view.findViewById(R.id.iv);

    }

    private void initData() {

    }

    private void initEvent() {

        btnImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_img:       //选择图片
                Intent intent = new Intent();  
                /* 开启Pictures画面Type设定为image */
                intent.setType("image/*");  
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                intent.setAction(Intent.ACTION_GET_CONTENT);   
                /* 取得相片后返回本画面 */
                startActivityForResult(intent, 1);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (data != null) {


                Uri uri = data.getData();
                Log.e("uri", uri.toString());
                ContentResolver cr = getActivity().getContentResolver();
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                /* 将Bitmap设定到ImageView */
                    iv.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    Log.e("Exception", e.getMessage(), e);
                }
            }
        }
    }
}
