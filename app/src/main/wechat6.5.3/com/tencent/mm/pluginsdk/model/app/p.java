package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.j.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedHashMap;
import java.util.Map;

public final class p {
    public static String e(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            v.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
            return null;
        }
        String d = u.d(context.getSharedPreferences(aa.bti(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(2131234137, new Object[]{str, Integer.valueOf(d.lWh), d, d.cmW, str2});
    }

    public static String t(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            v.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
            return null;
        }
        String d = u.d(context.getSharedPreferences(aa.bti(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(2131234138, new Object[]{str, Integer.valueOf(d.lWh), d, d.cmW, str2, Integer.valueOf(0)});
    }

    public static String s(String str, String str2) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
            return null;
        }
        String str3;
        int indexOf = str.indexOf("#");
        String str4 = SQLiteDatabase.KeyEmpty;
        if (indexOf >= 0) {
            str4 = str.substring(indexOf);
            str = str.substring(0, indexOf);
            str3 = str4;
        } else {
            str3 = str4;
        }
        int indexOf2 = str.indexOf("?");
        str4 = SQLiteDatabase.KeyEmpty;
        if (indexOf2 >= 0) {
            str4 = str.substring(indexOf2 + 1);
            str = str.substring(0, indexOf2);
        }
        v.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", str3, str4, str);
        Map linkedHashMap = new LinkedHashMap();
        if (!be.kS(str4)) {
            String[] split = str4.split("&");
            if (split != null && split.length > 0) {
                for (String str5 : split) {
                    String str52;
                    if (!be.kS(str52)) {
                        Object substring;
                        Object substring2;
                        int indexOf3 = str52.indexOf("=");
                        v.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", Integer.valueOf(indexOf3));
                        if (indexOf3 >= 0) {
                            substring = str52.substring(0, indexOf3 + 1);
                            substring2 = str52.substring(indexOf3 + 1);
                        } else {
                            String str6 = str52;
                            str52 = SQLiteDatabase.KeyEmpty;
                            str4 = str6;
                        }
                        linkedHashMap.put(substring, substring2);
                    }
                }
            }
        }
        str4 = "from=";
        if (str2 == null) {
            str2 = SQLiteDatabase.KeyEmpty;
        }
        linkedHashMap.put(str4, str2);
        v.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", Integer.valueOf(linkedHashMap.size()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str42 : linkedHashMap.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str42);
            stringBuilder.append((String) linkedHashMap.get(str42));
        }
        str42 = str + "?" + stringBuilder.toString();
        if (!be.kS(str3)) {
            str42 = str42 + str3;
        }
        v.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", str42);
        return str42;
    }

    public static boolean o(Context context, String str) {
        return av(context, str) != null;
    }

    public static PackageInfo av(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppUtil", "getPackageInfo, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                v.w("MicroMsg.AppUtil", "app not installed, packageName = " + str);
            }
        }
        return packageInfo;
    }

    public static String aM(Context context, String str) {
        Signature[] aN = aN(context, str);
        if (aN != null && aN.length != 0) {
            return GF(g.m(aN[0].toByteArray()));
        }
        v.e("MicroMsg.AppUtil", "signs is null");
        return null;
    }

    public static String GE(String str) {
        if (str != null && str.length() != 0) {
            return GF(str);
        }
        v.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        return null;
    }

    public static boolean b(Context context, f fVar, String str) {
        t tVar = a.lxJ;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
            tVar.f(fVar);
            return false;
        } else if (fVar == null) {
            v.i("MicroMsg.AppUtil", "app does not exist");
            return true;
        } else if (fVar.field_packageName == null || fVar.field_packageName.length() == 0) {
            v.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
            tVar.f(fVar);
            return false;
        } else if (fVar.field_signature == null || fVar.field_signature.length() == 0) {
            v.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
            tVar.f(fVar);
            return false;
        } else {
            Signature[] aN = aN(context, str);
            if (aN == null || aN.length == 0) {
                v.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
                tVar.f(fVar);
                return false;
            } else if (fVar.field_packageName.equals(str)) {
                v.i("MicroMsg.AppUtil", "server signatures:%s", fVar.field_signature);
                int length = aN.length;
                int i = 0;
                while (i < length) {
                    v.i("MicroMsg.AppUtil", "local signatures:%s", GF(g.m(aN[i].toByteArray())));
                    if (fVar.field_signature == null || !fVar.field_signature.equals(r6)) {
                        i++;
                    } else {
                        tVar.g(fVar);
                        return true;
                    }
                }
                v.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
                tVar.f(fVar);
                return false;
            } else {
                v.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", fVar.field_packageName, str);
                tVar.f(fVar);
                return false;
            }
        }
    }

    public static void R(Bundle bundle) {
        bundle.putString("wx_token_key", "com.tencent.mm.openapi.token");
    }

    public static void S(Bundle bundle) {
        bundle.putString("platformId", "wechat");
    }

    public static void b(Bundle bundle, String str) {
        bundle.putString("platformId", "wechat");
        if (!be.kS(str)) {
            bundle.putString("launchParam", str);
        }
    }

    public static Signature[] aN(Context context, String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppUtil", "getSignature, packageName is null");
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            v.e("MicroMsg.AppUtil", "info is null, packageName = " + str);
            return null;
        } catch (NameNotFoundException e) {
            v.e("MicroMsg.AppUtil", "NameNotFoundException");
            return null;
        }
    }

    public static String GF(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.toLowerCase());
        stringBuffer.append("mMHc ItnStR");
        return g.m(stringBuffer.toString().getBytes());
    }

    public static boolean c(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.AppUtil", "install app failed: " + uri.toString() + ", ex = " + e.getMessage());
            return false;
        }
    }

    public static boolean aO(Context context, String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (av(context, "com.android.vending") != null) {
            v.v("MicroMsg.AppUtil", "installAppWithGP, gp is installed, url = %s", str);
            intent.setPackage("com.android.vending");
        } else {
            v.v("MicroMsg.AppUtil", "installAppWithGP, gp is not installed, url = %s", str);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.AppUtil", "installAppWithGP first, ex = %s", e.getMessage());
            try {
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                v.e("MicroMsg.AppUtil", "installAppWithGP second, ex = %s", e2.getMessage());
                return false;
            }
        }
    }

    public static boolean b(Context context, f fVar) {
        v.i("MicroMsg.AppUtil", "check the signature of the Application.");
        if (context == null) {
            v.e("MicroMsg.AppUtil", "context is null.");
            return true;
        } else if (fVar == null) {
            v.e("MicroMsg.AppUtil", "appInfo is null.");
            return true;
        } else if (be.kS(fVar.field_packageName)) {
            v.e("MicroMsg.AppUtil", "packageName is null.");
            return true;
        } else if (be.kS(fVar.field_signature)) {
            v.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", fVar.field_packageName);
            return true;
        } else {
            Signature[] aN = aN(context, fVar.field_packageName);
            if (aN == null || aN.length == 0) {
                v.e("MicroMsg.AppUtil", "apk signatures is null");
                return false;
            }
            for (Signature toByteArray : aN) {
                if (fVar.field_signature.equals(GF(g.m(toByteArray.toByteArray())))) {
                    v.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", fVar.field_appName, fVar.field_signature);
                    return true;
                }
            }
            v.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", fVar.field_appName);
            return false;
        }
    }

    public static void GG(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.AppUtil", "appid is null");
            return;
        }
        SharedPreferences btk = aa.btk();
        if (btk != null) {
            String string = btk.getString("key_app_ids_registion_while_not_login", SQLiteDatabase.KeyEmpty);
            if (string.contains(str)) {
                v.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", str, string);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(string);
            btk.edit().putString("key_app_ids_registion_while_not_login", stringBuilder.toString()).commit();
        }
    }

    public static void bnu() {
        ao.lBK = null;
        ao.lBL = -1;
    }

    public static String GH(String str) {
        String str2 = null;
        if (!be.kS(str)) {
            try {
                v.i("MicroMsg.AppUtil", "get package name from archive filepath  :%s, package name is : %s", str, aa.getContext().getPackageManager().getPackageArchiveInfo(str, 0).packageName);
                str2 = r1.packageName;
            } catch (Exception e) {
                v.e("MicroMsg.AppUtil", "get package name from archive file path, failed : %s", e.getMessage());
            }
        }
        return str2;
    }

    public static int GI(String str) {
        int i = 0;
        if (!be.kS(str)) {
            try {
                v.i("MicroMsg.AppUtil", "get package version code from archive filepath  :%s, package version code is : %d", str, Integer.valueOf(aa.getContext().getPackageManager().getPackageArchiveInfo(str, 0).versionCode));
                i = r1.versionCode;
            } catch (Exception e) {
                v.e("MicroMsg.AppUtil", "get package version code from archive file path, failed : %s", e.getMessage());
            }
        }
        return i;
    }
}
