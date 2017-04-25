package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.ark;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import java.util.LinkedList;

public final class k extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new hq();
        aVar.czo = new hr();
        aVar.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
        aVar.czm = 1705;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1705;
    }

    public k(String str, ark com_tencent_mm_protocal_c_ark, int i, String str2) {
        apq();
        if (!(8 == i && 9 == i)) {
            v.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[]{Integer.valueOf(i)});
        }
        hq hqVar = (hq) this.cif.czk.czs;
        hqVar.mhz = str;
        hqVar.miB = com_tencent_mm_protocal_c_ark;
        hqVar.lZo = i;
        hqVar.lZp = str2;
    }

    public final String apE() {
        LinkedList linkedList = ((hr) this.cif.czl.czs).miC;
        if (linkedList == null || linkedList.size() != 1) {
            return null;
        }
        return ((cd) linkedList.get(0)).mcv;
    }
}
