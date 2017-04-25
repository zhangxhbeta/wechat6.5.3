package com.tencent.mm.plugin.report.service;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.BaseInfo;
import com.tencent.mars.smc.SmcLogic.ICallBack;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ak.j;
import com.tencent.mm.ba.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.b.f;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class h implements ICallBack {
    public static IKVReportNotify iup = null;

    public final void onReportDataReady(byte[] bArr, byte[] bArr2, int i) {
        try {
            if (iup != null && bArr2 != null && bArr2.length > 0) {
                iup.onReportKVDataReady(bArr, bArr2, i);
            }
        } catch (Exception e) {
            v.e("KVReportJni", e.getMessage());
        }
    }

    public final boolean onRequestGetStrategy(byte[] bArr, int i) {
        try {
            if (ak.yN()) {
                v.e("MicroMsg.SmcCallBack", "MMCore not inited");
                return false;
            }
            synchronized (this) {
                if (f.isRunning()) {
                    v.i("KVReportJni", "already running");
                    return false;
                }
                ak.vy().a(new f(), 0);
                return true;
            }
        } catch (Exception e) {
            v.e("KVReportJni", "onRequestGetStrategy error: " + e.getMessage());
            return false;
        }
    }

    public final boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        if (!ak.uz() || be.bl(ak.uT())) {
            v.e("MicroMsg.SmcCallBack", "onReportKVDaSelfMonitorOpLogReady account not ready");
            return false;
        }
        try {
            k kVar = new k();
            kVar.az(bArr);
            a toMMSelfMonitor = SmcProtoBufUtil.toMMSelfMonitor(kVar);
            if (toMMSelfMonitor.mDR <= 0) {
                v.e("KVReportJni", "error selfmonitor count");
                return true;
            }
            ak.yW();
            c.wG().b(new j.a(202, toMMSelfMonitor));
            return true;
        } catch (Exception e) {
            v.e("KVReportJni", e.getMessage());
            return false;
        }
    }

    public final int getSingleReportBufSizeB() {
        return 20480;
    }

    public final BaseInfo getKVCommReqBaseInfo() {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.deviceModel = Build.MODEL + Build.CPU_ABI;
        baseInfo.deviceBrand = Build.BRAND;
        baseInfo.osName = "android-" + Build.MANUFACTURER;
        baseInfo.osVersion = VERSION.SDK_INT;
        baseInfo.languageVer = u.bsY();
        return baseInfo;
    }

    public final String getKVCommPath() {
        return AppLogic.getAppFilePath() + "/kvcomm/";
    }

    public static void yL(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.SmcCallBack", "msg content is null");
            return;
        }
        v.i("MicroMsg.SmcCallBack", "receive msg: " + str);
        Map q = com.tencent.mm.b.f.q(str, "sysmsg");
        if (q == null || q.size() == 0) {
            v.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        String str2 = (String) q.get(".sysmsg.$type");
        if (be.kS(str2) || !str2.equalsIgnoreCase("getkvidkeystg")) {
            v.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        long j = be.getLong((String) q.get(".sysmsg.getkvidkeystg.generalversion"), -1);
        long j2 = be.getLong((String) q.get(".sysmsg.getkvidkeystg.specialversion"), -1);
        long j3 = be.getLong((String) q.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1);
        long j4 = be.getLong((String) q.get(".sysmsg.getkvidkeystg.timeinterval"), -1);
        long j5 = be.getLong((String) q.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1);
        long j6 = be.getLong((String) q.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1);
        long j7 = be.getLong((String) q.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1);
        if (j == -1 || j2 == -1 || j3 == -1 || j4 == -1 || -1 == j5 || -1 == j6 || -1 == j7) {
            v.e("MicroMsg.SmcCallBack", "plugin msg parse fail:" + str);
            return;
        }
        v.i("MicroMsg.SmcCallBack", "plugin msg version:" + j + ", " + j2 + ", " + j3);
        SmcLogic.OnPluginMsg(j5, j6, j7, j, j2, j4);
    }
}
