package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.protocal.c.lq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends k implements j {
    b cif;
    private e cii;
    private ArrayList<Long> ibf;

    public l(ArrayList<Long> arrayList) {
        this.ibf = arrayList;
        a aVar = new a();
        aVar.czn = new jz();
        aVar.czo = new ka();
        aVar.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        aVar.czm = 483;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if ((i2 != 0 || i3 != 0) && this.cii != null) {
            this.cii.a(i2, i3, str, this);
        } else if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 483;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        jz jzVar = (jz) this.cif.czk.czs;
        jzVar.eet = this.ibf.size();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.ibf.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            lq lqVar = new lq();
            lqVar.mcb = longValue;
            linkedList.add(lqVar);
            v.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[]{Long.valueOf(longValue)});
        }
        jzVar.mmw = linkedList;
        v.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[]{Integer.valueOf(jzVar.eet), Integer.valueOf(jzVar.mmw.size())});
        return a(eVar, this.cif, this);
    }
}
