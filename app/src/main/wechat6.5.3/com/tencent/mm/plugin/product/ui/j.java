package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;

public final class j extends BaseAdapter {
    m hSR;
    String hSS;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return od(i);
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.hSR.hRq != null ? this.hSR.hRq.size() : 0;
    }

    private h od(int i) {
        return (h) this.hSR.hRq.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        return od(i).hRi;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        h od = od(i);
        if (view == null || view.getTag() == null) {
            inflate = View.inflate(this.mContext, 2130904188, null);
        } else {
            inflate = view;
        }
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(od.name);
        checkBox.setEnabled(od.hRi);
        checkBox.setChecked(od.id.equals(this.hSS));
        if (!od.hRi) {
            inflate.setBackgroundResource(2130838914);
        } else if (od.id.equals(this.hSS)) {
            inflate.setBackgroundResource(2130838916);
        } else {
            inflate.setBackgroundResource(2130838915);
        }
        inflate.setTag(new Pair(this.hSR.hRo, od.id));
        return inflate;
    }
}
