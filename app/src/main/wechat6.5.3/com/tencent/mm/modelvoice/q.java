package com.tencent.mm.modelvoice;

import com.tencent.mm.ar.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.aw.b;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import junit.framework.Assert;

public final class q {
    public static boolean lB(String str) {
        if (str == null) {
            return false;
        }
        p lJ = m.Lz().lJ(str);
        if (lJ == null || lJ.dhM >= 250) {
            return false;
        }
        lJ.dhM++;
        lJ.bkU = 8192;
        return a(lJ);
    }

    public static b af(String str, String str2) {
        u Lz = m.Lz();
        String iU = iU(str2);
        switch (be.getInt(str, -1)) {
            case 1:
                if (Lz.djQ.get(iU) == null) {
                    Lz.djQ.put(iU, new l(iU));
                }
                return (b) Lz.djQ.get(iU);
            case 4:
                if (Lz.djR.get(iU) == null) {
                    Lz.djR.put(iU, new h(iU));
                }
                return (b) Lz.djR.get(iU);
            default:
                if (Lz.djP.get(iU) == null) {
                    Lz.djP.put(iU, new a(iU));
                }
                return (b) Lz.djP.get(iU);
        }
    }

    public static b lC(String str) {
        u Lz = m.Lz();
        String iU = iU(str);
        switch (o.lz(str)) {
            case 0:
                if (Lz.djP.get(iU) == null) {
                    Lz.djP.put(iU, new a(iU));
                }
                return (b) Lz.djP.get(iU);
            case 1:
                if (Lz.djQ.get(iU) == null) {
                    Lz.djQ.put(iU, new l(iU));
                }
                return (b) Lz.djQ.get(iU);
            case 2:
                if (Lz.djR.get(iU) == null) {
                    Lz.djR.put(iU, new h(iU));
                }
                return (b) Lz.djR.get(iU);
            default:
                if (Lz.djP.get(iU) == null) {
                    Lz.djP.put(iU, new a(iU));
                }
                return (b) Lz.djP.get(iU);
        }
    }

    public static void lD(String str) {
        u Lz = m.Lz();
        String iU = iU(str);
        a aVar;
        switch (o.lz(str)) {
            case 0:
                aVar = (a) Lz.djP.get(iU);
                if (aVar != null) {
                    aVar.Lr();
                    Lz.djP.remove(iU);
                    return;
                }
                return;
            case 1:
                l lVar = (l) Lz.djQ.get(iU);
                if (lVar != null) {
                    lVar.Lr();
                    Lz.djQ.remove(iU);
                    return;
                }
                return;
            case 2:
                h hVar = (h) Lz.djR.get(iU);
                if (hVar != null) {
                    hVar.Lr();
                    Lz.djR.remove(iU);
                    return;
                }
                return;
            default:
                aVar = (a) Lz.djP.get(iU);
                if (aVar != null) {
                    aVar.Lr();
                    Lz.djP.remove(iU);
                    return;
                }
                return;
        }
    }

    public static String iU(String str) {
        if (be.kS(str)) {
            return null;
        }
        return G(str, false);
    }

