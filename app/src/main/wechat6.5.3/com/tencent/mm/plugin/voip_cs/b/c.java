package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    public static int kDc = 0;
    public static int kDd = 1;
    public static int kDe = 2;
    public int aKG;
    public int channelStrategy;
    public String deviceModel;
    public long gFH;
    public long gHd;
    public String gHn;
    public String gHo;
    public int kDA;
    public int kDB;
    public int kDC;
    public int kDD;
    public int kDE;
    public long kDF;
    public int kDG;
    public long kDH;
    public long kDI;
    public long kDJ;
    public int kDK;
    public int kDL;
    public int kDM;
    public int kDN;
    public String kDO;
    public String kDP;
    public String kDQ;
    public int kDR;
    public int kDS;
    public int kDT;
    public int kDU;
    public int kDV;
    public int kDW;
    public int kDf;
    public int kDg;
    public int kDh;
    public int kDi;
    public int kDj;
    public int kDk;
    public int kDl;
    public int kDm;
    public int kDn;
    public int kDo;
    public int kDp;
    public int kDq;
    public int kDr;
    public long kDs;
    public String kDt;
    public int kDu;
    public int kDv;
    public int kDw;
    public int kDx;
    public int kDy;
    public int kDz;
    public int kjU;
    public int kvG;
    public int kvR;
    public int kvW;
    public int kvX;
    public int kvY;
    public int kxe;
    public int networkType;

    public c() {
        this.aKG = 0;
        this.kDf = 0;
        this.kDg = 0;
        this.kDh = 0;
        this.kDi = 0;
        this.kDj = 0;
        this.kDk = 0;
        this.kDl = 0;
        this.kDm = 0;
        this.kDn = 0;
        this.kDo = 0;
        this.networkType = 0;
        this.kDp = 0;
        this.kDr = 0;
        this.kvR = 0;
        this.kDs = 0;
        this.gFH = 0;
        this.kDt = "";
        this.kvG = 0;
        this.kDv = 0;
        this.kDw = 0;
        this.kDx = 0;
        this.kDy = 0;
        this.kvX = 0;
        this.kvW = 0;
        this.kDz = 0;
        this.kDA = 1;
        this.kDB = 0;
        this.kDC = 0;
        this.kDD = 0;
        this.kDE = 0;
        this.kDF = 0;
        this.kDH = 0;
        this.kDI = 0;
        this.kDJ = 0;
        this.gHd = 0;
        this.channelStrategy = 1;
        this.kxe = 0;
        this.kvY = 0;
        this.kDM = -1;
        this.kDN = 0;
        this.kDO = "";
        this.deviceModel = "";
        this.kDP = "";
        this.kDQ = "";
        this.kDR = 0;
        this.kDS = 0;
        this.kDT = 0;
        this.kDU = 0;
        this.kDV = 0;
        this.kDW = 0;
        this.kjU = l.rx();
        this.gHo = "";
        this.gHn = "";
        this.kDO = Build.MANUFACTURER;
        if (this.kDO.contains(",")) {
            this.kDO = this.kDO.replace(',', ' ');
        }
        this.deviceModel = Build.MODEL;
        if (this.deviceModel.contains(",")) {
            this.deviceModel = this.deviceModel.replace(',', ' ');
        }
        this.kDP = VERSION.SDK;
        if (this.kDP.contains(",")) {
            this.kDP = this.kDP.replace(',', ' ');
        }
        this.kDQ = VERSION.RELEASE;
        if (this.kDQ.contains(",")) {
            this.kDQ = this.kDQ.replace(',', ' ');
        }
    }

    public final void se(int i) {
        this.kvW = Math.abs(i);
    }

    public final void bee() {
        v.d("MicroMsg.VoipCSReportHelper", "markEndTalk");
        if (this.kDV == 0 && this.kDU != 0) {
            this.kDV = (int) (System.currentTimeMillis() / 1000);
            this.gHd = (long) (this.kDV - this.kDU);
        }
    }

    public final bev bef() {
        bev com_tencent_mm_protocal_c_bev = new bev();
        com_tencent_mm_protocal_c_bev.efm = 2;
        com_tencent_mm_protocal_c_bev.naG = this.gHn;
        v.i("MicroMsg.VoipCSReportHelper", "getVoipCSEngineReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_bev.naG});
        String[] split = this.gHn.split(",");
        if (split != null && split.length > 0) {
            try {
                this.kDi = be.getInt(split[8], 0);
                this.kDj = be.getInt(split[10], 0);
            } catch (Exception e) {
                v.e("MicroMsg.VoipCSReportHelper", "get videoFps and rate fail!!");
            }
        }
        return com_tencent_mm_protocal_c_bev;
    }

    public static int beg() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) aa.getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo == null) {
                    return kDc;
                }
                if (networkInfo.getState() == State.CONNECTED) {
                    return kDd;
                }
                return kDe;
            }
        } catch (Exception e) {
            v.e("MicroMsg.VoipCSReportHelper", "isMobileNetworkAvailable fail!");
        }
        return kDc;
    }

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 0;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 4;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 2;
            }
            return 3;
        } catch (Throwable e) {
            v.a("MicroMsg.VoipCSReportHelper", e, "", new Object[0]);
            return 0;
        }
    }
}
