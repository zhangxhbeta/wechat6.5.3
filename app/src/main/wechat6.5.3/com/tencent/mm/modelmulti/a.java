package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.e.a.mb;
import com.tencent.mm.e.a.pa;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.f.a.a.i;
import com.tencent.mm.plugin.f.a.a.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.adi;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.protocal.c.aza;
import com.tencent.mm.protocal.c.bcw;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.bn;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.o;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;
import junit.framework.Assert;

public final class a implements i {
    public final void a(kz kzVar, byte[] bArr, boolean z, j jVar) {
        String a;
        boolean z2;
        String a2;
        ab LX;
        b keVar;
        h hVar;
        String xF;
        int i;
        int i2;
        switch (kzVar.bkM) {
            case 13:
                ajc com_tencent_mm_protocal_c_ajc = (ajc) new ajc().az(bArr);
                if (1 == com_tencent_mm_protocal_c_ajc.mJA) {
                    ak.yW();
                    ay wN = c.wN();
                    a = m.a(com_tencent_mm_protocal_c_ajc.moM);
                    z2 = com_tencent_mm_protocal_c_ajc.mJm == 1;
                    Object obj = com_tencent_mm_protocal_c_ajc.mJB == 1 ? 1 : null;
                    if (be.kS(a)) {
                        v.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
                        return;
                    }
                    ax Ns = wN.Ns(a);
                    if (Ns == null) {
                        wN.a(new ax(a, z2, 2));
                        v.d("MicroMsg.RoleStorage", "insert new role, user=" + a);
                        return;
                    }
                    Ns.dN(z2);
                    if (obj != null) {
                        Ns.status |= 2;
                    } else {
                        Ns.status &= -3;
                    }
                    Ns.bkU = 4;
                    wN.b(Ns);
                    return;
                }
                v.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + com_tencent_mm_protocal_c_ajc.mJA);
                return;
            case 15:
                ain com_tencent_mm_protocal_c_ain = (ain) new ain().az(bArr);
                if (com_tencent_mm_protocal_c_ain != null) {
                    v.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + com_tencent_mm_protocal_c_ain.moM + " nickname:" + com_tencent_mm_protocal_c_ain.mEj);
                    a2 = m.a(com_tencent_mm_protocal_c_ain.moM);
                    ak.yW();
                    ab LX2 = c.wH().LX(a2);
                    LX2.setUsername(a2);
                    LX2.bS(m.a(com_tencent_mm_protocal_c_ain.mEj));
                    LX2.bT(m.a(com_tencent_mm_protocal_c_ain.moC));
                    LX2.bU(m.a(com_tencent_mm_protocal_c_ain.moD));
                    LX2.cV(com_tencent_mm_protocal_c_ain.cHc);
                    LX2.bQ(m.a(com_tencent_mm_protocal_c_ain.mIO));
                    LX2.bW(m.a(com_tencent_mm_protocal_c_ain.mIQ));
                    LX2.bX(m.a(com_tencent_mm_protocal_c_ain.mIP));
                    LX2.cY(com_tencent_mm_protocal_c_ain.mob);
                    h hVar2 = new h();
                    hVar2.bkU = -1;
                    hVar2.username = LX2.field_username;
                    hVar2.cyC = com_tencent_mm_protocal_c_ain.mlZ;
                    hVar2.cyD = com_tencent_mm_protocal_c_ain.mlY;
                    v.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", hVar2.getUsername(), hVar2.Be(), hVar2.Bf());
                    hVar2.aP(true);
                    if (com_tencent_mm_protocal_c_ain.mIT == 3 || com_tencent_mm_protocal_c_ain.mIT == 4) {
                        LX2.cU(com_tencent_mm_protocal_c_ain.mIT);
                        hVar2.bBY = com_tencent_mm_protocal_c_ain.mIT;
                    } else if (com_tencent_mm_protocal_c_ain.mIT == 2) {
                        LX2.cU(3);
                        hVar2.bBY = 3;
                        LX2.cU(3);
                        if (!k.xF().equals(LX2.field_username)) {
                            n.AX();
                            d.t(LX2.field_username, false);
                            n.AX();
                            d.t(LX2.field_username, true);
                            n.Bq().gD(LX2.field_username);
                        }
                    }
                    n.Bo().a(hVar2);
                    ak.yW();
                    c.wH().M(LX2);
                    BizInfo ho = u.Dy().ho(LX2.field_username);
                    ho.field_username = LX2.field_username;
                    ho.field_brandList = com_tencent_mm_protocal_c_ain.cHm;
                    mc mcVar = com_tencent_mm_protocal_c_ain.mFB;
                    if (mcVar != null) {
                        ho.field_brandFlag = mcVar.cHq;
                        ho.field_brandInfo = mcVar.cHs;
                        ho.field_brandIconURL = mcVar.cHt;
                        ho.field_extInfo = mcVar.cHr;
                    }
                    if (!u.Dy().e(ho)) {
                        u.Dy().d(ho);
                        return;
                    }
                    return;
                }
                return;
            case android.support.v7.a.a.k.MM /*22*/:
                adi com_tencent_mm_protocal_c_adi = (adi) new adi().az(bArr);
                q qVar = new q();
                qVar.username = com_tencent_mm_protocal_c_adi.gln;
                qVar.cHW = com_tencent_mm_protocal_c_adi.mEk;
                qVar.cCe = (int) be.Nh();
                ah.FP().a(qVar);
                return;
            case android.support.v7.a.a.k.Nb /*23*/:
                rc rcVar = (rc) new rc().az(bArr);
                switch (rcVar.muR) {
                    case 1:
                        ak.yW();
                        c.vf().set(17, Integer.valueOf(rcVar.muS));
                        return;
                    case 4:
                        return;
                    default:
                        v.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + rcVar.muR);
                        return;
                }
            case 24:
                aoe com_tencent_mm_protocal_c_aoe = (aoe) new aoe().az(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_aoe != null);
                Assert.assertTrue(be.ma(com_tencent_mm_protocal_c_aoe.gln).length() > 0);
                if (com.tencent.mm.storage.u.LJ(com_tencent_mm_protocal_c_aoe.gln)) {
                    ak.yW();
                    LX = c.wH().LX(com_tencent_mm_protocal_c_aoe.gln);
                    if (LX == null || ((int) LX.chr) == 0) {
                        LX = new com.tencent.mm.storage.u(com_tencent_mm_protocal_c_aoe.gln);
                        LX.tt();
                        LX.bS(com_tencent_mm_protocal_c_aoe.mlX);
                        LX.bQ(com_tencent_mm_protocal_c_aoe.mlX);
                        LX.cY(4);
                        ak.yW();
                        if (c.wH().O(LX) == -1) {
                            v.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                            return;
                        }
                        com.tencent.mm.u.b.gB(LX.field_username);
                    } else if (!be.ma(com_tencent_mm_protocal_c_aoe.mlX).equals(be.ma(LX.field_username))) {
                        LX.bS(com_tencent_mm_protocal_c_aoe.mlX);
                        LX.bQ(com_tencent_mm_protocal_c_aoe.mlX);
                        ak.yW();
                        if (c.wH().a(LX.field_username, LX) == -1) {
                            v.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                        }
                    }
                    keVar = new ke();
                    keVar.bla.opType = 1;
                    keVar.bla.ble = com_tencent_mm_protocal_c_aoe.gln;
                    keVar.bla.blf = com_tencent_mm_protocal_c_aoe.mOq;
                    keVar.bla.blg = com_tencent_mm_protocal_c_aoe.moi;
                    com.tencent.mm.sdk.c.a.nhr.z(keVar);
                    return;
                }
                v.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
                return;
            case 25:
                aza com_tencent_mm_protocal_c_aza = (aza) new aza().az(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_aza != null);
                Assert.assertTrue(be.ma(com_tencent_mm_protocal_c_aza.gln).length() > 0);
                if (com.tencent.mm.storage.u.LH(com_tencent_mm_protocal_c_aza.gln)) {
                    ak.yW();
                    LX = c.wH().LX(com_tencent_mm_protocal_c_aza.gln);
                    if (LX == null || ((int) LX.chr) == 0) {
                        LX = new com.tencent.mm.storage.u(com_tencent_mm_protocal_c_aza.gln);
                        LX.bQ(com_tencent_mm_protocal_c_aza.mlX);
                        LX.cY(1);
                        LX.tt();
                        ak.yW();
                        if (c.wH().O(LX) == -1) {
                            v.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                            return;
                        }
                        a2 = LX.field_username;
                        if (a2 == null) {
                            v.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        } else if (a2.endsWith("@t.qq.com")) {
                            hVar = new h();
                            hVar.username = a2;
                            hVar.bBY = 3;
                            hVar.bkU = 3;
                            n.Bo().a(hVar);
                        } else {
                            v.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
                        }
                    } else if (!be.ma(com_tencent_mm_protocal_c_aza.mlX).equals(be.ma(LX.field_username))) {
                        LX.bQ(com_tencent_mm_protocal_c_aza.mlX);
                        ak.yW();
                        if (c.wH().a(LX.field_username, LX) == -1) {
                            v.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                        }
                    }
                    keVar = new pa();
                    keVar.bqm.opType = 1;
                    keVar.bqm.ble = com_tencent_mm_protocal_c_aza.gln;
                    keVar.bqm.blf = com_tencent_mm_protocal_c_aza.mOq;
                    keVar.bqm.blg = com_tencent_mm_protocal_c_aza.moi;
                    com.tencent.mm.sdk.c.a.nhr.z(keVar);
                    return;
                }
                v.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
                return;
            case 33:
                aik com_tencent_mm_protocal_c_aik = (aik) new aik().az(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_aik != null);
                Assert.assertTrue(be.ma(com_tencent_mm_protocal_c_aik.gln).length() > 0);
                com.tencent.mm.storage.u uVar = new com.tencent.mm.storage.u();
                uVar.setUsername(com_tencent_mm_protocal_c_aik.gln);
                uVar.setType(com_tencent_mm_protocal_c_aik.efm);
                uVar.cV(com_tencent_mm_protocal_c_aik.cHc);
                uVar.cl(RegionCodeDecoder.Y(com_tencent_mm_protocal_c_aik.cHl, com_tencent_mm_protocal_c_aik.cHd, com_tencent_mm_protocal_c_aik.cHe));
                uVar.cf(com_tencent_mm_protocal_c_aik.cHf);
                h hVar3 = new h();
                hVar3.bkU = -1;
                hVar3.username = com_tencent_mm_protocal_c_aik.gln;
                hVar3.cyC = com_tencent_mm_protocal_c_aik.mlZ;
                hVar3.cyD = com_tencent_mm_protocal_c_aik.mlY;
                v.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", hVar3.getUsername(), hVar3.Be(), hVar3.Bf());
                v.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + com_tencent_mm_protocal_c_aik.mIT + " hd:" + com_tencent_mm_protocal_c_aik.mIU);
                hVar3.aP(com_tencent_mm_protocal_c_aik.mIU != 0);
                if (com_tencent_mm_protocal_c_aik.mIT == 3 || com_tencent_mm_protocal_c_aik.mIT == 4) {
                    uVar.cU(com_tencent_mm_protocal_c_aik.mIT);
                    hVar3.bBY = com_tencent_mm_protocal_c_aik.mIT;
                } else if (com_tencent_mm_protocal_c_aik.mIT == 2) {
                    uVar.cU(3);
                    hVar3.bBY = 3;
                    n.AX();
                    d.t(com_tencent_mm_protocal_c_aik.gln, false);
                    n.AX();
                    d.t(com_tencent_mm_protocal_c_aik.gln, true);
                    n.Bq().gD(com_tencent_mm_protocal_c_aik.gln);
                } else {
                    uVar.cU(3);
                    hVar3.bBY = 3;
                }
                n.Bo().a(hVar3);
                ak.yW();
                c.wH().L(uVar);
                return;
            case 35:
                aji com_tencent_mm_protocal_c_aji = (aji) new aji().az(bArr);
                Assert.assertTrue(com_tencent_mm_protocal_c_aji != null);
                xF = k.xF();
                i = com_tencent_mm_protocal_c_aji.mil;
                if (i == 2) {
                    xF = com.tencent.mm.storage.u.LM(xF);
                    ak.yW();
                    a = xF;
                    xF = (String) c.vf().get(12553, null);
                } else {
                    ak.yW();
                    a = xF;
                    xF = (String) c.vf().get(12297, null);
                }
                z2 = false;
                if (xF == null || !xF.equals(com_tencent_mm_protocal_c_aji.mJG)) {
                    n.AX();
                    d.t(a, true);
                    ak.yW();
                    c.vf().set(i == 2 ? 12553 : 12297, com_tencent_mm_protocal_c_aji.mJG);
                    z2 = true;
                }
                v.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", Boolean.valueOf(z2), Integer.valueOf(i), com_tencent_mm_protocal_c_aji.mJG, com_tencent_mm_protocal_c_aji.mlY, com_tencent_mm_protocal_c_aji.mlZ);
                hVar = new h();
                hVar.username = a;
                hVar.cyD = com_tencent_mm_protocal_c_aji.mlY;
                hVar.cyC = com_tencent_mm_protocal_c_aji.mlZ;
                if (!be.kS(hVar.Bf())) {
                    if (i == 1) {
                        ak.yW();
                        c.vf().set(59, Boolean.valueOf(true));
                    } else {
                        ak.yW();
                        c.vf().set(60, Boolean.valueOf(true));
                    }
                }
                hVar.aP(false);
                hVar.bkU = 56;
                if (!be.kS(com_tencent_mm_protocal_c_aji.mJG)) {
                    hVar.aP(true);
                }
                n.Bo().a(hVar);
                if (z2) {
                    new e().a(a, new e.b(this) {
                        final /* synthetic */ a cQD;

                        {
                            this.cQD = r1;
                        }

                        public final int aG(int i, int i2) {
                            return 0;
                        }
                    });
                    return;
                }
                return;
            case 44:
                bcw com_tencent_mm_protocal_c_bcw = (bcw) new bcw().az(bArr);
                v.d("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag " + com_tencent_mm_protocal_c_bcw.mFA.cHn);
                ak.yW();
                a2 = (String) c.vf().get(2, null);
                if (a2 != null && a2.length() > 0) {
                    if (com.tencent.mm.pluginsdk.j.ak.lyf != null) {
                        com.tencent.mm.pluginsdk.j.ak.lyf.a(a2, com_tencent_mm_protocal_c_bcw.mFA);
                    }
                    BizInfo hw = com.tencent.mm.modelbiz.e.hw(k.xF());
                    if (hw == null) {
                        hw = new BizInfo();
                    }
                    hw.field_username = a2;
                    hw.field_brandList = com_tencent_mm_protocal_c_bcw.cHm;
                    if (!(!hw.CA() || hw.aX(false) == null || hw.aX(false).CZ() == null || be.kS(hw.CF()))) {
                        hw.field_enterpriseFather = hw.CF();
                        v.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", a2, hw.field_enterpriseFather);
                    }
                    if (!u.Dy().e(hw)) {
                        u.Dy().d(hw);
                    }
                    int i3 = com_tencent_mm_protocal_c_bcw.mYI;
                    int i4 = com_tencent_mm_protocal_c_bcw.mYJ;
                    i = com_tencent_mm_protocal_c_bcw.mYK;
                    v.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i3 + " rommquota: " + i4 + " invite: " + i);
                    ak.yW();
                    c.vf().set(135175, Integer.valueOf(i3));
                    ak.yW();
                    c.vf().set(135176, Integer.valueOf(i4));
                    ak.yW();
                    c.vf().set(135177, Integer.valueOf(i));
                    ak.yW();
                    c.vf().set(144385, Integer.valueOf(com_tencent_mm_protocal_c_bcw.mYO));
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(com_tencent_mm_protocal_c_bcw.mYX));
                    ak.yW();
                    c.vf().set(339975, Integer.valueOf(com_tencent_mm_protocal_c_bcw.mYW));
                    v.d("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", Integer.valueOf(com_tencent_mm_protocal_c_bcw.mYW), Integer.valueOf(com_tencent_mm_protocal_c_bcw.mYX));
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.USERINFO_PROFILE_WEIDIANINFO_STRING, be.ah(com_tencent_mm_protocal_c_bcw.bCy, SQLiteDatabase.KeyEmpty));
                    v.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", com_tencent_mm_protocal_c_bcw.bCy);
                    ak.yW();
                    c.vf().set(147457, Long.valueOf(com_tencent_mm_protocal_c_bcw.mYY));
                    hVar = new h();
                    hVar.bkU = -1;
                    hVar.username = a2;
                    hVar.cyD = com_tencent_mm_protocal_c_bcw.mlY;
                    hVar.cyC = com_tencent_mm_protocal_c_bcw.mlZ;
                    hVar.aP(true);
                    hVar.bBY = 3;
                    v.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", hVar.getUsername(), hVar.Be(), hVar.Bf());
                    n.Bo().a(hVar);
                    a2 = com_tencent_mm_protocal_c_bcw.mJe;
                    xF = com_tencent_mm_protocal_c_bcw.mJf;
                    ak.yW();
                    c.vf().set(274433, xF);
                    ak.yW();
                    c.vf().set(274434, a2);
                    if (com_tencent_mm_protocal_c_bcw.mck != null) {
                        ak.yW();
                        c.vf().set(286721, com_tencent_mm_protocal_c_bcw.mck.mgp);
                        ak.yW();
                        c.vf().set(286722, com_tencent_mm_protocal_c_bcw.mck.mgq);
                        ak.yW();
                        c.vf().set(286723, com_tencent_mm_protocal_c_bcw.mck.mgr);
                    }
                    if (com_tencent_mm_protocal_c_bcw.mYU != null && com_tencent_mm_protocal_c_bcw.mYU.mMm != null && com_tencent_mm_protocal_c_bcw.mYU.mMm.mQu > 0) {
                        v.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", Integer.valueOf(com_tencent_mm_protocal_c_bcw.mYU.mMm.mQu));
                        keVar = new pr();
                        keVar.bqX.bqY = com_tencent_mm_protocal_c_bcw.mYU;
                        com.tencent.mm.sdk.c.a.nhr.z(keVar);
                        return;
                    }
                    return;
                }
                return;
            case 53:
                ajv com_tencent_mm_protocal_c_ajv = (ajv) new ajv().az(bArr);
                v.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", Integer.valueOf(com_tencent_mm_protocal_c_ajv.gll), Long.valueOf(com_tencent_mm_protocal_c_ajv.mcb));
                if (com.tencent.mm.model.m.eT(com_tencent_mm_protocal_c_ajv.gon)) {
                    keVar = new mb();
                    keVar.bnj.bao = com_tencent_mm_protocal_c_ajv.mcb;
                    com.tencent.mm.sdk.c.a.nhr.z(keVar);
                    return;
                }
                return;
            case 68:
            case 69:
                i2 = kzVar.bkM;
                keVar = new ka();
                keVar.bkL.bkM = i2;
                keVar.bkL.bkN = bArr;
                com.tencent.mm.sdk.c.a.nhr.z(keVar);
                return;
            case 204:
                a((bn) new bn().az(bArr), jVar);
                return;
            case 999999:
                try {
                    i2 = com.tencent.mm.a.n.c(bArr, 0);
                    v.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", Integer.valueOf(i2));
                    if (i2 > 0) {
                        Thread.sleep((long) i2);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    v.a("MicroMsg.BigBallOfMudSyncExtension", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return;
                }
            default:
                v.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + kzVar.bkM);
                return;
        }
    }

    public static boolean a(com.tencent.mm.storage.u uVar) {
        if (uVar == null || be.kS(uVar.field_username)) {
            String str;
            String str2 = "MicroMsg.BigBallOfMudSyncExtension";
            String str3 = "dealModContactExtInfo username:%s ";
            Object[] objArr = new Object[1];
            if (uVar == null) {
                str = "-1";
            } else {
                str = uVar.field_username;
            }
            objArr[0] = str;
            v.w(str2, str3, objArr);
            return false;
        }
        ak.yW();
        byte[] Ma = c.wH().Ma(uVar.field_username);
        if (be.bl(Ma)) {
            str2 = "MicroMsg.BigBallOfMudSyncExtension";
            str3 = "dealModContactExtInfo username:%s  buf:%d";
            objArr = new Object[2];
            objArr[0] = uVar.field_username;
            objArr[1] = Integer.valueOf(Ma == null ? -1 : Ma.length);
            v.w(str2, str3, objArr);
            return false;
        }
        ais com_tencent_mm_protocal_c_ais;
        try {
            com_tencent_mm_protocal_c_ais = (ais) new ais().az(Ma);
        } catch (Throwable e) {
            v.a("MicroMsg.BigBallOfMudSyncExtension", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            com_tencent_mm_protocal_c_ais = null;
        }
        ak.yW();
        c.wH().Mb(uVar.field_username);
        if (com_tencent_mm_protocal_c_ais != null) {
            return com.tencent.mm.plugin.bbom.c.a(uVar, com_tencent_mm_protocal_c_ais, false);
        }
        v.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        return false;
    }

    public final void a(bn bnVar, j jVar) {
        com.tencent.mm.storage.ab abVar;
        Object obj;
        long Ni;
        final String a = m.a(bnVar.mcd);
        long j = bnVar.mcb;
        int i = bnVar.hNS;
        int i2 = bnVar.mcg;
        int i3 = bnVar.mcc;
        int i4 = bnVar.gll;
        int i5 = bnVar.mce;
        String a2 = m.a(bnVar.mcf);
        v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], newMsgId[%d], createTime[%d], isActed[%d], msgseq[%d], msgType[%d], unDeliverCount[%d], content[%s]", a, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), be.KW(a2));
        if (be.kS(a)) {
            v.e("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId is null and ret");
        }
        if (i5 == 0) {
            com.tencent.mm.plugin.report.b.itm.a(403, 24, 1, false);
            if (be.ah(aw.fL(a2), SQLiteDatabase.KeyEmpty).equals(k.xF())) {
                ak.yW();
                at S = c.wJ().S(a, j);
                if (S.field_msgId > 0 && S.field_isSend == 1) {
                    v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList self send msg[%d] createtime[%d, %d] svrid[%d, %d] seq[%d, %d]", Long.valueOf(S.field_msgId), Long.valueOf(S.field_createTime), Integer.valueOf(i), Long.valueOf(S.field_msgSvrId), Long.valueOf(j), Long.valueOf(S.field_msgSeq), Integer.valueOf(i3));
                    if (S.field_msgSeq == 0) {
                        com.tencent.mm.plugin.report.b.itm.a(403, 25, 1, false);
                        S.B((long) i3);
                        ak.yW();
                        c.wJ().a(S.field_msgId, S);
                        return;
                    }
                    return;
                }
            }
        }
        ak.yW();
        af Mh = c.wK().Mh(a);
        af afVar;
        if (Mh == null) {
            com.tencent.mm.plugin.report.b.itm.a(403, 22, 1, false);
            af abVar2 = new com.tencent.mm.storage.ab(a);
            abVar2.s(((long) i) * 1000);
            abVar2.u((long) i3);
            abVar2.df(i5);
            abVar2.dn(i5);
            if (i5 < 2) {
                abVar2.v((long) i3);
                abVar = abVar2;
                obj = 1;
            } else {
                ak.yW();
                abVar2.v(c.xw().Mu(a));
                v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList new conv lastDeleteSeq(FirstUnDeliverSeq)[%d], msgSeq[%d]", Long.valueOf(r6), Integer.valueOf(i3));
                afVar = abVar2;
                int i6 = 1;
            }
        } else {
            int i7 = (int) Mh.field_lastSeq;
            com.tencent.mm.plugin.report.b.itm.a(403, 23, 1, false);
            if (i5 < Mh.field_UnDeliverCount) {
                com.tencent.mm.plugin.report.b.itm.a(403, 26, (long) Mh.field_UnDeliverCount, false);
            }
            if (i3 > i7) {
                Mh.u((long) i3);
                Mh.dn(i5);
                Mh.s(aw.h(a, (long) i));
                if (i5 > Mh.field_unReadCount) {
                    Mh.df(i5);
                }
                v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList  msgSeq[%d], firstSeq[%d], lastseq[%d]", Integer.valueOf(i3), Long.valueOf(Mh.field_firstUnDeliverSeq), Integer.valueOf(i7));
                if (Mh.field_firstUnDeliverSeq > 0) {
                    ak.yW();
                    if (c.wJ().T(a, (long) i7).field_msgId <= 0) {
                        com.tencent.mm.plugin.report.b.itm.a(403, 29, 1, false);
                        v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d lastSeq:%d not existed", Integer.valueOf(i5), Integer.valueOf(i7));
                        afVar = Mh;
                        obj = null;
                    } else if (i5 > 1) {
                        v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList unDeliverCount:%d keep firstSeq:%d", Integer.valueOf(i5), Long.valueOf(Ni));
                        com.tencent.mm.plugin.report.b.itm.a(403, 27, 1, false);
                        afVar = Mh;
                        obj = null;
                    } else {
                        Mh.v((long) i3);
                        com.tencent.mm.plugin.report.b.itm.a(403, 28, 1, false);
                        afVar = Mh;
                        obj = null;
                    }
                } else {
                    ak.yW();
                    if (c.xw().Mu(a) > 0) {
                        Mh.v((long) i3);
                        com.tencent.mm.plugin.report.b.itm.a(403, 30, 1, false);
                        afVar = Mh;
                        obj = null;
                    } else {
                        ak.yW();
                        Ni = c.wJ().Ni(a);
                        if (Ni > 0) {
                            Mh.v(Ni);
                            com.tencent.mm.plugin.report.b.itm.a(403, 31, 1, false);
                            afVar = Mh;
                            obj = null;
                        } else {
                            com.tencent.mm.plugin.report.b.itm.a(403, 32, 1, false);
                            afVar = Mh;
                            obj = null;
                        }
                    }
                }
            } else {
                if (i3 == i7 && i5 == 0 && Mh.field_unReadCount > 0) {
                    com.tencent.mm.plugin.report.b.itm.a(403, 33, 1, false);
                    Mh.df(0);
                }
                v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList msgSeq <= lastSeq, do nothing [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i7));
                return;
            }
        }
        if (i2 > 0) {
            abVar.dl(abVar.field_atCount + i2);
        }
        at atVar = new at();
        atVar.di(0);
        atVar.cH(a);
        atVar.setType(i4);
        atVar.setContent(a2);
        if (i4 == 49) {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(com.tencent.mm.pluginsdk.model.app.j.dl(a, a2));
            atVar.setType(l.h(dV.type, dV.aXx, dV.cov, dV.cow, dV.cpT));
            if (atVar.bvZ() || atVar.bwa()) {
                a2 = dV.content;
            }
            atVar.setContent(a2);
        } else if (i4 == 10002) {
            ak.yU();
            if (atVar.field_type == CdnLogic.MediaType_FAVORITE_VIDEO && !be.kS(a2)) {
                if (be.kS(a2)) {
                    v.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                } else {
                    Map Ks;
                    if (a2.startsWith("~SEMI_XML~")) {
                        Ks = au.Ks(a2);
                        if (Ks == null) {
                            v.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        } else {
                            a2 = "brand_service";
                        }
                    } else {
                        int indexOf = a2.indexOf("<sysmsg");
                        if (indexOf == -1) {
                            v.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        } else {
                            Ks = bf.q(a2.substring(indexOf), "sysmsg");
                            if (Ks == null) {
                                v.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                            } else {
                                a2 = (String) Ks.get(".sysmsg.$type");
                            }
                        }
                    }
                    if (a2 != null && a2.equals("revokemsg")) {
                        v.i("MicroMsg.SysCmdMsgExtension", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                        Ks.get(".sysmsg.revokemsg.session");
                        a2 = (String) Ks.get(".sysmsg.revokemsg.newmsgid");
                        v.i("MicroMsg.SysCmdMsgExtension", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", a2, (String) Ks.get(".sysmsg.revokemsg.replacemsg"));
                        atVar.setContent(r4);
                        atVar.setType(10000);
                    }
                }
            }
        }
        abVar.di(0);
        abVar.setContent(atVar.field_content);
        abVar.ct(Integer.toString(atVar.field_type));
        ak.yW();
        ac.c cVar = c.wK().nuA;
        if (cVar != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            cVar.a(atVar, pString, pString2, pInt, false);
            abVar.cu(pString.value);
            abVar.cv(pString2.value);
            abVar.dj(pInt.value);
            if (atVar.field_type == 49) {
                a2 = (String) bf.q(abVar.field_content, "msg").get(".msg.appmsg.title");
                abVar.cu(be.ma(abVar.field_digest).concat(be.kS(a2) ? SQLiteDatabase.KeyEmpty : " " + be.ma(a2)));
            }
        } else {
            abVar.cu(abVar.field_content);
        }
        if (obj != null) {
            ak.yW();
            Ni = c.wK().d(abVar);
            v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList insert username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a, Long.valueOf(Ni), Long.valueOf(abVar.field_firstUnDeliverSeq), Long.valueOf(abVar.field_lastSeq), Integer.valueOf(abVar.field_UnDeliverCount));
        } else {
            abVar.dk(abVar.field_attrflag & -1048577);
            ak.yW();
            Ni = (long) c.wK().a(abVar, a, true);
            v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr, processAddMsgDigestList update username[%s], ret[%d], firstSeq[%d], lastSeq[%d], undeliver[%d]", a, Long.valueOf(Ni), Long.valueOf(abVar.field_firstUnDeliverSeq), Long.valueOf(abVar.field_lastSeq), Integer.valueOf(abVar.field_UnDeliverCount));
        }
        final o LD = ak.yW().wO().LD(a);
        ak.yW();
        com.tencent.mm.i.a LX = c.wH().LX(a);
        if (LX == null || ((int) LX.chr) <= 0) {
            v.i("MicroMsg.BigBallOfMudSyncExtension", "summerbadcr processAddMsgDigestList chatRoomId[%s], contact is null need get", a);
            com.tencent.mm.model.ab.a.crZ.a(a, null, new com.tencent.mm.model.ab.c.a(this) {
                final /* synthetic */ a cQD;

                public final void p(String str, boolean z) {
                    if (LD != null && LD.bvd()) {
                        b iiVar = new ii();
                        iiVar.biD.biB = a;
                        iiVar.biD.biE = LD.bvc();
                        com.tencent.mm.sdk.c.a.nhr.z(iiVar);
                    }
                }
            });
        }
        if (com.tencent.mm.sdk.b.b.foreground && i4 != 10002 && i5 > 0) {
            bm bmVar = new bm();
            bmVar.mbU = bnVar.mcd;
            bmVar.mbV = m.lY(k.xF());
            bmVar.hNS = bnVar.hNS;
            bmVar.mbW = bnVar.mcf;
            bmVar.gll = bnVar.gll;
            bmVar.mcb = bnVar.mcb;
            bmVar.mcc = bnVar.mcc;
            if (jVar != null) {
                jVar.a(atVar, bmVar);
            }
        }
    }
}
