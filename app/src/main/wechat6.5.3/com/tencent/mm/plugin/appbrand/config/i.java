package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.ci;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.util.Iterator;
import java.util.LinkedList;

public final class i {

    public static class a {
        private static String U(String str, int i) {
            return String.format("%s_%s_local_version", new Object[]{str, Integer.valueOf(i)});
        }

        public static String V(String str, int i) {
            return String.format("%s_%s_server_version", new Object[]{str, Integer.valueOf(i)});
        }

        private static String W(String str, int i) {
            return String.format("%s_%s_config", new Object[]{str, Integer.valueOf(i)});
        }

        public static void s(String str, int i, int i2) {
            com.tencent.mm.plugin.appbrand.a.a.dzO.aF(U(str, i), String.valueOf(i2));
        }

        public static void t(String str, int i, int i2) {
            com.tencent.mm.plugin.appbrand.a.a.dzO.aF(V(str, i), String.valueOf(i2));
        }

        public static void e(String str, int i, String str2) {
            com.tencent.mm.plugin.appbrand.a.a.dzO.aF(W(str, i), str2);
        }

        public static int X(String str, int i) {
            return be.getInt(com.tencent.mm.plugin.appbrand.a.a.dzO.get(U(str, i), "0"), 0);
        }

        public static String Y(String str, int i) {
            return com.tencent.mm.plugin.appbrand.a.a.dzO.get(W(str, i), "");
        }
    }

    public interface b {
        void a(int i, int i2, String str, com.tencent.mm.v.b bVar);
    }

    public interface c {
        void mM(String str);
    }

    public static void d(String str, LinkedList<bdu> linkedList) {
        a(str, linkedList, true);
    }

    public static void a(final String str, LinkedList<bdu> linkedList, boolean z) {
        if (be.kS(str)) {
            v.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
        } else if (linkedList == null || linkedList.size() == 0) {
            v.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bdu com_tencent_mm_protocal_c_bdu = (bdu) it.next();
                v.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdu.version), Integer.valueOf(com_tencent_mm_protocal_c_bdu.type)});
                int X = a.X(str, com_tencent_mm_protocal_c_bdu.type);
                int i = com_tencent_mm_protocal_c_bdu.version;
                a.t(str, com_tencent_mm_protocal_c_bdu.type, i);
                if (i != 0) {
                    if (i > X) {
                        linkedList2.add(r(str, com_tencent_mm_protocal_c_bdu.type, com_tencent_mm_protocal_c_bdu.version));
                    } else if (i != X) {
                        v.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[]{Integer.valueOf(X), Integer.valueOf(i)});
                        if (be.kS(a.Y(str, com_tencent_mm_protocal_c_bdu.type))) {
                            linkedList2.add(r(str, com_tencent_mm_protocal_c_bdu.type, com_tencent_mm_protocal_c_bdu.version));
                        }
                    } else if (be.kS(a.Y(str, com_tencent_mm_protocal_c_bdu.type))) {
                        linkedList2.add(r(str, com_tencent_mm_protocal_c_bdu.type, com_tencent_mm_protocal_c_bdu.version));
                    }
                }
            }
            v.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[]{str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size())});
            if (z && linkedList2.size() != 0) {
                v.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[]{str});
                a(linkedList2, new b() {
                    public final void a(int i, int i2, String str, com.tencent.mm.v.b bVar) {
                        if (i == 0 && i2 == 0) {
                            se seVar = (se) bVar.czl.czs;
                            if (seVar.mwf == null || seVar.mwf.size() == 0) {
                                v.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                                return;
                            }
                            v.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[]{Integer.valueOf(seVar.mwf.size())});
                            Iterator it = seVar.mwf.iterator();
                            while (it.hasNext()) {
                                ci ciVar = (ci) it.next();
                                v.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{ciVar.mcC, Integer.valueOf(ciVar.mcB)});
                                if (!be.kS(ciVar.mcC)) {
                                    a.s(str, ciVar.efm, ciVar.mcB);
                                    a.t(str, ciVar.efm, ciVar.mcB);
                                    a.e(str, ciVar.efm, ciVar.mcC);
                                }
                            }
                            return;
                        }
                        v.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    }
                });
            }
        }
    }

    private static sc r(String str, int i, int i2) {
        sc scVar = new sc();
        scVar.glj = str;
        scVar.efm = i;
        scVar.mcB = i2;
        return scVar;
    }

    public static String a(final String str, int i, int i2, final c cVar, boolean z) {
        int X = a.X(str, i);
        int i3 = be.getInt(com.tencent.mm.plugin.appbrand.a.a.dzO.get(a.V(str, i), "0"), 0);
        String Y = a.Y(str, i);
        boolean z2 = i3 != 0 && (be.kS(Y) || i3 > X);
        v.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(X)});
        v.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[]{Y, Boolean.valueOf(z2)});
        if (z2) {
            b anonymousClass2 = new b() {
                public final void a(int i, int i2, String str, com.tencent.mm.v.b bVar) {
                    if (i == 0 && i2 == 0) {
                        se seVar = (se) bVar.czl.czs;
                        if (seVar.mwf == null || seVar.mwf.size() == 0) {
                            v.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                            if (cVar != null) {
                                cVar.mM("");
                                return;
                            }
                            return;
                        }
                        ci ciVar = (ci) seVar.mwf.get(0);
                        v.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{ciVar.mcC, Integer.valueOf(ciVar.mcB)});
                        if (!be.kS(ciVar.mcC)) {
                            a.s(str, ciVar.efm, ciVar.mcB);
                            a.t(str, ciVar.efm, ciVar.mcB);
                            a.e(str, ciVar.efm, ciVar.mcC);
                            if (cVar != null) {
                                cVar.mM(ciVar.mcC);
                                return;
                            }
                            return;
                        } else if (cVar != null) {
                            cVar.mM("");
                            return;
                        } else {
                            return;
                        }
                    }
                    v.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (cVar != null) {
                        cVar.mM("");
                    }
                }
            };
            LinkedList linkedList = new LinkedList();
            sc scVar = new sc();
            scVar.glj = str;
            scVar.efm = i;
            scVar.mcB = i3;
            scVar.mwd = i2;
            linkedList.add(scVar);
            a(linkedList, anonymousClass2);
        } else {
            cVar.mM(Y);
        }
        return Y;
    }

    private static void a(LinkedList<sc> linkedList, final b bVar) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czm = 1138;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        aVar.czo = new se();
        aVar.czp = 0;
        aVar.czq = 0;
        sd sdVar = new sd();
        sdVar.mwe = linkedList;
        aVar.czn = sdVar;
        u.a(aVar.Bv(), new com.tencent.mm.v.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                if (bVar != null) {
                    bVar.a(i, i2, str, bVar);
                }
                return 0;
            }
        }, true);
    }
}
