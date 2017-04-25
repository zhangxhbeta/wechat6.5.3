package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class y extends k implements j {
    public final b cif;
    private e cii = null;

    public y(int i) {
        a aVar = new a();
        aVar.czn = new yh();
        aVar.czo = new yi();
        aVar.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        aVar.czm = 143;
        aVar.czp = 38;
        aVar.czq = 1000000038;
        this.cif = aVar.Bv();
        yh yhVar = (yh) this.cif.czk.czs;
        yhVar.gly = 1;
        yhVar.mAf = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        yh yhVar = (yh) this.cif.czk.czs;
        if (yhVar.gly != 1 || ah.FO().fs(yhVar.mAf) != null) {
            return a(eVar, this.cif, this);
        }
        v.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
        return -1;
    }

    public final int getType() {
        return 143;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            yh yhVar = (yh) this.cif.czk.czs;
            yi yiVar = (yi) this.cif.czl.czs;
            if (yhVar.gly == 0) {
                a(yiVar.mAg);
            } else {
                af afVar;
                List<af> arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                List arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < yiVar.mAh.eet; i4++) {
                    Object obj;
                    k kVar;
                    h hVar;
                    aof com_tencent_mm_protocal_c_aof = (aof) yiVar.mAh.mOv.get(i4);
                    int i5 = yhVar.mAf;
                    v.v("MicroMsg.NetSceneGetQQGroup", "friend");
                    af afVar2 = new af();
                    afVar2.cIA = new o(com_tencent_mm_protocal_c_aof.mOr).longValue();
                    com.tencent.mm.u.b.d(afVar2.cIA, 3);
                    afVar2.cIC = i5;
                    afVar2.cIB = com_tencent_mm_protocal_c_aof.mOt;
                    if (com_tencent_mm_protocal_c_aof.mOt != 0) {
                        if (com_tencent_mm_protocal_c_aof.gln == null || com_tencent_mm_protocal_c_aof.gln.equals(SQLiteDatabase.KeyEmpty)) {
                            obj = null;
                            arrayList.add(obj);
                            kVar = new k();
                            kVar.bBZ = com_tencent_mm_protocal_c_aof.cHc;
                            kVar.bCi = com_tencent_mm_protocal_c_aof.cHg;
                            kVar.bCk = com_tencent_mm_protocal_c_aof.cHd;
                            kVar.bCl = com_tencent_mm_protocal_c_aof.cHe;
                            kVar.bCj = com_tencent_mm_protocal_c_aof.cHf;
                            kVar.username = com_tencent_mm_protocal_c_aof.gln;
                            arrayList2.add(kVar);
                            hVar = new h();
                            hVar.bBY = 3;
                            hVar.aP(true);
                            hVar.username = com_tencent_mm_protocal_c_aof.gln;
                            hVar.cyD = com_tencent_mm_protocal_c_aof.mlY;
                            hVar.cyC = com_tencent_mm_protocal_c_aof.mlZ;
                            arrayList3.add(hVar);
                        } else {
                            ak.yW();
                            ab LX = c.wH().LX(com_tencent_mm_protocal_c_aof.gln);
                            if (LX != null && LX.field_username.equals(com_tencent_mm_protocal_c_aof.gln) && com.tencent.mm.i.a.ei(LX.field_type)) {
                                afVar2.cIB = 2;
                            } else {
                                afVar2.cIB = 1;
                            }
                        }
                    }
                    afVar2.username = com_tencent_mm_protocal_c_aof.gln;
                    afVar2.cID = com_tencent_mm_protocal_c_aof.efy;
                    afVar2.cIJ = com_tencent_mm_protocal_c_aof.mOu;
                    afVar2.cIK = com.tencent.mm.platformtools.c.lU(com_tencent_mm_protocal_c_aof.mOu);
                    afVar2.cIL = com.tencent.mm.platformtools.c.lT(com_tencent_mm_protocal_c_aof.mOu);
                    afVar2.cIE = com.tencent.mm.platformtools.c.lU(com_tencent_mm_protocal_c_aof.efy);
                    afVar2.cIF = com.tencent.mm.platformtools.c.lT(com_tencent_mm_protocal_c_aof.efy);
                    afVar2.cIG = com_tencent_mm_protocal_c_aof.mOs;
                    afVar2.cIH = com.tencent.mm.platformtools.c.lU(com_tencent_mm_protocal_c_aof.mOs);
                    afVar2.cII = com.tencent.mm.platformtools.c.lT(com_tencent_mm_protocal_c_aof.mOs);
                    i5 = 32;
                    if (!be.kS(afVar2.FH())) {
                        i5 = afVar2.FH().charAt(0);
                    } else if (!be.kS(afVar2.FI())) {
                        i5 = afVar2.FI().charAt(0);
                    } else if (!be.kS(afVar2.FE())) {
                        i5 = afVar2.FE().charAt(0);
                    } else if (!be.kS(afVar2.FF())) {
                        i5 = afVar2.FF().charAt(0);
                    }
                    if (i5 >= 97 && i5 <= 122) {
                        i5 = (char) (i5 - 32);
                    } else if (i5 < 65 || i5 > 90) {
                        i5 = 123;
                    }
                    afVar2.cyz = i5;
                    ak.yW().xv().dJ(com_tencent_mm_protocal_c_aof.gln, com_tencent_mm_protocal_c_aof.mvR);
                    v.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + afVar2.FD() + "  remark: " + afVar2.FG());
                    af afVar3 = afVar2;
                    arrayList.add(obj);
                    kVar = new k();
                    kVar.bBZ = com_tencent_mm_protocal_c_aof.cHc;
                    kVar.bCi = com_tencent_mm_protocal_c_aof.cHg;
                    kVar.bCk = com_tencent_mm_protocal_c_aof.cHd;
                    kVar.bCl = com_tencent_mm_protocal_c_aof.cHe;
                    kVar.bCj = com_tencent_mm_protocal_c_aof.cHf;
                    kVar.username = com_tencent_mm_protocal_c_aof.gln;
                    arrayList2.add(kVar);
                    hVar = new h();
                    hVar.bBY = 3;
                    hVar.aP(true);
                    hVar.username = com_tencent_mm_protocal_c_aof.gln;
                    hVar.cyD = com_tencent_mm_protocal_c_aof.mlY;
                    hVar.cyC = com_tencent_mm_protocal_c_aof.mlZ;
                    arrayList3.add(hVar);
                }
                HashMap hashMap = new HashMap();
                ag FQ = ah.FQ();
                int i6 = yhVar.mAf;
                v.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i6);
                Cursor rawQuery = FQ.cuX.rawQuery("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i6 + "\"", null);
                while (rawQuery.moveToNext()) {
                    afVar = new af();
                    afVar.b(rawQuery);
                    hashMap.put(Long.valueOf(afVar.cIA), afVar);
                }
                rawQuery.close();
                for (af afVar4 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(afVar4.cIA))) {
                        afVar = (af) hashMap.get(Long.valueOf(afVar4.cIA));
                        Object obj2 = !be.r(Long.valueOf(afVar.cIA), Long.valueOf(afVar4.cIA)) ? null : !be.r(Integer.valueOf(afVar.cIB), Integer.valueOf(afVar4.cIB)) ? null : !be.r(Integer.valueOf(afVar.cIC), Integer.valueOf(afVar4.cIC)) ? null : !be.r(afVar.username, afVar4.username) ? null : !be.r(afVar.cID, afVar4.cID) ? null : !be.r(afVar.cIE, afVar4.cIE) ? null : !be.r(afVar.cIF, afVar4.cIF) ? null : !be.r(afVar.cIG, afVar4.cIG) ? null : !be.r(afVar.cIH, afVar4.cIH) ? null : !be.r(afVar.cII, afVar4.cII) ? null : !be.r(afVar.cIJ, afVar4.cIJ) ? null : !be.r(afVar.cIK, afVar4.cIK) ? null : !be.r(afVar.cIL, afVar4.cIL) ? null : !be.r(afVar.cyx, afVar4.cyx) ? null : !be.r(afVar.cyy, afVar4.cyy) ? null : !be.r(Integer.valueOf(afVar.cyz), Integer.valueOf(afVar4.cyz)) ? null : !be.r(Integer.valueOf(afVar.cyA), Integer.valueOf(afVar4.cyA)) ? null : 1;
                        if (obj2 == null) {
                            ah.FQ().a(afVar4.cIA, afVar4);
                            hashMap.remove(Long.valueOf(afVar4.cIA));
                        }
                    } else {
                        ah.FQ().a(afVar4);
                    }
                }
                for (Long longValue : hashMap.keySet()) {
                    long longValue2 = longValue.longValue();
                    com.tencent.mm.sdk.h.j FQ2 = ah.FQ();
                    v.d("MicroMsg.QQListStorage", "delete: QQ:" + longValue2);
                    if (FQ2.cuX.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue2)}) > 0) {
                        FQ2.b(5, FQ2, String.valueOf(longValue2));
                    }
                }
                ah.FN().z(arrayList2);
                n.Bo().z(arrayList3);
                ad adVar = new ad();
                adVar.cIs = yhVar.mAf;
                adVar.cIx = 0;
                adVar.cIw = (int) be.Nh();
                adVar.bkU = 48;
                ah.FO().a(adVar);
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    private static void a(aoi com_tencent_mm_protocal_c_aoi) {
        Map map;
        Cursor rawQuery = ah.FO().cuX.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null);
        if (rawQuery == null) {
            map = null;
        } else if (rawQuery.getCount() <= 0) {
            rawQuery.close();
            map = null;
        } else {
            map = new HashMap();
            for (int i = 0; i < rawQuery.getCount(); i++) {
                rawQuery.moveToPosition(i);
                ad adVar = new ad();
                adVar.b(rawQuery);
                map.put(Integer.valueOf(adVar.cIs), adVar);
            }
            rawQuery.close();
        }
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_aoi.eet; i2++) {
            ad adVar2;
            aoh com_tencent_mm_protocal_c_aoh = (aoh) com_tencent_mm_protocal_c_aoi.mOx.get(i2);
            v.d("MicroMsg.NetSceneGetQQGroup", "id:" + com_tencent_mm_protocal_c_aoh.mAf + " name:" + com_tencent_mm_protocal_c_aoh.muK + " mem:" + com_tencent_mm_protocal_c_aoh.mqV + " wei:" + com_tencent_mm_protocal_c_aoh.mOw + " md5:" + com_tencent_mm_protocal_c_aoh.mpI);
            if (com_tencent_mm_protocal_c_aoh.mAf < 0) {
                adVar = null;
            } else {
                adVar = new ad();
                adVar.cIs = com_tencent_mm_protocal_c_aoh.mAf;
                adVar.cIz = com_tencent_mm_protocal_c_aoh.muK;
                adVar.cIt = com_tencent_mm_protocal_c_aoh.mqV;
                adVar.cIu = com_tencent_mm_protocal_c_aoh.mOw;
                adVar.cIy = com_tencent_mm_protocal_c_aoh.mpI;
            }
            if (adVar == null) {
                v.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:" + i2);
            } else if (adVar.cIt != 0) {
                if (map != null) {
                    adVar2 = (ad) map.get(Integer.valueOf(adVar.cIs));
                } else {
                    adVar2 = null;
                }
                if (adVar2 == null) {
                    boolean z;
                    adVar.cIv = (int) be.Nh();
                    adVar.cIw = (int) be.Nh();
                    adVar.cIx = 1;
                    ae FO = ah.FO();
                    if (adVar != null) {
                        v.d("MicroMsg.QQGroupStorage", "insert: name:" + adVar.FA());
                        adVar.bkU = -1;
                        if (((int) FO.cuX.insert("qqgroup", "grouopid", adVar.Fy())) >= 0) {
                            FO.Ls();
                            z = true;
                            v.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + adVar.FA() + " ret:" + z);
                        }
                    }
                    z = false;
                    v.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + adVar.FA() + " ret:" + z);
                } else {
                    adVar2.cIx = -1;
                    v.d("MicroMsg.NetSceneGetQQGroup", adVar.Fz() + " " + adVar2.Fz() + " " + adVar.cIs);
                    if (!adVar2.Fz().equals(adVar.Fz())) {
                        adVar.cIw = (int) be.Nh();
                        adVar.cIx = 1;
                        adVar.bkU = -1;
                        v.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + adVar.FA() + " ret:" + ah.FO().a(adVar));
                    }
                }
            }
        }
        if (map != null) {
            for (Object obj : map.keySet()) {
                adVar2 = (ad) map.get(obj);
                if (adVar2.cIx == 0) {
                    boolean z2;
                    ae FO2 = ah.FO();
                    v.d("MicroMsg.QQGroupStorage", "delete: id:" + adVar2.cIs);
                    if (FO2.cuX.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        FO2.Ls();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    v.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + adVar2.FA() + " ret:" + z2);
                    ag FQ = ah.FQ();
                    v.d("MicroMsg.QQListStorage", "delete: GroupID:" + adVar2.cIs);
                    if (FQ.cuX.delete("qqlist", "groupid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    v.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + adVar2.FA() + " ret:" + z2);
                }
            }
        }
    }
}
