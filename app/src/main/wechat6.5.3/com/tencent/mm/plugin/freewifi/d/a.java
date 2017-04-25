package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.protocal.c.qz;
import com.tencent.mm.protocal.c.x;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a extends c {
    private static int fZs = 7200;
    private int bdf;
    private String mac;
    private String ssid;

    protected final void apq() {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new x();
        aVar.czo = new y();
        aVar.uri = "/cgi-bin/micromsg-bin/apauth";
        aVar.czm = 640;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 640;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        apq();
        this.ssid = str2;
        this.mac = str3;
        x xVar = (x) this.cif.czk.czs;
        String decode = URLDecoder.decode(str5);
        xVar.lZm = 0;
        xVar.URL = str;
        xVar.SSID = str2;
        xVar.lZj = str4;
        xVar.lZk = decode;
        xVar.lZl = str6;
        xVar.lZo = i;
        xVar.lZp = str7;
        LinkedList linkedList = new LinkedList();
        cc ccVar = new cc();
        ccVar.ssid = str2;
        ccVar.mac = str3;
        linkedList.add(ccVar);
        xVar.lZn = linkedList;
        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[]{str, str2, str4, str3, str5, decode, str6});
    }

    public a(String str, String str2, String str3, int i, int i2, String str4) {
        apq();
        this.ssid = str3;
        this.mac = str2;
        this.bdf = 1;
        LinkedList linkedList = new LinkedList();
        cc ccVar = new cc();
        ccVar.ssid = str3;
        ccVar.mac = str2;
        ccVar.mcu = i;
        linkedList.add(ccVar);
        x xVar = (x) this.cif.czk.czs;
        xVar.lZm = 1;
        xVar.lZn = linkedList;
        xVar.URL = str;
        xVar.lZo = i2;
        xVar.lZp = str4;
        xVar.lZr = m.tD("MicroMsg.FreeWifi.NetSceneAPAuth");
        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[]{Integer.valueOf(1), str2, str3, Integer.valueOf(i)});
    }

    public a(String str, int i, String str2) {
        apq();
        this.bdf = 4;
        x xVar = (x) this.cif.czk.czs;
        xVar.lZm = 4;
        xVar.URL = str;
        xVar.lZo = i;
        xVar.lZp = str2;
        xVar.lZq = m.aoE();
        xVar.lZn = new LinkedList();
        cc ccVar = new cc();
        ccVar.ssid = m.tB("MicroMsg.FreeWifi.NetSceneAPAuth");
        ccVar.mac = m.tC("MicroMsg.FreeWifi.NetSceneAPAuth");
        xVar.lZn.add(ccVar);
        xVar.lZr = m.tD("MicroMsg.FreeWifi.NetSceneAPAuth");
        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[]{Integer.valueOf(xVar.lZq), ccVar.ssid, ccVar.mac});
        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[]{Integer.valueOf(4), str});
    }

    protected final void a(int i, int i2, int i3, String str) {
        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.bdf)});
        c tP;
        c cVar;
        Object obj;
        y yVar;
        auy com_tencent_mm_protocal_c_auy;
        switch (this.bdf) {
            case 0:
                if (i2 == 0 && i3 == 0) {
                    tP = j.apj().tP(this.ssid);
                    String str2 = "MicroMsg.FreeWifi.NetSceneAPAuth";
                    String str3 = "get freewifi by ssid :%s, is wifi info = null ? %b";
                    Object[] objArr = new Object[2];
                    objArr[0] = this.ssid;
                    objArr[1] = Boolean.valueOf(tP == null);
                    v.i(str2, str3, objArr);
                    if (tP == null) {
                        tP = new c();
                        tP.field_ssidmd5 = z.Kg(this.ssid);
                        cVar = tP;
                        obj = 1;
                    } else {
                        cVar = tP;
                        obj = null;
                    }
                    cVar.field_wifiType = 1;
                    yVar = (y) this.cif.czl.czs;
                    com_tencent_mm_protocal_c_auy = yVar.lZw;
                    if (com_tencent_mm_protocal_c_auy != null) {
                        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_auy.mSu, com_tencent_mm_protocal_c_auy.mSv, com_tencent_mm_protocal_c_auy.mSw});
                        cVar.field_showWordCn = com_tencent_mm_protocal_c_auy.mSv;
                        cVar.field_showWordEn = com_tencent_mm_protocal_c_auy.mSu;
                        cVar.field_showWordTw = com_tencent_mm_protocal_c_auy.mSw;
                    } else {
                        cVar.field_showWordCn = aa.getContext().getResources().getString(2131232989);
                        cVar.field_showWordEn = aa.getContext().getResources().getString(2131232989);
                        cVar.field_showWordTw = aa.getContext().getResources().getString(2131232989);
                    }
                    cVar.field_action = yVar.lZu;
                    cVar.field_verifyResult = 1;
                    cVar.field_connectState = -1;
                    if (yVar.lZE <= 0) {
                        yVar.lZE = fZs;
                    }
                    cVar.field_expiredTime = be.Nh() + ((long) yVar.lZE);
                    cVar.field_showUrl = yVar.lZv;
                    cVar.field_action = yVar.lZu;
                    cVar.field_ssid = this.ssid;
                    cVar.field_mac = this.mac;
                    cVar.field_wifiType = 1;
                    boolean b;
                    if (obj != null) {
                        b = j.apj().b(cVar);
                        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b)});
                        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(yVar.lZt), Integer.valueOf(yVar.lZu), yVar.lZv});
                        return;
                    }
                    b = j.apj().a(cVar, new String[0]);
                    v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Boolean.valueOf(b), Integer.valueOf(yVar.lZt), Integer.valueOf(yVar.lZu), yVar.lZv});
                    return;
                }
                return;
            case 1:
                tP = j.apj().tP(this.ssid);
                if (tP == null) {
                    tP = new c();
                    tP.field_ssidmd5 = z.Kg(this.ssid);
                    cVar = tP;
                    obj = 1;
                } else {
                    cVar = tP;
                    obj = null;
                }
                boolean b2;
                if (i2 == 0 && i3 == 0) {
                    yVar = (y) this.cif.czl.czs;
                    cVar.field_ssid = this.ssid;
                    cVar.field_showUrl = yVar.lZv;
                    com_tencent_mm_protocal_c_auy = yVar.lZw;
                    v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[]{this.ssid, Integer.valueOf(yVar.lZt), Integer.valueOf(yVar.lZu), yVar.lZv});
                    if (com_tencent_mm_protocal_c_auy != null) {
                        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[]{com_tencent_mm_protocal_c_auy.mSu, com_tencent_mm_protocal_c_auy.mSv, com_tencent_mm_protocal_c_auy.mSw});
                        cVar.field_showWordCn = com_tencent_mm_protocal_c_auy.mSv;
                        cVar.field_showWordEn = com_tencent_mm_protocal_c_auy.mSu;
                        cVar.field_showWordTw = com_tencent_mm_protocal_c_auy.mSw;
                    } else {
                        cVar.field_showWordCn = aa.getContext().getResources().getString(2131232989);
                        cVar.field_showWordEn = aa.getContext().getResources().getString(2131232989);
                        cVar.field_showWordTw = aa.getContext().getResources().getString(2131232989);
                    }
                    cVar.field_action = yVar.lZu;
                    cVar.field_verifyResult = 1;
                    cVar.field_connectState = -1;
                    if (yVar.lZE <= 0) {
                        yVar.lZE = fZs;
                    }
                    cVar.field_expiredTime = be.Nh() + ((long) yVar.lZE);
                    cVar.field_mac = this.mac;
                    if (obj != null) {
                        b2 = j.apj().b(cVar);
                        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    } else {
                        b2 = j.apj().a(cVar, new String[0]);
                        v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[]{Boolean.valueOf(b2)});
                    }
                    j.apj().tQ(this.ssid);
                    return;
                }
                v.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[]{this.ssid});
                if (obj == null) {
                    b2 = j.apj().c(cVar, new String[0]);
                    v.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[]{this.ssid, Boolean.valueOf(b2)});
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final String apr() {
        y yVar = (y) this.cif.czl.czs;
        if (yVar != null) {
            return yVar.lZs;
        }
        return null;
    }

    public final aoj aps() {
        y yVar = (y) this.cif.czl.czs;
        if (yVar != null) {
            return yVar.lZz;
        }
        return null;
    }

    public final boolean apt() {
        y yVar = (y) this.cif.czl.czs;
        if (yVar == null || yVar.lZA == null) {
            return false;
        }
        if (yVar.lZA.lZq == 1) {
            return true;
        }
        return false;
    }

    public final qz apu() {
        y yVar = (y) this.cif.czl.czs;
        if (yVar != null) {
            return yVar.lZA;
        }
        return null;
    }

    public final String apv() {
        y yVar = (y) this.cif.czl.czs;
        if (yVar != null) {
            return yVar.lZC;
        }
        return null;
    }

    public final String apw() {
        y yVar = (y) this.cif.czl.czs;
        if (yVar != null) {
            return yVar.lZD;
        }
        return null;
    }

    public final dq apx() {
        y yVar = (y) this.cif.czl.czs;
        if (yVar != null) {
            return yVar.lZB;
        }
        return null;
    }
}
