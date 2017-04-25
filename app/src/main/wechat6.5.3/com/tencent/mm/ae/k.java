package com.tencent.mm.ae;

import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.ku;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.i;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelstat.g;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bci;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.protocal.c.ij;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.r;
import com.tencent.mm.v.t;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Map;
import junit.framework.Assert;

public final class k extends com.tencent.mm.v.k implements j {
    public static boolean DEBUG = true;
    private static long cNF;
    private String TAG;
    public at aXd;
    private float bhs;
    public String bob;
    private long cLC;
    private int cLy;
    private final f cMP;
    public long cMQ;
    private long cMR;
    private g cMT;
    private String cMU;
    private int cMV;
    private int cMY;
    private int cNA;
    private keep_SceneResult cNB;
    private boolean cNC;
    private c cND;
    private c cNE;
    private com.tencent.mm.modelcdntran.h.a cNe;
    private String cNk;
    private String cNl;
    private boolean cNm;
    private d cNn;
    private d cNo;
    private int cNp;
    b cNq;
    private String cNr;
    private boolean cNs;
    private float cNt;
    private String cNu;
    private String cNv;
    private int cNw;
    private String cNx;
    private boolean cNy;
    private String cNz;
    private final com.tencent.mm.v.b cif;
    private e cii;
    private int scene;
    private int startOffset;
    private long startTime;

    public interface a {
        void Gu();
    }

    private class b {
        final /* synthetic */ k cNH;
        public a cNK;

        final void Gu() {
            d d;
            if (this.cNH.cMQ == this.cNH.cMR) {
                d = this.cNH.Gv();
            } else {
                d = this.cNH.Gw();
            }
            if (d.cLG == 1) {
                com.tencent.mm.plugin.report.service.f.oS(23);
                com.tencent.mm.plugin.report.service.f.oS(21);
            }
            if (n.GH().a(Long.valueOf(this.cNH.cMR), this.cNH.Gv()) < 0) {
                v.e(this.cNH.TAG, "update db failed local id:" + this.cNH.cMR + " server id:" + this.cNH.Gv().bmL);
                h.fG((int) this.cNH.cMQ);
                h.fF((int) this.cNH.cMQ);
                this.cNH.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this.cNH);
            }
            if (this.cNH.cMR != this.cNH.cMQ) {
                n.GH().a(Long.valueOf(this.cNH.cMQ), this.cNH.Gw());
            }
            ad.o(new Runnable(this.cNH, this.cNH.cMR) {
                final /* synthetic */ k cNH;

                public final void run() {
                    m.Gy().cNN.remove(Long.valueOf(r2));
                }
            });
            if (this.cNH.cMQ != this.cNH.cMR) {
                ad.o(/* anonymous class already generated */);
            }
            if (this.cNK != null) {
                this.cNK.Gu();
            }
            this.cNH.fH(this.cNH.cLy);
            this.cNH.cNq = null;
        }

