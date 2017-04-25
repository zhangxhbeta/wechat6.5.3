package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog eZg;

    public class a extends a {
        final /* synthetic */ c eZh;

        public a(c cVar, Context context, View view) {
            this.eZh = cVar;
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

        protected final boolean a(com.tencent.mm.plugin.emoji.model.f.a aVar, View view) {
            aey();
            return super.a(aVar, view);
        }

        protected final void b(com.tencent.mm.plugin.emoji.model.f.a aVar, View view) {
            super.b(aVar, view);
            if (com.tencent.mm.plugin.emoji.h.a.rX(aex())) {
                cb cbVar = new cb();
                cbVar.aZC.aZD = aex();
                cbVar.aZC.status = com.tencent.mm.plugin.emoji.h.a.agV() ? 7 : 3;
                cbVar.aZC.progress = getProgress();
                cbVar.aZC.aZE = this.eYF.fal;
                com.tencent.mm.sdk.c.a.nhr.z(cbVar);
            }
        }

        protected final int[] aep() {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131492964);
            return new int[]{dimensionPixelSize, dimensionPixelSize};
        }

        protected final int aeq() {
            return -1;
        }

        protected final boolean aeA() {
            return true;
        }

        public final void aeD() {
            if (this.eYF != null) {
                switch (aey()) {
                    case 0:
                    case 3:
                        this.eYL.setVisibility(8);
                        this.eYM.setBackgroundResource(2130837799);
                        this.eYM.setVisibility(0);
                        this.eYO.setVisibility(0);
                        this.eYO.setText(2131232376);
                        this.eYO.setTextColor(this.mContext.getResources().getColorStateList(2131690182));
                        this.eYP.setVisibility(4);
                        this.eYP.setImageResource(2130838148);
                        this.eYQ.setVisibility(4);
                        return;
                    case 6:
                        aeB();
                        return;
                    default:
                        this.eYL.setVisibility(8);
                        this.eYM.setBackgroundResource(2130837802);
                        this.eYM.setVisibility(0);
                        this.eYO.setVisibility(0);
                        this.eYO.setText(2131232423);
                        this.eYO.setTextColor(this.mContext.getResources().getColorStateList(2131690144));
                        this.eYP.setVisibility(4);
                        this.eYP.setImageResource(2130838148);
                        this.eYQ.setVisibility(4);
                        return;
                }
            }
        }
    }

    public c(Context context) {
        super(context);
    }

    public final void notifyDataSetChanged() {
        if (this.eZW == null) {
            this.eZW = a(null);
        }
        super.notifyDataSetChanged();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f jG = jG(i);
        if (!(aVar == null || jG == null)) {
            ol olVar = jG.fai;
            if (olVar != null) {
                if (com.tencent.mm.plugin.emoji.h.a.d(olVar)) {
                    aVar.aer();
                    aVar.aet();
                } else {
                    if (be.kS(olVar.mqd)) {
                        aVar.setTitle(olVar.mdM);
                    } else {
                        aVar.setTitle(olVar.mqd);
                    }
                    if (be.kS(olVar.gnp)) {
                        v.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                    } else {
                        n.GL().a(olVar.gnp, aVar.aes(), g.bl(olVar.mdM, olVar.gnp));
                    }
                }
                if (i + 1 == getCount()) {
                    aVar.eYG.setBackgroundResource(2130838048);
                } else {
                    aVar.eYG.setBackgroundResource(2130838046);
                }
            }
        }
        return view;
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.eZX);
        return aVar;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.c a(e eVar) {
        return new d(eVar);
    }

    public final void an(String str, int i) {
        if (i == 7) {
            super.an(str, i);
        }
    }

    public final void clear() {
        if (this.eZg != null) {
            this.eZg.cancel();
        }
        super.clear();
    }

    protected final void aeH() {
        super.aeH();
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
