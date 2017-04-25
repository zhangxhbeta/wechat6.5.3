package com.tencent.mm.modelfriend;

import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.protocal.c.bce;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ac extends k implements j {
    private int bdn;
    public final List<String> cIn;
    public final List<String> cIo;
    private final String cIp = ((String) c.vf().get(6, null));
    private int cIq = 0;
    private int cIr = 0;
    private e cii;

    public ac(List<String> list, List<String> list2) {
        ak.yW();
        this.cIn = list;
        this.cIo = list2;
        this.bdn = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 0;
        this.cii = eVar2;
        if ((this.cIn == null || this.cIn.size() == 0) && (this.cIo == null || this.cIo.size() == 0)) {
            v.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
            return -1;
        }
        a aVar = new a();
        aVar.czn = new bce();
        aVar.czo = new bcf();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
        aVar.czm = 133;
        aVar.czp = 0;
        aVar.czq = 0;
        p Bv = aVar.Bv();
        bce com_tencent_mm_protocal_c_bce = (bce) Bv.czk.czs;
        com_tencent_mm_protocal_c_bce.mgw = this.cIp;
        com_tencent_mm_protocal_c_bce.gln = com.tencent.mm.model.k.xF();
        com_tencent_mm_protocal_c_bce.meB = this.bdn;
        int i2 = 200;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        while (i2 > 0) {
            if (this.cIn != null && this.cIq < this.cIn.size()) {
                if (this.cIn.get(this.cIq) != null) {
                    aij com_tencent_mm_protocal_c_aij = new aij();
                    com_tencent_mm_protocal_c_aij.v = (String) this.cIn.get(this.cIq);
                    linkedList.add(com_tencent_mm_protocal_c_aij);
                }
                this.cIq++;
                i2--;
            }
            if (this.cIo != null && this.cIr < this.cIo.size()) {
                if (this.cIo.get(this.cIr) != null) {
                    agt com_tencent_mm_protocal_c_agt = new agt();
                    com_tencent_mm_protocal_c_agt.v = (String) this.cIo.get(this.cIr);
                    linkedList2.add(com_tencent_mm_protocal_c_agt);
                }
                this.cIr++;
                i2--;
            }
            if ((this.cIo == null || this.cIr >= this.cIo.size()) && (this.cIn == null || this.cIq >= this.cIn.size())) {
                break;
            }
        }
        com_tencent_mm_protocal_c_bce.mGc = linkedList;
        com_tencent_mm_protocal_c_bce.mXN = linkedList.size();
        com_tencent_mm_protocal_c_bce.mXP = linkedList2;
        com_tencent_mm_protocal_c_bce.mXO = linkedList2.size();
        String str = "MicroMsg.NetSceneUploadMContact";
        StringBuilder append = new StringBuilder("doscene in:[").append(this.cIo == null ? 0 : this.cIo.size()).append(",");
        if (this.cIn != null) {
            i = this.cIn.size();
        }
        v.v(str, append.append(i).append("] index:[").append(this.cIr).append(",").append(this.cIq).append("] req:[").append(com_tencent_mm_protocal_c_bce.mXP.size()).append(",").append(com_tencent_mm_protocal_c_bce.mGc.size()).append("]").toString());
        return a(eVar, Bv, this);
    }

    public final boolean Bz() {
        return true;
    }

    protected final int a(p pVar) {
        bce com_tencent_mm_protocal_c_bce = (bce) ((b) pVar).czk.czs;
        int size = com_tencent_mm_protocal_c_bce.mXP.size() + com_tencent_mm_protocal_c_bce.mGc.size();
        if (size == 0 || size > 200) {
            v.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
            return b.czV;
        } else if (com_tencent_mm_protocal_c_bce.mgw == null || com_tencent_mm_protocal_c_bce.mgw.length() <= 0) {
            v.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
            return b.czV;
        } else if (com_tencent_mm_protocal_c_bce.gln != null && com_tencent_mm_protocal_c_bce.gln.length() > 0) {
            return b.czU;
        } else {
            v.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
            return b.czV;
        }
    }

    protected final int ul() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            bce com_tencent_mm_protocal_c_bce = (bce) ((b) pVar).czk.czs;
            m.E(H(com_tencent_mm_protocal_c_bce.mXP));
            m.E(I(com_tencent_mm_protocal_c_bce.mGc));
            if ((this.cIo == null || this.cIr >= this.cIo.size()) && (this.cIn == null || this.cIq >= this.cIn.size())) {
                this.cii.a(i2, i3, str, this);
                return;
            } else if (a(this.czE, this.cii) < 0) {
                this.cii.a(i2, i3, str, this);
                return;
            } else {
                return;
            }
        }
        v.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    private static List<String> H(List<agt> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            v.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
            return arrayList;
        }
        for (agt com_tencent_mm_protocal_c_agt : list) {
            arrayList.add(com_tencent_mm_protocal_c_agt.v);
        }
        return arrayList;
    }

    private static List<String> I(List<aij> list) {
        List<String> arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            v.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
            return arrayList;
        }
        for (aij com_tencent_mm_protocal_c_aij : list) {
            arrayList.add(g.m(com.tencent.mm.pluginsdk.a.yt(com_tencent_mm_protocal_c_aij.v).getBytes()));
        }
        return arrayList;
    }

    public final int getType() {
        return 133;
    }
}
