package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class au extends BaseAdapter implements u {
    private static HashMap<Long, a> jWn = new HashMap();
    as jWk;
    public at jWl;
    private boolean jWm = false;

    static class a {
        String id;
        HashSet<Integer> jWp;
        int jWq;
        int jnF;
        int networkType;

        a() {
        }
    }

    public final /* bridge */ /* synthetic */ Vending aVI() {
        return this.jWl;
    }

    public final /* synthetic */ Object getItem(int i) {
        return qK(i);
    }

    public au(MMActivity mMActivity, ListView listView, b bVar, h hVar, String str) {
        this.jWk = new as(mMActivity, listView, bVar, hVar, 10, this);
        this.jWk.jMd = true;
        this.jWl = new at();
        at atVar = this.jWl;
        as asVar = this.jWk;
        atVar.mContext = mMActivity;
        atVar.jWb = asVar;
        atVar.jUP = str;
        ak.yW();
        atVar.cvg = c.wH();
        com.tencent.mm.vending.base.b bVar2 = this.jWl;
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[]{Integer.valueOf(10)});
        bVar2.pgv = 10;
        this.jWl.addVendingDataChangedCallback(new d(this) {
            final /* synthetic */ au jWo;

            {
                this.jWo = r1;
            }

            public final void aXY() {
                this.jWo.notifyDataSetChanged();
            }
        });
    }

    public final void sW() {
        if (!this.jWm) {
            this.jWm = true;
            this.jWl.notifyVendingDataChangeSynchronize();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.jWk.g(i, view);
    }

    public final int getViewTypeCount() {
        return 12;
    }

    public final int getItemViewType(int i) {
        return this.jWk.getItemViewType(i);
    }

    public final void aVH() {
        this.jWl.notifyVendingDataChange();
    }

    public final k qK(int i) {
        av avVar = (av) this.jWl.get(i);
        if (avVar == null) {
            return null;
        }
        return avVar.jaC;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.jWl.mCount;
    }

    public static void B(k kVar) {
        if (kVar != null) {
            long j = kVar.field_snsId;
            if (!jWn.containsKey(Long.valueOf(j))) {
                a aVar = new a();
                if (kVar.aUp() != null && kVar.aUp().mWq != null && kVar.aUp().mWq.mol == 1 && kVar.aUp().mWq.mom != null && kVar.aUp().mWq.mom.size() > 0) {
                    aVar.jnF = kVar.aUp().mWq.mom.size();
                    aVar.jWp = new HashSet();
                    aVar.id = kVar.aUp().gID;
                    jWn.put(Long.valueOf(j), aVar);
                }
            }
        }
    }

    public static void b(k kVar, int i) {
        if (kVar != null) {
            long j = kVar.field_snsId;
            if (jWn.containsKey(Long.valueOf(j))) {
                a aVar = (a) jWn.get(Long.valueOf(j));
                if (aVar.jWq == 0) {
                    aVar.jWq = i + 1;
                }
                if (aVar.jWp == null) {
                    aVar.jWp = new HashSet();
                }
                aVar.jWp.add(Integer.valueOf(i + 1));
            }
        }
    }

    public static void aXX() {
        for (Entry value : jWn.entrySet()) {
            ((a) value.getValue()).networkType = i.aRb();
            v.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[]{Integer.valueOf(r0.jnF), Integer.valueOf(r0.jWp.size()), Integer.valueOf(r0.jWq), Integer.valueOf(r0.networkType), r0.id});
            g.iuh.h(11599, new Object[]{Integer.valueOf(r0.jnF), Integer.valueOf(r0.jWp.size()), Integer.valueOf(r0.jWq), Integer.valueOf(r0.networkType), Integer.valueOf(0), r0.id});
        }
        jWn.clear();
    }
}
