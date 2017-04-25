package com.tencent.mm.plugin.appbrand.g;

import android.text.TextUtils;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class f {
    private int dMg = 5;
    private final ArrayList<g> dMy = new ArrayList();

    public interface a {
        void i(int i, String str, String str2);

        void nD(String str);
    }

    public class b implements Runnable {
        final /* synthetic */ f dMA;
        private g dMz;

        public b(f fVar, g gVar) {
            this.dMA = fVar;
            this.dMz = gVar;
        }

        public final void run() {
            a(this.dMz);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(com.tencent.mm.plugin.appbrand.g.g r31) {
            /*
            r30 = this;
            r0 = r31;
            r0 = r0.mUrl;
            r17 = r0;
            r0 = r31;
            r0 = r0.dMB;
            r18 = r0;
            r0 = r31;
            r0 = r0.mName;
            r19 = r0;
            r0 = r31;
            r0 = r0.mMimeType;
            r20 = r0;
            r4 = new java.lang.StringBuilder;
            r2 = "wx-file.";
            r4.<init>(r2);
            r3 = com.tencent.mm.pluginsdk.ui.tools.s.Ij(r20);
            r2 = "dat";
            r5 = com.tencent.mm.sdk.platformtools.be.kS(r3);
            if (r5 == 0) goto L_0x006d;
        L_0x002d:
            r2 = r4.append(r2);
            r21 = r2.toString();
            r0 = r31;
            r0 = r0.dMC;
            r22 = r0;
            r0 = r31;
            r0 = r0.dMu;
            r23 = r0;
            r0 = r31;
            r0 = r0.dMD;
            r24 = r0;
            r0 = r31;
            r2 = r0.dMv;
            if (r2 == 0) goto L_0x006f;
        L_0x004d:
            r0 = r17;
            r2 = com.tencent.mm.plugin.appbrand.g.i.b(r2, r0);
            if (r2 != 0) goto L_0x006f;
        L_0x0055:
            r2 = "fail:url not in domain list";
            r0 = r24;
            r0.nD(r2);
            r2 = "MicroMsg.AppBrandNetworkUpload";
            r3 = "not in domain url %s";
            r4 = 1;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r4[r5] = r17;
            com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        L_0x006c:
            return;
        L_0x006d:
            r2 = r3;
            goto L_0x002d;
        L_0x006f:
            r15 = 0;
            r14 = 0;
            r13 = 0;
            r12 = 0;
            r11 = "";
            r0 = r31;
            r2 = r0.aHp;
            if (r2 != 0) goto L_0x008e;
        L_0x007c:
            r2 = "force_stop!";
            r0 = r24;
            r0.nD(r2);
            r2 = "MicroMsg.AppBrandNetworkUpload";
            r3 = "force stop!";
            com.tencent.mm.sdk.platformtools.v.e(r2, r3);
            goto L_0x006c;
        L_0x008e:
            r0 = r31;
            r2 = r0.mUrl;
            r2 = android.webkit.URLUtil.isHttpsUrl(r2);
            if (r2 != 0) goto L_0x00ab;
        L_0x0098:
            r0 = r31;
            r2 = r0.mUrl;
            r2 = android.webkit.URLUtil.isHttpUrl(r2);
            if (r2 != 0) goto L_0x00ab;
        L_0x00a2:
            r2 = "uploadFile protocol must be http or https";
            r0 = r24;
            r0.nD(r2);
            goto L_0x006c;
        L_0x00ab:
            r25 = "--";
            r2 = java.lang.System.currentTimeMillis();
            r26 = java.lang.Long.toString(r2);
            r27 = "\r\n";
            r16 = "";
            r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ UnsupportedEncodingException -> 0x0b7e, FileNotFoundException -> 0x0b68, SSLHandshakeException -> 0x0b49, SocketTimeoutException -> 0x08b7, Exception -> 0x0983, all -> 0x0a4f }
            r4 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r6 = 0;
            r8 = 1;
            r10 = 0;
            r3.a(r4, r6, r8, r10);	 Catch:{ UnsupportedEncodingException -> 0x0b7e, FileNotFoundException -> 0x0b68, SSLHandshakeException -> 0x0b49, SocketTimeoutException -> 0x08b7, Exception -> 0x0983, all -> 0x0a4f }
            r6 = new java.io.File;	 Catch:{ UnsupportedEncodingException -> 0x0b7e, FileNotFoundException -> 0x0b68, SSLHandshakeException -> 0x0b49, SocketTimeoutException -> 0x08b7, Exception -> 0x0983, all -> 0x0a4f }
            r0 = r18;
            r6.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0b7e, FileNotFoundException -> 0x0b68, SSLHandshakeException -> 0x0b49, SocketTimeoutException -> 0x08b7, Exception -> 0x0983, all -> 0x0a4f }
            r5 = new java.io.FileInputStream;	 Catch:{ UnsupportedEncodingException -> 0x0b7e, FileNotFoundException -> 0x0b68, SSLHandshakeException -> 0x0b49, SocketTimeoutException -> 0x08b7, Exception -> 0x0983, all -> 0x0a4f }
            r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x0b7e, FileNotFoundException -> 0x0b68, SSLHandshakeException -> 0x0b49, SocketTimeoutException -> 0x08b7, Exception -> 0x0983, all -> 0x0a4f }
            r8 = new java.net.URL;	 Catch:{ UnsupportedEncodingException -> 0x0b81, FileNotFoundException -> 0x0b6b, SSLHandshakeException -> 0x0b4c, SocketTimeoutException -> 0x0b27, Exception -> 0x0b05, all -> 0x0aec }
            r0 = r17;
            r8.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0b81, FileNotFoundException -> 0x0b6b, SSLHandshakeException -> 0x0b4c, SocketTimeoutException -> 0x0b27, Exception -> 0x0b05, all -> 0x0aec }
            r2 = r8.openConnection();	 Catch:{ UnsupportedEncodingException -> 0x0b81, FileNotFoundException -> 0x0b6b, SSLHandshakeException -> 0x0b4c, SocketTimeoutException -> 0x0b27, Exception -> 0x0b05, all -> 0x0aec }
            r2 = (java.net.HttpURLConnection) r2;	 Catch:{ UnsupportedEncodingException -> 0x0b81, FileNotFoundException -> 0x0b6b, SSLHandshakeException -> 0x0b4c, SocketTimeoutException -> 0x0b27, Exception -> 0x0b05, all -> 0x0aec }
            r3 = 1;
            r2.setDoInput(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = 1;
            r2.setDoOutput(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = 0;
            r2.setUseCaches(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r31;
            r3 = r0.dMq;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r2.setConnectTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r31;
            r3 = r0.dMq;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r2.setReadTimeout(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = "POST";
            r2.setRequestMethod(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = "Connection";
            r4 = "Keep-Alive";
            r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "file path = %s, lenght = %d";
            r7 = 2;
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9 = 0;
            r10 = r6.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r7[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9 = 1;
            r28 = r6.length();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r10 = java.lang.Long.valueOf(r28);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r7[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r7);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = 0;
            r2.setInstanceFollowRedirects(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            if (r23 == 0) goto L_0x02e6;
        L_0x012e:
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "url %s : set header ";
            r7 = 1;
            r7 = new java.lang.Object[r7];	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9 = 0;
            r7[r9] = r17;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r7);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r23.entrySet();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r7 = r3.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
        L_0x0145:
            r3 = r7.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            if (r3 == 0) goto L_0x02e6;
        L_0x014b:
            r3 = r7.next();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = (java.util.Map.Entry) r3;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r9 = "set header for : url %s : key:%s ,value %s ";
            r10 = 3;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r12 = 0;
            r10[r12] = r17;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r12 = 1;
            r15 = r3.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r10[r12] = r15;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r12 = 2;
            r15 = r3.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r10[r12] = r15;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            com.tencent.mm.sdk.platformtools.v.i(r4, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = r3.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            if (r4 != 0) goto L_0x0145;
        L_0x017a:
            r4 = r3.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            if (r4 != 0) goto L_0x0145;
        L_0x0186:
            r4 = r3.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = r4.toLowerCase();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9 = "content-length";
            r4 = r4.contains(r9);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            if (r4 == 0) goto L_0x023c;
        L_0x0199:
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "not allow to set Content-Length";
            com.tencent.mm.sdk.platformtools.v.e(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            goto L_0x0145;
        L_0x01a3:
            r3 = move-exception;
            r12 = r5;
            r15 = r2;
            r2 = r3;
        L_0x01a7:
            r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x0b01 }
            r4 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r6 = 1;
            r8 = 1;
            r10 = 0;
            r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0b01 }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "UnsupportEncodingException : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0b01 }
            r6 = 0;
            r2 = r2.toString();	 Catch:{ all -> 0x0b01 }
            r5[r6] = r2;	 Catch:{ all -> 0x0b01 }
            r2 = 1;
            r5[r2] = r17;	 Catch:{ all -> 0x0b01 }
            r2 = 2;
            r5[r2] = r18;	 Catch:{ all -> 0x0b01 }
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0b01 }
            r2 = -1;
            r3 = "unsupported encoding";
            r0 = r24;
            r0.i(r2, r3, r11);	 Catch:{ all -> 0x0b01 }
            r2 = 0;
            r0 = r31;
            r0.aHp = r2;
            r0 = r30;
            r2 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r2, r0, r1);
            r2 = "MicroMsg.AppBrandNetworkUpload";
            r3 = new java.lang.StringBuilder;
            r4 = "finally : url is ";
            r3.<init>(r4);
            r0 = r17;
            r3 = r3.append(r0);
            r4 = ", filepath";
            r3 = r3.append(r4);
            r0 = r18;
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.v.i(r2, r3);
            if (r12 == 0) goto L_0x020f;
        L_0x020c:
            r12.close();	 Catch:{ Exception -> 0x080f }
        L_0x020f:
            if (r15 == 0) goto L_0x0214;
        L_0x0211:
            r15.disconnect();
        L_0x0214:
            if (r13 == 0) goto L_0x0219;
        L_0x0216:
            r13.close();	 Catch:{ IOException -> 0x082b }
        L_0x0219:
            if (r14 == 0) goto L_0x006c;
        L_0x021b:
            r14.close();	 Catch:{ IOException -> 0x0220 }
            goto L_0x006c;
        L_0x0220:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x023c:
            r4 = r3.getKey();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r3.getValue();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r2.setRequestProperty(r4, r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            goto L_0x0145;
        L_0x024d:
            r3 = move-exception;
            r12 = r5;
            r15 = r2;
            r2 = r3;
        L_0x0251:
            r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x0b01 }
            r4 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r6 = 3;
            r8 = 1;
            r10 = 0;
            r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0b01 }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "FileNotFoundException : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0b01 }
            r6 = 0;
            r2 = r2.toString();	 Catch:{ all -> 0x0b01 }
            r5[r6] = r2;	 Catch:{ all -> 0x0b01 }
            r2 = 1;
            r5[r2] = r17;	 Catch:{ all -> 0x0b01 }
            r2 = 2;
            r5[r2] = r18;	 Catch:{ all -> 0x0b01 }
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0b01 }
            r2 = -1;
            r3 = "file not exist";
            r0 = r24;
            r0.i(r2, r3, r11);	 Catch:{ all -> 0x0b01 }
            r2 = 0;
            r0 = r31;
            r0.aHp = r2;
            r0 = r30;
            r2 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r2, r0, r1);
            r2 = "MicroMsg.AppBrandNetworkUpload";
            r3 = new java.lang.StringBuilder;
            r4 = "finally : url is ";
            r3.<init>(r4);
            r0 = r17;
            r3 = r3.append(r0);
            r4 = ", filepath";
            r3 = r3.append(r4);
            r0 = r18;
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.v.i(r2, r3);
            if (r12 == 0) goto L_0x02b9;
        L_0x02b6:
            r12.close();	 Catch:{ Exception -> 0x0847 }
        L_0x02b9:
            if (r15 == 0) goto L_0x02be;
        L_0x02bb:
            r15.disconnect();
        L_0x02be:
            if (r13 == 0) goto L_0x02c3;
        L_0x02c0:
            r13.close();	 Catch:{ IOException -> 0x0863 }
        L_0x02c3:
            if (r14 == 0) goto L_0x006c;
        L_0x02c5:
            r14.close();	 Catch:{ IOException -> 0x02ca }
            goto L_0x006c;
        L_0x02ca:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x02e6:
            r3 = "User-Agent";
            r4 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r7 = "";
            r4 = com.tencent.mm.pluginsdk.ui.tools.s.aW(r4, r7);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r6 = r6.length();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r10 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r10.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            if (r22 == 0) goto L_0x04e6;
        L_0x0307:
            r3 = "Content-Type";
            r4 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r12 = "multipart/form-data; boundary=";
            r4.<init>(r12);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r26;
            r4 = r4.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = r4.toString();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r22.keySet();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r12 = r3.iterator();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
        L_0x0327:
            r3 = r12.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            if (r3 == 0) goto L_0x043e;
        L_0x032d:
            r3 = r12.next();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r22;
            r4 = r0.get(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = (java.lang.String) r4;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r15 = "MicroMsg.AppBrandNetworkUpload";
            r23 = "append form data: key = %s, value = %s";
            r28 = 2;
            r0 = r28;
            r0 = new java.lang.Object[r0];	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r28 = r0;
            r29 = 0;
            r28[r29] = r3;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r29 = 1;
            r28[r29] = r4;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r23;
            r1 = r28;
            com.tencent.mm.sdk.platformtools.v.i(r15, r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r15 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r15.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r25;
            r15 = r15.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r26;
            r15 = r15.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r15 = r15.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r15 = r15.toString();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9.append(r15);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r15 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r23 = "Content-Disposition: form-data; name=\"";
            r0 = r23;
            r15.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r15.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r15 = "\"";
            r3 = r3.append(r15);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r9.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r9.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r9.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            goto L_0x0327;
        L_0x03a5:
            r3 = move-exception;
            r12 = r5;
            r15 = r2;
            r2 = r3;
        L_0x03a9:
            r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x0b01 }
            r4 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r6 = 2;
            r8 = 1;
            r10 = 0;
            r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0b01 }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "SSLHandshakeException : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0b01 }
            r6 = 0;
            r2 = r2.toString();	 Catch:{ all -> 0x0b01 }
            r5[r6] = r2;	 Catch:{ all -> 0x0b01 }
            r2 = 1;
            r5[r2] = r17;	 Catch:{ all -> 0x0b01 }
            r2 = 2;
            r5[r2] = r18;	 Catch:{ all -> 0x0b01 }
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0b01 }
            r2 = -1;
            r3 = "ssl hand shake error";
            r0 = r24;
            r0.i(r2, r3, r11);	 Catch:{ all -> 0x0b01 }
            r2 = 0;
            r0 = r31;
            r0.aHp = r2;
            r0 = r30;
            r2 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r2, r0, r1);
            r2 = "MicroMsg.AppBrandNetworkUpload";
            r3 = new java.lang.StringBuilder;
            r4 = "finally : url is ";
            r3.<init>(r4);
            r0 = r17;
            r3 = r3.append(r0);
            r4 = ", filepath";
            r3 = r3.append(r4);
            r0 = r18;
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.v.i(r2, r3);
            if (r12 == 0) goto L_0x0411;
        L_0x040e:
            r12.close();	 Catch:{ Exception -> 0x087f }
        L_0x0411:
            if (r15 == 0) goto L_0x0416;
        L_0x0413:
            r15.disconnect();
        L_0x0416:
            if (r13 == 0) goto L_0x041b;
        L_0x0418:
            r13.close();	 Catch:{ IOException -> 0x089b }
        L_0x041b:
            if (r14 == 0) goto L_0x006c;
        L_0x041d:
            r14.close();	 Catch:{ IOException -> 0x0422 }
            goto L_0x006c;
        L_0x0422:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x043e:
            r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r25;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r26;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = "Content-Disposition: form-data; name=\"";
            r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r19;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = "\"; filename=\"";
            r3 = r3.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r21;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = "\"";
            r3 = r3.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r4 = "Content-Type: ";
            r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r20;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r9.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r9.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r9.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r25;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r26;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r25;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = r27;
            r3 = r3.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r10.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r9.length();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = (long) r3;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r20 = r0;
            r6 = r6 + r20;
            r3 = r10.length();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r0 = (long) r3;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r20 = r0;
            r6 = r6 + r20;
        L_0x04e6:
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "contentLenght = %d";
            r12 = 1;
            r12 = new java.lang.Object[r12];	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r15 = 0;
            r20 = java.lang.Long.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r12[r15] = r20;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            com.tencent.mm.sdk.platformtools.v.i(r3, r4, r12);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = "Content-Length";
            r4 = java.lang.String.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r2.setRequestProperty(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r7 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r2.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r7.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x01a3, FileNotFoundException -> 0x024d, SSLHandshakeException -> 0x03a5, SocketTimeoutException -> 0x0b2b, Exception -> 0x0b09, all -> 0x0aef }
            r3 = r9.toString();	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r4 = "UTF-8";
            r3 = r3.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r7.write(r3);	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r3 = new byte[r3];	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
        L_0x051e:
            r4 = r5.read(r3);	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r6 = -1;
            if (r4 == r6) goto L_0x0531;
        L_0x0525:
            r6 = 0;
            r7.write(r3, r6, r4);	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            goto L_0x051e;
        L_0x052a:
            r3 = move-exception;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x01a7;
        L_0x0531:
            r3 = r10.toString();	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r4 = "UTF-8";
            r3 = r3.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r7.write(r3);	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r7.flush();	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r3 = r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r4 = java.lang.Integer.toString(r3);	 Catch:{ UnsupportedEncodingException -> 0x052a, FileNotFoundException -> 0x0b6f, SSLHandshakeException -> 0x0b50, SocketTimeoutException -> 0x0b31, Exception -> 0x0b0f, all -> 0x0af4 }
            r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r6 == r3) goto L_0x06bb;
        L_0x054e:
            r6 = "MicroMsg.AppBrandNetworkUpload";
            r9 = "code %d  url is %s filepath %s ";
            r10 = 3;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 0;
            r12 = r2.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r12 = java.lang.Integer.valueOf(r12);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r10[r11] = r12;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 1;
            r10[r11] = r17;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 2;
            r10[r11] = r18;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            com.tencent.mm.sdk.platformtools.v.e(r6, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r3 = com.tencent.mm.plugin.appbrand.g.i.hg(r3);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            if (r3 == 0) goto L_0x06bb;
        L_0x0571:
            r3 = com.tencent.mm.plugin.appbrand.g.i.b(r2);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r0 = r31;
            r6 = r0.dMw;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r9 = android.text.TextUtils.isEmpty(r3);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            if (r9 != 0) goto L_0x06bb;
        L_0x057f:
            if (r6 > 0) goto L_0x0618;
        L_0x0581:
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "reach the max redirect count(%d)";
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r9 = 0;
            r10 = 15;
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r8[r9] = r10;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            com.tencent.mm.sdk.platformtools.v.w(r3, r6, r8);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r3 = 0;
            r6 = "reach the max redirect count 15";
            r0 = r24;
            r0.i(r3, r6, r4);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r3 = 0;
            r0 = r31;
            r0.aHp = r3;
            r0 = r30;
            r3 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r3, r0, r1);
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = new java.lang.StringBuilder;
            r6 = "finally : url is ";
            r4.<init>(r6);
            r0 = r17;
            r4 = r4.append(r0);
            r6 = ", filepath";
            r4 = r4.append(r6);
            r0 = r18;
            r4 = r4.append(r0);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.v.i(r3, r4);
            r5.close();	 Catch:{ Exception -> 0x05fd }
        L_0x05d7:
            if (r2 == 0) goto L_0x05dc;
        L_0x05d9:
            r2.disconnect();
        L_0x05dc:
            r7.close();	 Catch:{ IOException -> 0x05e1 }
            goto L_0x006c;
        L_0x05e1:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x05fd:
            r3 = move-exception;
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "exception : %s ,url is %s filepath %s ";
            r6 = 3;
            r6 = new java.lang.Object[r6];
            r8 = 0;
            r3 = r3.toString();
            r6[r8] = r3;
            r3 = 1;
            r6[r3] = r17;
            r3 = 2;
            r6[r3] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);
            goto L_0x05d7;
        L_0x0618:
            r8 = "MicroMsg.AppBrandNetworkUpload";
            r9 = "redirect(%d) URL(%s) to URL(%s)";
            r10 = 3;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 0;
            r12 = java.lang.Integer.valueOf(r6);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r10[r11] = r12;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 1;
            r0 = r31;
            r12 = r0.mUrl;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r10[r11] = r12;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 2;
            r10[r11] = r3;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            com.tencent.mm.sdk.platformtools.v.i(r8, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r0 = r31;
            r0.mUrl = r3;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r3 = r6 + -1;
            r0 = r31;
            r0.dMw = r3;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r30.a(r31);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r3 = 0;
            r0 = r31;
            r0.aHp = r3;
            r0 = r30;
            r3 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r3, r0, r1);
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = new java.lang.StringBuilder;
            r6 = "finally : url is ";
            r4.<init>(r6);
            r0 = r17;
            r4 = r4.append(r0);
            r6 = ", filepath";
            r4 = r4.append(r6);
            r0 = r18;
            r4 = r4.append(r0);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.v.i(r3, r4);
            r5.close();	 Catch:{ Exception -> 0x06a0 }
        L_0x067a:
            if (r2 == 0) goto L_0x067f;
        L_0x067c:
            r2.disconnect();
        L_0x067f:
            r7.close();	 Catch:{ IOException -> 0x0684 }
            goto L_0x006c;
        L_0x0684:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x06a0:
            r3 = move-exception;
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "exception : %s ,url is %s filepath %s ";
            r6 = 3;
            r6 = new java.lang.Object[r6];
            r8 = 0;
            r3 = r3.toString();
            r6[r8] = r3;
            r3 = 1;
            r6[r3] = r17;
            r3 = 2;
            r6[r3] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);
            goto L_0x067a;
        L_0x06bb:
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r6 = "url %s ,start to read response ";
            r9 = 1;
            r9 = new java.lang.Object[r9];	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r10 = 0;
            r9[r10] = r17;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            com.tencent.mm.sdk.platformtools.v.i(r3, r6, r9);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r6 = r2.getInputStream();	 Catch:{ Exception -> 0x06f8, UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, all -> 0x0af4 }
        L_0x06ce:
            if (r6 == 0) goto L_0x0b8d;
        L_0x06d0:
            r3 = new java.io.BufferedReader;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r9 = new java.io.InputStreamReader;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r9.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r3.<init>(r9);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r9 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
        L_0x06df:
            r10 = r3.readLine();	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            if (r10 == 0) goto L_0x0723;
        L_0x06e5:
            r0 = r31;
            r11 = r0.aHp;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            if (r11 == 0) goto L_0x0723;
        L_0x06eb:
            r9.append(r10);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            goto L_0x06df;
        L_0x06ef:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r13 = r6;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x01a7;
        L_0x06f8:
            r3 = move-exception;
            r6 = "MicroMsg.AppBrandNetworkUpload";
            r9 = "getInputStream error : %s";
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 0;
            r10[r11] = r3;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            com.tencent.mm.sdk.platformtools.v.e(r6, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r6 = r2.getErrorStream();	 Catch:{ Exception -> 0x070d, UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, all -> 0x0af4 }
            goto L_0x06ce;
        L_0x070d:
            r3 = move-exception;
            r6 = "MicroMsg.AppBrandNetworkUpload";
            r9 = "read err stream failed : %s";
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r11 = 0;
            r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r10[r11] = r3;	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            com.tencent.mm.sdk.platformtools.v.e(r6, r9, r10);	 Catch:{ UnsupportedEncodingException -> 0x0b85, FileNotFoundException -> 0x0b76, SSLHandshakeException -> 0x0b57, SocketTimeoutException -> 0x0b38, Exception -> 0x0b16, all -> 0x0af4 }
            r6 = r13;
            goto L_0x06ce;
        L_0x0723:
            r3 = r9.toString();	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r9 = "MicroMsg.AppBrandNetworkUpload";
            r10 = "upload for url : %s, result = %s, statecode = %s";
            r11 = 3;
            r11 = new java.lang.Object[r11];	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r12 = 0;
            r11[r12] = r8;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r8 = 1;
            r11[r8] = r3;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r8 = 2;
            r11[r8] = r4;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            com.tencent.mm.sdk.platformtools.v.i(r9, r10, r11);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
        L_0x073c:
            r0 = r31;
            r8 = r0.aHp;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            if (r8 == 0) goto L_0x07bd;
        L_0x0742:
            r8 = 0;
            r0 = r24;
            r0.i(r8, r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r8 = "success : url = %s, filePath = %s";
            r9 = 2;
            r9 = new java.lang.Object[r9];	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r10 = 0;
            r9[r10] = r17;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r10 = 1;
            r9[r10] = r18;	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            com.tencent.mm.sdk.platformtools.v.i(r3, r8, r9);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
        L_0x075a:
            r3 = 0;
            r0 = r31;
            r0.aHp = r3;
            r0 = r30;
            r3 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r3, r0, r1);
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = new java.lang.StringBuilder;
            r8 = "finally : url is ";
            r4.<init>(r8);
            r0 = r17;
            r4 = r4.append(r0);
            r8 = ", filepath";
            r4 = r4.append(r8);
            r0 = r18;
            r4 = r4.append(r0);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.v.i(r3, r4);
            r5.close();	 Catch:{ Exception -> 0x07d9 }
        L_0x0792:
            if (r2 == 0) goto L_0x0797;
        L_0x0794:
            r2.disconnect();
        L_0x0797:
            if (r6 == 0) goto L_0x079c;
        L_0x0799:
            r6.close();	 Catch:{ IOException -> 0x07f4 }
        L_0x079c:
            r7.close();	 Catch:{ IOException -> 0x07a1 }
            goto L_0x006c;
        L_0x07a1:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x07bd:
            r3 = 0;
            r8 = "force_stop!";
            r0 = r24;
            r0.i(r3, r8, r4);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r8 = "force stop!";
            com.tencent.mm.sdk.platformtools.v.e(r3, r8);	 Catch:{ UnsupportedEncodingException -> 0x06ef, FileNotFoundException -> 0x07d0, SSLHandshakeException -> 0x0b5f, SocketTimeoutException -> 0x0b40, Exception -> 0x0b1e, all -> 0x0afa }
            goto L_0x075a;
        L_0x07d0:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r13 = r6;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0251;
        L_0x07d9:
            r3 = move-exception;
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "exception : %s ,url is %s filepath %s ";
            r8 = 3;
            r8 = new java.lang.Object[r8];
            r9 = 0;
            r3 = r3.toString();
            r8[r9] = r3;
            r3 = 1;
            r8[r3] = r17;
            r3 = 2;
            r8[r3] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r8);
            goto L_0x0792;
        L_0x07f4:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s , url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x079c;
        L_0x080f:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x020f;
        L_0x082b:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s , url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x0219;
        L_0x0847:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x02b9;
        L_0x0863:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s , url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x02c3;
        L_0x087f:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x0411;
        L_0x089b:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s , url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x041b;
        L_0x08b7:
            r2 = move-exception;
        L_0x08b8:
            r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x0b01 }
            r4 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r6 = 4;
            r8 = 1;
            r10 = 0;
            r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0b01 }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "SocketTimeoutException : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0b01 }
            r6 = 0;
            r2 = r2.toString();	 Catch:{ all -> 0x0b01 }
            r5[r6] = r2;	 Catch:{ all -> 0x0b01 }
            r2 = 1;
            r5[r2] = r17;	 Catch:{ all -> 0x0b01 }
            r2 = 2;
            r5[r2] = r18;	 Catch:{ all -> 0x0b01 }
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0b01 }
            r2 = -1;
            r3 = "socket timeout error";
            r0 = r24;
            r0.i(r2, r3, r11);	 Catch:{ all -> 0x0b01 }
            r2 = 0;
            r0 = r31;
            r0.aHp = r2;
            r0 = r30;
            r2 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r2, r0, r1);
            r2 = "MicroMsg.AppBrandNetworkUpload";
            r3 = new java.lang.StringBuilder;
            r4 = "finally : url is ";
            r3.<init>(r4);
            r0 = r17;
            r3 = r3.append(r0);
            r4 = ", filepath";
            r3 = r3.append(r4);
            r0 = r18;
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.v.i(r2, r3);
            if (r12 == 0) goto L_0x0920;
        L_0x091d:
            r12.close();	 Catch:{ Exception -> 0x094d }
        L_0x0920:
            if (r15 == 0) goto L_0x0925;
        L_0x0922:
            r15.disconnect();
        L_0x0925:
            if (r13 == 0) goto L_0x092a;
        L_0x0927:
            r13.close();	 Catch:{ IOException -> 0x0968 }
        L_0x092a:
            if (r14 == 0) goto L_0x006c;
        L_0x092c:
            r14.close();	 Catch:{ IOException -> 0x0931 }
            goto L_0x006c;
        L_0x0931:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x094d:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x0920;
        L_0x0968:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s , url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x092a;
        L_0x0983:
            r2 = move-exception;
        L_0x0984:
            r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x0b01 }
            r4 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
            r6 = 5;
            r8 = 1;
            r10 = 0;
            r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0b01 }
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0b01 }
            r6 = 0;
            r2 = r2.toString();	 Catch:{ all -> 0x0b01 }
            r5[r6] = r2;	 Catch:{ all -> 0x0b01 }
            r2 = 1;
            r5[r2] = r17;	 Catch:{ all -> 0x0b01 }
            r2 = 2;
            r5[r2] = r18;	 Catch:{ all -> 0x0b01 }
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0b01 }
            r2 = -1;
            r3 = "unkonwn";
            r0 = r24;
            r0.i(r2, r3, r11);	 Catch:{ all -> 0x0b01 }
            r2 = 0;
            r0 = r31;
            r0.aHp = r2;
            r0 = r30;
            r2 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r2, r0, r1);
            r2 = "MicroMsg.AppBrandNetworkUpload";
            r3 = new java.lang.StringBuilder;
            r4 = "finally : url is ";
            r3.<init>(r4);
            r0 = r17;
            r3 = r3.append(r0);
            r4 = ", filepath";
            r3 = r3.append(r4);
            r0 = r18;
            r3 = r3.append(r0);
            r3 = r3.toString();
            com.tencent.mm.sdk.platformtools.v.i(r2, r3);
            if (r12 == 0) goto L_0x09ec;
        L_0x09e9:
            r12.close();	 Catch:{ Exception -> 0x0a19 }
        L_0x09ec:
            if (r15 == 0) goto L_0x09f1;
        L_0x09ee:
            r15.disconnect();
        L_0x09f1:
            if (r13 == 0) goto L_0x09f6;
        L_0x09f3:
            r13.close();	 Catch:{ IOException -> 0x0a34 }
        L_0x09f6:
            if (r14 == 0) goto L_0x006c;
        L_0x09f8:
            r14.close();	 Catch:{ IOException -> 0x09fd }
            goto L_0x006c;
        L_0x09fd:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x006c;
        L_0x0a19:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s ,url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x09ec;
        L_0x0a34:
            r2 = move-exception;
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = "exception : %s , url is %s filepath %s ";
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r2 = r2.toString();
            r5[r6] = r2;
            r2 = 1;
            r5[r2] = r17;
            r2 = 2;
            r5[r2] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
            goto L_0x09f6;
        L_0x0a4f:
            r2 = move-exception;
            r5 = r12;
        L_0x0a51:
            r3 = 0;
            r0 = r31;
            r0.aHp = r3;
            r0 = r30;
            r3 = r0.dMA;
            r0 = r17;
            r1 = r19;
            com.tencent.mm.plugin.appbrand.g.f.a(r3, r0, r1);
            r3 = "MicroMsg.AppBrandNetworkUpload";
            r4 = new java.lang.StringBuilder;
            r6 = "finally : url is ";
            r4.<init>(r6);
            r0 = r17;
            r4 = r4.append(r0);
            r6 = ", filepath";
            r4 = r4.append(r6);
            r0 = r18;
            r4 = r4.append(r0);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.v.i(r3, r4);
            if (r5 == 0) goto L_0x0a8b;
        L_0x0a88:
            r5.close();	 Catch:{ Exception -> 0x0a9b }
        L_0x0a8b:
            if (r15 == 0) goto L_0x0a90;
        L_0x0a8d:
            r15.disconnect();
        L_0x0a90:
            if (r13 == 0) goto L_0x0a95;
        L_0x0a92:
            r13.close();	 Catch:{ IOException -> 0x0ab6 }
        L_0x0a95:
            if (r14 == 0) goto L_0x0a9a;
        L_0x0a97:
            r14.close();	 Catch:{ IOException -> 0x0ad1 }
        L_0x0a9a:
            throw r2;
        L_0x0a9b:
            r3 = move-exception;
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "exception : %s ,url is %s filepath %s ";
            r6 = 3;
            r6 = new java.lang.Object[r6];
            r7 = 0;
            r3 = r3.toString();
            r6[r7] = r3;
            r3 = 1;
            r6[r3] = r17;
            r3 = 2;
            r6[r3] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);
            goto L_0x0a8b;
        L_0x0ab6:
            r3 = move-exception;
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "exception : %s , url is %s filepath %s ";
            r6 = 3;
            r6 = new java.lang.Object[r6];
            r7 = 0;
            r3 = r3.toString();
            r6[r7] = r3;
            r3 = 1;
            r6[r3] = r17;
            r3 = 2;
            r6[r3] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);
            goto L_0x0a95;
        L_0x0ad1:
            r3 = move-exception;
            r4 = "MicroMsg.AppBrandNetworkUpload";
            r5 = "exception : %s ,url is %s filepath %s ";
            r6 = 3;
            r6 = new java.lang.Object[r6];
            r7 = 0;
            r3 = r3.toString();
            r6[r7] = r3;
            r3 = 1;
            r6[r3] = r17;
            r3 = 2;
            r6[r3] = r18;
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);
            goto L_0x0a9a;
        L_0x0aec:
            r2 = move-exception;
            goto L_0x0a51;
        L_0x0aef:
            r3 = move-exception;
            r15 = r2;
            r2 = r3;
            goto L_0x0a51;
        L_0x0af4:
            r3 = move-exception;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0a51;
        L_0x0afa:
            r3 = move-exception;
            r13 = r6;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0a51;
        L_0x0b01:
            r2 = move-exception;
            r5 = r12;
            goto L_0x0a51;
        L_0x0b05:
            r2 = move-exception;
            r12 = r5;
            goto L_0x0984;
        L_0x0b09:
            r3 = move-exception;
            r12 = r5;
            r15 = r2;
            r2 = r3;
            goto L_0x0984;
        L_0x0b0f:
            r3 = move-exception;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0984;
        L_0x0b16:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0984;
        L_0x0b1e:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r13 = r6;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0984;
        L_0x0b27:
            r2 = move-exception;
            r12 = r5;
            goto L_0x08b8;
        L_0x0b2b:
            r3 = move-exception;
            r12 = r5;
            r15 = r2;
            r2 = r3;
            goto L_0x08b8;
        L_0x0b31:
            r3 = move-exception;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x08b8;
        L_0x0b38:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x08b8;
        L_0x0b40:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r13 = r6;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x08b8;
        L_0x0b49:
            r2 = move-exception;
            goto L_0x03a9;
        L_0x0b4c:
            r2 = move-exception;
            r12 = r5;
            goto L_0x03a9;
        L_0x0b50:
            r3 = move-exception;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x03a9;
        L_0x0b57:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x03a9;
        L_0x0b5f:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r13 = r6;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x03a9;
        L_0x0b68:
            r2 = move-exception;
            goto L_0x0251;
        L_0x0b6b:
            r2 = move-exception;
            r12 = r5;
            goto L_0x0251;
        L_0x0b6f:
            r3 = move-exception;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0251;
        L_0x0b76:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x0251;
        L_0x0b7e:
            r2 = move-exception;
            goto L_0x01a7;
        L_0x0b81:
            r2 = move-exception;
            r12 = r5;
            goto L_0x01a7;
        L_0x0b85:
            r3 = move-exception;
            r11 = r4;
            r12 = r5;
            r14 = r7;
            r15 = r2;
            r2 = r3;
            goto L_0x01a7;
        L_0x0b8d:
            r3 = r16;
            goto L_0x073c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.f.b.a(com.tencent.mm.plugin.appbrand.g.g):void");
        }
    }

    static /* synthetic */ void a(f fVar, String str, String str2) {
        if (str != null) {
            Collection arrayList = new ArrayList();
            synchronized (fVar.dMy) {
                Iterator it = fVar.dMy.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (gVar.mUrl.equals(str) && gVar.mName.equals(str2)) {
                        arrayList.add(gVar);
                    }
                }
                if (arrayList.size() > 0) {
                    fVar.dMy.removeAll(arrayList);
                }
            }
        }
    }

    public f(int i) {
        if (i > 0) {
            this.dMg = i;
        }
    }

    public final void a(int i, String str, String str2, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar) {
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("name");
        Map g = i.g(jSONObject);
        if (this.dMy.size() >= this.dMg) {
            aVar.nD("tasked refused max connected");
            v.i("MicroMsg.AppBrandNetworkUpload", "max connected");
        } else if (TextUtils.isEmpty(optString2)) {
            aVar.nD("fileName error");
            v.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        } else if (aO(optString, optString2) != null) {
            v.i("MicroMsg.AppBrandNetworkUpload", "the same task is working");
            aVar.nD("the same task is working");
        } else {
            g gVar = new g(str2, optString, optString2, i, str, aVar);
            gVar.dMC = g;
            gVar.dMu = map;
            gVar.dMv = arrayList;
            gVar.aHp = true;
            synchronized (this.dMy) {
                this.dMy.add(gVar);
            }
            e.a(new b(this, gVar), "appbrand_upload_thread");
        }
    }

    private g aO(String str, String str2) {
        if (str == null) {
            return null;
        }
        synchronized (this.dMy) {
            Iterator it = this.dMy.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.mUrl.equals(str) && gVar.mName.equals(str2)) {
                    return gVar;
                }
            }
            return null;
        }
    }
}
