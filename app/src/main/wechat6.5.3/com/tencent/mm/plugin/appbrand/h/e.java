package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.e.b.i;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import java.lang.reflect.Field;

public final class e extends i {
    static final String[] btd = i.btd;
    static final a cxi;
    static final String dDR;

    static {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appIdHashCode";
        aVar.nmd.put("appIdHashCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHashCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "appIdHashCode";
        aVar.bXK[1] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "permByteString";
        aVar.nmd.put("permByteString", "TEXT");
        stringBuilder.append(" permByteString TEXT");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        cxi = aVar;
        dDR = f.a(aVar, "AppBrandJSApiCtrlInfo");
    }

    final boolean J(byte[] bArr) {
        String bn = be.bn(bArr);
        if (be.ma(bn).equals(this.field_permByteString)) {
            return false;
        }
        this.field_permByteString = bn;
        return true;
    }

    protected final a tl() {
        return cxi;
    }
}
