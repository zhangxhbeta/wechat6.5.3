package com.tencent.mm.plugin.c.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class e {
    private final g eos = new g();
    public final h eot = new h();

    public final boolean Z(byte[] bArr) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            return false;
        }
        a aVar = new a(bArr.length);
        aVar.v(bArr, bArr.length);
        boolean a = this.eos.a(aVar);
        if (a) {
            a = this.eot.a(aVar);
            if (a) {
                return a;
            }
            v.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            return a;
        }
        v.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
        return a;
    }
}
