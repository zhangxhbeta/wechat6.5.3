package com.tencent.mm.plugin.appbrand.e;

import com.tencent.mm.c.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    private static b dLJ = null;
    private static String dLK = null;
    private static Runnable dLL = null;
    private static ah dLM = null;

    private static void QI() {
        if (dLM != null) {
            dLM.QI();
        }
        dLM = null;
    }

    private static b QJ() {
        if (dLJ == null) {
            dLJ = new b(com.tencent.mm.compatible.b.b.a.caV);
        }
        return dLJ;
    }

    public static boolean a(String str, Runnable runnable) {
        oT();
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrand.AudioRecorder", "startRecord, path is null or nil");
            return false;
        } else if (QJ() == null) {
            return false;
        } else {
            b QJ = QJ();
            if (QJ.aTG == com.tencent.mm.compatible.b.b.a.caU) {
                if (QJ.aTE != null) {
                    QJ.aTE.reset();
                }
            } else if (QJ.aTH != b.b.aTP) {
                QJ.release();
                QJ.pg();
            }
            QJ().pe();
            QJ().pf();
            QJ().pd();
            QJ().setOutputFile(str);
            QJ().setMaxDuration(60000);
            try {
                QJ().prepare();
                QJ().start();
                dLL = runnable;
                dLK = str;
                QI();
                ah ahVar = new ah(new com.tencent.mm.sdk.platformtools.ah.a() {
                    public final boolean oU() {
                        a.oT();
                        return false;
                    }
                }, false);
                dLM = ahVar;
                ahVar.ea(60000);
                return true;
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.AudioRecorder", "record prepare, exp = %s", new Object[]{be.e(e)});
                return false;
            }
        }
    }

    public static void oT() {
        if (!be.kS(dLK)) {
            QJ().ph();
            QJ().release();
            QI();
            dLK = null;
            if (dLL != null) {
                dLL.run();
            }
            dLL = null;
        }
    }
}
