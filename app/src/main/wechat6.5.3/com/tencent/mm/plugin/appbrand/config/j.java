package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public final class j extends g {
    public static final String[] dDM = new String[]{a.dDR};
    public final com.tencent.mm.bg.g dBf;
    public final a dDN;
    private final com.tencent.mm.av.a<b> dDO = new com.tencent.mm.av.a();
    private final com.tencent.mm.av.a.a<b> dDP = new com.tencent.mm.av.a.a<b>(this) {
        final /* synthetic */ j dDQ;

        {
            this.dDQ = r1;
        }

        public final /* synthetic */ void an(Object obj) {
            b bVar = (b) obj;
            if (bVar != null) {
                bVar.PD();
            }
        }
    };

    private static final class a extends f<h> {
        private static final String dDR = f.a(h.cxi, "AppBrandWxaAppInfo");

        public a(d dVar) {
            super(dVar, h.cxi, "AppBrandWxaAppInfo", h.btd);
        }

        public final boolean a(h hVar) {
            if (be.kS(hVar.field_appId)) {
                return false;
            }
            hVar.field_appIdHashCode = hVar.field_appId.hashCode();
            return super.a(hVar, new String[0]);
        }

        public final boolean b(h hVar) {
            if (be.kS(hVar.field_appId)) {
                return false;
            }
            hVar.field_appIdHashCode = hVar.field_appId.hashCode();
            super.b(hVar);
            return b(hVar, new String[0]);
        }
    }

    public interface b {
        void PD();
    }

    public j(com.tencent.mm.bg.g gVar) {
        this.dDN = new a(gVar);
        this.dBf = gVar;
    }

    public final boolean PB() {
        return (this.dBf == null || this.dBf.buA()) ? false : true;
    }

    public final String nd(String str) {
        Cursor query = this.dBf.query("AppBrandWxaAppInfo", new String[]{"appId"}, String.format("%s=?", new Object[]{"brandId"}), new String[]{str}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            query.close();
            return null;
        }
        query.moveToFirst();
        String string = query.getString(0);
        query.close();
        return string;
    }

    public final h c(String str, String[] strArr) {
        if (be.kS(str)) {
            return null;
        }
        Cursor query = this.dBf.query("AppBrandWxaAppInfo", strArr, String.format("%s=?", new Object[]{"brandId"}), new String[]{str}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            query.close();
            return null;
        }
        query.moveToFirst();
        h hVar = new h();
        hVar.b(query);
        query.close();
        return hVar;
    }

    final String ne(String str) {
        Cursor query = this.dBf.query("AppBrandWxaAppInfo", new String[]{"syncAttrVersion"}, String.format("%s=?", new Object[]{"brandId"}), new String[]{str}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            query.close();
            return null;
        }
        query.moveToFirst();
        String string = query.getString(0);
        query.close();
        return string;
    }

    public final long nf(String str) {
        byte[] bArr = null;
        if (be.kS(str)) {
            return 0;
        }
        Cursor query = this.dBf.query("AppBrandWxaAppInfo", new String[]{"appInfo"}, String.format(Locale.US, "%s=?", new Object[]{"brandId"}), new String[]{str}, null, null, null);
        if (query == null) {
            return 0;
        }
        if (query.moveToFirst()) {
            bArr = query.getBlob(0);
        }
        query.close();
        if (!be.bl(bArr)) {
            try {
                bjc com_tencent_mm_protocal_c_bjc = new bjc();
                com_tencent_mm_protocal_c_bjc.az(bArr);
                if (com_tencent_mm_protocal_c_bjc.ndy == null) {
                    return 0;
                }
                return com_tencent_mm_protocal_c_bjc.ndy.mcU;
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrandSysConfigStorage", e, "getRunningFlagByBrandId", new Object[0]);
            }
        }
        return 0;
    }

    public final c ng(String str) {
        if (be.kS(str)) {
            return null;
        }
        h hVar = new h();
        hVar.field_brandId = str;
        if (!this.dDN.b(hVar, new String[]{"brandId"})) {
            return null;
        }
        c cVar = new c();
        cVar.dCN = hVar.field_signature;
        cVar.dCO = str;
        cVar.dCP = hVar.field_appName;
        cVar.dCQ = hVar.field_appIcon;
        cVar.dCR = be.kS(hVar.field_BigHeadImgUrl) ? hVar.field_appIcon : hVar.field_BigHeadImgUrl;
        cVar.dCU = hVar.field_appInfo;
        cVar.dCV = hVar.field_versionInfo;
        cVar.dCW = hVar.field_bindInfo;
        return cVar;
    }

    public final AppBrandSysConfig nh(String str) {
        LinkedList linkedList = null;
        if (be.kS(str) || !str.endsWith("@app")) {
            return null;
        }
        h hVar = new h();
        hVar.field_brandId = str;
        if (!this.dDN.b(hVar, new String[]{"brandId"})) {
            return null;
        }
        AppBrandSysConfig appBrandSysConfig = new AppBrandSysConfig();
        bjc com_tencent_mm_protocal_c_bjc = hVar.field_appInfo;
        appBrandSysConfig.aWH = str;
        appBrandSysConfig.aZU = hVar.field_appName;
        appBrandSysConfig.dDo = hVar.field_appIcon;
        appBrandSysConfig.appId = hVar.field_appId;
        appBrandSysConfig.dDp = hVar.field_debugEnabled;
        appBrandSysConfig.dDr = com_tencent_mm_protocal_c_bjc.ndv.mdd;
        appBrandSysConfig.dDs = com_tencent_mm_protocal_c_bjc.ndv.mde;
        appBrandSysConfig.dDv = com_tencent_mm_protocal_c_bjc.ndv.mdh;
        appBrandSysConfig.dDu = com_tencent_mm_protocal_c_bjc.ndv.mdg;
        appBrandSysConfig.dDt = com_tencent_mm_protocal_c_bjc.ndv.mdf;
        appBrandSysConfig.dDx = new ArrayList(com_tencent_mm_protocal_c_bjc.ndw.mKw);
        appBrandSysConfig.dDy = new ArrayList(com_tencent_mm_protocal_c_bjc.ndw.mKx);
        appBrandSysConfig.dDA = new ArrayList(com_tencent_mm_protocal_c_bjc.ndw.mKz);
        appBrandSysConfig.dDz = new ArrayList(com_tencent_mm_protocal_c_bjc.ndw.mKy);
        appBrandSysConfig.dDE = com_tencent_mm_protocal_c_bjc.ndy;
        appBrandSysConfig.dDw = (long) com_tencent_mm_protocal_c_bjc.ndv.mdi;
        if (hVar.field_bindInfo != null) {
            linkedList = hVar.field_bindInfo.mhi;
        }
        appBrandSysConfig.dDF = linkedList;
        i a = com.tencent.mm.plugin.appbrand.a.a.dzP.a(appBrandSysConfig.appId, 0, new String[]{"version", "downloadURL", "versionState"});
        if (a != null) {
            appBrandSysConfig.dDB.dBs = a.field_version;
            appBrandSysConfig.dDB.dBw = a.field_downloadURL;
            appBrandSysConfig.dDG = a.field_versionState;
        } else {
            appBrandSysConfig.dDG = 1;
        }
        return appBrandSysConfig;
    }

    public final boolean wT(String str) {
        if (be.kS(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("syncAttrVersion", "");
        contentValues.put("lastSyncAttrTimeInSecond", Long.valueOf(0));
        if (this.dBf.update("AppBrandWxaAppInfo", contentValues, String.format(Locale.US, "%s=?", new Object[]{"brandId"}), new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final void PC() {
        this.dDO.a(this.dDP);
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.dDO.ay(bVar);
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.dDO.remove(bVar);
        }
    }
}
