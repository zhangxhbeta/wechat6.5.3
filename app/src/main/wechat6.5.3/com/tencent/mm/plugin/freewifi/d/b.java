package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.aa;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.z;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import java.util.LinkedList;

public final class b extends c {
    private static int fZs = 7200;
    public String mac;
    private String ssid;

    protected final void apq() {
        a aVar = new a();
        aVar.czn = new z();
        aVar.czo = new aa();
        aVar.uri = "/cgi-bin/mmo2o-bin/apcheck";
        aVar.czm = 1744;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1744;
    }

    public b(String str, String str2, int i, int i2) {
        apq();
        this.ssid = str2;
        this.mac = str;
        LinkedList linkedList = new LinkedList();
        cc ccVar = new cc();
        ccVar.ssid = str2;
        ccVar.mac = str;
        ccVar.mcu = i;
        linkedList.add(ccVar);
        z zVar = (z) this.cif.czk.czs;
        zVar.lZF = b.fWU.aoq();
        zVar.lZn = linkedList;
        zVar.lZG = m.aoG();
        zVar.lZH = i2;
        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[]{str, str2, Integer.valueOf(i)});
    }

    protected final void a(int i, int i2, int i3, String str) {
        int i4;
        boolean z;
        c cVar;
        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (!(this.cif == null || this.cif.czl.czs == null)) {
            b.fWU.a((aa) this.cif.czl.czs);
            if (m.bF(i2, i3) || m.bG(i2, i3)) {
                aa aaVar = (aa) this.cif.czl.czs;
                i4 = aaVar.lZK;
                z = aaVar.lZJ;
                if (!(i4 == 0 || i4 == a.fWV.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
                    a.fWV.ay("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", i4);
                }
                if (z) {
                    a.fWV.s("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
                }
            }
        }
        c tP = j.apj().tP(this.ssid);
        if (tP == null) {
            tP = new c();
            tP.field_ssidmd5 = com.tencent.mm.sdk.platformtools.z.Kg(this.ssid);
            i4 = 1;
            cVar = tP;
        } else {
            i4 = 0;
            cVar = tP;
        }
        if (i2 == 0 && i3 == 0) {
            aaVar = (aa) this.cif.czl.czs;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = aaVar.lZv;
            auy com_tencent_mm_protocal_c_auy = aaVar.lZw;
            if (com_tencent_mm_protocal_c_auy != null) {
                v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_auy.mSu, com_tencent_mm_protocal_c_auy.mSv, com_tencent_mm_protocal_c_auy.mSw});
                cVar.field_showWordCn = com_tencent_mm_protocal_c_auy.mSv;
                cVar.field_showWordEn = com_tencent_mm_protocal_c_auy.mSu;
                cVar.field_showWordTw = com_tencent_mm_protocal_c_auy.mSw;
            } else {
                cVar.field_showWordCn = com.tencent.mm.sdk.platformtools.aa.getContext().getResources().getString(2131232989);
                cVar.field_showWordEn = com.tencent.mm.sdk.platformtools.aa.getContext().getResources().getString(2131232989);
                cVar.field_showWordTw = com.tencent.mm.sdk.platformtools.aa.getContext().getResources().getString(2131232989);
            }
            cVar.field_action = aaVar.lZu;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (aaVar.lZE <= 0) {
                aaVar.lZE = fZs;
            }
            cVar.field_expiredTime = be.Nh() + ((long) aaVar.lZE);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                z = j.apj().b(cVar);
                v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            } else {
                z = j.apj().a(cVar, new String[0]);
                v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(z)});
            }
            j.apj().tQ(this.ssid);
            return;
        }
        v.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            z = j.apj().c(cVar, new String[0]);
            v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(z)});
        }
    }
}
