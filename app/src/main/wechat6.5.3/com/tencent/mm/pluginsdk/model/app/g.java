package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {
    public static f Gh(String str) {
        return aC(str, true);
    }

    public static f bA(String str, int i) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (a.lxJ == null) {
            v.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = a.lxJ.Gh(str);
            Object obj = (fVar == null || fVar.field_appVersion < i) ? 1 : null;
            if (obj != null) {
                a.lxJ.Gi(str);
            }
        }
        return fVar;
    }

    public static f aC(String str, boolean z) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
        } else if (a.lxJ == null) {
            v.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            fVar = a.lxJ.Gh(str);
            if (z) {
                Object obj = (fVar == null || fVar.field_appName == null || fVar.field_appName.length() == 0) ? 1 : null;
                if (obj != null) {
                    a.lxJ.Gi(str);
                }
            }
        }
        return fVar;
    }

    public static Bitmap b(String str, int i, float f) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
            return null;
        } else if (!ak.uz()) {
            return null;
        } else {
            ak.yW();
            Bitmap a;
            if (c.isSDCardAvailable()) {
                a = a.lxJ.a(str, i, f);
                if (a == null) {
                    v.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
                    a.lxJ.bv(str, i);
                    return null;
                } else if (a.isRecycled()) {
                    return null;
                } else {
                    return a;
                }
            } else if (aa.getContext() == null || aa.getContext().getResources() == null) {
                return null;
            } else {
                switch (i) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                        a = BitmapFactory.decodeResource(aa.getContext().getResources(), 2130839157);
                        if (a == null || a.isRecycled()) {
                            return null;
                        }
                        return a;
                    case 2:
                        return null;
                    default:
                        v.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = " + i);
                        return null;
                }
            }
        }
    }

    public static List<f> b(Context context, long j, boolean z) {
        List arrayList = new ArrayList();
        i bnB = am.bnB();
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IRUSR);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        stringBuilder.append(" ( appSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( svrAppSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( appInfoFlag & ").append(8192).append(" ) != 0");
        stringBuilder.append(" and status != 4");
        if (!z) {
            stringBuilder.append(" and  ( appInfoFlag & ").append(16384).append(" ) == 0");
        }
        v.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", stringBuilder.toString());
        Cursor rawQuery = bnB.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.b(rawQuery);
                if (fVar.field_status == 1) {
                    if (!o(context, fVar.field_appId)) {
                        fVar.field_status = 4;
                        a.lxJ.e(fVar);
                    } else if (!be.kS(fVar.field_signature)) {
                        arrayList.add(fVar);
                    }
                } else if (fVar.field_signature != null) {
                    arrayList.add(fVar);
                }
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public static boolean l(Context context, long j) {
        if (b(context, j, true).size() == 0) {
            return false;
        }
        return true;
    }

    public static boolean G(Context context, int i) {
        Long FZ = b.a.FZ(String.valueOf(i));
        if (FZ == null || b(context, FZ.longValue(), true).size() == 0) {
            return false;
        }
        return true;
    }

    public static List<f> dh(Context context) {
        List arrayList = new ArrayList();
        if (a.lxJ == null) {
            v.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            Cursor tq = a.lxJ.tq(5);
            if (tq != null) {
                while (tq.moveToNext()) {
                    f fVar = new f();
                    fVar.b(tq);
                    if (fVar.field_status == 1) {
                        if (!o(context, fVar.field_appId)) {
                            fVar.field_status = 4;
                            a.lxJ.e(fVar);
                        } else if (!be.kS(fVar.field_signature)) {
                            arrayList.add(fVar);
                        }
                    } else if (fVar.field_signature != null) {
                        arrayList.add(fVar);
                    }
                }
                tq.close();
            }
        }
        return arrayList;
    }

    public static List<f> a(Context context, boolean z, int i) {
        List<f> arrayList = new ArrayList();
        if (a.lxJ == null) {
            v.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
        } else {
            arrayList = cR(1, i);
            int[] iArr = null;
            if (z) {
                iArr = new int[]{5};
            }
            if (iArr != null) {
                Cursor o = a.lxJ.o(iArr);
                if (o != null) {
                    while (o.moveToNext()) {
                        f fVar = new f();
                        fVar.b(o);
                        if (fVar.field_status == 1) {
                            if (!o(context, fVar.field_appId)) {
                                fVar.field_status = 4;
                                a.lxJ.e(fVar);
                            } else if (!be.kS(fVar.field_signature)) {
                                arrayList.add(fVar);
                            }
                        } else if (fVar.field_signature != null) {
                            arrayList.add(fVar);
                        }
                    }
                    o.close();
                }
            }
        }
        return arrayList;
    }

    private static List<f> cR(int i, int i2) {
        List arrayList = new ArrayList();
        if (a.lxJ == null) {
            v.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
        } else {
            Cursor cQ = a.lxJ.cQ(1, i2);
            if (cQ != null) {
                while (cQ.moveToNext()) {
                    f fVar = new f();
                    fVar.b(cQ);
                    if (!be.kS(fVar.field_openId)) {
                        arrayList.add(fVar);
                    }
                }
                cQ.close();
            }
        }
        return arrayList;
    }

    public static boolean o(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            return a(context, aC(str, true));
        }
        v.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
        return false;
    }

    public static boolean a(Context context, f fVar) {
        if (fVar == null) {
            v.w("MicroMsg.AppInfoLogic", "app is null");
            return false;
        } else if (fVar.field_packageName != null && fVar.field_packageName.length() != 0) {
            return p.o(context, fVar.field_packageName);
        } else {
            v.w("MicroMsg.AppInfoLogic", "field_packageName is null");
            return false;
        }
    }

    public static boolean bo(String str) {
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            return false;
        }
        return true;
    }

    public static String n(Context context, String str) {
        return a(context, aC(str, true), null);
    }

    public static String a(Context context, f fVar, String str) {
        if (context == null || fVar == null) {
            return str;
        }
        String di = di(context);
        String str2 = null;
        if (di.equalsIgnoreCase("zh_CN")) {
            str2 = fVar.field_appName;
        }
        if (di.equalsIgnoreCase("en")) {
            str2 = be.kS(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (di.equalsIgnoreCase("zh_TW") || di.equalsIgnoreCase("zh_HK")) {
            if (di.equalsIgnoreCase("zh_HK")) {
                str2 = be.kS(fVar.field_appName_hk) ? fVar.field_appName_tw : fVar.field_appName_hk;
            }
            if (be.kS(str2)) {
                str2 = be.kS(fVar.field_appName_tw) ? fVar.field_appName : fVar.field_appName_tw;
            }
        }
        if (be.kS(str2)) {
            str2 = be.kS(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (be.kS(str2)) {
            return str;
        }
        return str2;
    }

    public static String di(Context context) {
        String d = u.d(context.getSharedPreferences(aa.bti(), 0));
        if (d == null || d.length() == 0 || d.equalsIgnoreCase("zh_CN")) {
            return "zh_CN";
        }
        return d;
    }

    public static boolean Gv(String str) {
        if (be.kS(str)) {
            return false;
        }
        f aC = aC(str, true);
        if (aC == null) {
            v.w("MicroMsg.AppInfoLogic", "app is null, appId = " + str);
            return false;
        } else if (aC.field_authFlag == 0) {
            return true;
        } else {
            if ((aC.field_authFlag & 2) > 0) {
                return true;
            }
            return false;
        }
    }

    public static boolean bp(String str) {
        if (be.kS(str)) {
            return false;
        }
        f aC = aC(str, false);
        if (aC != null) {
            return aC.bnk();
        }
        v.w("MicroMsg.AppInfoLogic", "app is null, appId = " + str);
        return false;
    }

    public static boolean h(f fVar) {
        if (fVar == null || be.kS(fVar.field_appId) || (fVar.field_appInfoFlag & 1) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean i(f fVar) {
        if (fVar == null || (fVar.field_appInfoFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    public static boolean Gw(String str) {
        if (be.kS(str)) {
            return false;
        }
        f aC = aC(str, true);
        if (aC == null || be.kS(aC.field_appId) || (aC.field_appInfoFlag & 8) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean j(f fVar) {
        if (fVar == null || be.kS(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", fVar.field_appId, Boolean.valueOf(z));
        return z;
    }

    public static boolean a(f fVar, int i) {
        if (fVar == null || be.kS(fVar.field_appId)) {
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & i) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", fVar.field_appId, Integer.valueOf(i), Boolean.valueOf(z));
        v.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + fVar.field_appInfoFlag);
        return z;
    }

    public static boolean k(f fVar) {
        if (fVar == null || be.kS(fVar.field_appId)) {
            return false;
        }
        Object obj;
        if ((fVar.field_appInfoFlag & FileUtils.S_IWUSR) > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (1 != obj) {
            return false;
        }
        String str = fVar.field_appId;
        Map hashMap = new HashMap();
        k.b(327682, hashMap);
        str = hashMap.containsKey(str) ? (String) hashMap.get(str) : null;
        if (str == null || str.equals("0")) {
            return true;
        }
        return false;
    }

    public static d.a a(Context context, String str, WXMediaMessage wXMediaMessage, String str2) {
        v.d("MicroMsg.AppInfoLogic", "request pkg = " + str + ", openId = " + str2);
        d.a aVar = new d.a();
        if (context == null) {
            return aVar;
        }
        aVar.nhM = wXMediaMessage;
        aVar.lBj = com.tencent.mm.a.g.m((be.Ni()).getBytes());
        aVar.bfm = str2;
        aVar.cUi = u.d(context.getSharedPreferences(aa.bti(), 0));
        ak.yW();
        aVar.cJg = (String) c.vf().get(274436, null);
        Bundle bundle = new Bundle();
        aVar.t(bundle);
        p.R(bundle);
        p.S(bundle);
        com.tencent.mm.sdk.a.a.a aVar2 = new com.tencent.mm.sdk.a.a.a();
        aVar2.nhj = str;
        aVar2.nhl = bundle;
        com.tencent.mm.sdk.a.a.a(context, aVar2);
        return aVar;
    }

    public static void bno() {
        SharedPreferences btk = aa.btk();
        if (btk != null) {
            btk.edit().putString("key_app_ids_registion_while_not_login", SQLiteDatabase.KeyEmpty).commit();
        }
    }
}
