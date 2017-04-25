package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class n extends k implements j {
    private final b cif;
    private e cii = null;

    public final int getType() {
        return 340;
    }

    public n(String str, String str2, String str3, List<String> list) {
        a aVar = new a();
        aVar.czn = new asx();
        aVar.czo = new asy();
        aVar.uri = "/cgi-bin/micromsg-bin/sendqrcodebyemail";
        aVar.czm = 340;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        asx com_tencent_mm_protocal_c_asx = (asx) this.cif.czk.czs;
        com_tencent_mm_protocal_c_asx.mRp = str;
        com_tencent_mm_protocal_c_asx.hQP = str3;
        com_tencent_mm_protocal_c_asx.mRs = str2;
        com_tencent_mm_protocal_c_asx.mRq = list.size();
        LinkedList linkedList = new LinkedList();
        for (String JF : list) {
            linkedList.add(new arf().JF(JF));
        }
        com_tencent_mm_protocal_c_asx.mRr = linkedList;
        v.d("MicroMsg.NetSceneSendQRCodeByEmail", "grant to userName :" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSendQRCodeByEmail", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }
}
