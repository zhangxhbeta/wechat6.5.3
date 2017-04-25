package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.v;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    String bkC;
    private int count;
    private OnScrollListener eVr;
    private c iHk;
    private SparseArray<com.tencent.mm.ui.f.a.a> iHl = new SparseArray();
    long iHm;
    a iHn;

    public interface a {
        void E(int i, boolean z);
    }

    protected abstract boolean a(com.tencent.mm.ui.f.a.a aVar);

    protected abstract void aMm();

    protected abstract com.tencent.mm.ui.f.a.a pe(int i);

    public /* synthetic */ Object getItem(int i) {
        return pg(i);
    }

    public final Context getContext() {
        return this.iHk.getContext();
    }

    public b(c cVar) {
        v.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.iHk = cVar;
    }

    protected final void pf(int i) {
        v.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[]{Integer.valueOf(i)});
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i) {
        if (pg(i) != null) {
            return pg(i).eKg;
        }
        v.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        return -1;
    }

    public int getViewTypeCount() {
        return 17;
    }

    private com.tencent.mm.ui.f.a.a pg(int i) {
        if (this.iHl.indexOfKey(i) >= 0) {
            return (com.tencent.mm.ui.f.a.a) this.iHl.get(i);
        }
        com.tencent.mm.ui.f.a.a aVar = null;
        if (i >= 0 && i < getCount()) {
            aVar = pe(i);
        }
        if (aVar == null) {
            v.e("MicroMsg.FTS.FTSBaseAdapter", "getItem Occur error ! position = %d | count=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(getCount())});
            return aVar;
        }
        this.iHl.put(i, aVar);
        return aVar;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.ui.f.a.a pg = pg(i);
        if (view == null) {
            view = pg.YL().a(getContext(), viewGroup);
        }
        com.tencent.mm.ui.f.a.a.a aVar = (com.tencent.mm.ui.f.a.a.a) view.getTag();
        if (!pg.oPs) {
            pg.a(getContext(), aVar);
            pg.oPs = true;
        }
        pg.YL().a(getContext(), aVar, pg);
        return view;
    }

    public final void zj(String str) {
        stopSearch();
        this.iHm = System.currentTimeMillis();
        this.bkC = str;
        v.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[]{str});
        aMm();
    }

    public void stopSearch() {
        this.count = 0;
        this.bkC = "";
        clearCache();
        notifyDataSetChanged();
    }

    public void finish() {
        stopSearch();
    }

    protected void clearCache() {
        this.iHl.clear();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.eVr != null) {
            this.eVr.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.eVr != null) {
            this.eVr.onScroll(absListView, i, i2, i3);
        }
    }

    protected final void D(int i, boolean z) {
        if (this.iHn != null) {
            this.iHn.E(i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.iHk.axg();
        if (i < getCount()) {
            com.tencent.mm.ui.f.a.a pg = pg(i);
            pg.YL().a(getContext(), pg);
            a(pg);
            this.iHk.b(pg);
        }
    }
}
