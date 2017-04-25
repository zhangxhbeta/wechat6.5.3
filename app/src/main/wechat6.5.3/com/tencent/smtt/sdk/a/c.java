package com.tencent.smtt.sdk.a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class c {

    public static class a {
        public int lzQ = -1;
        public String lzR = SQLiteDatabase.KeyEmpty;
        public String packageName = null;
        public String pyC = "0";
        public int ver = -1;
    }

    private static class b {
        public String classname;
        public String lzS;

        private b() {
            this.classname = SQLiteDatabase.KeyEmpty;
            this.lzS = SQLiteDatabase.KeyEmpty;
        }
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        if (context == null) {
            return 3;
        }
        boolean z;
        if (str == null || str.length() == 0) {
            z = false;
        } else {
            String trim = str.trim();
            int indexOf = trim.toLowerCase().indexOf("://");
            int indexOf2 = trim.toLowerCase().indexOf(46);
            z = (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) ? trim.toLowerCase().contains("://") : false;
        }
        if (!z) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            a fQ = fQ(context);
            if (fQ.lzQ == -1) {
                return 4;
            }
            if (fQ.lzQ == 2 && fQ.ver < 33) {
                return 5;
            }
            Intent intent;
            Intent intent2 = new Intent("android.intent.action.VIEW");
            b e;
            if (fQ.lzQ == 2) {
                if (fQ.ver >= 33 && fQ.ver <= 39) {
                    intent2.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
                    intent = intent2;
                } else if (fQ.ver < 40 || fQ.ver > 45) {
                    if (fQ.ver >= 46) {
                        intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                        e = e(context, parse);
                        if (!(e == null || TextUtils.isEmpty(e.classname))) {
                            intent2.setClassName(e.lzS, e.classname);
                        }
                        intent = intent2;
                    }
                    intent = intent2;
                } else {
                    intent2.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                    intent = intent2;
                }
            } else if (fQ.lzQ == 1) {
                if (fQ.ver == 1) {
                    intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    intent = intent2;
                } else {
                    if (fQ.ver == 2) {
                        intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                        intent = intent2;
                    }
                    intent = intent2;
                }
            } else if (fQ.lzQ != 0) {
                intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                e = e(context, parse);
                if (!(e == null || TextUtils.isEmpty(e.classname))) {
                    intent2.setClassName(e.lzS, e.classname);
                }
                intent = intent2;
            } else if (fQ.ver < 4 || fQ.ver > 6) {
                if (fQ.ver > 6) {
                    intent2 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    e = e(context, parse);
                    if (!(e == null || TextUtils.isEmpty(e.classname))) {
                        intent2.setClassName(e.lzS, e.classname);
                    }
                    intent = intent2;
                }
                intent = intent2;
            } else {
                intent2.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                intent = intent2;
            }
            intent.setData(parse);
            if (hashMap != null) {
                Set<String> keySet = hashMap.keySet();
                if (keySet != null) {
                    for (String str2 : keySet) {
                        trim = (String) hashMap.get(str2);
                        if (!TextUtils.isEmpty(trim)) {
                            intent.putExtra(str2, trim);
                        }
                    }
                }
            }
            try {
                intent.putExtra("loginType", fP(context));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (webView != null) {
                    intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                    intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                }
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException e2) {
                return 4;
            }
        } catch (Exception e3) {
            return 2;
        }
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, String str2, WebView webView) {
        Object obj;
        String encode;
        Object obj2 = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Object obj3;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                if (packageInfo != null && packageInfo.versionCode > 601000) {
                    obj3 = 1;
                    obj = obj3;
                    encode = URLEncoder.encode(str, "UTF-8");
                    if (obj != null) {
                        str = encode;
                    }
                    obj2 = obj;
                    stringBuilder.append("mttbrowser://url=").append(str).append(",product=TBS,packagename=").append(context.getPackageName()).append(",from=").append(str2).append(",version=2.6.0.1061").append(obj2 == null ? ",encoded=1" : SQLiteDatabase.KeyEmpty);
                    return a(context, stringBuilder.toString(), hashMap, webView);
                }
            }
            obj3 = null;
            obj = obj3;
        } catch (Throwable th) {
            obj = null;
        }
        try {
            encode = URLEncoder.encode(str, "UTF-8");
            if (obj != null) {
                str = encode;
            }
            obj2 = obj;
        } catch (Exception e) {
        }
        if (obj2 == null) {
        }
        stringBuilder.append("mttbrowser://url=").append(str).append(",product=TBS,packagename=").append(context.getPackageName()).append(",from=").append(str2).append(",version=2.6.0.1061").append(obj2 == null ? ",encoded=1" : SQLiteDatabase.KeyEmpty);
        return a(context, stringBuilder.toString(), hashMap, webView);
    }

    public static boolean a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            Set<String> keySet = hashMap.keySet();
            if (keySet != null) {
                for (String str3 : keySet) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        intent.putExtra(str3, str4);
                    }
                }
            }
            File file = new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            intent.setDataAndType(Uri.fromFile(file), "mtt/" + str2);
            intent.putExtra("loginType", fP(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap) {
        Object obj;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(parse, "video/*");
        Set<String> keySet = hashMap.keySet();
        if (keySet != null) {
            for (String str2 : keySet) {
                String str3 = (String) hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra("loginType", fP(context));
            intent.setComponent(new ComponentName("com.tencent.mtt", "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            obj = 1;
        } catch (Throwable th) {
            obj = null;
        }
        if (obj == null) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th2) {
                return false;
            }
        }
        return true;
    }

    private static b e(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains("com.tencent.mtt")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.lzS = resolveInfo.activityInfo.packageName;
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.lzS = resolveInfo.activityInfo.packageName;
            }
        }
        return bVar;
    }

    private static int fP(Context context) {
        String str = context.getApplicationInfo().processName;
        return str.equals("com.tencent.mobileqq") ? 13 : str.equals("com.qzone") ? 14 : str.equals("com.tencent.WBlog") ? 15 : str.equals("com.tencent.mm") ? 24 : 26;
    }

    private static a fQ(Context context) {
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        a aVar = new a();
        if (z) {
            return aVar;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                aVar.lzQ = 2;
                aVar.packageName = "com.tencent.mtt";
                aVar.lzR = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.ver = packageInfo.versionCode;
                    aVar.lzR += packageInfo.versionName.replaceAll("\\.", SQLiteDatabase.KeyEmpty);
                    aVar.pyC = packageInfo.versionName.replaceAll("\\.", SQLiteDatabase.KeyEmpty);
                    return aVar;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                aVar.lzQ = 0;
                aVar.packageName = "com.tencent.qbx";
                aVar.lzR = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.lzQ = 1;
                    aVar.packageName = "com.tencent.qbx5";
                    aVar.lzR = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                        aVar.packageName = "com.tencent.mtt";
                        aVar.lzQ = 2;
                        aVar.lzR = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.packageName = "com.tencent.mtt.x86";
                            aVar.lzQ = 2;
                            aVar.lzR = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                b e6 = e(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                                if (!(e6 == null || TextUtils.isEmpty(e6.lzS))) {
                                    packageInfo = packageManager.getPackageInfo(e6.lzS, 0);
                                    aVar.packageName = e6.lzS;
                                    aVar.lzQ = 2;
                                    aVar.lzR = "ADRQB_";
                                }
                            } catch (Exception e7) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                aVar.ver = packageInfo.versionCode;
                aVar.lzR += packageInfo.versionName.replaceAll("\\.", SQLiteDatabase.KeyEmpty);
                aVar.pyC = packageInfo.versionName.replaceAll("\\.", SQLiteDatabase.KeyEmpty);
            }
        } catch (Exception e8) {
        }
        return aVar;
    }
}
