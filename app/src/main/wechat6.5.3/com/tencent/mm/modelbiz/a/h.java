package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.protocal.c.bat;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.protocal.c.hb;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.protocal.c.tg;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.protocal.c.ti;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h implements e {
    public h() {
        ak.vy().a(1352, (e) this);
        ak.vy().a(1365, (e) this);
        ak.vy().a(1353, (e) this);
        ak.vy().a(1354, (e) this);
        ak.vy().a(1357, (e) this);
        ak.vy().a(1356, (e) this);
        ak.vy().a(1355, (e) this);
        ak.vy().a(1358, (e) this);
        ak.vy().a(1367, (e) this);
        ak.vy().a(1361, (e) this);
        ak.vy().a(1389, (e) this);
        ak.vy().a(1315, (e) this);
    }

    protected final void finalize() {
        ak.vy().b(1352, (e) this);
        ak.vy().b(1365, (e) this);
        ak.vy().b(1353, (e) this);
        ak.vy().b(1354, (e) this);
        ak.vy().b(1357, (e) this);
        ak.vy().b(1356, (e) this);
        ak.vy().b(1355, (e) this);
        ak.vy().b(1358, (e) this);
        ak.vy().b(1367, (e) this);
        ak.vy().b(1361, (e) this);
        ak.vy().b(1389, (e) this);
        ak.vy().b(1315, (e) this);
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            int i3;
            boolean a;
            int i4;
            com.tencent.mm.modelbiz.k kVar2;
            String str2;
            String str3;
            switch (kVar.getType()) {
                case 1315:
                    m mVar = (m) kVar;
                    ls DQ = mVar.DQ();
                    i3 = 0;
                    if (DQ == null || DQ.mhP == null || DQ.mhP.ret != 0) {
                        if (DQ == null || DQ.mhP == null) {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(DQ.mhP.ret));
                        }
                        i3 = -1;
                    }
                    if (i3 >= 0 && DQ.mou == null && DQ.mot == null) {
                        i3 = -1;
                    }
                    if (i3 >= 0) {
                        if (DQ.mou != null) {
                            a = a(DQ.mou, DQ.mhJ);
                            if (a) {
                                mVar.cEj = DQ.mou.mhK;
                            }
                        } else {
                            a = a(DQ.mot, DQ.mhJ, true);
                            if (a) {
                                mVar.cEj = DQ.mot.muP.mhD;
                            }
                        }
                        if (!a) {
                            i4 = -1;
                            kVar2 = (com.tencent.mm.modelbiz.k) mVar.data;
                            if (kVar2 != null) {
                                kVar2.a(i4, mVar);
                                return;
                            }
                            return;
                        }
                    }
                    i4 = i3;
                    kVar2 = (com.tencent.mm.modelbiz.k) mVar.data;
                    if (kVar2 != null) {
                        kVar2.a(i4, mVar);
                        return;
                    }
                    return;
                case 1352:
                    o oVar = (o) kVar;
                    tg tgVar = (oVar.cif == null || oVar.cif.czl.czs == null) ? null : (tg) oVar.cif.czl.czs;
                    tf tfVar = (oVar.cif == null || oVar.cif.czk.czs == null) ? null : (tf) oVar.cif.czk.czs;
                    boolean z = oVar.cEk;
                    if (tgVar != null && tgVar.mhP != null && tgVar.mhP.ret == 0) {
                        a(tgVar.moz, tfVar.mhJ, z);
                        return;
                    } else if (tgVar == null || tgVar.mhP == null) {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        return;
                    } else {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(tgVar.mhP.ret));
                        return;
                    }
                case 1353:
                    int i5;
                    r rVar = (r) kVar;
                    tk tkVar = (rVar.cif == null || rVar.cif.czl.czs == null) ? null : (tk) rVar.cif.czl.czs;
                    i3 = 0;
                    if (tkVar == null || tkVar.mhP == null || tkVar.mhP.ret != 0) {
                        if (tkVar == null || tkVar.mhP == null) {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(tkVar.mhP.ret));
                        }
                        i3 = -1;
                    }
                    if (i3 < 0 || tkVar.mhQ != null) {
                        i5 = i3;
                    } else {
                        v.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
                        i5 = -1;
                    }
                    if (i5 >= 0) {
                        d dVar = u.DC().cie;
                        long j = 0;
                        if (dVar instanceof g) {
                            j = ((g) dVar).er(Thread.currentThread().getId());
                        }
                        for (int i6 = 0; i6 < tkVar.mhQ.size(); i6++) {
                            v.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", ((hb) tkVar.mhQ.get(i6)).eES);
                            j jVar = new j();
                            jVar.field_userId = ((hb) tkVar.mhQ.get(i6)).mhK;
                            jVar.field_userName = ((hb) tkVar.mhQ.get(i6)).eES;
                            str2 = jVar.field_userId;
                            str2 = (str2 == null || rVar.cEm == null) ? null : (String) rVar.cEm.get(str2);
                            jVar.field_brandUserName = str2;
                            jVar.field_UserVersion = ((hb) tkVar.mhQ.get(i6)).ver;
                            jVar.field_headImageUrl = ((hb) tkVar.mhQ.get(i6)).mhE;
                            jVar.field_profileUrl = ((hb) tkVar.mhQ.get(i6)).mhS;
                            jVar.field_bitFlag = ((hb) tkVar.mhQ.get(i6)).mhF;
                            jVar.field_addMemberUrl = ((hb) tkVar.mhQ.get(i6)).mhI;
                            jVar.field_needToUpdate = false;
                            j ig = u.DC().ig(((hb) tkVar.mhQ.get(i6)).mhK);
                            boolean fe = ig == null ? false : ig.fe(16);
                            boolean fe2 = jVar.fe(16);
                            if (ig == null) {
                                u.DC().a(jVar);
                            } else {
                                u.DC().b(jVar);
                            }
                            if (fe != fe2) {
                                c hR = u.DA().hR(jVar.field_userId);
                                if (hR != null) {
                                    if (fe && !fe2) {
                                        u.DB().Y(hR.field_bizChatLocalId);
                                    } else if (!fe && fe2) {
                                        u.DB().X(hR.field_bizChatLocalId);
                                    }
                                }
                            }
                        }
                        if (dVar instanceof g) {
                            ak.yW();
                            c.wE().es(j);
                        }
                    }
                    kVar2 = (com.tencent.mm.modelbiz.k) rVar.data;
                    if (kVar2 != null) {
                        kVar2.a(i5, rVar);
                        return;
                    }
                    return;
                case 1354:
                    int i7;
                    q qVar = (q) kVar;
                    ti tiVar = (qVar.cif == null || qVar.cif.czl.czs == null) ? null : (ti) qVar.cif.czl.czs;
                    th thVar = qVar.cif == null ? null : (th) qVar.cif.czk.czs;
                    if (tiVar == null || tiVar.mhP == null || tiVar.mhP.ret != 0) {
                        if (tiVar == null || tiVar.mhP == null) {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(tiVar.mhP.ret));
                        }
                        i7 = -1;
                    } else {
                        i7 = 0;
                    }
                    if (i7 >= 0) {
                        k DC = u.DC();
                        String str4 = thVar.mhJ;
                        hb hbVar = tiVar.mhM;
                        if (hbVar == null || be.kS(str4)) {
                            v.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
                        } else {
                            v.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", str4, hbVar.mhK, Boolean.valueOf(be.kS(hbVar.mhI)));
                            f ie = u.DD().ie(str4);
                            if (ie == null) {
                                ie = new f();
                                ie.field_brandUserName = str4;
                                ie.field_userId = hbVar.mhK;
                                u.DD().a(ie);
                            } else {
                                ie.field_userId = hbVar.mhK;
                                u.DD().b(ie);
                                v.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
                            }
                            j jVar2 = new j();
                            jVar2.field_userId = hbVar.mhK;
                            jVar2.field_userName = hbVar.eES;
                            jVar2.field_brandUserName = str4;
                            jVar2.field_UserVersion = hbVar.ver;
                            jVar2.field_headImageUrl = hbVar.mhE;
                            jVar2.field_profileUrl = hbVar.mhS;
                            jVar2.field_bitFlag = hbVar.mhF;
                            jVar2.field_needToUpdate = false;
                            jVar2.field_addMemberUrl = hbVar.mhI;
                            if (!DC.b(jVar2)) {
                                DC.a(jVar2);
                            }
                            DC.cDH.put(str4, jVar2.field_userId);
                        }
                    }
                    kVar2 = (com.tencent.mm.modelbiz.k) qVar.data;
                    if (kVar2 != null) {
                        kVar2.a(i7, qVar);
                        return;
                    }
                    return;
                case 1355:
                    n nVar = (n) kVar;
                    lx DR = nVar.DR();
                    lw DS = nVar.DS();
                    i3 = 0;
                    if (DR == null || DR.mhP == null || DR.mhP.ret != 0) {
                        if (DR == null || DR.mhP == null) {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(DR.mhP.ret));
                        }
                        i3 = -1;
                    }
                    if (i3 >= 0) {
                        i4 = a(DR.moz, DS.mhJ, true) ? 0 : -1;
                    } else {
                        i4 = i3;
                    }
                    kVar2 = (com.tencent.mm.modelbiz.k) nVar.data;
                    if (kVar2 != null) {
                        kVar2.a(i4, nVar);
                        return;
                    }
                    return;
                case 1356:
                    w wVar = (w) kVar;
                    bau com_tencent_mm_protocal_c_bau = (wVar.cif == null || wVar.cif.czl.czs == null) ? null : (bau) wVar.cif.czl.czs;
                    bat com_tencent_mm_protocal_c_bat = (wVar.cif == null || wVar.cif.czk.czs == null) ? null : (bat) wVar.cif.czk.czs;
                    i3 = 0;
                    if (com_tencent_mm_protocal_c_bau == null || com_tencent_mm_protocal_c_bau.mhP == null || com_tencent_mm_protocal_c_bau.mhP.ret != 0 || com_tencent_mm_protocal_c_bau.muP == null) {
                        if (com_tencent_mm_protocal_c_bau == null || com_tencent_mm_protocal_c_bau.mhP == null) {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(com_tencent_mm_protocal_c_bau.mhP.ret));
                        }
                        i3 = -1;
                    }
                    if (i3 >= 0) {
                        c hR2 = u.DA().hR(com_tencent_mm_protocal_c_bau.muP.mhD);
                        if (hR2 == null) {
                            str3 = "MicroMsg.BizChatNetworkMgr";
                            String str5 = "bizChatInfo == null:%s, resp.chat == null:%s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.valueOf(hR2 == null);
                            objArr[1] = Boolean.valueOf(com_tencent_mm_protocal_c_bau.muP == null);
                            v.w(str3, str5, objArr);
                            i3 = -1;
                        }
                        if (i3 < 0 || ((hR2.field_bitFlag == com_tencent_mm_protocal_c_bau.muP.mhF || !hR2.DO()) && com_tencent_mm_protocal_c_bau.muP.ver <= hR2.field_chatVersion)) {
                            i4 = -1;
                        } else {
                            hR2.field_chatType = com_tencent_mm_protocal_c_bau.muP.type;
                            hR2.field_headImageUrl = com_tencent_mm_protocal_c_bau.muP.mhE;
                            hR2.field_chatName = com_tencent_mm_protocal_c_bau.muP.name;
                            hR2.field_chatVersion = com_tencent_mm_protocal_c_bau.muP.ver;
                            hR2.field_needToUpdate = false;
                            hR2.field_bitFlag = com_tencent_mm_protocal_c_bau.muP.mhF;
                            hR2.field_maxMemberCnt = com_tencent_mm_protocal_c_bau.muP.mhG;
                            hR2.field_ownerUserId = com_tencent_mm_protocal_c_bau.muP.mhH;
                            hR2.field_addMemberUrl = com_tencent_mm_protocal_c_bau.muP.mhI;
                            hR2.field_brandUserName = com_tencent_mm_protocal_c_bat.mhJ;
                            u.DA().b(hR2);
                            i4 = i3;
                        }
                    } else {
                        i4 = i3;
                    }
                    kVar2 = (com.tencent.mm.modelbiz.k) wVar.data;
                    if (kVar2 != null) {
                        kVar2.a(i4, wVar);
                        return;
                    }
                    return;
                case 1357:
                    v.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
                    x xVar = (x) kVar;
                    bas com_tencent_mm_protocal_c_bas = (xVar.cif == null || xVar.cif.czl.czs == null) ? null : (bas) xVar.cif.czl.czs;
                    bar com_tencent_mm_protocal_c_bar = (xVar.cif == null || xVar.cif.czk.czs == null) ? null : (bar) xVar.cif.czk.czs;
                    if (com_tencent_mm_protocal_c_bas != null && com_tencent_mm_protocal_c_bas.mhP != null && com_tencent_mm_protocal_c_bas.mhP.ret == 0) {
                        i4 = a(com_tencent_mm_protocal_c_bas.moz, com_tencent_mm_protocal_c_bar.mhJ, false) ? 0 : -1;
                        kVar2 = (com.tencent.mm.modelbiz.k) xVar.data;
                        if (kVar2 != null) {
                            kVar2.a(i4, xVar);
                            return;
                        }
                        return;
                    } else if (com_tencent_mm_protocal_c_bas == null || com_tencent_mm_protocal_c_bas.mhP == null) {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        return;
                    } else {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(com_tencent_mm_protocal_c_bas.mhP.ret));
                        return;
                    }
                case 1358:
                    return;
                case 1365:
                    p pVar = (p) kVar;
                    te teVar = (pVar.cif == null || pVar.cif.czl.czs == null) ? null : (te) pVar.cif.czl.czs;
                    if (teVar != null && teVar.mhP != null && teVar.mhP.ret == 0) {
                        LinkedList linkedList = teVar.mwE;
                        if (linkedList == null || linkedList.size() == 0) {
                            v.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
                            return;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ra raVar = (ra) it.next();
                            String str6 = raVar.muP.mhD;
                            str6 = (str6 == null || pVar.cEl == null) ? null : (String) pVar.cEl.get(str6);
                            a(raVar, str6, false);
                        }
                        return;
                    } else if (teVar == null || teVar.mhP == null) {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        return;
                    } else {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(teVar.mhP.ret));
                        return;
                    }
                case 1367:
                    s sVar = (s) kVar;
                    vz vzVar = (sVar.cif == null || sVar.cif.czl.czs == null) ? null : (vz) sVar.cif.czl.czs;
                    vy vyVar = (sVar.cif == null || sVar.cif.czk.czs == null) ? null : (vy) sVar.cif.czk.czs;
                    if (vzVar != null && vzVar.mhP != null && vzVar.mhP.ret == 0) {
                        List<String> list = vzVar.myz;
                        d DA = u.DA();
                        str3 = vyVar.mhJ;
                        List<String> arrayList = new ArrayList();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("select bizChatServId from BizChatInfo");
                        stringBuilder.append(" where brandUserName = '").append(str3).append("'");
                        stringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
                        Cursor rawQuery = DA.rawQuery(stringBuilder.toString(), new String[0]);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                do {
                                    arrayList.add(rawQuery.getString(0));
                                } while (rawQuery.moveToNext());
                            }
                            rawQuery.close();
                        }
                        for (String str22 : arrayList) {
                            if (!list.contains(str22)) {
                                c hR3 = u.DA().hR(str22);
                                if (hR3 != null) {
                                    hR3.field_bitFlag &= -9;
                                    u.DA().b(hR3);
                                }
                            }
                        }
                        for (String str222 : list) {
                            if (!arrayList.contains(str222)) {
                                c hR4 = u.DA().hR(str222);
                                if (hR4 == null) {
                                    hR4 = new c();
                                    hR4.field_bizChatServId = str222;
                                    hR4.field_brandUserName = vyVar.mhJ;
                                    hR4.field_bitFlag |= 8;
                                    u.DA().a(hR4);
                                } else {
                                    hR4.field_bitFlag |= 8;
                                    u.DA().b(hR4);
                                }
                            }
                        }
                        a(vzVar.myz, vyVar.mhJ);
                        return;
                    } else if (vzVar == null || vzVar.mhP == null) {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        return;
                    } else {
                        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(vzVar.mhP.ret));
                        return;
                    }
                case 1389:
                    t tVar = (t) kVar;
                    add DT = tVar.DT();
                    i3 = 0;
                    if (DT == null || DT.mhP == null || DT.mhP.ret != 0) {
                        if (DT == null || DT.mhP == null) {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(DT.mhP.ret));
                        }
                        i3 = -1;
                    }
                    if (i3 >= 0 && DT.mou == null && DT.mot == null) {
                        i3 = -1;
                    }
                    if (i3 >= 0) {
                        if (DT.mou != null) {
                            a = a(DT.mou, DT.mhJ);
                            if (a) {
                                tVar.cEj = DT.mou.mhK;
                            }
                        } else {
                            a = a(DT.mot, DT.mhJ, true);
                            if (a) {
                                tVar.cEj = DT.mot.muP.mhD;
                            }
                        }
                        if (!a) {
                            i4 = -1;
                            kVar2 = (com.tencent.mm.modelbiz.k) tVar.data;
                            if (kVar2 != null) {
                                kVar2.a(i4, tVar);
                                return;
                            }
                            return;
                        }
                    }
                    i4 = i3;
                    kVar2 = (com.tencent.mm.modelbiz.k) tVar.data;
                    if (kVar2 != null) {
                        kVar2.a(i4, tVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        v.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
    }

    public static void b(String str, String str2, boolean z) {
        ak.vy().a(new o(str, str2, z), 0);
    }

    public static void a(LinkedList<String> linkedList, String str) {
        if (linkedList != null && !linkedList.isEmpty()) {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                gv gvVar = new gv();
                gvVar.mhJ = str;
                gvVar.mhD = str2;
                linkedList2.add(gvVar);
            }
            if (!linkedList2.isEmpty()) {
                ak.vy().a(new p(linkedList2), 0);
            }
        }
    }

    public static void a(LinkedList<String> linkedList, String str, com.tencent.mm.modelbiz.k kVar) {
        hs hsVar = new hs();
        hsVar.mhJ = str;
        hsVar.miD = linkedList;
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(hsVar);
        ak.vy().a(new r(linkedList2, kVar), 0);
    }

    public static void a(String str, String str2, com.tencent.mm.modelbiz.k kVar) {
        j hX = e.hX(str2);
        if (hX == null || hX.field_userId.equals(str)) {
            a(str2, kVar);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        a(linkedList, str2, kVar);
    }

    public static void a(String str, com.tencent.mm.modelbiz.k kVar) {
        ak.vy().a(new q(str, kVar), 0);
    }

    public static n a(String str, ra raVar, com.tencent.mm.modelbiz.k kVar) {
        k nVar = new n(str, raVar, kVar);
        ak.vy().a(nVar, 0);
        return nVar;
    }

    public static x a(String str, String str2, gx gxVar, gx gxVar2, com.tencent.mm.modelbiz.k kVar) {
        k xVar = new x(str, str2, gxVar, gxVar2, kVar);
        ak.vy().a(xVar, 0);
        return xVar;
    }

    public static w a(String str, gu guVar, com.tencent.mm.modelbiz.k kVar) {
        k wVar = new w(str, guVar, kVar);
        ak.vy().a(wVar, 0);
        return wVar;
    }

    private static boolean a(hb hbVar, String str) {
        if (be.kS(str) || be.kS(hbVar.mhK)) {
            return false;
        }
        j jVar = new j();
        jVar.field_userId = hbVar.mhK;
        jVar.field_userName = hbVar.eES;
        jVar.field_brandUserName = str;
        jVar.field_headImageUrl = hbVar.mhE;
        jVar.field_profileUrl = hbVar.mhS;
        jVar.field_UserVersion = hbVar.ver;
        jVar.field_addMemberUrl = hbVar.mhI;
        if (!u.DC().b(jVar)) {
            u.DC().a(jVar);
        }
        c cVar = new c();
        cVar.field_bizChatServId = jVar.field_userId;
        cVar.field_brandUserName = jVar.field_brandUserName;
        cVar.field_chatName = jVar.field_userName;
        cVar.field_chatType = 1;
        if (u.DA().c(cVar) != null) {
            return true;
        }
        return false;
    }

    private static boolean a(ra raVar, String str, boolean z) {
        v.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
        if (raVar == null || raVar.muP == null || be.kS(str)) {
            v.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
            return false;
        }
        boolean z2;
        c cVar;
        c hR = u.DA().hR(raVar.muP.mhD);
        if (hR == null) {
            v.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
            hR = new c();
            hR.field_bizChatServId = raVar.muP.mhD;
            hR.field_brandUserName = str;
            z2 = true;
            cVar = hR;
        } else {
            z2 = false;
            cVar = hR;
        }
        if (raVar.mhL == null) {
            v.w("MicroMsg.BizChatNetworkMgr", "members==null");
            return false;
        }
        Iterator it;
        if (cVar.DO() || raVar.muP.ver > cVar.field_chatVersion) {
            cVar.field_chatType = raVar.muP.type;
            cVar.field_headImageUrl = raVar.muP.mhE;
            cVar.field_chatName = raVar.muP.name;
            cVar.field_chatVersion = raVar.muP.ver;
            cVar.field_needToUpdate = false;
            cVar.field_bitFlag = raVar.muP.mhF;
            cVar.field_maxMemberCnt = raVar.muP.mhG;
            cVar.field_ownerUserId = raVar.muP.mhH;
            cVar.field_addMemberUrl = raVar.muP.mhI;
            cVar.field_brandUserName = str;
            List linkedList = new LinkedList();
            it = raVar.mhL.iterator();
            while (it.hasNext()) {
                linkedList.add(((gw) it.next()).mhK);
            }
            cVar.field_userList = be.b(linkedList, ";");
            if (z2) {
                u.DA().a(cVar);
            } else {
                u.DA().b(cVar);
            }
        }
        e.h(cVar);
        gw gwVar;
        if (z) {
            hs hsVar = new hs();
            hsVar.mhJ = cVar.field_brandUserName;
            LinkedList linkedList2 = new LinkedList();
            it = raVar.mhL.iterator();
            while (it.hasNext()) {
                int i;
                gwVar = (gw) it.next();
                k DC = u.DC();
                String str2 = gwVar.mhK;
                if (be.kS(str2)) {
                    v.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
                    i = -1;
                } else {
                    j ig = DC.ig(str2);
                    if (ig != null) {
                        i = ig.field_UserVersion;
                    } else {
                        v.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
                        i = -1;
                    }
                }
                if (((long) gwVar.ver) > ((long) i)) {
                    linkedList2.add(gwVar.mhK);
                }
            }
            if (linkedList2.size() > 0) {
                hsVar.miD = linkedList2;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(hsVar);
                ak.vy().a(new r(linkedList3, null), 0);
            }
        } else {
            d dVar = u.DC().cie;
            long j = 0;
            if (dVar instanceof g) {
                j = ((g) dVar).er(Thread.currentThread().getId());
            }
            Iterator it2 = raVar.mhL.iterator();
            while (it2.hasNext()) {
                gwVar = (gw) it2.next();
                j ig2 = u.DC().ig(gwVar.mhK);
                if (ig2 == null) {
                    ig2 = new j();
                    ig2.field_userId = gwVar.mhK;
                    ig2.field_userName = gwVar.eES;
                    ig2.field_brandUserName = cVar.field_brandUserName;
                    ig2.field_needToUpdate = true;
                    u.DC().a(ig2);
                } else if (gwVar.ver > ig2.field_UserVersion) {
                    ig2.field_needToUpdate = true;
                    u.DC().b(ig2);
                }
            }
            if (dVar instanceof g) {
                ak.yW();
                c.wE().es(j);
            }
        }
        return true;
    }
}
