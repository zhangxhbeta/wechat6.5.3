package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.brandservice.ui.base.a.a;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    public SparseArray<a> ezI;
    public Runnable ezJ;
    protected Context mContext;

    public abstract a iK(int i);

    public abstract Object[] iL(int i);

    public /* synthetic */ Object getItem(int i) {
        return iM(i);
    }

    public b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.ezI = new SparseArray();
        this.ezJ = new Runnable(this) {
            final /* synthetic */ b ezK;

            {
                this.ezK = r1;
            }

            public final void run() {
                this.ezK.notifyDataSetChanged();
            }
        };
    }

    public int getCount() {
        return this.ezI.size();
    }

    public int getItemViewType(int i) {
        if (iM(i) != null) {
            return iM(i).type;
        }
        v.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        return 0;
    }

    public int getViewTypeCount() {
        return 7;
    }

    public a iM(int i) {
        if (i < 0 || i > getCount()) {
            v.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[]{Integer.valueOf(i)});
            return null;
        }
        a aVar = (a) this.ezI.get(i);
        if (aVar != null) {
            return aVar;
        }
        aVar = iK(i);
        this.ezI.put(i, aVar);
        return aVar;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        a iM = iM(i);
        if (iM == null) {
            v.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.plugin.brandservice.ui.base.a.b Yn = iM.Yn();
            if (Yn == null) {
                v.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                a Yo;
                if (view == null) {
                    view = Yn.b(this.mContext, view);
                    Yo = iM.Yo();
                    Yn.a(view, Yo);
                    view.setTag(Yo);
                } else {
                    Yo = (a) view.getTag();
                }
                Object[] iL = iL(i);
                Assert.assertNotNull(Yo);
                if (!iM.ezH) {
                    iM.a(this.mContext, Yo, iL);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                Yn.a(this.mContext, Yo, iM);
                long currentTimeMillis4 = System.currentTimeMillis();
                v.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3)});
            }
        }
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a iM = iM(i);
        if (iM != null) {
            com.tencent.mm.plugin.brandservice.ui.base.a.b Yn = iM.Yn();
            if (Yn != null && Yn.a(this.mContext, iM, iL(i))) {
            }
        }
    }
}
