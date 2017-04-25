package com.tencent.mm.plugin.emoji.g.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.g.e;
import com.tencent.mm.plugin.emoji.g.f;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.v.k;

public final class d extends e {
    private String dnU;
    private f ffi;
    private k ffs;
    private c fft;

    public d(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.dnU = str;
        this.fft = g.afx().fch.NF(this.dnU);
    }

    public final void run() {
        if (this.ffi != null) {
            this.ffi.rG(this.dnU);
        } else {
            v.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.fft == null) {
            this.ffi.i(this.dnU, 1, false);
            return;
        }
        this.ffs = new com.tencent.mm.plugin.emoji.e.f(this.fft);
        ak.vy().a(this.ffs, 0);
    }

    public final String getKey() {
        return this.dnU;
    }

    public final void a(f fVar) {
        this.ffi = fVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (!(be.kS(this.dnU) || be.kS(dVar.dnU) || !this.dnU.equals(dVar.dnU))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
