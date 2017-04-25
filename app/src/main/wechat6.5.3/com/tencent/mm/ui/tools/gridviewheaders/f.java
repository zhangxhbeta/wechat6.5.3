package com.tencent.mm.ui.tools.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter implements b {
    private e oWq;
    private List<b> oWr;

    private final class a extends DataSetObserver {
        final /* synthetic */ f oWs;

        private a(f fVar) {
            this.oWs = fVar;
        }

        public final void onChanged() {
            this.oWs.oWr = this.oWs.a(this.oWs.oWq);
            this.oWs.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            this.oWs.oWr = this.oWs.a(this.oWs.oWq);
            this.oWs.notifyDataSetInvalidated();
        }
    }

    private class b {
        int mCount = 0;
        final /* synthetic */ f oWs;
        int oWt;

        public b(f fVar, int i) {
            this.oWs = fVar;
            this.oWt = i;
        }
    }

    public f(e eVar) {
        this.oWq = eVar;
        eVar.registerDataSetObserver(new a());
        this.oWr = a(eVar);
    }

    public final int getCount() {
        return this.oWq.getCount();
    }

    public final int yg(int i) {
        try {
            return ((b) this.oWr.get(i)).mCount;
        } catch (IndexOutOfBoundsException e) {
            e.toString();
            return 0;
        }
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return this.oWq.a(((b) this.oWr.get(i)).oWt, view, viewGroup);
    }

    public final Object getItem(int i) {
        return this.oWq.getItem(i);
    }

    public final long getItemId(int i) {
        return this.oWq.getItemId(i);
    }

    public final int bJB() {
        return this.oWr.size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.oWq.getView(i, view, viewGroup);
    }

    protected final List<b> a(e eVar) {
        Map hashMap = new HashMap();
        List<b> arrayList = new ArrayList();
        for (int i = 0; i < eVar.getCount(); i++) {
            long jw = eVar.jw(i);
            b bVar = (b) hashMap.get(Long.valueOf(jw));
            if (bVar == null) {
                bVar = new b(this, i);
                arrayList.add(bVar);
            }
            bVar.mCount++;
            hashMap.put(Long.valueOf(jw), bVar);
        }
        return arrayList;
    }
}
