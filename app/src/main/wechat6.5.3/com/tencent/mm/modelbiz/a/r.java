package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r extends k implements j {
    Map<String, String> cEm = new HashMap();
    public b cif;
    private e cii;
    Object data;

    public r(LinkedList<hs> linkedList, Object obj) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hs hsVar = (hs) it.next();
            LinkedList linkedList2 = hsVar.miD;
            String str = hsVar.mhJ;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.cEm.put((String) it2.next(), str);
                }
            }
        }
        a aVar = new a();
        aVar.czn = new tj();
        aVar.czo = new tk();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        aVar.czm = 1353;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((tj) this.cif.czk.czs).mwF = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1353;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        return a(eVar, this.cif, this);
    }
}
