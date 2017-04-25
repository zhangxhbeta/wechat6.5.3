package com.tencent.mm.plugin.brandservice.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e extends BaseAdapter {
    private Map<String, Integer> eAo;
    private a eAp;
    Runnable eAq = new Runnable(this) {
        final /* synthetic */ e eAr;

        {
            this.eAr = r1;
        }

        public final void run() {
            this.eAr.Z(this.eAr.ezP);
        }
    };
    List<f> ezP = null;

    public interface a {
        View a(f fVar, View view, boolean z, boolean z2);
    }

    public e(a aVar) {
        if (aVar == null) {
            throw new RuntimeException("ViewCreator can not be null.");
        }
        this.eAp = aVar;
        this.ezP = new ArrayList();
        this.eAo = new HashMap();
    }

    public final void Z(List<f> list) {
        if (this.ezP != list) {
            this.ezP.clear();
            if (list != null) {
                this.ezP.addAll(list);
            }
        }
        this.eAo.clear();
        int i = 0;
        String str = null;
        while (i < this.ezP.size()) {
            f fVar = (f) this.ezP.get(i);
            String str2 = (fVar == null || fVar.eAs == null) ? null : fVar.eAs;
            if (str2 == null || str2.equalsIgnoreCase(str)) {
                str2 = str;
            } else {
                this.eAo.put(str2, Integer.valueOf(i));
            }
            i++;
            str = str2;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.ezP.size();
    }

    public final Object getItem(int i) {
        return this.ezP.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        f fVar = (f) getItem(i);
        String iP = iP(i);
        String iP2 = iP(i + 1);
        boolean z2 = i == pD(iP);
        if (iP.equalsIgnoreCase(iP2)) {
            z = false;
        }
        a aVar = this.eAp;
        getCount();
        return aVar.a(fVar, view, z2, z);
    }

    private String iP(int i) {
        if (i < 0 || i >= this.ezP.size()) {
            return null;
        }
        return ((f) this.ezP.get(i)).eAs;
    }

    public final int pD(String str) {
        return be.a((Integer) this.eAo.get(str), -1);
    }
}
