package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;

public final class c implements a {
    private b eHH;

    public final /* synthetic */ b iQ(int i) {
        return this.eHH != null ? (CardInfo) this.eHH.getItem(i) : null;
    }

    public c(b bVar) {
        this.eHH = bVar;
    }

    public final void onCreate() {
        if (this.eHH != null) {
            af.aak().c(this.eHH);
        }
    }

    public final void onDestroy() {
        if (this.eHH != null) {
            af.aak().d(this.eHH);
            b bVar = this.eHH;
            bVar.avc();
            bVar.eFW.release();
            bVar.eFW = null;
            this.eHH = null;
        }
    }

    public final void zk() {
        if (this.eHH != null) {
            this.eHH.a(null, null);
        }
    }
}
