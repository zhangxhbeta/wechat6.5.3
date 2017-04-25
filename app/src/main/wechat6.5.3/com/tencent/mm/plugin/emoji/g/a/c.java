package com.tencent.mm.plugin.emoji.g.a;

import com.tencent.mm.plugin.emoji.g.e;
import com.tencent.mm.plugin.emoji.g.f;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;

public final class c extends e {
    private String fdU;
    private f ffi;

    public c(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.fdU = str;
    }

    public final void run() {
        if (this.ffi != null) {
            this.ffi.rG(getKey());
        } else {
            v.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        a aI = g.afx().fci.aI(a.nwJ, false);
        aI.field_flag = 0;
        g.afx().fci.a(aI);
        if (this.ffi != null) {
            this.ffi.i(getKey(), 2, true);
        }
    }

    public final String getKey() {
        return this.fdU == null ? "" : this.fdU;
    }

    public final void a(f fVar) {
        this.ffi = fVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (!(be.kS(this.fdU) || be.kS(cVar.getKey()) || !this.fdU.equals(cVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
