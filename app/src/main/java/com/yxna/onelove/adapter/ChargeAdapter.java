package com.yxna.onelove.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yxna.onelove.R;
import com.yxna.onelove.bean.ChargeModel;
import com.yxna.onelove.utils.OnSingleClickListener;

import java.util.List;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class ChargeAdapter extends BaseAdapter {

    private List<ChargeModel> list;

    private Context context;

    private int index = -1;

    public int getIndex() {
        return index;
    }

    public ChargeAdapter(Context context, List<ChargeModel> list) {
        this.context = context;
        this.list = list;
    }

    public void setCheck(int positon) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isCheck()) {
                list.get(i).setCheck(false);
            }
        }

        list.get(positon).setCheck(true);
        index = positon;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ChargeModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recharge_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvMoney = convertView.findViewById(R.id.tvMoney);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvMoney.setText(getItem(position).getMomey());
        viewHolder.tvName.setText(getItem(position).getContent());

        if (getItem(position).isCheck()) {
            convertView.setBackgroundResource(R.drawable.yes_selector);
            viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.white));
            viewHolder.tvMoney.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            convertView.setBackgroundResource(R.drawable.uncheck_selector);
            viewHolder.tvName.setTextColor(context.getResources().getColor(R.color.textColor3));
            viewHolder.tvMoney.setTextColor(context.getResources().getColor(R.color.textColor3));
        }

        convertView.setOnClickListener(new OnSingleClickListener() {
            @Override
            protected void onSingleClick(View view) {
                setCheck(position);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvMoney;
    }
}
