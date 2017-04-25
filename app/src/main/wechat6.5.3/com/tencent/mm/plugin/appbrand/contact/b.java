package com.tencent.mm.plugin.appbrand.contact;

import com.tencent.mm.bg.g;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;

public final class b extends f<a> {
    public static final String[] dBH = new String[]{f.a(a.cxi, "WxAppContact")};
    final g dBf;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        a aVar = (a) cVar;
        if (be.kS(aVar.field_UserName)) {
            return false;
        }
        aVar.field_UserNameHash = aVar.field_UserName.hashCode();
        return super.a(aVar, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((a) cVar);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((a) cVar, strArr);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        a aVar = (a) cVar;
        if (be.kS(aVar.field_UserName)) {
            return false;
        }
        aVar.field_UserNameHash = aVar.field_UserName.hashCode();
        return super.c(aVar, strArr);
    }

    public b(g gVar) {
        super(gVar, a.cxi, "WxAppContact", a.btd);
        this.dBf = gVar;
    }

    public final boolean a(a aVar, String... strArr) {
        if (be.kS(aVar.field_UserName)) {
            return false;
        }
        aVar.field_UserNameHash = aVar.field_UserName.hashCode();
        return super.b(aVar, strArr);
    }

    public final boolean a(a aVar) {
        if (be.kS(aVar.field_UserName)) {
            return false;
        }
        aVar.field_UserNameHash = aVar.field_UserName.hashCode();
        return super.b(aVar);
    }
}
