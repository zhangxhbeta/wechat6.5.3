package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.ol;

public final class d extends com.tencent.mm.plugin.emoji.a.a.a {

    public class a extends a {
        final /* synthetic */ d eZi;

        public a(d dVar, Context context, View view) {
            this.eZi = dVar;
            super(context, view);
        }

        protected final void aeo() {
            this.eYI.setVisibility(8);
            this.eYK.setVisibility(8);
            this.eYJ.setVisibility(0);
            this.eYL.setVisibility(8);
            this.eYP.setVisibility(8);
            this.eYQ.setVisibility(8);
            this.eYH.setVisibility(0);
            this.eXB.setVisibility(0);
            this.eYN.setVisibility(0);
            this.eYM.setVisibility(0);
            this.eYM.setBackgroundDrawable(null);
            this.eYO.setVisibility(0);
        }

        protected final int[] aep() {
            int N = com.tencent.mm.bd.a.N(this.mContext, 2131493439);
            return new int[]{N, N};
        }

        protected final int aeq() {
            return com.tencent.mm.bd.a.N(this.mContext, 2131493440);
        }

        protected final boolean aeA() {
            return true;
        }
    }

    public d(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.eZX);
        return aVar;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f jG = jG(i);
        if (!(aVar == null || jG == null)) {
            jG.fam = false;
            jG.fan = false;
            ol olVar = jG.fai;
            if (olVar != null) {
                aVar.setTitle(olVar.mqd);
                n.GL().a(olVar.gnp, aVar.aes(), g.bl(olVar.mdM, olVar.gnp));
                aVar.qV(o.G("yyyy-MM-dd", ((long) olVar.mqK) * 1000));
            }
        }
        return view;
    }

    public final int aeI() {
        return 0;
    }

    public final void jD(int i) {
    }

    public final int aeJ() {
        return 0;
    }

    public final void jE(int i) {
    }

    public final int aeK() {
        return 0;
    }

    public final void jF(int i) {
    }
}
