package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum a {
    ;
    
    private static final Set<a> dLN = null;

    public interface a {
        void QO();
    }

    static {
        dLN = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(a aVar) {
        if (aVar != null) {
            dLN.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            dLN.remove(aVar);
        }
    }

    public static void refresh() {
        if (QK()) {
            c.FY().a(new com.tencent.mm.modelgeo.a.a() {
                private int dLP;

                {
                    this.dLP = 0;
                }

                public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
                    c.FY().c(this);
                    int i2 = this.dLP + 1;
                    this.dLP = i2;
                    if (i2 <= 1 && z) {
                        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
                        aVar.czm = 1056;
                        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
                        aaz com_tencent_mm_protocal_c_aaz = new aaz();
                        com_tencent_mm_protocal_c_aaz.mCq = (double) f;
                        com_tencent_mm_protocal_c_aaz.mCr = (double) f2;
                        aVar.czn = com_tencent_mm_protocal_c_aaz;
                        aVar.czo = new aba();
                        u.a(aVar.Bv(), new com.tencent.mm.v.u.a(this) {
                            final /* synthetic */ AnonymousClass1 dLQ;

                            {
                                this.dLQ = r1;
                            }

                            public final int a(int i, int i2, String str, b bVar, k kVar) {
                                if (bVar == null || bVar.czl.czs == null || !(bVar.czl.czs instanceof aba)) {
                                    v.e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                                } else {
                                    String str2 = ((aba) bVar.czl.czs).mCt;
                                    String bB = a.QM();
                                    long j = (long) ((aba) bVar.czl.czs).mCu;
                                    String str3 = ((aba) bVar.czl.czs).mCs;
                                    v.i("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return newURL[ %s ], oldURL[ %s ], newLifeSpan %d", new Object[]{str2, bB, Long.valueOf(j)});
                                    if (!(be.kS(str2) || str2.equals(bB))) {
                                        a.b(str2, j, str3);
                                    }
                                }
                                return 0;
                            }
                        }, true);
                    }
                    return false;
                }
            }, true);
        } else {
            v.i("MicroMsg.AppBrandNearbyLogic", "refresh() ABTest switch off, skip");
        }
    }

    private static boolean QK() {
        if (!ak.uz()) {
            return false;
        }
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100189");
        if (Ls.isValid()) {
            return be.getInt((String) Ls.buX().get("EnableNearWeApp"), 0) > 0;
        } else {
            return false;
        }
    }

    public static String QL() {
        long j = 0;
        if (!QK()) {
            return null;
        }
        if (ak.uz()) {
            ak.yW();
            j = ((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.ntb, Long.valueOf(0))).longValue();
        }
        if (j <= be.Nh()) {
            return null;
        }
        return QM();
    }

    private static String QM() {
        if (!ak.uz()) {
            return null;
        }
        ak.yW();
        return (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nta, "");
    }

    public static String QN() {
        if (!ak.uz()) {
            return "";
        }
        ak.yW();
        return (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.ntc, "");
    }
}
