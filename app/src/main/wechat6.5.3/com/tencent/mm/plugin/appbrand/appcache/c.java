package com.tencent.mm.plugin.appbrand.appcache;

import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class c {
    private static final SparseIntArray dAn;

    static int n(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return wrap.getInt();
    }

    public static String OQ() {
        AppBrandGlobalSystemConfig Py = AppBrandGlobalSystemConfig.Py();
        if (Py == null || !s.HZ(Py.dDe)) {
            return "https://res.servicewechat.com/weapp/release/";
        }
        return Py.dDe.endsWith("/") ? Py.dDe : Py.dDe + "/";
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        dAn = sparseIntArray;
        sparseIntArray.put(0, 2131231035);
        dAn.put(1, 2131230912);
        dAn.put(2, 2131230911);
    }

    public static String gX(int i) {
        return aa.getResources().getString(dAn.get(i, 2131231035));
    }

    public static String Lo(String str) {
        if (be.kS(str)) {
            return str;
        }
        int i = 0;
        while (i < str.length() && '/' == str.charAt(i)) {
            i++;
        }
        return str.substring(i);
    }

    static String mJ(String str) {
        int i = 0;
        v.d("MicroMsg.AppBrandAppCacheUtil", "eliminateDuplicateSlashForPkgFile, original file name = %s", new Object[]{str});
        if (!str.startsWith("/")) {
            return "/" + str;
        }
        while (i < str.length() && '/' == str.charAt(i)) {
            i++;
        }
        return "/" + str.substring(i);
    }
}
