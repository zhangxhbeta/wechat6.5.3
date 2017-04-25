package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.bg.g;
import com.tencent.mm.protocal.c.ck;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public final class f extends com.tencent.mm.sdk.h.f<e> {
    private static volatile f dPv = null;
    private final g dBf;

    public final /* synthetic */ boolean b(c cVar) {
        return a((e) cVar);
    }

    public f(g gVar) {
        super(gVar, e.cxi, "AppBrandJSApiCtrlInfo", e.btd);
        this.dBf = gVar;
    }

    final boolean T(List<ck> list) {
        if (be.bP(list)) {
            return false;
        }
        long er = this.dBf.er(Thread.currentThread().getId());
        for (ck ckVar : list) {
            String str = ckVar.mbH;
            byte[] bArr = ckVar.mcE.lVU;
            if (!be.kS(str)) {
                e eVar = new e();
                eVar.field_appIdHashCode = str.hashCode();
                if (!super.b(eVar, new String[0])) {
                    eVar.field_appId = str;
                    eVar.J(bArr);
                    a(eVar);
                } else if (eVar.J(bArr)) {
                    boolean z;
                    if (be.kS(eVar.field_appId)) {
                        z = false;
                    } else {
                        eVar.field_appIdHashCode = eVar.field_appId.hashCode();
                        z = super.a(eVar, new String[0]);
                    }
                    if (z) {
                    }
                }
            }
        }
        return this.dBf.es(er) == 0;
    }

    private boolean a(e eVar) {
        if (be.kS(eVar.field_appId)) {
            return false;
        }
        eVar.field_appIdHashCode = eVar.field_appId.hashCode();
        return super.b(eVar);
    }

    public final e oj(String str) {
        if (be.kS(str)) {
            return null;
        }
        e eVar = new e();
        eVar.field_appIdHashCode = str.hashCode();
        if (super.b(eVar, new String[]{"appIdHashCode"})) {
            return eVar;
        }
        return null;
    }
}
