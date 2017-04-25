package com.tencent.mm.v;

import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class o implements c {
    private final d cAp;

    public o(d dVar) {
        this.cAp = dVar;
    }

    public final byte[] BP() {
        try {
            return this.cAp.BP();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
            return null;
        }
    }

    public final byte[] uT() {
        try {
            return this.cAp.uT();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
            return null;
        }
    }

    public final int ww() {
        int i = 0;
        try {
            i = this.cAp.ww();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
        return i;
    }

    private String getUsername() {
        try {
            return this.cAp.getUsername();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
            return null;
        }
    }

    public final boolean BQ() {
        boolean z = false;
        try {
            z = this.cAp.BQ();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
        return z;
    }

    public final void setUsername(String str) {
        try {
            this.cAp.setUsername(str);
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
    }

    public final void i(byte[] bArr, int i) {
        try {
            this.cAp.i(bArr, i);
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
    }

    public final void reset() {
        try {
            this.cAp.reset();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
    }

    public final String toString() {
        return (((("RAccInfo:\n" + "|-uin     =" + ww() + "\n") + "|-user    =" + getUsername() + "\n") + "|-session =" + uT() + "\n") + "|-ecdhkey =" + be.bk(BR()) + "\n") + "`-cookie  =" + be.bk(BP());
    }

    public final void h(String str, byte[] bArr) {
        try {
            this.cAp.h(str, bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
    }

    public final byte[] gS(String str) {
        try {
            return this.cAp.gS(str);
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
            return null;
        }
    }

    public final byte[] BR() {
        try {
            return this.cAp.BR();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
            return null;
        }
    }

    public final void aS(boolean z) {
        try {
            this.cAp.aS(z);
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
    }

    public final boolean BS() {
        boolean z = true;
        try {
            z = this.cAp.BS();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = be.e(e);
            v.e("MicroMsg.RAccInfo", "exception:%s", objArr);
        }
        return z;
    }

    public final byte[] BT() {
        try {
            return this.cAp.BT();
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", be.e(e));
            return null;
        }
    }

    public final int A(byte[] bArr) {
        try {
            return this.cAp.A(bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", be.e(e));
            return -6;
        }
    }

    public final void cW(int i) {
        try {
            this.cAp.cW(i);
        } catch (Throwable e) {
            v.e("MicroMsg.RAccInfo", "exception:%s", be.e(e));
        }
    }
}
