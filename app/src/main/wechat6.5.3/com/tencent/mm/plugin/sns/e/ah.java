package com.tencent.mm.plugin.sns.e;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ah {
    private static Map<String, awa> jmV = new ConcurrentHashMap();

    public static List<k> a(String str, boolean z, String str2, boolean z2) {
        Cursor a;
        if (z2) {
            a = ad.aSE().a(false, str, 10, z, str2);
        } else {
            a = ad.aSE().a(false, str, 0, z, str2);
        }
        List<k> arrayList = new ArrayList();
        if (a.getCount() == 0) {
            a.close();
            return arrayList;
        }
        if (a.moveToFirst()) {
            do {
                k kVar = new k();
                kVar.b(a);
                arrayList.add(kVar);
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public static k At(String str) {
        Cursor a = ad.aSE().a(true, str, 1, false, "");
        if (a.getCount() == 0) {
            a.close();
            return null;
        }
        a.moveToFirst();
        k kVar = new k();
        kVar.b(a);
        if (a.isClosed()) {
            return kVar;
        }
        a.close();
        return kVar;
    }

    public static void aSU() {
        if (jmV != null) {
            jmV.clear();
        }
    }

    public static awa m(k kVar) {
        try {
            awa c = ad.aSD().c((awa) new awa().az(kVar.field_attrBuf));
            jmV.clear();
            return c;
        } catch (Throwable e) {
            v.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            v.a("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new awa();
        }
    }

    public static awa n(k kVar) {
        try {
            awa com_tencent_mm_protocal_c_awa;
            if (kVar.jBH == null) {
                kVar.jBH = g.m(kVar.field_content) + g.m(kVar.field_attrBuf);
            }
            if (jmV.containsKey(kVar.jBH)) {
                com_tencent_mm_protocal_c_awa = (awa) jmV.get(kVar.jBH);
                if (com_tencent_mm_protocal_c_awa != null) {
                    ad.aSD().c(com_tencent_mm_protocal_c_awa);
                    return com_tencent_mm_protocal_c_awa;
                }
            }
            com_tencent_mm_protocal_c_awa = (awa) new awa().az(kVar.field_attrBuf);
            jmV.put(kVar.jBH, com_tencent_mm_protocal_c_awa);
            ad.aSD().c(com_tencent_mm_protocal_c_awa);
            return com_tencent_mm_protocal_c_awa;
        } catch (Throwable e) {
            v.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            v.a("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new awa();
        }
    }

    public static void b(long j, avn com_tencent_mm_protocal_c_avn) {
        avm com_tencent_mm_protocal_c_avm = com_tencent_mm_protocal_c_avn.mST;
        if (com_tencent_mm_protocal_c_avm.efm == 9) {
            k dd = ad.aSE().dd(j);
            if (dd != null) {
                try {
                    awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(dd.field_attrBuf);
                    com_tencent_mm_protocal_c_awa.mjq = j;
                    Iterator it = com_tencent_mm_protocal_c_awa.mTn.iterator();
                    while (it.hasNext()) {
                        avr com_tencent_mm_protocal_c_avr = (avr) it.next();
                        if (com_tencent_mm_protocal_c_avr.mSN == com_tencent_mm_protocal_c_avm.mSN && !be.kS(com_tencent_mm_protocal_c_avr.mdw) && com_tencent_mm_protocal_c_avr.mdw.equals(com_tencent_mm_protocal_c_avm.mOk)) {
                            com_tencent_mm_protocal_c_awa.mTn.remove(com_tencent_mm_protocal_c_avr);
                            break;
                        }
                    }
                    dd.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                    ad.aSE().a(com_tencent_mm_protocal_c_awa.mjq, dd);
                } catch (Throwable e) {
                    v.a("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void c(long j, avn com_tencent_mm_protocal_c_avn) {
        avm com_tencent_mm_protocal_c_avm = com_tencent_mm_protocal_c_avn.mST;
        if (com_tencent_mm_protocal_c_avm.efm == 13) {
            k dd = ad.aSE().dd(j);
            if (dd != null) {
                try {
                    awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(dd.field_attrBuf);
                    com_tencent_mm_protocal_c_awa.mjq = j;
                    if (com_tencent_mm_protocal_c_awa.mTz == null) {
                        com_tencent_mm_protocal_c_awa.mTz = new awq();
                    }
                    if (com_tencent_mm_protocal_c_avm.efm == 13) {
                        Iterator it = com_tencent_mm_protocal_c_awa.mTz.mTZ.iterator();
                        while (it.hasNext()) {
                            if (((avx) it.next()).mdw.equals(com_tencent_mm_protocal_c_avm.mOk)) {
                                return;
                            }
                        }
                        avx com_tencent_mm_protocal_c_avx = new avx();
                        com_tencent_mm_protocal_c_avx.mSR = com_tencent_mm_protocal_c_avm.mSR;
                        com_tencent_mm_protocal_c_avx.hNS = com_tencent_mm_protocal_c_avm.hNS;
                        com_tencent_mm_protocal_c_avx.mdw = com_tencent_mm_protocal_c_avm.mOk;
                        com_tencent_mm_protocal_c_awa.mTz.mTZ.add(com_tencent_mm_protocal_c_avx);
                        com_tencent_mm_protocal_c_awa.mTz.mTY = com_tencent_mm_protocal_c_awa.mTz.mTZ.size();
                    }
                    dd.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                    ad.aSE().a(com_tencent_mm_protocal_c_awa.mjq, dd);
                } catch (Throwable e) {
                    v.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e.getMessage());
                    v.a("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static boolean a(long j, avn com_tencent_mm_protocal_c_avn) {
        avm com_tencent_mm_protocal_c_avm = com_tencent_mm_protocal_c_avn.mST;
        if (com_tencent_mm_protocal_c_avm.efm != 1 && com_tencent_mm_protocal_c_avm.efm != 2) {
            return true;
        }
        k dd = ad.aSE().dd(j);
        if (dd == null) {
            return true;
        }
        if (dd.field_type != 21 || o.aRi()) {
            try {
                awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(dd.field_attrBuf);
                com_tencent_mm_protocal_c_awa.mjq = j;
                Iterator it;
                avr com_tencent_mm_protocal_c_avr;
                if (com_tencent_mm_protocal_c_avm.efm == 1) {
                    it = com_tencent_mm_protocal_c_awa.mTk.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_avr = (avr) it.next();
                        if (com_tencent_mm_protocal_c_avr.hNS == com_tencent_mm_protocal_c_avm.hNS && com_tencent_mm_protocal_c_avr.mdw.equals(com_tencent_mm_protocal_c_avm.mOk)) {
                            return true;
                        }
                    }
                    com_tencent_mm_protocal_c_awa.mTk.add(aa.a(com_tencent_mm_protocal_c_avn));
                } else if (com_tencent_mm_protocal_c_avm.efm == 2) {
                    it = com_tencent_mm_protocal_c_awa.mTn.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_avr = (avr) it.next();
                        if (com_tencent_mm_protocal_c_avr.hNS == com_tencent_mm_protocal_c_avm.hNS && com_tencent_mm_protocal_c_avr.mdw.equals(com_tencent_mm_protocal_c_avm.mOk)) {
                            return true;
                        }
                    }
                    com_tencent_mm_protocal_c_awa.mTn.add(aa.a(com_tencent_mm_protocal_c_avn));
                }
                dd.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                ad.aSE().a(com_tencent_mm_protocal_c_awa.mjq, dd);
            } catch (Throwable e) {
                v.a("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            }
            return true;
        }
        v.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
        return false;
    }

    public static long d(awa com_tencent_mm_protocal_c_awa) {
        String str = "";
        k dd = ad.aSE().dd(com_tencent_mm_protocal_c_awa.mjq);
        if (dd == null) {
            dd = new k();
        }
        return a(dd, com_tencent_mm_protocal_c_awa, str, 0);
    }

    private static long a(k kVar, awa com_tencent_mm_protocal_c_awa, String str, int i) {
        int i2 = 1;
        if (kVar == null) {
            kVar = new k();
        }
        if (!ad.aSD().cO(kVar.field_snsId)) {
            return com_tencent_mm_protocal_c_awa.mjq;
        }
        if (com_tencent_mm_protocal_c_awa.mTs != 0) {
            v.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + com_tencent_mm_protocal_c_awa.mjq + "  " + i.cE(com_tencent_mm_protocal_c_awa.mjq));
            if (kVar.qC(i)) {
                i2 = 0;
            } else {
                kVar.qA(i);
            }
            if (i2 != 0) {
                ad.aSE().a(com_tencent_mm_protocal_c_awa.mjq, kVar);
            }
            return com_tencent_mm_protocal_c_awa.mjq;
        }
        LinkedList linkedList = com_tencent_mm_protocal_c_awa.mTn;
        v.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_awa.mjq), Integer.valueOf(linkedList.size()), i.cE(com_tencent_mm_protocal_c_awa.mjq)});
        if (com_tencent_mm_protocal_c_awa.mTg == null || com_tencent_mm_protocal_c_awa.mTg.mQw == null) {
            v.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
            return com_tencent_mm_protocal_c_awa.mjq;
        }
        String str2 = new String(com_tencent_mm_protocal_c_awa.mTg.mQw.toByteArray());
        v.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_awa.mjq)});
        if (be.kS(str2)) {
            return com_tencent_mm_protocal_c_awa.mjq;
        }
        if (!kVar.Bo(str2)) {
            return com_tencent_mm_protocal_c_awa.mjq;
        }
        int i3;
        com_tencent_mm_protocal_c_awa.mTy = b(com_tencent_mm_protocal_c_awa.mTy, kVar.field_attrBuf);
        v.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_awa.mjq)});
        com_tencent_mm_protocal_c_awa.mTg.ba(new byte[0]);
        kVar.field_userName = com_tencent_mm_protocal_c_awa.mdw;
        kVar.fw(com_tencent_mm_protocal_c_awa.hNS);
        kVar.field_likeFlag = com_tencent_mm_protocal_c_awa.mTh;
        kVar.cY(com_tencent_mm_protocal_c_awa.mjq);
        kVar.da(com_tencent_mm_protocal_c_awa.mjq);
        kVar.qA(i);
        try {
            kVar.aC(com_tencent_mm_protocal_c_awa.toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
        }
        azr aUp = kVar.aUp();
        aUp.gln = com_tencent_mm_protocal_c_awa.mdw;
        int i4 = aUp.mHR;
        kVar.field_pravited = i4;
        v.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_awa.mjq), Integer.valueOf(com_tencent_mm_protocal_c_awa.mTr)});
        if ((com_tencent_mm_protocal_c_awa.mTr & 1) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            kVar.aUI();
        } else {
            kVar.aUJ();
        }
        if (i4 != 1 || i == 4) {
            if (i4 == 1 || (!str.equals(com_tencent_mm_protocal_c_awa.mdw) && i == 4)) {
                kVar.aUF();
            }
            kVar.b(aUp);
            kVar.field_type = aUp.mWq.mol;
            ad.aSE().a(com_tencent_mm_protocal_c_awa.mjq, kVar);
            return com_tencent_mm_protocal_c_awa.mjq;
        }
        v.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        return 0;
    }

    public static are b(are com_tencent_mm_protocal_c_are, byte[] bArr) {
        if (bArr != null) {
            try {
                are com_tencent_mm_protocal_c_are2 = ((awa) new awa().az(bArr)).mTy;
            } catch (Throwable e) {
                v.a("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                return null;
            }
        }
        com_tencent_mm_protocal_c_are2 = null;
        if (com_tencent_mm_protocal_c_are == null) {
            return com_tencent_mm_protocal_c_are2;
        }
        awi com_tencent_mm_protocal_c_awi = new awi();
        if (com_tencent_mm_protocal_c_are2 != null) {
            com_tencent_mm_protocal_c_awi = (awi) com_tencent_mm_protocal_c_awi.az(com_tencent_mm_protocal_c_are2.mQw.lVU);
        }
        awi com_tencent_mm_protocal_c_awi2 = (awi) new awi().az(com_tencent_mm_protocal_c_are.mQw.lVU);
        if (com_tencent_mm_protocal_c_awi2.mTL == null) {
            com_tencent_mm_protocal_c_awi2.mTL = com_tencent_mm_protocal_c_awi.mTL;
        }
        if (com_tencent_mm_protocal_c_awi.mTK == null) {
            com_tencent_mm_protocal_c_awi2.mTK = null;
        } else if (com_tencent_mm_protocal_c_awi2.mTK == null) {
            com_tencent_mm_protocal_c_awi2.mTK = com_tencent_mm_protocal_c_awi.mTK;
        }
        return new are().ba(com_tencent_mm_protocal_c_awi2.toByteArray());
    }

    private static String bm(List<String> list) {
        String str = "";
        for (String str2 : list) {
            if (str.length() == 0) {
                str = str2;
            } else {
                str = str + "," + str2;
            }
        }
        return str;
    }

    public static void a(String str, int i, LinkedList<awa> linkedList, String str2) {
        if (linkedList != null && !linkedList.isEmpty()) {
            String str3;
            String str4;
            Cursor rawQuery;
            l aSE = ad.aSE();
            List arrayList = new ArrayList();
            List linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                awa com_tencent_mm_protocal_c_awa = (awa) linkedList.get(i2);
                k dd = aSE.dd(com_tencent_mm_protocal_c_awa.mjq);
                if (dd == null) {
                    dd = new k();
                }
                if (a(dd, com_tencent_mm_protocal_c_awa, str, i) != 0) {
                    if (linkedList2.size() < 3 && (dd.field_type == 1 || dd.field_type == 15)) {
                        linkedList2.add(i.cE(dd.field_snsId));
                    }
                    arrayList.add(Long.valueOf(com_tencent_mm_protocal_c_awa.mjq));
                }
            }
            if ((i == 4 || i == 8) && str2.equals("")) {
                com.tencent.mm.plugin.sns.storage.i Bu = ad.aSG().Bu(str);
                List g = be.g(be.ah(Bu != null ? Bu.field_newerIds : "", "").split(","));
                v.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + bm(linkedList2));
                while (linkedList2.size() < 3 && g.size() > 0) {
                    str3 = (String) g.remove(0);
                    if (str3 != null) {
                        int i3 = 0;
                        while (i3 < linkedList2.size()) {
                            str4 = (String) linkedList2.get(i3);
                            if (str3.compareTo(str4) == 0) {
                                break;
                            } else if (str3.compareTo(str4) > 0) {
                                linkedList2.add(0, str3);
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (!linkedList2.contains(str3)) {
                            linkedList2.add(str3);
                        }
                    }
                }
                v.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + bm(linkedList2));
                ad.aSG().cM(str, bm(linkedList2));
            }
            str3 = i.zT(i.cE(((awa) linkedList.getLast()).mjq));
            v.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + str3);
            l aSE2;
            if (i == 2) {
                aSE2 = ad.aSE();
                str4 = l.aUX();
                if (str2 == null || !str2.equals("")) {
                    str4 = str4 + " AND " + aSE2.BC(str2);
                }
                if (l.By(str3)) {
                    str4 = str4 + " AND " + aSE2.Bz(str3);
                }
                v.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = aSE2.cie.rawQuery(str4, null);
            } else {
                aSE2 = ad.aSE();
                str4 = l.d(true, str, i == 4);
                if (l.By(str2)) {
                    str4 = str4 + " AND " + aSE2.BC(str2);
                }
                if (l.By(str3)) {
                    str4 = str4 + " AND " + aSE2.Bz(str3);
                }
                v.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = aSE2.cie.rawQuery(str4, null);
            }
            if (rawQuery == null) {
                return;
            }
            if (rawQuery.moveToFirst()) {
                do {
                    k kVar = new k();
                    kVar.b(rawQuery);
                    long j = kVar.field_snsId;
                    if (kVar.aUM()) {
                        v.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                    } else if (kVar.aUN()) {
                        v.d("MicroMsg.SnsInfoStorageLogic", "die one ");
                    } else if (!arrayList.contains(Long.valueOf(j))) {
                        kVar.qD(i);
                        ad.aSE().b(j, kVar);
                        v.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j + " source " + i);
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return;
            }
            rawQuery.close();
        }
    }

    public static boolean H(int i, boolean z) {
        if (!z || i <= 0) {
            return false;
        }
        return true;
    }

    public static boolean qf(int i) {
        aic com_tencent_mm_protocal_c_aic;
        Throwable th;
        int i2;
        int i3;
        com.tencent.mm.plugin.sns.storage.o de;
        aie com_tencent_mm_protocal_c_aie;
        v.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　" + i);
        k qG = ad.aSE().qG(i);
        if (qG == null) {
            return false;
        }
        qG.aUO();
        qG.fw((int) (System.currentTimeMillis() / 1000));
        aic com_tencent_mm_protocal_c_aic2 = null;
        try {
            aic com_tencent_mm_protocal_c_aic3 = (aic) new aic().az(qG.field_postBuf);
            try {
                com_tencent_mm_protocal_c_aic3.cxZ = 0;
                com_tencent_mm_protocal_c_aic3.mIq = System.currentTimeMillis();
                qG.field_postBuf = com_tencent_mm_protocal_c_aic3.toByteArray();
                com_tencent_mm_protocal_c_aic = com_tencent_mm_protocal_c_aic3;
            } catch (Throwable e) {
                Throwable th2 = e;
                com_tencent_mm_protocal_c_aic2 = com_tencent_mm_protocal_c_aic3;
                th = th2;
                v.a("MicroMsg.SnsInfoStorageLogic", th, "", new Object[0]);
                com_tencent_mm_protocal_c_aic = com_tencent_mm_protocal_c_aic2;
                if (com_tencent_mm_protocal_c_aic != null) {
                    return false;
                }
                ad.aSE().b(i, qG);
                for (i2 = 0; i2 < com_tencent_mm_protocal_c_aic.mIn.size(); i2++) {
                    i3 = ((ago) com_tencent_mm_protocal_c_aic.mIn.get(i2)).mGh;
                    de = ad.aSt().de((long) i3);
                    if (de == null) {
                        de.offset = 0;
                        try {
                            com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
                            if (com_tencent_mm_protocal_c_aie.mII == 0) {
                                com_tencent_mm_protocal_c_aie.mII = 2;
                                com_tencent_mm_protocal_c_aie.mIJ = "";
                                de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
                                ad.aSt().a(i3, de);
                            } else {
                                continue;
                            }
                        } catch (Exception e2) {
                            v.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                            return false;
                        }
                    }
                }
                return true;
            }
        } catch (Exception e3) {
            th = e3;
            v.a("MicroMsg.SnsInfoStorageLogic", th, "", new Object[0]);
            com_tencent_mm_protocal_c_aic = com_tencent_mm_protocal_c_aic2;
            if (com_tencent_mm_protocal_c_aic != null) {
                return false;
            }
            ad.aSE().b(i, qG);
            for (i2 = 0; i2 < com_tencent_mm_protocal_c_aic.mIn.size(); i2++) {
                i3 = ((ago) com_tencent_mm_protocal_c_aic.mIn.get(i2)).mGh;
                de = ad.aSt().de((long) i3);
                if (de == null) {
                    de.offset = 0;
                    com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
                    if (com_tencent_mm_protocal_c_aie.mII == 0) {
                        continue;
                    } else {
                        com_tencent_mm_protocal_c_aie.mII = 2;
                        com_tencent_mm_protocal_c_aie.mIJ = "";
                        de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
                        ad.aSt().a(i3, de);
                    }
                }
            }
            return true;
        }
        if (com_tencent_mm_protocal_c_aic != null) {
            return false;
        }
        ad.aSE().b(i, qG);
        for (i2 = 0; i2 < com_tencent_mm_protocal_c_aic.mIn.size(); i2++) {
            i3 = ((ago) com_tencent_mm_protocal_c_aic.mIn.get(i2)).mGh;
            de = ad.aSt().de((long) i3);
            if (de == null) {
                de.offset = 0;
                com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
                if (com_tencent_mm_protocal_c_aie.mII == 0) {
                    continue;
                } else {
                    com_tencent_mm_protocal_c_aie.mII = 2;
                    com_tencent_mm_protocal_c_aie.mIJ = "";
                    de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
                    ad.aSt().a(i3, de);
                }
            }
        }
        return true;
    }

    public static boolean Au(String str) {
        return com.tencent.mm.model.k.xF().equals(str.trim());
    }

    public static List<k> aSV() {
        List arrayList = new ArrayList();
        l aSE = ad.aSE();
        Cursor rawQuery = aSE.cie.rawQuery(l.aUY() + " AND " + l.jCe + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
        } else {
            rawQuery.moveToFirst();
            do {
                k kVar = new k();
                kVar.b(rawQuery);
                arrayList.add(kVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
        }
        return arrayList;
    }

    public static String Av(String str) {
        int i = 1;
        List linkedList = new LinkedList();
        Cursor cursor = ad.aSI().getCursor();
        if (cursor.moveToFirst()) {
            do {
                q qVar = new q();
                qVar.b(cursor);
                linkedList.add(be.ah(qVar.field_tagName, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        String str2 = str;
        while (linkedList.contains(str2)) {
            StringBuilder append = new StringBuilder().append(str);
            int i2 = i + 1;
            str2 = append.append(i).toString();
            i = i2;
        }
        return str2;
    }

    public static k qg(int i) {
        k kVar = new k();
        l aSE = ad.aSE();
        v.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[]{((l.aUZ() + " and createTime < " + i) + l.jBY) + " LIMIT 1"});
        Cursor rawQuery = aSE.cie.rawQuery(r3, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            kVar.b(rawQuery);
            rawQuery.close();
            return kVar;
        }
        rawQuery.close();
        return null;
    }

    public static List<b> cz(String str, String str2) {
        List<b> arrayList = new ArrayList();
        bw bwVar = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (FileOp.aR(str3)) {
                bwVar = (bw) new bw().az(FileOp.c(str3, 0, (int) FileOp.jP(str3)));
            }
            if (bwVar == null) {
                FileOp.deleteFile(str3);
                bwVar = a.AX(new String(FileOp.c(str4, 0, (int) FileOp.jP(str4))));
                FileOp.b(str3, bwVar.toByteArray(), -1);
            }
            Iterator it = bwVar.mcs.iterator();
            while (it.hasNext()) {
                abp com_tencent_mm_protocal_c_abp = (abp) it.next();
                str4 = com_tencent_mm_protocal_c_abp.gkB;
                Iterator it2 = com_tencent_mm_protocal_c_abp.mom.iterator();
                while (it2.hasNext()) {
                    aib com_tencent_mm_protocal_c_aib = (aib) it2.next();
                    com_tencent_mm_protocal_c_aib.gkC = str4;
                    b bVar = new b();
                    bVar.boL = com_tencent_mm_protocal_c_aib;
                    bVar.jqo = "";
                    arrayList.add(bVar);
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        return arrayList;
    }

    public static aib a(k kVar, int i) {
        if (ad.aSn() || kVar == null) {
            return null;
        }
        azr aUp = kVar.aUp();
        if (aUp.mWq == null || aUp.mWq.mom.size() == 0 || aUp.mWq.mom.size() <= i) {
            return null;
        }
        return (aib) aUp.mWq.mom.get(i);
    }

    public static List<b> Aw(String str) {
        List<b> arrayList = new ArrayList();
        if (ad.aSn()) {
            return arrayList;
        }
        k Bq = f.Bq(str);
        if (Bq == null) {
            return arrayList;
        }
        azr aUp = Bq.aUp();
        if (aUp.mWq == null || aUp.mWq.mom.size() == 0) {
            return arrayList;
        }
        arrayList.clear();
        Iterator it = aUp.mWq.mom.iterator();
        while (it.hasNext()) {
            aib com_tencent_mm_protocal_c_aib = (aib) it.next();
            b bVar = new b();
            bVar.boL = com_tencent_mm_protocal_c_aib;
            bVar.jqo = str;
            bVar.cLB = aUp.hNS;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static List<b> bn(List<String> list) {
        List<b> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        arrayList.clear();
        for (String str : list) {
            b bVar = new b();
            aib com_tencent_mm_protocal_c_aib = new aib();
            com_tencent_mm_protocal_c_aib.gID = "pre_temp_extend_pic" + str;
            bVar.boL = com_tencent_mm_protocal_c_aib;
            bVar.jqo = "";
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static void qh(int i) {
        v.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　" + i);
        k qG = ad.aSE().qG(i);
        if (qG != null) {
            if (((qG.field_localFlag & 64) > 0 ? 1 : null) != null) {
                qG.field_localFlag &= -65;
            }
            ad.aSE().b(i, qG);
        }
    }

    public static void aSW() {
        Cursor aX = ad.aSE().aX("", 0);
        if (aX != null) {
            v.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (aX.moveToNext()) {
                k kVar = new k();
                kVar.b(aX);
                v.i("MicroMsg.SnsInfoStorageLogic", kVar.aUq());
            }
            v.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            aX.close();
        }
    }
}
