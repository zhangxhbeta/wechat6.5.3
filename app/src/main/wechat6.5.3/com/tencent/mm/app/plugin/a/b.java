package com.tencent.mm.app.plugin.a;

import com.tencent.mm.compatible.d.r.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;

public final class b implements a {
    private q aSJ = new q(t.cng + "stepcounter.cfg");

    public b() {
        v.i("MicroMsg.DefaultCfgAccessibleImpl", "new DefaultCfgAccessibleImpl.");
    }

    public final void i(int i, String str) {
        v.d("MicroMsg.DefaultCfgAccessibleImpl", "setString(%s, %s), process : %s", Integer.valueOf(i), str, aa.getProcessName());
        this.aSJ.set(i, str);
    }

    public final void i(int i, long j) {
        v.d("MicroMsg.DefaultCfgAccessibleImpl", "setLong(%s, %s), process : %s", Integer.valueOf(i), Long.valueOf(j), aa.getProcessName());
        this.aSJ.setLong(i, j);
    }

    public final void ar(int i, int i2) {
        v.d("MicroMsg.DefaultCfgAccessibleImpl", "setInt(%s, %s), process : %s", Integer.valueOf(i), Integer.valueOf(i2), aa.getProcessName());
        this.aSJ.set(i, Integer.valueOf(i2));
    }

    public final String getString(int i, String str) {
        v.d("MicroMsg.DefaultCfgAccessibleImpl", "getString(%s, %s), process : %s", Integer.valueOf(i), str, aa.getProcessName());
        try {
            return (String) this.aSJ.get(i, str);
        } catch (Exception e) {
            return str;
        }
    }

    public final long getLong(int i, long j) {
        v.d("MicroMsg.DefaultCfgAccessibleImpl", "getLong(%s, %s), process : %s", Integer.valueOf(i), Long.valueOf(j), aa.getProcessName());
        try {
            j = this.aSJ.getLong(i, j);
        } catch (Exception e) {
        }
        return j;
    }

    public final int getInt(int i, int i2) {
        v.d("MicroMsg.DefaultCfgAccessibleImpl", "getInt(%s, %s), process : %s", Integer.valueOf(i), Integer.valueOf(i2), aa.getProcessName());
        try {
            i2 = this.aSJ.getInt(i, i2);
        } catch (Exception e) {
        }
        return i2;
    }
}
