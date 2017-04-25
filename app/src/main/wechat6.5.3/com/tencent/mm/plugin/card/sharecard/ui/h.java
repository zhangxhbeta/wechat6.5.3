package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g eGi;

    public h(g gVar) {
        this.eGi = gVar;
    }

    public final void onCreate() {
        this.eGi.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.eGi != null) {
            g gVar = this.eGi;
            gVar.eFW.release();
            gVar.eFW = null;
            gVar.eGh.clear();
            gVar.mContext = null;
            this.eGi = null;
        }
    }

    public final void zk() {
        if (this.eGi != null) {
            this.eGi.notifyDataSetChanged();
        }
    }

    public final b iQ(int i) {
        if (this.eGi != null) {
            return this.eGi.iQ(i);
        }
        return null;
    }
}
