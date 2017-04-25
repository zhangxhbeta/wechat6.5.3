package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.j;
import android.util.AttributeSet;
import android.view.View;

public class LoadMoreRecyclerView extends MRecyclerView {
    private View dZM;
    private a dZN;
    boolean dZO;

    public interface a {
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        getContext();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        super.a(linearLayoutManager);
        a(new j(this) {
            int dZP = 0;
            final /* synthetic */ LoadMoreRecyclerView dZR;

            public final void e(RecyclerView recyclerView, int i) {
                super.e(recyclerView, i);
                if (i == 0 && this.dZR.dZO && this.dZP == this.dZR.dZS.getItemCount() - 1 && this.dZR.dZN != null) {
                    this.dZR.dZN;
                    android.support.v7.widget.RecyclerView.a aVar = this.dZR.dZS.Yl;
                }
            }

            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
                this.dZP = linearLayoutManager.ff();
            }
        });
        this.dZS.a(new c(this) {
            final /* synthetic */ LoadMoreRecyclerView dZR;

            public final void T(int i, int i2) {
                super.T(i, i2);
                if (this.dZR.dZO && linearLayoutManager.ff() == this.dZR.dZS.getItemCount() - 1 && this.dZR.dZN != null) {
                    this.dZR.dZN;
                    android.support.v7.widget.RecyclerView.a aVar = this.dZR.dZS.Yl;
                }
            }
        });
    }

    public final void addFooterView(View view) {
        int Tq = this.dZS.Tq() - 1;
        if (this.dZM == null || Tq < 0) {
            super.addFooterView(view);
        } else {
            super.b(Tq, view);
        }
    }

    public final void a(h hVar) {
    }

    protected final boolean Tr() {
        if (this.dZM == null) {
            return super.Tr();
        }
        if (this.dZS.getItemCount() == 1 && this.dZS.Tq() == 1) {
            return true;
        }
        return false;
    }
}
