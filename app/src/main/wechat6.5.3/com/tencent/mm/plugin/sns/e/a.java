package com.tencent.mm.plugin.sns.e;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static Comparator<avr> jiD = new Comparator<avr>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((avr) obj).hNS - ((avr) obj2).hNS;
        }
    };

    public static void a(avi com_tencent_mm_protocal_c_avi) {
        if (com_tencent_mm_protocal_c_avi == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (com_tencent_mm_protocal_c_avi.mSF == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            c c = c(com_tencent_mm_protocal_c_avi);
            if (c == null) {
                return;
            }
            if (ad.aSF().cW(com_tencent_mm_protocal_c_avi.mSF.mjq)) {
                v.i("MicroMsg.AdSnsInfoStorageLogic", "ind this adobj and update" + com_tencent_mm_protocal_c_avi.mSF.mjq);
                ad.aSF().b(com_tencent_mm_protocal_c_avi.mSF.mjq, c);
                return;
            }
            v.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + com_tencent_mm_protocal_c_avi.mSF.mjq);
        }
    }

    public static void a(awp com_tencent_mm_protocal_c_awp) {
        b(b(com_tencent_mm_protocal_c_awp));
    }

    public static void b(avi com_tencent_mm_protocal_c_avi) {
        if (com_tencent_mm_protocal_c_avi == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (com_tencent_mm_protocal_c_avi.mSF == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            ad.aSF().a(com_tencent_mm_protocal_c_avi.mSF.mjq, c(com_tencent_mm_protocal_c_avi));
        }
    }

    private static c c(avi com_tencent_mm_protocal_c_avi) {
        c cVar;
        c cV = ad.aSF().cV(com_tencent_mm_protocal_c_avi.mSF.mjq);
        awa com_tencent_mm_protocal_c_awa = com_tencent_mm_protocal_c_avi.mSF;
        String str = null;
        if (cV == null) {
            cVar = new c();
        } else {
            str = cV.aUp().jGu;
            cVar = cV;
        }
        String b = m.b(com_tencent_mm_protocal_c_awa.mTg);
        if (be.kS(b)) {
            return null;
        }
        if (!cVar.Bo(b)) {
            return null;
        }
        if (!be.kS(str)) {
            azr aUp = cVar.aUp();
            aUp.jGu = str;
            cVar.b(aUp);
        }
        com_tencent_mm_protocal_c_awa.mTy = ah.b(com_tencent_mm_protocal_c_awa.mTy, cVar.field_attrBuf);
        v.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_awa.mjq)});
        com_tencent_mm_protocal_c_awa.mTg.ba(new byte[0]);
        cVar.field_userName = com_tencent_mm_protocal_c_awa.mdw;
        if (com_tencent_mm_protocal_c_avi.mSG != null) {
            cVar.field_recxml = m.a(com_tencent_mm_protocal_c_avi.mSG);
            str = Ad(cVar.field_recxml);
            if (!(be.kS(str) || str.equals(cVar.field_adxml))) {
                v.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml " + str);
                cVar.field_adxml = str;
            }
        }
        cVar.field_likeFlag = com_tencent_mm_protocal_c_awa.mTh;
        long j = com_tencent_mm_protocal_c_awa.mjq;
        cVar.field_snsId = j;
        if (j != 0) {
            cVar.field_stringSeq = i.cE(j);
            cVar.field_stringSeq = i.zT(cVar.field_stringSeq);
            v.d("MicroMsg.AdSnsInfo", j + " stringSeq " + cVar.field_stringSeq);
        }
        cVar.qA(2);
        cVar.qA(32);
        try {
            awa com_tencent_mm_protocal_c_awa2;
            List<avr> linkedList;
            Iterator it;
            avr com_tencent_mm_protocal_c_avr;
            Iterator it2;
            avr com_tencent_mm_protocal_c_avr2;
            Iterator it3;
            if (cVar.field_attrBuf == null) {
                com_tencent_mm_protocal_c_awa2 = new awa();
            } else {
                com_tencent_mm_protocal_c_awa2 = (awa) new awa().az(cVar.field_attrBuf);
            }
            if (!(com_tencent_mm_protocal_c_awa2 == null || com_tencent_mm_protocal_c_awa2.mTn == null)) {
                linkedList = new LinkedList();
                it = com_tencent_mm_protocal_c_awa.mTn.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_avr = (avr) it.next();
                    if (com_tencent_mm_protocal_c_avr.mJm > 0) {
                        linkedList.add(com_tencent_mm_protocal_c_avr);
                        it2 = com_tencent_mm_protocal_c_awa2.mTn.iterator();
                        while (it2.hasNext()) {
                            com_tencent_mm_protocal_c_avr2 = (avr) it2.next();
                            if (com_tencent_mm_protocal_c_avr2.mSQ == com_tencent_mm_protocal_c_avr.mSQ) {
                                com_tencent_mm_protocal_c_awa2.mTn.remove(com_tencent_mm_protocal_c_avr2);
                                break;
                            }
                        }
                    }
                }
                for (avr com_tencent_mm_protocal_c_avr3 : linkedList) {
                    com_tencent_mm_protocal_c_awa.mTn.remove(com_tencent_mm_protocal_c_avr3);
                }
                linkedList.clear();
                it3 = com_tencent_mm_protocal_c_awa2.mTn.iterator();
                while (it3.hasNext()) {
                    com_tencent_mm_protocal_c_avr3 = (avr) it3.next();
                    if (!(b(com_tencent_mm_protocal_c_avr3, com_tencent_mm_protocal_c_awa.mTn) || com_tencent_mm_protocal_c_avr3.mSQ == 0)) {
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(com_tencent_mm_protocal_c_avr3.mdw);
                        if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type) || LX.tK()) {
                            v.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + com_tencent_mm_protocal_c_avr3.mdw);
                        } else {
                            com_tencent_mm_protocal_c_awa.mTn.add(com_tencent_mm_protocal_c_avr3);
                            com_tencent_mm_protocal_c_awa.mTm = com_tencent_mm_protocal_c_awa.mTn.size();
                        }
                    }
                }
            }
            Collections.sort(com_tencent_mm_protocal_c_awa.mTn, jiD);
            if (com_tencent_mm_protocal_c_awa.mTk != null) {
                linkedList = new LinkedList();
                it = com_tencent_mm_protocal_c_awa.mTk.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_avr3 = (avr) it.next();
                    if (com_tencent_mm_protocal_c_avr3.mJm > 0) {
                        linkedList.add(com_tencent_mm_protocal_c_avr3);
                        it2 = com_tencent_mm_protocal_c_awa2.mTk.iterator();
                        while (it2.hasNext()) {
                            com_tencent_mm_protocal_c_avr2 = (avr) it2.next();
                            if (!be.kS(com_tencent_mm_protocal_c_avr2.mdw)) {
                                if (com_tencent_mm_protocal_c_avr2.mdw.equals(com_tencent_mm_protocal_c_avr3.mdw)) {
                                }
                            }
                            com_tencent_mm_protocal_c_awa2.mTk.remove(com_tencent_mm_protocal_c_avr2);
                        }
                    }
                }
                for (avr com_tencent_mm_protocal_c_avr32 : linkedList) {
                    com_tencent_mm_protocal_c_awa.mTk.remove(com_tencent_mm_protocal_c_avr32);
                }
                linkedList.clear();
                if (!(com_tencent_mm_protocal_c_awa2 == null || com_tencent_mm_protocal_c_awa2.mTk == null)) {
                    it3 = com_tencent_mm_protocal_c_awa2.mTk.iterator();
                    while (it3.hasNext()) {
                        com_tencent_mm_protocal_c_avr32 = (avr) it3.next();
                        if (!a(com_tencent_mm_protocal_c_avr32, com_tencent_mm_protocal_c_awa.mTk)) {
                            ak.yW();
                            u LX2 = com.tencent.mm.model.c.wH().LX(com_tencent_mm_protocal_c_avr32.mdw);
                            if (LX2 == null || !com.tencent.mm.i.a.ei(LX2.field_type) || LX2.tK()) {
                                v.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + com_tencent_mm_protocal_c_avr32.mdw);
                            } else {
                                com_tencent_mm_protocal_c_awa.mTk.add(com_tencent_mm_protocal_c_avr32);
                                com_tencent_mm_protocal_c_awa.mTj = com_tencent_mm_protocal_c_awa.mTk.size();
                            }
                        }
                    }
                }
                Collections.sort(com_tencent_mm_protocal_c_awa.mTk, jiD);
            }
        } catch (Throwable e) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "error " + e.getMessage());
            v.a("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        try {
            cVar.aC(com_tencent_mm_protocal_c_awa.toByteArray());
        } catch (Throwable e2) {
            v.a("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
        }
        azr aUp2 = cVar.aUp();
        aUp2.gln = com_tencent_mm_protocal_c_awa.mdw;
        cVar.field_pravited = aUp2.mHR;
        v.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + com_tencent_mm_protocal_c_awa.mTr + " " + com_tencent_mm_protocal_c_awa.mTn.size() + " " + com_tencent_mm_protocal_c_awa.mTk.size());
        cVar.b(aUp2);
        cVar.field_type = aUp2.mWq.mol;
        return cVar;
    }

    private static String Ad(String str) {
        String str2 = "<adxml";
        if (TextUtils.isEmpty(str) || str.startsWith(str2)) {
            return str;
        }
        String str3 = "</adxml>";
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(str3);
        if (lastIndexOf < 0 || lastIndexOf <= indexOf) {
            return str;
        }
        return str.substring(indexOf, str3.length() + lastIndexOf);
    }

    private static boolean a(avr com_tencent_mm_protocal_c_avr, List<avr> list) {
        for (avr com_tencent_mm_protocal_c_avr2 : list) {
            if (!be.kS(com_tencent_mm_protocal_c_avr.mdw) && com_tencent_mm_protocal_c_avr.mdw.equals(com_tencent_mm_protocal_c_avr2.mdw)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(avr com_tencent_mm_protocal_c_avr, List<avr> list) {
        for (avr com_tencent_mm_protocal_c_avr2 : list) {
            if (com_tencent_mm_protocal_c_avr.mSQ == com_tencent_mm_protocal_c_avr2.mSQ && com_tencent_mm_protocal_c_avr2.mSQ != 0) {
                return true;
            }
        }
        return false;
    }

    private static void a(bu buVar, int i, int i2, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (buVar == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (buVar.mcn == null || buVar.mcn.mSF == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            awa com_tencent_mm_protocal_c_awa = buVar.mcn.mSF;
            c c = c(buVar.mcn);
            azr aUp = c.aUp();
            axz com_tencent_mm_protocal_c_axz = new axz();
            com_tencent_mm_protocal_c_axz.mVt = new aya();
            com_tencent_mm_protocal_c_axz.mVt.mVx = aVar.jpt;
            com_tencent_mm_protocal_c_axz.mVt.mVw = aUp.gID;
            com_tencent_mm_protocal_c_axz.mVt.bbT = c.getSource();
            if (aUp.mWq.mol == 1) {
                com_tencent_mm_protocal_c_axz.mVt.cZA = 1;
            } else if (aUp.mWq.mol == 15) {
                com_tencent_mm_protocal_c_axz.mVt.cZA = 2;
            } else {
                com_tencent_mm_protocal_c_axz.mVt.cZA = 0;
            }
            aya com_tencent_mm_protocal_c_aya = com_tencent_mm_protocal_c_axz.mVt;
            b aUn = c.aUn();
            com_tencent_mm_protocal_c_aya.mVy = aUn == null ? 0 : aUn.juK;
            try {
                v.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[]{aUp.gID, Base64.encodeToString(com_tencent_mm_protocal_c_axz.toByteArray(), 0).replace("\n", ""), com_tencent_mm_protocal_c_axz.mVt.mVw, com_tencent_mm_protocal_c_axz.mVt.mVx});
                aUp.jGu = r0;
                c.b(aUp);
            } catch (Throwable e) {
                v.a("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            if (c != null) {
                c.field_createTime = i;
                c.field_exposureTime = 0;
                c.field_createAdTime = i2;
                c.field_recxml = m.a(buVar.mcn.mSG);
                c.field_adinfo = m.a(buVar.mco);
                c.field_adxml = Ad(c.field_recxml);
                ad.aSF().a(com_tencent_mm_protocal_c_awa.mjq, c);
            }
        }
    }

    private static avi b(awp com_tencent_mm_protocal_c_awp) {
        if (com_tencent_mm_protocal_c_awp == null) {
            return null;
        }
        avi com_tencent_mm_protocal_c_avi = new avi();
        com_tencent_mm_protocal_c_avi.mSG = com_tencent_mm_protocal_c_awp.mTX;
        if (com_tencent_mm_protocal_c_avi.mSG == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
        }
        com_tencent_mm_protocal_c_avi.mSF = com_tencent_mm_protocal_c_awp.mSF;
        return com_tencent_mm_protocal_c_avi;
    }

    private static bu a(apu com_tencent_mm_protocal_c_apu) {
        if (com_tencent_mm_protocal_c_apu == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.mco = com_tencent_mm_protocal_c_apu.mPk;
        if (buVar.mco == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
            return null;
        }
        buVar.mcn = b(com_tencent_mm_protocal_c_apu.mPj);
        return buVar;
    }

    public static void b(apu com_tencent_mm_protocal_c_apu) {
        bu a = a(com_tencent_mm_protocal_c_apu);
        if (a != null) {
            com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(m.a(a.mco));
            int i = aVar.jtX;
            int i2 = i <= 0 ? 1 : i + 1;
            int BE = ad.aSE().BE("");
            v.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(BE)});
            l aSE = ad.aSE();
            String str = "";
            String str2 = (l.jBX + " from SnsInfo where ") + l.aUV();
            if (l.By(str)) {
                str2 = str2 + " AND " + aSE.Bz(str);
            }
            String str3 = ((((str2 + " AND createTime >= " + BE) + " UNION ") + l.jBX + " from AdSnsInfo where createTime" + " > " + BE) + l.jBY) + " limit " + i2;
            v.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str3 + " limtiSeq: " + str);
            Cursor rawQuery = aSE.cie.rawQuery(str3, null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                v.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
                i2 = (int) be.Nh();
            } else {
                v.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[]{Integer.valueOf(rawQuery.getCount())});
                k kVar = new k();
                if (i < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                if (rawQuery.moveToPosition(i2)) {
                    kVar.b(rawQuery);
                } else {
                    rawQuery.moveToLast();
                    kVar.b(rawQuery);
                }
                i2 = kVar.field_createTime + 1;
            }
            rawQuery.close();
            v.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a.mcn.mSF.mjq + " ,createTime " + i2);
            a(a, i2, (int) be.Nh(), aVar);
            a(a);
        }
    }

    public static void c(LinkedList<apu> linkedList, LinkedList<awa> linkedList2) {
        if (linkedList != null) {
            LinkedList T = T(linkedList);
            v.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + T.size() + " recObj to AdvertiseObj");
            a(T, linkedList2, true);
        }
    }

    public static void d(LinkedList<bu> linkedList, LinkedList<awa> linkedList2) {
        a(linkedList, linkedList2, false);
    }

    private static LinkedList<bu> T(LinkedList<apu> linkedList) {
        LinkedList<bu> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bu a = a((apu) it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    private static void a(LinkedList<bu> linkedList, LinkedList<awa> linkedList2, boolean z) {
        if (linkedList != null && linkedList2 != null && linkedList2.size() != 0) {
            int a = a((awa) linkedList2.get(linkedList2.size() - 1));
            for (int i = 0; i < linkedList.size(); i++) {
                bu buVar = (bu) linkedList.get(i);
                if (buVar == null) {
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (buVar.mcn == null) {
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (buVar.mcn.mSF == null) {
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else if (z && ad.aSF().cW(buVar.mcn.mSF.mjq)) {
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "snsId %d already exist, ignore ", new Object[]{Long.valueOf(buVar.mcn.mSF.mjq)});
                } else {
                    String a2 = m.a(buVar.mco);
                    String a3 = m.a(buVar.mcn.mSG);
                    String b = m.b(buVar.mcn.mSF.mTg);
                    com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(a2);
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "skXml " + a2);
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "adXml " + a3);
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b + "\r\n");
                    int i2 = a + 1;
                    if (aVar.jtX >= linkedList2.size() || aVar.jtX < 0) {
                        v.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aVar.jtX);
                    } else {
                        i2 = a((awa) linkedList2.get(aVar.jtX)) + 1;
                        v.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i2 + " pos " + aVar.jtX);
                    }
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "gettime " + currentTimeMillis);
                    a(buVar, i2, currentTimeMillis, aVar);
                }
            }
        }
    }

    public static void U(LinkedList<apu> linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            LinkedList T = T(linkedList);
            v.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + T.size() + " recObj to AdvertiseObj");
            V(T);
        }
    }

    public static void V(LinkedList<bu> linkedList) {
        if (linkedList != null) {
            for (int i = 0; i < linkedList.size(); i++) {
                a((bu) linkedList.get(i));
            }
        }
    }

    private static void a(bu buVar) {
        String a = m.a(buVar.mcn.mSG);
        if (!be.kS(a) && new b(a).jun) {
            f.aUk().c("adId", a, "adxml", 0);
        }
    }

    public static void W(LinkedList<awa> linkedList) {
        if (linkedList != null) {
            l aSE = ad.aSE();
            for (int i = 0; i < linkedList.size(); i++) {
                awa com_tencent_mm_protocal_c_awa = (awa) linkedList.get(i);
                if (com_tencent_mm_protocal_c_awa != null) {
                    k dd = aSE.dd(com_tencent_mm_protocal_c_awa.mjq);
                    if (dd != null) {
                        azr aUp = dd.aUp();
                        if (!(aUp == null || be.kS(aUp.jYp))) {
                            f.aUk().c("adId", aUp.jYp, "adxml", 0);
                        }
                    }
                }
            }
        }
    }

    public static void Ae(String str) {
        if (!be.kS(str)) {
            f.aUk().c("adId", str, "adxml", 1);
        }
    }

    private static int a(awa com_tencent_mm_protocal_c_awa) {
        k dd = ad.aSE().dd(com_tencent_mm_protocal_c_awa.mjq);
        return dd == null ? com_tencent_mm_protocal_c_awa.hNS : dd.field_createTime;
    }

    public static boolean a(long j, avn com_tencent_mm_protocal_c_avn, int i, int i2, int i3, boolean z) {
        if (com_tencent_mm_protocal_c_avn != null) {
            avm com_tencent_mm_protocal_c_avm = com_tencent_mm_protocal_c_avn.mST;
            if (!(com_tencent_mm_protocal_c_avm.efm == 7 || com_tencent_mm_protocal_c_avm.efm == 8)) {
                return false;
            }
        }
        String xF = com.tencent.mm.model.k.xF();
        if (com_tencent_mm_protocal_c_avn != null && com_tencent_mm_protocal_c_avn.mSU != null && com_tencent_mm_protocal_c_avn.mSU.mOk != null && com_tencent_mm_protocal_c_avn.mSU.mOk.equals(xF)) {
            return true;
        }
        c cV = ad.aSF().cV(j);
        try {
            k Bp;
            com.tencent.mm.plugin.sns.storage.a aUo;
            avr com_tencent_mm_protocal_c_avr;
            int i4;
            awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(cV.field_attrBuf);
            com_tencent_mm_protocal_c_awa.mjq = j;
            int i5 = cV.field_firstControlTime;
            avm com_tencent_mm_protocal_c_avm2 = com_tencent_mm_protocal_c_avn.mST;
            g gVar;
            Object[] objArr;
            if (com_tencent_mm_protocal_c_avm2.efm == 7) {
                if (i2 > 0 && i5 + i2 < com_tencent_mm_protocal_c_avm2.hNS) {
                    if (z) {
                        Bp = ad.aSE().Bp(cV.aUq());
                        if (Bp != null) {
                            aUo = Bp.aUo();
                            if (aUo != null) {
                                gVar = g.iuh;
                                objArr = new Object[7];
                                objArr[0] = Long.valueOf(s.BK(cV.aUq()));
                                objArr[1] = aUo.jbF;
                                objArr[2] = Integer.valueOf(2);
                                objArr[3] = Integer.valueOf(1);
                                objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_awa.mTk != null ? com_tencent_mm_protocal_c_awa.mTk.size() : 0);
                                objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_awa.mTn != null ? com_tencent_mm_protocal_c_awa.mTn.size() : 0);
                                objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                gVar.h(13182, objArr);
                            } else {
                                v.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            v.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    v.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionLikeTimeLimit: " + i2 + " curAction.createTime: " + com_tencent_mm_protocal_c_avm2.hNS + "is over the time limit!");
                    return false;
                }
            } else if (com_tencent_mm_protocal_c_avm2.efm == 8 && i3 > 0 && i5 + i3 < com_tencent_mm_protocal_c_avm2.hNS) {
                if (z) {
                    Bp = ad.aSE().Bp(cV.aUq());
                    if (Bp != null) {
                        aUo = Bp.aUo();
                        if (aUo != null) {
                            gVar = g.iuh;
                            objArr = new Object[7];
                            objArr[0] = Long.valueOf(s.BK(cV.aUq()));
                            objArr[1] = aUo.jbF;
                            objArr[2] = Integer.valueOf(2);
                            objArr[3] = Integer.valueOf(2);
                            objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_awa.mTk != null ? com_tencent_mm_protocal_c_awa.mTk.size() : 0);
                            objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_awa.mTn != null ? com_tencent_mm_protocal_c_awa.mTn.size() : 0);
                            objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            gVar.h(13182, objArr);
                        } else {
                            v.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        v.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                v.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionCommentTimeLimit: " + i3 + " curAction.createTime: " + com_tencent_mm_protocal_c_avm2.hNS + "is over the time limit!");
                return false;
            }
            int i6 = 0;
            Iterator it = com_tencent_mm_protocal_c_awa.mTk.iterator();
            while (it.hasNext()) {
                com_tencent_mm_protocal_c_avr = (avr) it.next();
                if (com_tencent_mm_protocal_c_avr.hNS <= i5 || !(com_tencent_mm_protocal_c_avr == null || com_tencent_mm_protocal_c_avr.mdw == null || !com_tencent_mm_protocal_c_avr.mdw.equals(xF))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            int i7 = i6 + 0;
            i6 = 0;
            Iterator it2 = com_tencent_mm_protocal_c_awa.mTn.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_avr = (avr) it2.next();
                if (com_tencent_mm_protocal_c_avr.hNS <= i5 || !(com_tencent_mm_protocal_c_avr == null || com_tencent_mm_protocal_c_avr.mdw == null || !com_tencent_mm_protocal_c_avr.mdw.equals(xF))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            i4 = i7 + i6;
            v.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i4 + " firstCreateTime " + i5 + " actionLimit: " + i + " actionLikeTimeLimit: " + i2 + " actionCommentTimeLimit: " + i3);
            if (i4 >= i) {
                if (z) {
                    Bp = ad.aSE().Bp(cV.aUq());
                    if (Bp != null) {
                        aUo = Bp.aUo();
                        if (aUo != null) {
                            g gVar2 = g.iuh;
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Long.valueOf(s.BK(cV.aUq()));
                            objArr2[1] = aUo.jbF;
                            objArr2[2] = Integer.valueOf(1);
                            objArr2[3] = Integer.valueOf(2);
                            objArr2[4] = Integer.valueOf(com_tencent_mm_protocal_c_awa.mTk != null ? com_tencent_mm_protocal_c_awa.mTk.size() : 0);
                            objArr2[5] = Integer.valueOf(com_tencent_mm_protocal_c_awa.mTn != null ? com_tencent_mm_protocal_c_awa.mTn.size() : 0);
                            objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            gVar2.h(13182, objArr2);
                        } else {
                            v.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        v.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                return false;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    public static boolean a(long j, avn com_tencent_mm_protocal_c_avn) {
        avm com_tencent_mm_protocal_c_avm = com_tencent_mm_protocal_c_avn.mST;
        if (com_tencent_mm_protocal_c_avm.efm != 7 && com_tencent_mm_protocal_c_avm.efm != 8) {
            return false;
        }
        c cV = ad.aSF().cV(j);
        if (cV == null) {
            v.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null " + j);
            return false;
        }
        try {
            awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(cV.field_attrBuf);
            com_tencent_mm_protocal_c_awa.mjq = j;
            Iterator it;
            avr com_tencent_mm_protocal_c_avr;
            if (com_tencent_mm_protocal_c_avm.efm == 7) {
                it = com_tencent_mm_protocal_c_awa.mTk.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_avr = (avr) it.next();
                    if (com_tencent_mm_protocal_c_avr.hNS == com_tencent_mm_protocal_c_avm.hNS && com_tencent_mm_protocal_c_avr.mdw.equals(com_tencent_mm_protocal_c_avm.mOk)) {
                        v.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + com_tencent_mm_protocal_c_avr.hNS + " ");
                        return false;
                    }
                }
                com_tencent_mm_protocal_c_awa.mTk.add(aa.a(com_tencent_mm_protocal_c_avn));
            } else if (com_tencent_mm_protocal_c_avm.efm == 8) {
                it = com_tencent_mm_protocal_c_awa.mTn.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_avr = (avr) it.next();
                    if (com_tencent_mm_protocal_c_avr.hNS == com_tencent_mm_protocal_c_avm.hNS && com_tencent_mm_protocal_c_avr.mdw.equals(com_tencent_mm_protocal_c_avm.mOk)) {
                        v.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + com_tencent_mm_protocal_c_avr.hNS + " ");
                        return false;
                    }
                }
                com_tencent_mm_protocal_c_awa.mTn.add(aa.a(com_tencent_mm_protocal_c_avn));
            }
            cV.aC(com_tencent_mm_protocal_c_awa.toByteArray());
            ad.aSF().a(com_tencent_mm_protocal_c_awa.mjq, cV);
        } catch (Throwable e) {
            v.e("MicroMsg.AdSnsInfoStorageLogic", "e " + e.getMessage());
            v.a("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }
}
