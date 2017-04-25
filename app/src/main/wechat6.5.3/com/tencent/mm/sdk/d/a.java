package com.tencent.mm.sdk.d;

import com.tencent.mm.sdk.d.b.b;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public final class a extends b {
    private HttpURLConnection nhB = null;

    public a(HttpURLConnection httpURLConnection) {
        this.nhB = httpURLConnection;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.sdk.d.b.b r15, com.tencent.mm.sdk.d.b.c r16) {
        /*
        r14 = this;
        r2 = 0;
        r12 = 1;
        r3 = 0;
        r1 = "MicroMsg.HttpURLConnectionWrapper";
        r4 = "request : %s";
        r5 = new java.lang.Object[r12];
        r5[r3] = r15;
        com.tencent.mm.sdk.platformtools.v.i(r1, r4, r5);
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = r15.dMN;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1.setConnectTimeout(r4);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r15.iaI;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        if (r1 != 0) goto L_0x012f;
    L_0x001d:
        r1 = "GET";
    L_0x0020:
        r4.setRequestMethod(r1);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r15.iaI;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        if (r1 != r12) goto L_0x0033;
    L_0x0027:
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = 1;
        r1.setDoInput(r4);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = 1;
        r1.setDoOutput(r4);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
    L_0x0033:
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = 0;
        r1.setUseCaches(r4);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = "User-Agent";
        r5 = "weixin/android";
        r1.setRequestProperty(r4, r5);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = "Host";
        r5 = r15.host;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1.setRequestProperty(r4, r5);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = "http.keepAlive";
        r4 = "false";
        java.lang.System.setProperty(r1, r4);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = "Accept-Charset";
        r5 = "utf-8";
        r1.setRequestProperty(r4, r5);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = "Accept-Encoding";
        r5 = "compress;q=0.5, gzip;q=1.0";
        r1.setRequestProperty(r4, r5);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r5 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r6 = "Cookie";
        r7 = r15.iaK;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        if (r7 == 0) goto L_0x007c;
    L_0x0076:
        r1 = r7.size();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        if (r1 != 0) goto L_0x0134;
    L_0x007c:
        r1 = "";
    L_0x007f:
        r5.setRequestProperty(r6, r1);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1.connect();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r15.iaI;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        if (r1 != r12) goto L_0x0284;
    L_0x008b:
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = r1.getOutputStream();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        a(r15, r4);	 Catch:{ Exception -> 0x0267, all -> 0x0255 }
        r4.flush();	 Catch:{ Exception -> 0x0267, all -> 0x0255 }
        r6 = r4;
    L_0x0098:
        r1 = r14.nhB;	 Catch:{ Exception -> 0x026d, all -> 0x0259 }
        r4 = r1.getResponseCode();	 Catch:{ Exception -> 0x026d, all -> 0x0259 }
        r1 = r14.nhB;	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        r5 = "set-cookie";
        r1 = r1.getHeaderField(r5);	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        r5 = r14.nhB;	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        r7 = "Content-Encoding";
        r5 = r5.getHeaderField(r7);	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        r7 = r14.nhB;	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        r8 = "Content-Disposition";
        r7.getHeaderField(r8);	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        r7 = r14.nhB;	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        r2 = r7.getInputStream();	 Catch:{ Exception -> 0x0273, all -> 0x0259 }
        if (r5 == 0) goto L_0x0281;
    L_0x00c0:
        r7 = "gzip";
        r5 = r5.contains(r7);	 Catch:{ Exception -> 0x027a, all -> 0x0259 }
        if (r5 == 0) goto L_0x0281;
    L_0x00c9:
        r5 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x027a, all -> 0x0259 }
        r5.<init>(r2);	 Catch:{ Exception -> 0x027a, all -> 0x0259 }
    L_0x00ce:
        r0 = r16;
        r2 = r0.nhH;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        if (r2 == 0) goto L_0x0185;
    L_0x00d4:
        r0 = r16;
        r2 = r0.nhH;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2 = r2.filePath;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        if (r2 == 0) goto L_0x0185;
    L_0x00e0:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r0 = r16;
        r2 = r0.nhH;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2 = r2.filePath;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r7.<init>(r2);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r8 = 1;
        r2.<init>(r7, r8);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
    L_0x00f1:
        r7 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r7 = new byte[r7];	 Catch:{ Exception -> 0x0103, all -> 0x018c }
    L_0x00f5:
        r8 = r5.read(r7);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        if (r8 <= 0) goto L_0x01a2;
    L_0x00fb:
        r9 = 0;
        r2.write(r7, r9, r8);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2.flush();	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        goto L_0x00f5;
    L_0x0103:
        r1 = move-exception;
        r2 = r4;
        r4 = r5;
        r5 = r6;
    L_0x0107:
        r6 = "MicroMsg.HttpURLConnectionWrapper";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x025c }
        com.tencent.mm.sdk.platformtools.v.a(r6, r1, r7, r8);	 Catch:{ all -> 0x025c }
        if (r2 != 0) goto L_0x0215;
    L_0x0115:
        r1 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x0117:
        r0 = r16;
        r0.status = r1;	 Catch:{ all -> 0x025c }
        if (r5 == 0) goto L_0x0120;
    L_0x011d:
        r5.close();	 Catch:{ IOException -> 0x0219 }
    L_0x0120:
        if (r4 == 0) goto L_0x0125;
    L_0x0122:
        r4.close();	 Catch:{ IOException -> 0x0227 }
    L_0x0125:
        r1 = r14.nhB;
        if (r1 == 0) goto L_0x012e;
    L_0x0129:
        r1 = r14.nhB;
        r1.disconnect();
    L_0x012e:
        return;
    L_0x012f:
        r1 = "POST";
        goto L_0x0020;
    L_0x0134:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r8.<init>();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r7.keySet();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r9 = r1.iterator();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r4 = r3;
    L_0x0142:
        r1 = r9.hasNext();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        if (r1 == 0) goto L_0x017f;
    L_0x0148:
        r1 = r9.next();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r10 = "utf-8";
        r10 = java.net.URLEncoder.encode(r1, r10);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r10 = r8.append(r10);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r11 = 61;
        r10 = r10.append(r11);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r7.get(r1);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r11 = "utf-8";
        r1 = java.net.URLEncoder.encode(r1, r11);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r10.append(r1);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        r1 = r4 + 1;
        r4 = r7.size();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        if (r4 <= r1) goto L_0x017d;
    L_0x0177:
        r4 = "; ";
        r8.append(r4);	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
    L_0x017d:
        r4 = r1;
        goto L_0x0142;
    L_0x017f:
        r1 = r8.toString();	 Catch:{ Exception -> 0x0261, all -> 0x0251 }
        goto L_0x007f;
    L_0x0185:
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2.<init>();	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        goto L_0x00f1;
    L_0x018c:
        r1 = move-exception;
        r2 = r5;
    L_0x018e:
        if (r6 == 0) goto L_0x0193;
    L_0x0190:
        r6.close();	 Catch:{ IOException -> 0x0235 }
    L_0x0193:
        if (r2 == 0) goto L_0x0198;
    L_0x0195:
        r2.close();	 Catch:{ IOException -> 0x0243 }
    L_0x0198:
        r2 = r14.nhB;
        if (r2 == 0) goto L_0x01a1;
    L_0x019c:
        r2 = r14.nhB;
        r2.disconnect();
    L_0x01a1:
        throw r1;
    L_0x01a2:
        r0 = r16;
        r0.status = r4;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r1 = com.tencent.mm.sdk.d.b.xZ(r1);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r0 = r16;
        r0.iaK = r1;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r1 = r2 instanceof java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        if (r1 == 0) goto L_0x01f7;
    L_0x01b2:
        r7 = new java.lang.String;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r0 = r2;
        r0 = (java.io.ByteArrayOutputStream) r0;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r1 = r0;
        r1 = r1.toByteArray();	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r7.<init>(r1);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r1 = r7;
    L_0x01c0:
        r0 = r16;
        r0.content = r1;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2.flush();	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2.close();	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r1 = "MicroMsg.HttpURLConnectionWrapper";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r7 = "Response: %s";
        r2.<init>(r7);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        com.tencent.mm.sdk.platformtools.v.d(r1, r2);	 Catch:{ Exception -> 0x0103, all -> 0x018c }
        if (r6 == 0) goto L_0x01e7;
    L_0x01e4:
        r6.close();	 Catch:{ IOException -> 0x01fb }
    L_0x01e7:
        if (r5 == 0) goto L_0x01ec;
    L_0x01e9:
        r5.close();	 Catch:{ IOException -> 0x0208 }
    L_0x01ec:
        r1 = r14.nhB;
        if (r1 == 0) goto L_0x012e;
    L_0x01f0:
        r1 = r14.nhB;
        r1.disconnect();
        goto L_0x012e;
    L_0x01f7:
        r1 = "";
        goto L_0x01c0;
    L_0x01fb:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r4 = "";
        r6 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r4, r6);
        goto L_0x01e7;
    L_0x0208:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r4 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r4, r3);
        goto L_0x01ec;
    L_0x0215:
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        goto L_0x0117;
    L_0x0219:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r5 = "";
        r6 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r5, r6);
        goto L_0x0120;
    L_0x0227:
        r1 = move-exception;
        r2 = "MicroMsg.HttpURLConnectionWrapper";
        r4 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r4, r3);
        goto L_0x0125;
    L_0x0235:
        r4 = move-exception;
        r5 = "MicroMsg.HttpURLConnectionWrapper";
        r6 = "";
        r7 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r5, r4, r6, r7);
        goto L_0x0193;
    L_0x0243:
        r2 = move-exception;
        r4 = "MicroMsg.HttpURLConnectionWrapper";
        r5 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r4, r2, r5, r3);
        goto L_0x0198;
    L_0x0251:
        r1 = move-exception;
        r6 = r2;
        goto L_0x018e;
    L_0x0255:
        r1 = move-exception;
        r6 = r4;
        goto L_0x018e;
    L_0x0259:
        r1 = move-exception;
        goto L_0x018e;
    L_0x025c:
        r1 = move-exception;
        r2 = r4;
        r6 = r5;
        goto L_0x018e;
    L_0x0261:
        r1 = move-exception;
        r4 = r2;
        r5 = r2;
        r2 = r3;
        goto L_0x0107;
    L_0x0267:
        r1 = move-exception;
        r5 = r4;
        r4 = r2;
        r2 = r3;
        goto L_0x0107;
    L_0x026d:
        r1 = move-exception;
        r4 = r2;
        r5 = r6;
        r2 = r3;
        goto L_0x0107;
    L_0x0273:
        r1 = move-exception;
        r5 = r6;
        r13 = r2;
        r2 = r4;
        r4 = r13;
        goto L_0x0107;
    L_0x027a:
        r1 = move-exception;
        r5 = r6;
        r13 = r2;
        r2 = r4;
        r4 = r13;
        goto L_0x0107;
    L_0x0281:
        r5 = r2;
        goto L_0x00ce;
    L_0x0284:
        r6 = r2;
        goto L_0x0098;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.d.a.a(com.tencent.mm.sdk.d.b$b, com.tencent.mm.sdk.d.b$c):void");
    }

    private static void a(b bVar, OutputStream outputStream) {
        if (bVar.iaJ != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (String str : bVar.iaJ.keySet()) {
                stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode((String) bVar.iaJ.get(str), "utf-8"));
                obj = null;
            }
            outputStream.write(stringBuilder.toString().getBytes());
        }
    }
}
