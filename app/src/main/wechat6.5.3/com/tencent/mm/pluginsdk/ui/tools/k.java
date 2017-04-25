package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public final class k {
    private static String lUn = null;
    private static final String[] lUo = new String[]{SQLiteDatabase.KeyEmpty, "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use"};

    public static void kZ(int i) {
        cq(i, 0);
    }

    public static void cq(int i, int i2) {
        if (i <= 0 || i > 7) {
            v.e("MicroMsg.TBSReporter", "report invalid scene = %d", Integer.valueOf(i));
            return;
        }
        v.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", Integer.valueOf(i), lUo[i], Integer.valueOf(i2));
        Context context = aa.getContext();
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        String dn = dn(context);
        g.iuh.a(11633, false, true, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(tbsCoreVersion), Integer.valueOf(tbsSDKVersion), dn, Integer.valueOf(i2));
    }

    private static String dn(Context context) {
        if (lUn != null) {
            return lUn;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(aa.getPackageName(), FileUtils.S_IWUSR);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String string = applicationInfo.metaData.getString("com.tencent.mtt.TBS_CODE");
                if (!be.kS(string)) {
                    lUn = string;
                    return string;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", e.getMessage());
        }
        return null;
    }
}
