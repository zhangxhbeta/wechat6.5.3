package com.tencent.mm.pluginsdk.k.a.c;

import com.tencent.mm.pluginsdk.k.a.b.a;
import com.tencent.mm.pluginsdk.k.a.b.b;
import com.tencent.mm.pluginsdk.k.a.b.d;
import com.tencent.mm.pluginsdk.k.a.b.e;
import com.tencent.mm.pluginsdk.k.a.b.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import javax.net.ssl.SSLContext;

public final class k {
    private static final Class[] lEp = new Class[]{InterruptedException.class};
    private static final Class[] lEq = new Class[]{UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, a.class, d.class, f.class};
    private static final Class[] lEr = new Class[]{SocketException.class, SocketTimeoutException.class};
    private boolean lEo = false;

    k() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final com.tencent.mm.pluginsdk.k.a.c.m a(com.tencent.mm.pluginsdk.k.a.c.f r15) {
        /*
        r14 = this;
        r4 = 0;
        r8 = 1;
        r7 = 0;
        if (r15 != 0) goto L_0x0010;
    L_0x0005:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r3 = "get null task, just skip";
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);
        r2 = r4;
    L_0x000f:
        return r2;
    L_0x0010:
        r2 = r15.OZ();
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x0032;
    L_0x001a:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r3 = "%s: filePath is null or nil, just return null";
        r5 = new java.lang.Object[r8];
        r6 = r15.bnQ();
        r5[r7] = r6;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r5);
        r2 = r4;
        goto L_0x000f;
    L_0x002d:
        if (r5 == 0) goto L_0x0032;
    L_0x002f:
        r5.disconnect();	 Catch:{ Exception -> 0x0258 }
    L_0x0032:
        r2 = r15.Pc();	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        if (r2 != 0) goto L_0x003f;
    L_0x0038:
        r2 = r15.OZ();	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        com.tencent.mm.pluginsdk.k.a.d.a.Hl(r2);	 Catch:{ Exception -> 0x0262, all -> 0x025d }
    L_0x003f:
        boe();	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        r2 = r15.getURL();	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        r3 = new java.net.URL;	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        r2 = r3.openConnection();	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0262, all -> 0x025d }
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: connection opened, url = %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 0;
        r11 = r15.bnQ();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 1;
        r11 = r15.getURL();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.i(r5, r6, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        boe();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        a(r15, r2);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        boe();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = r15.OZ();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = com.tencent.mm.pluginsdk.k.a.d.a.Hj(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: RangeOffset = %d";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r12 = 0;
        r13 = r15.bnQ();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r12] = r13;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r12 = 1;
        r13 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r12] = r13;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.i(r5, r6, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r12 = 0;
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r5 != 0) goto L_0x015a;
    L_0x009c:
        r6 = r7;
    L_0x009d:
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: hasRangerHeader=%b";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 0;
        r12 = r15.bnQ();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 1;
        r12 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.i(r5, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        boe();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = "https";
        r3 = r3.getProtocol();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = r5.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r3 == 0) goto L_0x00f4;
    L_0x00c7:
        r0 = r2;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = r0;
        r5 = "TLSv1.2";
        r5 = Hf(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r5 != 0) goto L_0x00e1;
    L_0x00d4:
        r5 = "TLSv1";
        r5 = Hf(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r5 != 0) goto L_0x00e1;
    L_0x00dd:
        r5 = javax.net.ssl.SSLContext.getDefault();	 Catch:{ Exception -> 0x0252, all -> 0x01f5 }
    L_0x00e1:
        if (r5 == 0) goto L_0x017b;
    L_0x00e3:
        r9 = 0;
        r10 = 0;
        r11 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r11.<init>();	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r5.init(r9, r10, r11);	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r5 = r5.getSocketFactory();	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
        r3.setSSLSocketFactory(r5);	 Catch:{ Exception -> 0x017a, all -> 0x01f5 }
    L_0x00f4:
        boe();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = "MicroMsg.ResDownloader.NetworkPerformer";
        r5 = "%s: HttpMethod = %s";
        r9 = 2;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 0;
        r11 = r15.bnQ();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = 1;
        r11 = r15.boa();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.d(r3, r5, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = "POST";
        r5 = r15.boa();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = r3.equals(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r3 == 0) goto L_0x0148;
    L_0x011e:
        r3 = 0;
        r3 = com.tencent.mm.sdk.platformtools.be.bl(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r3 != 0) goto L_0x0148;
    L_0x0125:
        r3 = 1;
        r2.setDoOutput(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = "Content-Type";
        r5 = r15.bod();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.setRequestProperty(r3, r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = 0;
        r3 = r3.length;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.setFixedLengthStreamingMode(r3);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x01fe, all -> 0x0267 }
        r3 = r2.getOutputStream();	 Catch:{ IOException -> 0x01fe, all -> 0x0267 }
        r5.<init>(r3);	 Catch:{ IOException -> 0x01fe, all -> 0x0267 }
        r3 = 0;
        r5.write(r3);	 Catch:{ IOException -> 0x026a }
        r5.close();	 Catch:{ IOException -> 0x01d3 }
    L_0x0148:
        boe();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3 = a(r15, r2, r6);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.disconnect();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        if (r2 == 0) goto L_0x0157;
    L_0x0154:
        r2.disconnect();	 Catch:{ Exception -> 0x0255 }
    L_0x0157:
        r2 = r3;
        goto L_0x000f;
    L_0x015a:
        r5 = "Range";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9 = "bytes=";
        r6.<init>(r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = r6.append(r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9 = "-";
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r2.addRequestProperty(r5, r6);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = r8;
        goto L_0x009d;
    L_0x017a:
        r5 = move-exception;
    L_0x017b:
        r5 = r15.boc();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9 = new android.net.SSLSessionCache;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r9.<init>(r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = android.net.SSLCertificateSocketFactory.getDefault(r5, r9);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r3.setSSLSocketFactory(r5);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        goto L_0x00f4;
    L_0x0191:
        r3 = move-exception;
        r5 = r2;
    L_0x0193:
        r2 = b(r15, r3);	 Catch:{ all -> 0x0260 }
        if (r2 != 0) goto L_0x0248;
    L_0x0199:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: get null response in catch-block, may retry";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0260 }
        r10 = 0;
        r11 = r15.bnQ();	 Catch:{ all -> 0x0260 }
        r9[r10] = r11;	 Catch:{ all -> 0x0260 }
        com.tencent.mm.sdk.platformtools.v.i(r2, r6, r9);	 Catch:{ all -> 0x0260 }
        r2 = r15.Pg();	 Catch:{ all -> 0x0260 }
        if (r2 != 0) goto L_0x002d;
    L_0x01b2:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: retry times out";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0260 }
        r7 = 0;
        r8 = r15.bnQ();	 Catch:{ all -> 0x0260 }
        r6[r7] = r8;	 Catch:{ all -> 0x0260 }
        com.tencent.mm.sdk.platformtools.v.i(r2, r4, r6);	 Catch:{ all -> 0x0260 }
        r2 = a(r15, r3);	 Catch:{ all -> 0x0260 }
        if (r5 == 0) goto L_0x000f;
    L_0x01cb:
        r5.disconnect();	 Catch:{ Exception -> 0x01d0 }
        goto L_0x000f;
    L_0x01d0:
        r3 = move-exception;
        goto L_0x000f;
    L_0x01d3:
        r3 = move-exception;
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: Method POST, send request body, close IOException";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 0;
        r12 = r15.bnQ();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.e(r5, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r5 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.a(r5, r3, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        goto L_0x0148;
    L_0x01f5:
        r3 = move-exception;
        r5 = r2;
        r2 = r3;
    L_0x01f8:
        if (r5 == 0) goto L_0x01fd;
    L_0x01fa:
        r5.disconnect();	 Catch:{ Exception -> 0x025b }
    L_0x01fd:
        throw r2;
    L_0x01fe:
        r3 = move-exception;
        r5 = r4;
    L_0x0200:
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: Method POST, send request body, write IOException";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x0220 }
        r11 = 0;
        r12 = r15.bnQ();	 Catch:{ all -> 0x0220 }
        r10[r11] = r12;	 Catch:{ all -> 0x0220 }
        com.tencent.mm.sdk.platformtools.v.e(r6, r9, r10);	 Catch:{ all -> 0x0220 }
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x0220 }
        com.tencent.mm.sdk.platformtools.v.a(r6, r3, r9, r10);	 Catch:{ all -> 0x0220 }
        throw r3;	 Catch:{ all -> 0x0220 }
    L_0x0220:
        r3 = move-exception;
    L_0x0221:
        if (r5 == 0) goto L_0x0226;
    L_0x0223:
        r5.close();	 Catch:{ IOException -> 0x0227 }
    L_0x0226:
        throw r3;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
    L_0x0227:
        r5 = move-exception;
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "%s: Method POST, send request body, close IOException";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r11 = 0;
        r12 = r15.bnQ();	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.e(r6, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r9 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        com.tencent.mm.sdk.platformtools.v.a(r6, r5, r9, r10);	 Catch:{ Exception -> 0x0191, all -> 0x01f5 }
        goto L_0x0226;
    L_0x0248:
        if (r5 == 0) goto L_0x000f;
    L_0x024a:
        r5.disconnect();	 Catch:{ Exception -> 0x024f }
        goto L_0x000f;
    L_0x024f:
        r3 = move-exception;
        goto L_0x000f;
    L_0x0252:
        r9 = move-exception;
        goto L_0x00e1;
    L_0x0255:
        r2 = move-exception;
        goto L_0x0157;
    L_0x0258:
        r2 = move-exception;
        goto L_0x0032;
    L_0x025b:
        r3 = move-exception;
        goto L_0x01fd;
    L_0x025d:
        r2 = move-exception;
        r5 = r4;
        goto L_0x01f8;
    L_0x0260:
        r2 = move-exception;
        goto L_0x01f8;
    L_0x0262:
        r2 = move-exception;
        r3 = r2;
        r5 = r4;
        goto L_0x0193;
    L_0x0267:
        r3 = move-exception;
        r5 = r4;
        goto L_0x0221;
    L_0x026a:
        r3 = move-exception;
        goto L_0x0200;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.k.a.c.k.a(com.tencent.mm.pluginsdk.k.a.c.f):com.tencent.mm.pluginsdk.k.a.c.m");
    }

    private static void boe() {
        if (Thread.interrupted()) {
            throw new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
        }
    }

    private static void a(f fVar, HttpURLConnection httpURLConnection) {
        v.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", fVar.bnQ());
        Collection<b> bob = fVar.bob();
        if (bob != null && bob.size() > 0) {
            for (b bVar : bob) {
                httpURLConnection.addRequestProperty(bVar.name, bVar.value);
            }
        }
        httpURLConnection.setRequestMethod(fVar.boa());
        if ("GET".equalsIgnoreCase(fVar.boa())) {
            httpURLConnection.setDoOutput(false);
        }
        httpURLConnection.setConnectTimeout(fVar.getConnectTimeout());
        httpURLConnection.setReadTimeout(fVar.getReadTimeout());
        httpURLConnection.setUseCaches(false);
        if (fVar.Pb()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        String property = System.getProperty("http.agent");
        if (!be.kS(property)) {
            httpURLConnection.setRequestProperty("User-agent", property);
        }
        if (fVar.Pf()) {
            httpURLConnection.setInstanceFollowRedirects(true);
        } else {
            httpURLConnection.setInstanceFollowRedirects(false);
        }
    }

    private static SSLContext Hf(String str) {
        try {
            return SSLContext.getInstance(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.pluginsdk.k.a.c.m a(com.tencent.mm.pluginsdk.k.a.c.f r17, java.net.HttpURLConnection r18, boolean r19) {
        /*
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r3 = "%s: step4, start to read response";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r17.bnQ();
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r5 = 0;
        r4 = 0;
        r3 = -1;
        r6 = -1;
        r7 = r18.getResponseCode();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x029c }
        r9 = r18.getContentLength();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r10 = r18.getContentEncoding();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r11 = r18.getContentType();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2 = "bytes";
        r6 = "Accept-Ranges";
        r0 = r18;
        r6 = r0.getHeaderField(r6);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2 = r2.equals(r6);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        if (r2 == 0) goto L_0x00ab;
    L_0x0039:
        r2 = 1;
        r8 = r2;
    L_0x003b:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: received status code = %d, content-length = %d, content-encoding = %s, content-type = %s, isSupportRange = %b, \nresponseHeaders = %s";
        r12 = 7;
        r12 = new java.lang.Object[r12];	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r13 = 0;
        r14 = r17.bnQ();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r12[r13] = r14;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r13 = 1;
        r14 = java.lang.Integer.valueOf(r7);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r12[r13] = r14;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r13 = 2;
        r14 = java.lang.Integer.valueOf(r9);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r12[r13] = r14;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r13 = 3;
        r12[r13] = r10;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r13 = 4;
        r12[r13] = r11;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r13 = 5;
        r14 = java.lang.Boolean.valueOf(r8);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r12[r13] = r14;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r13 = 6;
        r14 = r18.getHeaderFields();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r14 = com.tencent.mm.pluginsdk.k.a.d.b.ac(r14);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r12[r13] = r14;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        com.tencent.mm.sdk.platformtools.v.i(r2, r6, r12);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2 = r17.OZ();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r12 = com.tencent.mm.pluginsdk.k.a.d.a.Hj(r2);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        if (r9 != 0) goto L_0x00c7;
    L_0x007e:
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r2 != r7) goto L_0x00c7;
    L_0x0082:
        r14 = 0;
        r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r2 <= 0) goto L_0x00c7;
    L_0x0088:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: file exists, return";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r9 = 0;
        r10 = r17.bnQ();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r8[r9] = r10;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        com.tencent.mm.sdk.platformtools.v.i(r2, r6, r8);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2 = new com.tencent.mm.pluginsdk.k.a.c.m;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r0 = r17;
        r2.<init>(r0, r12, r11);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r3 = 0;
        com.tencent.mm.pluginsdk.k.a.d.a.e(r3);
        r3 = 0;
        com.tencent.mm.pluginsdk.k.a.d.a.e(r3);
    L_0x00aa:
        return r2;
    L_0x00ab:
        r2 = "Content-Range";
        r0 = r18;
        r2 = r0.getHeaderField(r2);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        if (r2 == 0) goto L_0x00c3;
    L_0x00b6:
        r6 = "bytes";
        r2 = r2.startsWith(r6);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        if (r2 == 0) goto L_0x00c3;
    L_0x00bf:
        r2 = 1;
        r8 = r2;
        goto L_0x003b;
    L_0x00c3:
        r2 = 0;
        r8 = r2;
        goto L_0x003b;
    L_0x00c7:
        r2 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r2 == r7) goto L_0x00cf;
    L_0x00cb:
        r2 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r2 != r7) goto L_0x0104;
    L_0x00cf:
        r2 = r17.Pf();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        if (r2 != 0) goto L_0x0104;
    L_0x00d5:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r6 = "%s: task redirects not allowed, return";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r9 = 0;
        r10 = r17.bnQ();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r8[r9] = r10;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        com.tencent.mm.sdk.platformtools.v.i(r2, r6, r8);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2 = new com.tencent.mm.pluginsdk.k.a.b.d;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2.<init>();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        throw r2;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
    L_0x00ee:
        r2 = move-exception;
    L_0x00ef:
        throw r2;	 Catch:{ all -> 0x00f0 }
    L_0x00f0:
        r2 = move-exception;
    L_0x00f1:
        com.tencent.mm.pluginsdk.k.a.d.a.e(r5);
        com.tencent.mm.pluginsdk.k.a.d.a.e(r4);
        if (r3 <= 0) goto L_0x0103;
    L_0x00f9:
        r4 = com.tencent.mm.model.ab.a.csa;
        if (r4 == 0) goto L_0x0103;
    L_0x00fd:
        r4 = com.tencent.mm.model.ab.a.csa;
        r5 = 0;
        r4.aC(r3, r5);
    L_0x0103:
        throw r2;
    L_0x0104:
        if (r9 != 0) goto L_0x010e;
    L_0x0106:
        r2 = new com.tencent.mm.pluginsdk.k.a.b.f;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2.<init>();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        throw r2;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
    L_0x010c:
        r2 = move-exception;
    L_0x010d:
        throw r2;	 Catch:{ all -> 0x00f0 }
    L_0x010e:
        r2 = r17.Pd();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        if (r2 != 0) goto L_0x013d;
    L_0x0114:
        if (r9 >= 0) goto L_0x013d;
    L_0x0116:
        r2 = new java.net.SocketException;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2.<init>();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        throw r2;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
    L_0x011c:
        r2 = move-exception;
    L_0x011d:
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r7 = "%s: HttpUrlConnection SSLHandshakeException!";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x00f0 }
        r9 = 0;
        r10 = r17.bnQ();	 Catch:{ all -> 0x00f0 }
        r8[r9] = r10;	 Catch:{ all -> 0x00f0 }
        com.tencent.mm.sdk.platformtools.v.e(r6, r7, r8);	 Catch:{ all -> 0x00f0 }
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x00f0 }
        com.tencent.mm.sdk.platformtools.v.a(r6, r2, r7, r8);	 Catch:{ all -> 0x00f0 }
        throw r2;	 Catch:{ all -> 0x00f0 }
    L_0x013d:
        if (r9 <= 0) goto L_0x0176;
    L_0x013f:
        r14 = (long) r9;
        r0 = r17;
        r2 = r0.dw(r14);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        if (r2 != 0) goto L_0x0176;
    L_0x0148:
        r2 = new com.tencent.mm.pluginsdk.k.a.b.a;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2.<init>();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        throw r2;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
    L_0x014e:
        r2 = move-exception;
    L_0x014f:
        r6 = "MicroMsg.ResDownloader.NetworkPerformer";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f0 }
        r7.<init>();	 Catch:{ all -> 0x00f0 }
        r8 = r17.bnQ();	 Catch:{ all -> 0x00f0 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x00f0 }
        r8 = ": ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x00f0 }
        r8 = r2.getMessage();	 Catch:{ all -> 0x00f0 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x00f0 }
        r7 = r7.toString();	 Catch:{ all -> 0x00f0 }
        com.tencent.mm.sdk.platformtools.v.e(r6, r7);	 Catch:{ all -> 0x00f0 }
        throw r2;	 Catch:{ all -> 0x00f0 }
    L_0x0176:
        r2 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r2 != r7) goto L_0x0183;
    L_0x017a:
        r2 = new com.tencent.mm.pluginsdk.k.a.b.b;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r8 = (long) r9;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2.<init>(r8, r12);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        throw r2;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
    L_0x0181:
        r2 = move-exception;
    L_0x0182:
        throw r2;	 Catch:{ all -> 0x00f0 }
    L_0x0183:
        r2 = r18.getInputStream();	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r6 = new java.io.BufferedInputStream;	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r6.<init>(r2);	 Catch:{ InterruptedException -> 0x00ee, UnknownHostException -> 0x010c, SSLHandshakeException -> 0x011c, SocketException -> 0x014e, SocketTimeoutException -> 0x0181, IOException -> 0x02dd }
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r10);	 Catch:{ InterruptedException -> 0x0320, UnknownHostException -> 0x0313, SSLHandshakeException -> 0x0306, SocketException -> 0x02f9, SocketTimeoutException -> 0x02ec, IOException -> 0x02e3, all -> 0x02ca }
        if (r2 != 0) goto L_0x01a1;
    L_0x0192:
        r2 = "gzip";
        r2 = r10.equalsIgnoreCase(r2);	 Catch:{ InterruptedException -> 0x0320, UnknownHostException -> 0x0313, SSLHandshakeException -> 0x0306, SocketException -> 0x02f9, SocketTimeoutException -> 0x02ec, IOException -> 0x02e3, all -> 0x02ca }
        if (r2 == 0) goto L_0x01a1;
    L_0x019b:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ InterruptedException -> 0x0320, UnknownHostException -> 0x0313, SSLHandshakeException -> 0x0306, SocketException -> 0x02f9, SocketTimeoutException -> 0x02ec, IOException -> 0x02e3, all -> 0x02ca }
        r2.<init>(r6);	 Catch:{ InterruptedException -> 0x0320, UnknownHostException -> 0x0313, SSLHandshakeException -> 0x0306, SocketException -> 0x02f9, SocketTimeoutException -> 0x02ec, IOException -> 0x02e3, all -> 0x02ca }
        r6 = r2;
    L_0x01a1:
        r10 = r17.OZ();	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r5 = r17.bnQ();	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        if (r19 == 0) goto L_0x01dd;
    L_0x01ab:
        if (r8 == 0) goto L_0x01dd;
    L_0x01ad:
        r2 = 1;
    L_0x01ae:
        r12 = "MicroMsg.ResDownloader.NetworkPerformer";
        r13 = "%s: getOutputStream, filePath %s";
        r14 = 2;
        r14 = new java.lang.Object[r14];	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r15 = 0;
        r14[r15] = r5;	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r15 = 1;
        r14[r15] = r10;	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        com.tencent.mm.sdk.platformtools.v.d(r12, r13, r14);	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r12 = com.tencent.mm.sdk.platformtools.be.kS(r10);	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        if (r12 == 0) goto L_0x01df;
    L_0x01c6:
        r2 = new java.io.FileNotFoundException;	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r8 = "%s filePath is null or nil";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r10 = 0;
        r9[r10] = r5;	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r5 = java.lang.String.format(r8, r9);	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r2.<init>(r5);	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        throw r2;	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
    L_0x01d9:
        r2 = move-exception;
        r5 = r6;
        goto L_0x00ef;
    L_0x01dd:
        r2 = 0;
        goto L_0x01ae;
    L_0x01df:
        r5 = new java.io.BufferedOutputStream;	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r12 = new java.io.FileOutputStream;	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r12.<init>(r10, r2);	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r5.<init>(r12);	 Catch:{ InterruptedException -> 0x01d9, UnknownHostException -> 0x0317, SSLHandshakeException -> 0x030a, SocketException -> 0x02fd, SocketTimeoutException -> 0x02f0, IOException -> 0x02e3, all -> 0x02ce }
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: append = %b, isSupportRange = %s";
        r10 = 3;
        r10 = new java.lang.Object[r10];	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r12 = 0;
        r13 = r17.bnQ();	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r10[r12] = r13;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r12 = 1;
        r13 = java.lang.Boolean.valueOf(r19);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r10[r12] = r13;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r12 = 2;
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r10[r12] = r8;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        com.tencent.mm.sdk.platformtools.v.i(r2, r4, r10);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r2 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r2 = new byte[r2];	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r3 = 0;
    L_0x020f:
        r4 = 0;
        r8 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r4 = r6.read(r2, r4, r8);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r8 = -1;
        if (r4 == r8) goto L_0x0227;
    L_0x0219:
        r8 = 0;
        r5.write(r2, r8, r4);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r3 = r3 + r4;
        boe();	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        goto L_0x020f;
    L_0x0222:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        goto L_0x00ef;
    L_0x0227:
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: read count = %d";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r10 = 0;
        r12 = r17.bnQ();	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r8[r10] = r12;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r10 = 1;
        r12 = java.lang.Integer.valueOf(r3);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r8[r10] = r12;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        com.tencent.mm.sdk.platformtools.v.i(r2, r4, r8);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r5.flush();	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r2 = "MicroMsg.ResDownloader.NetworkPerformer";
        r4 = "%s: download complete, flush and send complete status";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r10 = 0;
        r12 = r17.bnQ();	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r8[r10] = r12;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        com.tencent.mm.sdk.platformtools.v.i(r2, r4, r8);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r2 = r17.Pd();	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        if (r2 == 0) goto L_0x0280;
    L_0x025d:
        r2 = new com.tencent.mm.pluginsdk.k.a.c.m;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r4 = r17.OZ();	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r8 = com.tencent.mm.pluginsdk.k.a.d.a.Hj(r4);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r0 = r17;
        r2.<init>(r0, r8, r11);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        com.tencent.mm.pluginsdk.k.a.d.a.e(r6);
        com.tencent.mm.pluginsdk.k.a.d.a.e(r5);
        if (r3 <= 0) goto L_0x00aa;
    L_0x0274:
        r4 = com.tencent.mm.model.ab.a.csa;
        if (r4 == 0) goto L_0x00aa;
    L_0x0278:
        r4 = com.tencent.mm.model.ab.a.csa;
        r5 = 0;
        r4.aC(r3, r5);
        goto L_0x00aa;
    L_0x0280:
        r2 = new com.tencent.mm.pluginsdk.k.a.c.m;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r8 = (long) r9;	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        r0 = r17;
        r2.<init>(r0, r8, r11);	 Catch:{ InterruptedException -> 0x0222, UnknownHostException -> 0x031b, SSLHandshakeException -> 0x030e, SocketException -> 0x0301, SocketTimeoutException -> 0x02f4, IOException -> 0x02e8, all -> 0x02d2 }
        com.tencent.mm.pluginsdk.k.a.d.a.e(r6);
        com.tencent.mm.pluginsdk.k.a.d.a.e(r5);
        if (r3 <= 0) goto L_0x00aa;
    L_0x0290:
        r4 = com.tencent.mm.model.ab.a.csa;
        if (r4 == 0) goto L_0x00aa;
    L_0x0294:
        r4 = com.tencent.mm.model.ab.a.csa;
        r5 = 0;
        r4.aC(r3, r5);
        goto L_0x00aa;
    L_0x029c:
        r2 = move-exception;
        r16 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r16;
    L_0x02a4:
        com.tencent.mm.pluginsdk.k.a.d.a.e(r6);	 Catch:{ all -> 0x02d7 }
        r6 = r18.getErrorStream();	 Catch:{ all -> 0x02d7 }
        r7 = "MicroMsg.ResDownloader.NetworkPerformer";
        r8 = "%s: HttpUrlConnection getInputStream failed!";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x02c4 }
        r10 = 0;
        r11 = r17.bnQ();	 Catch:{ all -> 0x02c4 }
        r9[r10] = r11;	 Catch:{ all -> 0x02c4 }
        com.tencent.mm.sdk.platformtools.v.e(r7, r8, r9);	 Catch:{ all -> 0x02c4 }
        r7 = new com.tencent.mm.pluginsdk.k.a.b.e;	 Catch:{ all -> 0x02c4 }
        r7.<init>(r3, r2);	 Catch:{ all -> 0x02c4 }
        throw r7;	 Catch:{ all -> 0x02c4 }
    L_0x02c4:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x00f1;
    L_0x02ca:
        r2 = move-exception;
        r5 = r6;
        goto L_0x00f1;
    L_0x02ce:
        r2 = move-exception;
        r5 = r6;
        goto L_0x00f1;
    L_0x02d2:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        goto L_0x00f1;
    L_0x02d7:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x00f1;
    L_0x02dd:
        r2 = move-exception;
        r6 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r7;
        goto L_0x02a4;
    L_0x02e3:
        r2 = move-exception;
        r5 = r4;
        r4 = r3;
        r3 = r7;
        goto L_0x02a4;
    L_0x02e8:
        r2 = move-exception;
        r4 = r3;
        r3 = r7;
        goto L_0x02a4;
    L_0x02ec:
        r2 = move-exception;
        r5 = r6;
        goto L_0x0182;
    L_0x02f0:
        r2 = move-exception;
        r5 = r6;
        goto L_0x0182;
    L_0x02f4:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        goto L_0x0182;
    L_0x02f9:
        r2 = move-exception;
        r5 = r6;
        goto L_0x014f;
    L_0x02fd:
        r2 = move-exception;
        r5 = r6;
        goto L_0x014f;
    L_0x0301:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        goto L_0x014f;
    L_0x0306:
        r2 = move-exception;
        r5 = r6;
        goto L_0x011d;
    L_0x030a:
        r2 = move-exception;
        r5 = r6;
        goto L_0x011d;
    L_0x030e:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        goto L_0x011d;
    L_0x0313:
        r2 = move-exception;
        r5 = r6;
        goto L_0x010d;
    L_0x0317:
        r2 = move-exception;
        r5 = r6;
        goto L_0x010d;
    L_0x031b:
        r2 = move-exception;
        r4 = r5;
        r5 = r6;
        goto L_0x010d;
    L_0x0320:
        r2 = move-exception;
        r5 = r6;
        goto L_0x00ef;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.k.a.c.k.a(com.tencent.mm.pluginsdk.k.a.c.f, java.net.HttpURLConnection, boolean):com.tencent.mm.pluginsdk.k.a.c.m");
    }

    private static m a(f fVar, Exception exception) {
        int i = -1;
        if (exception instanceof e) {
            i = ((e) exception).httpStatusCode;
            exception = ((e) exception).lEc;
        }
        v.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", fVar.bnQ(), exception);
        return new m(fVar, exception, i, 3);
    }

    private static m b(f fVar, Exception exception) {
        if (exception instanceof ProtocolException) {
            v.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", fVar.bnQ(), fVar.boa());
            return a(fVar, exception);
        } else if (exception instanceof b) {
            v.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", fVar.bnQ(), exception.getClass().getSimpleName(), exception.getMessage());
            com.tencent.mm.pluginsdk.k.a.d.a.Hl(fVar.OZ());
            return null;
        } else {
            v.e("MicroMsg.ResDownloader.NetworkPerformer", exception.getClass().getSimpleName());
            for (Object equals : lEp) {
                if (equals.equals(exception.getClass())) {
                    v.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", fVar.bnQ(), exception);
                    return new m(fVar, exception);
                }
            }
            for (Object equals2 : lEr) {
                if (equals2.equals(exception.getClass())) {
                    return null;
                }
            }
            for (Object equals3 : lEq) {
                if (equals3.equals(exception.getClass())) {
                    return a(fVar, exception);
                }
            }
            return a(fVar, exception);
        }
    }
}
