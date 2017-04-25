package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.u;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k {

    public interface a {

        public enum a {
            LOCAL,
            SERVER
        }

        void a(a aVar, AppBrandSysConfig appBrandSysConfig);
    }

    public static boolean ni(String str) {
        int i;
        long j;
        int i2 = j.sU().getInt("MMBizAttrSyncFreq", -1);
        if (i2 == -1) {
            v.i("MicroMsg.AppBrandSysConfigUpdater", "MMBizAttrSyncFreq is null.");
            i = 3600;
        } else {
            i = i2;
        }
        long Nh = be.Nh();
        Cursor query = com.tencent.mm.plugin.appbrand.a.a.OO().dBf.query("AppBrandWxaAppInfo", new String[]{"lastSyncAttrTimeInSecond"}, String.format("%s=?", new Object[]{"brandId"}), new String[]{str}, null, null, null);
        if (query == null) {
            j = 0;
        } else if (query.getCount() <= 0) {
            query.close();
            j = 0;
        } else {
            query.moveToFirst();
            j = query.getLong(0);
            query.close();
        }
        v.i("MicroMsg.AppBrandSysConfigUpdater", "needUpdateAttr, brandId(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[]{str, Long.valueOf(Nh), Long.valueOf(j), Integer.valueOf(i)});
        return Nh - j >= ((long) i);
    }

    static void a(String str, WeakReference<a> weakReference, boolean z) {
        if (weakReference == null || weakReference.get() == null) {
            v.d("MicroMsg.AppBrandSysConfigUpdater", "readDBAndCallback, callback null, no need to read db");
            return;
        }
        AppBrandSysConfig nh = com.tencent.mm.plugin.appbrand.a.a.OO().nh(str);
        if (weakReference.get() != null) {
            ((a) weakReference.get()).a(z ? a.SERVER : a.LOCAL, nh);
        }
    }

    public static void S(List<String> list) {
        int i = 0;
        if (!be.bP(list)) {
            int i2 = 0;
            while (i < list.size() / 10) {
                int i3 = i * 10;
                i2 = i3 + 10;
                cO(list.subList(i3, i2));
                i++;
            }
            if (i2 < list.size()) {
                cO(list.subList(i2, list.size()));
            }
        }
    }

    private static void cO(List<String> list) {
        if (!be.bP(list)) {
            ep epVar = new ep();
            for (String str : list) {
                gs gsVar = new gs();
                gsVar.mhz = str;
                gsVar.mhA = Rm(str);
                epVar.mfE.add(gsVar);
            }
            com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
            aVar.czm = 1166;
            aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/batchbizattrsync";
            aVar.czo = new eq();
            aVar.czn = epVar;
            u.a(aVar.Bv(), new com.tencent.mm.v.u.a() {
                public final int a(int i, int i2, String str, b bVar, com.tencent.mm.v.k kVar) {
                    if (i == 0 && i2 == 0) {
                        eq eqVar = (eq) bVar.czl.czs;
                        if (eqVar != null) {
                            Iterator it = eqVar.mfF.iterator();
                            while (it.hasNext()) {
                                gt gtVar = (gt) it.next();
                                k.a(gtVar.mhz, gtVar.mhA, gtVar.mhB);
                            }
                        }
                    } else {
                        v.e("MicroMsg.AppBrandSysConfigUpdater", "BatchBizAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    }
                    return 0;
                }
            }, true);
        }
    }

    static boolean a(String str, com.tencent.mm.ba.b bVar, LinkedList<gr> linkedList) {
        String bn = be.bn(bVar.lVU);
        if (be.ma(bn).equals(com.tencent.mm.plugin.appbrand.a.a.OO().ne(str))) {
            v.i("MicroMsg.AppBrandSysConfigUpdater", "UpdateLocalBizAttr, username = %s, sync version not updated", new Object[]{str});
        } else {
            v.i("MicroMsg.AppBrandSysConfigUpdater", "UpdateLocalBizAttr, username = %s, UpdateInfoList size = %d, version = %s", new Object[]{str, Integer.valueOf(linkedList.size()), bn});
            if (!be.bP(linkedList)) {
                String nd;
                boolean a;
                h hVar;
                String str2;
                String str3;
                String str4;
                com.tencent.mm.u.h gQ;
                com.tencent.mm.i.a LX;
                Object obj;
                l lVar;
                bjf com_tencent_mm_protocal_c_bjf;
                boolean z;
                j OO;
                ContentValues contentValues;
                c cVar = new c();
                cVar.dCO = str;
                for (gr grVar : linkedList) {
                    if ("WxaAppInfo".equals(grVar.mhC)) {
                        cVar.dCU = l.nj(grVar.itR);
                    }
                    if ("WxaAppVersionInfo".equals(grVar.mhC)) {
                        cVar.dCV = l.nk(grVar.itR);
                    }
                    if ("NickName".equals(grVar.mhC)) {
                        cVar.dCP = grVar.itR;
                        v.i("MicroMsg.AppBrandBizInfo", "parsed NickName = %s", new Object[]{cVar.dCP});
                    }
                    if ("BrandIconURL".equals(grVar.mhC)) {
                        cVar.dCQ = grVar.itR;
                        v.i("MicroMsg.AppBrandBizInfo", "parsed BrandIconURL = %s", new Object[]{cVar.dCQ});
                    }
                    if ("BigHeadImgUrl".equals(grVar.mhC)) {
                        cVar.dCR = grVar.itR;
                        v.i("MicroMsg.AppBrandBizInfo", "parsed BigHeadImgUrl = %s", new Object[]{cVar.dCR});
                    }
                    if ("BrandFlag".equals(grVar.mhC)) {
                        cVar.dCS = Integer.valueOf(be.getInt(grVar.itR, 0));
                        v.i("MicroMsg.AppBrandBizInfo", "parsed BrandFlag = %d", new Object[]{cVar.dCS});
                    }
                    if ("AppOpt".equals(grVar.mhC)) {
                        cVar.dCT = Integer.valueOf(be.getInt(grVar.itR, 0));
                        v.i("MicroMsg.AppBrandBizInfo", "parsed AppOpt = %d", new Object[]{cVar.dCT});
                    }
                    if ("BindWxaInfo".equals(grVar.mhC)) {
                        cVar.dCW = l.nl(grVar.itR);
                    }
                    if ("Signature".equals(grVar.mhC)) {
                        cVar.dCN = grVar.itR;
                        v.i("MicroMsg.AppBrandBizInfo", "parsed Signature = %s", new Object[]{cVar.dCN});
                    }
                }
                j OO2 = com.tencent.mm.plugin.appbrand.a.a.OO();
                if (be.kS(cVar.dCO)) {
                    v.e("MicroMsg.AppBrandSysConfigStorage", "flushBizInfo, invalid bizInfo");
                } else {
                    if (cVar.dCU == null) {
                        v.i("MicroMsg.AppBrandSysConfigStorage", "flushBizInfo, null WxaAppInfo in BizInfo");
                        nd = OO2.nd(cVar.dCO);
                    } else {
                        nd = cVar.dCU.mbH;
                    }
                    if (be.kS(nd)) {
                        v.e("MicroMsg.AppBrandSysConfigStorage", "flushBizInfo, null appId");
                    } else {
                        h hVar2 = new h();
                        hVar2.field_appIdHashCode = nd.hashCode();
                        if (OO2.dDN.b(hVar2, new String[0])) {
                            Object obj2 = null;
                            if (!(be.ma(hVar2.field_appIcon).equals(cVar.dCQ) || be.kS(cVar.dCQ))) {
                                hVar2.field_appIcon = cVar.dCQ;
                                obj2 = 1;
                            }
                            if (!(be.ma(hVar2.field_appName).equals(cVar.dCP) || be.kS(cVar.dCP))) {
                                hVar2.field_appName = cVar.dCP;
                                obj2 = 1;
                            }
                            if (!(cVar.dCU == null || l.a(hVar2.field_appInfo, cVar.dCU))) {
                                hVar2.field_appInfo = cVar.dCU;
                                hVar2.field_roundedSquareIcon = cVar.dCU.pRC;
                                obj2 = 1;
                            }
                            if (!(cVar.dCV == null || l.a(hVar2.field_versionInfo, cVar.dCV))) {
                                hVar2.field_versionInfo = cVar.dCV;
                                obj2 = 1;
                            }
                            if (!(cVar.dCS == null || cVar.dCS.equals(Integer.valueOf(hVar2.field_brandFlag)))) {
                                hVar2.field_brandFlag = cVar.dCS.intValue();
                                obj2 = 1;
                            }
                            if (!(cVar.dCT == null || cVar.dCT.equals(Integer.valueOf(hVar2.field_AppOpt)))) {
                                hVar2.field_AppOpt = cVar.dCT.intValue();
                                obj2 = 1;
                            }
                            if (!(be.kS(cVar.dCR) || cVar.dCR.equals(hVar2.field_BigHeadImgUrl))) {
                                hVar2.field_BigHeadImgUrl = cVar.dCR;
                                obj2 = 1;
                            }
                            if (!(cVar.dCW == null || l.a(hVar2.field_bindInfo, cVar.dCW))) {
                                hVar2.field_bindInfo = cVar.dCW;
                                obj2 = 1;
                            }
                            if (!(be.ma(hVar2.field_signature).equals(cVar.dCN) || be.kS(cVar.dCN))) {
                                hVar2.field_signature = cVar.dCN;
                                obj2 = 1;
                            }
                            if (obj2 != null) {
                                a = OO2.dDN.a(hVar2);
                            }
                        } else {
                            hVar2.field_appId = cVar.dCU.mbH;
                            hVar2.field_brandId = cVar.dCO;
                            hVar2.field_appIcon = cVar.dCQ;
                            hVar2.field_appName = cVar.dCP;
                            hVar2.field_appInfo = cVar.dCU;
                            hVar2.field_versionInfo = cVar.dCV;
                            hVar2.field_brandFlag = be.f(cVar.dCS);
                            hVar2.field_AppOpt = be.f(cVar.dCT);
                            hVar2.field_BigHeadImgUrl = cVar.dCR;
                            hVar2.field_bindInfo = cVar.dCW;
                            hVar2.field_signature = cVar.dCN;
                            hVar2.field_roundedSquareIcon = cVar.dCU.pRC;
                            a = OO2.dDN.b(hVar2);
                        }
                        if (a) {
                            OO2.a("single", 3, cVar.dCO);
                            OO2.PC();
                        }
                        nd = cVar.dCO;
                        if (!ak.yN() && ak.uz()) {
                            hVar = new h();
                            hVar.field_brandId = nd;
                            if (OO2.dDN.b(hVar, new String[]{"brandId"}) && !be.kS(hVar.field_brandId)) {
                                str2 = hVar.field_brandId;
                                str3 = hVar.field_appName;
                                str4 = hVar.field_BigHeadImgUrl;
                                if (!be.kS(str4)) {
                                    gQ = n.Bo().gQ(str2);
                                    if (gQ == null) {
                                        gQ = new com.tencent.mm.u.h();
                                    }
                                    if (!(str4.equals(gQ.Bf()) && str4.equals(gQ.Be()))) {
                                        gQ.username = str2;
                                        gQ.cyC = str4;
                                        gQ.cyD = str4;
                                        gQ.aP(true);
                                        gQ.bkU = 31;
                                        n.Bo().a(gQ);
                                    }
                                    nd = com.tencent.mm.u.b.r(str2, false);
                                    if (!(be.kS(nd) || FileOp.aR(nd))) {
                                        com.tencent.mm.u.b.a(str2, false, -1);
                                    }
                                    nd = com.tencent.mm.u.b.r(str2, true);
                                    if (!(be.kS(nd) || FileOp.aR(nd))) {
                                        com.tencent.mm.u.b.a(str2, false, -1);
                                    }
                                }
                                ak.yW();
                                LX = c.wH().LX(str2);
                                obj = null;
                                if (LX == null) {
                                    LX = new com.tencent.mm.storage.u();
                                }
                                if (((int) LX.chr) == 0) {
                                    LX.setUsername(str2);
                                    obj = 1;
                                }
                                if (!str3.equals(LX.field_nickname)) {
                                    LX.bS(str3);
                                    LX.bT(com.tencent.mm.platformtools.c.lU(str3));
                                    LX.bU(com.tencent.mm.platformtools.c.lT(str3));
                                    obj = 1;
                                }
                                if (obj != null) {
                                    ak.yW();
                                    c.wH().L(LX);
                                }
                            }
                        }
                        v.i("MicroMsg.AppBrandSysConfigUpdater", "UpdateLocalBizAttr, flushBizInfo ret = %b, username = %s", new Object[]{Boolean.valueOf(a), str});
                        str4 = com.tencent.mm.plugin.appbrand.a.a.OO().nd(str);
                        if (be.kS(str4)) {
                            if (cVar.dCU == null) {
                                return false;
                            }
                            if (be.kS(cVar.dCU.mbH)) {
                                return false;
                            }
                            str4 = cVar.dCU.mbH;
                        }
                        if (cVar.dCV != null) {
                            lVar = com.tencent.mm.plugin.appbrand.a.a.dzP;
                            com_tencent_mm_protocal_c_bjf = cVar.dCV;
                            if (!be.kS(str4) || com_tencent_mm_protocal_c_bjf == null) {
                                v.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[]{str4, com_tencent_mm_protocal_c_bjf});
                                z = false;
                            } else {
                                z = lVar.a(str4, com_tencent_mm_protocal_c_bjf.mht, com_tencent_mm_protocal_c_bjf.ndI, com_tencent_mm_protocal_c_bjf.ndJ, com_tencent_mm_protocal_c_bjf.ndK, false);
                            }
                            v.i("MicroMsg.AppBrandSysConfigUpdater", "UpdateLocalBizAttr, flushWxaAppVersionInfo, ret = %s, brandId = %s appId = %s", new Object[]{Boolean.valueOf(z), str, str4});
                        }
                        OO = com.tencent.mm.plugin.appbrand.a.a.OO();
                        if (!be.kS(str)) {
                            contentValues = new ContentValues(2);
                            contentValues.put("syncAttrVersion", bn);
                            contentValues.put("lastSyncAttrTimeInSecond", Long.valueOf(bn != null ? 0 : be.Nh()));
                            OO.dBf.update("AppBrandWxaAppInfo", contentValues, String.format("%s=?", new Object[]{"brandId"}), new String[]{str});
                        }
                        if (cVar.dCU != null || cVar.dCU.ndz == null) {
                            v.e("MicroMsg.AppBrandSysConfigUpdater", "_WxaAppInfo or AnalyticInfo is null");
                        } else {
                            LinkedList linkedList2 = cVar.dCU.ndz.mcD;
                            if (linkedList2 == null || linkedList2.size() == 0) {
                                v.e("MicroMsg.AppBrandSysConfigUpdater", "updateAppReportConfig, versionItems is empty");
                            } else {
                                i.d(str4, linkedList2);
                            }
                        }
                        return true;
                    }
                }
                a = false;
                if (a) {
                    OO2.a("single", 3, cVar.dCO);
                    OO2.PC();
                }
                nd = cVar.dCO;
                hVar = new h();
                hVar.field_brandId = nd;
                str2 = hVar.field_brandId;
                str3 = hVar.field_appName;
                str4 = hVar.field_BigHeadImgUrl;
                if (be.kS(str4)) {
                    gQ = n.Bo().gQ(str2);
                    if (gQ == null) {
                        gQ = new com.tencent.mm.u.h();
                    }
                    gQ.username = str2;
                    gQ.cyC = str4;
                    gQ.cyD = str4;
                    gQ.aP(true);
                    gQ.bkU = 31;
                    n.Bo().a(gQ);
                    nd = com.tencent.mm.u.b.r(str2, false);
                    com.tencent.mm.u.b.a(str2, false, -1);
                    nd = com.tencent.mm.u.b.r(str2, true);
                    com.tencent.mm.u.b.a(str2, false, -1);
                }
                ak.yW();
                LX = c.wH().LX(str2);
                obj = null;
                if (LX == null) {
                    LX = new com.tencent.mm.storage.u();
                }
                if (((int) LX.chr) == 0) {
                    LX.setUsername(str2);
                    obj = 1;
                }
                if (str3.equals(LX.field_nickname)) {
                    LX.bS(str3);
                    LX.bT(com.tencent.mm.platformtools.c.lU(str3));
                    LX.bU(com.tencent.mm.platformtools.c.lT(str3));
                    obj = 1;
                }
                if (obj != null) {
                    ak.yW();
                    c.wH().L(LX);
                }
                v.i("MicroMsg.AppBrandSysConfigUpdater", "UpdateLocalBizAttr, flushBizInfo ret = %b, username = %s", new Object[]{Boolean.valueOf(a), str});
                str4 = com.tencent.mm.plugin.appbrand.a.a.OO().nd(str);
                if (be.kS(str4)) {
                    if (cVar.dCU == null) {
                        return false;
                    }
                    if (be.kS(cVar.dCU.mbH)) {
                        return false;
                    }
                    str4 = cVar.dCU.mbH;
                }
                if (cVar.dCV != null) {
                    lVar = com.tencent.mm.plugin.appbrand.a.a.dzP;
                    com_tencent_mm_protocal_c_bjf = cVar.dCV;
                    if (be.kS(str4)) {
                    }
                    v.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[]{str4, com_tencent_mm_protocal_c_bjf});
                    z = false;
                    v.i("MicroMsg.AppBrandSysConfigUpdater", "UpdateLocalBizAttr, flushWxaAppVersionInfo, ret = %s, brandId = %s appId = %s", new Object[]{Boolean.valueOf(z), str, str4});
                }
                OO = com.tencent.mm.plugin.appbrand.a.a.OO();
                if (be.kS(str)) {
                    contentValues = new ContentValues(2);
                    contentValues.put("syncAttrVersion", bn);
                    if (bn != null) {
                    }
                    contentValues.put("lastSyncAttrTimeInSecond", Long.valueOf(bn != null ? 0 : be.Nh()));
                    OO.dBf.update("AppBrandWxaAppInfo", contentValues, String.format("%s=?", new Object[]{"brandId"}), new String[]{str});
                }
                if (cVar.dCU != null) {
                }
                v.e("MicroMsg.AppBrandSysConfigUpdater", "_WxaAppInfo or AnalyticInfo is null");
                return true;
            }
        }
        return false;
    }

    public static boolean a(final String str, a aVar) {
        if (be.kS(str)) {
            return false;
        }
        final WeakReference weakReference = new WeakReference(aVar);
        if (ni(str)) {
            u.a(Oe(str), new com.tencent.mm.v.u.a() {
                public final int a(int i, int i2, String str, b bVar, com.tencent.mm.v.k kVar) {
                    if (i == 0 && i2 == 0) {
                        boolean a;
                        gq gqVar = (gq) bVar.czl.czs;
                        if (gqVar != null) {
                            a = k.a(str, gqVar.mhA, gqVar.mhB);
                        } else {
                            v.e("MicroMsg.AppBrandSysConfigUpdater", "BizAttrSync, null response");
                            a = false;
                        }
                        k.a(str, weakReference, a);
                    } else {
                        v.e("MicroMsg.AppBrandSysConfigUpdater", "BizAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    }
                    return 0;
                }
            }, true);
        } else {
            v.i("MicroMsg.AppBrandSysConfigUpdater", "updateAndGetAppConfig, no need to sync biz attr, read db and callback now");
            a(str, weakReference, false);
        }
        return true;
    }

    public static void J(final String str, final boolean z) {
        if (!be.kS(str)) {
            e.a(new Runnable() {
                public final void run() {
                    if (z) {
                        com.tencent.mm.plugin.appbrand.a.a.OO().wT(str);
                    }
                    k.I(str, true);
                }
            }, "AppBrandForceSyncWxaAttrs");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.vending.j.c<com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig, com.tencent.mm.v.a.a<com.tencent.mm.protocal.c.gq>> I(java.lang.String r9, boolean r10) {
        /*
        r3 = -1;
        r1 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r0 == 0) goto L_0x000d;
    L_0x0008:
        r0 = com.tencent.mm.vending.j.a.t(r1, r1);
    L_0x000c:
        return r0;
    L_0x000d:
        if (r10 != 0) goto L_0x0099;
    L_0x000f:
        r0 = com.tencent.mm.plugin.appbrand.a.a.OO();
        r0 = r0.nh(r9);
        if (r0 == 0) goto L_0x001f;
    L_0x0019:
        r2 = ni(r9);
        if (r2 == 0) goto L_0x0093;
    L_0x001f:
        r2 = Oe(r9);
        r4 = com.tencent.mm.plugin.appbrand.netscene.g.b(r2);
        if (r4 == 0) goto L_0x0035;
    L_0x0029:
        r2 = r4 instanceof com.tencent.mm.plugin.appbrand.netscene.g.a;
        if (r2 != 0) goto L_0x0035;
    L_0x002d:
        r2 = r4.errType;
        if (r2 != 0) goto L_0x0035;
    L_0x0031:
        r2 = r4.errCode;
        if (r2 == 0) goto L_0x007b;
    L_0x0035:
        r5 = "MicroMsg.AppBrandSysConfigUpdater";
        r6 = "synchronousGet, errType = %d, errCode = %d, errMsg = %s";
        r2 = 3;
        r7 = new java.lang.Object[r2];
        r8 = 0;
        if (r4 != 0) goto L_0x006d;
    L_0x0041:
        r2 = r3;
    L_0x0042:
        r2 = java.lang.Integer.valueOf(r2);
        r7[r8] = r2;
        r2 = 1;
        if (r4 != 0) goto L_0x0070;
    L_0x004b:
        r3 = java.lang.Integer.valueOf(r3);
        r7[r2] = r3;
        r3 = 2;
        if (r4 != 0) goto L_0x0073;
    L_0x0054:
        r2 = "null resp";
    L_0x0057:
        r7[r3] = r2;
        com.tencent.mm.sdk.platformtools.v.e(r5, r6, r7);
        if (r0 != 0) goto L_0x0068;
    L_0x005e:
        r0 = com.tencent.mm.plugin.appbrand.a.a.OO();
        r0 = r0.nh(r9);
        if (r0 == 0) goto L_0x0076;
    L_0x0068:
        r0 = com.tencent.mm.vending.j.a.t(r0, r1);
        goto L_0x000c;
    L_0x006d:
        r2 = r4.errType;
        goto L_0x0042;
    L_0x0070:
        r3 = r4.errCode;
        goto L_0x004b;
    L_0x0073:
        r2 = r4.biS;
        goto L_0x0057;
    L_0x0076:
        r0 = com.tencent.mm.vending.j.a.t(r1, r4);
        goto L_0x000c;
    L_0x007b:
        r0 = r4.bra;
        r0 = (com.tencent.mm.protocal.c.gq) r0;
        r1 = r0.mhA;
        r0 = r4.bra;
        r0 = (com.tencent.mm.protocal.c.gq) r0;
        r0 = r0.mhB;
        a(r9, r1, r0);
        r0 = com.tencent.mm.plugin.appbrand.a.a.OO();
        r0 = r0.nh(r9);
        r1 = r4;
    L_0x0093:
        r0 = com.tencent.mm.vending.j.a.t(r0, r1);
        goto L_0x000c;
    L_0x0099:
        r0 = r1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.k.I(java.lang.String, boolean):com.tencent.mm.vending.j.c<com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig, com.tencent.mm.v.a$a<com.tencent.mm.protocal.c.gq>>");
    }

    private static b Oe(String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czm = 1075;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.czo = new gq();
        aVar.czp = 0;
        aVar.czq = 0;
        gp gpVar = new gp();
        gpVar.mhz = str;
        gpVar.mhA = Rm(str);
        aVar.czn = gpVar;
        return aVar.Bv();
    }

    private static com.tencent.mm.ba.b Rm(String str) {
        if (be.kS(str)) {
            return new com.tencent.mm.ba.b(new byte[0]);
        }
        return new com.tencent.mm.ba.b(be.KG(com.tencent.mm.plugin.appbrand.a.a.OO().ne(str)));
    }
}
