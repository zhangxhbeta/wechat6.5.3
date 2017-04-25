package com.tencent.mm.ae;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mm.h.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class p {
    private static String[] cOI = null;

    public static boolean GP() {
        boolean z;
        if (cOI == null) {
            GQ();
        }
        if (VERSION.SDK_INT < 14 || cOI == null || cOI.length <= 0 || com.tencent.mm.compatible.d.p.ceJ.cej != 1) {
            z = false;
        } else {
            z = true;
        }
        v.d("MicroMsg.WebpUtil", "isSupportWebp: %b", Boolean.valueOf(z));
        return z;
    }

    private static void GQ() {
        String value = j.sU().getValue("BizEnableWebpUrl");
        v.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", value);
        if (!be.kS(value)) {
            try {
                cOI = value.split(";");
                v.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", Integer.valueOf(cOI.length));
            } catch (Exception e) {
                v.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", e.getMessage());
            }
        }
    }

    private static boolean jd(String str) {
        if (cOI == null || cOI.length <= 0 || be.kS(str)) {
            return false;
        }
        for (String startsWith : cOI) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static String je(String str) {
        if (cOI == null || cOI.length == 0) {
            v.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            GQ();
        }
        if (jd(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("wxtype");
                if (be.kS(queryParameter)) {
                    return str;
                }
                queryParameter = queryParameter.toLowerCase();
                v.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, wxtype:%s", queryParameter);
                if (queryParameter.equals("gif") || queryParameter.contains("gif")) {
                    return str;
                }
                String queryParameter2 = parse.getQueryParameter("tp");
                if ((!be.kS(queryParameter2) && queryParameter2.equals("webp")) || be.kS(queryParameter)) {
                    return str;
                }
                v.d("MicroMsg.WebpUtil", "webpURL: %s", parse.buildUpon().appendQueryParameter("tp", "webp").build().toString());
                return parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
            } catch (Exception e) {
                return str;
            }
        }
        v.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
        return str;
    }

    public static boolean jf(String str) {
        try {
            if (be.kS(str) || !jd(str)) {
                return false;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("tp");
            if (be.kS(queryParameter) || !queryParameter.equals("webp")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int GR() {
        Context context = aa.getContext();
        if (ak.isWifi(context)) {
            return 1;
        }
        if (ak.is4G(context)) {
            return 4;
        }
        if (ak.is3G(context)) {
            return 3;
        }
        if (ak.is2G(context)) {
            return 2;
        }
        return 0;
    }

    public static String fK(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(GR()), Integer.valueOf(2)});
    }

    public static String fL(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(GR()), Integer.valueOf(1)});
    }

    public static String jg(String str) {
        String str2 = null;
        try {
            if (jd(str)) {
                String toLowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
                if (!be.kS(toLowerCase)) {
                    str2 = toLowerCase.toLowerCase();
                }
            }
        } catch (Exception e) {
        }
        return str2;
    }
}
