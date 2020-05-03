package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.bean.FindSearchBean;
import com.yxna.onelove.ui.fragment.collect.SearchListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author wjb
 * describe
 */
public class FindSearchActivity extends BaseActivity {
    @BindView(R.id.listView)
    SearchListView listView;


    private List<FindSearchBean> findSearchBeans;

    public static void start(Context context) {
        Intent starter = new Intent(context, FindSearchActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void initData() {
        for (int i = 0; i < 20; i++) {
            findSearchBeans.add(new FindSearchBean("热门搜索"));
        }

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_find_search;
    }


}
