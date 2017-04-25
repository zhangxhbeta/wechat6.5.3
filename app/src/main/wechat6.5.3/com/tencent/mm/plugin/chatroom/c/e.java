package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends k implements j {
    private LinkedList<abq> bim;
    private final b cif;
    private com.tencent.mm.v.e cii;

    public e(LinkedList<abq> linkedList) {
        this.bim = linkedList;
        a aVar = new a();
        aVar.czn = new lb();
        aVar.czo = new lc();
        aVar.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        aVar.czm = 181;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        lb lbVar = (lb) this.cif.czk.czs;
        lbVar.mnD = linkedList;
        lbVar.mnC = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 181;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (pVar.ze().lWU != 0) {
            this.cii.a(i2, i3, str, this);
            return;
        }
        if (this.bim != null) {
            Iterator it = this.bim.iterator();
            while (it.hasNext()) {
                abq com_tencent_mm_protocal_c_abq = (abq) it.next();
                v.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + com_tencent_mm_protocal_c_abq.mCK);
                String str2 = com_tencent_mm_protocal_c_abq.mCK;
                if (str2.toLowerCase().endsWith("@groupcard")) {
                    ak.yW();
                    aa wH = c.wH();
                    if (wH.LZ(str2)) {
                        wH.Mc(str2);
                    } else {
                        v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + str2 + "]");
                    }
                    i.ei(str2);
                } else {
                    v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + str2 + "]");
                }
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
