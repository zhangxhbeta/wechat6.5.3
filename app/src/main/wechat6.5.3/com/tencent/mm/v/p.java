package com.tencent.mm.v;

import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.k;
import com.tencent.mm.network.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class p implements e {
    public final f cAq;
    private o cAr;

    public p(f fVar) {
        this.cAq = fVar;
    }

    public final int a(q qVar, k kVar) {
        try {
            return this.cAq.a(qVar, kVar);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return -1;
        }
    }

    public final String getNetworkServerIp() {
        try {
            return this.cAq.getNetworkServerIp();
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return null;
        }
    }

    public final String[] getIPsString(boolean z) {
        try {
            return this.cAq.getIPsString(z);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return null;
        }
    }

    public final void cancel(int i) {
        try {
            this.cAq.cancel(i);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", Integer.valueOf(i), e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void reset() {
        try {
            this.cAq.reset();
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
        try {
            this.cAq.a(z, str, str2, iArr, iArr2, i, i2, str3, str4);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final c BU() {
        try {
            if (this.cAr == null) {
                this.cAr = new o(this.cAq.LY());
            }
            return this.cAr;
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return null;
        }
    }

    public final void a(b bVar) {
        try {
            this.cAq.a(bVar);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void aT(boolean z) {
        try {
            this.cAq.aT(z);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final boolean BK() {
        boolean z = true;
        try {
            z = this.cAq.BK();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = e;
            v.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", objArr);
            objArr = new Object[z];
            objArr[0] = be.e(e);
            v.e("MicroMsg.RDispatcher", "exception:%s", objArr);
        }
        return z;
    }

    public final h BV() {
        try {
            return this.cAq.Ma();
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return null;
        }
    }

    public final void a(ac acVar) {
        try {
            this.cAq.a(acVar);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void gT(String str) {
        try {
            this.cAq.gT(str);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", e);
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final int getHostByName(String str, List<String> list) {
        try {
            return this.cAq.getHostByName(str, list);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return -1;
        }
    }

    public final int a(String str, boolean z, List<String> list) {
        try {
            return this.cAq.a(str, z, list);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return -1;
        }
    }

    public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
        try {
            this.cAq.setHostInfo(strArr, strArr2, iArr);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void a(int i, String str, int i2, boolean z) {
        try {
            this.cAq.a(i, str, i2, z);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final String getIspId() {
        try {
            return this.cAq.getIspId();
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
            return null;
        }
    }

    public final void setSignallingStrategy(long j, long j2) {
        try {
            this.cAq.setSignallingStrategy(j, j2);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void keepSignalling() {
        try {
            this.cAq.keepSignalling();
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void stopSignalling() {
        try {
            this.cAq.stopSignalling();
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void a(n nVar) {
        try {
            this.cAq.a(nVar);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void reportFailIp(String str) {
        try {
            this.cAq.reportFailIp(str);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void gU(String str) {
        try {
            this.cAq.gU(str);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void aU(boolean z) {
        try {
            this.cAq.aU(z);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void aV(boolean z) {
        try {
            this.cAq.aV(z);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void aW(boolean z) {
        try {
            this.cAq.aW(z);
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }

    public final void BW() {
        try {
            this.cAq.BW();
        } catch (Throwable e) {
            v.e("MicroMsg.RDispatcher", "exception:%s", be.e(e));
        }
    }
}
