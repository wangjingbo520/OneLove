package com.yxna.onelove.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yxna.onelove.R;
import com.yxna.onelove.bean.ChargeModel;

/**
 * @author wjb（H）
 * @date describe
 */
public class HomTopGridViewAdapter extends BaseAdapter {

    private Context context;

    private String[] titleArr = {"优选话题", "关系维护", "分手挽回", "小测试"};

    public HomTopGridViewAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return titleArr.length;
    }

    @Override
    public String getItem(int position) {
        return titleArr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
            viewHolder.ivTop = convertView.findViewById(R.id.ivTop);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(titleArr[position]);

        return convertView;
    }

    static class ViewHolder {
        TextView tvTitle;
        ImageView ivTop;
    }
}
