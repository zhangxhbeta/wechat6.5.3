package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.td;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p extends k implements j {
    Map<String, String> cEl = new HashMap();
    public b cif;
    private e cii;

    public p(LinkedList<gv> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            gv gvVar = (gv) it.next();
            String str = gvVar.mhD;
            String str2 = gvVar.mhJ;
            if (!(str2 == null || str == null)) {
                this.cEl.put(str, str2);
            }
        }
        a aVar = new a();
        aVar.czn = new td();
        aVar.czo = new te();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        aVar.czm = 1365;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((td) this.cif.czk.czs).mwD = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1365;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        return a(eVar, this.cif, this);
    }
}