        public b(k kVar, a aVar) {
            this.cNH = kVar;
            this.cNK = aVar;
        }
    }

    static /* synthetic */ void K(k kVar) {
        com.tencent.mm.sdk.c.a.nhr.f(kVar.cND);
        com.tencent.mm.sdk.c.a.nhr.f(kVar.cNE);
    }

    private d Gv() {
        if (this.cNn == null) {
            this.cNn = n.GH().b(Long.valueOf(this.cMR));
        }
        return this.cNn;
    }

    private d Gw() {
        if (this.cNo == null) {
            this.cNo = n.GH().b(Long.valueOf(this.cMQ));
        }
        return this.cNo;
    }

    public k(String str, String str2, String str3, int i) {
        this(4, str, str2, str3, i, null, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
    }

    public k(int i, String str, String str2, String str3, int i2, f fVar, int i3, a aVar, int i4) {
        this(3, str, str2, str3, i2, fVar, i3, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, 2130837922);
        this.cNq = new b(this, aVar);
    }

    private k(int i, String str, String str2, String str3, int i2, f fVar, String str4, String str5) {
        this(4, str, str2, str3, i2, null, 0, str4, str5, false, -1);
    }

    public k(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4) {
        this(i, str, str2, str3, i2, fVar, i3, str4, str5, z, i4, 0, -1000.0f, -1000.0f);
    }

    public k(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4, int i5, float f, float f2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.cNk = SQLiteDatabase.KeyEmpty;
        this.cNl = SQLiteDatabase.KeyEmpty;
        this.cNm = true;
        this.cNp = 16384;
        this.cLy = 0;
        this.aXd = null;
        this.cMT = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startTime = 0;
        this.startOffset = -1;
        this.cMV = 0;
        this.cNq = new b(this, null);
        this.cNe = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ k cNH;

            {
                this.cNH = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                Throwable th;
                v.d(this.cNH.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.cNH.cMU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
                if (i == -21005) {
                    v.w(this.cNH.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.cNH.cMU);
                    if (this.cNH.cNq != null) {
                        this.cNH.cNq.Gu();
                    }
                    this.cNH.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.cNH);
                    return 0;
                } else if (i != 0) {
                    v.e(this.cNH.TAG, "cdntra cdnCallback clientid:%s startRet:%d", this.cNH.cMU, Integer.valueOf(i));
                    h.fG((int) this.cNH.cMQ);
                    h.fF((int) this.cNH.cMQ);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        r1 = com.tencent.mm.plugin.report.service.g.iuh;
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Long.valueOf(this.cNH.startTime);
                        objArr[3] = Long.valueOf(be.Ni());
                        objArr[4] = Integer.valueOf(d.aO(aa.getContext()));
                        objArr[5] = Integer.valueOf(this.cNH.cMV);
                        objArr[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                        objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                        objArr[8] = SQLiteDatabase.KeyEmpty;
                        objArr[9] = SQLiteDatabase.KeyEmpty;
                        objArr[10] = SQLiteDatabase.KeyEmpty;
                        objArr[11] = SQLiteDatabase.KeyEmpty;
                        objArr[12] = SQLiteDatabase.KeyEmpty;
                        objArr[13] = SQLiteDatabase.KeyEmpty;
                        objArr[14] = SQLiteDatabase.KeyEmpty;
                        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                            r0 = SQLiteDatabase.KeyEmpty;
                        } else {
                            r0 = k.iX(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        }
                        objArr[15] = r0;
                        r1.h(10421, objArr);
                    }
                    this.cNH.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.cNH);
                    if (this.cNH.cNq != null) {
                        this.cNH.cNq.Gu();
                    }
                    return 0;
                } else {
                    final d d = this.cNH.Gv();
                    if (d == null || d.cLu != this.cNH.cMR) {
                        com.tencent.mm.modelcdntran.g.DZ().ip(this.cNH.cMU);
                        v.e(this.cNH.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(this.cNH.cMR), this.cNH.cMU);
                        if (this.cNH.cNq != null) {
                            this.cNH.cNq.Gu();
                        }
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                        this.cNH.a(d, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, 0, 0, com_tencent_mm_modelcdntran_keep_SceneResult);
                        return 0;
                    } else {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            v.i(this.cNH.TAG, "dkupimg sceneResult:%s", com_tencent_mm_modelcdntran_keep_SceneResult);
                            bcj com_tencent_mm_protocal_c_bcj;
                            Object[] objArr2;
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                v.e(this.cNH.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", this.cNH.cMU, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult);
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == -21111) {
                                    v.w(this.cNH.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", this.cNH.cMU, Boolean.valueOf(this.cNH.cNm));
                                    ak.vA().x(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass4 cNI;

                                        public final void run() {
                                            this.cNI.cNH.cNm = false;
                                            this.cNI.cNH.startTime = 0;
                                            this.cNI.cNH.startOffset = 0;
                                            d d = this.cNI.cNH.Gv();
                                            d.fv(0);
                                            this.cNI.cNH.aXd.z(aw.fN(this.cNI.cNH.aXd.field_talker));
                                            this.cNI.cNH.cMU = d.a("upimg", this.cNI.cNH.aXd.field_createTime, this.cNI.cNH.aXd.field_talker, this.cNI.cNH.aXd.field_msgId + "_" + this.cNI.cNH.cMR + "_" + this.cNI.cNH.cLy);
                                            boolean a = this.cNI.cNH.a(d, 0, 0, 0, com_tencent_mm_modelcdntran_keep_SceneResult);
                                            bci com_tencent_mm_protocal_c_bci = (bci) this.cNI.cNH.cif.czk.czs;
                                            if (com_tencent_mm_protocal_c_bci == null) {
                                                v.w(this.cNI.cNH.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                com_tencent_mm_protocal_c_bci.mXW = new arf().JF(this.cNI.cNH.cMU);
                                            }
                                            v.i(this.cNI.cNH.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(this.cNI.cNH.cNm), Boolean.valueOf(a), this.cNI.cNH.cMU, Long.valueOf(this.cNI.cNH.aXd.field_createTime));
                                            this.cNI.cNH.a(this.cNI.cNH.czE, this.cNI.cNH.cii);
                                        }
                                    });
                                    return 0;
                                }
                                com_tencent_mm_protocal_c_bcj = null;
                                if (!be.bl(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf)) {
                                    com_tencent_mm_protocal_c_bcj = new bcj();
                                    try {
                                        com_tencent_mm_protocal_c_bcj.az(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf);
                                        v.d(this.cNH.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(com_tencent_mm_protocal_c_bcj.mQl.mcj), com_tencent_mm_protocal_c_bcj.mQl.mfD.toString());
                                    } catch (Throwable e) {
                                        th = e;
                                        com_tencent_mm_protocal_c_bcj = null;
                                        v.e(this.cNH.TAG, "UploadMsgImgResponse parse fail: %s", th);
                                        v.e(this.cNH.TAG, "exception:%s", be.e(th));
                                    } catch (Throwable e2) {
                                        th = e2;
                                        com_tencent_mm_protocal_c_bcj = null;
                                        v.e(this.cNH.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", th);
                                        v.e(this.cNH.TAG, "exception:%s", be.e(th));
                                    }
                                }
                                h.fG((int) this.cNH.cMQ);
                                h.fF((int) this.cNH.cMQ);
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                                objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr2[1] = Integer.valueOf(1);
                                objArr2[2] = Long.valueOf(this.cNH.startTime);
                                objArr2[3] = Long.valueOf(be.Ni());
                                objArr2[4] = Integer.valueOf(d.aO(aa.getContext()));
                                objArr2[5] = Integer.valueOf(this.cNH.cMV);
                                objArr2[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                                objArr2[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                objArr2[8] = SQLiteDatabase.KeyEmpty;
                                objArr2[9] = SQLiteDatabase.KeyEmpty;
                                objArr2[10] = SQLiteDatabase.KeyEmpty;
                                objArr2[11] = SQLiteDatabase.KeyEmpty;
                                objArr2[12] = SQLiteDatabase.KeyEmpty;
                                objArr2[13] = SQLiteDatabase.KeyEmpty;
                                objArr2[14] = SQLiteDatabase.KeyEmpty;
                                objArr2[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? SQLiteDatabase.KeyEmpty : k.iX(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                                gVar.h(10421, objArr2);
                                if (com_tencent_mm_protocal_c_bcj == null || com_tencent_mm_protocal_c_bcj.mQl.mcj == 0) {
                                    this.cNH.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.cNH);
                                } else {
                                    this.cNH.cii.a(4, com_tencent_mm_protocal_c_bcj.mQl.mcj, com_tencent_mm_protocal_c_bcj.mQl.mfD.toString(), this.cNH);
                                }
                                if (this.cNH.cNq != null) {
                                    this.cNH.cNq.Gu();
                                }
                            } else {
                                v.i(this.cNH.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField));
                                r1 = com.tencent.mm.plugin.report.service.g.iuh;
                                objArr2 = new Object[3];
                                objArr2[0] = Integer.valueOf(d.bbT == 0 ? 3 : d.bbT);
                                objArr2[1] = this.cNH.cNk;
                                objArr2[2] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType);
                                r1.h(13230, objArr2);
                                r0 = this.cNH.cNr;
                                if (be.kS(r0)) {
                                    r0 = (("<msg><img aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/></msg>";
                                    v.i(this.cNH.TAG, "cdn callback new build cdnInfo:%s", r0);
                                }
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
                                    if (be.kS(this.cNH.cNv)) {
                                        v.w(this.cNH.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        r0 = (("<msg><img aeskey=\"" + this.cNH.cNv + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + this.cNH.cNv + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/></msg>";
                                    }
                                }
                                d.iT(r0);
                                if (this.cNH.cMQ != this.cNH.cMR) {
                                    this.cNH.Gw().iT(r0);
                                }
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField) {
                                    ak.vy().a(new l(this.cNH.cNw, (bci) this.cNH.cif.czk.czs, d, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                                        final /* synthetic */ AnonymousClass4 cNI;

                                        public final void a(long j, int i, int i2, int i3) {
                                            com.tencent.mm.plugin.report.service.g.iuh.h(10421, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.cNI.cNH.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cNI.cNH.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, k.iX(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2));
                                            v.d(this.cNI.cNH.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", this.cNI.cNH.cMU, Integer.valueOf(i2), Integer.valueOf(i3));
                                            if (i2 == 0 && i3 == 0) {
                                                this.cNI.cNH.a(d, d.cyu, j, i, com_tencent_mm_modelcdntran_keep_SceneResult);
                                                return;
                                            }
                                            h.fG((int) this.cNI.cNH.cMQ);
                                            h.fF((int) this.cNI.cNH.cMQ);
                                            this.cNI.cNH.cii.a(i2, i3, SQLiteDatabase.KeyEmpty, this.cNI.cNH);
                                            if (this.cNI.cNH.cNq != null) {
                                                this.cNI.cNH.cNq.Gu();
                                            }
                                        }
                                    }), 0);
                                } else {
                                    com.tencent.mm.plugin.report.service.g.iuh.h(10421, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.cNH.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cNH.cMV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, k.iX(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2));
                                    com_tencent_mm_protocal_c_bcj = new bcj();
                                    try {
                                        com_tencent_mm_protocal_c_bcj.az(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf);
                                        long j = com_tencent_mm_protocal_c_bcj.mcb != 0 ? com_tencent_mm_protocal_c_bcj.mcb : (long) com_tencent_mm_protocal_c_bcj.mbT;
                                        v.d(this.cNH.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(com_tencent_mm_protocal_c_bcj.mQl.mcj), com_tencent_mm_protocal_c_bcj.mQl.mfD.toString());
                                        this.cNH.a(d, d.cyu, j, com_tencent_mm_protocal_c_bcj.hNS, com_tencent_mm_modelcdntran_keep_SceneResult);
                                        this.cNH.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this.cNH);
                                        if (this.cNH.cNq != null) {
                                            this.cNH.cNq.Gu();
                                        }
                                        return 0;
                                    } catch (Throwable e22) {
                                        v.e(this.cNH.TAG, "UploadMsgImgResponse parse fail: %s", e22);
                                        v.e(this.cNH.TAG, "exception:%s", be.e(e22));
                                        this.cNH.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.cNH);
                                        if (this.cNH.cNq != null) {
                                            this.cNH.cNq.Gu();
                                        }
                                    }
                                }
                            }
                        }
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                bci com_tencent_mm_protocal_c_bci = (bci) this.cNH.cif.czk.czs;
                com.tencent.mm.ba.a ijVar = new ij();
                ijVar.mjI = com_tencent_mm_protocal_c_bci.mXW.mQy;
                ijVar.gon = com_tencent_mm_protocal_c_bci.mbU.mQy;
                ijVar.gom = com_tencent_mm_protocal_c_bci.mbV.mQy;
                ijVar.mjJ = com_tencent_mm_protocal_c_bci.mYd;
                ijVar.mjK = com_tencent_mm_protocal_c_bci.mYe;
                ijVar.maG = this.cNH.scene;
                ijVar.mjM = this.cNH.cNt;
                ijVar.mjN = this.cNH.bhs;
                ijVar.mjO = this.cNH.cNu;
                ijVar.mbZ = com_tencent_mm_protocal_c_bci.mbZ;
                ijVar.mjT = this.cNH.cNl;
                String l = n.GH().l(this.cNH.Gv().cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                com.tencent.mm.modelcdntran.g.Ea();
                ijVar.mjU = com.tencent.mm.modelcdntran.b.in(l);
                v.i(this.cNH.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d]", str, Integer.valueOf(ijVar.mjJ), Integer.valueOf(ijVar.mjK), ijVar.mbZ, ijVar.gom, ijVar.mjT, Long.valueOf(this.cNH.cMR), Long.valueOf(this.cNH.cLC), r0.cLv, l, Integer.valueOf(ijVar.mjU));
                com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
                aVar.czn = ijVar;
                aVar.czo = new bcj();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.czm = 625;
                aVar.czp = 9;
                aVar.czq = 1000000009;
                com.tencent.mm.v.b Bv = aVar.Bv();
                com.tencent.mm.network.c BU = this.cNH.czE.BU();
                l = this.cNH.TAG;
                String str2 = "getCdnAuthInfo login:%s";
                Object[] objArr = new Object[1];
                objArr[0] = BU == null ? "acc == null" : Boolean.valueOf(BU.BQ());
                v.i(l, str2, objArr);
                if (BU == null || !BU.BQ()) {
                    v.e(this.cNH.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", ijVar.mjI);
                    return;
                }
                if (r.a(BU.uT(), BU.BP(), BU.BR(), Bv.Bx(), byteArrayOutputStream, BU.BS())) {
                    v.d(this.cNH.TAG, "getCdnAuthInfo successed.clientimgid:%s", ijVar.mjI);
                } else {
                    v.e(this.cNH.TAG, "getCdnAuthInfo failed. clientimgid:%s", ijVar.mjI);
                }
            }

            public final byte[] i(String str, byte[] bArr) {
                PInt pInt = new PInt();
                aqx ikVar = new ik();
                try {
                    byte[] a = t.a(bArr, ak.vy().cAa.BU().uT(), pInt, ikVar);
                    v.d(this.cNH.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", ikVar.mjT, ikVar.mjV, ikVar.mjI);
                    this.cNH.cNv = ikVar.mjT;
                    v.i(this.cNH.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    return a;
                } catch (Exception e) {
                    v.e(this.cNH.TAG, "decodePrepareResponse Exception:%s", e);
                    this.cNH.cNv = null;
                    return null;
                }
            }
        };
        this.cNy = false;
        this.cNA = 0;
        this.cNC = false;
        this.cND = new c<kv>(this) {
            final /* synthetic */ k cNH;

            {
                this.cNH = r2;
                this.nhz = kv.class.getName().hashCode();
            }

            private boolean a(kv kvVar) {
                if (kvVar.bme.filePath.equals(this.cNH.cNz)) {
                    String encode;
                    String str = SQLiteDatabase.KeyEmpty;
                    try {
                        encode = URLEncoder.encode(kvVar.bme.bfz, "UTF-8");
                    } catch (Throwable e) {
                        v.a(this.cNH.TAG, e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        encode = str;
                    }
                    if (this.cNH.cNC) {
                        v.i(this.cNH.TAG, "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", Long.valueOf(this.cNH.cMR), Integer.valueOf(this.cNH.hashCode()), this.cNH.cNx + encode, kvVar.bme.filePath);
                        com.tencent.mm.plugin.report.service.g.iuh.Y(13717, str);
                    }
                    if (this.cNH.cNA == 1) {
                        com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                        bci com_tencent_mm_protocal_c_bci = (bci) this.cNH.cif.czk.czs;
                        cVar.n("20toUser", com_tencent_mm_protocal_c_bci.mbV.mQy + ",");
                        cVar.n("21source", this.cNH.cNw + ",");
                        cVar.n("22qrUrl", encode + ",");
                        cVar.n("23md5", (this.cNH.cNB == null ? SQLiteDatabase.KeyEmpty : this.cNH.cNB.field_filemd5) + ",");
                        cVar.n("24cdnFileId", (this.cNH.cNB == null ? SQLiteDatabase.KeyEmpty : this.cNH.cNB.field_fileId) + ",");
                        cVar.n("25cdnAesKey", (this.cNH.cNB == null ? SQLiteDatabase.KeyEmpty : this.cNH.cNB.field_aesKey) + ",");
                        encode = SQLiteDatabase.KeyEmpty;
                        if (this.cNH.aXd.bvY()) {
                            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.cNH.aXd.field_content);
                            if (dV != null) {
                                encode = dV.appId;
                            }
                        }
                        cVar.n("26appip", encode + ",");
                        cVar.n("27toUsersCount", i.el(com_tencent_mm_protocal_c_bci.mbV.mQy) + ",");
                        v.i(this.cNH.TAG, "report qrCodeImgChatting(13628): " + cVar.JH());
                        n.aB(13628, cVar.toString());
                    }
                    k.K(this.cNH);
                }
                return false;
            }
        };
        this.cNE = new c<ku>(this) {
            final /* synthetic */ k cNH;

            {
                this.cNH = r2;
                this.nhz = ku.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                if (((ku) bVar).bmd.filePath.equals(this.cNH.cNz)) {
                    if (this.cNH.cNC) {
                        v.i(this.cNH.TAG, "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", Long.valueOf(this.cNH.cMR), Integer.valueOf(this.cNH.hashCode()), this.cNH.cNx);
                        com.tencent.mm.plugin.report.service.g.iuh.Y(13717, this.cNH.cNx);
                    }
                    k.K(this.cNH);
                }
                return false;
            }
        };
        v.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.valueOf(true), be.bur(), Integer.valueOf(i5), Float.valueOf(f), Float.valueOf(f2));
        this.cNs = z;
        this.cMY = i4;
        this.cMP = fVar;
        this.cLy = i2;
        this.scene = i5;
        this.bhs = f2;
        this.cNt = f;
        this.cNw = i;
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.cNr = str4;
        pString.value = str5;
        this.cMQ = n.GH().a(str3, i2, i, i3, pString, pInt, pInt2);
        this.cMR = this.cMQ;
        v.d(this.TAG, "FROM A UI :" + str2 + " " + this.cMQ);
        if (this.cMQ < 0 || !h.fE((int) this.cMQ)) {
            v.e(this.TAG, "insert to img storage failed id:" + this.cMQ);
            this.cLC = -1;
            this.cif = null;
            return;
        }
        d Gv;
        Assert.assertTrue(this.cMQ >= 0);
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bci();
        aVar.czo = new bcj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.czm = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.czp = 9;
        aVar.czq = 1000000009;
        this.cif = aVar.Bv();
        this.bob = str2;
        this.aXd = new at();
        this.aXd.setType(m.fq(str2));
        this.aXd.cH(str2);
        this.aXd.di(1);
        this.aXd.dh(1);
        this.aXd.cI(pString.value);
        this.aXd.dt(pInt.value);
        this.aXd.du(pInt2.value);
        this.aXd.z(aw.fN(this.aXd.field_talker));
        if (com.tencent.mm.modelbiz.e.hC(this.aXd.field_talker)) {
            this.aXd.cN(com.tencent.mm.modelbiz.a.e.zr());
        }
        ak.yW();
        this.cLC = com.tencent.mm.model.c.wJ().R(this.aXd);
        Assert.assertTrue(this.cLC >= 0);
        v.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.cLC);
        d Gw = Gw();
        Gw.af((long) ((int) this.cLC));
        n.GH().a(Long.valueOf(this.cMQ), Gw);
        if (i2 == 1) {
            this.cMR = (long) Gw.cLE;
            Gv = Gv();
        } else {
            Gv = Gw;
        }
        Gv.fx(com.tencent.mm.a.e.aQ(n.GH().l(Gv.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)));
        n.GH().a(Long.valueOf(this.cMR), Gv);
        v.d(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.cMR + " img len = " + Gv.cyu);
        bci com_tencent_mm_protocal_c_bci = (bci) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bci.mbU = new arf().JF(str);
        com_tencent_mm_protocal_c_bci.mbV = new arf().JF(str2);
        com_tencent_mm_protocal_c_bci.mdA = Gv.offset;
        com_tencent_mm_protocal_c_bci.mdz = Gv.cyu;
        com_tencent_mm_protocal_c_bci.gll = this.aXd.field_type;
        com_tencent_mm_protocal_c_bci.mzC = i2;
        com_tencent_mm_protocal_c_bci.mnk = com.tencent.mm.network.aa.bk(aa.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bci.mUu = Gv.bbT;
        com_tencent_mm_protocal_c_bci.mYf = Gv.cLz;
        com_tencent_mm_protocal_c_bci.mYd = pInt2.value;
        com_tencent_mm_protocal_c_bci.mYe = pInt.value;
        v.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bci.mYd), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYe));
        if (com_tencent_mm_protocal_c_bci.mYf == 0) {
            com_tencent_mm_protocal_c_bci.mYf = i == 4 ? 2 : 1;
        }
        v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(Gv.bbT), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYf));
        if (Gv.offset == 0) {
            this.cMT = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) Gv.cyu);
        }
        fH(i2);
        if (fVar != null) {
            final int i6 = Gv.offset;
            final int i7 = Gv.cyu;
            final f fVar2 = fVar;
            ad.o(new Runnable(this) {
                final /* synthetic */ k cNH;

                public final void run() {
                    fVar2.a(i6, i7, this.cNH);
                }
            });
        }
    }

    public k(int i, int i2, String str, String str2, String str3, int i3, f fVar, int i4, String str4, String str5, int i5) {
        d Gv;
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.cNk = SQLiteDatabase.KeyEmpty;
        this.cNl = SQLiteDatabase.KeyEmpty;
        this.cNm = true;
        this.cNp = 16384;
        this.cLy = 0;
        this.aXd = null;
        this.cMT = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startTime = 0;
        this.startOffset = -1;
        this.cMV = 0;
        this.cNq = new b(this, null);
        this.cNe = /* anonymous class already generated */;
        this.cNy = false;
        this.cNA = 0;
        this.cNC = false;
        this.cND = /* anonymous class already generated */;
        this.cNE = /* anonymous class already generated */;
        v.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", Integer.valueOf(i), Integer.valueOf(3), str, str2, str3, Integer.valueOf(i3), fVar, Integer.valueOf(i4), str4, str5, Boolean.valueOf(true), Integer.valueOf(2130837922), Boolean.valueOf(true), be.bur());
        this.cNs = true;
        this.cMY = 2130837922;
        this.cMP = fVar;
        this.cLy = i3;
        this.cNw = 3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.cNr = str4;
        this.cMQ = (long) i;
        this.cMR = this.cMQ;
        d Gw = Gw();
        ak.yW();
        this.aXd = com.tencent.mm.model.c.wJ().ek(Gw.cLC);
        this.cLC = this.aXd.field_msgId;
        pInt2.value = this.aXd.bNq;
        pInt.value = this.aXd.bNp;
        if (i3 == 1) {
            this.cMR = (long) Gw.cLE;
            this.cNn = null;
            Gv = Gv();
        } else {
            Gv = Gw;
        }
        v.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.aXd.field_msgId);
        v.d(this.TAG, "FROM A UI :" + str2 + " " + this.cMQ);
        if (this.cMQ < 0 || !h.fE((int) this.cMQ)) {
            v.e(this.TAG, "insert to img storage failed id:" + this.cMQ);
            this.cLC = -1;
            this.cif = null;
            return;
        }
        Assert.assertTrue(this.cMQ >= 0);
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bci();
        aVar.czo = new bcj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.czm = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.czp = 9;
        aVar.czq = 1000000009;
        this.cif = aVar.Bv();
        v.d(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.cMR + " img len = " + Gv.cyu);
        bci com_tencent_mm_protocal_c_bci = (bci) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bci.mbU = new arf().JF(str);
        com_tencent_mm_protocal_c_bci.mbV = new arf().JF(str2);
        com_tencent_mm_protocal_c_bci.mdA = Gv.offset;
        com_tencent_mm_protocal_c_bci.mdz = Gv.cyu;
        com_tencent_mm_protocal_c_bci.gll = this.aXd.field_type;
        com_tencent_mm_protocal_c_bci.mzC = i3;
        com_tencent_mm_protocal_c_bci.mnk = com.tencent.mm.network.aa.bk(aa.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bci.mUu = Gv.bbT;
        com_tencent_mm_protocal_c_bci.mYf = Gv.cLz;
        com_tencent_mm_protocal_c_bci.mYd = pInt2.value;
        com_tencent_mm_protocal_c_bci.mYe = pInt.value;
        v.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bci.mYd), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYe));
        if (com_tencent_mm_protocal_c_bci.mYf == 0) {
            com_tencent_mm_protocal_c_bci.mYf = 1;
        }
        v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(Gv.bbT), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYf));
        if (Gv.offset == 0) {
            this.cMT = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) Gv.cyu);
        }
        if (fVar != null) {
            final int i6 = Gv.offset;
            final int i7 = Gv.cyu;
            final f fVar2 = fVar;
            ad.o(new Runnable(this) {
                final /* synthetic */ k cNH;

                public final void run() {
                    fVar2.a(i6, i7, this.cNH);
                }
            });
        }
    }

    public final void fH(int i) {
        int i2 = 0;
        if (this.aXd == null) {
            v.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", Long.valueOf(this.cLC), Integer.valueOf(i));
        } else if (!this.cNs) {
            n.GH().a(this.aXd.field_imgPath, com.tencent.mm.bd.a.getDensity(aa.getContext()), true);
        } else if (this.aXd.bNt == 0) {
            boolean z;
            f GH = n.GH();
            bx bxVar = this.aXd;
            int i3 = this.cMY;
            String l = f.l(bxVar);
            if (be.kS(l)) {
                z = false;
            } else {
                z = GH.a(l, bxVar.field_imgPath, i3, i);
            }
            bxVar = this.aXd;
            if (z) {
                i2 = 1;
            }
            bxVar.bNt = i2;
            bxVar.bKL = true;
            ak.yW();
            com.tencent.mm.model.c.wJ().a(this.cLC, this.aXd);
        }
    }

    public k(int i, int i2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.cNk = SQLiteDatabase.KeyEmpty;
        this.cNl = SQLiteDatabase.KeyEmpty;
        this.cNm = true;
        this.cNp = 16384;
        this.cLy = 0;
        this.aXd = null;
        this.cMT = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startTime = 0;
        this.startOffset = -1;
        this.cMV = 0;
        this.cNq = new b(this, null);
        this.cNe = /* anonymous class already generated */;
        this.cNy = false;
        this.cNA = 0;
        this.cNC = false;
        this.cND = /* anonymous class already generated */;
        this.cNE = /* anonymous class already generated */;
        v.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", Integer.valueOf(i), Integer.valueOf(i2), be.bur());
        this.cMQ = (long) i;
        this.cMR = (long) i;
        this.cLy = i2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bci();
        aVar.czo = new bcj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.czm = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.czp = 9;
        aVar.czq = 1000000009;
        this.cif = aVar.Bv();
        this.cMP = null;
        v.d(this.TAG, "FROM B SERVICE:" + this.cMQ);
        if (h.fE((int) this.cMQ)) {
            d b;
            d b2 = n.GH().b(Long.valueOf(this.cMQ));
            this.cLC = b2.cLC;
            if (i2 == 1) {
                this.cMR = (long) b2.cLE;
                b = n.GH().b(Long.valueOf(this.cMR));
            } else {
                b = b2;
            }
            b2 = n.GH().fD((int) b.cLu);
            if (b2 != null) {
                this.cLC = b2.cLC;
            }
            ak.yW();
            this.aXd = com.tencent.mm.model.c.wJ().ek(this.cLC);
            if (this.aXd != null && this.aXd.field_msgId != this.cLC) {
                v.w(this.TAG, "init get msg by id failed:%d", Long.valueOf(this.cLC));
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 206, 1, false);
                this.aXd = null;
                return;
            } else if (this.aXd != null) {
                bci com_tencent_mm_protocal_c_bci = (bci) this.cif.czk.czs;
                com_tencent_mm_protocal_c_bci.mbU = new arf().JF(com.tencent.mm.model.k.xF());
                com_tencent_mm_protocal_c_bci.mbV = new arf().JF(this.aXd.field_talker);
                com_tencent_mm_protocal_c_bci.mdA = b.offset;
                com_tencent_mm_protocal_c_bci.mdz = b.cyu;
                com_tencent_mm_protocal_c_bci.gll = this.aXd.field_type;
                com_tencent_mm_protocal_c_bci.mzC = i2;
                com_tencent_mm_protocal_c_bci.mnk = com.tencent.mm.network.aa.bk(aa.getContext()) ? 1 : 2;
                com_tencent_mm_protocal_c_bci.mUu = b.bbT;
                com_tencent_mm_protocal_c_bci.mYf = b.cLz;
                com_tencent_mm_protocal_c_bci.mYf = b.cLz;
                com_tencent_mm_protocal_c_bci.mYd = this.aXd.bNq;
                com_tencent_mm_protocal_c_bci.mYe = this.aXd.bNp;
                v.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bci.mYd), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYe));
                v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b.bbT), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYf));
                if (b.offset == 0) {
                    this.cMT = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) b.cyu);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        this.cMQ = -1;
    }

    public k(int i, int i2, byte b) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.cNk = SQLiteDatabase.KeyEmpty;
        this.cNl = SQLiteDatabase.KeyEmpty;
        this.cNm = true;
        this.cNp = 16384;
        this.cLy = 0;
        this.aXd = null;
        this.cMT = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startTime = 0;
        this.startOffset = -1;
        this.cMV = 0;
        this.cNq = new b(this, null);
        this.cNe = /* anonymous class already generated */;
        this.cNy = false;
        this.cNA = 0;
        this.cNC = false;
        this.cND = /* anonymous class already generated */;
        this.cNE = /* anonymous class already generated */;
        v.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", Integer.valueOf(i), Integer.valueOf(i2), null, be.bur());
        this.cMQ = (long) i;
        this.cMR = (long) i;
        this.cLy = i2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bci();
        aVar.czo = new bcj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.czm = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.czp = 9;
        aVar.czq = 1000000009;
        this.cif = aVar.Bv();
        this.cMP = null;
        v.d(this.TAG, "FROM C SERVICE:" + this.cMQ);
        if (h.fE((int) this.cMQ)) {
            d b2;
            d b3 = n.GH().b(Long.valueOf(this.cMQ));
            this.cLC = b3.cLC;
            b3.dh(0);
            b3.y(0);
            b3.setOffset(0);
            n.GH().a((int) this.cMR, b3);
            if (i2 == 1) {
                this.cMR = (long) b3.cLE;
                b2 = n.GH().b(Long.valueOf(this.cMR));
            } else {
                b2 = b3;
            }
            ak.yW();
            this.aXd = com.tencent.mm.model.c.wJ().ek(this.cLC);
            if (this.aXd != null) {
                this.aXd.dh(1);
                String str = b2.cLx;
                if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                    this.aXd.cI("THUMBNAIL://" + b2.cLu);
                } else {
                    this.aXd.cI(str);
                }
                ak.yW();
                com.tencent.mm.model.c.wJ().a(this.cLC, this.aXd);
                bci com_tencent_mm_protocal_c_bci = (bci) this.cif.czk.czs;
                com_tencent_mm_protocal_c_bci.mbU = new arf().JF(com.tencent.mm.model.k.xF());
                com_tencent_mm_protocal_c_bci.mbV = new arf().JF(this.aXd.field_talker);
                com_tencent_mm_protocal_c_bci.mdA = b2.offset;
                com_tencent_mm_protocal_c_bci.mdz = b2.cyu;
                com_tencent_mm_protocal_c_bci.gll = this.aXd.field_type;
                com_tencent_mm_protocal_c_bci.mzC = i2;
                com_tencent_mm_protocal_c_bci.mnk = com.tencent.mm.network.aa.bk(aa.getContext()) ? 1 : 2;
                com_tencent_mm_protocal_c_bci.mUu = b2.bbT;
                com_tencent_mm_protocal_c_bci.mYf = b2.cLz;
                com_tencent_mm_protocal_c_bci.mYd = this.aXd.bNq;
                com_tencent_mm_protocal_c_bci.mYe = this.aXd.bNp;
                v.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bci.mYd), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYe));
                v.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b2.bbT), Integer.valueOf(com_tencent_mm_protocal_c_bci.mYf));
                if (b2.offset == 0) {
                    this.cMT = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) b2.cyu);
                    return;
                }
                return;
            }
            return;
        }
        this.cMQ = -1;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        ak.vA().f(new Runnable(this) {
            final /* synthetic */ k cNH;

            {
                this.cNH = r1;
            }

            public final void run() {
                ak.yW();
                com.tencent.mm.model.c.wJ().MD("SendImgSpeeder");
            }
        }, 100);
        if (this.cMR < 0) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 204, 1, false);
            v.e(this.TAG, "doScene invalid imgLocalId:" + this.cMR);
            return fI(-1);
        } else if (this.aXd == null) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 203, 1, false);
            v.e(this.TAG, "doScene msg is null imgid:%d", Long.valueOf(this.cMR));
            h.fG((int) this.cMQ);
            return fI(-2);
        } else {
            String zr;
            this.cii = eVar2;
            c(eVar);
            bci com_tencent_mm_protocal_c_bci = (bci) this.cif.czk.czs;
            d Gv = Gv();
            d fD = n.GH().fD((int) Gv.cLu);
            if (fD != null) {
                if (fD.status == -1) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(111, 202, 1, false);
                    v.e(this.TAG, "doScene hd img info is null or error.");
                    return fI(-3);
                }
            } else if (Gv == null || Gv.status == -1) {
                v.e(this.TAG, "doScene img info is null or error.");
                return fI(-4);
            }
            if (com.tencent.mm.modelbiz.e.hC(this.aXd.field_talker)) {
                com_tencent_mm_protocal_c_bci.mbZ = com.tencent.mm.modelbiz.a.e.hY(this.aXd.bNo);
            } else {
                zr = ax.zr();
                if (!(zr == null || zr.equals(this.aXd.bNo)) || (zr == null && !be.kS(this.aXd.bNo))) {
                    this.aXd.cN(zr);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(this.aXd.field_msgId, this.aXd);
                }
                com_tencent_mm_protocal_c_bci.mbZ = this.aXd.bNo;
            }
            String l = n.GH().l(Gv.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            String l2 = n.GH().l(Gv.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            zr = SQLiteDatabase.KeyEmpty;
            if (!be.kS(Gv.cLw)) {
                zr = n.GH().l(Gv.cLw, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            }
            if (com.tencent.mm.a.e.aQ(l) <= 0 || com.tencent.mm.a.e.aQ(l2) <= 0) {
                v.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", Long.valueOf(this.cMR), Integer.valueOf(com.tencent.mm.a.e.aQ(l)), Integer.valueOf(com.tencent.mm.a.e.aQ(l2)), l, l2);
                return fI(-5);
            }
            Object obj;
            if (com_tencent_mm_protocal_c_bci.mXW == null || be.kS(com_tencent_mm_protocal_c_bci.mXW.mQy)) {
                if (be.kS(this.cMU)) {
                    v.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(this.aXd.field_createTime), this.aXd.field_talker, Long.valueOf(this.aXd.field_msgId), Long.valueOf(this.cMR), Integer.valueOf(this.cLy));
                    this.cMU = d.a("upimg", this.aXd.field_createTime, this.aXd.field_talker, this.aXd.field_msgId + "_" + this.cMR + "_" + this.cLy);
                }
                com_tencent_mm_protocal_c_bci.mXW = new arf().JF(this.cMU);
                bx bxVar = this.aXd;
                bxVar.bNv = this.cMU;
                bxVar.bKL = true;
            }
            if (this.startTime == 0) {
                this.startTime = be.Ni();
                this.startOffset = Gv.offset;
                this.cMV = this.cLy == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            v.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", l, l2, Gv.cLv);
            if (m.fo(this.aXd.field_talker)) {
                v.w(this.TAG, "cdntra not use cdn user:%s", this.aXd.field_talker);
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.DZ();
                if (!com.tencent.mm.modelcdntran.c.fk(1) && be.kS(Gv.cLF)) {
                    r7 = new Object[2];
                    com.tencent.mm.modelcdntran.g.DZ();
                    r7[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(1));
                    r7[1] = Gv.cLF;
                    v.w(this.TAG, "cdntra not use cdn flag:%b getCdnInfo:%s", r7);
                    obj = null;
                } else if (be.kS(this.cMU)) {
                    v.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.cMR));
                    obj = null;
                } else {
                    h hVar = new h();
                    hVar.cFR = this.cNe;
                    hVar.field_mediaId = this.cMU;
                    hVar.field_fullpath = l;
                    hVar.field_thumbpath = l2;
                    hVar.field_fileType = this.cMV;
                    hVar.field_talker = this.aXd.field_talker;
                    hVar.field_chattype = m.dE(this.aXd.field_talker) ? 1 : 0;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                    hVar.field_needStorage = false;
                    hVar.field_isStreamMedia = false;
                    hVar.field_sendmsg_viacdn = true;
                    hVar.field_enable_hitcheck = this.cNm;
                    hVar.field_midimgpath = zr;
                    hVar.field_force_aeskeycdn = false;
                    hVar.field_trysafecdn = true;
                    if (hVar.field_fileType == com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE && be.kS(hVar.field_midimgpath)) {
                        com.tencent.mm.modelcdntran.g.DZ();
                        if (com.tencent.mm.modelcdntran.c.fk(FileUtils.S_IRUSR)) {
                            v.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                            hVar.field_force_aeskeycdn = true;
                            hVar.field_trysafecdn = false;
                        }
                    }
                    Map q = bf.q(this.cNr, "msg");
                    if (q != null) {
                        if (this.cLy != 1) {
                            hVar.field_fileId = (String) q.get(".msg.img.$cdnmidimgurl");
                            hVar.field_midFileLength = be.getInt((String) q.get(".msg.img.$length"), 0);
                            hVar.field_totalLen = 0;
                        } else {
                            hVar.field_fileId = (String) q.get(".msg.img.$cdnbigimgurl");
                            hVar.field_midFileLength = be.getInt((String) q.get(".msg.img.$length"), 0);
                            hVar.field_totalLen = 0;
                        }
                        hVar.field_aesKey = (String) q.get(".msg.img.$aeskey");
                    } else {
                        v.i(this.TAG, "parse cdnInfo failed. [%s]", Gv.cLF);
                    }
                    if (be.kS(hVar.field_aesKey)) {
                        com.tencent.mm.modelcdntran.g.Ea();
                        hVar.field_aesKey = com.tencent.mm.modelcdntran.b.DU();
                        v.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", hVar.field_aesKey);
                    }
                    v.i(this.TAG, "dkupimg src:%d fileid:%s", Integer.valueOf(Gv.bbT), hVar.field_fileId);
                    this.cNk = hVar.field_fileId;
                    this.cNl = hVar.field_aesKey;
                    v.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", Boolean.valueOf(hVar.field_enable_hitcheck), Integer.valueOf(hVar.field_fileType), hVar.field_midimgpath, hVar.field_fullpath, hVar.field_aesKey, hVar.field_fileId, Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn));
                    this.cNv = null;
                    if (com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                        if (be.ma(Gv.cLF).length() <= 0) {
                            Gv.iT("CDNINFO_SEND");
                            Gv.bkU = 4096;
                        }
                        obj = 1;
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.a(111, 205, 1, false);
                        v.e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.cMU);
                        this.cMU = SQLiteDatabase.KeyEmpty;
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                v.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", com_tencent_mm_protocal_c_bci.mXW.mQy);
                return 0;
            }
            v.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
            int i = Gv.cLD;
            if (i >= ul()) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 201, 1, false);
                v.e(this.TAG, "doScene limit net time:" + i);
                h.fG((int) this.cMQ);
                return fI(-6);
            }
            Gv.fv(i + 1);
            Gv.bkU = 512;
            n.GH().a(Long.valueOf(this.cMR), Gv);
            int i2 = Gv.cyu - Gv.offset;
            if (i2 > this.cNp) {
                i2 = this.cNp;
            }
            if (com.tencent.mm.a.e.aQ(l) > 10485760) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 200, 1, false);
                v.e(this.TAG, "doScene, file size is too large");
                return fI(-7);
            }
            byte[] c = com.tencent.mm.a.e.c(l, Gv.offset, i2);
            if (c == null || c.length <= 0) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 199, 1, false);
                v.e(this.TAG, "doScene, file read buf error.");
                return fI(-8);
            }
            com_tencent_mm_protocal_c_bci.mdB = c.length;
            com_tencent_mm_protocal_c_bci.mdA = Gv.offset;
            com_tencent_mm_protocal_c_bci.mfg = new are().ba(c);
            if (this.cMT != null) {
                this.cMT.Kc();
            }
            int a = a(eVar, this.cif, this);
            if (a >= 0) {
                return a;
            }
            v.e(this.TAG, "doScene netId error");
            h.fG((int) this.cMQ);
            return fI(-9);
        }
    }

    private int fI(int i) {
        v.e(this.TAG, "do Scene error code : " + i + " hashcode : " + hashCode());
        if (this.cNq != null) {
            this.cNq.Gu();
        }
        return -1;
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_CLOSE_FAILED;
    }

    protected final int ul() {
        if (this.cLy == 0) {
            return 100;
        }
        return 1350;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bcj com_tencent_mm_protocal_c_bcj = (bcj) ((com.tencent.mm.v.b) pVar).czl.czs;
        v.d(this.TAG, "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.cMU);
        if (i2 == 3 && i3 == -1 && !be.kS(this.cMU)) {
            v.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.cMU);
        } else if (i2 == 0 && i3 == 0) {
            this.cNp = com_tencent_mm_protocal_c_bcj.mdB;
            if (this.cNp > 16384) {
                this.cNp = 16384;
            }
            d Gv = Gv();
            v.v(this.TAG, "onGYNetEnd localId:" + this.cMR + "  totalLen:" + Gv.cyu + " offSet:" + Gv.offset);
            if (com_tencent_mm_protocal_c_bcj.mdA < 0 || (com_tencent_mm_protocal_c_bcj.mdA > Gv.cyu && Gv.cyu > 0)) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 197, 1, false);
                v.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + com_tencent_mm_protocal_c_bcj.mdA + " img totalLen = " + Gv.cyu);
                h.fG((int) this.cMQ);
                h.fF((int) this.cMQ);
                com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cMV), Integer.valueOf(0));
                this.cii.a(4, -2, SQLiteDatabase.KeyEmpty, this);
                if (this.cNq != null) {
                    this.cNq.Gu();
                }
            } else if (com_tencent_mm_protocal_c_bcj.mdA < Gv.offset || (e.b(Gv) && this.cNp <= 0)) {
                v.e(this.TAG, "onGYNetEnd invalid data startPos = " + com_tencent_mm_protocal_c_bcj.mdA + " totalLen = " + Gv.cyu + " off:" + Gv.offset);
                h.fG((int) this.cMQ);
                h.fF((int) this.cMQ);
                this.cii.a(4, -1, SQLiteDatabase.KeyEmpty, this);
                if (this.cNq != null) {
                    this.cNq.Gu();
                }
            } else {
                v.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + com_tencent_mm_protocal_c_bcj.mdA);
                if (a(Gv, com_tencent_mm_protocal_c_bcj.mdA, com_tencent_mm_protocal_c_bcj.mcb, com_tencent_mm_protocal_c_bcj.hNS, null) && a(this.czE, this.cii) < 0) {
                    h.fF((int) this.cMQ);
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                    if (this.cNq != null) {
                        this.cNq.Gu();
                    }
                }
            }
        } else {
            v.e(this.TAG, "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 198, 1, false);
            h.fG((int) this.cMQ);
            h.fF((int) this.cMQ);
            com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cMV), Integer.valueOf(0));
            this.cii.a(i2, i3, str, this);
            if (this.cNq != null) {
                this.cNq.Gu();
            }
        }
    }

    public final void Gx() {
        v.i(this.TAG, "send img from system");
        this.cNC = true;
    }

    private boolean a(d dVar, int i, long j, int i2, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        v.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", this.cMU, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        v.d(this.TAG, "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(j), Integer.valueOf(q.dqk));
        if (10007 == q.dqj && q.dqk != 0) {
            j = (long) q.dqk;
            q.dqk = 0;
        }
        final long j2 = dVar.cLu;
        final int i3 = dVar.cyu;
        if (this.cMP != null) {
            final int i4 = i;
            ad.o(new Runnable(this) {
                final /* synthetic */ k cNH;

                public final void run() {
                    m Gy = m.Gy();
                    long j = j2;
                    long j2 = (long) i3;
                    long j3 = (long) i4;
                    m.d dVar = Gy.cNN.containsKey(Long.valueOf(j)) ? (m.d) Gy.cNN.get(Long.valueOf(j)) : new m.d();
                    dVar.cOf = j3;
                    dVar.cOe = j2;
                    Gy.cNN.put(Long.valueOf(j), dVar);
                    this.cNH.cMP.a(i4, i3, this.cNH);
                }
            });
        }
        dVar.setOffset(i);
        dVar.y(j);
        if (e.b(dVar) && this.cMQ != this.cMR) {
            d b = n.GH().b(Long.valueOf(this.cMQ));
            b.y(j);
            b.fx(dVar.cyu);
            b.setOffset(dVar.cyu);
            n.GH().a(Long.valueOf(this.cMQ), b);
        }
        if (!e.b(dVar)) {
            return true;
        }
        if (be.kS(this.cMU)) {
            com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cMV), Integer.valueOf(dVar.cyu - this.startOffset));
        }
        this.aXd.dh(2);
        this.aXd.y(j);
        ak.yW();
        com.tencent.mm.model.c.wJ().a(this.cLC, this.aXd);
        com.tencent.mm.modelstat.b.daJ.p(this.aXd);
        h.fF((int) this.cMQ);
        if (this.cMT != null) {
            this.cMT.aq(0);
        }
        this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100131");
        if (Ls.isValid()) {
            this.cNA = com.tencent.mm.platformtools.t.getInt((String) Ls.buX().get("needUploadData"), 1);
        }
        if (!this.cNy && (this.cNC || this.cNA != 0)) {
            this.cNB = com_tencent_mm_modelcdntran_keep_SceneResult;
            this.cNy = true;
            String str = ((bci) this.cif.czk.czs).mbV.mQy;
            Object obj = (be.kS(str) || !str.endsWith("@chatroom")) ? null : 1;
            this.cNx = "2," + (obj != null ? 2 : 1) + ",,";
            b = Gv();
            if (b != null) {
                com.tencent.mm.sdk.c.b ktVar = new kt();
                com.tencent.mm.sdk.c.a.nhr.e(this.cND);
                com.tencent.mm.sdk.c.a.nhr.e(this.cNE);
                this.cNz = n.GH().l(b.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                ktVar.bmc.filePath = this.cNz;
                com.tencent.mm.sdk.c.a.nhr.z(ktVar);
            }
        }
        if (this.cNq != null) {
            this.cNq.Gu();
        }
        return false;
    }

    public static void aj(long j) {
        cNF = j;
    }

    public static String iX(String str) {
        try {
            if (!be.kS(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 19) {
                    StringBuilder stringBuilder = new StringBuilder();
                    long j = cNF;
                    cNF = -1;
                    split[19] = stringBuilder.append(j).toString();
                    str = be.b(be.g(split), ",");
                }
            }
        } catch (Exception e) {
        }
        return str;
    }
}
