package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.a.a;
import junit.framework.Assert;

public abstract class m extends BaseAdapter {
    private SparseArray<a> nnT = new SparseArray();
    public l oGZ;
    private boolean oHa;
    int scene;

    public abstract a gK(int i);

    public /* synthetic */ Object getItem(int i) {
        return xS(i);
    }

    public m(l lVar, boolean z, int i) {
        this.oGZ = lVar;
        this.oHa = z;
        this.scene = i;
    }

    public boolean aQk() {
        return this.oHa;
    }

    public final void jW(boolean z) {
        this.oHa = z;
        notifyDataSetChanged();
    }

    public final a xS(int i) {
        if (this.nnT.indexOfKey(i) >= 0) {
            return (a) this.nnT.get(i);
        }
        if (i < 0 || i >= getCount()) {
            v.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
            return null;
        }
        a gK = gK(i);
        if (gK != null) {
            gK.eyw = c(gK);
            this.nnT.put(i, gK);
            v.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", Integer.valueOf(gK.eKg), Integer.valueOf(i));
            return gK;
        }
        v.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i));
        return gK;
    }

    protected boolean c(a aVar) {
        return false;
    }

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        if (xS(i) != null) {
            return xS(i).eKg;
        }
        v.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i));
        return -1;
    }

    public int getViewTypeCount() {
        return 5;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a xS = xS(i);
        if (view == null) {
            view = xS.NE().a(this.oGZ.getActivity(), viewGroup);
        }
        a.a aVar = (a.a) view.getTag();
        Assert.assertNotNull(aVar);
        if (!xS.oJd) {
            xS.bo(this.oGZ.getActivity());
            xS.oJd = true;
        }
        xS.oHa = aQk();
        xS.NE().a(this.oGZ.getActivity(), aVar, xS, this.oGZ.b(xS), this.oGZ.a(xS));
        return view;
    }

    public final void clearCache() {
        if (this.nnT != null) {
            this.nnT.clear();
        }
    }

    public void finish() {
        clearCache();
    }

    public boolean xT(int i) {
        return false;
    }
}
