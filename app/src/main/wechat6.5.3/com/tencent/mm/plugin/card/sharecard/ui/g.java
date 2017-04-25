package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g extends BaseAdapter {
    c eFW;
    List<b> eGh;
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return iQ(i);
    }

    public final int getCount() {
        return this.eGh.size();
    }

    public final b iQ(int i) {
        return (b) this.eGh.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.eFW.a(i, view, iQ(i));
    }
}
