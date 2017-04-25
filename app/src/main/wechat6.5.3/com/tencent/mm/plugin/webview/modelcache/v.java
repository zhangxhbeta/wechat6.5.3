package com.tencent.mm.plugin.webview.modelcache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.z;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;

public final class v {
    public static boolean Ei(String str) {
        return !be.kS(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static String Ej(String str) {
        String str2;
        if (!Ei(str)) {
            return null;
        }
        try {
            URI uri = new URI(str);
            String toLowerCase = be.ma(uri.getScheme()).toLowerCase();
            String toLowerCase2 = be.ma(uri.getHost()).toLowerCase();
            if (be.kS(toLowerCase2)) {
                return null;
            }
            int port = uri.getPort() == -1 ? toLowerCase.equalsIgnoreCase("http") ? 80 : 443 : uri.getPort();
            str = toLowerCase + "://" + toLowerCase2 + ":" + port + "/" + be.ma(uri.getPath()) + (be.kS(uri.getQuery()) ? "" : "?" + uri.getQuery()) + (be.kS(uri.getFragment()) ? "" : "#" + uri.getFragment());
            if (str.endsWith("/")) {
                str = str + "/";
            }
            return Ek(str);
        } catch (URISyntaxException e) {
            URISyntaxException uRISyntaxException = e;
            str2 = str;
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", new Object[]{uRISyntaxException.getMessage()});
            return str2;
        } catch (Exception e2) {
            Exception exception = e2;
            str2 = str;
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", new Object[]{exception.getMessage()});
            return str2;
        }
    }

    private static String Ek(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://");
        stringBuilder.append(parse.getHost()).append(":").append(parse.getPort());
        if (be.bP(parse.getPathSegments())) {
            stringBuilder.append("/");
        } else {
            for (String append : parse.getPathSegments()) {
                stringBuilder.append("/").append(append);
            }
        }
        if (!be.kS(parse.getQuery())) {
            stringBuilder.append("?").append(parse.getQuery());
        }
        if (!be.kS(parse.getFragment())) {
            stringBuilder.append("#").append(parse.getFragment());
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static String[] El(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            return strArr;
        } catch (JSONException e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "arrayStrongToStringArray, exception = %s, arrayString = %s", new Object[]{e, str});
            return new String[0];
        }
    }

    public static boolean g(i iVar) {
        if (iVar == null) {
            return false;
        }
        boolean z;
        if (be.kS(iVar.field_contentMd5) || !be.ma(Et(iVar.field_localPath)).equals(iVar.field_contentMd5)) {
            z = false;
        } else {
            z = true;
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewCacheUtils", "isCacheResValid, cacheRes = %s, ret = %b", new Object[]{iVar, Boolean.valueOf(z)});
        return z;
    }

    public static String S(String str, String str2, String str3) {
        String str4;
        String ma = be.ma(str2);
        if (Ei(ma)) {
            str4 = Ej(ma) + "/" + str3;
        } else if (!Ei(str)) {
            return null;
        } else {
            str4 = str + "/" + ma + "/" + str3;
        }
        try {
            Uri parse = Uri.parse(str4);
            StringBuilder stringBuilder = new StringBuilder(parse.getScheme());
            stringBuilder.append("://");
            stringBuilder.append(parse.getHost()).append(":").append(parse.getPort());
            for (String ma2 : parse.getPathSegments()) {
                stringBuilder.append("/").append(ma2);
            }
            if (!be.kS(parse.getQuery())) {
                stringBuilder.append("?").append(parse.getQuery());
            }
            if (!be.kS(parse.getFragment())) {
                stringBuilder.append("#").append(parse.getFragment());
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "concatURL, exception = %s", new Object[]{e});
            return str4;
        }
    }

    public static String Em(String str) {
        String Ej = Ej(str);
        if (be.kS(Ej)) {
            return null;
        }
        Uri parse = Uri.parse(Ej);
        return parse.getHost() + ":" + parse.getPort();
    }

    public static String En(String str) {
        String Ej = Ej(str);
        if (be.kS(Ej)) {
            return null;
        }
        Uri parse = Uri.parse(Ej);
        return parse.getScheme() + "://" + parse.getHost() + ":" + parse.getPort();
    }

    public static String Eo(String str) {
        String Ep = Ep(str);
        return be.kS(Ep) ? null : Ep.replaceAll("http://", "").replaceAll("https://", "");
    }

    public static String Ep(String str) {
        String Ej = Ej(str);
        if (be.kS(Ej)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", new Object[]{str});
            return null;
        }
        Uri parse = Uri.parse(Ej);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://").append(parse.getHost()).append(":").append(parse.getPort());
        if (!be.bP(parse.getPathSegments())) {
            for (String Ej2 : parse.getPathSegments()) {
                stringBuilder.append("/").append(be.ma(Ej2));
            }
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static String Eq(String str) {
        if (be.kS(str)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "url is null");
            return null;
        }
        int lastIndexOf = str.lastIndexOf("?");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return "1";
        }
        return z.Kg(str.substring(lastIndexOf));
    }

    public static byte[] Er(String str) {
        Closeable byteArrayOutputStream;
        Closeable inputStream;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                int contentLength = httpURLConnection.getContentLength();
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, statusCode = %d, contentLength = %d", new Object[]{str, Integer.valueOf(responseCode), Integer.valueOf(contentLength)});
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            contentLength = inputStream.read(bArr);
                            if (contentLength != -1) {
                                byteArrayOutputStream.write(bArr, 0, contentLength);
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                                be.f(inputStream);
                                be.f(byteArrayOutputStream);
                                return bArr;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
                            be.f(inputStream);
                            be.f(byteArrayOutputStream);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = inputStream;
                            be.f(closeable);
                            be.f(byteArrayOutputStream);
                            throw th;
                        }
                    }
                }
                be.f(inputStream);
                be.f(byteArrayOutputStream);
                return null;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
                be.f(inputStream);
                be.f(byteArrayOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                be.f(closeable);
                be.f(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            inputStream = null;
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
            be.f(inputStream);
            be.f(byteArrayOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            be.f(closeable);
            be.f(byteArrayOutputStream);
            throw th;
        }
    }

    public static boolean Es(String str) {
        return be.ma(str).startsWith("https://res.wx.qq.com/open/libs/") || be.ma(str).startsWith("https://res.wx.qq.com:443/open/libs/") || be.ma(str).startsWith("http://203.195.235.76:8888");
    }

    public static String Et(String str) {
        Closeable openRead;
        FileNotFoundException e;
        Throwable th;
        Exception e2;
        String str2 = null;
        if (FileOp.aR(str)) {
            try {
                int jP = (int) FileOp.jP(str);
                openRead = FileOp.openRead(str);
                try {
                    str2 = g.a(openRead, jP);
                    be.f(openRead);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e});
                        be.f(openRead);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        be.f(openRead);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                    be.f(openRead);
                    return str2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                openRead = str2;
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e});
                be.f(openRead);
                return str2;
            } catch (Exception e6) {
                e2 = e6;
                openRead = str2;
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                be.f(openRead);
                return str2;
            } catch (Throwable th3) {
                openRead = str2;
                th = th3;
                be.f(openRead);
                throw th;
            }
        }
        return str2;
    }

    public static int a(k kVar) {
        if (!be.ma(kVar.lqZ).equals("cache")) {
            return -1;
        }
        if (!Boolean.parseBoolean((String) kVar.iaJ.get("async")) || be.kS((String) kVar.iaJ.get("src"))) {
            return !be.kS((String) kVar.iaJ.get("resourceList")) ? 1 : -1;
        } else {
            return 2;
        }
    }
}
