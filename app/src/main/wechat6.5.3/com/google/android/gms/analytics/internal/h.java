package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

final class h extends o {
    private static final byte[] agd = "\n".getBytes();
    private final String agb;
    private final j agc;

    private class a {
        int age;
        ByteArrayOutputStream agf = new ByteArrayOutputStream();
        final /* synthetic */ h agg;

        public a(h hVar) {
            this.agg = hVar;
        }

        public final boolean b(c cVar) {
            w.Z(cVar);
            if (this.age + 1 > ac.iH()) {
                return false;
            }
            String a = this.agg.a(cVar, false);
            if (a == null) {
                this.agg.afY.hZ().a(cVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = a.getBytes();
            int length = bytes.length;
            if (length > ac.iD()) {
                this.agg.afY.hZ().a(cVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.agf.size() > 0) {
                length++;
            }
            if (this.agf.size() + length > ((Integer) aj.aiC.get()).intValue()) {
                return false;
            }
            try {
                if (this.agf.size() > 0) {
                    this.agf.write(h.agd);
                }
                this.agf.write(bytes);
                this.age++;
                return true;
            } catch (IOException e) {
                this.agg.g("Failed to write payload when batching hits", e);
                return true;
            }
        }
    }

    h(q qVar) {
        super(qVar);
        String str = p.VERSION;
        String str2 = VERSION.RELEASE;
        String c = k.c(Locale.getDefault());
        String str3 = Build.MODEL;
        String str4 = Build.ID;
        this.agb = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str, str2, c, str3, str4});
        this.agc = new j(qVar.agn);
    }

    private int a(java.net.URL r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0034 in list [B:7:0x0031]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        com.google.android.gms.common.internal.w.Z(r5);
        r0 = "GET request";
        r4.e(r0, r5);
        r1 = 0;
        r1 = r4.b(r5);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r1.connect();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r4.a(r1);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r0 = r1.getResponseCode();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        if (r0 != r2) goto L_0x0025;	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
    L_0x001c:
        r2 = r4.afY;	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r2 = r2.ib();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r2.hS();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
    L_0x0025:
        r2 = "GET status";	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r3 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r4.e(r2, r3);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.disconnect();
    L_0x0034:
        return r0;
    L_0x0035:
        r0 = move-exception;
        r2 = "Network GET connection error";	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r4.f(r2, r0);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.disconnect();
    L_0x0041:
        r0 = 0;
        goto L_0x0034;
    L_0x0043:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r1.disconnect();
    L_0x0049:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.h.a(java.net.URL):int");
    }

    private int a(URL url, byte[] bArr) {
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        w.Z(url);
        w.Z(bArr);
        b("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (n.hW()) {
            d("Post payload\n", new String(bArr));
        }
        HttpURLConnection b;
        try {
            b = b(url);
            try {
                b.setDoOutput(true);
                b.setFixedLengthStreamingMode(bArr.length);
                b.connect();
                outputStream = b.getOutputStream();
                outputStream.write(bArr);
                a(b);
                int responseCode = b.getResponseCode();
                if (responseCode == 200) {
                    this.afY.ib().hS();
                }
                e("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        g("Error closing http post connection output stream", e2);
                    }
                }
                if (b == null) {
                    return responseCode;
                }
                b.disconnect();
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    f("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            g("Error closing http post connection output stream", e4);
                        }
                    }
                    if (b != null) {
                        b.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            g("Error closing http post connection output stream", e22);
                        }
                    }
                    if (b != null) {
                        b.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            b = outputStream;
            f("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (b != null) {
                b.disconnect();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            b = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (b != null) {
                b.disconnect();
            }
            throw th;
        }
    }

