package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public final class a implements i {
    public static h drp;
    public static g drq;

    public final void a(h hVar) {
        drp = hVar;
    }

    public final void a(g gVar) {
        drq = gVar;
    }

    public static void c(int i, Object obj) {
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "set config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = obj == null ? "null" : obj.toString();
        v.i(str, str2, objArr);
        ak.yW();
        c.vf().set(i, obj);
    }
}
