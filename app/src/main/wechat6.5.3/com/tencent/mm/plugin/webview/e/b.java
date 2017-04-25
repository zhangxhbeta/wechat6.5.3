package com.tencent.mm.plugin.webview.e;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public static final String lgF = Integer.toString(100028);

    public static void b(d dVar) {
        Bundle i;
        try {
            i = dVar.i(24, new Bundle(0));
        } catch (Throwable e) {
            v.a("MicroMsg.WebView.CookiesCleanup", e, "", new Object[0]);
            i = null;
        }
        if (i == null) {
            v.i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
            return;
        }
        List stringArrayList = i.getStringArrayList("cookies_cleanup_url_list");
        if (be.bP(stringArrayList)) {
            v.i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
            return;
        }
        bH(stringArrayList);
        CookieSyncManager.createInstance(aa.getContext()).sync();
        v.i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
    }

    private static void bH(List<String> list) {
        CookieManager instance = CookieManager.getInstance();
        for (String str : list) {
            List list2;
            v.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", new Object[]{str});
            String cookie = instance.getCookie(str);
            if (be.kS(cookie)) {
                list2 = null;
            } else {
                String[] split = cookie.split(";");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split[i] = split[i].trim();
                }
                list2 = new LinkedList();
                for (String str2 : split) {
                    if (!be.kS(str2) && str2.contains("=")) {
                        list2.add(str2.split("=")[0]);
                    }
                }
                if (list2.isEmpty()) {
                    list2 = null;
                }
            }
            a(str, list2, instance);
        }
    }

    private static void a(String str, List<String> list, CookieManager cookieManager) {
        if (!be.bP(list)) {
            String str2;
            String[] split = Uri.parse(str).getHost().split("\\.");
            if (split.length <= 1) {
                str2 = "";
            } else {
                str2 = split[split.length - 2] + "." + split[split.length - 1];
            }
            v.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", new Object[]{r2});
            v.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", new Object[]{str2});
            for (String str3 : list) {
                if (!be.kS(str3)) {
                    cookieManager.setCookie(str, str3 + "=");
                    cookieManager.setCookie(str, str3 + "=;path=/");
                    if (!be.kS(str2)) {
                        cookieManager.setCookie(str2, str3 + "=;domain=." + str2 + ";path=/");
                    }
                }
            }
        }
    }
}
