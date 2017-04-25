package com.tencent.mm.modelfriend;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.protocal.c.xf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class x extends k implements j {
    private List<String> cHz;
    private List<String> cIg;
    b cif;
    private e cii = null;

    public x() {
        Ft();
        xe xeVar = (xe) this.cif.czk.czs;
        xeVar.mpI = SQLiteDatabase.KeyEmpty;
        xeVar.mzA = null;
        xeVar.mzz = 0;
        xeVar.mzy = null;
        xeVar.mzx = 0;
        xeVar.gly = 0;
        xeVar.maG = 1;
    }

    public x(List<String> list, List<String> list2) {
        Ft();
        if ((list != null && list.size() != 0) || (list2 != null && list2.size() != 0)) {
            this.cHz = list;
            this.cIg = list2;
            xe xeVar = (xe) this.cif.czk.czs;
            xeVar.mpI = SQLiteDatabase.KeyEmpty;
            xeVar.gly = 2;
            xeVar.maG = 1;
        }
    }

    private void Ft() {
        a aVar = new a();
        aVar.czn = new xe();
        aVar.czo = new xf();
        aVar.uri = "/cgi-bin/micromsg-bin/getmfriend";
        aVar.czm = 142;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final void Fu() {
        xe xeVar = (xe) this.cif.czk.czs;
        ak.yW();
        xeVar.mpI = (String) c.vf().get(65828, null);
        xeVar.gly = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        xe xeVar = (xe) this.cif.czk.czs;
        if (xeVar.gly == 2) {
            if ((this.cHz == null || this.cHz.size() == 0) && (this.cIg == null || this.cIg.size() == 0)) {
                v.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                return -1;
            }
            LinkedList linkedList;
            if (this.cHz != null && this.cHz.size() > 0) {
                v.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", Integer.valueOf(this.cHz.size()));
                linkedList = new LinkedList();
                for (String str : this.cHz) {
                    aij com_tencent_mm_protocal_c_aij = new aij();
                    com_tencent_mm_protocal_c_aij.v = str;
                    linkedList.add(com_tencent_mm_protocal_c_aij);
                }
                xeVar.mzy = linkedList;
                xeVar.mzx = linkedList.size();
            }
            if (this.cIg != null && this.cIg.size() > 0) {
                v.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", Integer.valueOf(this.cIg.size()));
                linkedList = new LinkedList();
                for (String str2 : this.cIg) {
                    agt com_tencent_mm_protocal_c_agt = new agt();
                    com_tencent_mm_protocal_c_agt.v = str2;
                    linkedList.add(com_tencent_mm_protocal_c_agt);
                }
                xeVar.mzA = linkedList;
                xeVar.mzz = linkedList.size();
            }
        }
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 32;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        xf xfVar = (xf) this.cif.czl.czs;
        xe xeVar = (xe) this.cif.czk.czs;
        if (i2 == 4 && i3 == -68) {
            this.cii.a(i2, i3, xfVar.mQl.mfD.mQy, this);
        } else if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            ak.yW();
            String ma = be.ma((String) c.vf().get(65828, null));
            if (!(xeVar.gly != 1 || be.kS(xfVar.mpI) || xfVar.mpI.equals(ma))) {
                ak.yW();
                c.vf().set(65828, xfVar.mpI);
                ah.FM().ER();
            }
            if (xfVar.mzB == null) {
                v.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                return;
            }
            v.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", Integer.valueOf(xfVar.mzB.size()));
            ak.yW();
            long er = c.wE().er(Thread.currentThread().getId());
            for (int i4 = 0; i4 < xfVar.mzB.size(); i4++) {
                agu com_tencent_mm_protocal_c_agu = (agu) xfVar.mzB.get(i4);
                if (com_tencent_mm_protocal_c_agu == null) {
                    v.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                } else {
                    b iB = ah.FL().iB(com_tencent_mm_protocal_c_agu.cHb);
                    if (iB != null || xeVar.gly == 1) {
                        ak.yW().xv().dJ(com_tencent_mm_protocal_c_agu.mdw, com_tencent_mm_protocal_c_agu.mvR);
                        h hVar = new h();
                        if (xeVar.gly == 1) {
                            if (com_tencent_mm_protocal_c_agu.mGr == null) {
                                v.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                            } else {
                                hVar.bCb = com_tencent_mm_protocal_c_agu.mGr.iuq;
                                hVar.cHw = com_tencent_mm_protocal_c_agu.mGr.mru;
                                com.tencent.mm.u.b.gx(com_tencent_mm_protocal_c_agu.mGr.iuq);
                                hVar.cHv = com_tencent_mm_protocal_c_agu.mGr.gkB;
                                hVar.bLc = com_tencent_mm_protocal_c_agu.cHh;
                                hVar.bCl = com_tencent_mm_protocal_c_agu.cHe;
                                hVar.bCk = com_tencent_mm_protocal_c_agu.cHd;
                                hVar.bCj = com_tencent_mm_protocal_c_agu.cHf;
                                hVar.bCi = com_tencent_mm_protocal_c_agu.cHg;
                                hVar.bBZ = com_tencent_mm_protocal_c_agu.cHc;
                                hVar.aGX = com_tencent_mm_protocal_c_agu.mGq;
                                hVar.cGV = com.tencent.mm.platformtools.c.lU(com_tencent_mm_protocal_c_agu.mGr.gkB);
                                hVar.cGW = com.tencent.mm.platformtools.c.lT(com_tencent_mm_protocal_c_agu.mGr.gkB);
                                hVar.username = com_tencent_mm_protocal_c_agu.mdw;
                            }
                        } else if (be.kS(com_tencent_mm_protocal_c_agu.mdw)) {
                            v.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                        }
                        k kVar = new k();
                        kVar.username = com_tencent_mm_protocal_c_agu.mdw;
                        kVar.bCk = com_tencent_mm_protocal_c_agu.cHd;
                        kVar.bCl = com_tencent_mm_protocal_c_agu.cHe;
                        kVar.bCj = com_tencent_mm_protocal_c_agu.cHf;
                        kVar.bBZ = com_tencent_mm_protocal_c_agu.cHc;
                        kVar.bCi = com_tencent_mm_protocal_c_agu.cHg;
                        ab abVar = null;
                        if (!be.kS(com_tencent_mm_protocal_c_agu.mdw)) {
                            ak.yW();
                            abVar = c.wH().LX(com_tencent_mm_protocal_c_agu.mdw);
                            if (abVar == null || !com_tencent_mm_protocal_c_agu.mdw.equals(abVar.field_username)) {
                                abVar = null;
                            } else if (!(be.kS(com_tencent_mm_protocal_c_agu.cHh) || com_tencent_mm_protocal_c_agu.cHh.equals(abVar.pD()))) {
                                abVar.bP(com_tencent_mm_protocal_c_agu.cHh);
                                ak.yW();
                                c.wH().a(abVar.field_username, abVar);
                            }
                        }
                        if (be.kS(com_tencent_mm_protocal_c_agu.mdw)) {
                            Assert.assertTrue("mobile friend never go here", xeVar.gly == 1);
                            hVar.status = MMGIFException.D_GIF_ERR_READ_FAILED;
                        } else if (abVar == null || !com.tencent.mm.i.a.ei(abVar.field_type)) {
                            hVar.status = 100;
                            if (iB != null) {
                                v.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status on, nick:" + com_tencent_mm_protocal_c_agu.mGq + " realName:" + iB.ED() + "  MFriend:" + com_tencent_mm_protocal_c_agu.toString());
                                iB.status = 1;
                                iB.username = com_tencent_mm_protocal_c_agu.mdw;
                                iB.aGX = com_tencent_mm_protocal_c_agu.mGq;
                                iB.cGV = com.tencent.mm.platformtools.c.lU(com_tencent_mm_protocal_c_agu.mGr.gkB);
                                iB.cGW = com.tencent.mm.platformtools.c.lT(com_tencent_mm_protocal_c_agu.mGr.gkB);
                                iB.cHa = iB.tm();
                                a(iB, com_tencent_mm_protocal_c_agu);
                                iB.bkU = -1;
                                ah.FL().a(iB.EB(), iB);
                                h hVar2 = new h();
                                hVar2.username = com_tencent_mm_protocal_c_agu.mdw;
                                hVar2.cyD = com_tencent_mm_protocal_c_agu.mlY;
                                hVar2.cyC = com_tencent_mm_protocal_c_agu.mlZ;
                                hVar2.aP(true);
                                hVar2.bBY = 3;
                                n.Bo().a(hVar2);
                            }
                        } else {
                            hVar.status = MMGIFException.D_GIF_ERR_OPEN_FAILED;
                            if (iB != null) {
                                v.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status friend, nick:" + com_tencent_mm_protocal_c_agu.mGq + "  md5:" + com_tencent_mm_protocal_c_agu.cHb);
                                iB.status = 2;
                                iB.username = com_tencent_mm_protocal_c_agu.mdw;
                                iB.aGX = com_tencent_mm_protocal_c_agu.mGq;
                                iB.cHa = iB.tm();
                                a(iB, com_tencent_mm_protocal_c_agu);
                                iB.bkU = -1;
                                ah.FL().a(iB.EB(), iB);
                                com.tencent.mm.u.b.r(com_tencent_mm_protocal_c_agu.mdw, 3);
                            }
                        }
                        if (xeVar.gly == 1) {
                            ah.FM().a(hVar);
                        }
                        ah.FN().a(kVar);
                    } else {
                        v.e("MicroMsg.NetSceneGetMFriend", "Err MD5 not found is AddrUploadStg, nickName: " + com_tencent_mm_protocal_c_agu.mGq + " md5: " + com_tencent_mm_protocal_c_agu.cHb);
                    }
                }
            }
            ak.yW();
            c.wE().es(er);
            this.cii.a(i2, i3, str, this);
        } else {
            v.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
        }
    }

    private static void a(b bVar, agu com_tencent_mm_protocal_c_agu) {
        bVar.cHb = com_tencent_mm_protocal_c_agu.cHb;
        bVar.cHc = com_tencent_mm_protocal_c_agu.cHc;
        bVar.cHd = com_tencent_mm_protocal_c_agu.cHd;
        bVar.cHe = com_tencent_mm_protocal_c_agu.cHe;
        bVar.cHf = com_tencent_mm_protocal_c_agu.cHf;
        bVar.cHg = com_tencent_mm_protocal_c_agu.cHg;
        bVar.cHh = com_tencent_mm_protocal_c_agu.cHh;
        bVar.cHi = com_tencent_mm_protocal_c_agu.cHi;
        bVar.cHk = com_tencent_mm_protocal_c_agu.cHk;
        bVar.cHj = com_tencent_mm_protocal_c_agu.cHj;
        bVar.cHl = com_tencent_mm_protocal_c_agu.cHl;
        bVar.cHm = com_tencent_mm_protocal_c_agu.cHm;
        axg com_tencent_mm_protocal_c_axg = com_tencent_mm_protocal_c_agu.mFA;
        if (com_tencent_mm_protocal_c_axg != null) {
            bVar.cHn = com_tencent_mm_protocal_c_axg.cHn;
            bVar.cHo = com_tencent_mm_protocal_c_axg.cHo;
            bVar.cHp = com_tencent_mm_protocal_c_axg.cHp;
        }
        mc mcVar = com_tencent_mm_protocal_c_agu.mFB;
        if (mcVar != null) {
            bVar.cHq = mcVar.cHq;
            bVar.cHr = mcVar.cHr;
            bVar.cHs = mcVar.cHs;
            bVar.cHt = mcVar.cHt;
        }
    }
}
