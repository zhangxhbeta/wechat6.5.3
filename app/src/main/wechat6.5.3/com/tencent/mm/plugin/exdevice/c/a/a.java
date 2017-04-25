package com.tencent.mm.plugin.exdevice.c.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.lj;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public final class a extends com.tencent.mm.plugin.exdevice.a.a<lj, lk> {
    String aRh;
    String aZN;
    String appId;
    String frt;
    private WeakReference<b<a>> fru;

    protected final /* bridge */ /* synthetic */ void a(com.tencent.mm.ba.a aVar) {
        lj ljVar = (lj) aVar;
        ljVar.mnR = this.aRh;
        ljVar.meq = this.aZN;
        ljVar.mnS = this.frt;
        ljVar.glj = this.appId;
    }

    protected final /* synthetic */ com.tencent.mm.ba.a ain() {
        return new lj();
    }

    protected final /* synthetic */ com.tencent.mm.ba.a aio() {
        return new lk();
    }

    public a(String str, String str2, String str3, String str4, b<a> bVar) {
        this.aRh = be.ma(str);
        this.aZN = be.ma(str2);
        this.frt = be.ma(str3);
        this.appId = be.ma(str4);
        this.fru = new WeakReference(bVar);
    }

    public final int getType() {
        return 1799;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, pVar.toString()});
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.fru.get();
        if (bVar != null) {
            bVar.c(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
    }
}
