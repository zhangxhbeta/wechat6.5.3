package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.y;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class s {
    private static ap dpa = null;
    private static final Pattern lVi = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    private static final Map<String, String> lVj;
    private static final Map<String, String> lVk;

    public static final class a {
        private static final Pattern lVp = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
        public final String charset;
        public final String mimeType;

        private a(String str, String str2) {
            this.mimeType = str;
            this.charset = str2;
        }

        public final String toString() {
            return "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
        }

        public static a Ik(String str) {
            String str2 = null;
            if (be.kS(str)) {
                return null;
            }
            Matcher matcher = lVp.matcher(str);
            if (!matcher.find()) {
                return null;
            }
            String group = matcher.group(0);
            if (str.contains("charset=")) {
                str2 = str.substring(str.indexOf("charset=") + 8).trim();
            }
            if (be.kS(str2)) {
                str2 = "UTF-8";
            }
            return new a(group, str2);
        }
    }

    public interface b {
        void Fr(String str);
    }

    private static class c implements com.tencent.mm.sdk.platformtools.ap.a {
        private static Pattern lVq = Pattern.compile("image/[A-Za-z0-9]+");
        private static Pattern lVr = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
        private String cUK;
        private Context context;
        private String imagePath;
        private String lVs;
        private String lVt;
        private boolean lVu;
        private b lVv;
        private int opType;

        public c(Context context, String str, String str2, boolean z) {
            this(context, str, str2, z, 0, null);
        }

        public c(Context context, String str, String str2, boolean z, int i, b bVar) {
            this.context = context;
            this.cUK = str;
            this.lVt = str2;
            this.lVu = z;
            this.opType = i;
            this.lVv = bVar;
        }

        public final boolean Ba() {
            if (1 == this.opType) {
                this.lVv.Fr(this.imagePath);
            } else if (be.kS(this.lVs)) {
                Toast.makeText(this.context, this.context.getString(2131236685), 1).show();
            } else {
                Toast.makeText(this.context, this.lVs, 1).show();
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void brf() {
            /*
            r8 = this;
            r2 = 0;
            r0 = new java.net.URL;	 Catch:{ Exception -> 0x0083, all -> 0x009c }
            r1 = r8.cUK;	 Catch:{ Exception -> 0x0083, all -> 0x009c }
            r0.<init>(r1);	 Catch:{ Exception -> 0x0083, all -> 0x009c }
            r0 = r0.openConnection();	 Catch:{ Exception -> 0x0083, all -> 0x009c }
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0083, all -> 0x009c }
            r1 = "GET";
            r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r1 = "Cookie";
            r3 = r8.lVt;	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r1 = 1;
            r0.setAllowUserInteraction(r1);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r1 == r3) goto L_0x006d;
        L_0x0028:
            r3 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
            if (r1 == r3) goto L_0x0030;
        L_0x002c:
            r3 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
            if (r1 != r3) goto L_0x005e;
        L_0x0030:
            r1 = "Location";
            r1 = r0.getHeaderField(r1);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            if (r1 != 0) goto L_0x0040;
        L_0x0039:
            r1 = "location";
            r1 = r0.getHeaderField(r1);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
        L_0x0040:
            r3 = "MicroMsg.WebViewUtil";
            r4 = "redirect url = %s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r6 = 0;
            r5[r6] = r1;	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r3 = com.tencent.mm.sdk.platformtools.be.kS(r1);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            if (r3 != 0) goto L_0x005e;
        L_0x0055:
            r8.cUK = r1;	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r8.brf();	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            a(r0, r2);
        L_0x005d:
            return;
        L_0x005e:
            r1 = r8.context;	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r3 = 2131236685; // 0x7f08174d float:1.80896E38 double:1.052970829E-314;
            r1 = r1.getString(r3);	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r8.lVs = r1;	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            a(r0, r2);
            goto L_0x005d;
        L_0x006d:
            r1 = r0.getContentType();	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r2 = r0.getInputStream();	 Catch:{ Exception -> 0x00ac, all -> 0x00a2 }
            r3 = "Content-Disposition";
            r3 = r0.getHeaderField(r3);	 Catch:{ Exception -> 0x00b2, all -> 0x00a2 }
            r8.a(r1, r3, r2);	 Catch:{ Exception -> 0x00b2, all -> 0x00a2 }
            a(r0, r2);
            goto L_0x005d;
        L_0x0083:
            r0 = move-exception;
            r1 = r2;
        L_0x0085:
            r3 = "MicroMsg.WebViewUtil";
            r4 = "init http url connection failed : %s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00a7 }
            r6 = 0;
            r0 = r0.getMessage();	 Catch:{ all -> 0x00a7 }
            r5[r6] = r0;	 Catch:{ all -> 0x00a7 }
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x00a7 }
            a(r2, r1);
            goto L_0x005d;
        L_0x009c:
            r0 = move-exception;
            r1 = r2;
        L_0x009e:
            a(r1, r2);
            throw r0;
        L_0x00a2:
            r1 = move-exception;
            r7 = r1;
            r1 = r0;
            r0 = r7;
            goto L_0x009e;
        L_0x00a7:
            r0 = move-exception;
            r7 = r1;
            r1 = r2;
            r2 = r7;
            goto L_0x009e;
        L_0x00ac:
            r1 = move-exception;
            r7 = r1;
            r1 = r2;
            r2 = r0;
            r0 = r7;
            goto L_0x0085;
        L_0x00b2:
            r1 = move-exception;
            r7 = r1;
            r1 = r2;
            r2 = r0;
            r0 = r7;
            goto L_0x0085;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.s.c.brf():void");
        }

        private static void a(HttpURLConnection httpURLConnection, InputStream inputStream) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    v.a("MicroMsg.WebViewUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        }

        private void a(String str, String str2, InputStream inputStream) {
            Matcher matcher;
            v.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", str, str2);
            String str3 = null;
            if (!be.kS(str)) {
                matcher = lVq.matcher(str);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(47) + 1);
                }
            }
            if (be.kS(str3) && !be.kS(str2)) {
                matcher = lVr.matcher(str2);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(46) + 1);
                }
            }
            if (be.kS(str3)) {
                q qVar = new q(this.cUK);
                int lastIndexOf = qVar.aEZ.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    str3 = "jpg";
                } else {
                    str3 = qVar.aEZ.substring(lastIndexOf + 1);
                }
            }
            this.imagePath = l.lV(str3);
            FileOutputStream fileOutputStream = new FileOutputStream(this.imagePath);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception e) {
                        v.e("MicroMsg.WebViewUtil", "close os failed : %s", e.getMessage());
                    }
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (this.opType == 0) {
                this.lVs = this.context.getString(2131232244, new Object[]{l.MT()});
                l.c(this.imagePath, this.context);
            }
        }

        public final boolean AZ() {
            Exception e;
            FileOutputStream fileOutputStream;
            Throwable th;
            HttpURLConnection httpURLConnection;
            InputStream inputStream = null;
            int i = 0;
            if (!this.lVu) {
                this.lVs = this.context.getString(2131236686);
                return true;
            } else if (be.kS(this.cUK)) {
                return false;
            } else {
                boolean isDataUrl;
                Object invokeStaticMethod;
                String str = this.cUK;
                y bNJ = y.bNJ();
                if (bNJ == null || !bNJ.bNK()) {
                    isDataUrl = URLUtil.isDataUrl(str);
                } else {
                    invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
                    isDataUrl = invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
                }
                if (isDataUrl) {
                    this.imagePath = l.lV("jpg");
                    try {
                        int indexOf = this.cUK.indexOf("base64");
                        if (indexOf > 0) {
                            this.cUK = this.cUK.substring(indexOf + 7);
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.imagePath);
                        try {
                            byte[] decode = Base64.decode(this.cUK, 0);
                            if (decode != null) {
                                fileOutputStream2.write(decode);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            this.lVs = this.context.getString(2131232244, new Object[]{l.MT()});
                            l.c(this.imagePath, this.context);
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                                v.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e2.getMessage());
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            fileOutputStream = fileOutputStream2;
                            try {
                                v.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e2.getMessage());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e22) {
                                        v.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e22.getMessage());
                                    }
                                }
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e4) {
                                        v.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e4.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e22 = e5;
                        v.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e22.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return true;
                    }
                }
                str = this.cUK;
                bNJ = y.bNJ();
                if (bNJ == null || !bNJ.bNK()) {
                    i = URLUtil.isHttpsUrl(str);
                } else {
                    invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
                    if (invokeStaticMethod != null) {
                        i = ((Boolean) invokeStaticMethod).booleanValue();
                    }
                }
                if (i != 0) {
                    try {
                        HttpURLConnection httpURLConnection2 = (HttpsURLConnection) new URL(this.cUK).openConnection();
                        try {
                            httpURLConnection2.setRequestMethod("GET");
                            httpURLConnection2.setRequestProperty("Cookie", this.lVt);
                            httpURLConnection2.setAllowUserInteraction(true);
                            i = httpURLConnection2.getResponseCode();
                            String headerField;
                            if (i != 200) {
                                if (i == 301 || i == 302) {
                                    headerField = httpURLConnection2.getHeaderField("Location");
                                    if (headerField == null) {
                                        headerField = httpURLConnection2.getHeaderField("location");
                                    }
                                    v.i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                                    if (!be.kS(headerField)) {
                                        this.cUK = headerField;
                                        brf();
                                        a(httpURLConnection2, null);
                                    }
                                }
                                this.lVs = this.context.getString(2131236685);
                                a(httpURLConnection2, null);
                            } else {
                                headerField = httpURLConnection2.getContentType();
                                inputStream = httpURLConnection2.getInputStream();
                                a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream);
                                a(httpURLConnection2, inputStream);
                            }
                        } catch (Exception e6) {
                            Exception exception = e6;
                            httpURLConnection = httpURLConnection2;
                            e22 = exception;
                            try {
                                v.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                                a(httpURLConnection, inputStream);
                                return true;
                            } catch (Throwable th4) {
                                th = th4;
                                a(httpURLConnection, inputStream);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            httpURLConnection = httpURLConnection2;
                            th = th5;
                            a(httpURLConnection, inputStream);
                            throw th;
                        }
                    } catch (Exception e7) {
                        e22 = e7;
                        httpURLConnection = null;
                        v.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                        a(httpURLConnection, inputStream);
                        return true;
                    } catch (Throwable th6) {
                        th = th6;
                        httpURLConnection = null;
                        a(httpURLConnection, inputStream);
                        throw th;
                    }
                }
                brf();
                return true;
            }
        }
    }

    public static String aW(Context context, String str) {
        String str2;
        Assert.assertTrue("MicroMsg.WebViewUtil, appendUserAgent fail, context is null, stack = " + be.bur(), context != null);
        if (str == null) {
            str2 = " MicroMessenger/";
        } else {
            str2 = str + " MicroMessenger/";
        }
        PackageInfo av = av(context, aa.getPackageName());
        if (av != null) {
            str2 = (str2 + f.S(null, d.lWh)) + "." + av.versionCode;
        }
        str2 = (str2 + " NetType/" + ak.dO(aa.getContext())) + " Language/" + u.dJ(aa.getContext());
        v.i("MicroMsg.WebViewUtil", "appendUserAgent, uaStr = " + str2);
        return str2;
    }

    public static boolean HY(String str) {
        if (str == null) {
            return false;
        }
        return str.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
    }

    public static boolean ds(String str, String str2) {
        if (str == null || str2 == null || str.length() < 0 || str2.length() < 0 || str2.length() > str.length() || !str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            return false;
        }
        return true;
    }

    public static PackageInfo av(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            v.e("MicroMsg.WebViewUtil", "getPackageInfo fail, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                v.a("MicroMsg.WebViewUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return packageInfo;
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("silk", "audio/silk"));
        arrayList.add(new Pair("jpg", "image/jpg"));
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            hashMap.put(pair.first, pair.second);
            hashMap2.put(pair.second, pair.first);
        }
        lVj = Collections.unmodifiableMap(hashMap);
        lVk = Collections.unmodifiableMap(hashMap2);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (dpa == null) {
            dpa = new ap(1, "webview-save-image", 1);
        }
        dpa.c(new c(context, str, str2, z));
    }

    public static void a(Context context, String str, String str2, boolean z, b bVar) {
        if (dpa == null) {
            dpa = new ap(1, "webview-save-image", 1);
        }
        dpa.c(new c(context, str, str2, z, 1, bVar));
    }

    public static void b(final WebView webView) {
        if (webView != null) {
            v.d("MicroMsg.WebViewUtil", "initPreinjectiframe");
            ad.o(new Runnable() {
                public final void run() {
                    webView.evaluateJavascript("javascript:var preinject_iframe = document.getElementById('preinject_iframe');if (preinject_iframe === null) {preinject_iframe = document.createElement('iframe');preinject_iframe.id = 'preinject_iframe';preinject_iframe.style.display = 'none';document.documentElement.appendChild(preinject_iframe);preinject_iframe.src = ' weixinpreinject://iframe ' }", null);
                }
            });
        }
    }

    public static void c(final WebView webView) {
        if (webView != null) {
            v.d("MicroMsg.WebViewUtil", "initPingIFrame");
            ad.o(new Runnable() {
                public final void run() {
                    webView.evaluateJavascript("javascript:var ping_iframe = document.getElementById('ping_iframe');if (ping_iframe === null) {ping_iframe = document.createElement('iframe');ping_iframe.id = 'ping_iframe';ping_iframe.style.display = 'none';document.documentElement.appendChild(ping_iframe);ping_iframe.src = ' weixinping://iframe ' }", null);
                }
            });
        }
    }

    public static void d(final WebView webView) {
        v.d("MicroMsg.WebViewUtil", "initIFrame");
        ad.o(new Runnable() {
            public final void run() {
                webView.evaluateJavascript("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}", null);
            }
        });
    }

    public static void a(WebView webView, String str, String str2) {
        a(webView, str, str2, true);
    }

    public static void a(final WebView webView, final String str, final String str2, final boolean z) {
        if (webView == null || be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            return;
        }
        v.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", str, str2);
        d(webView);
        ad.o(new Runnable() {
            public final void run() {
                if (z) {
                    webView.evaluateJavascript("javascript:document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2, null);
                } else {
                    webView.evaluateJavascript("javascript:console.log('" + str + "' + " + str2 + ")", null);
                }
            }
        });
    }

    public static String dt(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            return null;
        }
        v.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", str, str2);
        return "document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2;
    }

    public static boolean HZ(String str) {
        if (be.kS(str)) {
            return false;
        }
        try {
            URI uri = new URI(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static final String S(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (!(be.kS(str) || obj == null)) {
                if (!(obj instanceof String) || !be.kS((String) obj)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(str);
                    stringBuilder.append("=");
                    stringBuilder.append(obj);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static final String Ia(String str) {
        if (!be.kS(str)) {
            try {
                str = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                v.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", e.getMessage());
            }
        }
        return str;
    }

    public static final String Ib(String str) {
        if (be.kS(str)) {
            return str;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            bytes = str.getBytes();
            v.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", unsupportedEncodingException.getMessage());
        }
        return Base64.encodeToString(bytes, 2);
    }

    private static String dp(Context context) {
        WifiInfo connectionInfo;
        try {
            connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e) {
            connectionInfo = null;
        }
        if (connectionInfo == null) {
            return "127.0.0.1";
        }
        int ipAddress = connectionInfo.getIpAddress();
        return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & WebView.NORMAL_MODE_ALPHA), Integer.valueOf((ipAddress >> 8) & WebView.NORMAL_MODE_ALPHA), Integer.valueOf((ipAddress >> 16) & WebView.NORMAL_MODE_ALPHA), Integer.valueOf((ipAddress >> 24) & WebView.NORMAL_MODE_ALPHA)});
    }

    public static String bre() {
        int i = 0;
        try {
            i = w.sb();
        } catch (Exception e) {
            v.e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", e);
        }
        if (i == 0) {
            return "127.0.0.1";
        }
        if (i == 1) {
            return dp(aa.getContext());
        }
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface != null) {
                    Enumeration inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return be.kS(inetAddress.getHostAddress()) ? "127.0.0.1" : inetAddress.getHostAddress();
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e2) {
        }
        return "127.0.0.1";
    }

    public static String Ic(String str) {
        if (!be.kS(str) && lVi.matcher(str).matches()) {
            return str.substring(str.indexOf("base64,") + 7).trim();
        }
        return null;
    }

    public static String biq() {
        ConnectivityManager connectivityManager = (ConnectivityManager) aa.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        v.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public static Boolean Id(String str) {
        if (str != null && str.startsWith("Refused to frame")) {
            String[] split = str.split("'");
            if (split.length > 1 && split[1].equalsIgnoreCase("weixinpreinject://iframe")) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    public static Boolean Ie(String str) {
        if (str != null && str.startsWith("Refused to frame")) {
            String[] split = str.split("'");
            if (split.length > 1 && split[1].equalsIgnoreCase("weixinping://iframe")) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    public static String If(String str) {
        String str2 = SQLiteDatabase.KeyEmpty;
        if (str == null || !str.startsWith("Refused to frame")) {
            return str2;
        }
        String[] split = str.split("'");
        if (split.length > 2) {
            return split[1];
        }
        return str2;
    }

    public static String Ig(String str) {
        String str2 = (String) lVj.get(str.toLowerCase());
        if (!be.kS(str2) || be.kS(str)) {
            return str2;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public static String Ih(String str) {
        return Ig(Ii(str));
    }

    public static String Ii(String str) {
        if (be.kS(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String Ij(String str) {
        if (be.kS(str)) {
            return null;
        }
        String str2 = (String) lVk.get(str.toLowerCase());
        if (be.kS(str2)) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return str2;
    }
}
