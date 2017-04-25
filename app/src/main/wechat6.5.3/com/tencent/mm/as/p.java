package com.tencent.mm.as;

import android.content.ContentValues;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class p {
    public static boolean lg(String str) {
        if (str == null) {
            return false;
        }
        n lp = lp(str);
        if (lp == null || lp.dhM >= 2500) {
            return false;
        }
        lp.dhM++;
        lp.bkU = 16384;
        return e(lp);
    }

    public static boolean lh(String str) {
        g.iuh.a(111, 218, 1, false);
        v.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", str, be.bur());
        k.KY().aVs.remove(str);
        if (str == null) {
            return false;
        }
        n lp = lp(str);
        if (lp == null) {
            v.e("MicroMsg.VideoLogic", "Set error failed file:" + str);
            return false;
        }
        lp.status = 198;
        lp.dhI = System.currentTimeMillis() / 1000;
        lp.bkU = 1280;
        ahn com_tencent_mm_protocal_c_ahn = lp.dhU;
        com_tencent_mm_protocal_c_ahn.mHe = 0;
        lp.dhU = com_tencent_mm_protocal_c_ahn;
        boolean e = e(lp);
        v.d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + lp.dhL + " old stat:" + lp.status);
        if (lp == null || lp.dhL == 0) {
            return e;
        }
        ak.yW();
        at ek = c.wJ().ek((long) lp.dhL);
        int i = ek.field_type;
        v.i("MicroMsg.VideoLogic", "set error, msg type %d", Integer.valueOf(i));
        if (43 != i && 62 != i) {
            return e;
        }
        ek.cH(lp.Ld());
        ek.setContent(l.b(lp.Le(), -1, true));
        v.d("MicroMsg.VideoLogic", "[oneliang][setError]");
        ak.yW();
        c.wJ().a(ek.field_msgId, ek);
        return e;
    }

    public static boolean li(String str) {
        n lp = lp(str);
        if (lp == null || lp.dhL == 0) {
            return false;
        }
        ak.yW();
        at ek = c.wJ().ek((long) lp.dhL);
        int i = ek.field_type;
        v.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", Integer.valueOf(i));
        if (43 != i && 62 != i) {
            return false;
        }
        ek.setContent(l.b(lp.Le(), (long) lp.dhK, false));
        ek.dh(2);
        ak.yW();
        c.wJ().a((long) lp.dhL, ek);
        lp.status = 197;
        lp.dhI = be.Nh();
        lp.bkU = 1280;
        v.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
        return e(lp);
    }

    public static boolean lj(String str) {
        g.iuh.a(111, 217, 1, false);
        n lp = lp(str);
        if (lp == null) {
            return false;
        }
        ak.yW();
        at ek = c.wJ().ek((long) lp.dhL);
        int i = ek.field_type;
        v.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", Integer.valueOf(i));
        if (43 != i && 62 != i) {
            return false;
        }
        ek.setContent(l.b(lp.Le(), (long) lp.dhK, false));
        ek.dh(2);
        ak.yW();
        c.wJ().a((long) lp.dhL, ek);
        lp.status = 196;
        lp.dhI = be.Nh();
        lp.bkU = 1280;
        v.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
        return e(lp);
    }

    public static boolean b(String str, int i, String str2, String str3) {
        return a(str, i, str2, str3, 0, SQLiteDatabase.KeyEmpty, 43);
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3) {
        return a(str, i, str2, str3, i2, str4, i3, null, SQLiteDatabase.KeyEmpty);
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3, ayk com_tencent_mm_protocal_c_ayk, String str5) {
        n nVar = new n();
        nVar.aST = str;
        nVar.dhK = i;
        nVar.ble = str2;
        ak.yW();
        nVar.dhC = (String) c.vf().get(2, SQLiteDatabase.KeyEmpty);
        nVar.dhH = be.Nh();
        nVar.dhI = be.Nh();
        nVar.dhQ = str4;
        nVar.dgk = str3;
        nVar.dhT = com_tencent_mm_protocal_c_ayk;
        nVar.bnY = str5;
        if (!be.kS(str3)) {
            nVar.dhO = 1;
        }
        if (i2 > 0) {
            nVar.dhO = 1;
        }
        if (62 == i3) {
            nVar.dhR = 3;
        } else if (i2 > 0) {
            nVar.dhR = 2;
        } else {
            nVar.dhR = 1;
        }
        k.KV();
        int le = o.le(o.lc(str));
        if (le <= 0) {
            v.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
            return false;
        }
        nVar.cyu = le;
        k.KV();
        String ld = o.ld(str);
        int le2 = o.le(ld);
        if (le2 <= 0) {
            v.e("MicroMsg.VideoLogic", "get Thumb size failed :" + ld + " size:" + le2);
            return false;
        }
        nVar.dhG = le2;
        v.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + nVar.dhG + " videosize:" + nVar.cyu + " msgType:" + i3);
        nVar.status = MMGIFException.D_GIF_ERR_READ_FAILED;
        at atVar = new at();
        atVar.cH(nVar.Ld());
        atVar.setType(i3);
        atVar.di(1);
        atVar.cI(str);
        atVar.dh(1);
        atVar.z(aw.fN(nVar.Ld()));
        nVar.dhL = (int) aw.e(atVar);
        return k.KV().a(nVar);
    }

    public static long a(String str, int i, String str2, String str3, int i2) {
        if (be.kS(str)) {
            v.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", Integer.valueOf(i2));
            return -1;
        } else if (be.kS(str2)) {
            v.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", Integer.valueOf(i2));
            return -1;
        } else if (i <= 0) {
            v.w("MicroMsg.VideoLogic", "do prepare, but video len error, type %d", Integer.valueOf(i2));
            return -1;
        } else {
            int i3;
            n nVar;
            n nVar2 = new n();
            nVar2.aST = str;
            nVar2.dhK = i;
            nVar2.ble = str2;
            ak.yW();
            nVar2.dhC = (String) c.vf().get(2, SQLiteDatabase.KeyEmpty);
            nVar2.dhH = be.Nh();
            nVar2.dhI = be.Nh();
            nVar2.dhQ = null;
            nVar2.dgk = str3;
            if (!be.kS(str3)) {
                nVar2.dhO = 1;
            }
            if (62 == i2) {
                nVar2.dhO = 0;
                i3 = 3;
                nVar = nVar2;
            } else if (nVar2.dhO == 0) {
                i3 = 1;
                nVar = nVar2;
            } else {
                i3 = -1;
                nVar = nVar2;
            }
            nVar.dhR = i3;
            nVar2.cyu = 0;
            nVar2.status = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
            at atVar = new at();
            atVar.cH(nVar2.Ld());
            atVar.setType(i2);
            atVar.di(1);
            atVar.cI(str);
            atVar.dh(8);
            atVar.z(aw.fN(nVar2.Ld()));
            long e = aw.e(atVar);
            nVar2.dhL = (int) e;
            if (k.KV().a(nVar2)) {
                return e;
            }
            return -1;
        }
    }

    public static long d(String str, int i, String str2) {
        return a(str, i, str2, null, 62);
    }

    public static void f(String str, int i, int i2) {
        n lp = lp(str);
        if (lp == null) {
            v.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", str, Integer.valueOf(i2));
            return;
        }
        k.KV();
        v.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", Integer.valueOf(o.le(o.lc(str))), Integer.valueOf(i2));
        lp.cyu = r1;
        lp.dhK = i;
        ahn com_tencent_mm_protocal_c_ahn = lp.dhU;
        com_tencent_mm_protocal_c_ahn.mHc = false;
        lp.dhU = com_tencent_mm_protocal_c_ahn;
        lp.status = MMGIFException.D_GIF_ERR_READ_FAILED;
        k.KV();
        lp.dhG = o.le(o.ld(str));
        v.i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + lp.dhG);
        lp.bkU = 4512;
        v.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", Boolean.valueOf(e(lp)), Integer.valueOf(i2));
        ak.yW();
        at ek = c.wJ().ek((long) lp.dhL);
        v.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(ek.field_msgId), Long.valueOf(ek.field_msgSvrId), ek.field_talker, Integer.valueOf(ek.field_type), Integer.valueOf(ek.field_isSend), ek.field_imgPath, Integer.valueOf(ek.field_status), Long.valueOf(ek.field_createTime));
        ek.cH(lp.Ld());
        ek.setType(i2);
        ek.di(1);
        ek.cI(str);
        ek.dh(1);
        v.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(ek.field_msgId), Long.valueOf(ek.field_msgSvrId), ek.field_talker, Integer.valueOf(ek.field_type), Integer.valueOf(ek.field_isSend), ek.field_imgPath, Integer.valueOf(ek.field_status), Long.valueOf(ek.field_createTime));
        ak.yW();
        c.wJ().a((long) lp.dhL, ek);
    }

    public static int lk(String str) {
        n lp = lp(str);
        if (lp == null) {
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else if (lp.status == MMGIFException.D_GIF_ERR_READ_FAILED || lp.status == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
            int i = lp.status;
            if (lp.status == MMGIFException.D_GIF_ERR_READ_FAILED || lp.dhG != lp.dhF) {
                lp.status = MMGIFException.D_GIF_ERR_NOT_GIF_FILE;
            } else {
                lp.status = MMGIFException.D_GIF_ERR_NO_SCRN_DSCR;
            }
            v.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.sm() + "startSend file:" + str + " status:[" + i + "->" + lp.status + "]");
            lp.dhJ = be.Nh();
            lp.dhI = be.Nh();
            lp.bkU = 3328;
            if (e(lp)) {
                k.KY().run();
                return 0;
            }
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else {
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " get status failed: " + str + " status:" + lp.status);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
    }

    public static int at(long j) {
        for (n nVar : k.KV().as(j)) {
            int i = nVar.status;
            nVar.status = 200;
            v.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.sm() + "startSend file:" + nVar.getFileName() + " status:[" + i + "->" + nVar.status + "]");
            nVar.dhJ = be.Nh();
            nVar.dhI = be.Nh();
            nVar.bkU = 3328;
            if (!e(nVar)) {
                v.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.sm() + " update failed: " + nVar.getFileName());
                return 0 - com.tencent.mm.compatible.util.g.sk();
            }
        }
        ak.vA().x(new Runnable(k.KZ()) {
            final /* synthetic */ i dgY;

            {
                this.dgY = r1;
            }

            public final void run() {
                v.d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + this.dgY.aVv + " sending:" + this.dgY.aVu);
                if (!this.dgY.aVv) {
                    this.dgY.aVw = 5;
                    this.dgY.aVz.cgu = SystemClock.elapsedRealtime();
                    this.dgY.aVu = false;
                }
                this.dgY.aVv = true;
                this.dgY.aVA.ea(10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
        return 0;
    }

    public static void c(n nVar) {
        if (nVar == null) {
            v.e("MicroMsg.VideoLogic", "video info is null");
            return;
        }
        ak.yW();
        at ek = c.wJ().ek((long) nVar.dhL);
        int i = ek.field_type;
        v.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", Integer.valueOf(i));
        if (43 == i || 62 == i) {
            ek.di(1);
            ek.cH(nVar.Ld());
            ek.y(nVar.bmL);
            ek.dh(2);
            ek.setContent(l.b(nVar.Le(), (long) nVar.dhK, false));
            ak.yW();
            c.wJ().a((long) nVar.dhL, ek);
            v.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", Long.valueOf(ek.field_msgId));
        }
    }

    static boolean d(n nVar) {
        ak.yW();
        bx ek = c.wJ().ek((long) nVar.dhL);
        int i = ek.field_type;
        v.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", Integer.valueOf(i));
        if (43 != i && 62 != i) {
            return false;
        }
        ek.y(nVar.bmL);
        ek.setContent(l.b(nVar.Le(), (long) nVar.dhK, false));
        ek.cH(nVar.Ld());
        v.d("MicroMsg.VideoLogic", "set msg content :" + ek.field_content);
        ak.yW();
        c.wJ().b(nVar.bmL, ek);
        v.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", Long.valueOf(ek.field_msgId));
        if (ek.bwo()) {
            v.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", Integer.valueOf(nVar.cyu));
        }
        return true;
    }

    public static int ll(String str) {
        n lp = lp(str);
        if (lp == null) {
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else if (lp.status == MMGIFException.D_GIF_ERR_NOT_READABLE || lp.status == MMGIFException.D_GIF_ERR_EOF_TOO_SOON || lp.status == 121 || lp.status == 122) {
            lp.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            lp.dhJ = be.Nh();
            lp.dhI = be.Nh();
            lp.bkU = 3328;
            if (e(lp)) {
                k.KY().Lp();
                k.KY().run();
                return 0;
            }
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else {
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " get status failed: " + str + " status:" + lp.status);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
    }

    public static int lm(String str) {
        n lp = lp(str);
        if (lp == null) {
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else if (lp.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || lp.status == 120 || lp.status == 122) {
            lp.status = MMGIFException.D_GIF_ERR_EOF_TOO_SOON;
            lp.dhI = be.Nh();
            lp.bkU = 1280;
            if (e(lp)) {
                return 0;
            }
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else {
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " get status failed: " + str + " status:" + lp.status);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
    }

    public static boolean E(String str, int i) {
        int i2 = 0;
        n lp = lp(str);
        if (lp == null) {
            v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " getinfo failed: " + str);
            return false;
        }
        if (i != lp.cyu) {
            v.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", Integer.valueOf(i), Integer.valueOf(lp.cyu));
            lp.cyu = i;
            i2 = 32;
        }
        lp.dhE = i;
        lp.dhI = be.Nh();
        d(lp);
        lp.status = 199;
        lp.bkU = i2 | 1296;
        boolean e = e(lp);
        v.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i + " total:" + lp.cyu + " status:" + lp.status + " netTimes:" + lp.dhM + " update ret: " + e);
        return e;
    }

    public static boolean ln(String str) {
        v.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : " + str);
        n nVar = new n();
        nVar.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        nVar.dhI = be.Nh();
        nVar.dhJ = be.Nh();
        nVar.aST = str;
        nVar.bkU = 3328;
        if (!e(nVar)) {
            return false;
        }
        k.KY().run();
        return true;
    }

    public static boolean lo(String str) {
        n lp = lp(str);
        if (lp == null) {
            return false;
        }
        v.i("MicroMsg.VideoLogic", "rsetMsgSend %s", str);
        ahn com_tencent_mm_protocal_c_ahn = lp.dhU;
        if (com_tencent_mm_protocal_c_ahn != null) {
            com_tencent_mm_protocal_c_ahn.mHe = 0;
            lp.dhU = com_tencent_mm_protocal_c_ahn;
        }
        if (lp.dhF < lp.dhG) {
            lp.status = MMGIFException.D_GIF_ERR_NOT_GIF_FILE;
        } else {
            lp.status = MMGIFException.D_GIF_ERR_NO_SCRN_DSCR;
        }
        lp.dhH = be.Nh();
        lp.dhI = be.Nh();
        lp.dhJ = be.Nh();
        lp.bkU = 536874752;
        if (!e(lp)) {
            return false;
        }
        k.KY().run();
        return true;
    }

    public static n lp(String str) {
        if (be.kS(str)) {
            return null;
        }
        return k.KV().kZ(str);
    }

    public static boolean e(n nVar) {
        if (nVar == null) {
            return false;
        }
        if ((nVar.getFileName() == null || nVar.getFileName().length() <= 0) && nVar.bkU == -1) {
            return false;
        }
        return k.KV().b(nVar);
    }

    public static String lq(String str) {
        String str2 = e.cgg + be.Ni() + ".mp4";
        if (j.dz(str, str2)) {
            return str2;
        }
        return null;
    }

    public static int f(n nVar) {
        if (nVar.cyu == 0) {
            return 0;
        }
        v.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + nVar.dhE + " " + nVar.cyu);
        return (nVar.dhE * 100) / nVar.cyu;
    }

    public static int g(n nVar) {
        if (nVar.cyu == 0) {
            return 0;
        }
        v.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + nVar.dgC + " " + nVar.cyu);
        return (nVar.dgC * 100) / nVar.cyu;
    }

    public static boolean lr(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            return false;
        }
        v.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: " + str);
        n lp = lp(str);
        if (lp == null || lp.status != 199) {
            return false;
        }
        int i = lp.cyu;
        k.KV();
        int aQ = com.tencent.mm.a.e.aQ(o.lc(str));
        v.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", Integer.valueOf(aQ), Integer.valueOf(i));
        if (aQ <= 0 || Math.abs(aQ - i) <= 16) {
            return false;
        }
        v.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", Integer.valueOf(aQ), Integer.valueOf(i));
        lj(lp.getFileName());
        return true;
    }

    public static int x(int i, String str) {
        int i2;
        long Nj = be.Nj();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!k.KW().b(str, pInt, pInt2) || be.ax((long) pInt.value) >= 300) {
            i2 = 0;
        } else {
            i2 = pInt2.value;
        }
        if (i2 < 0 || i2 >= i - 1) {
            i2 = 0;
        }
        v.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", Integer.valueOf(i2), Integer.valueOf(pInt.value), str, Long.valueOf(be.az(Nj)));
        return i2;
    }

    public static void d(String str, int i, boolean z) {
        if (be.kS(str)) {
            v.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", str);
            return;
        }
        boolean z2;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        long Nj = be.Nj();
        long update;
        if (k.KW().lu(str)) {
            s KW = k.KW();
            int Ni = (int) (be.Ni() / 1000);
            if (!be.kS(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("starttime", Integer.valueOf(Ni));
                contentValues.put("playduration", Integer.valueOf(i2));
                update = (long) KW.cie.update("VideoPlayHistory", contentValues, "filename=?", new String[]{str});
                v.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            s KW2 = k.KW();
            int Ni2 = (int) (be.Ni() / 1000);
            int i3 = z ? 1 : 0;
            if (!be.kS(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("filename", str);
                contentValues2.put("starttime", Integer.valueOf(Ni2));
                contentValues2.put("playduration", Integer.valueOf(i2));
                contentValues2.put("downloadway", Integer.valueOf(i3));
                update = KW2.cie.insert("VideoPlayHistory", "filename", contentValues2);
                v.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        v.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", Boolean.valueOf(z2), str, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(be.az(Nj)));
    }

    public static void ls(String str) {
        boolean z = true;
        if (!be.kS(str)) {
            if (k.KW().cie.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
                z = false;
            }
            v.d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        }
    }

    public static String e(long j, int i) {
        return j + "_" + i;
    }

    public static int c(long j, String str) {
        int i = -1;
        if (!be.kS(str)) {
            try {
                String[] split = str.split("_");
                if (split != null && split.length == 2 && be.getLong(split[0], 0) == j) {
                    i = be.getInt(split[1], 0);
                }
            } catch (Exception e) {
                v.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e.toString());
            }
        }
        return i;
    }

    public static boolean Lo() {
        int i;
        ak.yW();
        int intValue = ((Integer) c.vf().get(a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100136");
        if (Ls.isValid()) {
            i = be.getInt((String) Ls.buX().get("streamingDownload"), 0);
        } else {
            i = 0;
        }
        v.i("MicroMsg.VideoLogic", "check can online play video opcode : " + intValue + " abTestFlag : " + i);
        if (intValue == 0 || i == -1) {
            return false;
        }
        if (intValue > 0) {
            return true;
        }
        if (intValue == 0 || i <= 0) {
            return false;
        }
        return true;
    }

    public static void F(String str, int i) {
        n lp = lp(str);
        if (lp != null) {
            lp.status = 122;
            lp.dhJ = be.Nh();
            lp.dhI = be.Nh();
            lp.cFX = i;
            lp.bkU = 268438784;
            v.i("MicroMsg.VideoLogic", "set online video Completion ret: " + k.KV().b(lp) + " status: " + lp.status);
        }
    }

    public static boolean G(String str, int i) {
        return b(lp(str), i);
    }

    public static boolean b(n nVar, int i) {
        if (nVar == null) {
            return false;
        }
        nVar.cFX = i;
        nVar.bkU = SQLiteDatabase.CREATE_IF_NECESSARY;
        return e(nVar);
    }

    public static boolean a(String str, PInt pInt, PInt pInt2) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable e;
        Throwable th;
        if (be.kS(str)) {
            v.w("MicroMsg.VideoLogic", "get media info but path is null");
            return false;
        }
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                pInt.value = be.ee((long) be.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                pInt2.value = be.getInt(mediaMetadataRetriever.extractMetadata(20), 0) / 1000;
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    v.a("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    v.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever = null;
            v.a("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            v.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
            return true;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        v.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
        return true;
    }
}
