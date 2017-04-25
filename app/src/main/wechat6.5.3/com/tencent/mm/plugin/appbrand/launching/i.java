package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.h.e;
import com.tencent.mm.plugin.appbrand.netscene.g;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

final class i extends e<e> {
    private final String appId;
    private final int bpD;

    public final /* synthetic */ Object call() {
        b bVar;
        String str = this.appId;
        int i = this.bpD;
        c t = a.t(null, null);
        if (be.kS(str)) {
            bVar = t;
        } else {
            Object b;
            Object oj = com.tencent.mm.plugin.appbrand.a.a.dzR.oj(str);
            if (oj == null) {
                List arrayList = new ArrayList(1);
                arrayList.add(a.t(str, Integer.valueOf(i)));
                b = g.b(com.tencent.mm.plugin.appbrand.h.g.U(arrayList));
                if (b == null || (b instanceof g.a)) {
                    bVar = t;
                } else if (b.errType == 0 && b.errCode == 0) {
                    arrayList = ((kg) b.bra).mmQ;
                    if (be.bP(arrayList)) {
                        v.e("MicroMsg.AppPermissionUpdater", "synchronousGet, resp info list is Null Or Nil");
                    } else {
                        boolean V = com.tencent.mm.plugin.appbrand.h.g.V(arrayList);
                        v.i("MicroMsg.AppPermissionUpdater", "synchronousGet, infoList.size %d, updateDB %b", new Object[]{Integer.valueOf(arrayList.size()), Boolean.valueOf(V)});
                    }
                    oj = com.tencent.mm.plugin.appbrand.a.a.dzR.oj(str);
                } else {
                    v.e("MicroMsg.AppPermissionUpdater", "synchronousGet, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(b.errType), Integer.valueOf(b.errCode), b.biS});
                    bVar = a.t(null, b);
                }
            } else {
                b = null;
            }
            v.i("MicroMsg.AppPermissionUpdater", "synchronousGet, return perm %s", new Object[]{oj});
            bVar = a.t(oj, b);
        }
        String str2;
        if (bVar.get(0) != null) {
            if (bVar.get(1) == null) {
                str2 = this.appId;
                int i2 = this.bpD;
                if (be.kS(str2)) {
                    v.e("MicroMsg.AppPermissionUpdater", "sync, appId is null or nil");
                } else {
                    List linkedList = new LinkedList();
                    linkedList.add(a.t(str2, Integer.valueOf(i2)));
                    com.tencent.mm.plugin.appbrand.h.g.a(linkedList, null);
                }
            }
            return (e) bVar.get(0);
        }
        Object[] objArr = new Object[1];
        if (bVar.get(1) == null) {
            str2 = "";
        } else {
            str2 = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((com.tencent.mm.v.a.a) bVar.get(1)).errType), Integer.valueOf(((com.tencent.mm.v.a.a) bVar.get(1)).errCode)});
        }
        objArr[0] = str2;
        f.nJ(f.d(2131230969, objArr));
        return null;
    }

    i(String str, int i) {
        this.appId = str;
        this.bpD = i;
    }
}
