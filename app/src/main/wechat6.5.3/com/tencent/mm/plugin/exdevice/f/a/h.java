package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public final class h extends a<mn, mo> {
    private final WeakReference<b<h>> fru;
    String username;

    protected final /* bridge */ /* synthetic */ void a(com.tencent.mm.ba.a aVar) {
        ((mn) aVar).moR = this.username;
    }

    protected final /* synthetic */ com.tencent.mm.ba.a ain() {
        return new mn();
    }

    protected final /* synthetic */ com.tencent.mm.ba.a aio() {
        return new mo();
    }

    public h(String str, b<h> bVar) {
        this.username = str;
        this.fru = new WeakReference(bVar);
    }

    public final int getType() {
        return 1792;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        super.a(i, i2, i3, str, pVar, bArr);
        if (i2 == 0 && i3 == 0) {
            ac.ajs().sl(this.username);
        }
        b bVar = (b) this.fru.get();
        if (bVar != null) {
            bVar.c(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }
}
