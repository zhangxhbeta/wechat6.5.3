package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.adg;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.v.k implements j {
    public at bmk;
    private final b cif;
    private e cii;
    public int eOX;

    public k(String str, List<String> list) {
        a aVar = new a();
        aVar.czn = new adf();
        aVar.czo = new adg();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.cif = aVar.Bv();
        adf com_tencent_mm_protocal_c_adf = (adf) this.cif.czk.czs;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            aif com_tencent_mm_protocal_c_aif = new aif();
            com_tencent_mm_protocal_c_aif.moS = m.lY(str2);
            linkedList.add(com_tencent_mm_protocal_c_aif);
        }
        com_tencent_mm_protocal_c_adf.mbB = linkedList;
        com_tencent_mm_protocal_c_adf.eOX = linkedList.size();
        com_tencent_mm_protocal_c_adf.mbC = m.lY(str);
        com_tencent_mm_protocal_c_adf.mEh = 0;
    }

    public k(String str, List<String> list, String str2, at atVar) {
        this.bmk = atVar;
        a aVar = new a();
        aVar.czn = new adf();
        aVar.czo = new adg();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.cif = aVar.Bv();
        adf com_tencent_mm_protocal_c_adf = (adf) this.cif.czk.czs;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            aif com_tencent_mm_protocal_c_aif = new aif();
            com_tencent_mm_protocal_c_aif.moS = m.lY(str3);
            linkedList.add(com_tencent_mm_protocal_c_aif);
        }
        this.eOX = linkedList.size();
        com_tencent_mm_protocal_c_adf.mbB = linkedList;
        com_tencent_mm_protocal_c_adf.eOX = linkedList.size();
        com_tencent_mm_protocal_c_adf.mbC = m.lY(str);
        com_tencent_mm_protocal_c_adf.mEh = 2;
        com_tencent_mm_protocal_c_adf.mEi = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 610;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.cii.a(i2, i3, str, this);
    }
}
