package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.be;

public class f extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean eZp = false;
    public boolean eZq = true;
    public boolean eZr = false;
    public boolean eZs = true;

    public class a extends a {
        final /* synthetic */ f eZt;

        public a(f fVar, Context context, View view) {
            this.eZt = fVar;
            super(context, view);
        }

        protected final void aeo() {
            this.eYI.setVisibility(8);
            aew();
            this.eYL.setVisibility(8);
            this.eYP.setVisibility(8);
            this.eYQ.setVisibility(8);
            this.eYH.setVisibility(0);
            this.eXB.setVisibility(0);
            this.eYN.setVisibility(0);
            this.eYM.setVisibility(0);
            this.eYO.setVisibility(0);
        }

        protected final int[] aep() {
            int N = com.tencent.mm.bd.a.N(this.mContext, 2131493435);
            return new int[]{N, N};
        }

        protected final int aeq() {
            return com.tencent.mm.bd.a.N(this.mContext, 2131493434);
        }

        protected final boolean aeA() {
            return this.eZt.eZq;
        }
    }

    public f(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.eZX);
        return aVar;
    }

    public final void clear() {
        super.clear();
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        a aVar = (a) view.getTag();
        com.tencent.mm.plugin.emoji.a.a.f jG = jG(i);
        if (this.eZr) {
            jG.fao = true;
            jG.fam = false;
            jG.fan = false;
        }
        if (!(aVar == null || jG == null)) {
            jG.fan = this.eZs;
            oc ocVar = jG.faj;
            if (ocVar == null) {
                aVar.jC(0);
                z = false;
            } else {
                aVar.setTitle(ocVar.aXz);
                aVar.qW(ocVar.gkC);
                if (!be.kS(ocVar.gnp)) {
                    n.GL().a(ocVar.gnp, aVar.aes(), g.bl("", ocVar.gnp));
                }
                if (be.kS(ocVar.mpX)) {
                    aVar.jB(8);
                } else {
                    n.GL().a(ocVar.mpX, aVar.aeu(), g.bl("", ocVar.mpX));
                    aVar.jB(0);
                }
                aVar.jC(8);
            }
            if (!z) {
                ol olVar = jG.fai;
                if (olVar != null) {
                    aVar.setTitle(olVar.mqd);
                    if (com.tencent.mm.plugin.emoji.h.a.d(olVar)) {
                        n.GL().a("", aVar.aes());
                        aVar.aet();
                    } else {
                        n.GL().a(olVar.gnp, aVar.aes(), g.bl(olVar.mdM, olVar.gnp));
                    }
                    boolean bx = e.bx(olVar.mqh, 2);
                    if (!TextUtils.isEmpty(olVar.mqN)) {
                        aVar.aeu().setImageDrawable(null);
                        aVar.aeu().setVisibility(0);
                        n.GL().a(olVar.mqN, aVar.aeu(), g.bl("", olVar.mqN));
                    } else if (bx) {
                        aVar.jB(0);
                        aVar.aev();
                    } else {
                        aVar.jB(8);
                    }
                    aVar.qW(olVar.mqM);
                    if (this.eZp && aVar.eYG != null) {
                        aVar.eYG.setBackgroundResource(2130838048);
                    }
                }
            }
        }
        return view;
    }

    public int aeI() {
        return 0;
    }

    public void jD(int i) {
    }

    public int aeJ() {
        return 0;
    }

    public void jE(int i) {
    }

    public int aeK() {
        return 0;
    }

    public void jF(int i) {
    }
}
