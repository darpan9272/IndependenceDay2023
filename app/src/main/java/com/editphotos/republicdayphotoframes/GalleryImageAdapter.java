package com.editphotos.republicdayphotoframes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryImageAdapter extends BaseAdapter {
    public Integer[] mImageIds = {Integer.valueOf(R.drawable.rd_1), Integer.valueOf(R.drawable.rd_2), Integer.valueOf(R.drawable.rd_3), Integer.valueOf(R.drawable.rd_4), Integer.valueOf(R.drawable.rd_5), Integer.valueOf(R.drawable.rd_6), Integer.valueOf(R.drawable.rd_7), Integer.valueOf(R.drawable.rd_8), Integer.valueOf(R.drawable.rd_9), Integer.valueOf(R.drawable.rd_10), Integer.valueOf(R.drawable.rd_11), Integer.valueOf(R.drawable.rd_12), Integer.valueOf(R.drawable.rd_13), Integer.valueOf(R.drawable.rd_14), Integer.valueOf(R.drawable.rd_15), Integer.valueOf(R.drawable.rd_16), Integer.valueOf(R.drawable.rd_17), Integer.valueOf(R.drawable.rd_18), Integer.valueOf(R.drawable.rd_19), Integer.valueOf(R.drawable.rd_20), Integer.valueOf(R.drawable.rd_21), Integer.valueOf(R.drawable.rd_22), Integer.valueOf(R.drawable.rd_23), Integer.valueOf(R.drawable.rd_24), Integer.valueOf(R.drawable.rd_25), Integer.valueOf(R.drawable.rd_26), Integer.valueOf(R.drawable.rd_27), Integer.valueOf(R.drawable.rd_28), Integer.valueOf(R.drawable.rd_29), Integer.valueOf(R.drawable.rd_30), Integer.valueOf(R.drawable.rd_31), Integer.valueOf(R.drawable.rd_32), Integer.valueOf(R.drawable.rd_33), Integer.valueOf(R.drawable.rd_34), Integer.valueOf(R.drawable.rd_35), Integer.valueOf(R.drawable.rd_36), Integer.valueOf(R.drawable.rd_37), Integer.valueOf(R.drawable.rd_38), Integer.valueOf(R.drawable.rd_39), Integer.valueOf(R.drawable.rd_40), Integer.valueOf(R.drawable.rd_41), Integer.valueOf(R.drawable.rd_42)};
    Integer[] imageId = {Integer.valueOf(R.drawable.thumb_rd_1), Integer.valueOf(R.drawable.thumb_rd_2), Integer.valueOf(R.drawable.thumb_rd_3), Integer.valueOf(R.drawable.thumb_rd_4), Integer.valueOf(R.drawable.thumb_rd_5), Integer.valueOf(R.drawable.thumb_rd_6), Integer.valueOf(R.drawable.thumb_rd_7), Integer.valueOf(R.drawable.thumb_rd_8), Integer.valueOf(R.drawable.thumb_rd_9), Integer.valueOf(R.drawable.thumb_rd_10), Integer.valueOf(R.drawable.thumb_rd_11), Integer.valueOf(R.drawable.thumb_rd_12), Integer.valueOf(R.drawable.thumb_rd_13), Integer.valueOf(R.drawable.thumb_rd_14), Integer.valueOf(R.drawable.thumb_rd_15), Integer.valueOf(R.drawable.thumb_rd_16), Integer.valueOf(R.drawable.thumb_rd_17), Integer.valueOf(R.drawable.thumb_rd_18), Integer.valueOf(R.drawable.thumb_rd_19), Integer.valueOf(R.drawable.thumb_rd_20), Integer.valueOf(R.drawable.thumb_rd_21), Integer.valueOf(R.drawable.thumb_rd_22), Integer.valueOf(R.drawable.thumb_rd_23), Integer.valueOf(R.drawable.thumb_rd_24), Integer.valueOf(R.drawable.thumb_rd_25), Integer.valueOf(R.drawable.thumb_rd_26), Integer.valueOf(R.drawable.thumb_rd_27), Integer.valueOf(R.drawable.thumb_rd_28), Integer.valueOf(R.drawable.thumb_rd_29), Integer.valueOf(R.drawable.thumb_rd_30), Integer.valueOf(R.drawable.thumb_rd_31), Integer.valueOf(R.drawable.thumb_rd_32), Integer.valueOf(R.drawable.thumb_rd_33), Integer.valueOf(R.drawable.thumb_rd_34), Integer.valueOf(R.drawable.thumb_rd_35), Integer.valueOf(R.drawable.thumb_rd_36), Integer.valueOf(R.drawable.thumb_rd_37), Integer.valueOf(R.drawable.thumb_rd_38), Integer.valueOf(R.drawable.thumb_rd_39), Integer.valueOf(R.drawable.thumb_rd_40), Integer.valueOf(R.drawable.thumb_rd_41), Integer.valueOf(R.drawable.thumb_rd_42)};
    private Context mContext;

    public GalleryImageAdapter(Context context) {
        this.mContext = context;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.mImageIds.length;
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(this.imageId[i].intValue());
        imageView.setLayoutParams(new Gallery.LayoutParams(350, 400));
        return imageView;
    }
}
