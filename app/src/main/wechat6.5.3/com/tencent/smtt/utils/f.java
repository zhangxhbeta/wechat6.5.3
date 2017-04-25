package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.mmdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class f {

    public interface a {
        void yN(int i);
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        String bOb;
        if (z) {
            try {
                bOb = j.bNZ().bOb();
            } catch (Exception e) {
                return null;
            }
        }
        i.bNW();
        bOb = i.bNX();
        bOb = str + bOb;
        if (z) {
            try {
                bArr = com.tencent.smtt.sdk.a.a.l(j.bNZ().pzf.getBytes(), bArr);
            } catch (Exception e2) {
            }
        } else {
            bArr = i.bNW().by(bArr);
        }
        if (bArr == null) {
            return null;
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Content-Length", String.valueOf(bArr.length));
        HttpURLConnection l = l(bOb, hashMap);
        if (l == null) {
            return null;
        }
        a(l, bArr);
        return a(l, aVar, z);
    }

    public static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        Closeable inflaterInputStream;
        Closeable byteArrayOutputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            String contentEncoding;
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.yN(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    if (contentEncoding != null) {
                        if (contentEncoding.equalsIgnoreCase("deflate")) {
                            inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                        }
                    }
                    Object obj = inputStream;
                } else {
                    inflaterInputStream = new GZIPInputStream(inputStream);
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    g(inflaterInputStream);
                    g(closeable);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[FileUtils.S_IWUSR];
                    while (true) {
                        int read = inflaterInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (z) {
                        closeable = inflaterInputStream;
                        contentEncoding = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                    } else {
                        i.bNW();
                        closeable = inflaterInputStream;
                        contentEncoding = new String(i.bz(byteArrayOutputStream.toByteArray()));
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    closeable = byteArrayOutputStream;
                    th = th4;
                    g(inflaterInputStream);
                    g(closeable);
                    throw th;
                }
            }
            byteArrayOutputStream = null;
            contentEncoding = null;
            g(closeable);
            g(byteArrayOutputStream);
            return contentEncoding;
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
            g(inflaterInputStream);
            g(closeable);
            throw th;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e) {
        }
    }

    private static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static HttpURLConnection l(String str, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(20000);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
