package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements j {
    public int bis = 0;
    public String bit;
    public final List<String> biu;
    public final List<String> biw;
    public List<String> bix;
    public List<String> biy;
    private final b cif;
    private e cii;
    public final List<String> eON;

    public f(String str, List<String> list) {
        v.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + ((String) list.get(0)));
        a aVar = new a();
        aVar.czn = new ly();
        aVar.czo = new lz();
        aVar.uri = "/cgi-bin/micromsg-bin/createchatroom";
        aVar.czm = 119;
        aVar.czp = 37;
        aVar.czq = 1000000037;
        this.cif = aVar.Bv();
        ly lyVar = (ly) this.cif.czk.czs;
        lyVar.moA = m.lY(str);
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            aif com_tencent_mm_protocal_c_aif = new aif();
            com_tencent_mm_protocal_c_aif.moS = m.lY(str2);
            linkedList.add(com_tencent_mm_protocal_c_aif);
        }
        lyVar.mbB = linkedList;
        lyVar.eOX = linkedList.size();
        this.biu = new LinkedList();
        this.eON = new LinkedList();
        this.biw = new LinkedList();
        this.bix = new LinkedList();
        this.biy = new LinkedList();
        this.bit = "";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 119;
    }

    private static boolean a(lz lzVar) {
        if (!m.a(lzVar.mbC).toLowerCase().endsWith("@chatroom") || lzVar.eOX == 0) {
            v.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + lzVar.mbC + "] listCnt:" + lzVar.eOX);
            return false;
        }
        u uVar = new u();
        uVar.bS(m.a(lzVar.moA));
        uVar.bT(m.a(lzVar.moC));
        uVar.bU(m.a(lzVar.moD));
        uVar.setUsername(m.a(lzVar.mbC));
        ak.yW();
        aa wH = c.wH();
        if (!wH.LZ(uVar.field_username)) {
            wH.N(uVar);
        }
        h hVar = new h();
        hVar.username = uVar.field_username;
        hVar.cyD = lzVar.mlY;
        hVar.cyC = lzVar.mlZ;
        hVar.bBY = 3;
        hVar.aP(false);
        hVar.bkU = -1;
        n.Bo().a(hVar);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < lzVar.mbB.size(); i++) {
            if (((aig) lzVar.mbB.get(i)).mIN == 0) {
                ab abVar;
                u LX = wH.LX(m.a(((aig) lzVar.mbB.get(i)).moS));
                if (((int) LX.chr) != 0) {
                    LX.to();
                    wH.a(LX.field_username, LX);
                    abVar = LX;
                } else {
                    abVar = i.a(LX, (aig) lzVar.mbB.get(i));
                    wH.N(abVar);
                }
                arrayList.add(abVar.field_username);
            }
        }
        if (!arrayList.contains(com.tencent.mm.model.k.xF())) {
            arrayList.add(com.tencent.mm.model.k.xF());
            v.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(com.tencent.mm.model.k.xF()));
        }
        return i.a(uVar.field_username, arrayList, com.tencent.mm.model.k.xF());
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        lz lzVar = (lz) this.cif.czl.czs;
        this.bit = m.a(lzVar.mbC);
        int i4 = this.cif.czl.lWU;
        this.bis = lzVar.eOX;
        af(lzVar.mbB);
        if (!be.kS(this.bit) && i4 == 0) {
            a(lzVar);
        }
        this.cii.a(i2, i3, str, this);
    }

    private void af(List<aig> list) {
        for (int i = 0; i < list.size(); i++) {
            int i2 = ((aig) list.get(i)).mIN;
            if (i2 == 0) {
                this.biy.add(m.a(((aig) list.get(i)).moS));
            } else if (i2 == 3) {
                v.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((aig) list.get(i)).moS);
                this.eON.add(m.a(((aig) list.get(i)).moS));
            } else if (i2 == 1) {
                v.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((aig) list.get(i)).moS);
                this.biw.add(m.a(((aig) list.get(i)).moS));
            } else if (i2 == 2) {
                v.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((aig) list.get(i)).moS);
                this.biu.add(m.a(((aig) list.get(i)).moS));
            } else if (i2 == 4) {
                v.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((aig) list.get(i)).moS);
                this.bix.add(m.a(((aig) list.get(i)).moS));
            } else if (!(i2 == 5 || i2 == 6)) {
                v.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = " + i2);
            }
        }
    }
}
