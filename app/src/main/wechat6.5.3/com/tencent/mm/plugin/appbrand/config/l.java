package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import com.tencent.mm.ba.a;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.protocal.c.avc;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.protocal.c.jf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public enum l {
    ;

    static boolean a(a aVar, a aVar2) {
        boolean z = false;
        if (aVar == null && aVar2 == null) {
            throw new IllegalArgumentException("both null!!!");
        }
        if (!(aVar == null || aVar2 == null)) {
            try {
                z = be.isEqual(aVar.toByteArray(), aVar2.toByteArray());
            } catch (Exception e) {
            }
        }
        return z;
    }

    static bjc nj(String str) {
        if (be.kS(str)) {
            return null;
        }
        v.i("MicroMsg.AppBrandSysConfigUtil", "parse pb:WxaAppInfo from json[%s]", new Object[]{str});
        bjc com_tencent_mm_protocal_c_bjc = new bjc();
        try {
            JSONObject jSONObject = new JSONObject(str);
            com_tencent_mm_protocal_c_bjc.mbH = jSONObject.optString("Appid");
            com_tencent_mm_protocal_c_bjc.ndt = jSONObject.optInt("AppState", -1);
            com_tencent_mm_protocal_c_bjc.gkV = jSONObject.optString("ExternInfo");
            JSONObject optJSONObject = jSONObject.optJSONObject("Slogan");
            com_tencent_mm_protocal_c_bjc.ndu = new avc();
            if (optJSONObject != null) {
                com_tencent_mm_protocal_c_bjc.ndu.mqb = optJSONObject.optString("BigImgUrl");
                com_tencent_mm_protocal_c_bjc.ndu.gIE = optJSONObject.optString("Wording");
            }
            optJSONObject = jSONObject.optJSONObject("Setting");
            com_tencent_mm_protocal_c_bjc.ndv = new cq();
            if (optJSONObject != null) {
                com_tencent_mm_protocal_c_bjc.ndv.mdb = optJSONObject.optInt("MaxLocalstorageSize", 5);
                com_tencent_mm_protocal_c_bjc.ndv.mdc = optJSONObject.optInt("MaxCodeSize", 5);
                com_tencent_mm_protocal_c_bjc.ndv.mdd = optJSONObject.optInt("MaxWebviewDepth", 5);
                com_tencent_mm_protocal_c_bjc.ndv.mde = optJSONObject.optInt("MaxBackgroundLifespan", 600);
                com_tencent_mm_protocal_c_bjc.ndv.mdf = optJSONObject.optInt("MaxRequestConcurrent", 5);
                com_tencent_mm_protocal_c_bjc.ndv.mdg = optJSONObject.optInt("MaxUploadConcurrent", 5);
                com_tencent_mm_protocal_c_bjc.ndv.mdh = optJSONObject.optInt("MaxDownloadConcurrent", 5);
            }
            optJSONObject = jSONObject.optJSONObject("Network");
            com_tencent_mm_protocal_c_bjc.ndw = new ajt();
            if (optJSONObject != null) {
                com_tencent_mm_protocal_c_bjc.ndw.mKw = f(optJSONObject.optJSONArray("RequestDomain"));
                com_tencent_mm_protocal_c_bjc.ndw.mKx = f(optJSONObject.optJSONArray("WsRequestDomain"));
                com_tencent_mm_protocal_c_bjc.ndw.mKy = f(optJSONObject.optJSONArray("UploadDomain"));
                com_tencent_mm_protocal_c_bjc.ndw.mKz = f(optJSONObject.optJSONArray("DownloadDomain"));
            }
            optJSONObject = jSONObject.optJSONObject("BaseInfo");
            com_tencent_mm_protocal_c_bjc.ndx = new cf();
            if (optJSONObject != null) {
                com_tencent_mm_protocal_c_bjc.ndx.hNZ = optJSONObject.optString("AppName");
                com_tencent_mm_protocal_c_bjc.ndx.gnp = optJSONObject.optString("IconUrl");
            }
            optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
            com_tencent_mm_protocal_c_bjc.ndy = new cp();
            if (optJSONObject != null) {
                com_tencent_mm_protocal_c_bjc.ndy.mcU = optJSONObject.optLong("RunningFlag");
                com_tencent_mm_protocal_c_bjc.ndy.mcV = optJSONObject.optInt("StopServiceTime");
                com_tencent_mm_protocal_c_bjc.ndy.mcW = optJSONObject.optInt("AppForbiddenReason");
                com_tencent_mm_protocal_c_bjc.ndy.mcX = optJSONObject.optInt("SessionOpenForbiddenReason");
                com_tencent_mm_protocal_c_bjc.ndy.mcY = optJSONObject.optInt("TimelineOpenForbiddenReason");
            }
            optJSONObject = jSONObject.optJSONObject("AppConfig");
            com_tencent_mm_protocal_c_bjc.ndz = new cj();
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
                com_tencent_mm_protocal_c_bjc.ndz.mcD = new LinkedList();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        bdu com_tencent_mm_protocal_c_bdu = new bdu();
                        com_tencent_mm_protocal_c_bdu.type = optJSONObject2.optInt(Columns.TYPE);
                        com_tencent_mm_protocal_c_bdu.version = optJSONObject2.optInt("version");
                        com_tencent_mm_protocal_c_bjc.ndz.mcD.add(com_tencent_mm_protocal_c_bdu);
                    }
                }
            }
            com_tencent_mm_protocal_c_bjc.ndA = e(jSONObject.optJSONArray("Category"));
            com_tencent_mm_protocal_c_bjc.pRC = jSONObject.optString("RoundedSquareIconUrl", null);
            com_tencent_mm_protocal_c_bjc.pRD = jSONObject.optString("OriginIconImageUrl", null);
            return com_tencent_mm_protocal_c_bjc;
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandSysConfigUtil", "parse pb:WxaAppInfo from json, exp = %s", new Object[]{be.e(e)});
            return null;
        }
    }

    private static LinkedList<jf> e(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray == null) {
            return new LinkedList();
        }
        v.i("MicroMsg.AppBrandSysConfigUtil", "optCategoryList %s", new Object[]{jSONArray});
        LinkedList<jf> linkedList = new LinkedList();
        while (i < jSONArray.length()) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            jf jfVar = new jf();
            jfVar.mlv = optJSONObject.optString("first");
            jfVar.mlw = optJSONObject.optString("second");
            jfVar.mlx = optJSONObject.optInt("first_id");
            jfVar.mly = optJSONObject.optInt("second_id");
            jfVar.mlz = optJSONObject.optInt("audit_status");
            jfVar.mlA = optJSONObject.optInt("audit_id");
            linkedList.add(jfVar);
            i++;
        }
        return linkedList;
    }

    private static LinkedList<String> f(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            linkedList.add(jSONArray.optString(i));
        }
        return linkedList;
    }

    static bjf nk(String str) {
        if (be.kS(str)) {
            return null;
        }
        v.i("MicroMsg.AppBrandSysConfigUtil", "parse pb:WxaAppInfoVersion from json[%s]", new Object[]{str});
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("AppVersion", -1);
            int optInt2 = jSONObject.optInt("VersionState", -1);
            String optString = jSONObject.optString("VersionMD5");
            v.i("MicroMsg.AppBrandSysConfigUtil", "parse pb:WxaAppInfoVersion, AppVersion = %d, VersionState = %d, VersionMD5 = %s, AppCDNDownloadUrl = %s, CDNUrlLifeSpan = %s", new Object[]{Integer.valueOf(optInt), Integer.valueOf(optInt2), optString, jSONObject.optString("AppCDNDownloadUrl"), Integer.valueOf(jSONObject.optInt("CDNUrlLifeSpan"))});
            if (optInt2 == 0 && (-1 == optInt || be.kS(optString))) {
                return null;
            }
            String str2;
            if (be.kS(optString)) {
                str2 = null;
            } else {
                str2 = r1;
            }
            bjf com_tencent_mm_protocal_c_bjf = new bjf();
            com_tencent_mm_protocal_c_bjf.mht = optInt;
            com_tencent_mm_protocal_c_bjf.ndI = optInt2;
            com_tencent_mm_protocal_c_bjf.ndJ = optString;
            com_tencent_mm_protocal_c_bjf.ndK = str2;
            com_tencent_mm_protocal_c_bjf.ndL = r7;
            com_tencent_mm_protocal_c_bjf.moH = e(jSONObject.optJSONArray("Categories"));
            return com_tencent_mm_protocal_c_bjf;
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandSysConfigUtil", "parse pb:WxaAppInfoVersion, exp = %s", new Object[]{be.e(e)});
            return null;
        }
    }

    static gm nl(String str) {
        if (be.kS(str)) {
            return null;
        }
        v.i("MicroMsg.AppBrandSysConfigUtil", "parse pb:BindWxaInfo from json[ %s ]", new Object[]{str});
        try {
            gm gmVar = new gm();
            JSONObject jSONObject = new JSONObject(str);
            gmVar.mhh = g(jSONObject.optJSONArray("wxaEntryInfo"));
            gmVar.mhi = g(jSONObject.optJSONArray("bizEntryInfo"));
            return gmVar;
        } catch (Throwable e) {
            v.a("MicroMsg.AppBrandSysConfigUtil", e, "parse pb:BindWxaInfo ", new Object[0]);
            return null;
        }
    }

    private static LinkedList<bjg> g(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        LinkedList<bjg> linkedList = new LinkedList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                bjg com_tencent_mm_protocal_c_bjg = new bjg();
                com_tencent_mm_protocal_c_bjg.username = optJSONObject.optString("username");
                com_tencent_mm_protocal_c_bjg.title = optJSONObject.optString("title");
                com_tencent_mm_protocal_c_bjg.cBw = optJSONObject.optString("title_key");
                com_tencent_mm_protocal_c_bjg.eBZ = optJSONObject.optString("icon_url");
                linkedList.add(com_tencent_mm_protocal_c_bjg);
                i++;
            } catch (Throwable e) {
                v.a("MicroMsg.AppBrandSysConfigUtil", e, "parse pb:repeated WxaEntryInfo ", new Object[0]);
                return linkedList;
            }
        }
        return linkedList;
    }

    static String a(cp cpVar) {
        if (cpVar == null) {
            return "AppRunningFlagInfo{null}";
        }
        return "AppRunningFlagInfo{RunningFlag=" + cpVar.mcU + ", StopServiceTime" + cpVar.mcV + ", AppForbiddenReason" + cpVar.mcW + ", SessionOpenForbiddenReason" + cpVar.mcX + ", TimelineOpenForbiddenReason" + cpVar.mcY + "}";
    }

    public static cp d(Parcel parcel) {
        if (parcel == null) {
            return null;
        }
        cp cpVar = new cp();
        cpVar.mcU = parcel.readLong();
        cpVar.mcV = parcel.readInt();
        cpVar.mcW = parcel.readInt();
        cpVar.mcX = parcel.readInt();
        cpVar.mcY = parcel.readInt();
        cpVar.mcZ = parcel.readInt();
        cpVar.mda = parcel.readInt();
        return cpVar;
    }

    public static void a(cp cpVar, Parcel parcel) {
        if (cpVar != null && parcel != null) {
            parcel.writeLong(cpVar.mcU);
            parcel.writeInt(cpVar.mcV);
            parcel.writeInt(cpVar.mcW);
            parcel.writeInt(cpVar.mcX);
            parcel.writeInt(cpVar.mcY);
            parcel.writeInt(cpVar.mcZ);
            parcel.writeInt(cpVar.mda);
        }
    }
}
