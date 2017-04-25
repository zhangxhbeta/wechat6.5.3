package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class MMGridPaperGridView extends GridView {
    private OnItemClickListener kgG = new OnItemClickListener(this) {
        final /* synthetic */ MMGridPaperGridView nVV;

        {
            this.nVV = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.nVV.nVT == null) {
                v.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
            }
        }
    };
    private int mCount;
    int mIndex;
    private int nVN;
    private int nVO;
    private int nVP;
    private int nVQ = -1;
    private boolean nVR = false;
    a nVS;
    private j nVT;
    private OnItemLongClickListener nVU = new OnItemLongClickListener(this) {
        final /* synthetic */ MMGridPaperGridView nVV;

        {
            this.nVV = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.nVV.nVT == null) {
                v.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
            }
            return false;
        }
    };

    private class a extends BaseAdapter {
        final /* synthetic */ MMGridPaperGridView nVV;

        private a(MMGridPaperGridView mMGridPaperGridView) {
            this.nVV = mMGridPaperGridView;
        }

        public final boolean isEnabled(int i) {
            return this.nVV.nVT != null;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final int getCount() {
            return (this.nVV.mCount < 0 || this.nVV.nVT == null) ? 0 : this.nVV.mCount;
        }

        public final Object getItem(int i) {
            return this.nVV.nVT == null ? null : this.nVV.nVT.getItem(this.nVV.nVP + i);
        }

        public final long getItemId(int i) {
            return this.nVV.nVT == null ? 0 : this.nVV.nVT.getItemId(this.nVV.nVP + i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            long Nj = be.Nj();
            String str = "MicroMsg.MMGridPaperGridView";
            String str2 = "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.nVV.mIndex);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(view == null);
            objArr[3] = viewGroup.toString();
            objArr[4] = Boolean.valueOf(this.nVV.nVR);
            v.v(str, str2, objArr);
            if (this.nVV.nVR) {
                view = null;
            }
            View c = this.nVV.nVT == null ? null : this.nVV.nVT.c(this.nVV.nVP + i, view);
            if (c != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (-1 == this.nVV.nVQ || this.nVV.nVP + i != this.nVV.nVQ) {
                c.setVisibility(0);
            } else {
                c.setVisibility(4);
            }
            v.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", Long.valueOf(be.az(Nj)), Integer.valueOf(this.nVV.nVQ), Integer.valueOf(this.nVV.nVP + i));
            return c;
        }
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, int i2, int i3, j jVar) {
        boolean z = true;
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "index[%d], rows[%d], columns[%d], adapter is null[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        if (jVar != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        this.mIndex = i;
        this.nVN = i2;
        this.nVO = i3;
        this.nVT = jVar;
        this.mCount = this.nVN * this.nVO;
        this.nVP = this.mIndex * this.mCount;
        if (this.nVT != null && this.nVT.getCount() - this.nVP < this.mCount) {
            this.mCount = this.nVT.getCount() - this.nVP;
        }
        if (getAdapter() == null) {
            v.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.nVS = new a();
            setAdapter(this.nVS);
        }
        setNumColumns(this.nVO);
        setColumnWidth(3);
        setOnItemClickListener(this.kgG);
        setOnItemLongClickListener(this.nVU);
    }
}
