package com.yxna.onelove.ui.fragment.collect;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yxna.onelove.R;
import com.yxna.onelove.base.LazyLoadFragment;

import butterknife.BindView;


/**
 * @author wjb
 * describe
 */
public class TestFragment extends LazyLoadFragment {


    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.imageType)
    ImageView imageType;
    @BindView(R.id.tvTip)
    TextView tvTip;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initView(View root) {
    }

    @Override
    protected void initData() {

    }

    @Override
    public void fetchData() {

    }
}
