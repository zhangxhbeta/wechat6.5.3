package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.g;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements j {
    private b cif;
    private e cii;
    private String eEL;
    List<d> iNX;
    private int iNY;
    int ret;

    public a(byte[] bArr) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aue();
        aVar.czo = new auf();
        aVar.uri = "/cgi-bin/micromsg-bin/shakeget";
        aVar.czm = 162;
        aVar.czp = 57;
        aVar.czq = 1000000057;
        this.cif = aVar.Bv();
        aue com_tencent_mm_protocal_c_aue = (aue) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aue.meT = new are().ba(bArr);
        com_tencent_mm_protocal_c_aue.mRL = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneShakeGet", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 162;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        auf com_tencent_mm_protocal_c_auf = (auf) this.cif.czl.czs;
        this.iNX = new LinkedList();
        this.iNY = com_tencent_mm_protocal_c_auf.mRN;
        this.ret = com_tencent_mm_protocal_c_auf.mcj;
        this.eEL = com_tencent_mm_protocal_c_auf.hQO;
        int i4 = com_tencent_mm_protocal_c_auf.eet;
        v.d("MicroMsg.NetSceneShakeGet", "size:" + i4);
        ak.yW();
        aa wH = c.wH();
        if (i4 > 0) {
            e aNO = k.aNO();
            aNO.aNG();
            v.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:" + i4);
            if (aNO.cie.dF("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i4 ? 100 - i4 : 0) + " )")) {
                v.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:" + i4);
                aNO.Ls();
            }
            for (i4--; i4 >= 0; i4--) {
                if (!com.tencent.mm.model.k.xF().equals(((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).gln)) {
                    BizInfo ho = u.Dy().ho(((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).gln);
                    ho.field_username = ((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).gln;
                    ho.field_brandList = ((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).cHm;
                    mc mcVar = ((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).mFB;
                    if (mcVar != null) {
                        ho.field_brandFlag = mcVar.cHq;
                        ho.field_brandInfo = mcVar.cHs;
                        ho.field_brandIconURL = mcVar.cHt;
                        ho.field_extInfo = mcVar.cHr;
                    }
                    if (!u.Dy().e(ho)) {
                        u.Dy().d(ho);
                    }
                }
                d dVar = new d((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4));
                h hVar = new h();
                hVar.username = dVar.field_username;
                hVar.aP(dVar.field_hasHDImg > 0);
                hVar.bBY = dVar.field_imgstatus;
                hVar.cyD = ((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).mlY;
                hVar.cyC = ((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).mlZ;
                n.Bo().a(hVar);
                hVar.bkU = -1;
                v.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", new Object[]{hVar.getUsername(), hVar.Be(), hVar.Bf()});
                dVar.field_reserved2 = wH.LT(dVar.field_username) ? 1 : 0;
                com.tencent.mm.storage.u LX = wH.LX(dVar.field_username);
                if (LX != null && ((int) LX.chr) > 0) {
                    aNO.zp(LX.field_username);
                    aNO.zp(LX.field_encryptUsername);
                }
                aNO.a(dVar, false);
                g xv = ak.yW().xv();
                String str2 = dVar.field_username;
                int i5 = this.iNY;
                String str3 = ((aud) com_tencent_mm_protocal_c_auf.mRM.get(i4)).mvR;
                if (!be.kS(str2)) {
                    com.tencent.mm.storage.g.a aVar = new com.tencent.mm.storage.g.a();
                    aVar.field_userName = str2;
                    aVar.field_scene = i5;
                    aVar.field_ticket = str3;
                    xv.a(aVar);
                    xv.dJ(str2, str3);
                }
                dVar.scene = this.iNY;
                this.iNX.add(dVar);
                v.v("MicroMsg.NetSceneShakeGet", "item info: " + dVar.field_username + " " + dVar.field_nickname);
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
