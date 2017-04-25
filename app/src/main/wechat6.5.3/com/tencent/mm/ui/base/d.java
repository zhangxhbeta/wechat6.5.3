package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d extends t {
    public Context context;
    private Queue<View> nSy;
    private int nSz = 0;

    public abstract View a(View view, ViewGroup viewGroup, int i);

    public abstract int aDm();

    public abstract void nx(int i);

    public d(Context context) {
        this.context = context;
        this.nSy = new LinkedList();
    }

    public final boolean a(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object b(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View a = a((View) this.nSy.poll(), viewGroup, i);
        if (a.getLayoutParams() == null) {
            a.setLayoutParams(new LayoutParams(-1, -1));
        }
        viewGroup.addView(a);
        v.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return a;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.nSy.add(view);
        nx(i);
        v.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[]{Integer.valueOf(this.nSy.size())});
    }

    public final void notifyDataSetChanged() {
        this.nSz = aDm();
        super.notifyDataSetChanged();
    }

    public final int j(Object obj) {
        if (this.nSz <= 0) {
            return super.j(obj);
        }
        this.nSz--;
        return -2;
    }
}
