package com.tencent.mm.plugin.appbrand.g.a;

import java.util.ArrayList;
import java.util.Map;

public final class b implements Runnable {
    public volatile boolean aHp = false;
    private final a dML;
    public Map<String, String> dMM;
    public int dMN = 60000;
    public volatile int dMO;
    public ArrayList<String> dMv;
    private int dMw = 15;
    private String filename;
    public String uri;

    public b(String str, String str2, a aVar) {
        this.uri = str;
        this.filename = str2;
        this.dML = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r19 = this;
        r0 = r19;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpsUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x000a:
        r0 = r19;
        r2 = r0.uri;
        r2 = android.webkit.URLUtil.isHttpUrl(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x0014:
        r0 = r19;
        r2 = r0.dML;
        r0 = r19;
        r3 = r0.filename;
        r0 = r19;
        r4 = r0.uri;
        r5 = "downloadFile protocol must be http or https";
        r2.w(r3, r4, r5);
    L_0x0026:
        return;
    L_0x0027:
        r0 = r19;
        r2 = r0.dMv;
        if (r2 == 0) goto L_0x0061;
    L_0x002d:
        r0 = r19;
        r2 = r0.dMv;
        r0 = r19;
        r3 = r0.uri;
        r2 = com.tencent.mm.plugin.appbrand.g.i.b(r2, r3);
        if (r2 != 0) goto L_0x0061;
    L_0x003b:
        r0 = r19;
        r2 = r0.dML;
        r0 = r19;
        r3 = r0.filename;
        r0 = r19;
        r4 = r0.uri;
        r5 = "url not in domain list";
        r2.w(r3, r4, r5);
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r19;
        r6 = r0.uri;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        goto L_0x0026;
    L_0x0061:
        r0 = r19;
        r2 = r0.aHp;
        if (r2 != 0) goto L_0x007a;
    L_0x0067:
        r0 = r19;
        r2 = r0.dML;
        r0 = r19;
        r3 = r0.filename;
        r0 = r19;
        r4 = r0.uri;
        r5 = "force stop";
        r2.w(r3, r4, r5);
        goto L_0x0026;
    L_0x007a:
        r0 = r19;
        r2 = r0.dML;
        r0 = r19;
        r3 = r0.filename;
        r0 = r19;
        r4 = r0.uri;
        r2.aN(r3, r4);
        r13 = 0;
        r12 = 0;
        r11 = 0;
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 0;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r8 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r0 = r19;
        r2 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r8.<init>(r2);	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r2 = "MicroMsg.AppBrandDownloadWorker";
        r3 = "url is %s ,filename is %s , start download";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r5 = 0;
        r0 = r19;
        r6 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r5 = 1;
        r0 = r19;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r4[r5] = r6;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r2 = r8.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x07b7, FileNotFoundException -> 0x0566, SSLHandshakeException -> 0x05d8, SocketTimeoutException -> 0x064a, Exception -> 0x06bc }
        r3 = 1;
        r2.setDoInput(r3);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r3 = r0.dMN;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r2.setConnectTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r3 = r0.dMN;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r2.setReadTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r3 = 0;
        r2.setInstanceFollowRedirects(r3);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r3 = r0.dMM;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r3 == 0) goto L_0x018d;
    L_0x00dd:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url %s : set header ";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6 = 0;
        r5[r6] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r3 = r0.dMM;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r3 = r3.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6 = r3.iterator();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
    L_0x00f8:
        r3 = r6.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r3 == 0) goto L_0x018d;
    L_0x00fe:
        r3 = r6.next();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = r3.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r5 = r3.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r5 = (java.lang.String) r5;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r2.setRequestProperty(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "filename %s : key:%s ,value %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r9 = 0;
        r0 = r19;
        r10 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r9 = 1;
        r10 = r3.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r9 = 2;
        r3 = r3.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7[r9] = r3;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r7);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        goto L_0x00f8;
    L_0x0135:
        r3 = move-exception;
        r11 = r2;
        r2 = r3;
    L_0x0138:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x072e }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 1;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x072e }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x072e }
        r6 = 0;
        r0 = r19;
        r7 = r0.uri;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 1;
        r0 = r19;
        r7 = r0.filename;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x072e }
        r5[r6] = r2;	 Catch:{ all -> 0x072e }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r0 = r19;
        r2 = r0.dML;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r3 = r0.filename;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r4 = r0.uri;	 Catch:{ all -> 0x072e }
        r5 = "unsupport encoding error";
        r2.w(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r2 = 0;
        r0 = r19;
        r0.aHp = r2;
        if (r13 == 0) goto L_0x0181;
    L_0x017e:
        r13.close();	 Catch:{ IOException -> 0x0548 }
    L_0x0181:
        if (r12 == 0) goto L_0x0186;
    L_0x0183:
        r12.close();	 Catch:{ IOException -> 0x0557 }
    L_0x0186:
        if (r11 == 0) goto L_0x0026;
    L_0x0188:
        r11.disconnect();
        goto L_0x0026;
    L_0x018d:
        r3 = "User-Agent";
        r4 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r5 = "";
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.aW(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r3 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r10 = (long) r3;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6 = 0;
        r3 = "Content-Type";
        r3 = r2.getHeaderField(r3);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r5 = com.tencent.mm.pluginsdk.ui.tools.s.a.Ik(r3);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r5 != 0) goto L_0x0237;
    L_0x01b6:
        r3 = com.tencent.mm.pluginsdk.ui.tools.s.Ih(r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
    L_0x01ba:
        r4 = r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r8 = java.lang.Integer.toString(r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 == r5) goto L_0x0284;
    L_0x01c6:
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r9 = "statusCode %s, url is %s ,filename is %s ";
        r14 = 3;
        r14 = new java.lang.Object[r14];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r15 = 0;
        r16 = java.lang.Integer.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r14[r15] = r16;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r15 = 1;
        r0 = r19;
        r0 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r16 = r0;
        r14[r15] = r16;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r15 = 2;
        r0 = r19;
        r0 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r16 = r0;
        r14[r15] = r16;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.e(r5, r9, r14);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = com.tencent.mm.plugin.appbrand.g.i.hg(r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r4 == 0) goto L_0x0284;
    L_0x01f1:
        r4 = com.tencent.mm.plugin.appbrand.g.i.b(r2);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r5 != 0) goto L_0x0284;
    L_0x01fb:
        r0 = r19;
        r5 = r0.dMw;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6 = r5 + -1;
        r0 = r19;
        r0.dMw = r6;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r5 > 0) goto L_0x0250;
    L_0x0207:
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "reach the max redirect count(%d)";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7 = 0;
        r9 = 15;
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6[r7] = r9;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.w(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r4 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r5 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r6 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4.e(r5, r3, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        if (r2 == 0) goto L_0x0026;
    L_0x0232:
        r2.disconnect();
        goto L_0x0026;
    L_0x0237:
        r3 = r5.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r8 = "application/octet-stream";
        r3 = r3.contains(r8);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r3 == 0) goto L_0x024c;
    L_0x0242:
        r3 = com.tencent.mm.pluginsdk.ui.tools.s.Ih(r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r3);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r4 == 0) goto L_0x01ba;
    L_0x024c:
        r3 = r5.mimeType;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        goto L_0x01ba;
    L_0x0250:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "redirect(%d) URL(%s) to URL(%s)";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7 = 0;
        r0 = r19;
        r8 = r0.dMw;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7 = 1;
        r0 = r19;
        r8 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7 = 2;
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r0.uri = r4;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r19.run();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        if (r2 == 0) goto L_0x0026;
    L_0x027f:
        r2.disconnect();
        goto L_0x0026;
    L_0x0284:
        r4 = r2.getContentLength();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r4 <= 0) goto L_0x02ca;
    L_0x028a:
        r0 = r19;
        r5 = r0.dMO;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        if (r5 <= 0) goto L_0x02ca;
    L_0x0290:
        r0 = r19;
        r5 = r0.dMO;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r9 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r5 = r5 * r9;
        if (r4 < r5) goto L_0x02ca;
    L_0x0299:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "before actually read stream, contentLength %d exceed limit";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r7 = 0;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6[r7] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r3 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r4 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r0 = r19;
        r5 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r6 = "exceed max file size";
        r3.w(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        if (r2 == 0) goto L_0x0026;
    L_0x02c5:
        r2.disconnect();
        goto L_0x0026;
    L_0x02ca:
        r4 = r2.getInputStream();	 Catch:{ Exception -> 0x032e, UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, all -> 0x0760 }
    L_0x02ce:
        r9 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r0 = r19;
        r5 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r9.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r5 = r9.exists();	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        if (r5 == 0) goto L_0x0368;
    L_0x02dd:
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r12 = "exists temp file ,filename is %s ";
        r14 = 1;
        r14 = new java.lang.Object[r14];	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r15 = 0;
        r0 = r19;
        r0 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r16 = r0;
        r14[r15] = r16;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        com.tencent.mm.sdk.platformtools.v.i(r5, r12, r14);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r5 = r9.delete();	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        if (r5 != 0) goto L_0x0368;
    L_0x02f8:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "exists temp file delete failed, filename is %s ";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r7 = 0;
        r0 = r19;
        r8 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r0 = r19;
        r3 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r0 = r19;
        r5 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r0 = r19;
        r6 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r7 = "exists temp file delete failed";
        r3.w(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        if (r4 == 0) goto L_0x0327;
    L_0x0324:
        r4.close();	 Catch:{ IOException -> 0x035a }
    L_0x0327:
        if (r2 == 0) goto L_0x0026;
    L_0x0329:
        r2.disconnect();
        goto L_0x0026;
    L_0x032e:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r9 = "getInputStream error : %s";
        r14 = 1;
        r14 = new java.lang.Object[r14];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r15 = 0;
        r14[r15] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.e(r5, r9, r14);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = r2.getErrorStream();	 Catch:{ Exception -> 0x0343, UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, all -> 0x0760 }
        goto L_0x02ce;
    L_0x0343:
        r4 = move-exception;
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r9 = "read err stream failed : %s";
        r14 = 1;
        r14 = new java.lang.Object[r14];	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r15 = 0;
        r4 = r4.toString();	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r14[r15] = r4;	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        com.tencent.mm.sdk.platformtools.v.e(r5, r9, r14);	 Catch:{ UnsupportedEncodingException -> 0x0135, FileNotFoundException -> 0x07a5, SSLHandshakeException -> 0x0793, SocketTimeoutException -> 0x0781, Exception -> 0x076f, all -> 0x0760 }
        r4 = r12;
        goto L_0x02ce;
    L_0x035a:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x0327;
    L_0x0368:
        r5 = r9.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r5 = r5.exists();	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        if (r5 != 0) goto L_0x03d5;
    L_0x0372:
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r12 = "create file ,filename is %s ";
        r14 = 1;
        r14 = new java.lang.Object[r14];	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r15 = 0;
        r0 = r19;
        r0 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r16 = r0;
        r14[r15] = r16;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        com.tencent.mm.sdk.platformtools.v.i(r5, r12, r14);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r5 = r9.getParentFile();	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r5 = r5.mkdirs();	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        if (r5 != 0) goto L_0x03d5;
    L_0x0391:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "create file  getParentFile failed, filename is %s ";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r7 = 0;
        r0 = r19;
        r8 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r0 = r19;
        r3 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r0 = r19;
        r5 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r0 = r19;
        r6 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r7 = "getParentFile failed";
        r3.w(r5, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        if (r4 == 0) goto L_0x03c0;
    L_0x03bd:
        r4.close();	 Catch:{ IOException -> 0x03c7 }
    L_0x03c0:
        if (r2 == 0) goto L_0x0026;
    L_0x03c2:
        r2.disconnect();
        goto L_0x0026;
    L_0x03c7:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x03c0;
    L_0x03d5:
        if (r4 == 0) goto L_0x07c0;
    L_0x03d7:
        r5 = new java.io.FileOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r5.<init>(r9);	 Catch:{ UnsupportedEncodingException -> 0x07ba, FileNotFoundException -> 0x07aa, SSLHandshakeException -> 0x0798, SocketTimeoutException -> 0x0786, Exception -> 0x0774, all -> 0x0764 }
        r12 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r12 = new byte[r12];	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
    L_0x03e0:
        r13 = r4.read(r12);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = -1;
        if (r13 == r14) goto L_0x04c7;
    L_0x03e7:
        r0 = r19;
        r14 = r0.aHp;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        if (r14 == 0) goto L_0x04c7;
    L_0x03ed:
        r14 = 0;
        r5.write(r12, r14, r13);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = (long) r13;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r6 = r6 + r14;
        r13 = "MicroMsg.AppBrandDownloadWorker";
        r14 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r15 = "download size = ";
        r14.<init>(r15);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = r14.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r15 = "total size";
        r14 = r14.append(r15);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = r14.append(r10);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = r14.toString();	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        com.tencent.mm.sdk.platformtools.v.v(r13, r14);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = 0;
        r13 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r13 <= 0) goto L_0x044d;
    L_0x041a:
        r14 = r6 / r10;
        r16 = 100;
        r14 = r14 * r16;
        r13 = (int) r14;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = "MicroMsg.AppBrandDownloadWorker";
        r15 = "percent = %s";
        r16 = 1;
        r0 = r16;
        r0 = new java.lang.Object[r0];	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r16 = r0;
        r17 = 0;
        r18 = java.lang.Integer.valueOf(r13);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r16[r17] = r18;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        com.tencent.mm.sdk.platformtools.v.v(r14, r15, r16);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r14 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r15 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r0 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r16 = r0;
        r0 = r16;
        r14.i(r15, r0, r13);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
    L_0x044d:
        r14 = 0;
        r13 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
        if (r13 <= 0) goto L_0x03e0;
    L_0x0453:
        r0 = r19;
        r13 = r0.dMO;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        if (r13 <= 0) goto L_0x03e0;
    L_0x0459:
        r0 = r19;
        r13 = r0.dMO;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r14 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r13 = r13 * r14;
        r14 = (long) r13;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r13 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
        if (r13 < 0) goto L_0x03e0;
    L_0x0465:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r8 = "after read stream, downloadSize %d exceed limit";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r11 = 0;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r10[r11] = r6;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        com.tencent.mm.sdk.platformtools.v.i(r3, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r3 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r8 = "exceed max file size";
        r3.w(r6, r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        com.tencent.mm.sdk.platformtools.be.f(r5);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        com.tencent.mm.sdk.platformtools.be.f(r4);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r3 = r9.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        com.tencent.mm.loader.stub.b.deleteFile(r3);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        r5.close();	 Catch:{ IOException -> 0x04ab }
    L_0x049f:
        if (r4 == 0) goto L_0x04a4;
    L_0x04a1:
        r4.close();	 Catch:{ IOException -> 0x04b9 }
    L_0x04a4:
        if (r2 == 0) goto L_0x0026;
    L_0x04a6:
        r2.disconnect();
        goto L_0x0026;
    L_0x04ab:
        r3 = move-exception;
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r5, r3, r6, r7);
        goto L_0x049f;
    L_0x04b9:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x04a4;
    L_0x04c7:
        r5.flush();	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
    L_0x04ca:
        r0 = r19;
        r6 = r0.aHp;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        if (r6 == 0) goto L_0x0512;
    L_0x04d0:
        r0 = r19;
        r6 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r7 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r9 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r6.e(r7, r3, r9, r8);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
    L_0x04df:
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r6 = "finished filename = %s , url = %s ";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r8 = 0;
        r0 = r19;
        r9 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r8 = 1;
        r0 = r19;
        r9 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        com.tencent.mm.sdk.platformtools.v.v(r3, r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r2.disconnect();	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        if (r5 == 0) goto L_0x0506;
    L_0x0503:
        r5.close();	 Catch:{ IOException -> 0x052c }
    L_0x0506:
        if (r4 == 0) goto L_0x050b;
    L_0x0508:
        r4.close();	 Catch:{ IOException -> 0x053a }
    L_0x050b:
        if (r2 == 0) goto L_0x0026;
    L_0x050d:
        r2.disconnect();
        goto L_0x0026;
    L_0x0512:
        r0 = r19;
        r3 = r0.dML;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r6 = r0.filename;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r0 = r19;
        r7 = r0.uri;	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        r8 = "force stop";
        r3.w(r6, r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x0525, FileNotFoundException -> 0x07b0, SSLHandshakeException -> 0x079e, SocketTimeoutException -> 0x078c, Exception -> 0x077a, all -> 0x0769 }
        goto L_0x04df;
    L_0x0525:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r13 = r5;
        r2 = r3;
        goto L_0x0138;
    L_0x052c:
        r3 = move-exception;
        r5 = "MicroMsg.AppBrandDownloadWorker";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r5, r3, r6, r7);
        goto L_0x0506;
    L_0x053a:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x050b;
    L_0x0548:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0181;
    L_0x0557:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0186;
    L_0x0566:
        r2 = move-exception;
    L_0x0567:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x072e }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 3;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x072e }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x072e }
        r6 = 0;
        r0 = r19;
        r7 = r0.uri;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 1;
        r0 = r19;
        r7 = r0.filename;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x072e }
        r5[r6] = r2;	 Catch:{ all -> 0x072e }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r0 = r19;
        r2 = r0.dML;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r3 = r0.filename;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r4 = r0.uri;	 Catch:{ all -> 0x072e }
        r5 = "file not found error";
        r2.w(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r2 = 0;
        r0 = r19;
        r0.aHp = r2;
        if (r13 == 0) goto L_0x05b0;
    L_0x05ad:
        r13.close();	 Catch:{ IOException -> 0x05bc }
    L_0x05b0:
        if (r12 == 0) goto L_0x05b5;
    L_0x05b2:
        r12.close();	 Catch:{ IOException -> 0x05ca }
    L_0x05b5:
        if (r11 == 0) goto L_0x0026;
    L_0x05b7:
        r11.disconnect();
        goto L_0x0026;
    L_0x05bc:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x05b0;
    L_0x05ca:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x05b5;
    L_0x05d8:
        r2 = move-exception;
    L_0x05d9:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x072e }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 2;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x072e }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x072e }
        r6 = 0;
        r0 = r19;
        r7 = r0.uri;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 1;
        r0 = r19;
        r7 = r0.filename;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x072e }
        r5[r6] = r2;	 Catch:{ all -> 0x072e }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r0 = r19;
        r2 = r0.dML;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r3 = r0.filename;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r4 = r0.uri;	 Catch:{ all -> 0x072e }
        r5 = "ssl handshake error";
        r2.w(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r2 = 0;
        r0 = r19;
        r0.aHp = r2;
        if (r13 == 0) goto L_0x0622;
    L_0x061f:
        r13.close();	 Catch:{ IOException -> 0x062e }
    L_0x0622:
        if (r12 == 0) goto L_0x0627;
    L_0x0624:
        r12.close();	 Catch:{ IOException -> 0x063c }
    L_0x0627:
        if (r11 == 0) goto L_0x0026;
    L_0x0629:
        r11.disconnect();
        goto L_0x0026;
    L_0x062e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0622;
    L_0x063c:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0627;
    L_0x064a:
        r2 = move-exception;
    L_0x064b:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x072e }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 4;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x072e }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x072e }
        r6 = 0;
        r0 = r19;
        r7 = r0.uri;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 1;
        r0 = r19;
        r7 = r0.filename;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x072e }
        r5[r6] = r2;	 Catch:{ all -> 0x072e }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r0 = r19;
        r2 = r0.dML;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r3 = r0.filename;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r4 = r0.uri;	 Catch:{ all -> 0x072e }
        r5 = "socket timeout";
        r2.w(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r2 = 0;
        r0 = r19;
        r0.aHp = r2;
        if (r13 == 0) goto L_0x0694;
    L_0x0691:
        r13.close();	 Catch:{ IOException -> 0x06a0 }
    L_0x0694:
        if (r12 == 0) goto L_0x0699;
    L_0x0696:
        r12.close();	 Catch:{ IOException -> 0x06ae }
    L_0x0699:
        if (r11 == 0) goto L_0x0026;
    L_0x069b:
        r11.disconnect();
        goto L_0x0026;
    L_0x06a0:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0694;
    L_0x06ae:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0699;
    L_0x06bc:
        r2 = move-exception;
    L_0x06bd:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x072e }
        r4 = 437; // 0x1b5 float:6.12E-43 double:2.16E-321;
        r6 = 5;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x072e }
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "url is %s ,filename is %s , error is %s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x072e }
        r6 = 0;
        r0 = r19;
        r7 = r0.uri;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 1;
        r0 = r19;
        r7 = r0.filename;	 Catch:{ all -> 0x072e }
        r5[r6] = r7;	 Catch:{ all -> 0x072e }
        r6 = 2;
        r2 = r2.toString();	 Catch:{ all -> 0x072e }
        r5[r6] = r2;	 Catch:{ all -> 0x072e }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r0 = r19;
        r2 = r0.dML;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r3 = r0.filename;	 Catch:{ all -> 0x072e }
        r0 = r19;
        r4 = r0.uri;	 Catch:{ all -> 0x072e }
        r5 = "unknown error";
        r2.w(r3, r4, r5);	 Catch:{ all -> 0x072e }
        r2 = 0;
        r0 = r19;
        r0.aHp = r2;
        if (r13 == 0) goto L_0x0706;
    L_0x0703:
        r13.close();	 Catch:{ IOException -> 0x0712 }
    L_0x0706:
        if (r12 == 0) goto L_0x070b;
    L_0x0708:
        r12.close();	 Catch:{ IOException -> 0x0720 }
    L_0x070b:
        if (r11 == 0) goto L_0x0026;
    L_0x070d:
        r11.disconnect();
        goto L_0x0026;
    L_0x0712:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0706;
    L_0x0720:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandDownloadWorker";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x070b;
    L_0x072e:
        r2 = move-exception;
    L_0x072f:
        r3 = 0;
        r0 = r19;
        r0.aHp = r3;
        if (r13 == 0) goto L_0x0739;
    L_0x0736:
        r13.close();	 Catch:{ IOException -> 0x0744 }
    L_0x0739:
        if (r12 == 0) goto L_0x073e;
    L_0x073b:
        r12.close();	 Catch:{ IOException -> 0x0752 }
    L_0x073e:
        if (r11 == 0) goto L_0x0743;
    L_0x0740:
        r11.disconnect();
    L_0x0743:
        throw r2;
    L_0x0744:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x0739;
    L_0x0752:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandDownloadWorker";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x073e;
    L_0x0760:
        r3 = move-exception;
        r11 = r2;
        r2 = r3;
        goto L_0x072f;
    L_0x0764:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r2 = r3;
        goto L_0x072f;
    L_0x0769:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r13 = r5;
        r2 = r3;
        goto L_0x072f;
    L_0x076f:
        r3 = move-exception;
        r11 = r2;
        r2 = r3;
        goto L_0x06bd;
    L_0x0774:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r2 = r3;
        goto L_0x06bd;
    L_0x077a:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r13 = r5;
        r2 = r3;
        goto L_0x06bd;
    L_0x0781:
        r3 = move-exception;
        r11 = r2;
        r2 = r3;
        goto L_0x064b;
    L_0x0786:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r2 = r3;
        goto L_0x064b;
    L_0x078c:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r13 = r5;
        r2 = r3;
        goto L_0x064b;
    L_0x0793:
        r3 = move-exception;
        r11 = r2;
        r2 = r3;
        goto L_0x05d9;
    L_0x0798:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r2 = r3;
        goto L_0x05d9;
    L_0x079e:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r13 = r5;
        r2 = r3;
        goto L_0x05d9;
    L_0x07a5:
        r3 = move-exception;
        r11 = r2;
        r2 = r3;
        goto L_0x0567;
    L_0x07aa:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r2 = r3;
        goto L_0x0567;
    L_0x07b0:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r13 = r5;
        r2 = r3;
        goto L_0x0567;
    L_0x07b7:
        r2 = move-exception;
        goto L_0x0138;
    L_0x07ba:
        r3 = move-exception;
        r11 = r2;
        r12 = r4;
        r2 = r3;
        goto L_0x0138;
    L_0x07c0:
        r5 = r13;
        goto L_0x04ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.a.b.run():void");
    }
}
