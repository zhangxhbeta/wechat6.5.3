package com.tencent.mm.plugin.game.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.plugin.game.c.ae.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class af {
    private static String gjT = null;
    private static String gjU = "";

    public static void a(Context context, int i, int i2, String str, int i3, String str2) {
        g.iuh.h(13384, new Object[]{Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1), Integer.valueOf(0), str, Integer.valueOf(i3), Integer.valueOf(0), null, Integer.valueOf(be.getInt(null, 0)), Integer.valueOf(bX(context)), str2});
    }

    public static void m(Context context, String str, String str2) {
        v.d("MicroMsg.GameReportUtil", "reportRegToWx, appId = " + str + ", pkgName = " + str2);
        if (be.kS(str)) {
            v.e("MicroMsg.GameReportUtil", "reportRegToWx fail, appId is null");
            return;
        }
        g.iuh.h(10534, new Object[]{str, Integer.valueOf(U(context, str2)), arV(), Long.valueOf(System.currentTimeMillis() / 1000)});
    }

    public static void a(String str, String str2, int i, int i2, String str3, long j) {
        v.d("MicroMsg.GameReportUtil", "reportReadMsg, appId = " + str);
        if (be.kS(str)) {
            v.e("MicroMsg.GameReportUtil", "reportReadMsg fail, appId is null");
            return;
        }
        v.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = " + new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(j)).toString());
        g.iuh.h(10532, new Object[]{str, r0, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)});
    }

    public static void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
        v.d("MicroMsg.GameReportUtil", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", new Object[]{str, str2, Long.valueOf(j), str5});
        if (be.kS(str)) {
            v.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appId is null");
            return;
        }
        if (context == null) {
            context = aa.getContext();
        }
        if (com.tencent.mm.pluginsdk.model.app.g.aC(str, false) == null) {
            v.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appinfo is null");
            return;
        }
        au.ase().a(a.g(10531, str, Integer.valueOf(U(context, str2)), arV(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bX(context)), be.ma(r0.field_packageName), be.ma(r0.field_signature), Long.toString(j), "", str5));
    }

    public static void e(String str, int i, int i2, int i3) {
        v.d("MicroMsg.GameReportUtil", "reportGameDetail, appId = " + str + ", scene = " + i2);
        if (be.kS(str)) {
            v.e("MicroMsg.GameReportUtil", "reportGameDetail fail, appId is null");
            return;
        }
        g.iuh.h(10700, new Object[]{str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static void a(String str, String str2, int i, int i2, String str3, int i3) {
        v.d("MicroMsg.GameReportUtil", "rejectGameMsg, fromUserName = " + str + ", appId = " + str2 + ", msgType = " + i + ", scene = " + i2 + ", actionName = " + str3);
        if (be.kS(str2)) {
            v.e("MicroMsg.GameReportUtil", "rejectGameMsg fail, appId is null");
            return;
        }
        g.iuh.h(10546, new Object[]{str, str2, Integer.valueOf(i), arV(), Integer.valueOf(i2), str3, Integer.valueOf(i3)});
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        v.d("MicroMsg.GameReportUtil", "reportMsgClick, appId = " + str + ", pkgName = " + str2);
        if (be.kS(str)) {
            v.e("MicroMsg.GameReportUtil", "reportDelGameMsg fail, appId is null");
            return;
        }
        if (context == null) {
            context = aa.getContext();
        }
        au.ase().a(a.g(10583, str, Integer.valueOf(U(context, str2)), arV(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(bX(context))));
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str) {
        a(context, i, i2, i3, i4, 0, null, i5, 0, null, null, str);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, null, str2);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2, String str3) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, str2, str3);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, String str2, String str3, String str4) {
        au.ase().a(a.g(12909, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), Integer.valueOf(i7), str2, Integer.valueOf(be.getInt(str3, 0)), Integer.valueOf(bX(context)), str4));
    }

    public static String ug(String str) {
        if (be.kS(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            String str2 = "";
            v.e("MicroMsg.GameReportUtil", exception.getMessage());
            return str2;
        }
    }

    private static String uh(String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (Throwable e) {
            v.a("MicroMsg.GameReportUtil", e, "", new Object[0]);
        }
        return str;
    }

    public static String s(Map<String, String> map) {
        if (map.size() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
                v.e("MicroMsg.GameReportUtil", e.getMessage());
                return "";
            }
        }
        try {
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e2) {
            v.e("MicroMsg.GameReportUtil", e2.getMessage());
            return "";
        }
    }

    public static String bH(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("function_type", str);
            jSONObject.put("function_value", str2);
        } catch (Throwable e) {
            v.a("MicroMsg.GameReportUtil", e, "", new Object[0]);
        }
        return ug(jSONObject.toString());
    }

    public static String E(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, str3);
        } catch (Exception e) {
            v.e("MicroMsg.GameReportUtil", e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            return bI(str, jSONObject.toString());
        }
        return str;
    }

    private static String bI(String str, String str2) {
        if (be.kS(str)) {
            return str2;
        }
        String uh = uh(str);
        String uh2 = uh(str2);
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(uh);
        } catch (Exception e) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject(uh2);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str3 = (String) keys.next();
                        jSONObject2.put(str3, jSONObject.opt(str3));
                    } catch (Exception e2) {
                        return "";
                    }
                }
            }
            return ug(jSONObject2.toString());
        } catch (JSONException e3) {
            return "";
        }
    }

    public static void a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        long currentTimeMillis = System.currentTimeMillis();
        au.ase().a(a.g(10737, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), str2, "", str3, Integer.valueOf(bX(aa.getContext())), Integer.valueOf(0), Integer.valueOf(1), str4, str5));
    }

    public static void F(String str, String str2, String str3) {
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.GameReportUtil", "null open or null username");
            return;
        }
        g.iuh.h(10738, new Object[]{str, str2, str, str3});
    }

    private static int U(Context context, String str) {
        PackageInfo av = p.av(context, str);
        return av == null ? 0 : av.versionCode;
    }

    private static String arV() {
        if (gjT == null) {
            String rK = com.tencent.mm.compatible.d.p.rK();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < rK.length() - 1; i++) {
                stringBuilder.append(Integer.toHexString(rK.charAt(i)));
            }
            stringBuilder.append("00");
            gjT = stringBuilder.toString();
        }
        return gjT;
    }

    private static int bX(Context context) {
        if (ak.is3G(context)) {
            return 4;
        }
        if (ak.is4G(context)) {
            return 5;
        }
        switch (ak.getNetType(context)) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                return 6;
        }
    }

    public static void ui(String str) {
        gjU = str;
    }
}
