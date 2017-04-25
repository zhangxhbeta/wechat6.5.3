package com.tencent.mm.plugin.appbrand.l.e;

import com.tencent.mm.sdk.platformtools.v;

public final class d extends g implements b {
    private String dTM = "*";

    public final void oA(String str) {
        if (str == null) {
            v.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
        } else {
            this.dTM = str;
        }
    }

    public final String SD() {
        return this.dTM;
    }
}
