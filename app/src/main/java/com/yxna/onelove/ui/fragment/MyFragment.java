package com.yxna.onelove.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseFragment;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */

public class MyFragment extends BaseFragment {

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }
}
