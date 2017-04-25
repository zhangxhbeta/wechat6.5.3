package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.ak.j;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.dx;
import com.tencent.mm.e.a.gd;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.a.hz;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.pc;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.ph;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.f.a.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.jo;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.protocal.c.mi;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c implements a {
    public final void a(u uVar, u uVar2, ais com_tencent_mm_protocal_c_ais, byte[] bArr, boolean z, boolean z2) {
        Object obj;
        String str = uVar.field_username;
        String str2 = uVar.field_encryptUsername;
        if (!(uVar2 == null || be.ma(uVar2.bCu).equals(be.ma(com_tencent_mm_protocal_c_ais.mJn)))) {
            com.tencent.mm.an.c.HV();
            com.tencent.mm.an.c.jy(str);
        }
        if (be.bl(bArr)) {
            a(uVar, com_tencent_mm_protocal_c_ais, true);
        } else if (u.vd(uVar.field_verifyFlag)) {
            a(com_tencent_mm_protocal_c_ais, str, uVar, true);
        }
        if (uVar2 == null || com.tencent.mm.i.a.ei(uVar2.field_type) || !com.tencent.mm.i.a.ei(uVar.field_type)) {
            obj = null;
        } else {
            obj = 1;
        }
        String str3 = "MicroMsg.BigBallContactAssemblerImpl";
        String str4 = "username:%s PhoneNumList size:%s";
        Object[] objArr = new Object[2];
        objArr[0] = uVar.field_username;
        objArr[1] = com_tencent_mm_protocal_c_ais.mJo == null ? SQLiteDatabase.KeyEmpty : Integer.valueOf(be.f(Integer.valueOf(com_tencent_mm_protocal_c_ais.mJo.mNk.size())));
        v.i(str3, str4, objArr);
        StringBuffer stringBuffer = new StringBuffer();
        if (!(com_tencent_mm_protocal_c_ais.mJo == null || com_tencent_mm_protocal_c_ais.mJo.mNk == null)) {
            Iterator it = com_tencent_mm_protocal_c_ais.mJo.mNk.iterator();
            while (it.hasNext()) {
                amr com_tencent_mm_protocal_c_amr = (amr) it.next();
                if (com_tencent_mm_protocal_c_amr.mNj != null) {
                    stringBuffer.append(com_tencent_mm_protocal_c_amr.mNj + ",");
                }
            }
        }
        v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", uVar.field_username, stringBuffer.toString());
        str = null;
        Object obj2 = null;
        if (uVar2 != null) {
            str = uVar2.bCz;
        }
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            ak.yW();
            ba Nw = com.tencent.mm.model.c.wI().Nw(str2);
            if (Nw != null) {
                str = Nw.field_conPhone;
            }
        }
        v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", uVar.field_username, be.ma(str));
        if (!be.kS(str)) {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            Object obj3 = null;
            while (i < length) {
                String str5 = split[i];
                String[] split2 = stringBuffer.toString().split(",");
                int length2 = split2.length;
                Object obj4 = obj2;
                int i2 = 0;
                while (i2 < length2) {
                    if (str5.equals(split2[i2])) {
                        obj4 = null;
                        break;
                    } else {
                        i2++;
                        int i3 = 1;
                    }
                }
                if (obj4 != null) {
                    stringBuffer.append(str5);
                    obj3 = 1;
                }
                i++;
                obj2 = obj4;
            }
            if (obj3 != null) {
                com.tencent.mm.ba.a com_tencent_mm_protocal_c_aje = new aje();
                com_tencent_mm_protocal_c_aje.mJq = uVar.field_username;
                ams com_tencent_mm_protocal_c_ams = new ams();
                if (!be.kS(stringBuffer.toString())) {
                    String[] split3 = stringBuffer.toString().split(",");
                    com_tencent_mm_protocal_c_ams.eet = split3.length;
                    com_tencent_mm_protocal_c_ams.mNk = new LinkedList();
                    for (String str6 : split3) {
                        amr com_tencent_mm_protocal_c_amr2 = new amr();
                        com_tencent_mm_protocal_c_amr2.mNj = str6;
                        com_tencent_mm_protocal_c_ams.mNk.add(com_tencent_mm_protocal_c_amr2);
                    }
                    com_tencent_mm_protocal_c_aje.mJo = com_tencent_mm_protocal_c_ams;
                    ak.yW();
                    com.tencent.mm.model.c.wG().b(new j.a(60, com_tencent_mm_protocal_c_aje));
                }
            }
            if (obj != null && 15 == com_tencent_mm_protocal_c_ais.mcP) {
                g gVar = g.iuh;
                Object[] objArr2 = new Object[4];
                objArr2[0] = uVar.field_username;
                objArr2[1] = Integer.valueOf(3);
                objArr2[2] = Integer.valueOf(be.kS(ah.FL().iA(uVar.field_username).EB()) ? 0 : 1);
                objArr2[3] = Integer.valueOf(stringBuffer.toString().split(",").length >= 5 ? 5 : stringBuffer.toString().split(",").length);
                gVar.h(12040, objArr2);
            }
        }
        v.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", uVar.field_username, stringBuffer.toString());
        str = stringBuffer.toString();
        if (!be.kS(str)) {
            v.i("MicroMsg.BigBallContactAssemblerImpl", str);
            uVar.cs(str);
        }
        str = null;
        ak.yW();
        ba Nw2 = com.tencent.mm.model.c.wI().Nw(uVar.field_encryptUsername);
        if (Nw2 != null) {
            str = Nw2.field_contactLabels;
        }
        if (be.kS(str)) {
            ak.yW();
            Nw2 = com.tencent.mm.model.c.wI().Nw(uVar.field_username);
            if (Nw2 != null) {
                str = Nw2.field_contactLabels;
            }
        }
        if (!be.kS(str)) {
            com.tencent.mm.pluginsdk.j.a.bmu().bV(uVar.field_username, str);
            Nw2.field_contactLabels = SQLiteDatabase.KeyEmpty;
            ak.yW();
            com.tencent.mm.model.c.wI().c(Nw2);
        }
        boolean z3 = false;
        ak.yW();
        Nw2 = com.tencent.mm.model.c.wI().Nw(uVar.field_username);
        if (be.kS(uVar.field_conRemark)) {
            if ((Nw2 == null || be.kS(Nw2.field_encryptUsername)) && !be.kS(str2)) {
                ak.yW();
                Nw2 = com.tencent.mm.model.c.wI().Nw(str2);
            }
            if (!(Nw2 == null || be.kS(Nw2.field_encryptUsername))) {
                v.d("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + Nw2.field_encryptUsername);
                uVar.bQ(Nw2.field_conRemark);
                uVar.bW(com.tencent.mm.platformtools.c.lT(Nw2.field_conRemark));
                uVar.bX(com.tencent.mm.platformtools.c.lU(Nw2.field_conRemark));
                z3 = a(uVar, Nw2);
            }
            switch (uVar.bbT) {
                case 10:
                case 11:
                case 13:
                    b bVar = null;
                    if (com_tencent_mm_protocal_c_ais != null && !be.kS(com_tencent_mm_protocal_c_ais.mJg)) {
                        v.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", com_tencent_mm_protocal_c_ais.mJg, com_tencent_mm_protocal_c_ais.mJh);
                        com.tencent.mm.modelfriend.c FL = ah.FL();
                        String str7 = com_tencent_mm_protocal_c_ais.mJg;
                        str4 = com_tencent_mm_protocal_c_ais.mJh;
                        bVar = FL.iB(str7);
                        if (bVar == null) {
                            bVar = FL.iB(str4);
                        }
                    } else if (!be.kS(str2)) {
                        bVar = ah.FL().iA(str2);
                    }
                    if (bVar == null) {
                        v.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
                    } else {
                        v.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", be.ma(bVar.ED()), be.ma(bVar.getUsername()), Boolean.valueOf(bVar.EN()));
                    }
                    if (!(bVar == null || be.kS(bVar.ED()) || !bVar.EN())) {
                        v.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", bVar.ED(), bVar.getUsername(), Boolean.valueOf(z3));
                        bVar.username = uVar.field_username;
                        bVar.status = 2;
                        bVar.EM();
                        if (!z3) {
                            uVar.bQ(bVar.ED());
                            uVar.bW(com.tencent.mm.platformtools.c.lT(bVar.ED()));
                            uVar.bX(com.tencent.mm.platformtools.c.lU(bVar.ED()));
                            z3 = true;
                        }
                        if (com.tencent.mm.i.a.ei(uVar.field_type)) {
                            v.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", bVar.ED(), bVar.getUsername(), Boolean.valueOf(z3));
                            ah.FL().a(bVar.EB(), bVar);
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (!(Nw2 == null || be.kS(uVar.bCt) || uVar.bCt.equals(Nw2.field_conDescription))) {
            a(uVar, Nw2);
        }
        z3 = false;
        v.i("MicroMsg.BigBallContactAssemblerImpl", "needModContact %s", Boolean.valueOf(z3));
        if (z3) {
            m.s(uVar);
        }
    }

    public final void b(u uVar, u uVar2, ais com_tencent_mm_protocal_c_ais, byte[] bArr, boolean z, boolean z2) {
        Object obj;
        String awp;
        com.tencent.mm.sdk.c.b phVar;
        int i;
        Object obj2;
        BizInfo ho;
        String str;
        long currentTimeMillis;
        af Mh;
        com.tencent.mm.sdk.h.j wK;
        ab Mh2;
        Cursor rawQuery;
        at MI;
        String str2 = uVar.field_username;
        if (m.dE(str2)) {
            jp jpVar;
            com.tencent.mm.sdk.c.b pdVar;
            if (com_tencent_mm_protocal_c_ais.mxC != null) {
                Iterator it;
                LinkedList linkedList = com_tencent_mm_protocal_c_ais.mxC.mlV;
                if (com.tencent.mm.pluginsdk.j.a.lxP == null) {
                    obj = null;
                } else {
                    awp = com.tencent.mm.pluginsdk.j.a.lxP.awp();
                    if (!be.kS(awp) && awp.equals(str2) && m.dE(str2)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                jpVar = (jp) it.next();
                                if (!be.kS(jpVar.gln) && jpVar.gln.equals(k.xF())) {
                                    obj = null;
                                    break;
                                }
                            }
                        }
                        if (com.tencent.mm.pluginsdk.j.a.lxQ != null) {
                            if (com.tencent.mm.pluginsdk.j.a.lxQ.bY(str2, k.xF())) {
                                v.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
                                phVar = new ph();
                                phVar.bqF.userName = str2;
                                com.tencent.mm.sdk.c.a.nhr.z(phVar);
                            }
                            com.tencent.mm.pluginsdk.j.a.lxQ.a(str2, null, 0.0d, 0.0d, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                        }
                        if (!(com.tencent.mm.pluginsdk.j.a.lxP == null || be.kS(com.tencent.mm.pluginsdk.j.a.lxQ.awz()))) {
                            v.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", com.tencent.mm.pluginsdk.j.a.lxP.awp());
                            phVar = new dx();
                            phVar.bbQ.username = com.tencent.mm.pluginsdk.j.a.lxP.awp();
                            com.tencent.mm.sdk.c.a.nhr.z(phVar);
                        }
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    linkedList = com_tencent_mm_protocal_c_ais.mxC.mlV;
                    pdVar = new pd();
                    pdVar.bqt.bqv = true;
                    com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                    if (!be.kS(str2) && m.dE(str2) && !be.kS(pdVar.bqu.bqx) && str2.equals(pdVar.bqu.bqx)) {
                        if (linkedList != null) {
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                jpVar = (jp) it.next();
                                if (!be.kS(jpVar.gln)) {
                                    if (jpVar.gln.equals(k.xF())) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
                            com.tencent.mm.pluginsdk.j.a.lxG.a(str2, null, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0);
                        }
                        phVar = new pd();
                        phVar.bqt.bqw = true;
                        com.tencent.mm.sdk.c.a.nhr.z(phVar);
                        phVar = new pc();
                        phVar.bqr.bqs = true;
                        com.tencent.mm.sdk.c.a.nhr.z(phVar);
                    }
                }
                linkedList = com_tencent_mm_protocal_c_ais.mxC.mlV;
                if (com.tencent.mm.pluginsdk.j.a.lxR != null && linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        jpVar = (jp) it.next();
                        if (be.kS(jpVar.gln) || !jpVar.gln.equals(k.xF())) {
                        }
                    }
                    obj = 1;
                    if (!(obj == null || com.tencent.mm.pluginsdk.j.a.lxR == null)) {
                        com.tencent.mm.pluginsdk.j.a.lxR.wG(str2);
                    }
                }
                obj = null;
                com.tencent.mm.pluginsdk.j.a.lxR.wG(str2);
            }
            awp = "MicroMsg.BigBallContactAssemblerImpl";
            String str3 = "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ";
            Object[] objArr = new Object[9];
            objArr[0] = str2;
            if (com_tencent_mm_protocal_c_ais.mxC == null) {
                i = 0;
            } else {
                i = com_tencent_mm_protocal_c_ais.mxC.eOX;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = com_tencent_mm_protocal_c_ais.mJb;
            objArr[3] = com_tencent_mm_protocal_c_ais.mJa;
            objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_ais.mJl);
            objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_ais.mJk);
            objArr[6] = com_tencent_mm_protocal_c_ais.gor;
            objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_ais.mJj);
            if (com_tencent_mm_protocal_c_ais.mxC == null) {
                i = -1;
            } else {
                i = com_tencent_mm_protocal_c_ais.mxC.mlW;
            }
            objArr[8] = Integer.valueOf(i);
            v.i(awp, str3, objArr);
            if (!(com_tencent_mm_protocal_c_ais.mxC == null || com_tencent_mm_protocal_c_ais.mxC.eOX == 0)) {
                o LC;
                com.tencent.mm.g.a.a.a aVar = new com.tencent.mm.g.a.a.a();
                aVar.type = com_tencent_mm_protocal_c_ais.mJl;
                aVar.caG = com_tencent_mm_protocal_c_ais.mJk;
                aVar.caH = com_tencent_mm_protocal_c_ais.gor;
                aVar.caI = com_tencent_mm_protocal_c_ais.mJj;
                if (com_tencent_mm_protocal_c_ais.mxC.mlW == 0) {
                    aVar.biE = com_tencent_mm_protocal_c_ais.mJj;
                }
                i = com_tencent_mm_protocal_c_ais.mJj;
                o LC2 = ak.yW().wO().LC(str2);
                obj = (LC2 == null || LC2.field_chatroomVersion >= i) ? null : 1;
                if (obj != null) {
                    com.tencent.mm.sdk.c.a.nhr.z(new gd());
                    i = com_tencent_mm_protocal_c_ais.mJl;
                    p wO = ak.yW().wO();
                    LC = wO.LC(str2);
                    if (LC != null) {
                        if (LC.b(LC.nnW)) {
                            LC.bvb();
                        }
                        com.tencent.mm.g.a.a.a aVar2 = LC.nnW;
                        aVar2.type = i;
                        LC.a(str2, aVar2, false);
                        wO.b(LC);
                    }
                }
                pdVar = new ii();
                pdVar.biD.biB = str2;
                pdVar.biD.biE = aVar.biE;
                String str4 = com_tencent_mm_protocal_c_ais.mJa;
                jo joVar = com_tencent_mm_protocal_c_ais.mxC;
                String xF = k.xF();
                if ((str2.toLowerCase().endsWith("@chatroom") || str2.toLowerCase().endsWith("@groupcard") || str2.toLowerCase().endsWith("@talkroom")) && joVar.eOX != 0) {
                    ak.yW();
                    aa wH = com.tencent.mm.model.c.wH();
                    o LC3 = ak.yW().wO().LC(str2);
                    if (LC3 != null) {
                        aVar.biE = LC3.bvc();
                    }
                    List arrayList = new ArrayList();
                    boolean z3 = false;
                    v.d("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str2 + "] memCnt:" + joVar.eOX);
                    for (int i2 = 0; i2 < joVar.eOX; i2++) {
                        jpVar = (jp) joVar.mlV.get(i2);
                        com.tencent.mm.e.b.ab LX = wH.LX(jpVar.gln);
                        if (LX == null) {
                            v.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
                        } else {
                            boolean z4;
                            com.tencent.mm.g.a.a.b bVar = new com.tencent.mm.g.a.a.b();
                            bVar.userName = jpVar.gln;
                            bVar.caL = jpVar.mmb;
                            if (joVar.mlW == 0) {
                                bVar.caJ = jpVar.mlX;
                                bVar.caK = jpVar.mma;
                                if (!be.kS(jpVar.mlZ)) {
                                    h gQ = n.Bo().gQ(jpVar.gln);
                                    if (gQ == null) {
                                        gQ = new h();
                                        gQ.username = jpVar.gln;
                                    }
                                    gQ.cyD = jpVar.mlY;
                                    gQ.cyC = jpVar.mlZ;
                                    gQ.bBY = 3;
                                    gQ.aP(!be.kS(jpVar.mlY));
                                    n.Bo().a(gQ);
                                }
                            }
                            if (LC3 != null) {
                                com.tencent.mm.g.a.a.b Ly = LC3.Ly(jpVar.gln);
                                if (Ly != null) {
                                    bVar.caJ = Ly.caJ;
                                    bVar.caK = Ly.caK;
                                    bVar.caL = jpVar.mmb;
                                }
                            }
                            aVar.caF.add(bVar);
                            if (((int) LX.chr) == 0) {
                                LX.setUsername(jpVar.gln);
                                if (jpVar.efy != null) {
                                    LX.bS(jpVar.efy);
                                }
                                LX.to();
                                wH.N(LX);
                                z4 = true;
                            } else {
                                z4 = z3;
                            }
                            arrayList.add(LX.field_username);
                            z3 = z4;
                        }
                    }
                    v.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + arrayList.size() + " event: " + pdVar + " publish: " + z3);
                    if (z3) {
                        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                    } else if (LC3 != null) {
                        o.bve();
                    } else {
                        v.i("MicroMsg.ChatroomMembersLogic", "ChatroomId:%s is Need Update All InviteerInfo ", str2);
                        ((ii) pdVar).biD.biE = 0;
                        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                    }
                    o LC4 = ak.yW().wO().LC(str2);
                    if (LC4 == null) {
                        LC4 = new o();
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    LC4.field_chatroomname = str2;
                    LC4.field_roomowner = str4;
                    LC = LC4.bS(arrayList);
                    LC.field_displayname = i.t(arrayList);
                    LC.a(xF, aVar, joVar.mlW != 0);
                    boolean a = i.a(LC4);
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                    v.d("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember ret : %s , during : %s", Boolean.valueOf(a), Long.valueOf(currentTimeMillis2));
                    if (LC4.bvd()) {
                        v.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", Integer.valueOf(LC4.bvc()));
                        phVar = new com.tencent.mm.e.a.ah();
                        phVar.aXS.username = str2;
                        com.tencent.mm.sdk.c.a.nhr.z(phVar);
                    }
                } else {
                    v.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str2 + "] listCnt:" + joVar.eOX);
                }
            }
        }
        if (!com.tencent.mm.i.a.ei(uVar.field_type)) {
            if (!(((uVar.field_type & 2) != 0 ? 1 : null) != null || u.ew(uVar.field_username) || m.dE(uVar.field_username))) {
                v.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", uVar.field_username, Integer.valueOf(uVar.field_type));
                ak.yW();
                com.tencent.mm.model.c.wK().Mf(uVar.field_username);
            }
        }
        if ((uVar.field_type & 2048) != 0) {
            if (uVar2 == null || (uVar2.field_type & 2048) != (uVar.field_type & 2048)) {
                if (e.hA(uVar.field_username) && !e.hC(uVar.field_username)) {
                    x(uVar);
                } else if (uVar.bvm() && e.hy(uVar.field_username) && uVar != null && uVar.bvm() && e.hy(uVar.field_username)) {
                    v.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + uVar.field_username);
                    ak.yW();
                    ab Mh3 = com.tencent.mm.model.c.wK().Mh(uVar.field_username);
                    com.tencent.mm.modelbiz.u.Dy().ho(uVar.field_username);
                    if (Mh3 == null) {
                        ak.yW();
                        if (com.tencent.mm.model.c.wK().Mh("officialaccounts") == null) {
                            Mh3 = new ab("officialaccounts");
                            Mh3.bvG();
                            ak.yW();
                            com.tencent.mm.model.c.wK().d(Mh3);
                        }
                        Mh3 = new ab(uVar.field_username);
                        Mh3.cw("officialaccounts");
                        ak.yW();
                        com.tencent.mm.model.c.wK().d(Mh3);
                    }
                }
            }
        } else if ((uVar2 == null || (uVar2.field_type & 2048) != (uVar.field_type & 2048)) && e.hA(uVar.field_username) && !e.hC(uVar.field_username)) {
            x(uVar);
        }
        if (uVar2 == null || com.tencent.mm.i.a.ei(uVar2.field_type) || !com.tencent.mm.i.a.ei(uVar.field_type)) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (e.hz(uVar.field_username)) {
            com.tencent.mm.modelbiz.u.DF();
            com.tencent.mm.modelbiz.c.a(uVar.field_username, null);
            if (obj2 != null && e.hA(uVar.field_username)) {
                if (e.hC(uVar.field_username)) {
                    com.tencent.mm.modelbiz.u.DE();
                    com.tencent.mm.modelbiz.a.h.a(uVar.field_username, null);
                } else if (e.hE(uVar.field_username)) {
                    ak.yW();
                    if (com.tencent.mm.model.c.wK().Mh(uVar.field_username) == null) {
                        ho = com.tencent.mm.modelbiz.u.Dy().ho(uVar.field_username);
                        ab abVar = new ab(uVar.field_username);
                        if (ho.CB()) {
                            abVar.cw(null);
                        } else {
                            v.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", ho.CF(), uVar.field_username);
                            abVar.cw(be.ma(ho.CF()));
                        }
                        abVar.bvG();
                        ak.yW();
                        com.tencent.mm.model.c.wK().d(abVar);
                    }
                }
            }
        }
        ho = e.hw(uVar.field_username);
        if (ho != null) {
            ExtInfo aX = ho.aX(false);
            if (aX != null) {
                i = 0;
                if (aX.cBx != null) {
                    i = aX.cBx.optInt("WXAppType", 0);
                }
                if (i != 0) {
                    obj = 1;
                    if (obj != null) {
                        com.tencent.mm.modelbiz.u.DI();
                        str = uVar.field_username;
                        if (!be.kS(str)) {
                            ho = com.tencent.mm.modelbiz.u.Dy().ho(str);
                            ho.field_attrSyncVersion = null;
                            ho.field_incrementUpdateTime = 0;
                            com.tencent.mm.modelbiz.u.Dy().e(ho);
                        }
                    }
                    if ((uVar.field_type & 8) == 0) {
                        if (uVar2 == null || (uVar2.field_type & 8) != (uVar.field_type & 8)) {
                            ak.yW();
                            com.tencent.mm.model.c.wK().c(new String[]{uVar.field_username}, "@blacklist");
                        }
                    } else if (uVar2 == null || (uVar2.field_type & 8) != (uVar.field_type & 8)) {
                        ak.yW();
                        com.tencent.mm.model.c.wK().c(new String[]{uVar.field_username}, SQLiteDatabase.KeyEmpty);
                    }
                    if (!z2) {
                        if (uVar != null && uVar.bvm() && com.tencent.mm.i.a.ei(uVar.field_type)) {
                            currentTimeMillis = System.currentTimeMillis();
                            ak.yW();
                            Mh = com.tencent.mm.model.c.wK().Mh(uVar.field_username);
                            if (Mh != null && Mh.el(4194304)) {
                                ak.yW();
                                boolean b = com.tencent.mm.model.c.wK().b(uVar.field_username, 4194304, false, Mh.field_attrflag);
                                v.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", uVar.field_username, Boolean.valueOf(b), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        }
                        if (uVar2 != null && ((int) uVar2.chr) > 0 && uVar2.bCr != 0 && uVar2.bCs == 0 && uVar.bCs == 1) {
                            StringBuilder stringBuilder;
                            v.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", uVar.field_username);
                            ak.yW();
                            wK = com.tencent.mm.model.c.wK();
                            awp = uVar.field_username;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Update rconversation");
                            stringBuilder.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + be.lZ(awp) + "\"");
                            v.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", stringBuilder.toString());
                            if (wK.cie.dF("rconversation", stringBuilder.toString())) {
                                wK.b(3, wK, awp);
                            }
                            ak.yW();
                            Mh2 = com.tencent.mm.model.c.wK().Mh("officialaccounts");
                            if (Mh2 != null) {
                                ak.yW();
                                ac wK2 = com.tencent.mm.model.c.wK();
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("SELECT SUM(rconversation.unReadCount").append(")");
                                stringBuilder2.append(" FROM rconversation");
                                stringBuilder2.append(" WHERE parentRef = 'officialaccounts").append("'");
                                v.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", stringBuilder2.toString());
                                rawQuery = wK2.cie.rawQuery(awp, null);
                                i = 0;
                                if (rawQuery != null) {
                                    if (rawQuery.getCount() > 0) {
                                        rawQuery.moveToFirst();
                                        i = rawQuery.getInt(0);
                                    }
                                    rawQuery.close();
                                }
                                Mh2.df(i);
                                v.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", Integer.valueOf(Mh2.field_unReadCount));
                                ak.yW();
                                str = com.tencent.mm.model.c.wK().Mr("officialaccounts");
                                ak.yW();
                                MI = com.tencent.mm.model.c.wJ().MI(str);
                                if (MI != null || MI.field_msgId <= 0) {
                                    Mh2.bvG();
                                } else {
                                    Mh2.M(MI);
                                    Mh2.setContent(MI.field_talker + ":" + MI.field_content);
                                    Mh2.ct(Integer.toString(MI.field_type));
                                    ak.yW();
                                    com.tencent.mm.storage.ac.c cVar = com.tencent.mm.model.c.wK().nuA;
                                    if (cVar != null) {
                                        PString pString = new PString();
                                        PString pString2 = new PString();
                                        PInt pInt = new PInt();
                                        MI.cH("officialaccounts");
                                        MI.setContent(Mh2.field_content);
                                        cVar.a(MI, pString, pString2, pInt, true);
                                        Mh2.cu(pString.value);
                                        Mh2.cv(pString2.value);
                                        Mh2.dj(pInt.value);
                                    }
                                }
                                ak.yW();
                                com.tencent.mm.model.c.wK().a(Mh2, Mh2.field_username, true);
                            }
                        }
                    }
                    if (obj2 != null) {
                        phVar = new hz();
                        phVar.bhS.username = uVar.field_username;
                        phVar.bhS.bhT = uVar.bhT;
                        com.tencent.mm.sdk.c.a.nhr.z(phVar);
                    }
                    if (obj2 != null && com_tencent_mm_protocal_c_ais.mcP == 18) {
                        phVar = new hn();
                        phVar.bhi.bhj = uVar.field_encryptUsername;
                        phVar.bhi.type = 2;
                        l.KE().kJ(phVar.bhi.bhj);
                        com.tencent.mm.sdk.c.a.nhr.z(phVar);
                    }
                    if (obj2 != null) {
                        ah(uVar.field_username, com_tencent_mm_protocal_c_ais.mcP);
                    }
                    com.tencent.mm.pluginsdk.j.a.bmu().avF();
                }
            }
        }
        obj = null;
        if (obj != null) {
            com.tencent.mm.modelbiz.u.DI();
            str = uVar.field_username;
            if (be.kS(str)) {
                ho = com.tencent.mm.modelbiz.u.Dy().ho(str);
                ho.field_attrSyncVersion = null;
                ho.field_incrementUpdateTime = 0;
                com.tencent.mm.modelbiz.u.Dy().e(ho);
            }
        }
        if ((uVar.field_type & 8) == 0) {
            ak.yW();
            com.tencent.mm.model.c.wK().c(new String[]{uVar.field_username}, SQLiteDatabase.KeyEmpty);
        } else {
            ak.yW();
            com.tencent.mm.model.c.wK().c(new String[]{uVar.field_username}, "@blacklist");
        }
        if (z2) {
            currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            Mh = com.tencent.mm.model.c.wK().Mh(uVar.field_username);
            ak.yW();
            boolean b2 = com.tencent.mm.model.c.wK().b(uVar.field_username, 4194304, false, Mh.field_attrflag);
            v.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", uVar.field_username, Boolean.valueOf(b2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            v.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", uVar.field_username);
            ak.yW();
            wK = com.tencent.mm.model.c.wK();
            awp = uVar.field_username;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Update rconversation");
            stringBuilder.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + be.lZ(awp) + "\"");
            v.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", stringBuilder.toString());
            if (wK.cie.dF("rconversation", stringBuilder.toString())) {
                wK.b(3, wK, awp);
            }
            ak.yW();
            Mh2 = com.tencent.mm.model.c.wK().Mh("officialaccounts");
            if (Mh2 != null) {
                ak.yW();
                ac wK22 = com.tencent.mm.model.c.wK();
                StringBuilder stringBuilder22 = new StringBuilder();
                stringBuilder22.append("SELECT SUM(rconversation.unReadCount").append(")");
                stringBuilder22.append(" FROM rconversation");
                stringBuilder22.append(" WHERE parentRef = 'officialaccounts").append("'");
                v.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", stringBuilder22.toString());
                rawQuery = wK22.cie.rawQuery(awp, null);
                i = 0;
                if (rawQuery != null) {
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        i = rawQuery.getInt(0);
                    }
                    rawQuery.close();
                }
                Mh2.df(i);
                v.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", Integer.valueOf(Mh2.field_unReadCount));
                ak.yW();
                str = com.tencent.mm.model.c.wK().Mr("officialaccounts");
                ak.yW();
                MI = com.tencent.mm.model.c.wJ().MI(str);
                if (MI != null) {
                }
                Mh2.bvG();
                ak.yW();
                com.tencent.mm.model.c.wK().a(Mh2, Mh2.field_username, true);
            }
        }
        if (obj2 != null) {
            phVar = new hz();
            phVar.bhS.username = uVar.field_username;
            phVar.bhS.bhT = uVar.bhT;
            com.tencent.mm.sdk.c.a.nhr.z(phVar);
        }
        phVar = new hn();
        phVar.bhi.bhj = uVar.field_encryptUsername;
        phVar.bhi.type = 2;
        l.KE().kJ(phVar.bhi.bhj);
        com.tencent.mm.sdk.c.a.nhr.z(phVar);
        if (obj2 != null) {
            ah(uVar.field_username, com_tencent_mm_protocal_c_ais.mcP);
        }
        com.tencent.mm.pluginsdk.j.a.bmu().avF();
    }

    public final void a(mi miVar) {
        String a = com.tencent.mm.platformtools.m.a(miVar.moM);
        if (e.hz(a)) {
            e.hF(a);
        }
    }

    private static void a(ais com_tencent_mm_protocal_c_ais, String str, u uVar, boolean z) {
        String xF = k.xF();
        if (xF != null && !xF.equals(str)) {
            BizInfo ho = com.tencent.mm.modelbiz.u.Dy().ho(str);
            ho.field_username = str;
            ho.field_brandList = com_tencent_mm_protocal_c_ais.cHm;
            mc mcVar = com_tencent_mm_protocal_c_ais.mFB;
            if (mcVar != null) {
                ho.field_brandFlag = mcVar.cHq;
                ho.field_brandInfo = mcVar.cHs;
                ho.field_brandIconURL = mcVar.cHt;
                ho.field_extInfo = mcVar.cHr;
                if (z) {
                    ho.field_attrSyncVersion = null;
                    ho.field_incrementUpdateTime = 0;
                    v.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", str);
                }
                if (!be.kS(ho.field_extInfo)) {
                    ho.aX(true);
                }
            }
            if (!(ho.aX(false) == null || ho.aX(false).CV() != 3 || ho.aX(false).CZ() == null || be.kS(ho.CF()))) {
                ho.field_enterpriseFather = ho.CF();
                v.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", str, ho.field_enterpriseFather);
            }
            if (!com.tencent.mm.modelbiz.u.Dy().e(ho)) {
                com.tencent.mm.modelbiz.u.Dy().d(ho);
            }
            uVar.dd(ho.field_type);
        }
    }

    public static boolean a(u uVar, ais com_tencent_mm_protocal_c_ais, boolean z) {
        if (uVar == null || be.kS(uVar.field_username)) {
            v.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
            return false;
        }
        String str = uVar.field_username;
        String str2 = uVar.field_encryptUsername;
        n.Bo().a(com.tencent.mm.u.b.a(str, com_tencent_mm_protocal_c_ais));
        axg com_tencent_mm_protocal_c_axg = com_tencent_mm_protocal_c_ais.mFA;
        if (!(uVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_axg == null)) {
            v.d("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + com_tencent_mm_protocal_c_axg.cHn + " " + com_tencent_mm_protocal_c_ais.moM);
            v.d("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + com_tencent_mm_protocal_c_axg.cHo);
            v.d("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.cHp);
            v.d("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + com_tencent_mm_protocal_c_axg.mUx);
            if (com.tencent.mm.pluginsdk.j.ak.lyf != null) {
                com.tencent.mm.pluginsdk.j.ak.lyf.a(uVar.field_username, com_tencent_mm_protocal_c_axg);
            }
        }
        if (com.tencent.mm.i.a.ei(uVar.field_type)) {
            boolean A = l.KD().A(str, 1);
            if (A) {
                v.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = " + str);
            } else {
                A = l.KD().A(str2, 1);
                v.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = " + str2);
            }
            v.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = " + A);
        }
        if (com.tencent.mm.i.a.ei(uVar.field_type) && (uVar.bbT == 10 || uVar.bbT == 13)) {
            Context context = com.tencent.mm.sdk.platformtools.aa.getContext();
            str2 = uVar.field_username;
            String str3 = uVar.field_encryptUsername;
            if (d.ba(context)) {
                com.tencent.mm.sdk.i.e.c(new com.tencent.mm.modelsimple.b(context, d.bc(context), str2, str3), "MMAccountManager_updateSpecifiedContact").start();
            } else {
                d.z(context, null);
                v.d("MicroMsg.MMAccountManager", "no account added or not current account");
            }
            b iA = ah.FL().iA(uVar.field_encryptUsername);
            if (!(iA == null || be.kS(iA.cHb))) {
                iA.username = uVar.field_username;
                v.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr " + ah.FL().a(iA.cHb, iA));
            }
        }
        a(com_tencent_mm_protocal_c_ais, str, uVar, z);
        return true;
    }

    private static boolean a(u uVar, ba baVar) {
        boolean z = false;
        if (!be.kS(baVar.field_conDescription)) {
            uVar.cm(baVar.field_conDescription);
        }
        if (!m.eB(uVar.field_username) && com.tencent.mm.i.a.ei(uVar.field_type)) {
            ak.yW();
            com.tencent.mm.model.c.wI().Nx(baVar.field_encryptUsername);
            z = true;
            if (!be.kS(baVar.field_conDescription)) {
                com.tencent.mm.ba.a com_tencent_mm_protocal_c_ait = new ait();
                com_tencent_mm_protocal_c_ait.mJq = uVar.field_username;
                com_tencent_mm_protocal_c_ait.gkC = baVar.field_conDescription;
                ak.yW();
                com.tencent.mm.model.c.wG().b(new j.a(54, com_tencent_mm_protocal_c_ait));
            }
        }
        return z;
    }

    private static void x(u uVar) {
        if (uVar != null && e.hA(uVar.field_username) && !e.hC(uVar.field_username)) {
            ak.yW();
            ab Mh = com.tencent.mm.model.c.wK().Mh(uVar.field_username);
            BizInfo ho = com.tencent.mm.modelbiz.u.Dy().ho(uVar.field_username);
            if (e.hE(ho.field_username) && Mh == null) {
                Mh = new ab(ho.field_username);
                v.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", ho.CF(), ho.field_username);
                Mh.cw(be.ma(ho.CF()));
                Mh.bvG();
                ak.yW();
                com.tencent.mm.model.c.wK().d(Mh);
            }
        }
    }

    private static void ah(String str, int i) {
        f[] fVarArr;
        com.tencent.mm.ar.h[] hVarArr;
        com.tencent.mm.pluginsdk.ui.preference.b[] a;
        com.tencent.mm.ar.j[] jVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            v.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
            com.tencent.mm.ar.j[] kP = l.KF().kP(str);
            fVarArr = null;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.sdk.platformtools.aa.getContext(), kP);
            jVarArr = kP;
        } else if (i == 18) {
            v.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
            bu[] kK = l.KE().kK(str);
            fVarArr = null;
            bu[] buVarArr = kK;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.sdk.platformtools.aa.getContext(), kK);
            jVarArr = null;
        } else {
            f[] kF = l.KC().kF(str);
            fVarArr = kF;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.sdk.platformtools.aa.getContext(), kF);
            jVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                com.tencent.mm.pluginsdk.ui.preference.b bVar = a[i3];
                at atVar = new at();
                atVar.setContent(bVar.cqK);
                int fp = m.fp(bVar.username);
                if (fVarArr != null) {
                    i4 = i2 + 1;
                    atVar.z(fVarArr[i2].field_createTime);
                } else if (hVarArr != null) {
                    i4 = i2 + 1;
                    atVar.z(hVarArr[i2].field_createtime * 1000);
                } else if (jVarArr != null) {
                    i4 = i2 + 1;
                    atVar.z(jVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                atVar.cH(bVar.username);
                atVar.setType(fp);
                if (bVar.cFQ) {
                    atVar.dh(2);
                    atVar.di(1);
                } else {
                    atVar.dh(6);
                    atVar.di(0);
                }
                ak.yW();
                long R = com.tencent.mm.model.c.wJ().R(atVar);
                Assert.assertTrue(R != -1);
                v.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = " + R);
                i3++;
                i2 = i4;
            }
            at atVar2 = new at();
            if (fVarArr != null) {
                atVar2.z(fVarArr[fVarArr.length - 1].field_createTime + 1);
            } else if (hVarArr != null) {
                atVar2.z((hVarArr[hVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (jVarArr != null) {
                atVar2.z((jVarArr[jVarArr.length - 1].field_createtime * 1000) + 1);
            }
            atVar2.cH(str);
            atVar2.setContent(com.tencent.mm.sdk.platformtools.aa.getContext().getString(2131235699));
            atVar2.setType(10000);
            atVar2.dh(6);
            atVar2.di(0);
            ak.yW();
            com.tencent.mm.model.c.wJ().R(atVar2);
        }
    }
}
