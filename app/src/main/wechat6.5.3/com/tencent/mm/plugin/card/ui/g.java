package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class g implements a {
    private f eKn;

    public final /* synthetic */ b iQ(int i) {
        return this.eKn != null ? this.eKn.jc(i) : null;
    }

    public g(f fVar) {
        this.eKn = fVar;
    }

    public final void onCreate() {
        this.eKn.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.eKn != null) {
            f fVar = this.eKn;
            fVar.eFW.release();
            fVar.eFW = null;
            fVar.eGh.clear();
            fVar.mContext = null;
            fVar.eKl = null;
            this.eKn = null;
        }
    }

    public final void zk() {
        if (this.eKn != null) {
            this.eKn.notifyDataSetChanged();
        }
    }
}
