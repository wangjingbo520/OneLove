package com.yxna.onelove.ui.fragment.collect;

import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.LazyLoadFragment;
import com.yxna.onelove.net.volley.InterfaceMethod;

import java.util.HashMap;


/**
 * @author wjb
 * describe
 */
public class PictureTextFragment extends LazyLoadFragment {

    private int currentPage = 1;
    private int pageSize = 20;
    private int type = 2;


    @Override
    protected int getContentLayout() {
        return R.layout.fragment_picture_text;
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

    private void loadData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageIndex", currentPage + "");
        hashMap.put("pageSize", pageSize + "");
        hashMap.put("type", type + "");
        doPost(hashMap, InterfaceMethod.getMemberCollectListById);

    }
}
