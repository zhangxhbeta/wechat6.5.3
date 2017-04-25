package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;

public final class e extends f<d> {
    public static final String[] dBH = new String[]{f.a(d.cxi, "AppBrandCommonKVData")};
    public final d dBY;

    public e(d dVar) {
        super(dVar, d.cxi, "AppBrandCommonKVData", null);
        this.dBY = dVar;
    }

    public final boolean aF(String str, String str2) {
        if (be.kS(str)) {
            return false;
        }
        d dVar = new d();
        dVar.field_key = str;
        dVar.field_value = str2;
        if (!be.kS(dVar.field_value)) {
            return super.a(dVar);
        }
        if (super.c(dVar, new String[0])) {
            return false;
        }
        return true;
    }

    public final String get(String str, String str2) {
        if (be.kS(str)) {
            return str2;
        }
        d dVar = new d();
        dVar.field_key = str;
        if (super.b(dVar, new String[0])) {
            return dVar.field_value;
        }
        return str2;
    }
}
