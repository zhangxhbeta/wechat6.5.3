package com.tencent.mm.plugin.voip_cs.b.c;

import android.telephony.TelephonyManager;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.protocal.c.bew;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class e extends k implements j {
    public b cif;
    private com.tencent.mm.v.e cii;

    public e(long j, long j2) {
        int i;
        com.tencent.mm.plugin.voip.model.k bct;
        byte[] bArr;
        a aVar = new a();
        aVar.czn = new bew();
        aVar.czo = new bex();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipreport";
        aVar.czm = 312;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bew com_tencent_mm_protocal_c_bew = (bew) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bew.nat = j;
        com_tencent_mm_protocal_c_bew.mqT = j2;
        LinkedList linkedList = com_tencent_mm_protocal_c_bew.naH;
        c bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        bev com_tencent_mm_protocal_c_bev = new bev();
        com_tencent_mm_protocal_c_bev.efm = 1;
        com_tencent_mm_protocal_c_bev.naG = bed.gHo;
        v.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_bev.naG});
        linkedList.add(com_tencent_mm_protocal_c_bev);
        com_tencent_mm_protocal_c_bew.naH.add(com.tencent.mm.plugin.voip_cs.b.b.bed().bef());
        LinkedList linkedList2 = com_tencent_mm_protocal_c_bew.naH;
        c bed2 = com.tencent.mm.plugin.voip_cs.b.b.bed();
        bev com_tencent_mm_protocal_c_bev2 = new bev();
        com_tencent_mm_protocal_c_bev2.efm = 3;
        bed2.kvX = ak.yX().rf();
        bed2.se(com.tencent.mm.plugin.voip_cs.b.a.a.bej().kve.bdR());
        int i2 = bed2.kjU & 255;
        bed2.kxe = i2;
        bed2.kxe = i2;
        bed2.kDK = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.field_audioDuration;
        bed2.kDL = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.field_videoDuration;
        if (bed2.kDo != 1 && bed2.kDW != 1) {
            bed2.kDC = 1;
        } else if (bed2.kDo != 1) {
            bed2.kDC = 2;
        } else if (bed2.kDW != 1) {
            bed2.kDC = 3;
        } else {
            bed2.kDC = 0;
        }
        bed2.kDv = com.tencent.mm.plugin.voip.b.a.getNetType(aa.getContext());
        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO;
        com_tencent_mm_plugin_voip_model_v2protocal.setJNIAppCmd(1, com_tencent_mm_plugin_voip_model_v2protocal.kwM, com_tencent_mm_plugin_voip_model_v2protocal.kwM.length);
        i2 = (int) (v2protocal.aL(com_tencent_mm_plugin_voip_model_v2protocal.kwM) / 1000);
        i2 = (bed2.kDR == 0 || i2 <= bed2.kDR) ? 0 : i2 - bed2.kDR;
        bed2.kDJ = (long) i2;
        com_tencent_mm_protocal_c_bev2.naG = bed2.kvR + "," + bed2.kDs + "," + bed2.gFH + "," + bed2.kDt + "," + bed2.kDu + "," + bed2.kvG + "," + bed2.kDv + "," + bed2.kDw + "," + bed2.kDx + "," + bed2.kDy + "," + bed2.kvX + "," + bed2.kvW + "," + bed2.kDz + "," + bed2.kDA + "," + bed2.kDB + "," + bed2.kDC + "," + bed2.kDD + "," + bed2.kDE + "," + bed2.kDF + "," + bed2.kDG + "," + bed2.kDH + "," + bed2.kDI + "," + bed2.kDJ + "," + bed2.gHd + "," + bed2.kDK + "," + bed2.kDL + "," + bed2.channelStrategy + "," + bed2.kxe + "," + bed2.kvY + "," + bed2.kDM + "," + bed2.kDN + "," + bed2.kDO + "," + bed2.deviceModel + "," + bed2.kDP + "," + bed2.kDQ;
        v.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[]{com_tencent_mm_protocal_c_bev2.naG});
        linkedList2.add(com_tencent_mm_protocal_c_bev2);
        linkedList = com_tencent_mm_protocal_c_bew.naH;
        bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
        com_tencent_mm_protocal_c_bev = new bev();
        com_tencent_mm_protocal_c_bev.efm = 4;
        bed.networkType = c.getNetType(aa.getContext());
        String simOperator = ((TelephonyManager) aa.getContext().getSystemService("phone")).getSimOperator();
        if (simOperator != null) {
            if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                i = 1;
                bed.kDp = i;
                bed.kDf = (int) (System.currentTimeMillis() / 1000);
                bed.kDq = c.beg();
                bed.kvX = ak.yX().rf();
                bct = com.tencent.mm.plugin.voip.model.k.bct();
                bed.kDr = bct.kuI != 0 ? bct.kuH / bct.kuI : -1;
                if (bed.kDr == -1) {
                    bArr = new byte[4];
                    if (com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.setAppCmd(10, bArr, 4) < 0) {
                        bed.kDr = 0;
                        v.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                    } else {
                        bed.kDr = be.aA(bArr);
                    }
                }
                v.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bed.aKG), Integer.valueOf(bed.kDf), Integer.valueOf(bed.kDg), Integer.valueOf(bed.kDh), Integer.valueOf(bed.kDi), Integer.valueOf(bed.kDj), Integer.valueOf(bed.kDk), Integer.valueOf(bed.kDl), Integer.valueOf(bed.kDm), Integer.valueOf(bed.kDn), Integer.valueOf(bed.kDo), Integer.valueOf(bed.networkType), Integer.valueOf(bed.kDp), Integer.valueOf(bed.kDq), Integer.valueOf(bed.kDr)});
                com_tencent_mm_protocal_c_bev.naG = bed.aKG + "," + bed.kDf + "," + bed.kDg + "," + bed.kDh + "," + bed.kDi + "," + bed.kDj + "," + bed.kDk + "," + bed.kDl + "," + bed.kDm + "," + bed.kDn + "," + bed.kDo + "," + bed.networkType + "," + bed.kDp + "," + bed.kDq + "," + bed.kDr + "," + bed.kDs + "," + bed.gFH;
                v.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_bev.naG);
                linkedList.add(com_tencent_mm_protocal_c_bev);
            }
            if (simOperator.equals("46001")) {
                i = 3;
            } else if (simOperator.equals("46003")) {
                i = 2;
            }
            bed.kDp = i;
            bed.kDf = (int) (System.currentTimeMillis() / 1000);
            bed.kDq = c.beg();
            bed.kvX = ak.yX().rf();
            bct = com.tencent.mm.plugin.voip.model.k.bct();
            if (bct.kuI != 0) {
            }
            bed.kDr = bct.kuI != 0 ? bct.kuH / bct.kuI : -1;
            if (bed.kDr == -1) {
                bArr = new byte[4];
                if (com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.setAppCmd(10, bArr, 4) < 0) {
                    bed.kDr = be.aA(bArr);
                } else {
                    bed.kDr = 0;
                    v.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                }
            }
            v.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bed.aKG), Integer.valueOf(bed.kDf), Integer.valueOf(bed.kDg), Integer.valueOf(bed.kDh), Integer.valueOf(bed.kDi), Integer.valueOf(bed.kDj), Integer.valueOf(bed.kDk), Integer.valueOf(bed.kDl), Integer.valueOf(bed.kDm), Integer.valueOf(bed.kDn), Integer.valueOf(bed.kDo), Integer.valueOf(bed.networkType), Integer.valueOf(bed.kDp), Integer.valueOf(bed.kDq), Integer.valueOf(bed.kDr)});
            com_tencent_mm_protocal_c_bev.naG = bed.aKG + "," + bed.kDf + "," + bed.kDg + "," + bed.kDh + "," + bed.kDi + "," + bed.kDj + "," + bed.kDk + "," + bed.kDl + "," + bed.kDm + "," + bed.kDn + "," + bed.kDo + "," + bed.networkType + "," + bed.kDp + "," + bed.kDq + "," + bed.kDr + "," + bed.kDs + "," + bed.gFH;
            v.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_bev.naG);
            linkedList.add(com_tencent_mm_protocal_c_bev);
        }
        i = 0;
        bed.kDp = i;
        bed.kDf = (int) (System.currentTimeMillis() / 1000);
        bed.kDq = c.beg();
        bed.kvX = ak.yX().rf();
        bct = com.tencent.mm.plugin.voip.model.k.bct();
        if (bct.kuI != 0) {
        }
        bed.kDr = bct.kuI != 0 ? bct.kuH / bct.kuI : -1;
        if (bed.kDr == -1) {
            bArr = new byte[4];
            if (com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.setAppCmd(10, bArr, 4) < 0) {
                bed.kDr = 0;
                v.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
            } else {
                bed.kDr = be.aA(bArr);
            }
        }
        v.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[]{Integer.valueOf(bed.aKG), Integer.valueOf(bed.kDf), Integer.valueOf(bed.kDg), Integer.valueOf(bed.kDh), Integer.valueOf(bed.kDi), Integer.valueOf(bed.kDj), Integer.valueOf(bed.kDk), Integer.valueOf(bed.kDl), Integer.valueOf(bed.kDm), Integer.valueOf(bed.kDn), Integer.valueOf(bed.kDo), Integer.valueOf(bed.networkType), Integer.valueOf(bed.kDp), Integer.valueOf(bed.kDq), Integer.valueOf(bed.kDr)});
        com_tencent_mm_protocal_c_bev.naG = bed.aKG + "," + bed.kDf + "," + bed.kDg + "," + bed.kDh + "," + bed.kDi + "," + bed.kDj + "," + bed.kDk + "," + bed.kDl + "," + bed.kDm + "," + bed.kDn + "," + bed.kDo + "," + bed.networkType + "," + bed.kDp + "," + bed.kDq + "," + bed.kDr + "," + bed.kDs + "," + bed.gFH;
        v.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + com_tencent_mm_protocal_c_bev.naG);
        linkedList.add(com_tencent_mm_protocal_c_bev);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 312;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
