package com.tencent.mm.as;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.as.a.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.bco;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class d extends k implements j {
    private static int dgy = 32000;
    String aST;
    int aYJ = 0;
    private String bov = SQLiteDatabase.KeyEmpty;
    String cMU = SQLiteDatabase.KeyEmpty;
    private a cNe = new a(this) {
        final /* synthetic */ d dgI;

        {
            this.dgI = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            v.d("MicroMsg.NetSceneUploadVideo", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.dgI.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
            if (i == -21005) {
                v.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.dgI.cMU);
                return 0;
            } else if (i != 0) {
                p.lh(this.dgI.aST);
                g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.dgI.startTime), Long.valueOf(be.Ni()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext())), Integer.valueOf(this.dgI.dgq), Integer.valueOf(0), SQLiteDatabase.KeyEmpty);
                this.dgI.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.dgI);
                return 0;
            } else {
                this.dgI.dgo = p.lp(this.dgI.aST);
                int i2;
                if (this.dgI.dgo == null || this.dgI.dgo.status == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                    v.i("MicroMsg.NetSceneUploadVideo", "info is null or has paused, status:%d", Integer.valueOf(this.dgI.dgo == null ? -1 : this.dgI.dgo.status));
                    com.tencent.mm.modelcdntran.g.DZ().ip(this.dgI.cMU);
                    this.dgI.cii.a(3, i, "info is null or has paused, status" + i2, this.dgI);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                            v.e("MicroMsg.NetSceneUploadVideo", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo);
                            p.lh(this.dgI.aST);
                            g.iuh.h(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.dgI.startTime), Long.valueOf(be.Ni()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext())), Integer.valueOf(this.dgI.dgq), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            this.dgI.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.dgI);
                        } else {
                            v.i("MicroMsg.NetSceneUploadVideo", "summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(this.dgI.cNm));
                            g gVar = g.iuh;
                            Object[] objArr = new Object[2];
                            i2 = this.dgI.dgE ? 810 : this.dgI.dgD ? 820 : 830;
                            objArr[0] = Integer.valueOf(i2 + com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType);
                            objArr[1] = Integer.valueOf(this.dgI.dgo.cyu);
                            gVar.h(12696, objArr);
                            v.d("MicroMsg.NetSceneUploadVideo", "it video was reduced by cdn %b %s", Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_isVideoReduced), this.dgI.aST);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_isVideoReduced) {
                                g.iuh.a(106, 200, 1, false);
                            } else {
                                g.iuh.a(106, 205, 1, false);
                                if (this.dgI.dgF > 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength > 0) {
                                    v.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", this.dgI.aST, Integer.valueOf(this.dgI.dgF), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength));
                                    if (this.dgI.dgF * 2 > com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength) {
                                        g.iuh.a(106, 206, 1, false);
                                    } else {
                                        g.iuh.a(106, 207, 1, false);
                                    }
                                }
                                k.KV();
                                v.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", this.dgI.aST, Integer.valueOf(this.dgI.dgo.cyu), Integer.valueOf(e.aQ(o.lc(this.dgI.aST))));
                                if (this.dgI.dgo.cyu != e.aQ(o.lc(this.dgI.aST))) {
                                    g.iuh.a(106, 208, 1, false);
                                } else {
                                    g.iuh.a(106, 209, 1, false);
                                }
                            }
                            this.dgI.dgo = p.lp(this.dgI.aST);
                            if (be.kS(this.dgI.dgo.Lg())) {
                                v.i("MicroMsg.NetSceneUploadVideo", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\" ") + "cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\"/></msg>");
                                this.dgI.dgo.dhQ = r0;
                                p.e(this.dgI.dgo);
                            }
                            Map q = bf.q(this.dgI.dgo.Lg(), "msg");
                            if (q != null) {
                                o KV = k.KV();
                                k.KV();
                                boolean o = KV.o(o.lc(this.dgI.aST), (String) q.get(".msg.videomsg.$cdnvideourl"), (String) q.get(".msg.videomsg.$aeskey"));
                                gVar = g.iuh;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf((o ? 1 : 2) + 900);
                                objArr[1] = Integer.valueOf(this.dgI.dgo.cyu);
                                gVar.h(12696, objArr);
                            }
                            d.a(this.dgI, com_tencent_mm_modelcdntran_keep_SceneResult);
                            ak.vy().a(new e(this.dgI.aST, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                                final /* synthetic */ AnonymousClass1 dgJ;

                                public final void aS(int i, int i2) {
                                    if (i == 4 && i2 == MMGIFException.D_GIF_ERR_READ_FAILED) {
                                        ak.vA().x(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 dgK;

                                            {
                                                this.dgK = r1;
                                            }

                                            public final void run() {
                                                this.dgK.dgJ.dgI.cNm = false;
                                                this.dgK.dgJ.dgI.dgo.status = MMGIFException.D_GIF_ERR_NO_SCRN_DSCR;
                                                this.dgK.dgJ.dgI.dgo.dhH = be.Nh();
                                                this.dgK.dgJ.dgI.dgo.dhI = be.Nh();
                                                this.dgK.dgJ.dgI.dgo.dgC = 0;
                                                this.dgK.dgJ.dgI.dgo.bkU = 1288;
                                                boolean e = p.e(this.dgK.dgJ.dgI.dgo);
                                                v.i("MicroMsg.NetSceneUploadVideo", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(this.dgK.dgJ.dgI.cNm), Boolean.valueOf(e), Long.valueOf(this.dgK.dgJ.dgI.dgo.dhH));
                                                this.dgK.dgJ.dgI.a(this.dgK.dgJ.dgI.czE, this.dgK.dgJ.dgI.cii);
                                            }
                                        });
                                        return;
                                    }
                                    g.iuh.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.dgJ.dgI.startTime), Long.valueOf(be.Ni()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext())), Integer.valueOf(this.dgJ.dgI.dgq), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                                    c.a(this.dgJ.dgI.dgo, 0);
                                    this.dgJ.dgI.cii.a(i, i2, SQLiteDatabase.KeyEmpty, this.dgJ.dgI);
                                }
                            }), 0);
                        }
                    }
                    return 0;
                } else if (this.dgI.dgo.dgC > com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                    v.w("MicroMsg.NetSceneUploadVideo", "cdntra cdnEndProc error oldpos:%d newpos:%d", Integer.valueOf(this.dgI.dgo.dgC), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                    return 0;
                } else {
                    this.dgI.dgo.dhI = be.Nh();
                    this.dgI.dgo.dgC = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                    this.dgI.dgo.bkU = 1032;
                    p.e(this.dgI.dgo);
                    return 0;
                }
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    private boolean cNm = true;
    com.tencent.mm.compatible.util.g.a cQT = null;
    private b cif;
    private com.tencent.mm.v.e cii;
    ah cxS = new ah(new ah.a(this) {
        final /* synthetic */ d dgI;

        {
            this.dgI = r1;
        }

        public final boolean oU() {
            if (this.dgI.a(this.dgI.czE, this.dgI.cii) == -1) {
                this.dgI.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                this.dgI.cii.a(3, -1, "doScene failed", this.dgI);
            }
            return false;
        }
    }, true);
    private final long dgA = 1800000;
    boolean dgB = false;
    private int dgC = -1;
    private boolean dgD = false;
    private boolean dgE = false;
    private int dgF = 0;
    private int dgG = 0;
    int dgH = 0;
    private n dgo;
    private int dgq = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    boolean dgr = false;
    private final int dgz;
    private long startTime = 0;

    static /* synthetic */ void a(d dVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        j KT = j.KT();
        k.KV();
        KT.a(com_tencent_mm_modelcdntran_keep_SceneResult, o.lc(dVar.aST));
    }

    private boolean KL() {
        if (m.fo(this.dgo.Ld())) {
            v.w("MicroMsg.NetSceneUploadVideo", "cdntra not use cdn user:%s", this.dgo.Ld());
            return false;
        }
        com.tencent.mm.modelcdntran.g.DZ();
        if (com.tencent.mm.modelcdntran.c.fk(2) || this.dgo.dhP == 1) {
            this.cMU = com.tencent.mm.modelcdntran.d.a("upvideo", this.dgo.dhH, this.dgo.Ld(), this.dgo.getFileName());
            if (be.kS(this.cMU)) {
                v.w("MicroMsg.NetSceneUploadVideo", "cdntra genClientId failed not use cdn file:%s", this.dgo.getFileName());
                return false;
            }
            k.KV();
            String ld = o.ld(this.aST);
            k.KV();
            String lc = o.lc(this.aST);
            h hVar = new h();
            hVar.cFR = this.cNe;
            hVar.field_mediaId = this.cMU;
            hVar.field_fullpath = lc;
            hVar.field_thumbpath = kU(ld);
            hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
            hVar.field_enable_hitcheck = this.cNm;
            hVar.field_largesvideo = com.tencent.mm.modelcontrol.d.En().iw(lc);
            if (this.dgo != null && 3 == this.dgo.dhR) {
                hVar.field_smallVideoFlag = 1;
            }
            String str = "MicroMsg.NetSceneUploadVideo";
            String str2 = "%d upload video MMSightExtInfo is null? %b %s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            objArr[1] = Boolean.valueOf(this.dgo.dhU == null);
            objArr[2] = this.aST;
            v.i(str, str2, objArr);
            if (this.dgo.dhU != null && this.dgo.dhU.mHd) {
                v.i("MicroMsg.NetSceneUploadVideo", "local capture video, mark use large video");
                j KT = j.KT();
                str = SQLiteDatabase.KeyEmpty;
                k.KV();
                KT.a(str, o.lc(this.aST), this.dgo.Ld(), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 2, 2);
                hVar.field_largesvideo = true;
            }
            str = "MicroMsg.NetSceneUploadVideo";
            str2 = "checkAD file:%s adinfo:%s";
            objArr = new Object[2];
            objArr[0] = this.dgo.getFileName();
            objArr[1] = this.dgo.dhT == null ? "null" : this.dgo.dhT.cqm;
            v.i(str, str2, objArr);
            if (!(this.dgo.dhT == null || be.kS(this.dgo.dhT.cqm))) {
                hVar.field_advideoflag = 1;
            }
            hVar.field_talker = this.dgo.Ld();
            hVar.field_chattype = m.dE(this.dgo.Ld()) ? 1 : 0;
            hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
            hVar.field_needStorage = false;
            hVar.field_isStreamMedia = false;
            hVar.field_trysafecdn = true;
            this.dgG = e.aQ(hVar.field_fullpath);
            this.dgF = e.aQ(hVar.field_thumbpath);
            if (this.dgF >= com.tencent.mm.modelcdntran.b.cEP) {
                v.w("MicroMsg.NetSceneUploadVideo", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", hVar.field_thumbpath, Integer.valueOf(this.dgF));
                return false;
            }
            int i;
            Map q = bf.q(this.dgo.Lg(), "msg");
            if (q != null) {
                hVar.field_fileId = (String) q.get(".msg.videomsg.$cdnvideourl");
                hVar.field_aesKey = (String) q.get(".msg.videomsg.$aeskey");
                this.dgE = true;
            } else {
                v.i("MicroMsg.NetSceneUploadVideo", "cdntra parse video recv xml failed");
                try {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    String[] split;
                    String[] split2 = be.ma(com.tencent.mm.h.j.sU().getValue("UseVideoHash")).split(",");
                    ak.yW();
                    int aq = com.tencent.mm.a.h.aq(com.tencent.mm.model.c.ww(), 100);
                    boolean z4 = (split2 == null || split2.length <= 0) ? false : be.getInt(split2[0], 0) >= aq;
                    boolean z5 = (split2 == null || split2.length < 2) ? false : be.getInt(split2[1], 0) >= aq;
                    boolean z6 = (split2 == null || split2.length < 3) ? false : be.getInt(split2[2], 0) >= aq;
                    if (com.tencent.mm.sdk.b.b.bsI()) {
                        z = true;
                        z2 = true;
                        z3 = true;
                    } else {
                        z = z5;
                        z2 = z4;
                        z3 = z6;
                    }
                    if (z2) {
                        o KV = k.KV();
                        v.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(be.getInt(split2[2], 0)), lc, be.bur());
                        long Ni = be.Ni();
                        if (be.kS(lc)) {
                            v.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", lc);
                            ld = SQLiteDatabase.KeyEmpty;
                        } else {
                            int[] lf = o.lf(lc);
                            if (lf == null || lf.length < 33) {
                                v.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", lc);
                                ld = SQLiteDatabase.KeyEmpty;
                            } else {
                                int i2;
                                KV.cuX.dF("VideoHash", "delete from VideoHash where CreateTime < " + (be.Nh() - 432000));
                                int i3 = lf[32];
                                StringBuffer stringBuffer = new StringBuffer();
                                for (i = 0; i < 32; i++) {
                                    stringBuffer.append(Integer.toHexString(lf[i]));
                                }
                                int length = stringBuffer.length();
                                Vector vector = new Vector();
                                Vector vector2 = new Vector();
                                Vector vector3 = new Vector();
                                Vector vector4 = new Vector();
                                int i4 = -1;
                                Cursor rawQuery = KV.cuX.rawQuery("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = " + i3, null);
                                while (rawQuery.moveToNext()) {
                                    long j = rawQuery.getLong(1);
                                    String string = rawQuery.getString(2);
                                    String string2 = rawQuery.getString(3);
                                    String string3 = rawQuery.getString(4);
                                    v.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                    if (be.kS(string) || be.kS(string2)) {
                                        g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_NO_SCRN_DSCR), Integer.valueOf(i3));
                                        v.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                    } else if (length != string.length()) {
                                        g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_NO_IMAG_DSCR), Integer.valueOf(i3));
                                        v.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
                                    } else {
                                        i2 = 0;
                                        aq = 0;
                                        while (aq < length) {
                                            if (stringBuffer.charAt(aq) == string.charAt(aq)) {
                                                i = i2 + 1;
                                            } else {
                                                i = i2;
                                            }
                                            aq++;
                                            i2 = i;
                                        }
                                        if (i4 < 0 || vector3.size() <= i4 || ((Integer) vector3.get(i4)).intValue() < i2) {
                                            i = vector3.size();
                                        } else {
                                            i = i4;
                                        }
                                        vector3.add(Integer.valueOf(i2));
                                        vector.add(string2);
                                        vector2.add(string3);
                                        vector4.add(Long.valueOf(j));
                                        v.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(i2), Integer.valueOf(length), vector3.get(i), Integer.valueOf(i), Integer.valueOf(vector3.size()));
                                        i4 = i;
                                    }
                                }
                                rawQuery.close();
                                if (i4 < 0 || vector3.size() <= 0) {
                                    g.iuh.h(12696, Integer.valueOf(201), Integer.valueOf(i3));
                                    v.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i4), Integer.valueOf(vector3.size()));
                                    ld = SQLiteDatabase.KeyEmpty;
                                } else {
                                    int intValue = ((Integer) vector3.get(i4)).intValue();
                                    length = (intValue * 100) / FileUtils.S_IRUSR;
                                    if (length < 77) {
                                        g.iuh.h(12696, Integer.valueOf(202), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()));
                                        v.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(be.ay(Ni)), Integer.valueOf(intValue), Integer.valueOf(length), Integer.valueOf(lf.length - 1), lc);
                                        ld = SQLiteDatabase.KeyEmpty;
                                    } else {
                                        str2 = be.ma((String) vector.get(i4));
                                        i2 = 0;
                                        int i5 = 0;
                                        while (i5 < vector3.size()) {
                                            if (i5 == i4 || ((Integer) vector3.get(i5)).intValue() < intValue || str2.hashCode() == ((String) vector.get(i5)).hashCode()) {
                                                i = i2;
                                            } else {
                                                i = i2 + 1;
                                            }
                                            i5++;
                                            i2 = i;
                                        }
                                        if (i2 > 0) {
                                            KV.cuX.dF("VideoHash", "delete from VideoHash where size = " + i3);
                                            g.iuh.h(12696, Integer.valueOf(203), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()), Integer.valueOf(0), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, Integer.valueOf(i2));
                                            v.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(i2), lc);
                                            ld = SQLiteDatabase.KeyEmpty;
                                        } else {
                                            Ni = be.ay(Ni);
                                            long a = be.a((Long) vector4.get(i4), 0);
                                            g.iuh.h(12696, Integer.valueOf(SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD), String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(intValue), Long.valueOf(a), Integer.valueOf(vector4.size()), Long.valueOf(Ni)}));
                                            g.iuh.h(12696, Integer.valueOf(length + 3000), r5);
                                            v.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(Ni), Integer.valueOf(intValue), Integer.valueOf(length), Long.valueOf(a), lc, str2, vector2.get(i4));
                                            ld = (String) vector2.get(i4);
                                            z4 = be.Ni() % 1000 < ((long) (r14 * 10)) || length < 90;
                                            v.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z4), Long.valueOf(Ni), Integer.valueOf(r14), Integer.valueOf(length), Boolean.valueOf(com.tencent.mm.sdk.b.b.bsI()));
                                            if (z4 || com.tencent.mm.sdk.b.b.bsI()) {
                                                com.tencent.mm.sdk.i.e.b(new com.tencent.mm.as.o.AnonymousClass2(KV, lc, ld, r5), "checkVideoHashByteDiff", 1);
                                            }
                                            ld = str2;
                                        }
                                    }
                                }
                            }
                        }
                        if (!be.kS(ld)) {
                            split = ld.split("##");
                            if (z && split != null && split.length == 2) {
                                hVar.field_fileId = split[0];
                                hVar.field_aesKey = split[1];
                                this.dgD = true;
                            }
                            v.i("MicroMsg.NetSceneUploadVideo", "CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", Boolean.valueOf(com.tencent.mm.sdk.b.b.bsI()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.dgD), hVar.field_fileId, hVar.field_aesKey);
                        }
                    }
                    split = null;
                    hVar.field_fileId = split[0];
                    hVar.field_aesKey = split[1];
                    this.dgD = true;
                    v.i("MicroMsg.NetSceneUploadVideo", "CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", Boolean.valueOf(com.tencent.mm.sdk.b.b.bsI()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.dgD), hVar.field_fileId, hVar.field_aesKey);
                } catch (Throwable e) {
                    v.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", be.e(e));
                }
            }
            g gVar = g.iuh;
            objArr = new Object[2];
            i = this.dgD ? 1 : this.dgE ? 2 : 0;
            objArr[0] = Integer.valueOf(i + 700);
            objArr[1] = Integer.valueOf(this.dgo.cyu);
            gVar.h(12696, objArr);
            v.i("MicroMsg.NetSceneUploadVideo", "summersafecdn check hit cache VideoHash :%s %s %s %b %b", hVar.field_mediaId, hVar.field_fileId, hVar.field_aesKey, Boolean.valueOf(this.cNm), Boolean.valueOf(hVar.field_largesvideo));
            if (com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                if (this.dgo.dhP != 1) {
                    this.dgo.dhP = 1;
                    this.dgo.status = MMGIFException.D_GIF_ERR_NO_SCRN_DSCR;
                    this.dgo.clientId = this.cMU;
                    this.dgo.bkU = 524544;
                    p.e(this.dgo);
                }
                return true;
            }
            g.iuh.a(111, 226, 1, false);
            v.e("MicroMsg.NetSceneUploadVideo", "cdntra addSendTask failed.");
            this.cMU = SQLiteDatabase.KeyEmpty;
            return false;
        }
        r4 = new Object[2];
        com.tencent.mm.modelcdntran.g.DZ();
        r4[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(2));
        r4[1] = Integer.valueOf(this.dgo.dhP);
        v.w("MicroMsg.NetSceneUploadVideo", "cdntra not use cdn flag:%b getCdnInfo:%d", r4);
        return false;
    }

    public d(String str) {
        boolean z = true;
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        v.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:" + str);
        this.aST = str;
        this.dgo = p.lp(str);
        if (this.dgo != null) {
            this.dgz = 2500;
        } else {
            this.dgz = 0;
        }
        this.cQT = new com.tencent.mm.compatible.util.g.a();
        if (this.dgo != null && 3 == this.dgo.dhR) {
            this.dgq = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        v.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  videoType:" + this.dgq);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        this.dgo = p.lp(this.aST);
        if (this.dgo == null || !(this.dgo.status == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR || this.dgo.status == MMGIFException.D_GIF_ERR_NOT_GIF_FILE)) {
            v.e("MicroMsg.NetSceneUploadVideo", "Get info Failed file:" + this.aST);
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.aST).append(" stat:").append(this.dgo.status).append(" [").append(this.dgo.dhF).append(",").append(this.dgo.dhG).append("] [").append(this.dgo.dgC).append(",").append(this.dgo.cyu).append("]  netTimes:").append(this.dgo.dhM).append(" times:");
        int i = this.dgH;
        this.dgH = i + 1;
        v.d("MicroMsg.NetSceneUploadVideo", append.append(i).toString());
        if (this.startTime == 0) {
            this.startTime = be.Ni();
            this.dgC = this.dgo.dgC;
        }
        if (KL()) {
            v.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.aST);
            return 0;
        }
        String aX;
        if (this.dgo.dhO == 1) {
            this.dgB = true;
        } else if (this.dgo.dhH + 600 < be.Nh()) {
            v.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.aST);
            p.lh(this.aST);
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        } else if (!p.lg(this.aST)) {
            v.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.aST);
            p.lh(this.aST);
            this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.czn = new bco();
        aVar.czo = new bcp();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.czm = 149;
        aVar.czp = 39;
        aVar.czq = 1000000039;
        this.cif = aVar.Bv();
        bco com_tencent_mm_protocal_c_bco = (bco) this.cif.czk.czs;
        ak.yW();
        com_tencent_mm_protocal_c_bco.gon = (String) com.tencent.mm.model.c.vf().get(2, SQLiteDatabase.KeyEmpty);
        com_tencent_mm_protocal_c_bco.gom = this.dgo.Ld();
        com_tencent_mm_protocal_c_bco.mcN = this.aST;
        if (this.dgB) {
            com_tencent_mm_protocal_c_bco.mYn = 2;
        }
        if (this.dgo.dhR == 3) {
            com_tencent_mm_protocal_c_bco.mYn = 3;
        }
        com_tencent_mm_protocal_c_bco.mYm = this.dgo.dhK;
        com_tencent_mm_protocal_c_bco.mHA = this.dgo.dhG;
        com_tencent_mm_protocal_c_bco.mYj = this.dgo.cyu;
        com_tencent_mm_protocal_c_bco.mpt = com.tencent.mm.network.aa.bk(aa.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bco.mHD = 2;
        com_tencent_mm_protocal_c_bco.mYk = 0;
        com_tencent_mm_protocal_c_bco.mYl = new are().ba(new byte[0]);
        com_tencent_mm_protocal_c_bco.mHC = new are().ba(new byte[0]);
        if (be.kS(this.bov)) {
            k.KV();
            aX = com.tencent.mm.a.g.aX(o.lc(this.aST));
            this.bov = aX;
        } else {
            aX = this.bov;
        }
        com_tencent_mm_protocal_c_bco.mYq = aX;
        com_tencent_mm_protocal_c_bco.mbZ = ax.zr();
        com_tencent_mm_protocal_c_bco.mYz = this.dgo.bnY;
        ayk com_tencent_mm_protocal_c_ayk = this.dgo.dhT;
        if (com_tencent_mm_protocal_c_ayk != null && !be.kS(com_tencent_mm_protocal_c_ayk.cqg)) {
            com_tencent_mm_protocal_c_bco.mYr = be.ah(com_tencent_mm_protocal_c_ayk.cqg, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYs = com_tencent_mm_protocal_c_ayk.mtD;
            com_tencent_mm_protocal_c_bco.mYt = be.ah(com_tencent_mm_protocal_c_ayk.cqi, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYv = be.ah(com_tencent_mm_protocal_c_ayk.cqk, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYu = be.ah(com_tencent_mm_protocal_c_ayk.cqj, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYw = be.ah(com_tencent_mm_protocal_c_ayk.cql, SQLiteDatabase.KeyEmpty);
        } else if (!(com_tencent_mm_protocal_c_ayk == null || be.kS(com_tencent_mm_protocal_c_ayk.cqk) || be.kS(com_tencent_mm_protocal_c_ayk.cqj))) {
            com_tencent_mm_protocal_c_bco.mYv = com_tencent_mm_protocal_c_ayk.cqk;
            com_tencent_mm_protocal_c_bco.mYu = com_tencent_mm_protocal_c_ayk.cqj;
        }
        if (com_tencent_mm_protocal_c_ayk != null) {
            com_tencent_mm_protocal_c_bco.mYy = be.ah(com_tencent_mm_protocal_c_ayk.cqm, SQLiteDatabase.KeyEmpty);
            com_tencent_mm_protocal_c_bco.mYx = be.ah(com_tencent_mm_protocal_c_ayk.cqn, SQLiteDatabase.KeyEmpty);
        }
        v.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(com_tencent_mm_protocal_c_bco.mYm), Integer.valueOf(com_tencent_mm_protocal_c_bco.mHB), Integer.valueOf(com_tencent_mm_protocal_c_bco.mYj), Integer.valueOf(com_tencent_mm_protocal_c_bco.mYn), com_tencent_mm_protocal_c_bco.mYq, com_tencent_mm_protocal_c_bco.mYr, Integer.valueOf(com_tencent_mm_protocal_c_bco.mYs), com_tencent_mm_protocal_c_bco.mYt, com_tencent_mm_protocal_c_bco.mYw);
        o.b e;
        Object obj;
        if (this.dgo.status == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
            k.KV();
            e = o.e(o.ld(this.aST), this.dgo.dhF, dgy);
            if (e.ret < 0 || e.aUT == 0) {
                g.iuh.a(111, 225, 1, false);
                p.lh(this.aST);
                v.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.aST + "]  Error ");
                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                return -1;
            }
            v.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.aST + "] read ret:" + e.ret + " readlen:" + e.aUT + " newOff:" + e.dik + " netOff:" + this.dgo.dhF);
            if (e.dik < this.dgo.dhF) {
                v.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.aST + "] newOff:" + e.dik + " OldtOff:" + this.dgo.dhF);
                p.lh(this.aST);
                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                return -1;
            }
            obj = new byte[e.aUT];
            System.arraycopy(e.buf, 0, obj, 0, e.aUT);
            com_tencent_mm_protocal_c_bco.mHB = this.dgo.dhF;
            com_tencent_mm_protocal_c_bco.mHC = new are().ba(obj);
        } else {
            k.KV();
            e = o.e(o.lc(this.aST), this.dgo.dgC, dgy);
            if (e.ret < 0 || e.aUT == 0) {
                g.iuh.a(111, 224, 1, false);
                p.lh(this.aST);
                v.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.aST + "]  Error ");
                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                return -1;
            }
            v.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.aST + "] read ret:" + e.ret + " readlen:" + e.aUT + " newOff:" + e.dik + " netOff:" + this.dgo.dgC);
            if (e.dik < this.dgo.dgC) {
                v.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.aST + "] newOff:" + e.dik + " OldtOff:" + this.dgo.dgC);
                p.lh(this.aST);
                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                return -1;
            } else if (e.dik >= 20971520) {
                g.iuh.a(111, 222, 1, false);
                v.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.aST + "] maxsize:20971520");
                p.lh(this.aST);
                this.aYJ = 0 - (com.tencent.mm.compatible.util.g.sk() + 10000);
                return -1;
            } else {
                obj = new byte[e.aUT];
                System.arraycopy(e.buf, 0, obj, 0, e.aUT);
                com_tencent_mm_protocal_c_bco.mYk = this.dgo.dgC;
                com_tencent_mm_protocal_c_bco.mHB = this.dgo.dhF;
                com_tencent_mm_protocal_c_bco.mYl = new are().ba(obj);
            }
        }
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        bco com_tencent_mm_protocal_c_bco = (bco) ((b) pVar).czk.czs;
        if (!be.kS(com_tencent_mm_protocal_c_bco.mcN) && com_tencent_mm_protocal_c_bco.mHD > 0 && !be.kS(com_tencent_mm_protocal_c_bco.gon) && !be.kS(com_tencent_mm_protocal_c_bco.gom) && com_tencent_mm_protocal_c_bco.mpt > 0 && com_tencent_mm_protocal_c_bco.mHB <= com_tencent_mm_protocal_c_bco.mHA && com_tencent_mm_protocal_c_bco.mHB >= 0 && com_tencent_mm_protocal_c_bco.mYk <= com_tencent_mm_protocal_c_bco.mYj && com_tencent_mm_protocal_c_bco.mYk >= 0 && ((com_tencent_mm_protocal_c_bco.mYk != com_tencent_mm_protocal_c_bco.mYj || com_tencent_mm_protocal_c_bco.mHB != com_tencent_mm_protocal_c_bco.mHA) && com_tencent_mm_protocal_c_bco.mHA > 0 && com_tencent_mm_protocal_c_bco.mYj > 0 && (com_tencent_mm_protocal_c_bco.mYl.mQu > 0 || com_tencent_mm_protocal_c_bco.mHC.mQu > 0))) {
            return b.czU;
        }
        v.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.aST + " user:" + com_tencent_mm_protocal_c_bco.gom);
        return b.czV;
    }

    protected final int ul() {
        return this.dgz;
    }

    protected final void a(a aVar) {
        g.iuh.a(111, 221, 1, false);
        p.lh(this.aST);
    }

    public final boolean BA() {
        boolean BA = super.BA();
        if (BA) {
            g.iuh.a(111, 210, 1, false);
        }
        return BA;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.cMU);
        if (this.dgr) {
            v.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.aST + " user:" + this.dgo.Ld());
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !be.kS(this.cMU)) {
            v.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.cMU);
        } else {
            bcp com_tencent_mm_protocal_c_bcp = (bcp) ((b) pVar).czl.czs;
            bco com_tencent_mm_protocal_c_bco = (bco) ((b) pVar).czk.czs;
            this.dgo = p.lp(this.aST);
            if (this.dgo == null) {
                v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.aST);
                this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                this.cii.a(i2, i3, str, this);
            } else if (this.dgo.status == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                v.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                this.cii.a(i2, i3, str, this);
            } else if (this.dgo.status != MMGIFException.D_GIF_ERR_NO_SCRN_DSCR && this.dgo.status != MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.dgo.status + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                this.cii.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 == -22) {
                v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.aST + " user:" + this.dgo.Ld());
                p.li(this.aST);
                this.cii.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                g.iuh.a(111, 220, 1, false);
                v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.aST + " user:" + this.dgo.Ld());
                p.lh(this.aST);
                g.iuh.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext())), Integer.valueOf(this.dgq), Integer.valueOf(0));
                this.cii.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                g.iuh.a(111, 219, 1, false);
                v.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.aST + " user:" + this.dgo.Ld());
                this.cii.a(i2, i3, str, this);
            } else if (!be.bl(com_tencent_mm_protocal_c_bco.mHC.mQw.lVU) && com_tencent_mm_protocal_c_bco.mHB != com_tencent_mm_protocal_c_bcp.mHB - com_tencent_mm_protocal_c_bco.mHC.mQu) {
                v.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + com_tencent_mm_protocal_c_bco.mHB + "," + com_tencent_mm_protocal_c_bco.mHC.mQu + "," + com_tencent_mm_protocal_c_bcp.mHB + "] file:" + this.aST + " user:" + com_tencent_mm_protocal_c_bco.gom);
                p.lh(this.aST);
                this.cii.a(i2, i3, str, this);
            } else if (be.bl(com_tencent_mm_protocal_c_bco.mYl.mQw.lVU) || com_tencent_mm_protocal_c_bco.mYk == com_tencent_mm_protocal_c_bcp.mYk - com_tencent_mm_protocal_c_bco.mYl.mQu) {
                this.dgo.dhI = be.Nh();
                this.dgo.bmL = com_tencent_mm_protocal_c_bcp.mcb;
                this.dgo.bkU = 1028;
                v.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.dgo.bmL), Integer.valueOf(q.dqk));
                if (!(10007 != q.dqj || q.dqk == 0 || this.dgo.bmL == 0)) {
                    this.dgo.bmL = (long) q.dqk;
                    q.dqk = 0;
                }
                Object obj = null;
                int i4 = this.dgo.status;
                if (i4 == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                    this.dgo.dhF = com_tencent_mm_protocal_c_bco.mHC.mQu + com_tencent_mm_protocal_c_bco.mHB;
                    this.dgo.bkU |= 64;
                    if (this.dgo.dhF >= this.dgo.dhG) {
                        this.dgo.status = MMGIFException.D_GIF_ERR_NO_SCRN_DSCR;
                        this.dgo.bkU |= FileUtils.S_IRUSR;
                    }
                } else if (i4 == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR) {
                    this.dgo.dgC = com_tencent_mm_protocal_c_bco.mYl.mQu + com_tencent_mm_protocal_c_bco.mYk;
                    this.dgo.bkU |= 8;
                    if (this.dgo.dgC >= this.dgo.cyu) {
                        this.dgo.status = 199;
                        this.dgo.bkU |= FileUtils.S_IRUSR;
                        p.c(this.dgo);
                        obj = 1;
                    }
                } else {
                    v.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i4 + " file:" + this.aST + " user:" + com_tencent_mm_protocal_c_bco.gom);
                    p.lh(this.aST);
                    this.cii.a(i2, i3, str, this);
                    return;
                }
                p.e(this.dgo);
                if (this.dgr) {
                    this.cii.a(i2, i3, str, this);
                } else if (obj == null) {
                    this.cxS.ea(10);
                } else {
                    boolean z;
                    ak.yW();
                    com.tencent.mm.modelstat.b.daJ.p(com.tencent.mm.model.c.wJ().ek((long) this.dgo.dhL));
                    g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext())), Integer.valueOf(this.dgq), Integer.valueOf(this.dgo.cyu - this.dgC));
                    if (this.dgo == null) {
                        z = false;
                    } else {
                        ak.yW();
                        com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(this.dgo.Ld());
                        z = (LX == null || ((int) LX.chr) <= 0) ? false : LX.bvm();
                    }
                    if (z || m.eP(this.dgo.Ld())) {
                        v.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.dgo.Ld());
                        if (this.dgo.bmL < 0) {
                            v.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.dgo.bmL + " file:" + this.aST + " toUser:" + this.dgo.Ld());
                            p.lh(this.aST);
                        }
                    } else {
                        v.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                        if (this.dgo.bmL <= 0) {
                            v.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.dgo.bmL + " file:" + this.aST + " toUser:" + this.dgo.Ld());
                            p.lh(this.aST);
                        }
                    }
                    long sn = this.cQT != null ? this.cQT.sn() : 0;
                    v.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.aST + " toUser:" + this.dgo.Ld() + " msgsvrid:" + this.dgo.bmL + " thumbsize:" + this.dgo.dhG + " videosize:" + this.dgo.cyu + " useTime:" + sn);
                    v.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.aST + " packSize:" + dgy + " filesize:" + this.dgo.cyu + " useTime:" + sn);
                    c.a(this.dgo, 0);
                    this.cii.a(i2, i3, str, this);
                }
            } else {
                v.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + com_tencent_mm_protocal_c_bco.mYk + "," + com_tencent_mm_protocal_c_bco.mYl.mQu + "," + com_tencent_mm_protocal_c_bcp.mYk + "] file:" + this.aST + " user:" + com_tencent_mm_protocal_c_bco.gom);
                p.lh(this.aST);
                this.cii.a(i2, i3, str, this);
            }
        }
    }

    public final int getType() {
        return 149;
    }

    private static String kU(String str) {
        boolean z;
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable e;
        File file = new File(str);
        File file2 = new File(file.getParentFile(), "send" + file.getName());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        v.d("MicroMsg.NetSceneUploadVideo", "getSendThumbnailPath:origin file: %d", Long.valueOf(file.length()));
        try {
            if (file.length() <= 32768) {
                z = false;
            } else if (file2.exists()) {
                v.d("MicroMsg.NetSceneUploadVideo", "dst file %s exist!", file2.getAbsolutePath());
                z = true;
            } else {
                Options JS = com.tencent.mm.sdk.platformtools.d.JS(file.getAbsolutePath());
                String str2 = "MicroMsg.NetSceneUploadVideo";
                String str3 = "getSendThumbnailPath:options %s";
                Object[] objArr = new Object[1];
                objArr[0] = JS == null ? "null" : JS.outWidth + "-" + JS.outHeight;
                v.i(str2, str3, objArr);
                if (JS == null || (JS.outWidth <= 288 && JS.outHeight <= 288)) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(fileInputStream, 0.0f, 288, 288);
                        if (a != null) {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                z = a.compress(CompressFormat.JPEG, 60, fileOutputStream);
                                outputStream = fileOutputStream;
                                inputStream = fileInputStream;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    v.e("MicroMsg.NetSceneUploadVideo", "exception: %s", be.e(e));
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            z = false;
                                        } catch (IOException e4) {
                                            z = false;
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        v.i("MicroMsg.NetSceneUploadVideo", "compress success: length=%d | path=%s", Long.valueOf(file2.length()), file2.getAbsolutePath());
                                        return file2.getAbsolutePath();
                                    }
                                    v.i("MicroMsg.NetSceneUploadVideo", "compress fail: origin length=%d | path=%s", Long.valueOf(file.length()), file.getAbsolutePath());
                                    return str;
                                } catch (Throwable th) {
                                    e = th;
                                    outputStream = fileOutputStream;
                                    inputStream = fileInputStream;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    throw e;
                                }
                            }
                        }
                        z = false;
                        inputStream = fileInputStream;
                    } catch (Exception e7) {
                        e = e7;
                        fileOutputStream = null;
                        v.e("MicroMsg.NetSceneUploadVideo", "exception: %s", be.e(e));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            z = false;
                        } else {
                            fileOutputStream.close();
                            z = false;
                        }
                        if (z) {
                            v.i("MicroMsg.NetSceneUploadVideo", "compress success: length=%d | path=%s", Long.valueOf(file2.length()), file2.getAbsolutePath());
                            return file2.getAbsolutePath();
                        }
                        v.i("MicroMsg.NetSceneUploadVideo", "compress fail: origin length=%d | path=%s", Long.valueOf(file.length()), file.getAbsolutePath());
                        return str;
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw e;
                    }
                }
                z = com.tencent.mm.sdk.platformtools.d.a(file.getAbsolutePath(), 288, 288, CompressFormat.JPEG, 60, file2.getParentFile().getAbsolutePath() + "/", file2.getName());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            fileInputStream = null;
            v.e("MicroMsg.NetSceneUploadVideo", "exception: %s", be.e(e));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                z = false;
            } else {
                z = false;
            }
            if (z) {
                v.i("MicroMsg.NetSceneUploadVideo", "compress fail: origin length=%d | path=%s", Long.valueOf(file.length()), file.getAbsolutePath());
                return str;
            }
            v.i("MicroMsg.NetSceneUploadVideo", "compress success: length=%d | path=%s", Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
        if (z) {
            v.i("MicroMsg.NetSceneUploadVideo", "compress success: length=%d | path=%s", Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        }
        v.i("MicroMsg.NetSceneUploadVideo", "compress fail: origin length=%d | path=%s", Long.valueOf(file.length()), file.getAbsolutePath());
        return str;
    }
}
