package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public abstract class a<RequestType extends com.tencent.mm.ba.a, ResponseType extends com.tencent.mm.ba.a> extends k implements j {
    private e cxf;
    protected b fqX;

    public abstract RequestType ain();

    public abstract ResponseType aio();

    public abstract String getUri();

    public void a(RequestType requestType) {
    }

    public final ResponseType Ud() {
        if (this.fqX == null || this.fqX.czl.czs == null) {
            return null;
        }
        return this.fqX.czl.czs;
    }

    public void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        if (this.fqX == null) {
            com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
            aVar.czm = getType();
            aVar.uri = getUri();
            aVar.czn = ain();
            aVar.czo = aio();
            aVar.czp = 0;
            aVar.czq = 0;
            this.fqX = aVar.Bv();
            a(this.fqX.czk.czs);
        }
        return a(eVar, this.fqX, this);
    }
}
