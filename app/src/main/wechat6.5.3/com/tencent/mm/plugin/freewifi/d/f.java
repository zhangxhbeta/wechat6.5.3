package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.v.b.a;

public final class f extends c {
    private static int fZs = 7200;
    private String mac;
    private String ssid;

    protected final void apq() {
        a aVar = new a();
        aVar.czn = new sr();
        aVar.czo = new ss();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        aVar.czm = 1726;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1726;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        apq();
        this.ssid = str;
        this.mac = str2;
        cc ccVar = new cc();
        ccVar.mac = str2;
        ccVar.ssid = str;
        sr srVar = (sr) this.cif.czk.czs;
        srVar.appId = str3;
        srVar.fZS = str4;
        srVar.fZT = str5;
        srVar.fZU = str6;
        srVar.fZV = str7;
        srVar.fZW = str8;
        srVar.mwq = ccVar;
    }

    protected final void a(int i, int i2, int i3, String str) {
        int i4;
        c cVar;
        c tP = j.apj().tP(this.ssid);
        if (tP == null) {
            tP = new c();
            tP.field_ssidmd5 = z.Kg(this.ssid);
            i4 = 1;
            cVar = tP;
        } else {
            i4 = 0;
            cVar = tP;
        }
        boolean b;
        if (i2 == 0 && i3 == 0) {
            ss ssVar = (ss) this.cif.czl.czs;
            cVar.field_ssid = this.ssid;
            cVar.field_showUrl = ssVar.lZv;
            auy com_tencent_mm_protocal_c_auy = ssVar.lZw;
            if (com_tencent_mm_protocal_c_auy != null) {
                v.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_auy.mSu, com_tencent_mm_protocal_c_auy.mSv, com_tencent_mm_protocal_c_auy.mSw});
                cVar.field_showWordCn = com_tencent_mm_protocal_c_auy.mSv;
                cVar.field_showWordEn = com_tencent_mm_protocal_c_auy.mSu;
                cVar.field_showWordTw = com_tencent_mm_protocal_c_auy.mSw;
            } else {
                cVar.field_showWordCn = aa.getContext().getResources().getString(2131232989);
                cVar.field_showWordEn = aa.getContext().getResources().getString(2131232989);
                cVar.field_showWordTw = aa.getContext().getResources().getString(2131232989);
            }
            cVar.field_action = ssVar.lZu;
            cVar.field_verifyResult = 1;
            cVar.field_connectState = -1;
            if (ssVar.lZE <= 0) {
                ssVar.lZE = fZs;
            }
            cVar.field_expiredTime = be.Nh() + ((long) ssVar.lZE);
            cVar.field_mac = this.mac;
            if (i4 != 0) {
                b = j.apj().b(cVar);
                v.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            } else {
                b = j.apj().a(cVar, new String[0]);
                v.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
            }
            j.apj().tQ(this.ssid);
            return;
        }
        v.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
        if (i4 == 0) {
            b = j.apj().c(cVar, new String[0]);
            v.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b)});
        }
    }

    public final dq apx() {
        return ((ss) this.cif.czl.czs).gbO;
    }
}
