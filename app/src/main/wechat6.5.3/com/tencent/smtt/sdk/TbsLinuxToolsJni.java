package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    private static boolean pwI = false;
    private static boolean pwJ = false;

    public TbsLinuxToolsJni(Context context) {
        synchronized (TbsLinuxToolsJni.class) {
            if (pwJ) {
                return;
            }
            pwJ = true;
            try {
                File file;
                if (q.fz(context)) {
                    file = new File(q.bNx());
                } else {
                    m.bNm();
                    file = m.fr(context);
                }
                if (file != null) {
                    System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                    pwI = true;
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (Throwable th) {
                pwI = false;
            }
        }
    }

    private native int ChmodInner(String str, String str2);

    public final int ef(String str, String str2) {
        if (pwI) {
            return ChmodInner(str, str2);
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
