package com.tencent.mm.plugin.appbrand.g;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    private int dMg = 5;
    protected final ArrayList<d> dMn = new ArrayList();

    public interface a {
        void aL(String str, String str2);

        void v(String str, String str2, String str3);
    }

    public c(int i) {
        if (i > 0) {
            this.dMg = i;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(com.tencent.mm.plugin.appbrand.g.d r17) {
        /*
        r16 = this;
        r13 = 0;
        r12 = 0;
        r11 = 0;
        r0 = r17;
        r14 = r0.dMt;
        r0 = r17;
        r15 = r0.dMu;
        r0 = r17;
        r2 = r0.dMv;
        if (r2 == 0) goto L_0x0038;
    L_0x0011:
        r0 = r17;
        r3 = r0.mUrl;
        r2 = com.tencent.mm.plugin.appbrand.g.i.b(r2, r3);
        if (r2 != 0) goto L_0x0038;
    L_0x001b:
        r2 = "fail";
        r3 = "url not in domain list";
        r14.aL(r2, r3);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "not in domain url %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r17;
        r6 = r0.mUrl;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
    L_0x0037:
        return;
    L_0x0038:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 0;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);
        r2 = "MicroMsg.AppBrandNetworkRequest";
        r3 = "prepare to send https request url is %s method is %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r17;
        r6 = r0.mUrl;
        r4[r5] = r6;
        r5 = 1;
        r0 = r17;
        r6 = r0.dMs;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r2 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x0588, SSLHandshakeException -> 0x0355, FileNotFoundException -> 0x03b6, SocketTimeoutException -> 0x0417, Exception -> 0x048f }
        r0 = r17;
        r3 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0588, SSLHandshakeException -> 0x0355, FileNotFoundException -> 0x03b6, SocketTimeoutException -> 0x0417, Exception -> 0x048f }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x0588, SSLHandshakeException -> 0x0355, FileNotFoundException -> 0x03b6, SocketTimeoutException -> 0x0417, Exception -> 0x048f }
        r2 = r2.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x0588, SSLHandshakeException -> 0x0355, FileNotFoundException -> 0x03b6, SocketTimeoutException -> 0x0417, Exception -> 0x048f }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x0588, SSLHandshakeException -> 0x0355, FileNotFoundException -> 0x03b6, SocketTimeoutException -> 0x0417, Exception -> 0x048f }
        if (r2 == 0) goto L_0x0593;
    L_0x006f:
        r0 = r17;
        r3 = r0.dMq;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r2.setConnectTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r0 = r17;
        r3 = r0.dMq;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r2.setReadTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = "charset";
        r4 = "utf-8";
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = 0;
        r2.setInstanceFollowRedirects(r3);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r0 = r17;
        r3 = r0.dMs;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r2.setRequestMethod(r3);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = 1;
        r2.setUseCaches(r3);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        if (r15 == 0) goto L_0x0143;
    L_0x0097:
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url %s : set header ";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r6 = 0;
        r0 = r17;
        r7 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r5[r6] = r7;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = r15.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r6 = r3.iterator();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
    L_0x00b2:
        r3 = r6.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        if (r3 == 0) goto L_0x0143;
    L_0x00b8:
        r3 = r6.next();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r0 = r3;
        r0 = (java.util.Map.Entry) r0;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r5 = r0;
        r3 = r5.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r4 = r5.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url %s : key:%s ,value %s ";
        r7 = 3;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r8 = 0;
        r0 = r17;
        r9 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r8 = 1;
        r9 = r5.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r8 = 2;
        r5 = r5.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r7[r8] = r5;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r7);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        goto L_0x00b2;
    L_0x00f1:
        r3 = move-exception;
    L_0x00f2:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x053d }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 1;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x053d }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "UnsupportedEncodingException: url %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x053d }
        r6 = 0;
        r0 = r17;
        r7 = r0.mUrl;	 Catch:{ all -> 0x053d }
        r5[r6] = r7;	 Catch:{ all -> 0x053d }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x053d }
        r3 = "fail";
        r4 = "UTF-8 decode error";
        r14.aL(r3, r4);	 Catch:{ all -> 0x053d }
        r0 = r17;
        r3 = r0.mUrl;
        r0 = r16;
        r0.nM(r3);
        if (r2 == 0) goto L_0x0128;
    L_0x0125:
        r2.disconnect();
    L_0x0128:
        if (r12 == 0) goto L_0x012d;
    L_0x012a:
        r12.close();	 Catch:{ IOException -> 0x0346 }
    L_0x012d:
        if (r11 == 0) goto L_0x0037;
    L_0x012f:
        r11.close();	 Catch:{ IOException -> 0x0134 }
        goto L_0x0037;
    L_0x0134:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x0143:
        r3 = "User-Agent";
        r4 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r5 = "";
        r4 = com.tencent.mm.pluginsdk.ui.tools.s.aW(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r0 = r17;
        r3 = r0.dMs;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = nL(r3);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        if (r3 == 0) goto L_0x0590;
    L_0x015e:
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "set post or put";
        com.tencent.mm.sdk.platformtools.v.i(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = "Content-Length";
        r0 = r17;
        r4 = r0.dMr;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r4 = r4.length;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r4 = java.lang.Integer.toString(r4);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = 1;
        r2.setDoOutput(r3);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r4 = r2.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x00f1, SSLHandshakeException -> 0x057c, FileNotFoundException -> 0x0570, SocketTimeoutException -> 0x055e, Exception -> 0x054c }
        r0 = r17;
        r4 = r0.dMr;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r3.write(r4);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r3.flush();	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r3.close();	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
    L_0x0190:
        r4 = r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r6 = java.lang.Integer.toString(r4);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r5 = "MicroMsg.AppBrandNetworkRequest";
        r7 = "responseCode = %d, url = %s";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r9 = 1;
        r0 = r17;
        r10 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        com.tencent.mm.sdk.platformtools.v.i(r5, r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 == r5) goto L_0x028d;
    L_0x01b6:
        r5 = "MicroMsg.AppBrandNetworkRequest";
        r7 = "url is %s, failed code: %d";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r9 = 0;
        r0 = r17;
        r10 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r9 = 1;
        r10 = java.lang.Integer.valueOf(r4);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        com.tencent.mm.sdk.platformtools.v.e(r5, r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r4 = com.tencent.mm.plugin.appbrand.g.i.hg(r4);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        if (r4 == 0) goto L_0x028d;
    L_0x01d6:
        r4 = com.tencent.mm.plugin.appbrand.g.i.b(r2);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r0 = r17;
        r5 = r0.dMw;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r7 = android.text.TextUtils.isEmpty(r4);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        if (r7 != 0) goto L_0x028d;
    L_0x01e4:
        if (r5 > 0) goto L_0x0228;
    L_0x01e6:
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "reach the max redirect count(%d)";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8 = 0;
        r9 = 15;
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r7[r8] = r9;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        com.tencent.mm.sdk.platformtools.v.w(r4, r5, r7);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r4 = "ok";
        r5 = "reach the max redirect count 15";
        r14.v(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r0 = r17;
        r4 = r0.mUrl;
        r0 = r16;
        r0.nM(r4);
        if (r2 == 0) goto L_0x0212;
    L_0x020f:
        r2.disconnect();
    L_0x0212:
        if (r3 == 0) goto L_0x0037;
    L_0x0214:
        r3.close();	 Catch:{ IOException -> 0x0219 }
        goto L_0x0037;
    L_0x0219:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x0228:
        r6 = "MicroMsg.AppBrandNetworkRequest";
        r7 = "redirect(%d) URL(%s) to URL(%s)";
        r8 = 3;
        r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r5);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r9 = 1;
        r0 = r17;
        r10 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r9 = 2;
        r8[r9] = r4;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        com.tencent.mm.sdk.platformtools.v.i(r6, r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r0 = r17;
        r0.mUrl = r4;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r4 = r5 + -1;
        r0 = r17;
        r0.dMw = r4;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "now redirect count = %d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r7 = 0;
        r0 = r17;
        r8 = r0.dMw;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r6[r7] = r8;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r16.a(r17);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r0 = r17;
        r4 = r0.mUrl;
        r0 = r16;
        r0.nM(r4);
        if (r2 == 0) goto L_0x0277;
    L_0x0274:
        r2.disconnect();
    L_0x0277:
        if (r3 == 0) goto L_0x0037;
    L_0x0279:
        r3.close();	 Catch:{ IOException -> 0x027e }
        goto L_0x0037;
    L_0x027e:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x028d:
        r5 = "";
        r7 = new java.io.ByteArrayOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r7.<init>();	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r4 = r2.getInputStream();	 Catch:{ Exception -> 0x02b0, UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, all -> 0x0541 }
    L_0x0299:
        if (r4 == 0) goto L_0x0309;
    L_0x029b:
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
    L_0x029f:
        r8 = r4.read(r5);	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r9 = -1;
        if (r8 == r9) goto L_0x02df;
    L_0x02a6:
        r9 = 0;
        r7.write(r5, r9, r8);	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        goto L_0x029f;
    L_0x02ab:
        r5 = move-exception;
        r11 = r3;
        r12 = r4;
        goto L_0x00f2;
    L_0x02b0:
        r4 = move-exception;
        r8 = "MicroMsg.AppBrandNetworkRequest";
        r9 = "read input stream failed : %s";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r11 = 0;
        r4 = r4.toString();	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r10[r11] = r4;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        com.tencent.mm.sdk.platformtools.v.e(r8, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r4 = r2.getErrorStream();	 Catch:{ Exception -> 0x02c9, UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, all -> 0x0541 }
        goto L_0x0299;
    L_0x02c9:
        r4 = move-exception;
        r8 = "MicroMsg.AppBrandNetworkRequest";
        r9 = "read err stream failed : %s";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r11 = 0;
        r4 = r4.toString();	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r10[r11] = r4;	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        com.tencent.mm.sdk.platformtools.v.e(r8, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x058c, SSLHandshakeException -> 0x057f, FileNotFoundException -> 0x0573, SocketTimeoutException -> 0x0563, Exception -> 0x0551, all -> 0x0541 }
        r4 = r12;
        goto L_0x0299;
    L_0x02df:
        r7.flush();	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r4.close();	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r5 = "UTF-8";
        r5 = r7.toString(r5);	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r8 = "MicroMsg.AppBrandNetworkRequest";
        r9 = "url %s : buffer string %s";
        r10 = 2;
        r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r11 = 0;
        r0 = r17;
        r12 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r10[r11] = r12;	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r11 = 1;
        r12 = "UTF-8";
        r7 = r7.toString(r12);	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        r10[r11] = r7;	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
        com.tencent.mm.sdk.platformtools.v.v(r8, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
    L_0x0309:
        r7 = "ok";
        r14.v(r7, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x02ab, SSLHandshakeException -> 0x0583, FileNotFoundException -> 0x0577, SocketTimeoutException -> 0x0569, Exception -> 0x0557, all -> 0x0546 }
    L_0x030f:
        r0 = r17;
        r5 = r0.mUrl;
        r0 = r16;
        r0.nM(r5);
        if (r2 == 0) goto L_0x031d;
    L_0x031a:
        r2.disconnect();
    L_0x031d:
        if (r4 == 0) goto L_0x0322;
    L_0x031f:
        r4.close();	 Catch:{ IOException -> 0x0338 }
    L_0x0322:
        if (r3 == 0) goto L_0x0037;
    L_0x0324:
        r3.close();	 Catch:{ IOException -> 0x0329 }
        goto L_0x0037;
    L_0x0329:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x0338:
        r2 = move-exception;
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r2, r5, r6);
        goto L_0x0322;
    L_0x0346:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x012d;
    L_0x0355:
        r2 = move-exception;
        r2 = r13;
    L_0x0357:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x053d }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 2;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x053d }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "SSLHandshakeException: url %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x053d }
        r6 = 0;
        r0 = r17;
        r7 = r0.mUrl;	 Catch:{ all -> 0x053d }
        r5[r6] = r7;	 Catch:{ all -> 0x053d }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x053d }
        r3 = "fail";
        r4 = "ssl hand shake error";
        r14.aL(r3, r4);	 Catch:{ all -> 0x053d }
        r0 = r17;
        r3 = r0.mUrl;
        r0 = r16;
        r0.nM(r3);
        if (r2 == 0) goto L_0x038d;
    L_0x038a:
        r2.disconnect();
    L_0x038d:
        if (r12 == 0) goto L_0x0392;
    L_0x038f:
        r12.close();	 Catch:{ IOException -> 0x03a8 }
    L_0x0392:
        if (r11 == 0) goto L_0x0037;
    L_0x0394:
        r11.close();	 Catch:{ IOException -> 0x0399 }
        goto L_0x0037;
    L_0x0399:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x03a8:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0392;
    L_0x03b6:
        r2 = move-exception;
        r2 = r13;
    L_0x03b8:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x053d }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 3;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x053d }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "FileNotFoundException: url %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x053d }
        r6 = 0;
        r0 = r17;
        r7 = r0.mUrl;	 Catch:{ all -> 0x053d }
        r5[r6] = r7;	 Catch:{ all -> 0x053d }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x053d }
        r3 = "fail";
        r4 = "file not exist error";
        r14.aL(r3, r4);	 Catch:{ all -> 0x053d }
        r0 = r17;
        r3 = r0.mUrl;
        r0 = r16;
        r0.nM(r3);
        if (r2 == 0) goto L_0x03ee;
    L_0x03eb:
        r2.disconnect();
    L_0x03ee:
        if (r12 == 0) goto L_0x03f3;
    L_0x03f0:
        r12.close();	 Catch:{ IOException -> 0x0409 }
    L_0x03f3:
        if (r11 == 0) goto L_0x0037;
    L_0x03f5:
        r11.close();	 Catch:{ IOException -> 0x03fa }
        goto L_0x0037;
    L_0x03fa:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x0409:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x03f3;
    L_0x0417:
        r2 = move-exception;
    L_0x0418:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x0507 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 4;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0507 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s, failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0507 }
        r6 = 0;
        r0 = r17;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0507 }
        r5[r6] = r7;	 Catch:{ all -> 0x0507 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x0507 }
        r5[r6] = r7;	 Catch:{ all -> 0x0507 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0507 }
        r3 = "fail";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0507 }
        r5 = "send request fail:";
        r4.<init>(r5);	 Catch:{ all -> 0x0507 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0507 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0507 }
        r2 = r2.toString();	 Catch:{ all -> 0x0507 }
        r14.aL(r3, r2);	 Catch:{ all -> 0x0507 }
        r0 = r17;
        r2 = r0.mUrl;
        r0 = r16;
        r0.nM(r2);
        if (r13 == 0) goto L_0x0466;
    L_0x0463:
        r13.disconnect();
    L_0x0466:
        if (r12 == 0) goto L_0x046b;
    L_0x0468:
        r12.close();	 Catch:{ IOException -> 0x0481 }
    L_0x046b:
        if (r11 == 0) goto L_0x0037;
    L_0x046d:
        r11.close();	 Catch:{ IOException -> 0x0472 }
        goto L_0x0037;
    L_0x0472:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x0481:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x046b;
    L_0x048f:
        r2 = move-exception;
    L_0x0490:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x0507 }
        r4 = 435; // 0x1b3 float:6.1E-43 double:2.15E-321;
        r6 = 5;
        r8 = 1;
        r10 = 0;
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0507 }
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "url is %s,failed reason: %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0507 }
        r6 = 0;
        r0 = r17;
        r7 = r0.mUrl;	 Catch:{ all -> 0x0507 }
        r5[r6] = r7;	 Catch:{ all -> 0x0507 }
        r6 = 1;
        r7 = r2.toString();	 Catch:{ all -> 0x0507 }
        r5[r6] = r7;	 Catch:{ all -> 0x0507 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0507 }
        r3 = "fail";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0507 }
        r5 = "send request fail:";
        r4.<init>(r5);	 Catch:{ all -> 0x0507 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0507 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0507 }
        r2 = r2.toString();	 Catch:{ all -> 0x0507 }
        r14.aL(r3, r2);	 Catch:{ all -> 0x0507 }
        r0 = r17;
        r2 = r0.mUrl;
        r0 = r16;
        r0.nM(r2);
        if (r13 == 0) goto L_0x04de;
    L_0x04db:
        r13.disconnect();
    L_0x04de:
        if (r12 == 0) goto L_0x04e3;
    L_0x04e0:
        r12.close();	 Catch:{ IOException -> 0x04f9 }
    L_0x04e3:
        if (r11 == 0) goto L_0x0037;
    L_0x04e5:
        r11.close();	 Catch:{ IOException -> 0x04ea }
        goto L_0x0037;
    L_0x04ea:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0037;
    L_0x04f9:
        r2 = move-exception;
        r3 = "MicroMsg.AppBrandNetworkRequest";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x04e3;
    L_0x0507:
        r2 = move-exception;
    L_0x0508:
        r0 = r17;
        r3 = r0.mUrl;
        r0 = r16;
        r0.nM(r3);
        if (r13 == 0) goto L_0x0516;
    L_0x0513:
        r13.disconnect();
    L_0x0516:
        if (r12 == 0) goto L_0x051b;
    L_0x0518:
        r12.close();	 Catch:{ IOException -> 0x0521 }
    L_0x051b:
        if (r11 == 0) goto L_0x0520;
    L_0x051d:
        r11.close();	 Catch:{ IOException -> 0x052f }
    L_0x0520:
        throw r2;
    L_0x0521:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x051b;
    L_0x052f:
        r3 = move-exception;
        r4 = "MicroMsg.AppBrandNetworkRequest";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r4, r3, r5, r6);
        goto L_0x0520;
    L_0x053d:
        r3 = move-exception;
        r13 = r2;
        r2 = r3;
        goto L_0x0508;
    L_0x0541:
        r4 = move-exception;
        r11 = r3;
        r13 = r2;
        r2 = r4;
        goto L_0x0508;
    L_0x0546:
        r5 = move-exception;
        r11 = r3;
        r12 = r4;
        r13 = r2;
        r2 = r5;
        goto L_0x0508;
    L_0x054c:
        r3 = move-exception;
        r13 = r2;
        r2 = r3;
        goto L_0x0490;
    L_0x0551:
        r4 = move-exception;
        r11 = r3;
        r13 = r2;
        r2 = r4;
        goto L_0x0490;
    L_0x0557:
        r5 = move-exception;
        r11 = r3;
        r12 = r4;
        r13 = r2;
        r2 = r5;
        goto L_0x0490;
    L_0x055e:
        r3 = move-exception;
        r13 = r2;
        r2 = r3;
        goto L_0x0418;
    L_0x0563:
        r4 = move-exception;
        r11 = r3;
        r13 = r2;
        r2 = r4;
        goto L_0x0418;
    L_0x0569:
        r5 = move-exception;
        r11 = r3;
        r12 = r4;
        r13 = r2;
        r2 = r5;
        goto L_0x0418;
    L_0x0570:
        r3 = move-exception;
        goto L_0x03b8;
    L_0x0573:
        r4 = move-exception;
        r11 = r3;
        goto L_0x03b8;
    L_0x0577:
        r5 = move-exception;
        r11 = r3;
        r12 = r4;
        goto L_0x03b8;
    L_0x057c:
        r3 = move-exception;
        goto L_0x0357;
    L_0x057f:
        r4 = move-exception;
        r11 = r3;
        goto L_0x0357;
    L_0x0583:
        r5 = move-exception;
        r11 = r3;
        r12 = r4;
        goto L_0x0357;
    L_0x0588:
        r2 = move-exception;
        r2 = r13;
        goto L_0x00f2;
    L_0x058c:
        r4 = move-exception;
        r11 = r3;
        goto L_0x00f2;
    L_0x0590:
        r3 = r11;
        goto L_0x0190;
    L_0x0593:
        r3 = r11;
        r4 = r12;
        goto L_0x030f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.c.a(com.tencent.mm.plugin.appbrand.g.d):void");
    }

    private static boolean nL(String str) {
        return str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE");
    }

    public final void a(int i, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar) {
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("method");
        if (be.kS(optString3)) {
            optString3 = "GET";
        }
        if (TextUtils.isEmpty(optString)) {
            aVar.aL("fail", "url is null");
        } else if (URLUtil.isHttpsUrl(optString) || URLUtil.isHttpUrl(optString)) {
            byte[] bArr = new byte[0];
            if (optString2 != null && nL(optString3)) {
                bArr = optString2.getBytes(Charset.forName("UTF-8"));
            }
            if (this.dMn.size() >= this.dMg) {
                aVar.aL("fail", "max connected");
                v.i("MicroMsg.AppBrandNetworkRequest", "max connected");
                return;
            }
            v.i("MicroMsg.AppBrandNetworkRequest", "method %s ,url %s timeout %s", new Object[]{optString3, optString, Integer.valueOf(i)});
            final d dVar = new d(optString, bArr, i, aVar, optString3);
            dVar.dMu = map;
            dVar.dMv = arrayList;
            synchronized (this.dMn) {
                this.dMn.add(dVar);
            }
            e.a(new Runnable(this) {
                final /* synthetic */ c dMp;

                public final void run() {
                    this.dMp.a(dVar);
                }
            }, "appbrand_request_thread");
        } else {
            aVar.aL("fail", "request protocol must be http or https");
        }
    }

    private synchronized void nM(String str) {
        if (str != null) {
            Collection arrayList = new ArrayList();
            synchronized (this.dMn) {
                Iterator it = this.dMn.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.mUrl.equals(str)) {
                        arrayList.add(dVar);
                    }
                }
                if (arrayList.size() > 0) {
                    this.dMn.removeAll(arrayList);
                }
            }
        }
    }
}
