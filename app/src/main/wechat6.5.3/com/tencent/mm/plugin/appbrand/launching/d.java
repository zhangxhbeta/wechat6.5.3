package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.h.e;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.a.b;
import com.tencent.mm.t.h;
import java.util.concurrent.Future;

public class d extends e<AppBrandSysConfig> {
    final String aWH;
    final int bpD;
    final int dLp;

    public /* synthetic */ Object call() {
        return QE();
    }

    public d(String str, int i, int i2) {
        this.aWH = str;
        this.bpD = i;
        this.dLp = i2;
    }

    public void QD() {
    }

    public void c(AppBrandSysConfig appBrandSysConfig) {
    }

    public final AppBrandSysConfig QE() {
        AppBrandSysConfig nh = a.OO().nh(this.aWH);
        if (nh == null) {
            f.nJ(com.tencent.mm.plugin.appbrand.k.a.d(2131230967, ""));
        }
        if (nh == null) {
            v.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "get null config!!!");
            return null;
        } else if (new k(nh, this.bpD, this.dLp).QG()) {
            v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "ban by op, return null, username %s, appId %s", new Object[]{nh.aWH, nh.appId});
            return null;
        } else {
            boolean z;
            int i;
            final String str = nh.appId;
            Future submit = c.QC().submit(new g(this, nh.appId, this.bpD, nh.dDB.dBs, nh.dDB.dBw) {
                final /* synthetic */ d dLq;

                final void QD() {
                    this.dLq.QD();
                }
            });
            Future submit2 = c.QC().submit(new i(str, this.bpD));
            if (this.bpD == 0) {
                z = true;
            } else {
                z = false;
            }
            Future submit3 = c.QC().submit(new h(z));
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) submit.get();
            if (wxaPkgWrappingInfo == null) {
                v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig null app pkg, username %s appId %s", new Object[]{nh.aWH, nh.appId});
                i = 0;
            } else {
                nh.dDB.b(wxaPkgWrappingInfo);
                if (nh.dDB.dBr != 0) {
                    nh.dDB.dBs = 0;
                }
                v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, app pkg %s", new Object[]{nh.aWH, nh.appId, nh.dDB});
                nh.dDC.b((WxaPkgWrappingInfo) submit3.get());
                if (999 != nh.dDC.dBr) {
                    nh.dDC.dBr = 0;
                }
                v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, lib pkg %s", new Object[]{nh.aWH, nh.appId, nh.dDC});
                e eVar = (e) submit2.get();
                if (eVar != null) {
                    nh.dDq = be.KG(eVar.field_permByteString);
                }
                if (nh.dDq == null) {
                    v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, perm %s, bytes null", new Object[]{nh.aWH, nh.appId, eVar});
                    i = 0;
                } else {
                    k.a anonymousClass3;
                    nh.dDD = AppBrandGlobalSystemConfig.Py();
                    if (nh.dDD == null) {
                        nh.dDD = AppBrandGlobalSystemConfig.dYV;
                    }
                    if (this.bpD == 0) {
                        anonymousClass3 = new k.a(this) {
                            final /* synthetic */ d dLq;

                            public final void a(k.a.a aVar, AppBrandSysConfig appBrandSysConfig) {
                                if (new k(appBrandSysConfig, this.dLq.bpD, this.dLq.dLp).QG()) {
                                    AppBrandTaskManager.ab(str, this.dLq.bpD);
                                }
                            }
                        };
                    } else {
                        anonymousClass3 = null;
                    }
                    k.a(this.aWH, anonymousClass3);
                    h c = a.OO().c(this.aWH, new String[]{"roundedSquareIcon", "BigHeadImgUrl"});
                    if (c != null) {
                        if (!be.kS(c.field_roundedSquareIcon)) {
                            b.AL().mF(c.field_roundedSquareIcon);
                        } else if (!be.kS(c.field_BigHeadImgUrl)) {
                            b.AL().mF(c.field_BigHeadImgUrl);
                        }
                    }
                    v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig ok username %s, appId %s", new Object[]{nh.aWH, nh.appId});
                    i = 1;
                }
            }
            if (i == 0) {
                v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig, false, username %s, appId %s", new Object[]{nh.aWH, nh.appId});
                return null;
            }
            v.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "prepare ok, just go weapp, username %s, appId %s", new Object[]{nh.aWH, nh.appId});
            return nh;
        }
    }
}
