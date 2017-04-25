package com.tencent.mm.plugin.emoji.g.a;

import com.tencent.mm.e.a.bz;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.g.e;
import com.tencent.mm.plugin.emoji.g.f;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.k;

public final class b extends e {
    private String fdU;
    private boolean fen = false;
    private f ffi;
    private g ffr;

    public b(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.fdU = str;
    }

    public b(String str, byte b) {
        if (be.kS(str)) {
            v.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.fdU = str;
        this.fen = true;
    }

    public final void run() {
        if (this.ffi != null) {
            this.ffi.rG(getKey());
        } else {
            v.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        a aI = com.tencent.mm.plugin.emoji.model.g.afx().fci.aI(getKey(), true);
        if (this.fen || aI == null || aI.field_sync != 2 || aI.field_status != 7) {
            this.ffr = new g(this.fdU);
            ak.vy().a(this.ffr, 0);
            vp vpVar = new vp();
            k NK = com.tencent.mm.plugin.emoji.model.g.afx().fcl.NK(this.fdU);
            if (!(NK == null || NK.field_content == null)) {
                try {
                    vpVar.az(NK.field_content);
                } catch (Throwable e) {
                    v.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", new Object[]{be.e(e)});
                }
            }
            if (vpVar.myd == null) {
                ak.vy().a(new com.tencent.mm.plugin.emoji.e.k(this.fdU, 15), 0);
                return;
            }
            return;
        }
        bz bzVar = new bz();
        bzVar.aZx.aZy = getKey();
        bzVar.aZx.aYt = 2;
        bzVar.aZx.aZz = true;
        com.tencent.mm.sdk.c.a.nhr.z(bzVar);
    }

    public final String getKey() {
        return this.fdU == null ? "" : this.fdU;
    }

    public final void a(f fVar) {
        this.ffi = fVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (!(be.kS(this.fdU) || be.kS(bVar.getKey()) || !this.fdU.equals(bVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        if (this.ffr == null || be.kS(this.ffr.cMU)) {
            v.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            return;
        }
        com.tencent.mm.modelcdntran.g.DZ().iq(this.ffr.cMU);
        v.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", new Object[]{this.ffr.cMU});
    }
}
