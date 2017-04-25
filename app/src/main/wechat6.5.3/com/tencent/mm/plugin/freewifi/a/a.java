package com.tencent.mm.plugin.freewifi.a;

import java.net.HttpURLConnection;

public final class a {
    private static final int fXV = b.fWU.aor();
    private static final int fXW = b.fWU.aos();

    public interface a {
        void c(HttpURLConnection httpURLConnection);

        void h(Exception exception);
    }

    private static class b {
        private static a fXX = new a();
    }

    private a() {
    }

    public static a aoH() {
        return b.fXX;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r5, com.tencent.mm.plugin.freewifi.a.a.a r6) {
        /*
        r3 = 0;
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r1 = "method=request, desc=it starts a http GET request. url=%s.";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.freewifi.m.ty(r5);
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r1 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0070 }
        r0.<init>(r5);	 Catch:{ Exception -> 0x0070 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0070 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0070 }
        if (r0 == 0) goto L_0x0047;
    L_0x0024:
        r1 = fXV;	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r1 = fXW;	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r1 = "User-Agent";
        r2 = com.tencent.mm.plugin.freewifi.h.b.fWU;	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r2 = r2.getUserAgent();	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r0.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r1 = 0;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        r6.c(r0);	 Catch:{ IOException -> 0x004d, Exception -> 0x005f, all -> 0x0064 }
    L_0x0047:
        if (r0 == 0) goto L_0x0015;
    L_0x0049:
        r0.disconnect();
        goto L_0x0015;
    L_0x004d:
        r1 = move-exception;
        r6.h(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        goto L_0x0047;
    L_0x0052:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0056:
        r6.h(r0);	 Catch:{ all -> 0x006e }
        if (r1 == 0) goto L_0x0015;
    L_0x005b:
        r1.disconnect();
        goto L_0x0015;
    L_0x005f:
        r1 = move-exception;
        r6.h(r1);	 Catch:{ Exception -> 0x0052, all -> 0x0064 }
        goto L_0x0047;
    L_0x0064:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0068:
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.disconnect();
    L_0x006d:
        throw r0;
    L_0x006e:
        r0 = move-exception;
        goto L_0x0068;
    L_0x0070:
        r0 = move-exception;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.a.a.a(java.lang.String, com.tencent.mm.plugin.freewifi.a.a$a):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r13, java.lang.String r14, com.tencent.mm.plugin.freewifi.a.a.a r15) {
        /*
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r1 = "method=requestPost, desc=it starts a http POST request. url=%s, postParams=%s.";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r13;
        r3 = 1;
        r2[r3] = r14;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = com.tencent.mm.plugin.freewifi.m.ty(r13);
        if (r0 != 0) goto L_0x001e;
    L_0x0018:
        r0 = com.tencent.mm.plugin.freewifi.m.ty(r14);
        if (r0 == 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        if (r14 == 0) goto L_0x002a;
    L_0x0021:
        r0 = "";
        r0 = r0.equalsIgnoreCase(r14);
        if (r0 == 0) goto L_0x00bc;
    L_0x002a:
        r0 = "";
        r1 = r0;
    L_0x002e:
        r0 = "MicroMsg.FreeWifi.HttpTemplate";
        r2 = "method=requestPost, desc=it extracts PostParams. url=%s, postParams=%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r13;
        r4 = 1;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x01aa, all -> 0x01a5 }
        r0.<init>(r13);	 Catch:{ Exception -> 0x01aa, all -> 0x01a5 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x01aa, all -> 0x01a5 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x01aa, all -> 0x01a5 }
        if (r0 == 0) goto L_0x00b5;
    L_0x004e:
        r2 = fXV;	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = fXW;	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = "User-Agent";
        r3 = com.tencent.mm.plugin.freewifi.h.b.fWU;	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r3 = r3.getUserAgent();	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = 0;
        r0.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = "POST";
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = "Content-Type";
        r3 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = "charset";
        r3 = "utf-8";
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = 0;
        r0.setUseCaches(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = "UTF-8";
        r2 = java.nio.charset.Charset.forName(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r1 = r1.getBytes(r2);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = "Content-Length";
        r3 = r1.length;	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2.write(r1);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2.flush();	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r2.close();	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        r15.c(r0);	 Catch:{ IOException -> 0x0182, Exception -> 0x0196, all -> 0x019c }
    L_0x00b5:
        if (r0 == 0) goto L_0x001e;
    L_0x00b7:
        r0.disconnect();
        goto L_0x001e;
    L_0x00bc:
        r2 = "";
        r0 = "&";
        r5 = r14.split(r0);
        r0 = 1;
        r4 = r0;
    L_0x00c8:
        r0 = 10;
        if (r4 > r0) goto L_0x017f;
    L_0x00cc:
        r0 = new java.lang.StringBuilder;
        r1 = "key";
        r0.<init>(r1);
        r0 = r0.append(r4);
        r6 = r0.toString();
        r0 = new java.lang.StringBuilder;
        r1 = "value";
        r0.<init>(r1);
        r0 = r0.append(r4);
        r7 = r0.toString();
        r3 = 0;
        r1 = 0;
        r8 = r5.length;
        r0 = 0;
        r12 = r0;
        r0 = r1;
        r1 = r3;
        r3 = r12;
    L_0x00f4:
        if (r3 >= r8) goto L_0x0132;
    L_0x00f6:
        r9 = r5[r3];
        r10 = r9.indexOf(r6);
        if (r10 < 0) goto L_0x0116;
    L_0x00fe:
        r10 = "=";
        r10 = r9.split(r10);
        r10 = r10.length;
        r11 = 2;
        if (r10 != r11) goto L_0x0116;
    L_0x0109:
        r1 = "=";
        r1 = r9.split(r1);
        r9 = 1;
        r1 = r1[r9];
    L_0x0113:
        r3 = r3 + 1;
        goto L_0x00f4;
    L_0x0116:
        r10 = r9.indexOf(r7);
        if (r10 < 0) goto L_0x0113;
    L_0x011c:
        r10 = "=";
        r10 = r9.split(r10);
        r10 = r10.length;
        r11 = 2;
        if (r10 != r11) goto L_0x0113;
    L_0x0127:
        r0 = "=";
        r0 = r9.split(r0);
        r9 = 1;
        r0 = r0[r9];
        goto L_0x0113;
    L_0x0132:
        if (r1 == 0) goto L_0x017f;
    L_0x0134:
        if (r0 == 0) goto L_0x017f;
    L_0x0136:
        r3 = 1;
        if (r4 != r3) goto L_0x015b;
    L_0x0139:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r1 = r2.append(r1);
        r2 = "=";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
    L_0x0155:
        r1 = r4 + 1;
        r4 = r1;
        r2 = r0;
        goto L_0x00c8;
    L_0x015b:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = "&";
        r2 = r2.append(r3);
        r1 = r2.append(r1);
        r2 = "=";
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        goto L_0x0155;
    L_0x017f:
        r1 = r2;
        goto L_0x002e;
    L_0x0182:
        r1 = move-exception;
        r15.h(r1);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        goto L_0x00b5;
    L_0x0188:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x018c:
        r15.h(r0);	 Catch:{ all -> 0x01a7 }
        if (r1 == 0) goto L_0x001e;
    L_0x0191:
        r1.disconnect();
        goto L_0x001e;
    L_0x0196:
        r1 = move-exception;
        r15.h(r1);	 Catch:{ Exception -> 0x0188, all -> 0x019c }
        goto L_0x00b5;
    L_0x019c:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x019f:
        if (r2 == 0) goto L_0x01a4;
    L_0x01a1:
        r2.disconnect();
    L_0x01a4:
        throw r0;
    L_0x01a5:
        r0 = move-exception;
        goto L_0x019f;
    L_0x01a7:
        r0 = move-exception;
        r2 = r1;
        goto L_0x019f;
    L_0x01aa:
        r0 = move-exception;
        r1 = r2;
        goto L_0x018c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.a.a.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.freewifi.a.a$a):void");
    }
}