    private URL a(c cVar) {
        try {
            return new URL(cVar.afQ ? ac.iI() + ac.iK() : ac.iJ() + ac.iK());
        } catch (MalformedURLException e) {
            g("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private void a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    g("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    g("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private int b(URL url, byte[] bArr) {
        HttpURLConnection b;
        OutputStream outputStream;
        Object e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        OutputStream outputStream2 = null;
        w.Z(url);
        w.Z(bArr);
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            super.a(3, "POST compressed size, ratio %, url", Integer.valueOf(toByteArray.length), Long.valueOf((100 * ((long) toByteArray.length)) / ((long) bArr.length)), url);
            if (toByteArray.length > bArr.length) {
                c("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(toByteArray.length), Integer.valueOf(bArr.length));
            }
            if (n.hW()) {
                d("Post payload", "\n" + new String(bArr));
            }
            b = b(url);
            try {
                b.setDoOutput(true);
                b.addRequestProperty("Content-Encoding", "gzip");
                b.setFixedLengthStreamingMode(toByteArray.length);
                b.connect();
                outputStream = b.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
                httpURLConnection = b;
                try {
                    f("Network compressed POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            g("Error closing http compressed post connection output stream", e3);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    b = httpURLConnection;
                    outputStream2 = outputStream;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e4) {
                            g("Error closing http compressed post connection output stream", e4);
                        }
                    }
                    if (b != null) {
                        b.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (b != null) {
                    b.disconnect();
                }
                throw th;
            }
            try {
                outputStream.write(toByteArray);
                outputStream.close();
                a(b);
                int responseCode = b.getResponseCode();
                if (responseCode == 200) {
                    this.afY.ib().hS();
                }
                e("POST status", Integer.valueOf(responseCode));
                if (b == null) {
                    return responseCode;
                }
                b.disconnect();
                return responseCode;
            } catch (IOException e5) {
                e = e5;
                httpURLConnection = b;
                f("Network compressed POST connection error", e);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return 0;
            } catch (Throwable th4) {
                th = th4;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (b != null) {
                    b.disconnect();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            f("Network compressed POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th5) {
            th = th5;
            b = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (b != null) {
                b.disconnect();
            }
            throw th;
        }
    }

    private HttpURLConnection b(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) aj.aiG.get()).intValue());
            httpURLConnection.setReadTimeout(((Integer) aj.aiH.get()).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.agb);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private URL b(c cVar, String str) {
        try {
            return new URL(cVar.afQ ? ac.iI() + ac.iK() + "?" + str : ac.iJ() + ac.iK() + "?" + str);
        } catch (MalformedURLException e) {
            g("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private URL hx() {
        try {
            return new URL(ac.iI() + ((String) aj.aiv.get()));
        } catch (MalformedURLException e) {
            g("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private List<Long> j(List<c> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (c cVar : list) {
            boolean z;
            w.Z(cVar);
            String a = a(cVar, !cVar.afQ);
            if (a == null) {
                this.afY.hZ().a(cVar, "Error formatting hit for upload");
                z = true;
            } else {
                URL b;
                if (a.length() <= ((Integer) aj.aiw.get()).intValue()) {
                    b = b(cVar, a);
                    if (b == null) {
                        G("Failed to build collect GET endpoint url");
                    } else {
                        z = a(b) == 200;
                    }
                } else {
                    String a2 = a(cVar, false);
                    if (a2 == null) {
                        this.afY.hZ().a(cVar, "Error formatting hit for POST upload");
                        z = true;
                    } else {
                        byte[] bytes = a2.getBytes();
                        if (bytes.length > ((Integer) aj.aiB.get()).intValue()) {
                            this.afY.hZ().a(cVar, "Hit payload exceeds size limit");
                            z = true;
                        } else {
                            b = a(cVar);
                            if (b == null) {
                                G("Failed to build collect POST endpoint url");
                            } else if (a(b, bytes) == 200) {
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (!z) {
                break;
            }
            arrayList.add(Long.valueOf(cVar.afN));
            if (arrayList.size() >= ac.iG()) {
                break;
            }
        }
        return arrayList;
    }

    final String a(c cVar, boolean z) {
        w.Z(cVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : cVar.afL.entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    a(stringBuilder, str, (String) entry.getValue());
                }
            }
            a(stringBuilder, "ht", String.valueOf(cVar.afO));
            a(stringBuilder, "qt", String.valueOf(this.afY.agn.currentTimeMillis() - cVar.afO));
            if (f.aob) {
                a(stringBuilder, "_gmsv", p.VERSION);
            }
            if (z) {
                long z2 = k.z(cVar.c("_s", "0"));
                a(stringBuilder, "z", z2 != 0 ? String.valueOf(z2) : String.valueOf(cVar.afN));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            g("Failed to encode name or value", e);
            return null;
        }
    }

    protected final void hm() {
        d("Network initialized. User agent", this.agb);
    }

    public final boolean hw() {
        NetworkInfo activeNetworkInfo;
        q.if();
        hX();
        try {
            activeNetworkInfo = ((ConnectivityManager) this.afY.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C("No network connectivity");
        return false;
    }

    public final List<Long> i(List<c> list) {
        boolean z;
        boolean z2;
        a aVar;
        List<Long> arrayList;
        URL hx;
        int b;
        boolean z3 = true;
        q.if();
        hX();
        w.Z(list);
        if (this.afY.agG.iL().isEmpty() || !this.agc.f(((long) ((Integer) aj.aiE.get()).intValue()) * 1000)) {
            z = false;
        } else {
            z = x.M((String) aj.aix.get()) != x.NONE;
            if (z.N((String) aj.aiy.get()) == z.GZIP) {
                z2 = true;
                if (z) {
                    return j(list);
                }
                if (list.isEmpty()) {
                    z3 = false;
                }
                w.ab(z3);
                a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
                aVar = new a(this);
                arrayList = new ArrayList();
                for (c cVar : list) {
                    if (aVar.b(cVar)) {
                        break;
                    }
                    arrayList.add(Long.valueOf(cVar.afN));
                }
                if (aVar.age == 0) {
                    return arrayList;
                }
                hx = hx();
                if (hx != null) {
                    G("Failed to build batching endpoint url");
                } else {
                    b = z2 ? b(hx, aVar.agf.toByteArray()) : a(hx, aVar.agf.toByteArray());
                    if (200 != b) {
                        d("Batched upload completed. Hits batched", Integer.valueOf(aVar.age));
                        return arrayList;
                    }
                    d("Network error uploading hits. status code", Integer.valueOf(b));
                    if (this.afY.agG.iL().contains(Integer.valueOf(b))) {
                        F("Server instructed the client to stop batching");
                        this.agc.start();
                    }
                }
                return Collections.emptyList();
            }
        }
        z2 = false;
        if (z) {
            return j(list);
        }
        if (list.isEmpty()) {
            z3 = false;
        }
        w.ab(z3);
        a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
        aVar = new a(this);
        arrayList = new ArrayList();
        for (c cVar2 : list) {
            if (aVar.b(cVar2)) {
                break;
            }
            arrayList.add(Long.valueOf(cVar2.afN));
        }
        if (aVar.age == 0) {
            return arrayList;
        }
        hx = hx();
        if (hx != null) {
            if (z2) {
            }
            if (200 != b) {
                d("Network error uploading hits. status code", Integer.valueOf(b));
                if (this.afY.agG.iL().contains(Integer.valueOf(b))) {
                    F("Server instructed the client to stop batching");
                    this.agc.start();
                }
            } else {
                d("Batched upload completed. Hits batched", Integer.valueOf(aVar.age));
                return arrayList;
            }
        }
        G("Failed to build batching endpoint url");
        return Collections.emptyList();
    }
}
