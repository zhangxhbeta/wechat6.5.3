package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.VerticalScrollBar;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSortView extends LinearLayout implements com.tencent.mm.ui.base.VerticalScrollBar.a {
    private OnItemSelectedListener Fp;
    public OnItemClickListener abT;
    public OnItemLongClickListener dWv;
    private VerticalScrollBar ezL;
    private ListView ezM;
    private View ezN;
    e ezO = new e(Yz());
    private List<f> ezP = new ArrayList();
    public boolean ezQ;
    public boolean ezR;
    a ezS;
    public int mMode;

    public interface a {
        void aa(List<f> list);
    }

    public abstract VerticalScrollBar Yx();

    public abstract View Yy();

    public abstract com.tencent.mm.plugin.brandservice.ui.base.e.a Yz();

    public abstract boolean a(String str, f fVar);

    public abstract ListView getListView();

    public abstract View inflate();

    public BaseSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate();
        this.ezL = Yx();
        this.ezM = getListView();
        this.ezN = Yy();
        this.ezQ = true;
        cf(true);
        this.ezM.setAdapter(this.ezO);
        if (this.ezL != null) {
            this.ezL.obP = this;
        }
        this.ezO.registerDataSetObserver(new DataSetObserver(this) {
            final /* synthetic */ BaseSortView ezT;

            {
                this.ezT = r1;
            }

            public final void onChanged() {
                if (this.ezT.ezS != null) {
                    this.ezT.ezS.aa(this.ezT.ezO.ezP);
                }
            }
        });
        this.ezM.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BaseSortView ezT;

            {
                this.ezT = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.ezT.abT != null) {
                    this.ezT.abT.onItemClick(adapterView, view, i, j);
                }
            }
        });
        this.ezM.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BaseSortView ezT;

            {
                this.ezT = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.ezT.dWv != null) {
                    return this.ezT.dWv.onItemLongClick(adapterView, view, i, j);
                }
                return false;
            }
        });
        this.ezM.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ BaseSortView ezT;

            {
                this.ezT = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.ezT.Fp != null) {
                    this.ezT.Fp.onItemSelected(adapterView, view, i, j);
                }
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
                if (this.ezT.Fp != null) {
                    this.ezT.Fp.onNothingSelected(adapterView);
                }
            }
        });
    }

    public void refresh() {
        ad.o(this.ezO.eAq);
    }

    public final void Z(List<f> list) {
        if (this.mMode == 0 && this.ezP != list) {
            this.ezP.clear();
            if (list != null) {
                this.ezP.addAll(list);
            }
        }
        this.ezO.Z(list);
    }

    public final void pB(String str) {
        boolean z = true;
        if (this.mMode != 1) {
            v.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        boolean z2;
        boolean z3;
        List arrayList = new ArrayList();
        if (be.kS(str)) {
            z2 = false;
        } else {
            arrayList.clear();
            for (f fVar : this.ezP) {
                if (a(str, fVar)) {
                    arrayList.add(fVar);
                }
            }
            z2 = true;
        }
        View view = this.ezM;
        if (!z2 || arrayList.size() <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        h(view, z3);
        View view2 = this.ezN;
        if (!z2 || arrayList.size() > 0) {
            z = false;
        }
        h(view2, z);
        Z(arrayList);
    }

    public final void pC(String str) {
        int pD = this.ezO.pD(str);
        if (pD >= 0) {
            this.ezM.setSelection(pD);
        }
    }

    public final void YE() {
        this.mMode = 1;
        pB("");
    }

    protected static void h(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void cf(boolean z) {
        this.ezR = z;
        if (this.ezL != null) {
            this.ezL.setVisibility(z ? 0 : 8);
        }
    }

    public final void YF() {
        this.ezQ = false;
        ad.o(this.ezO.eAq);
    }
}
