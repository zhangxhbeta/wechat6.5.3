package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.c.h;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter {
    protected LayoutInflater CE;
    protected List<h> hen = new LinkedList();
    protected Context mContext;

    public /* synthetic */ Object getItem(int i) {
        return mF(i);
    }

    public d(Context context) {
        this.mContext = context;
        this.CE = LayoutInflater.from(context);
    }

    public final void aJ(List<h> list) {
        if (list == null) {
            this.hen = new LinkedList();
        } else {
            this.hen = list;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.hen.size();
    }

    public final void a(h hVar) {
        this.hen.remove(hVar);
    }

    public final h mF(int i) {
        return (h) this.hen.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
