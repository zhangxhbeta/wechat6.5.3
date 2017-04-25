package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.appcache.m.a.b;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.j.c;
import java.util.concurrent.CountDownLatch;

class g extends e<WxaPkgWrappingInfo> {
    final String appId;
    final int bpD;
    final int dBs;
    final String dLs;

    public /* synthetic */ Object call() {
        c k = h.k(this.appId, this.bpD, this.dBs);
        if (k.get(1) != null) {
            return (WxaPkgWrappingInfo) k.get(1);
        }
        if (a.dAQ.equals(k.get(0))) {
            return QF();
        }
        a((a) k.get(0));
        return null;
    }

    g(String str, int i, int i2, String str2) {
        this.appId = str;
        this.bpD = i;
        this.dBs = i2;
        this.dLs = str2;
    }

    void QD() {
    }

    private WxaPkgWrappingInfo QF() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final com.tencent.mm.plugin.appbrand.k.h hVar = new com.tencent.mm.plugin.appbrand.k.h();
        m.a anonymousClass1 = new m.a(this) {
            final /* synthetic */ g dLv;

            public final void a(String str, b bVar, m.a.a aVar) {
                v.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "onPkgUpdatingCallback, appId = %s, return = %s", new Object[]{str, bVar.name()});
                if (b.OK.equals(bVar)) {
                    WxaPkgWrappingInfo mO = WxaPkgWrappingInfo.mO(aVar.filePath);
                    if (mO == null) {
                        v.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "onPkgUpdatingCallback, ret=OK but obtain null appPkgInfo");
                    } else {
                        mO.dBs = aVar.version;
                        mO.dBt = com.tencent.mm.plugin.appbrand.k.a.Sm();
                        mO.dBr = aVar.dzx;
                        hVar.dTk = mO;
                    }
                } else if (b.SEVER_FILE_NOT_FOUND.equals(bVar)) {
                    f.he(2131230971);
                    com.tencent.mm.plugin.appbrand.report.a.S(str, 23);
                } else {
                    f.nJ(com.tencent.mm.plugin.appbrand.k.a.d(2131230968, Integer.valueOf(2), Integer.valueOf(bVar.aJW)));
                }
                countDownLatch.countDown();
            }
        };
        QD();
        if (this.bpD == 0) {
            v.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[]{this.appId, Integer.valueOf(this.dBs)});
            if (!m.a(this.appId, com.tencent.mm.plugin.appbrand.appcache.c.OQ(), this.dBs, this.dLs, anonymousClass1)) {
                a(a.dAR);
                return null;
            }
        }
        v.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[]{this.appId, Integer.valueOf(this.bpD)});
        if (com.tencent.mm.plugin.appbrand.a.a.dzP == null) {
            v.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, null storage");
            a(a.dAR);
            return null;
        }
        String str;
        l lVar = com.tencent.mm.plugin.appbrand.a.a.dzP;
        String str2 = this.appId;
        int i = this.bpD;
        Cursor query = lVar.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"downloadURL"}, String.format("%s=? and %s=? order by %s desc limit 1 offset 0", new Object[]{"appId", "debugType", "createTime"}), new String[]{str2, String.valueOf(i)}, null, null, null);
        if (query == null) {
            str = null;
        } else if (query.getCount() <= 0) {
            query.close();
            str = null;
        } else {
            query.moveToFirst();
            str = query.getString(0);
            query.close();
        }
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "triggerDownloading, url is null or nil");
            a(a.dAN);
            return null;
        }
        m.a(this.appId, str, this.bpD, anonymousClass1);
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            v.a("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        return (WxaPkgWrappingInfo) hVar.dTk;
    }

    private void a(a aVar) {
        int i = 2131230955;
        if (a.dAN.equals(aVar)) {
            String d;
            if (this.bpD == 1) {
                d = com.tencent.mm.plugin.appbrand.k.a.d(2131230955, new Object[0]);
            } else {
                d = com.tencent.mm.plugin.appbrand.k.a.d(2131230970, com.tencent.mm.plugin.appbrand.appcache.c.gX(this.bpD));
            }
            if (this.bpD == 1) {
                AppBrandTaskManager.ab(this.appId, this.bpD);
                com.tencent.mm.plugin.appbrand.report.a.S(this.appId, 10);
            }
            f.nJ(d);
        } else if (a.dAP.equals(aVar) || a.dAO.equals(aVar)) {
            if (this.bpD == 0) {
                i = 2131230957;
            }
            f.he(i);
            if (this.bpD == 1) {
                com.tencent.mm.plugin.appbrand.report.a.S(this.appId, 10);
            }
            AppBrandTaskManager.ab(this.appId, this.bpD);
        } else {
            f.nJ(com.tencent.mm.plugin.appbrand.k.a.d(2131230968, Integer.valueOf(1), Integer.valueOf(aVar.Pi())));
        }
    }
}
