package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView extends LinearLayout {
    public FavTagPanel fOC;
    private ImageButton fPX;
    public List<String> fPY = new LinkedList();
    public List<String> fPZ = new LinkedList();
    public List<Integer> fPq = new LinkedList();
    public a fQa;

    public interface a {
        void Og();

        void a(List<Integer> list, List<String> list2, List<String> list3);

        void a(List<Integer> list, List<String> list2, List<String> list3, boolean z);
    }

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.fPX = (ImageButton) findViewById(2131756985);
        this.fOC = (FavTagPanel) findViewById(2131756984);
        if (this.fOC != null) {
            FavTagPanel favTagPanel = this.fOC;
            int color = getResources().getColor(2131690127);
            if (favTagPanel.nYs != null) {
                favTagPanel.nYs.setTextColor(color);
            }
            this.fOC.nYj = 0;
            this.fOC.nYl = 0;
            this.fOC.gMg = 0;
            this.fOC.gMh = 2131690123;
            this.fOC.fPA = 0;
            this.fOC.fPz = 2131690127;
            this.fOC.Ou(getResources().getString(2131231148));
            this.fOC.ju(true);
            this.fOC.nYg = false;
            this.fOC.nYh = true;
            favTagPanel = this.fOC;
            com.tencent.mm.plugin.favorite.ui.base.FavTagPanel.a anonymousClass1 = new com.tencent.mm.plugin.favorite.ui.base.FavTagPanel.a(this) {
                final /* synthetic */ FavSearchActionView fQb;

                {
                    this.fQb = r1;
                }

                public final void rS(String str) {
                    v.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[]{str});
                    this.fQb.fOC.removeTag(str);
                    rU(str);
                }

                public final void rT(String str) {
                }

                public final void rU(String str) {
                    this.fQb.tl(this.fQb.fOC.bCw());
                    this.fQb.fPY.remove(str);
                    this.fQb.amU();
                    if (this.fQb.fQa != null) {
                        this.fQb.fQa.a(this.fQb.fPq, this.fQb.fPZ, this.fQb.fPY, true);
                    }
                }

                public final void rV(String str) {
                    this.fQb.tl(this.fQb.fOC.bCw());
                    this.fQb.amU();
                    if (this.fQb.fQa != null) {
                        this.fQb.fQa.a(this.fQb.fPq, this.fQb.fPZ, this.fQb.fPY);
                    }
                }

                public final void rW(String str) {
                    this.fQb.tl(str);
                    this.fQb.fQa.a(this.fQb.fPq, this.fQb.fPZ, this.fQb.fPY, false);
                }

                public final void aii() {
                    if (this.fQb.fQa != null) {
                        this.fQb.fQa.Og();
                    }
                }

                public final void tm(String str) {
                    this.fQb.tl(this.fQb.fOC.bCw());
                    this.fQb.fPq.remove(com.tencent.mm.plugin.favorite.b.v.Q(this.fQb.getContext(), str));
                    this.fQb.amU();
                    if (this.fQb.fQa != null) {
                        this.fQb.fQa.a(this.fQb.fPq, this.fQb.fPZ, this.fQb.fPY, true);
                    }
                }

                public final void tn(String str) {
                    v.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[]{str});
                    this.fQb.fOC.to(str);
                    tm(str);
                }

                public final void f(boolean z, int i) {
                }
            };
            favTagPanel.fQg = anonymousClass1;
            favTagPanel.nYp = anonymousClass1;
        }
        if (this.fPX != null) {
            this.fPX.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FavSearchActionView fQb;

                {
                    this.fQb = r1;
                }

                public final void onClick(View view) {
                    if (this.fQb.fQa != null) {
                        d dVar;
                        FavTagPanel a = this.fQb.fOC;
                        Iterator it = a.fQf.iterator();
                        while (it.hasNext()) {
                            dVar = (d) it.next();
                            a.removeView(dVar.nYG);
                            a.a(dVar);
                        }
                        a.fQf.clear();
                        a.bCD();
                        a = this.fQb.fOC;
                        it = a.mtZ.iterator();
                        while (it.hasNext()) {
                            dVar = (d) it.next();
                            a.removeView(dVar.nYG);
                            a.a(dVar);
                        }
                        a.mtZ.clear();
                        a.bCD();
                        this.fQb.fOC.bCx();
                        this.fQb.fPq.clear();
                        this.fQb.fPZ.clear();
                        this.fQb.fPY.clear();
                        this.fQb.fQa.a(this.fQb.fPq, this.fQb.fPZ, this.fQb.fPY, true);
                        this.fQb.amU();
                    }
                }
            });
        }
    }

    public final void tl(String str) {
        this.fPZ.clear();
        for (String str2 : be.ah(str, "").split(" ")) {
            if (!be.kS(str2)) {
                this.fPZ.add(str2);
            }
        }
    }

    public final void amU() {
        if (this.fPq.isEmpty() && this.fPY.isEmpty()) {
            this.fOC.Ou(getResources().getString(2131231148));
        } else {
            this.fOC.Ou("");
        }
    }
}
