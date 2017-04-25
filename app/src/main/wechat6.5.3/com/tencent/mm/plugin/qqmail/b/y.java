package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.t;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.OutputStream;
import java.net.URLEncoder;

public final class y extends h {
    private t ick;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.qqmail.b.h.c a(java.lang.String r15, java.lang.String r16, com.tencent.mm.plugin.qqmail.b.h.b r17, com.tencent.mm.plugin.qqmail.b.h.a r18) {
        /*
        r14 = this;
        r2 = "MicroMsg.URLConnectionUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "uri=";
        r3.<init>(r4);
        r0 = r16;
        r3 = r3.append(r0);
        r4 = ", ";
        r3 = r3.append(r4);
        r0 = r17;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r0 = r17;
        r2 = r0.iaI;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        if (r2 != 0) goto L_0x0187;
    L_0x002e:
        r0 = r17;
        r2 = r0.iaJ;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
    L_0x0032:
        r0 = r16;
        r2 = com.tencent.mm.plugin.qqmail.b.h.b(r15, r0, r2);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = 0;
        r2 = com.tencent.mm.network.b.a(r2, r6);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r14.ick = r2;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = dMN;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2.setConnectTimeout(r6);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r0 = r17;
        r2 = r0.iaI;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        if (r2 != 0) goto L_0x018a;
    L_0x004e:
        r2 = "GET";
    L_0x0051:
        r6.setRequestMethod(r2);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2.Mj();	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2.Mk();	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = 0;
        r2.setUseCaches(r6);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = "User-Agent";
        r7 = fWL;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = "Host";
        r7 = host;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = "http.keepAlive";
        r6 = "false";
        java.lang.System.setProperty(r2, r6);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = "Accept-Charset";
        r7 = "utf-8";
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = "Accept-Encoding";
        r7 = "compress;q=0.5, gzip;q=1.0";
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r6 = "Cookie";
        r0 = r17;
        r7 = r0.iaK;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r7 = com.tencent.mm.plugin.qqmail.b.h.y(r7);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2.setRequestProperty(r6, r7);	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2.connect();	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r2 = r14.ick;	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r7 = r2.getOutputStream();	 Catch:{ Exception -> 0x0288, all -> 0x0279 }
        r0 = r17;
        r2 = r0.iaI;	 Catch:{ Exception -> 0x028b, all -> 0x027d }
        r5 = 1;
        if (r2 != r5) goto L_0x00be;
    L_0x00b9:
        r0 = r17;
        a(r0, r7);	 Catch:{ Exception -> 0x028b, all -> 0x027d }
    L_0x00be:
        r7.flush();	 Catch:{ Exception -> 0x028b, all -> 0x027d }
        r2 = r14.ick;	 Catch:{ Exception -> 0x028b, all -> 0x027d }
        r5 = r2.getResponseCode();	 Catch:{ Exception -> 0x028b, all -> 0x027d }
        r2 = r14.ick;	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        r3 = "set-cookie";
        r9 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        r2 = r14.ick;	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        r3 = "Content-Encoding";
        r6 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        r2 = r14.ick;	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        r3 = "Content-Disposition";
        r2 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        if (r2 == 0) goto L_0x018f;
    L_0x00e4:
        r3 = "attachment;";
        r2 = r2.contains(r3);	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        if (r2 == 0) goto L_0x018f;
    L_0x00ed:
        r2 = "download";
        r0 = r16;
        r2 = r0.contains(r2);	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        if (r2 == 0) goto L_0x018f;
    L_0x00f8:
        r2 = 1;
        r8 = r2;
    L_0x00fa:
        r2 = r14.ick;	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        r3 = r2.getInputStream();	 Catch:{ Exception -> 0x028f, all -> 0x027d }
        if (r6 == 0) goto L_0x029a;
    L_0x0102:
        r2 = "gzip";
        r2 = r6.contains(r2);	 Catch:{ Exception -> 0x0294, all -> 0x0280 }
        if (r2 == 0) goto L_0x029a;
    L_0x010b:
        r6 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0294, all -> 0x0280 }
        r6.<init>(r3);	 Catch:{ Exception -> 0x0294, all -> 0x0280 }
    L_0x0110:
        if (r8 == 0) goto L_0x01a1;
    L_0x0112:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3 = iaH;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r10.<init>();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r0 = r17;
        r2 = r0.iaJ;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r11 = "default_attach_name";
        r2 = r2.get(r11);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        if (r2 != 0) goto L_0x0193;
    L_0x0128:
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r2 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
    L_0x0130:
        r2 = r10.append(r2);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r4.<init>(r3, r2);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r2 = 1;
        r3.<init>(r4, r2);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
    L_0x0141:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
    L_0x0145:
        r4 = r6.read(r2);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        if (r4 <= 0) goto L_0x01bf;
    L_0x014b:
        r10 = 0;
        r3.write(r2, r10, r4);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3.flush();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r18.aHu();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        goto L_0x0145;
    L_0x0156:
        r2 = move-exception;
        r3 = r5;
        r4 = r6;
        r5 = r7;
    L_0x015a:
        r6 = "MicroMsg.URLConnectionUtil";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0284 }
        com.tencent.mm.sdk.platformtools.v.a(r6, r2, r7, r8);	 Catch:{ all -> 0x0284 }
        r2 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ all -> 0x0284 }
        if (r3 != 0) goto L_0x0239;
    L_0x016a:
        r3 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
    L_0x016c:
        r6 = 0;
        r7 = 0;
        r2.<init>(r3, r6, r7);	 Catch:{ all -> 0x0284 }
        if (r5 == 0) goto L_0x0176;
    L_0x0173:
        r5.close();	 Catch:{ IOException -> 0x023d }
    L_0x0176:
        if (r4 == 0) goto L_0x017b;
    L_0x0178:
        r4.close();	 Catch:{ IOException -> 0x024c }
    L_0x017b:
        r3 = r14.ick;
        if (r3 == 0) goto L_0x0186;
    L_0x017f:
        r3 = r14.ick;
        r3 = r3.dmc;
        r3.disconnect();
    L_0x0186:
        return r2;
    L_0x0187:
        r2 = 0;
        goto L_0x0032;
    L_0x018a:
        r2 = "POST";
        goto L_0x0051;
    L_0x018f:
        r2 = 0;
        r8 = r2;
        goto L_0x00fa;
    L_0x0193:
        r0 = r17;
        r2 = r0.iaJ;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r11 = "default_attach_name";
        r2 = r2.get(r11);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r2 = (java.io.Serializable) r2;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        goto L_0x0130;
    L_0x01a1:
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3.<init>();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        goto L_0x0141;
    L_0x01a7:
        r2 = move-exception;
        r4 = r6;
    L_0x01a9:
        if (r7 == 0) goto L_0x01ae;
    L_0x01ab:
        r7.close();	 Catch:{ IOException -> 0x025b }
    L_0x01ae:
        if (r4 == 0) goto L_0x01b3;
    L_0x01b0:
        r4.close();	 Catch:{ IOException -> 0x026a }
    L_0x01b3:
        r3 = r14.ick;
        if (r3 == 0) goto L_0x01be;
    L_0x01b7:
        r3 = r14.ick;
        r3 = r3.dmc;
        r3.disconnect();
    L_0x01be:
        throw r2;
    L_0x01bf:
        r4 = new com.tencent.mm.plugin.qqmail.b.h$c;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r9 = com.tencent.mm.plugin.qqmail.b.h.xZ(r9);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        if (r8 == 0) goto L_0x020e;
    L_0x01c7:
        r2 = "";
    L_0x01ca:
        r4.<init>(r5, r9, r2);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3.flush();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3.close();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r2 = "MicroMsg.URLConnectionUtil";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r8 = "uri=";
        r3.<init>(r8);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r0 = r16;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r8 = ", ";
        r3 = r3.append(r8);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        if (r7 == 0) goto L_0x01fb;
    L_0x01f8:
        r7.close();	 Catch:{ IOException -> 0x021d }
    L_0x01fb:
        if (r6 == 0) goto L_0x0200;
    L_0x01fd:
        r6.close();	 Catch:{ IOException -> 0x022b }
    L_0x0200:
        r2 = r14.ick;
        if (r2 == 0) goto L_0x020b;
    L_0x0204:
        r2 = r14.ick;
        r2 = r2.dmc;
        r2.disconnect();
    L_0x020b:
        r2 = r4;
        goto L_0x0186;
    L_0x020e:
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r0 = r3;
        r0 = (java.io.ByteArrayOutputStream) r0;	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r2 = r0;
        r2 = r2.toByteArray();	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r8.<init>(r2);	 Catch:{ Exception -> 0x0156, all -> 0x01a7 }
        r2 = r8;
        goto L_0x01ca;
    L_0x021d:
        r2 = move-exception;
        r3 = "MicroMsg.URLConnectionUtil";
        r5 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r5, r7);
        goto L_0x01fb;
    L_0x022b:
        r2 = move-exception;
        r3 = "MicroMsg.URLConnectionUtil";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r5, r6);
        goto L_0x0200;
    L_0x0239:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        goto L_0x016c;
    L_0x023d:
        r3 = move-exception;
        r5 = "MicroMsg.URLConnectionUtil";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r5, r3, r6, r7);
        goto L_0x0176;
    L_0x024c:
        r3 = move-exception;
        r4 = "MicroMsg.URLConnectionUtil";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x017b;
    L_0x025b:
        r3 = move-exception;
        r5 = "MicroMsg.URLConnectionUtil";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r5, r3, r6, r7);
        goto L_0x01ae;
    L_0x026a:
        r3 = move-exception;
        r4 = "MicroMsg.URLConnectionUtil";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x01b3;
    L_0x0279:
        r2 = move-exception;
        r7 = r5;
        goto L_0x01a9;
    L_0x027d:
        r2 = move-exception;
        goto L_0x01a9;
    L_0x0280:
        r2 = move-exception;
        r4 = r3;
        goto L_0x01a9;
    L_0x0284:
        r2 = move-exception;
        r7 = r5;
        goto L_0x01a9;
    L_0x0288:
        r2 = move-exception;
        goto L_0x015a;
    L_0x028b:
        r2 = move-exception;
        r5 = r7;
        goto L_0x015a;
    L_0x028f:
        r2 = move-exception;
        r3 = r5;
        r5 = r7;
        goto L_0x015a;
    L_0x0294:
        r2 = move-exception;
        r4 = r3;
        r3 = r5;
        r5 = r7;
        goto L_0x015a;
    L_0x029a:
        r6 = r3;
        goto L_0x0110;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.b.y.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.qqmail.b.h$b, com.tencent.mm.plugin.qqmail.b.h$a):com.tencent.mm.plugin.qqmail.b.h$c");
    }

    public final void cancel() {
        v.d("MicroMsg.URLConnectionUtil", "cancel conection.");
        if (this.ick != null) {
            this.ick.dmc.disconnect();
        }
    }

    private static void a(b bVar, OutputStream outputStream) {
        if (bVar.iaJ != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (String str : bVar.iaJ.keySet()) {
                stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) bVar.iaJ.get(str), ProtocolPackage.ServerEncoding));
                obj = null;
            }
            outputStream.write(stringBuilder.toString().getBytes());
        }
    }
}
