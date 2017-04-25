package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.model.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements j {
    public int bhN = 0;
    public String biB = null;
    public final List<String> bir;
    public final List<String> biu;
    public final List<String> biw;
    public final List<String> bix;
    private final b cif;
    private e cii = null;
    public final List<String> eOM;
    public final List<String> eON;
    public final List<String> eOO;

    public d(String str, List<String> list, String str2) {
        a aVar = new a();
        aVar.czn = new bb();
        aVar.czo = new bc();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroommember";
        aVar.czm = 120;
        aVar.czp = 36;
        aVar.czq = 1000000036;
        this.cif = aVar.Bv();
        bb bbVar = (bb) this.cif.czk.czs;
        bbVar.mbC = m.lY(str);
        this.biB = str;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            aif com_tencent_mm_protocal_c_aif = new aif();
            com_tencent_mm_protocal_c_aif.moS = m.lY(str3);
            linkedList.add(com_tencent_mm_protocal_c_aif);
        }
        bbVar.mbB = linkedList;
        bbVar.eOX = linkedList.size();
        this.eOM = new ArrayList();
        this.biu = new LinkedList();
        this.eON = new LinkedList();
        this.biw = new LinkedList();
        this.bix = new LinkedList();
        this.eOO = new ArrayList();
        this.bir = list;
        bbVar.mbE = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 120;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bb bbVar = (bb) this.cif.czk.czs;
        bc bcVar = (bc) this.cif.czl.czs;
        this.bhN = bcVar.eOX;
        List list = bcVar.mbB;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int i5 = ((aig) list.get(i4)).mIN;
            if (i5 == 0) {
                this.eOM.add(m.a(((aig) list.get(i4)).moS));
            } else if (i5 == 3) {
                v.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((aig) list.get(i4)).moS);
                this.eON.add(m.a(((aig) list.get(i4)).moS));
            } else if (i5 == 1) {
                v.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((aig) list.get(i4)).moS);
                this.biw.add(m.a(((aig) list.get(i4)).moS));
            } else if (i5 == 2) {
                v.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((aig) list.get(i4)).moS);
                this.biu.add(m.a(((aig) list.get(i4)).moS));
            } else if (i5 == 4) {
                v.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((aig) list.get(i4)).moS);
                this.bix.add(m.a(((aig) list.get(i4)).moS));
            } else if (i5 != 5) {
                if (i5 == 6) {
                    this.eOO.add(m.a(((aig) list.get(i4)).moS));
                } else {
                    v.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = " + i5);
                }
            }
        }
        this.cii.a(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            i.a(m.a(bbVar.mbC), bcVar);
        }
    }
}
