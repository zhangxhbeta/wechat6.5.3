package com.tencent.mm.v;

import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;

public final class b extends i {
    public int brn;
    public b czk;
    public c czl;
    public int czm;
    public String uri;

    public static class a {
        public int czm = 396;
        public com.tencent.mm.ba.a czn;
        public com.tencent.mm.ba.a czo;
        public int czp = 0;
        public int czq = 0;
        public boolean czr = true;
        public String uri;

        public final b Bv() {
            if (this.czn != null && this.czo != null && !be.kS(this.uri) && this.czm > 0 && this.czp != Integer.MIN_VALUE && this.czq != Integer.MIN_VALUE) {
                return new b(this.czn, this.czo, this.uri, this.czm, this.czp, this.czq, this.czr);
            }
            throw new IllegalArgumentException();
        }
    }

    public static final class b extends com.tencent.mm.protocal.l.c implements com.tencent.mm.protocal.l.a {
        public int cmdId;
        private int czm;
        public com.tencent.mm.ba.a czs;
        private boolean czt;

        public b(com.tencent.mm.ba.a aVar, int i, int i2, boolean z) {
            this.czs = aVar;
            this.czm = i;
            this.cmdId = i2;
            this.czt = z;
        }

        public final int getCmdId() {
            return this.cmdId;
        }

        public final int zg() {
            return this.czm;
        }

        public final byte[] zf() {
            if (this.czs instanceof aqp) {
                ((aqp) this.czs).mPU = l.a(this);
            }
            return this.czs.toByteArray();
        }
    }

    public static final class c extends d implements com.tencent.mm.protocal.l.b {
        public int cmdId;
        public com.tencent.mm.ba.a czs = null;
        private boolean czt;

        public c(com.tencent.mm.ba.a aVar, int i, boolean z) {
            this.czs = aVar;
            this.cmdId = i;
            this.czt = z;
        }

        public final int y(byte[] bArr) {
            this.czs = this.czs.az(bArr);
            if (this.czs instanceof avb) {
                return ((avb) this.czs).getRet();
            }
            l.a(this, ((aqx) this.czs).mQl);
            return ((aqx) this.czs).mQl.mcj;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    protected final /* bridge */ /* synthetic */ com.tencent.mm.protocal.l.c zd() {
        return this.czk;
    }

    public final /* bridge */ /* synthetic */ d ze() {
        return this.czl;
    }

    private b(com.tencent.mm.ba.a aVar, com.tencent.mm.ba.a aVar2, String str, int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        this.czk = null;
        this.czl = null;
        this.brn = 0;
        if (z && (aVar instanceof aqp)) {
            z2 = true;
        }
        this.czk = new b(aVar, i, i2, z2);
        this.czl = new c(aVar2, i3, z);
        this.uri = str;
        this.czm = i;
    }

    public final int getType() {
        return this.czm;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void a(ad adVar) {
        this.czk.lWS = adVar;
    }

    public final int Bu() {
        return this.brn;
    }
}