    public static String G(String str, boolean z) {
        a aVar = new a();
        ak.yW();
        String b = h.b(c.wU(), "msg_", str, ".amr", 2);
        v.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + aVar.sn());
        if (be.kS(b)) {
            return null;
        }
        if (z || new File(b).exists()) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(c.wT()).append(str).toString();
        if (new File(stringBuilder2 + ".amr").exists()) {
            j.n(stringBuilder2 + ".amr", b, true);
            return b;
        } else if (!new File(stringBuilder2).exists()) {
            return b;
        } else {
            j.n(stringBuilder2, b, true);
            return b;
        }
    }

    public static String lE(String str) {
        String lI = u.lI(k.xF());
        p pVar = new p();
        pVar.aST = lI;
        pVar.ble = str;
        pVar.dhH = System.currentTimeMillis() / 1000;
        pVar.clientId = lI;
        pVar.dhI = System.currentTimeMillis() / 1000;
        pVar.status = 1;
        pVar.dhC = k.xF();
        pVar.bkU = -1;
        if (!m.Lz().b(pVar)) {
            return null;
        }
        v.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
        return lI;
    }

    public static boolean lF(String str) {
        if (str == null) {
            return false;
        }
        p lJ = m.Lz().lJ(str);
        if (lJ == null) {
            v.d("MicroMsg.VoiceLogic", "cancel null download : " + str);
            return true;
        }
        v.d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + lJ.bmL);
        if (lJ.bmL != 0) {
            ak.yW();
            c.wJ().Z(lJ.ble, lJ.bmL);
        }
        return lH(str);
    }

    public static boolean lG(String str) {
        if (str == null) {
            return false;
        }
        p lJ = m.Lz().lJ(str);
        if (lJ == null) {
            v.i("MicroMsg.VoiceLogic", "cancel null record : " + str);
            return true;
        }
        v.i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + lJ.dhL);
        if (lJ.dhL != 0) {
            ak.yW();
            c.wJ().em((long) lJ.dhL);
        }
        return lH(str);
    }

    public static boolean lH(String str) {
        if (be.kS(str)) {
            return false;
        }
        u Lz = m.Lz();
        Assert.assertTrue(str.length() > 0);
        if (Lz.cuX.delete("voiceinfo", "FileName= ?", new String[]{str}) <= 0) {
            v.w("MicroMsg.VoiceStorage", "delete failed, no such file:" + str);
        }
        lD(str);
        return new File(iU(str)).delete();
    }

    public static boolean g(String str, int i, int i2) {
        if (str == null) {
            return false;
        }
        v.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + iU(str) + "]");
        p lJ = m.Lz().lJ(str);
        if (lJ == null) {
            return false;
        }
        if (!(lJ.status == 97 || lJ.status == 98)) {
            lJ.status = 3;
        }
        lJ.cyu = o.le(str);
        if (lJ.cyu <= 0) {
            lh(str);
            return false;
        }
        lJ.dhI = System.currentTimeMillis() / 1000;
        lJ.djF = i;
        lJ.bkU = 3424;
        bx atVar = new at();
        atVar.cH(lJ.ble);
        atVar.setType(34);
        atVar.di(1);
        atVar.cI(str);
        if (lJ.status == 97) {
            atVar.dh(2);
            atVar.setContent(n.b(lJ.dhC, (long) lJ.djF, false));
        } else if (lJ.status == 98) {
            atVar.dh(5);
            atVar.setContent(n.b(lJ.dhC, -1, true));
        } else {
            atVar.dh(1);
            atVar.setContent(n.b(lJ.dhC, (long) lJ.djF, false));
        }
        atVar.z(aw.fN(lJ.ble));
        atVar.vg(i2);
        if (e.hC(atVar.field_talker)) {
            atVar.cN(com.tencent.mm.modelbiz.a.e.zr());
        }
        lJ.dhL = (int) aw.e(atVar);
        return a(lJ);
    }

    static boolean a(p pVar, d.a aVar) {
        try {
            pVar.dhL = (int) a(pVar, true, 3, SQLiteDatabase.KeyEmpty, pVar.bNo, aVar);
            pVar.bkU |= 2048;
            return a(pVar);
        } catch (Throwable e) {
            v.e("MicroMsg.VoiceLogic", "exception:%s", be.e(e));
            return false;
        }
    }

    static long a(p pVar, boolean z, int i, String str, String str2, d.a aVar) {
        at atVar = new at();
        atVar.y(pVar.bmL);
        atVar.cI(pVar.aST);
        atVar.z(aw.h(pVar.ble, pVar.dhH));
        atVar.cH(pVar.ble);
        atVar.di(k.eo(pVar.dhC) ? 1 : 0);
        atVar.setType(34);
        atVar.cM(str);
        atVar.vg(pVar.diF);
        atVar.dh(i);
        if (aVar == null) {
            int i2 = pVar.bNn;
            if (i2 != 0) {
                v.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", Integer.valueOf(i2));
                atVar.dr(i2);
                if (atVar.field_msgId == 0 && atVar.field_isSend == 0 && (i2 & 2) != 0) {
                    atVar.z(aw.a(atVar.field_talker, pVar.dhH, true, atVar.field_msgSeq));
                }
            }
            if (pVar.cQM != 0) {
                atVar.B((long) pVar.cQM);
            }
            v.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(pVar.cQM));
        } else {
            aw.a(atVar, aVar);
        }
        v.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", str2);
        if (!be.kS(str2)) {
            atVar.cN(str2);
            atVar.cO(aw.fQ(str2));
        }
        if (z) {
            atVar.setContent(n.b(pVar.dhC, (long) pVar.djF, false));
        } else {
            atVar.setContent(n.b(pVar.dhC, 0, false));
        }
        if (!be.kS(str2)) {
            atVar.cN(str2);
            atVar.cO(aw.fQ(str2));
            b fP = aw.fP(str2);
            if (fP != null) {
                atVar.cO(fP.ctv);
                atVar.cL(fP.ctu);
                v.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", fP.ctu);
                if (fP.ctw != null && fP.scene == 1) {
                    ak.yW();
                    c.vf().set(73729, Integer.valueOf(1));
                    com.tencent.mm.ar.h hVar = new com.tencent.mm.ar.h();
                    hVar.field_content = atVar.field_content;
                    hVar.field_createtime = be.Nh();
                    hVar.field_imgpath = SQLiteDatabase.KeyEmpty;
                    hVar.field_sayhicontent = aa.getContext().getString(2131234016);
                    hVar.field_sayhiuser = atVar.field_talker;
                    hVar.field_scene = 18;
                    hVar.field_status = atVar.field_status > 3 ? atVar.field_status : 3;
                    hVar.field_svrid = atVar.field_msgSvrId;
                    hVar.field_talker = atVar.field_talker;
                    hVar.field_type = 34;
                    hVar.field_isSend = 0;
                    hVar.field_sayhiencryptuser = atVar.field_talker;
                    hVar.field_ticket = fP.ctw;
                    l.KE().a(hVar);
                    com.tencent.mm.sdk.c.b hnVar = new hn();
                    hnVar.bhi.bhj = atVar.field_talker;
                    com.tencent.mm.sdk.c.a.nhr.z(hnVar);
                }
            }
        }
        v.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", Long.valueOf(atVar.field_msgSvrId), Long.valueOf(atVar.field_msgSeq));
        return aw.e(atVar);
    }

    public static int a(String str, int i, d.a aVar) {
        if (str == null) {
            return -1;
        }
        p lJ = m.Lz().lJ(str);
        if (lJ == null) {
            return -1;
        }
        lJ.dhE = i;
        lJ.dhI = System.currentTimeMillis() / 1000;
        lJ.bkU = 272;
        int i2 = 0;
        if (lJ.cyu > 0 && i >= lJ.cyu) {
            a(lJ, aVar);
            lJ.status = 99;
            lJ.bkU |= 64;
            v.d("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i + " total:" + lJ.cyu + " status:" + lJ.status + " netTimes:" + lJ.dhM);
            i2 = 1;
            lD(str);
        }
        v.d("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i + " total:" + lJ.cyu + " status:" + lJ.status);
        if (a(lJ)) {
            return i2;
        }
        return -3;
    }

    public static String c(String str, String str2, int i) {
        if (be.kS(str)) {
            return null;
        }
        if (!(be.kS(str2) || str2.startsWith("amr_") || str2.startsWith("spx_"))) {
            str2.startsWith("silk_");
        }
        String lE = lE(str);
        if (be.kS(lE) || !j.n(iU(str2), iU(lE), false)) {
            return null;
        }
        g(lE, i, 1);
        return lE;
    }

    public static boolean lh(String str) {
        boolean z = false;
        g.iuh.a(111, 234, 1, false);
        if (str != null) {
            p lJ = m.Lz().lJ(str);
            if (lJ == null) {
                v.e("MicroMsg.VoiceLogic", "Set error failed file:" + str);
            } else {
                lJ.status = 98;
                lJ.dhI = System.currentTimeMillis() / 1000;
                lJ.bkU = 320;
                z = a(lJ);
                v.d("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + lJ.dhL + " old stat:" + lJ.status);
                if (lJ.dhL == 0 || be.kS(lJ.ble)) {
                    v.e("MicroMsg.VoiceLogic", "setError failed msg id:" + lJ.dhL + " user:" + lJ.ble);
                } else {
                    ak.yW();
                    at ek = c.wJ().ek((long) lJ.dhL);
                    ek.x((long) lJ.dhL);
                    ek.dh(5);
                    ek.cH(lJ.ble);
                    ek.setContent(n.b(lJ.dhC, -1, true));
                    ak.yW();
                    c.wJ().a(ek.field_msgId, ek);
                }
            }
        }
        return z;
    }

    public static boolean a(p pVar) {
        if (pVar == null || pVar.bkU == -1) {
            return false;
        }
        return m.Lz().a(pVar.aST, pVar);
    }

    public static float au(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static boolean y(at atVar) {
        if (atVar == null || !atVar.bwb()) {
            return false;
        }
        return new n(atVar.field_content).dhD;
    }

    public static boolean z(at atVar) {
        if (atVar == null || !atVar.bwb() || atVar.field_isSend == 1) {
            return false;
        }
        if (new n(atVar.field_content).time != 0) {
            return false;
        }
        return true;
    }

    public static void A(at atVar) {
        int i = 1;
        if (atVar != null && atVar.bwb()) {
            ak.yW();
            bx ek = c.wJ().ek(atVar.field_msgId);
            if (ek.field_msgId == atVar.field_msgId) {
                n nVar = new n(ek.field_content);
                if (!nVar.dhD) {
                    nVar.dhD = true;
                    StringBuilder append = new StringBuilder().append(nVar.dhC).append(":").append(nVar.time).append(":");
                    if (!nVar.dhD) {
                        i = 0;
                    }
                    atVar.setContent(append.append(i).append("\n").toString());
                    ak.yW();
                    c.wJ().a(atVar.field_msgId, atVar);
                }
            }
        }
    }
}
