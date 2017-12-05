package com.othershe.behaviortest.mainpage;

import android.content.Context;
import android.graphics.Color;

import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.base.CommonBaseAdapter;
import com.othershe.behaviortest.R;

import java.util.List;

public class TypeAdapter extends CommonBaseAdapter<String> {
    private int[] c;

    public TypeAdapter(Context context, List<String> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        c = new int[]{Color.parseColor("#33FF0000"),
                Color.parseColor("#3300FF00"),
                Color.parseColor("#330000FF")};
    }

    @Override
    protected void convert(ViewHolder holder, String data, int position) {
        holder.setBgColor(R.id.item_tv, c[position % 3]);
        holder.setText(R.id.item_tv, "item" + (position + 1));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_layout;
    }
}
