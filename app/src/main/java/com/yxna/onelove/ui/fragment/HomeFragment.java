package com.yxna.onelove.ui.fragment;

import android.view.View;
import android.widget.GridView;

import com.yxna.onelove.R;
import com.yxna.onelove.adapter.HomTopGridViewAdapter;
import com.yxna.onelove.base.BaseFragment;
import com.yxna.onelove.ui.activity.RealLoveActivity;

import butterknife.BindView;


/**
 * @author wjb
 * describe
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.gridview)
    GridView gridview;
    private HomTopGridViewAdapter homTopGridViewAdapter;


    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View root) {
        homTopGridViewAdapter = new HomTopGridViewAdapter(mContext);
        gridview.setAdapter(homTopGridViewAdapter);

        gridview.setOnItemClickListener((adapterView, view, position, l) -> {
            if (position == 0) {
              //
            } else if (position == 3) {
                RealLoveActivity.start(mContext);
            }

        });

    }

    @Override
    protected void initData() {

    }
}
