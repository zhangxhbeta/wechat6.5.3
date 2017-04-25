package com.tencent.mm.wallet_core.b;

import android.content.Context;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tenpay.cert.CertUtil;

public final class a {
    static boolean isInit = false;
    private static a pip = null;
    private boolean piq = false;

    public static a bKZ() {
        if (pip == null) {
            pip = new a();
        }
        return pip;
    }

    public static void init(Context context) {
        if (!isInit) {
            v.d("MicroMsg.CertUtilWx", "init  %s", new Object[]{be.bur().toString()});
            CertUtil.getInstance().init(context);
            isInit = true;
        }
    }

    public final String getCertApplyCSR(String str) {
        String str2;
        v.d("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s", new Object[]{be.bur().toString()});
        synchronized (this) {
            if (this.piq) {
                v.i("MicroMsg.CertUtilWx", "isCert_Wating");
                str2 = "";
            } else {
                this.piq = true;
                str2 = CertUtil.getInstance().getCertApplyCSR(str);
            }
        }
        return str2;
    }

    public final boolean importCert(String str, String str2) {
        boolean importCert;
        v.d("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", new Object[]{str, str2, be.bur().toString()});
        synchronized (this) {
            this.piq = false;
            importCert = CertUtil.getInstance().importCert(str, str2);
        }
        return importCert;
    }

    public final boolean bLa() {
        v.d("MicroMsg.CertUtilWx", "importCertNone");
        synchronized (this) {
            this.piq = false;
        }
        return false;
    }

    public static boolean isCertExist(String str) {
        v.d("MicroMsg.CertUtilWx", "isCertExist stack %s", new Object[]{be.bur().toString()});
        g.iuh.a(414, 5, 1, true);
        boolean isCertExist = CertUtil.getInstance().isCertExist(str);
        g.iuh.a(414, 6, 1, true);
        return isCertExist;
    }

    public static String genUserSig(String str, String str2) {
        v.d("MicroMsg.CertUtilWx", "genUserSig stack %s", new Object[]{be.bur().toString()});
        return CertUtil.getInstance().genUserSig(str, str2);
    }

    public static boolean setTokens(String str, String str2) {
        v.d("MicroMsg.CertUtilWx", "setTokens stack %s", new Object[]{be.bur().toString()});
        return CertUtil.getInstance().setTokens(str, str2);
    }

    public static String getToken(String str) {
        v.d("MicroMsg.CertUtilWx", "getToken stack %s", new Object[]{be.bur().toString()});
        return CertUtil.getInstance().getToken(str);
    }

    public static void clearToken(String str) {
        v.d("MicroMsg.CertUtilWx", "clearToken stack %s", new Object[]{be.bur().toString()});
        CertUtil.getInstance().clearToken(str);
    }

    public static int getTokenCount(String str, boolean z) {
        v.d("MicroMsg.CertUtilWx", "getTokenCount stack %s", new Object[]{be.bur().toString()});
        return CertUtil.getInstance().getTokenCount(str, true);
    }

    public static int getLastError() {
        v.d("MicroMsg.CertUtilWx", "getLastError stack %s", new Object[]{be.bur().toString()});
        return CertUtil.getInstance().getLastError();
    }

    public static void clearCert(String str) {
        v.d("MicroMsg.CertUtilWx", "clearCert stack %s", new Object[]{be.bur().toString()});
        CertUtil.getInstance().clearCert(str);
    }

    public static void clean() {
        v.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", new Object[]{be.bur().toString()});
        CertUtil.getInstance().clearAllCert();
    }
}
