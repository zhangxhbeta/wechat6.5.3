package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.protocal.c.ck;
import com.tencent.mm.protocal.c.kf;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import com.tencent.mm.vending.j.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public final class g {

    public interface a {
    }

    public static b U(List<c<String, Integer>> list) {
        kf kfVar = new kf();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            kfVar.mmN.add((String) cVar.get(0));
            kfVar.mmO.add((Integer) cVar.get(1));
        }
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = kfVar;
        aVar.czo = new kg();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-checkjsapiinfo";
        aVar.czm = 1187;
        return aVar.Bv();
    }

    public static boolean a(List<c<String, Integer>> list, a aVar) {
        if (be.bP(list)) {
            v.e("MicroMsg.AppPermissionUpdater", "batchSync, reqList is null or nil");
            return false;
        } else if (com.tencent.mm.plugin.appbrand.a.a.dzR == null) {
            v.e("MicroMsg.AppPermissionUpdater", "batchSync, db not ready");
            return false;
        } else {
            final WeakReference weakReference = new WeakReference(null);
            u.a(U(list), new com.tencent.mm.v.u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        List list = ((kg) bVar.czl.czs).mmQ;
                        if (be.bP(list)) {
                            v.e("MicroMsg.AppPermissionUpdater", "batchSync, resp info list is Null Or Nil");
                        } else if (g.V(list)) {
                            if (weakReference.get() != null) {
                                weakReference.get();
                            } else {
                                v.i("MicroMsg.AppPermissionUpdater", "batchSync, try to callback ok but callback is null");
                            }
                        }
                        if (weakReference.get() != null) {
                            weakReference.get();
                        } else {
                            v.i("MicroMsg.AppPermissionUpdater", "batchSync, try to callback fail but callback is null");
                        }
                    } else {
                        v.e("MicroMsg.AppPermissionUpdater", "batchSync, cgi failed, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (weakReference.get() != null) {
                            weakReference.get();
                        }
                    }
                    return 0;
                }
            }, true);
            return true;
        }
    }

    public static boolean V(List<ck> list) {
        if (com.tencent.mm.plugin.appbrand.a.a.dzR == null) {
            v.e("MicroMsg.AppPermissionUpdater", "batchSync update db ctrl info failed, db not ready");
            return false;
        }
        v.i("MicroMsg.AppPermissionUpdater", "batchSync, update list size = %d, ret = %b", new Object[]{Integer.valueOf(list.size()), Boolean.valueOf(com.tencent.mm.plugin.appbrand.a.a.dzR.T(list))});
        return com.tencent.mm.plugin.appbrand.a.a.dzR.T(list);
    }
}
