package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.p;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e {
    public static boolean yK(String str) {
        File file = new File("/sdcard/cov.txt");
        if (file.exists()) {
            String A = ai.cse.A("login_user_name", "never_login_crash");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("#username=" + A);
            stringBuffer.append("\n");
            stringBuffer.append("#rev=" + com.tencent.mm.sdk.platformtools.e.cmU);
            stringBuffer.append("\n");
            stringBuffer.append("#path=" + com.tencent.mm.sdk.platformtools.e.cnc);
            stringBuffer.append("\n");
            if (str.length() > 0) {
                stringBuffer.append("#startrev=" + str);
                stringBuffer.append("\n");
            }
            com.tencent.mm.a.e.e(file.getAbsolutePath(), stringBuffer.toString().getBytes());
            String a = p.a(file, false, "/sdcard/cov/cov_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".zip");
            if (a == null) {
                v.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
                return false;
            }
            file.delete();
            v.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :" + A);
            com.tencent.mm.platformtools.p.a(a, A, false, false, 10, 20004);
            return true;
        }
        v.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
        return false;
    }
}
