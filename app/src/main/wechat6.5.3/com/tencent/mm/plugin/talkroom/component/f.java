package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.c.b.c;
import com.tencent.mm.plugin.talkroom.component.d.a;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends a {
    private c aTF;
    private c.a aUE = new c.a(this) {
        final /* synthetic */ f kju;

        {
            this.kju = r1;
        }

        public final void d(byte[] bArr, int i) {
            v.d("MicroMsg.MicRecoder", "pcm len: " + i);
            if (i <= 0) {
                v.e("MicroMsg.MicRecoder", "pcm data too low");
                return;
            }
            f.a(this.kju, bArr, i);
            int Send = this.kju.kjr.Send(bArr, (short) i);
            if (Send < 0) {
                v.e("MicroMsg.MicRecoder", "send failed, ret: " + Send);
            }
        }

        public final void as(int i, int i2) {
        }
    };
    private v2engine kjr;
    private short kjs;
    private short kjt;

    static /* synthetic */ void a(f fVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > fVar.kjs) {
                fVar.kjs = s;
            }
        }
    }

    public f(v2engine com_tencent_mm_plugin_talkroom_component_v2engine) {
        this.kjr = com_tencent_mm_plugin_talkroom_component_v2engine;
    }

    public final void aZR() {
        if (this.aTF != null) {
            this.aTF.pb();
            this.aTF = null;
        }
    }

    public final void aZS() {
        this.aTF = new c(com.tencent.mm.plugin.talkroom.model.a.kjH, 2);
        this.aTF.r(8, false);
        this.aTF.aUn = this.aUE;
        this.aTF.cL(20);
        this.aTF.pj();
        this.kjt = (short) 0;
        this.kjs = (short) 0;
    }

    public final int aZT() {
        if (this.kjt < this.kjs) {
            this.kjt = this.kjs;
        }
        if (this.kjt == (short) 0) {
            return 0;
        }
        short s = (short) ((this.kjs * 100) / this.kjt);
        this.kjs = (short) 0;
        return s;
    }

    public final void start() {
    }

    public final void release() {
        aZR();
    }
}
