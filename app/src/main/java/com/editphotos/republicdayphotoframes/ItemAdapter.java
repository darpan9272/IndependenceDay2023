package com.editphotos.republicdayphotoframes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ItemAdapter extends BaseAdapter {
    Context mContext;
    private Integer[] item_thumb = {Integer.valueOf(R.drawable.thumb_rd_1), Integer.valueOf(R.drawable.thumb_rd_2), Integer.valueOf(R.drawable.thumb_rd_3), Integer.valueOf(R.drawable.thumb_rd_4), Integer.valueOf(R.drawable.thumb_rd_5), Integer.valueOf(R.drawable.thumb_rd_6), Integer.valueOf(R.drawable.thumb_rd_7), Integer.valueOf(R.drawable.thumb_rd_8), Integer.valueOf(R.drawable.thumb_rd_9), Integer.valueOf(R.drawable.thumb_rd_10), Integer.valueOf(R.drawable.thumb_rd_11), Integer.valueOf(R.drawable.thumb_rd_12), Integer.valueOf(R.drawable.thumb_rd_13), Integer.valueOf(R.drawable.thumb_rd_14), Integer.valueOf(R.drawable.thumb_rd_15), Integer.valueOf(R.drawable.thumb_rd_16), Integer.valueOf(R.drawable.thumb_rd_17), Integer.valueOf(R.drawable.thumb_rd_18), Integer.valueOf(R.drawable.thumb_rd_19), Integer.valueOf(R.drawable.thumb_rd_20), Integer.valueOf(R.drawable.thumb_rd_21), Integer.valueOf(R.drawable.thumb_rd_22), Integer.valueOf(R.drawable.thumb_rd_23), Integer.valueOf(R.drawable.thumb_rd_24), Integer.valueOf(R.drawable.thumb_rd_25), Integer.valueOf(R.drawable.thumb_rd_26), Integer.valueOf(R.drawable.thumb_rd_27), Integer.valueOf(R.drawable.thumb_rd_28), Integer.valueOf(R.drawable.thumb_rd_29), Integer.valueOf(R.drawable.thumb_rd_30), Integer.valueOf(R.drawable.thumb_rd_31), Integer.valueOf(R.drawable.thumb_rd_32), Integer.valueOf(R.drawable.thumb_rd_33), Integer.valueOf(R.drawable.thumb_rd_34), Integer.valueOf(R.drawable.thumb_rd_35), Integer.valueOf(R.drawable.thumb_rd_36), Integer.valueOf(R.drawable.thumb_rd_37), Integer.valueOf(R.drawable.thumb_rd_38), Integer.valueOf(R.drawable.thumb_rd_39), Integer.valueOf(R.drawable.thumb_rd_40), Integer.valueOf(R.drawable.thumb_rd_41), Integer.valueOf(R.drawable.thumb_rd_42)};

    public ItemAdapter(Context context) {
        this.mContext = context;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.item_thumb.length;
    }

    public Object getItem(int i) {
        return new Integer(this.item_thumb[i].intValue());
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(new AbsListView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) view;
        }
        imageView.setImageResource(this.item_thumb[i].intValue());
        return imageView;
    }
}
