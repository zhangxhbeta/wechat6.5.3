package com.tencent.mm.plugin.exdevice;

import com.tencent.mm.plugin.exdevice.service.x;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;

public final class a implements com.tencent.mm.compatible.d.r.a {
    private q aSJ = new q(t.cng + "stepcounter.cfg");
    private x fqU;

    public a() {
        v.i("MicroMsg.exdevice.CfgAccessibleIPCImpl", "new CfgAccessibleIPCImpl.");
    }

    public final void a(x xVar) {
        this.fqU = xVar;
        v.d("MicroMsg.exdevice.CfgAccessibleIPCImpl", "setIPCDispatcher, process : %s", new Object[]{aa.getProcessName()});
    }

    public final int getInt(int i, int i2) {
        v.d("MicroMsg.exdevice.CfgAccessibleIPCImpl", "getInt(%s, %s), process : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), aa.getProcessName()});
        if (aim()) {
            try {
                return this.aSJ.getInt(i, i2);
            } catch (Exception e) {
                return i2;
            }
        } else if (this.fqU != null) {
            return this.fqU.getInt(i, i2);
        } else {
            return i2;
        }
    }

    public final long getLong(int i, long j) {
        v.d("MicroMsg.exdevice.CfgAccessibleIPCImpl", "getLong(%s, %s), process : %s", new Object[]{Integer.valueOf(i), Long.valueOf(j), aa.getProcessName()});
        if (aim()) {
            try {
                return this.aSJ.getLong(i, j);
            } catch (Exception e) {
                return j;
            }
        } else if (this.fqU != null) {
            return this.fqU.getLong(i, j);
        } else {
            return j;
        }
    }

    public final String getString(int i, String str) {
        v.d("MicroMsg.exdevice.CfgAccessibleIPCImpl", "getString(%s, %s), process : %s", new Object[]{Integer.valueOf(i), str, aa.getProcessName()});
        if (aim()) {
            try {
                return (String) this.aSJ.get(i, str);
            } catch (Exception e) {
                return str;
            }
        } else if (this.fqU != null) {
            return this.fqU.getString(i, str);
        } else {
            return str;
        }
    }

    public final void ar(int i, int i2) {
        v.d("MicroMsg.exdevice.CfgAccessibleIPCImpl", "putInt(%s, %s), process : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), aa.getProcessName()});
        if (aim()) {
            this.aSJ.setInt(i, i2);
        } else if (this.fqU != null) {
            try {
                this.fqU.fxB.ar(i, i2);
            } catch (Throwable e) {
                v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            }
        }
    }

    public final void i(int i, long j) {
        v.d("MicroMsg.exdevice.CfgAccessibleIPCImpl", "putLong(%s, %s), process : %s", new Object[]{Integer.valueOf(i), Long.valueOf(j), aa.getProcessName()});
        if (aim()) {
            this.aSJ.setLong(i, j);
        } else if (this.fqU != null) {
            try {
                this.fqU.fxB.i(i, j);
            } catch (Throwable e) {
                v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            }
        }
    }

    public final void i(int i, String str) {
        v.d("MicroMsg.exdevice.CfgAccessibleIPCImpl", "putString(%s, %s), process : %s", new Object[]{Integer.valueOf(i), str, aa.getProcessName()});
        if (aim()) {
            this.aSJ.set(i, str);
        } else if (this.fqU != null) {
            try {
                this.fqU.fxB.i(i, str);
            } catch (Throwable e) {
                v.a("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            }
        }
    }

    private boolean aim() {
        return (!aa.btr() && this.fqU == null) || aa.btr();
    }
}
