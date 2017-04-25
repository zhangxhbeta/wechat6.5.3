package com.tencent.mm.wallet_core.b;

import android.os.Bundle;
import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class k extends com.tencent.mm.v.k implements j {
    public int cVh = 0;
    private int fra = 0;
    private long kXs;
    public String mProcessName = "";
    public long piE = 0;
    public Bundle uA;

    public abstract void c(int i, int i2, String str, p pVar);

    public int axM() {
        return -1;
    }

    public void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis() - this.kXs;
        String str2 = "";
        String str3 = "";
        this.fra = axM();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.uA != null) {
            str2 = this.uA.getString("key_TransId");
            str3 = this.uA.getString("key_reqKey");
            if (this.piE == 0) {
                this.piE = this.uA.getLong("key_SessionId", 0);
            }
            if (this.cVh == 0) {
                this.cVh = this.uA.getInt("key_scene");
            }
        }
        g.iuh.h(11170, new Object[]{Integer.valueOf(getType()), Integer.valueOf(this.fra), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(ak.getNetType(aa.getContext())), this.mProcessName, str2, str3, Long.valueOf(this.piE), Long.valueOf(currentTimeMillis2)});
        n.a(getType(), axM(), i2, i3, currentTimeMillis, this.cVh, this.mProcessName);
        c(i2, i3, str, pVar);
    }

    public final int a(e eVar, p pVar, j jVar) {
        this.kXs = System.currentTimeMillis();
        return super.a(eVar, pVar, jVar);
    }
}
