package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.protocal.c.abc;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.a;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d {

    private static final class b extends a<bbl> {
        b(int i, boolean z, int i2, int i3, int i4, String str) {
            com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
            bbk com_tencent_mm_protocal_c_bbk = new bbk();
            if (i == 0) {
                i = BaseReportManager.MAX_READ_COUNT;
            }
            com_tencent_mm_protocal_c_bbk.scene = i;
            com_tencent_mm_protocal_c_bbk.mXq = z ? 1 : 0;
            com_tencent_mm_protocal_c_bbk.mXr = i2;
            com_tencent_mm_protocal_c_bbk.mXs = i3;
            com_tencent_mm_protocal_c_bbk.mXt = i4;
            com_tencent_mm_protocal_c_bbk.username = str;
            aVar.czn = com_tencent_mm_protocal_c_bbk;
            aVar.czo = new bbl();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
            aVar.czm = 1149;
            this.cif = aVar.Bv();
        }
    }

    static void a(String str, int i, int i2, int i3, boolean z, int i4) {
        final int i5 = i4;
        final boolean z2 = z;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final String str2 = str;
        com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable() {
            public final void run() {
                new b(i5, z2, i6, i7, i8, str2).Bt().a(new com.tencent.mm.vending.c.a<Void, a.a<bbl>>(this) {
                    final /* synthetic */ AnonymousClass1 dBV;

                    {
                        this.dBV = r1;
                    }

                    public final /* synthetic */ Object aq(Object obj) {
                        a.a aVar = (a.a) obj;
                        v.i("MicroMsg.AppBrandUsageUpdater", "GetWxaUsageRecord, errType %d, errCode %d, errMsg %s, username %s, versionType %d, scene %d", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.biS, str2, Integer.valueOf(i6), Integer.valueOf(i7)});
                        return phb;
                    }
                });
            }
        });
    }

    public static void ha(final int i) {
        com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable() {
            public final void run() {
                if (!ak.yN() && ak.uz() && com.tencent.mm.plugin.appbrand.a.a.dzS != null) {
                    boolean z;
                    int i = i;
                    if (1 == i) {
                        z = true;
                    } else {
                        t.a aVar = 3 == i ? t.a.nsX : t.a.nsW;
                        ak.yW();
                        z = be.Nh() >= ((Long) c.vf().get(aVar, Long.valueOf(0))).longValue();
                    }
                    if (z) {
                        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
                        abb com_tencent_mm_protocal_c_abb = new abb();
                        com_tencent_mm_protocal_c_abb.bhB = i;
                        aVar2.czn = com_tencent_mm_protocal_c_abb;
                        aVar2.czo = new abc();
                        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
                        aVar2.czm = 1148;
                        u.a(aVar2.Bv(), new u.a(this) {
                            final /* synthetic */ AnonymousClass2 dBX;

                            {
                                this.dBX = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                boolean z = true;
                                ak.yW();
                                c.vf().a(t.a.nsW, Long.valueOf(be.Nh() + 86400));
                                ak.yW();
                                c.vf().a(t.a.nsX, Long.valueOf(be.Nh() + 300000));
                                if (!(com.tencent.mm.plugin.appbrand.a.a.dzS == null || bVar.czl.czs == null || !(bVar.czl.czs instanceof abc))) {
                                    abc com_tencent_mm_protocal_c_abc = (abc) bVar.czl.czs;
                                    if (i == 0 && i2 == 0) {
                                        LinkedList linkedList;
                                        if (2 == i) {
                                            linkedList = com_tencent_mm_protocal_c_abc.mCv;
                                            Collection collection = com_tencent_mm_protocal_c_abc.mCw;
                                            List<bjd> linkedList2 = new LinkedList();
                                            linkedList2.addAll(collection);
                                            Collection hashSet = new HashSet();
                                            for (bjd com_tencent_mm_protocal_c_bjd : linkedList2) {
                                                if (!be.kS(com_tencent_mm_protocal_c_bjd.username)) {
                                                    hashSet.add(com_tencent_mm_protocal_c_bjd.username);
                                                }
                                            }
                                            List linkedList3 = new LinkedList();
                                            linkedList3.addAll(hashSet);
                                            com.tencent.mm.plugin.appbrand.config.k.S(linkedList3);
                                        }
                                        c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
                                        linkedList = com_tencent_mm_protocal_c_abc.mCv;
                                        c.Po();
                                        com.tencent.mm.plugin.appbrand.a.a.dzS.R(com_tencent_mm_protocal_c_abc.mCw);
                                        cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
                                        int i3 = com_tencent_mm_protocal_c_abc.status;
                                        ak.yW();
                                        r vf = c.vf();
                                        if (!cVar.Pp()) {
                                            vf.a(t.a.nsZ, Boolean.valueOf((i3 & 2) > 0));
                                        }
                                        t.a aVar = t.a.nsY;
                                        if ((i3 & 1) <= 0) {
                                            z = false;
                                        }
                                        vf.a(aVar, Boolean.valueOf(z));
                                    } else {
                                        v.e("MicroMsg.AppBrandUsageUpdater", "GetWxaUsageRecord, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                                    }
                                }
                                return 0;
                            }
                        }, true);
                    }
                }
            }
        });
    }
}
