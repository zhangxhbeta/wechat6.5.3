package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static WxaPkgWrappingInfo a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (wxaPkgWrappingInfo == null) {
            return null;
        }
        if (wxaPkgWrappingInfo.dBu || be.bP(wxaPkgWrappingInfo.dBy) || wxaPkgWrappingInfo.dBx != null) {
            return wxaPkgWrappingInfo;
        }
        synchronized (wxaPkgWrappingInfo) {
            if (wxaPkgWrappingInfo.dBx == null) {
                wxaPkgWrappingInfo.dBx = new HashMap(wxaPkgWrappingInfo.dBy.size());
                Iterator it = wxaPkgWrappingInfo.dBy.iterator();
                while (it.hasNext()) {
                    WxaPkgItemInfo wxaPkgItemInfo = (WxaPkgItemInfo) it.next();
                    wxaPkgWrappingInfo.dBx.put(wxaPkgItemInfo.aST, wxaPkgItemInfo);
                }
            }
        }
        return wxaPkgWrappingInfo;
    }

    private static WebResourceResponse a(String str, String str2, String str3, int i, int i2) {
        try {
            ByteBuffer map = new RandomAccessFile(new File(str), "r").getChannel().map(MapMode.READ_ONLY, (long) i, (long) i2);
            map.order(f.dAq);
            map.limit(i2);
            InputStream aVar = new a(map);
            String Ih = s.Ih(str2);
            String str4 = "UTF-8";
            s.a Ik = s.a.Ik(str3);
            if (Ik != null) {
                Ih = Ik.mimeType;
            }
            if (Ik != null) {
                str4 = Ik.charset;
            }
            return new WebResourceResponse(Ih, str4, aVar);
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandResourceHelper", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", new Object[]{str, be.e(e)});
            return null;
        }
    }

    public static String aq(String str, String str2) {
        if (be.kS(str2)) {
            return "";
        }
        WebResourceResponse ar = ar(str, str2);
        if (ar != null) {
            try {
                v.d("MicroMsg.AppBrandResourceHelper", "getCacheContent, dataStream available = %d, url = %s", new Object[]{Integer.valueOf(ar.getData().available()), str2});
            } catch (Exception e) {
                v.e("MicroMsg.AppBrandResourceHelper", "getCacheContent exp = %s, appId = %s, url = %s", new Object[]{e, str, str2});
            }
            return e(ar.getData());
        }
        v.e("MicroMsg.AppBrandResourceHelper", "get cache content for appId : %s from url : %s, failed", new Object[]{str, str2});
        return "";
    }

    public static WebResourceResponse ar(String str, String str2) {
        v.i("MicroMsg.AppBrandResourceHelper", "getCacheResource called, appId = %s, reqURL = %s", new Object[]{str, str2});
        if (be.kS(str2) || s.ds(str2, "about:blank") || com.tencent.mm.plugin.webview.modelcache.v.Ei(str2)) {
            return null;
        }
        WebResourceResponse webResourceResponse;
        WxaPkgItemInfo wxaPkgItemInfo;
        String mJ = c.mJ(str2);
        v.d("MicroMsg.AppBrandResourceHelper", "tryHitWxaPkgFile with appId(%s), fileName(%s)", new Object[]{str, mJ});
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(str);
        WxaPkgWrappingInfo a = mr == null ? null : a(mr.dDB);
        if (a == null) {
            v.e("MicroMsg.AppBrandResourceHelper", "tryHitWxaPkgFile, get null appInfo by appId %s", new Object[]{str});
            webResourceResponse = null;
        } else if (be.kS(a.dBA) || a.dBx == null) {
            v.e("MicroMsg.AppBrandResourceHelper", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] pkgFileInfoMap[%s] by appId %s", new Object[]{a.dBA, a.dBx, str});
            webResourceResponse = null;
        } else {
            wxaPkgItemInfo = (WxaPkgItemInfo) a.dBx.get(mJ);
            if (wxaPkgItemInfo == null) {
                v.e("MicroMsg.AppBrandResourceHelper", "tryHitWxaPkgFile, fileInfo not found with appId(%s), fileName(%s)", new Object[]{str, mJ});
                webResourceResponse = null;
            } else {
                String str3 = a.dBA;
                if (be.kS(str3)) {
                    v.e("MicroMsg.AppBrandResourceHelper", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                    webResourceResponse = null;
                } else {
                    v.d("MicroMsg.AppBrandResourceHelper", "tryHitWxaPkgFile, fileName(%s), offset = %d, length = %d", new Object[]{mJ, Integer.valueOf(wxaPkgItemInfo.dAU), Integer.valueOf(wxaPkgItemInfo.dAT)});
                    webResourceResponse = a(str3, mJ, wxaPkgItemInfo.bsL, wxaPkgItemInfo.dAU, wxaPkgItemInfo.dAT);
                }
            }
        }
        if (webResourceResponse == null) {
            mr = com.tencent.mm.plugin.appbrand.a.mr(str);
            a = mr == null ? null : a(mr.dDC);
            if (a == null) {
                webResourceResponse = null;
            } else if (a.dBu) {
                InputStream openRead = e.openRead(str2);
                webResourceResponse = openRead != null ? new WebResourceResponse(s.Ih(str2), "UTF-8", openRead) : null;
            } else if (be.kS(a.dBA) || a.dBx == null) {
                v.e("MicroMsg.AppBrandResourceHelper", "tryHitLibWxaPkgFile, pkgPath[%s] or pkgFileInfoMap[%s] is Null Or Nil", new Object[]{a.dBA, a.dBx});
                webResourceResponse = null;
            } else {
                mJ = c.mJ(str2);
                wxaPkgItemInfo = (WxaPkgItemInfo) a.dBx.get(mJ);
                if (wxaPkgItemInfo == null) {
                    v.e("MicroMsg.AppBrandResourceHelper", "tryHitLibWxaPkgFile, fileInfo not found with fileName(%s)", new Object[]{mJ});
                    webResourceResponse = null;
                } else {
                    v.d("MicroMsg.AppBrandResourceHelper", "tryHitLibWxaPkgFile, fileName(%s), offset = %d, length = %d", new Object[]{mJ, Integer.valueOf(wxaPkgItemInfo.dAU), Integer.valueOf(wxaPkgItemInfo.dAT)});
                    webResourceResponse = a(a.dBA, mJ, wxaPkgItemInfo.bsL, wxaPkgItemInfo.dAU, wxaPkgItemInfo.dAT);
                }
            }
        }
        return webResourceResponse;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String e(java.io.InputStream r8) {
        /*
        r7 = 1;
        r6 = 0;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r8);
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new char[r0];
        r2 = new java.io.StringWriter;
        r2.<init>();
    L_0x0010:
        r3 = -1;
        r4 = r1.read(r0);	 Catch:{ Exception -> 0x001c }
        if (r3 == r4) goto L_0x0037;
    L_0x0017:
        r3 = 0;
        r2.write(r0, r3, r4);	 Catch:{ Exception -> 0x001c }
        goto L_0x0010;
    L_0x001c:
        r0 = move-exception;
        r2 = "MicroMsg.AppBrandResourceHelper";
        r3 = "convertStreamToString: read, %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0065 }
        r4[r5] = r0;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        r0 = "";
        r1.close();	 Catch:{ Exception -> 0x0052 }
    L_0x0036:
        return r0;
    L_0x0037:
        r1.close();	 Catch:{ Exception -> 0x003f }
    L_0x003a:
        r0 = r2.toString();
        goto L_0x0036;
    L_0x003f:
        r0 = move-exception;
        r1 = "MicroMsg.AppBrandResourceHelper";
        r3 = "convertStreamToString: close, %s";
        r4 = new java.lang.Object[r7];
        r0 = r0.getMessage();
        r4[r6] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r1, r3, r4);
        goto L_0x003a;
    L_0x0052:
        r1 = move-exception;
        r2 = "MicroMsg.AppBrandResourceHelper";
        r3 = "convertStreamToString: close, %s";
        r4 = new java.lang.Object[r7];
        r1 = r1.getMessage();
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        goto L_0x0036;
    L_0x0065:
        r0 = move-exception;
        r1.close();	 Catch:{ Exception -> 0x006a }
    L_0x0069:
        throw r0;
    L_0x006a:
        r1 = move-exception;
        r2 = "MicroMsg.AppBrandResourceHelper";
        r3 = "convertStreamToString: close, %s";
        r4 = new java.lang.Object[r7];
        r1 = r1.getMessage();
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.b.e(java.io.InputStream):java.lang.String");
    }
}
