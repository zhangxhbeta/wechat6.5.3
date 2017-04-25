package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends com.tencent.mm.v.k implements j {
    private e cxf = null;
    private b fut = null;
    private String[] fuu;

    public k(String[] strArr, String str) {
        this.fuu = strArr;
        v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[]{str, Integer.valueOf(1)});
        a aVar = new a();
        aVar.czn = new fn();
        aVar.czo = new fo();
        aVar.czm = 542;
        aVar.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        fn fnVar = (fn) this.fut.czk.czs;
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 0; i++) {
            String str2 = strArr[0];
            if (str2 != null) {
                fm fmVar = new fm();
                fmVar.mfU = str2;
                linkedList.add(fmVar);
                v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[]{str2});
            }
        }
        fnVar.mfV = linkedList;
        if (!be.kS(str)) {
            fl flVar = new fl();
            flVar.mfT = str;
            fnVar.mfW = flVar;
        }
        fnVar.mfX = 3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.fuu != null && this.fuu.length == 1) {
            v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[]{this.fuu[0]});
        }
        if (pVar == null) {
            v.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
        } else if (this.fut.czm != pVar.getType()) {
            v.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[]{Integer.valueOf(this.fut.czm), Integer.valueOf(pVar.getType())});
        } else {
            if (i2 == 0 && i3 == 0) {
                Iterator it = aji().mfY.iterator();
                while (it.hasNext()) {
                    fp fpVar = (fp) it.next();
                    v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[]{Integer.valueOf(fpVar.mcj), fpVar.mfZ, fpVar.mfU, fpVar.eeA});
                    if (fpVar.mga == null) {
                        v.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        ais com_tencent_mm_protocal_c_ais = fpVar.mga;
                        if (com_tencent_mm_protocal_c_ais == null) {
                            v.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a = m.a(com_tencent_mm_protocal_c_ais.moM);
                            String ma = be.ma(com_tencent_mm_protocal_c_ais.mJd);
                            if (be.kS(a) && be.kS(ma)) {
                                v.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[]{a, ma});
                            } else {
                                v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[]{a});
                                ak.yW();
                                u LX = c.wH().LX(a);
                                if (LX == null || !a.equals(LX.field_encryptUsername)) {
                                    u uVar = new u(a);
                                    uVar.bP(com_tencent_mm_protocal_c_ais.cHh);
                                    uVar.setType(com_tencent_mm_protocal_c_ais.mnV & com_tencent_mm_protocal_c_ais.mnW);
                                    if (!be.kS(ma)) {
                                        uVar.bY(ma);
                                    } else if (LX != null && ((int) LX.chr) > 0) {
                                        uVar.bY(LX.field_encryptUsername);
                                    }
                                    uVar.chr = LX == null ? 0 : (long) ((int) LX.chr);
                                    uVar.bS(m.a(com_tencent_mm_protocal_c_ais.mEj));
                                    uVar.bT(m.a(com_tencent_mm_protocal_c_ais.moC));
                                    uVar.bU(m.a(com_tencent_mm_protocal_c_ais.moD));
                                    uVar.cV(com_tencent_mm_protocal_c_ais.cHc);
                                    uVar.cY(com_tencent_mm_protocal_c_ais.mob);
                                    uVar.bR(m.a(com_tencent_mm_protocal_c_ais.mIX));
                                    uVar.cZ(com_tencent_mm_protocal_c_ais.mof);
                                    uVar.da(com_tencent_mm_protocal_c_ais.cHg);
                                    uVar.cl(RegionCodeDecoder.Y(com_tencent_mm_protocal_c_ais.cHl, com_tencent_mm_protocal_c_ais.cHd, com_tencent_mm_protocal_c_ais.cHe));
                                    uVar.cf(com_tencent_mm_protocal_c_ais.cHf);
                                    uVar.cR(com_tencent_mm_protocal_c_ais.mFu);
                                    uVar.ck(com_tencent_mm_protocal_c_ais.mFv);
                                    uVar.setSource(com_tencent_mm_protocal_c_ais.mcP);
                                    uVar.cQ(com_tencent_mm_protocal_c_ais.mFy);
                                    uVar.bV(com_tencent_mm_protocal_c_ais.mFx);
                                    if (com.tencent.mm.model.m.ft(com_tencent_mm_protocal_c_ais.mFw)) {
                                        uVar.cj(com_tencent_mm_protocal_c_ais.mFw);
                                    }
                                    uVar.dc((int) be.Nh());
                                    uVar.bQ(m.a(com_tencent_mm_protocal_c_ais.mIO));
                                    uVar.bW(m.a(com_tencent_mm_protocal_c_ais.mIQ));
                                    uVar.bX(m.a(com_tencent_mm_protocal_c_ais.mIP));
                                    uVar.cm(com_tencent_mm_protocal_c_ais.mdJ);
                                    uVar.cn(com_tencent_mm_protocal_c_ais.mJn);
                                    if (!(LX == null || be.ma(LX.bCu).equals(be.ma(com_tencent_mm_protocal_c_ais.mJn)))) {
                                        com.tencent.mm.an.c.HV();
                                        com.tencent.mm.an.c.jy(a);
                                    }
                                    ak.yW();
                                    c.wH().Mb(a);
                                    if (be.kS(uVar.field_username)) {
                                        v.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = uVar.field_username;
                                        n.Bo().a(com.tencent.mm.u.b.a(str2, com_tencent_mm_protocal_c_ais));
                                        axg com_tencent_mm_protocal_c_axg = com_tencent_mm_protocal_c_ais.mFA;
                                        if (!(uVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_axg == null)) {
                                            v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + com_tencent_mm_protocal_c_axg.cHn + " " + com_tencent_mm_protocal_c_ais.moM);
                                            v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + com_tencent_mm_protocal_c_axg.cHo);
                                            v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.cHp);
                                            v.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.mUx);
                                            if (com.tencent.mm.pluginsdk.j.ak.lyf != null) {
                                                com.tencent.mm.pluginsdk.j.ak.lyf.a(uVar.field_username, com_tencent_mm_protocal_c_axg);
                                            }
                                        }
                                        String xF = com.tencent.mm.model.k.xF();
                                        if (!(xF == null || xF.equals(str2))) {
                                            BizInfo ho = com.tencent.mm.modelbiz.u.Dy().ho(str2);
                                            ho.field_username = str2;
                                            ho.field_brandList = com_tencent_mm_protocal_c_ais.cHm;
                                            mc mcVar = com_tencent_mm_protocal_c_ais.mFB;
                                            if (mcVar != null) {
                                                ho.field_brandFlag = mcVar.cHq;
                                                ho.field_brandInfo = mcVar.cHs;
                                                ho.field_brandIconURL = mcVar.cHt;
                                                ho.field_extInfo = mcVar.cHr;
                                                ho.field_attrSyncVersion = null;
                                                ho.field_incrementUpdateTime = 0;
                                            }
                                            if (!com.tencent.mm.modelbiz.u.Dy().e(ho)) {
                                                com.tencent.mm.modelbiz.u.Dy().d(ho);
                                            }
                                            uVar.dd(ho.field_type);
                                        }
                                    }
                                    uVar.cT(com_tencent_mm_protocal_c_ais.mJm);
                                    if (!(com_tencent_mm_protocal_c_ais.mJi == null || com_tencent_mm_protocal_c_ais.mJi.mck == null)) {
                                        uVar.co(com_tencent_mm_protocal_c_ais.mJi.mck.mgp);
                                        uVar.cp(com_tencent_mm_protocal_c_ais.mJi.mck.mgq);
                                        uVar.cq(com_tencent_mm_protocal_c_ais.mJi.mck.mgr);
                                    }
                                    if (com.tencent.mm.model.m.fn(a)) {
                                        uVar.tw();
                                    }
                                    if (uVar.bvm()) {
                                        uVar.tz();
                                    }
                                    if (be.kS(ma)) {
                                        ak.yW();
                                        c.wH().M(uVar);
                                    } else {
                                        ak.yW();
                                        c.wH().b(ma, uVar);
                                    }
                                    if (!(LX == null || (LX.field_type & 2048) == (uVar.field_type & 2048))) {
                                        if ((uVar.field_type & 2048) != 0) {
                                            ak.yW();
                                            c.wK().Ml(uVar.field_username);
                                        } else {
                                            ak.yW();
                                            c.wK().Mm(uVar.field_username);
                                        }
                                    }
                                } else {
                                    v.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            }
                        }
                    }
                }
            }
            this.cxf.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.fut, this);
    }

    public final fo aji() {
        if (this.fut == null || this.fut.czl.czs == null) {
            return null;
        }
        return (fo) this.fut.czl.czs;
    }
}
