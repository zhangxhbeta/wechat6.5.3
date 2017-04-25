package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class k implements com.tencent.mm.model.bo.b {
    private static final Map<String, c> dAX;

    interface c {
        void n(Map<String, String> map);
    }

    private static final class a implements c {
        private a() {
        }

        public final void n(Map<String, String> map) {
            if (map.get(".sysmsg.mmbizwxaconfig") != null) {
                int i = be.getInt((String) map.get(".sysmsg.mmbizwxaconfig.command"), -1);
                final int i2 = be.getInt((String) map.get(".sysmsg.mmbizwxaconfig.type"), 0);
                final String str = (String) map.get(".sysmsg.mmbizwxaconfig.appid");
                v.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(be.getInt((String) map.get(".sysmsg.mmbizwxaconfig.configversion"), 0))});
                LinkedList linkedList = new LinkedList();
                bdu com_tencent_mm_protocal_c_bdu = new bdu();
                com_tencent_mm_protocal_c_bdu.version = r1;
                com_tencent_mm_protocal_c_bdu.type = i2;
                linkedList.add(com_tencent_mm_protocal_c_bdu);
                i.a(str, linkedList, false);
                i.a(str, i2, i, new com.tencent.mm.plugin.appbrand.config.i.c(this) {
                    final /* synthetic */ a dBb;

                    public final void mM(String str) {
                        v.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[]{str});
                        com.tencent.mm.plugin.appbrand.ipc.d.f(str, i2, str);
                    }
                }, true);
            }
        }
    }

    private static final class b implements c {
        private b() {
        }

        public final void n(Map<String, String> map) {
            b(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
            int i = 0;
            do {
                i++;
            } while (b(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo" + i, map));
        }

        private boolean b(String str, Map<String, String> map) {
            v.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", new Object[]{str});
            if (map.get(str) == null) {
                return false;
            }
            final String str2 = (String) map.get(str + ".AppID");
            String str3 = (String) map.get(str + ".UserName");
            final int i = be.getInt((String) map.get(str + ".Type"), 1);
            String str4 = (String) map.get(str + ".URL");
            long j = be.getLong((String) map.get(str + ".StartTime"), be.Nh());
            v.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", new Object[]{str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(be.getLong((String) map.get(str + ".EndTime"), 7200 + j)), r7, Boolean.valueOf(com.tencent.mm.plugin.appbrand.a.a.dzP.a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10))});
            if (com.tencent.mm.plugin.appbrand.a.a.dzP.a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)) {
                String str5;
                Cursor query = com.tencent.mm.plugin.appbrand.a.a.OO().dBf.query("AppBrandWxaAppInfo", new String[]{"appName"}, String.format("%s=?", new Object[]{"appId"}), new String[]{str2}, null, null, null);
                if (query == null) {
                    str5 = null;
                } else {
                    str5 = null;
                    if (query.moveToFirst()) {
                        str5 = query.getString(0);
                    }
                    query.close();
                }
                if (!(i == 0 || 999 == i)) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ b dBd;

                        public final void run() {
                            AppBrandTaskManager.ab(str2, i);
                            Toast.makeText(aa.getContext(), aa.getContext().getString(2131230966, new Object[]{be.ah(str5, str2)}), 1).show();
                        }
                    });
                }
            }
            if (999 != i) {
                com.tencent.mm.plugin.appbrand.config.k.a(str3, null);
            }
            com.tencent.mm.plugin.appbrand.a.a.dzS.a(str3, i, false, BaseReportManager.MAX_READ_COUNT);
            return true;
        }
    }

    private static final class d implements c {
        private d() {
        }

        public final void n(Map<String, String> map) {
            if (map.get(".sysmsg.AppPublicLibraryNotify") != null) {
                int i = be.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
                String str = (String) map.get(".sysmsg.AppPublicLibraryNotify.MD5");
                String str2 = (String) map.get(".sysmsg.AppPublicLibraryNotify.URL");
                int i2 = be.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
                if (be.kS(str2) || be.kS(str) || i <= 0) {
                    v.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", new Object[]{str2, str, Integer.valueOf(i)});
                    return;
                }
                v.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
                biz com_tencent_mm_protocal_c_biz = new biz();
                com_tencent_mm_protocal_c_biz.version = i;
                com_tencent_mm_protocal_c_biz.aZy = str;
                com_tencent_mm_protocal_c_biz.url = str2;
                com_tencent_mm_protocal_c_biz.ndp = i2;
                com.tencent.mm.plugin.appbrand.a.a.dzP.a(com_tencent_mm_protocal_c_biz);
            }
        }
    }

    static /* synthetic */ void mL(String str) {
        if (com.tencent.mm.plugin.appbrand.a.a.dzP == null) {
            v.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            return;
        }
        Map q = bf.q(str, "sysmsg");
        if (q == null || q.size() <= 0) {
            v.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            return;
        }
        String str2 = (String) q.get(".sysmsg.$type");
        v.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", new Object[]{str2});
        if (!be.kS(str2)) {
            c cVar = (c) dAX.get(str2);
            if (cVar != null) {
                cVar.n(q);
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new b());
        hashMap.put("AppPublicLibraryNotify", new d());
        hashMap.put("mmbizwxaconfig", new a());
        dAX = Collections.unmodifiableMap(hashMap);
    }

    public final void a(com.tencent.mm.v.d.a aVar) {
        final String a = m.a(aVar.czu.mbW);
        if (be.kS(a)) {
            v.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
        } else {
            com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable(this) {
                final /* synthetic */ k dAZ;

                public final void run() {
                    k.mL(a);
                }
            });
        }
    }
}
