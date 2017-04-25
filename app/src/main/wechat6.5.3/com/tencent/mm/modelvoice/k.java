package com.tencent.mm.modelvoice;

import com.tencent.mm.c.b.a;
import com.tencent.mm.c.b.c;
import com.tencent.mm.c.b.g;
import com.tencent.mm.c.c.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.h;
import com.tencent.smtt.sdk.WebView;

public final class k implements a {
    private static int djw = 100;
    public c aTF;
    private int aTq = 0;
    c.a aUn = new c.a(this) {
        final /* synthetic */ k djy;

        {
            this.djy = r1;
        }

        public final void d(byte[] bArr, int i) {
            if (this.djy.djx != null) {
                this.djy.djx.a(new g.a(bArr, i), 0);
            }
            k.a(this.djy, bArr, i);
        }

        public final void as(int i, int i2) {
        }
    };
    private d djx;
    private String mFileName = null;
    public int mStatus = 0;

    static /* synthetic */ void a(k kVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & WebView.NORMAL_MODE_ALPHA) | (bArr[(i2 * 2) + 1] << 8));
            if (s > kVar.aTq) {
                kVar.aTq = s;
            }
        }
    }

    public final boolean bx(String str) {
        if (be.kS(this.mFileName)) {
            this.mStatus = 1;
            this.aTq = 0;
            this.aTF = new c(16000, 0);
            this.aTF.aUc = -19;
            if (p.ceJ.cdA > 0) {
                this.aTF.r(p.ceJ.cdA, true);
            } else {
                this.aTF.r(5, false);
            }
            this.aTF.al(false);
            this.aTF.aUn = this.aUn;
            this.djx = new d();
            if (!this.djx.bA(str)) {
                v.e("MicroMsg.SpeexRecorder", "init speex writer failed");
                clean();
                this.mStatus = -1;
                return false;
            } else if (this.aTF.pj()) {
                this.mFileName = str;
                return true;
            } else {
                v.e("MicroMsg.SpeexRecorder", "start record failed");
                clean();
                this.mStatus = -1;
                return false;
            }
        }
        v.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
        return false;
    }

    public final void a(h.a aVar) {
    }

    public final boolean pb() {
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        return true;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        if (this.aTF != null) {
            this.aTF.pb();
            this.aTF = null;
        }
        if (this.djx != null) {
            this.djx.pv();
            this.djx = null;
        }
    }

    public final int getMaxAmplitude() {
        int i = this.aTq;
        this.aTq = 0;
        if (i > djw) {
            djw = i;
        }
        return (i * 100) / djw;
    }

    public final int pc() {
        return this.aTF.aUs;
    }
}
