package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.v;

public final class x implements m {
    public h fxB;

    public x(h hVar) {
        this.fxB = hVar;
    }

    public final boolean b(int i, j jVar) {
        boolean z = false;
        try {
            z = this.fxB.b(i, jVar);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean c(int i, j jVar) {
        boolean z = false;
        try {
            z = this.fxB.c(i, jVar);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final long[] ajF() {
        try {
            return this.fxB.ajF();
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return null;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        boolean z = false;
        u.ajV().bj(j);
        try {
            z = this.fxB.a(j, i, kVar);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean bm(long j) {
        boolean z = false;
        u.ajV().bj(j);
        try {
            z = this.fxB.bm(j);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final long a(p pVar) {
        try {
            return this.fxB.a(pVar);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return -1;
        }
    }

    public final boolean a(i iVar) {
        boolean z = false;
        try {
            z = this.fxB.a(iVar);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        v.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", new Object[]{Long.valueOf(j)});
        try {
            this.fxB.setChannelSessionKey(j, bArr);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        boolean z2 = false;
        v.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        try {
            z2 = this.fxB.a(str, z, qVar);
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z2]);
        }
        return z2;
    }

    public final boolean b(n nVar) {
        try {
            this.fxB.a(nVar);
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return false;
        }
    }

    public final int ajM() {
        int i = 0;
        try {
            i = this.fxB.ajM();
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.getStepCount failed!!, %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[i]);
        }
        return i;
    }

    public final boolean a(j jVar) {
        boolean z = false;
        try {
            z = this.fxB.d(0, jVar);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean b(j jVar) {
        boolean z = false;
        try {
            z = this.fxB.e(0, jVar);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean a(long j, k kVar) {
        boolean z = false;
        try {
            z = this.fxB.b(j, 0, kVar);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean bp(long j) {
        boolean z = false;
        try {
            z = this.fxB.bp(j);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean a(s sVar) {
        boolean z = false;
        try {
            z = this.fxB.a(sVar);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        boolean z = false;
        try {
            z = this.fxB.b(j, bArr, tVar);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
        }
        return z;
    }

    public final int getInt(int i, int i2) {
        try {
            i2 = this.fxB.getInt(i, i2);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
        }
        return i2;
    }

    public final long getLong(int i, long j) {
        try {
            j = this.fxB.getLong(i, j);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
        }
        return j;
    }

    public final String getString(int i, String str) {
        try {
            str = this.fxB.getString(i, str);
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
        }
        return str;
    }
}
