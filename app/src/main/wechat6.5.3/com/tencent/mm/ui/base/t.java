package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class t extends android.support.v4.view.t {
    private Queue<View> nZC = new LinkedList();
    private HashMap<Object, Integer> nZD = new HashMap();
    public SparseArray<Object> nZE = new SparseArray();

    public abstract Object d(int i, View view);

    public abstract MultiTouchImageView lo(int i);

    public final Object b(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View view = null;
        if (this.nZC.size() > 0) {
            view = (View) this.nZC.poll();
        }
        Object d = d(i, view);
        v.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s", Integer.valueOf(d.hashCode()), ((View) d).getParent());
        this.nZD.put(d, Integer.valueOf(i));
        this.nZE.put(i, d);
        if (((View) d).getParent() == null) {
            viewGroup.addView((View) d);
        }
        v.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return d;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        v.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", Integer.valueOf(i));
        v.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", Integer.valueOf(obj.hashCode()));
        this.nZC.add((View) obj);
        this.nZD.remove(obj);
        this.nZE.remove(i);
    }

    public final int j(Object obj) {
        if (this.nZD.containsKey(obj)) {
            return ((Integer) this.nZD.get(obj)).intValue();
        }
        return -2;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final View wA(int i) {
        Object obj = this.nZE.get(i);
        if (obj != null) {
            return (View) obj;
        }
        return null;
    }

    public int bCI() {
        return -1;
    }

    public int bCJ() {
        return -1;
    }

    public void detach() {
        this.nZC.clear();
        this.nZD.clear();
        this.nZE.clear();
    }
}
