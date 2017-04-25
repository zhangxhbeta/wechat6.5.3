package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.appcache.m.a;
import com.tencent.mm.plugin.appbrand.appcache.m.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.vending.j.c;
import java.util.concurrent.CountDownLatch;

final class h extends e<WxaPkgWrappingInfo> implements a {
    private final boolean dLw;
    private final CountDownLatch dLx = new CountDownLatch(1);
    private volatile int dLy = 0;

    public final /* synthetic */ Object call() {
        c cVar;
        while (true) {
            c bt = com.tencent.mm.plugin.appbrand.appcache.h.bt(this.dLw);
            if (!this.dLw && bt.get(1) == null) {
                if (bt.get(0) != com.tencent.mm.plugin.appbrand.appcache.h.a.dAQ) {
                    break;
                }
                i a = com.tencent.mm.plugin.appbrand.a.a.dzP.a("@LibraryAppId", 999, new String[]{"downloadURL"});
                if (a != null && !be.kS(a.field_downloadURL)) {
                    int i = this.dLy;
                    this.dLy = i + 1;
                    if (i > 0) {
                        break;
                    }
                    m.a(a.field_downloadURL, this);
                    this.dLx.await();
                } else {
                    break;
                }
            }
            cVar = bt;
            if (cVar.get(1) == null) {
                return e.OR();
            }
            if (((WxaPkgWrappingInfo) cVar.get(1)).dBr != 0) {
                ((WxaPkgWrappingInfo) cVar.get(1)).dBs = 0;
            }
            return (WxaPkgWrappingInfo) cVar.get(1);
        }
        cVar = com.tencent.mm.plugin.appbrand.appcache.h.bt(true);
        if (cVar.get(1) == null) {
            return e.OR();
        }
        if (((WxaPkgWrappingInfo) cVar.get(1)).dBr != 0) {
            ((WxaPkgWrappingInfo) cVar.get(1)).dBs = 0;
        }
        return (WxaPkgWrappingInfo) cVar.get(1);
    }

    h(boolean z) {
        this.dLw = z;
    }

    public final void a(String str, b bVar, a.a aVar) {
        this.dLx.countDown();
    }
}
