package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class o implements ICallBack {
    private static long dlm = 0;
    private static int dln = 0;
    private final String TAG = "IPxxCallback";

    public final String getUplodLogExtrasInfo() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Device:").append(d.lWb).append(" ").append(d.lWc).append("\n");
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public final void setNewDnsDebugHostInfo(String str, int i) {
        MMLogic.setNewDnsDebugHost(str, String.valueOf(i));
    }

    public final String getCrashFilePath(int i) {
        String str = e.cnk + "crash_" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis() - (((long) i) * 86400000))) + ".txt";
        return com.tencent.mm.a.e.aR(str) ? str : null;
    }

    public final void recoverLinkAddrs() {
        MMLogic.recoverLinkAddrs();
    }

    public final void uploadLogResponse(long j, long j2) {
        int i = 100;
        int i2 = 0;
        v.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(dln));
        long Nh = be.Nh();
        if (Nh - 1 >= dlm) {
            dlm = Nh;
            if (j2 >= 0 && j > 0 && j2 < j) {
                i2 = (int) ((100 * j2) / j);
            }
            if (i2 <= 100) {
                i = i2;
            }
            if (dln > i) {
                i = dln;
            }
            dln = i;
            gA(i);
        }
    }

    public final void uploadLogFail() {
        dln = 0;
        gA(-1);
    }

    public final void uploadLogSuccess() {
        dln = 0;
        gA(100);
    }

    private static void gA(int i) {
        try {
            s Mx = z.Mx();
            if (Mx.dlA != null) {
                try {
                    Mx.dlA.cF(i);
                } catch (Throwable e) {
                    v.e("MicroMsg.AutoAuth", "exception:%s", be.e(e));
                }
            }
        } catch (Throwable e2) {
            v.e("IPxxCallback", "exception:%s", be.e(e2));
        }
    }
}
