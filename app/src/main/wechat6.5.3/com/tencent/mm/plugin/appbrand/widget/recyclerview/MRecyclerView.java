package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.View;

public class MRecyclerView extends RecyclerView {
    protected a dZS;
    public a dZT;
    public b dZU;
    private View dZV;

    public interface a {
        void bz(View view);
    }

    public interface b {
        boolean bA(View view);
    }

    public MRecyclerView(Context context) {
        super(context);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dZS = new a();
        this.dZS.dZH = new b(this) {
            final /* synthetic */ MRecyclerView dZW;

            {
                this.dZW = r1;
            }

            public final void bL(View view) {
                if (this.dZW.dZT != null) {
                    this.dZW.dZT.bz(view);
                }
            }
        };
        this.dZS.dZI = new c(this) {
            final /* synthetic */ MRecyclerView dZW;

            {
                this.dZW = r1;
            }

            public final boolean bM(View view) {
                if (this.dZW.dZU != null) {
                    return this.dZW.dZU.bA(view);
                }
                return false;
            }
        };
        super.a(this.dZS);
        this.dZS.a(new c(this) {
            final /* synthetic */ MRecyclerView dZW;

            {
                this.dZW = r1;
            }

            public final void onChanged() {
                if (this.dZW.dZV != null) {
                    this.dZW.dZV.setVisibility(this.dZW.Tr() ? 0 : 8);
                }
            }
        });
    }

    public final int D(s sVar) {
        if (this.dZS == null) {
            return -1;
        }
        a aVar = this.dZS;
        if (sVar == null || sVar.gh() == -1) {
            return -1;
        }
        return sVar.gh() - (aVar.dZF.isEmpty() ? 0 : 1);
    }

    public final void a(android.support.v7.widget.RecyclerView.a aVar) {
        a aVar2 = this.dZS;
        if (aVar2.Yl != null) {
            if (!aVar2.Yl.equals(aVar)) {
                aVar2.Yl.b(aVar2.dZJ);
            } else {
                return;
            }
        }
        aVar2.Yl = aVar;
        if (aVar2.Yl != null) {
            aVar2.Yl.a(aVar2.dZJ);
        }
    }

    public final void aT(int i) {
        super.aT(i);
    }

    public final void addHeaderView(View view) {
        this.dZS.dZF.add(view);
    }

    public void addFooterView(View view) {
        this.dZS.dZG.add(view);
    }

    public final void b(int i, View view) {
        this.dZS.dZG.add(i, view);
    }

    protected boolean Tr() {
        return this.dZS.getItemCount() == 0;
    }
}
