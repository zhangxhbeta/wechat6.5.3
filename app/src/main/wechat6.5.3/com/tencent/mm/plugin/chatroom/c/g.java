package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.model.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.protocal.c.mp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class g extends k implements j {
    public List<String> bir;
    private b cif;
    private e cii;

    public g(String str, List<String> list) {
        this(str, list, 0);
    }

    public g(String str, List<String> list, int i) {
        a aVar = new a();
        aVar.czn = new mg();
        aVar.czo = new mh();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        aVar.czm = 179;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        mg mgVar = (mg) this.cif.czk.czs;
        mgVar.moN = str;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            mp mpVar = new mp();
            mpVar.moS = m.lY(str2);
            linkedList.add(mpVar);
        }
        mgVar.mbB = linkedList;
        mgVar.eOX = linkedList.size();
        mgVar.maG = i;
        this.bir = list;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 179;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        mg mgVar = (mg) this.cif.czk.czs;
        mh mhVar = (mh) this.cif.czl.czs;
        if (this.cif.czl.lWU != 0) {
            this.cii.a(i2, i3, str, this);
            return;
        }
        i.a(mgVar.moN, mhVar);
        this.cii.a(i2, i3, str, this);
    }
}
