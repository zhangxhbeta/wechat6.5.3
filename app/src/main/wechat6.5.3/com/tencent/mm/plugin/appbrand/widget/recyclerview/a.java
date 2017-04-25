package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a<s> {
    private static LayoutParams dZC = new LayoutParams(-1, -2);
    android.support.v7.widget.RecyclerView.a Yl;
    private ViewGroup dZD;
    private ViewGroup dZE;
    List<View> dZF = new LinkedList();
    List<View> dZG = new LinkedList();
    b dZH;
    c dZI;
    c dZJ = new c(this) {
        final /* synthetic */ a dZK;

        {
            this.dZK = r1;
        }

        public final void onChanged() {
            this.dZK.Zi.notifyChanged();
        }

        public final void R(int i, int i2) {
            this.dZK.Zi.b((this.dZK.dZF.isEmpty() ? 0 : 1) + i, i2, null);
        }

        public final void c(int i, int i2, Object obj) {
            this.dZK.b((this.dZK.dZF.isEmpty() ? 0 : 1) + i, i2, obj);
        }

        public final void S(int i, int i2) {
            this.dZK.P((this.dZK.dZF.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void T(int i, int i2) {
            this.dZK.Q((this.dZK.dZF.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void U(int i, int i2) {
            int i3 = 0;
            a aVar = this.dZK;
            int i4 = (this.dZK.dZF.isEmpty() ? 0 : 1) + i;
            if (!this.dZK.dZF.isEmpty()) {
                i3 = 1;
            }
            aVar.O(i4, i3 + i2);
        }
    };

    private static class a extends s {
        a(View view) {
            super(view);
        }
    }

    a() {
    }

    public final int getItemViewType(int i) {
        if (!this.dZF.isEmpty() && i == 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.dZG.isEmpty() && i == getItemCount() - 1) {
            return 2147483646;
        }
        return this.Yl.getItemViewType(i - (this.dZF.isEmpty() ? 0 : 1));
    }

    public final int getItemCount() {
        int itemCount = this.Yl.getItemCount();
        if (!this.dZF.isEmpty()) {
            itemCount++;
        }
        if (this.dZG.isEmpty()) {
            return itemCount;
        }
        return itemCount + 1;
    }

    public final void a(final s sVar, int i) {
        if (!this.dZF.isEmpty() && i == 0) {
            return;
        }
        if (this.dZG.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.dZF.isEmpty() ? 0 : 1);
            this.Yl.a(sVar, i2);
            sVar.aal.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a dZK;

                public final void onClick(View view) {
                    if (this.dZK.dZH != null) {
                        b b = this.dZK.dZH;
                        View view2 = sVar.aal;
                        long j = sVar.aan;
                        b.bL(view2);
                    }
                }
            });
            sVar.aal.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ a dZK;

                public final boolean onLongClick(View view) {
                    if (this.dZK.dZI == null) {
                        return false;
                    }
                    c c = this.dZK.dZI;
                    View view2 = sVar.aal;
                    long j = sVar.aan;
                    return c.bM(view2);
                }
            });
        }
    }

    public final s a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2;
        if (i == 2147483646) {
            if (this.dZD != null) {
                this.dZD.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(2130904530, viewGroup, false);
            this.dZD = viewGroup2;
            for (View addView : this.dZG) {
                viewGroup2.addView(addView, dZC);
            }
            return new a(viewGroup2);
        } else if (i != Integer.MAX_VALUE) {
            return this.Yl.a(viewGroup, i);
        } else {
            if (this.dZE != null) {
                this.dZE.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(2130904530, viewGroup, false);
            this.dZE = viewGroup2;
            for (View addView2 : this.dZF) {
                viewGroup2.addView(addView2, dZC);
            }
            return new a(viewGroup2);
        }
    }

    public final int Tq() {
        return this.dZG.size();
    }
}
