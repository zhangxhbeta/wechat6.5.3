package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView extends LinearLayout {
    public ImageView bdF;
    public Context context;
    public int count;
    public Map<Integer, ImageView> map = new HashMap();
    public int nWL = 2130904083;

    public final void dh(int i, int i2) {
        this.count = i;
        qw(i2);
    }

    public MMPageControlView(Context context) {
        super(context);
        this.context = context;
    }

    public MMPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void qw(int i) {
        removeAllViews();
        if (i < this.count) {
            int i2 = this.count;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bdF = null;
                if (i == i3) {
                    if (this.map.size() > i3) {
                        this.bdF = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.bdF == null) {
                        this.bdF = (ImageView) View.inflate(this.context, this.nWL, null).findViewById(2131758302);
                        this.map.put(Integer.valueOf(i3), this.bdF);
                    }
                    this.bdF.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.bdF = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.bdF == null) {
                        this.bdF = (ImageView) View.inflate(this.context, this.nWL, null).findViewById(2131758302);
                        this.map.put(Integer.valueOf(i3), this.bdF);
                    }
                    this.bdF.setSelected(false);
                }
                if (i3 == 0) {
                    this.bdF.setPadding(0, 0, 0, 0);
                }
                addView(this.bdF);
            }
        }
    }
}
