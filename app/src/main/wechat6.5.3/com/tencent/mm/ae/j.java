package com.tencent.mm.ae;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.j {
    String TAG;
    at aXd;
    private long bao;
    private int cLy;
    final f cMP;
    public final long cMQ;
    long cMR;
    private int cMS;
    private g cMT;
    String cMU;
    int cMV;
    private String cMW;
    public String cMX;
    int cMY;
    public boolean cMZ;
    private int cNa;
    private String cNb;
    private int cNc;
    boolean cNd;
    private a cNe;
    private final b cif;
    e cii;
    int cyu;
    private int startOffset;
    long startTime;
    private int token;

    public j(long j, long j2, int i, f fVar) {
        this(j, j2, i, fVar, -1);
    }

    public j(long j, long j2, int i, final f fVar, int i2) {
        d b;
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.cMT = null;
        this.bao = -1;
        this.aXd = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startTime = 0;
        this.startOffset = -1;
        this.cMV = 0;
        this.cMW = SQLiteDatabase.KeyEmpty;
        this.cMX = SQLiteDatabase.KeyEmpty;
        this.cyu = 0;
        this.cMY = -1;
        this.cMZ = false;
        this.cNa = -1;
        this.cNb = null;
        this.cNc = 0;
        this.token = -1;
        this.cNd = false;
        this.cNe = new a(this) {
            final /* synthetic */ j cNi;

            {
                this.cNi = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21006) {
                    v.d(this.cNi.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", this.cNi.cMU);
                    return 0;
                } else if (i != 0) {
                    h.fG((int) this.cNi.cMQ);
                    h.fF((int) this.cNi.cMQ);
                    r1 = com.tencent.mm.plugin.report.service.g.iuh;
                    r3 = new Object[16];
                    r3[0] = Integer.valueOf(i);
                    r3[1] = Integer.valueOf(2);
                    r3[2] = Long.valueOf(this.cNi.startTime);
                    r3[3] = Long.valueOf(be.Ni());
                    r3[4] = Integer.valueOf(d.aO(aa.getContext()));
                    r3[5] = Integer.valueOf(this.cNi.cMV);
                    r3[6] = Integer.valueOf(this.cNi.cyu);
                    r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? SQLiteDatabase.KeyEmpty : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                    r3[8] = SQLiteDatabase.KeyEmpty;
                    r3[9] = SQLiteDatabase.KeyEmpty;
                    r3[10] = SQLiteDatabase.KeyEmpty;
                    r3[11] = SQLiteDatabase.KeyEmpty;
                    r3[12] = SQLiteDatabase.KeyEmpty;
                    r3[13] = SQLiteDatabase.KeyEmpty;
                    r3[14] = SQLiteDatabase.KeyEmpty;
                    r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? SQLiteDatabase.KeyEmpty : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                    r1.h(10421, r3);
                    this.cNi.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.cNi);
                    return 0;
                } else {
                    d b = n.GH().b(Long.valueOf(this.cNi.cMR));
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                h.fF((int) this.cNi.cMQ);
                                v.e(this.cNi.TAG, "cdntra sceneResult.retCode :%d", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode));
                                this.cNi.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.cNi);
                            } else {
                                v.i(this.cNi.TAG, "cdntra getimg ok. need convert:%b", Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline));
                                if (b.cLy == 1) {
                                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 26, (long) b.cyu, false);
                                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 27, 1, false);
                                    com.tencent.mm.plugin.report.service.g.iuh.a(198, m.dE(this.cNi.aXd != null ? this.cNi.aXd.field_talker : SQLiteDatabase.KeyEmpty) ? 29 : 28, 1, false);
                                } else {
                                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 21, (long) b.cyu, false);
                                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 22, 1, false);
                                    com.tencent.mm.plugin.report.service.g.iuh.a(198, m.dE(this.cNi.aXd != null ? this.cNi.aXd.field_talker : SQLiteDatabase.KeyEmpty) ? 24 : 23, 1, false);
                                }
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline) {
                                    v.i(this.cNi.TAG, "cdntra need convert2baseline. file:%s", this.cNi.cMX);
                                    boolean Convert2Baseline = MMNativeJpeg.Convert2Baseline(this.cNi.cMX, 60);
                                    v.i(this.cNi.TAG, "convert result:%b", Boolean.valueOf(Convert2Baseline));
                                }
                                if (this.cNi.cNd) {
                                    this.cNi.a(b, b.offset, b.offset, 0, null);
                                } else {
                                    this.cNi.a(b, this.cNi.cyu, b.offset, this.cNi.cyu - b.offset, null);
                                }
                            }
                            r1 = com.tencent.mm.plugin.report.service.g.iuh;
                            r3 = new Object[16];
                            r3[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                            r3[1] = Integer.valueOf(2);
                            r3[2] = Long.valueOf(this.cNi.startTime);
                            r3[3] = Long.valueOf(be.Ni());
                            r3[4] = Integer.valueOf(d.aO(aa.getContext()));
                            r3[5] = Integer.valueOf(this.cNi.cMV);
                            r3[6] = Integer.valueOf(this.cNi.cyu);
                            r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? SQLiteDatabase.KeyEmpty : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                            r3[8] = SQLiteDatabase.KeyEmpty;
                            r3[9] = SQLiteDatabase.KeyEmpty;
                            r3[10] = SQLiteDatabase.KeyEmpty;
                            r3[11] = SQLiteDatabase.KeyEmpty;
                            r3[12] = SQLiteDatabase.KeyEmpty;
                            r3[13] = SQLiteDatabase.KeyEmpty;
                            r3[14] = SQLiteDatabase.KeyEmpty;
                            r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? SQLiteDatabase.KeyEmpty : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                            r1.h(10421, r3);
                        }
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == this.cNi.cyu) {
                        v.d(this.cNi.TAG, "cdntra ignore progress 100%");
                        return 0;
                    } else {
                        this.cNi.cNd = true;
                        if (!this.cNi.cMZ) {
                            this.cNi.cMZ = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify;
                        }
                        v.i(this.cNi.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", this.cNi.cMU, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Boolean.valueOf(this.cNi.cMZ));
                        this.cNi.a(b, this.cNi.cyu, b.offset, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength - b.offset, null);
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
        boolean z = j >= 0 && j2 >= 0 && fVar != null;
        Assert.assertTrue(z);
        this.cMP = fVar;
        this.cLy = i;
        this.cMQ = j;
        this.cMR = j;
        this.bao = j2;
        this.cNa = i2;
        d b2 = n.GH().b(Long.valueOf(this.cMR));
        if (i == 1) {
            this.cMR = (long) b2.cLE;
            b = n.GH().b(Long.valueOf(this.cMR));
        } else {
            b = b2;
        }
        this.TAG += "[" + this.cMR + "]";
        b.a aVar = new b.a();
        aVar.czn = new xg();
        aVar.czo = new xh();
        aVar.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        aVar.czm = MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
        aVar.czp = 10;
        aVar.czq = 1000000010;
        this.cif = aVar.Bv();
        xg xgVar = (xg) this.cif.czk.czs;
        ak.yW();
        this.aXd = c.wJ().ek(j2);
        xgVar.mdA = b.offset;
        xgVar.mdz = b.cyu;
        v.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", Integer.valueOf(b.offset), Integer.valueOf(b.cyu), be.bur());
        xgVar.mcb = this.aXd.field_msgSvrId;
        xgVar.mbU = new arf().JF(this.aXd.field_talker);
        arf com_tencent_mm_protocal_c_arf = new arf();
        ak.yW();
        xgVar.mbV = com_tencent_mm_protocal_c_arf.JF((String) c.vf().get(2, null));
        xgVar.mzC = i;
        if (b.offset == 0) {
            this.cMT = new g(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, false, (long) b.cyu);
        }
        this.cMS = 8192;
        if (fVar != null) {
            final int i3 = b.offset;
            final int i4 = b.cyu;
            ad.o(new Runnable(this) {
                final /* synthetic */ j cNi;

                public final void run() {
                    fVar.a(i3, i4, this.cNi);
                }
            });
        }
    }

    protected final int ul() {
        if (this.cLy == 0) {
            return 100;
        }
        return 1280;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void cancel() {
        if (!(be.kS(this.cMU) || com.tencent.mm.modelcdntran.g.DZ() == null)) {
            v.d(this.TAG, "cancel recv task");
            com.tencent.mm.modelcdntran.g.DZ().iq(this.cMU);
        }
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        xg xgVar = (xg) this.cif.czk.czs;
        d b = n.GH().b(Long.valueOf(this.cMR));
        if (b.cLu == 0) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 195, 1, false);
            v.e(this.TAG, "doScene id:%d  img:%s", Long.valueOf(this.cMR), b);
            return -1;
        } else if (b.status != 0) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 194, 1, false);
            v.e(this.TAG, "doSceneError, id:%d, status:%d", Long.valueOf(b.cLu), Integer.valueOf(b.status));
            return -1;
        } else {
            Object obj;
            if (b.cLv.startsWith("SERVERID://")) {
                this.cMW = com.tencent.mm.a.g.m(b.cLv.getBytes());
                this.cMX = n.GH().l(this.cMW, null, ".temp");
                b.iQ(this.cMW + ".temp");
                n.GH().a(Long.valueOf(this.cMR), b);
            } else {
                this.cMW = b.cLv;
                this.cMX = n.GH().l(this.cMW, null, SQLiteDatabase.KeyEmpty);
            }
            v.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", Long.valueOf(b.cLu), Integer.valueOf(this.cLy), Integer.valueOf(b.offset), Integer.valueOf(b.cyu), r4, this.cMW, this.cMX);
            if (this.startTime == 0) {
                this.startTime = be.Ni();
                this.startOffset = b.offset;
                this.cMV = this.cLy == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            String str = xgVar.mbU.mQy;
            long j = xgVar.mcb;
            if (be.kS(b.cLF)) {
                obj = null;
            } else {
                Map q = bf.q(b.cLF, "msg");
                if (q == null) {
                    v.e(this.TAG, "parse cdnInfo failed. [%s]", b.cLF);
                    obj = null;
                } else {
                    String str2;
                    this.cyu = 0;
                    if (this.cLy != 1) {
                        str = (String) q.get(".msg.img.$cdnmidimgurl");
                        this.cyu = be.getInt((String) q.get(".msg.img.$length"), 0);
                        str2 = str;
                    } else {
                        str = (String) q.get(".msg.img.$cdnbigimgurl");
                        this.cyu = be.getInt((String) q.get(".msg.img.$hdlength"), 0);
                        str2 = str;
                    }
                    v.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s]", Integer.valueOf(this.cLy), Integer.valueOf(this.cyu), str2);
                    if (be.kS(str2)) {
                        v.e(this.TAG, "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        str = (String) q.get(".msg.img.$aeskey");
                        if (be.kS(str)) {
                            v.e(this.TAG, "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            this.cMU = d.a("downimg", (long) b.cLB, this.aXd.field_talker, this.aXd.field_msgId);
                            if (be.kS(this.cMU)) {
                                v.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.cMR));
                                obj = null;
                            } else {
                                String str3 = (String) q.get(".msg.img.$md5");
                                if (!be.kS(str3) && (be.kS((String) q.get(".msg.img.$cdnbigimgurl")) || this.cLy == 1)) {
                                    String bL = ak.yW().wM().bL(str3, this.cyu);
                                    int aQ = com.tencent.mm.a.e.aQ(bL);
                                    int i = this.cyu - aQ;
                                    String str4 = this.TAG;
                                    String str5 = "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s";
                                    Integer[] numArr = new Object[8];
                                    numArr[0] = Integer.valueOf(this.cyu);
                                    numArr[1] = str3;
                                    numArr[2] = q.get(".msg.img.$cdnbigimgurl");
                                    numArr[3] = Boolean.valueOf(this.cLy == 1);
                                    numArr[4] = Integer.valueOf(aQ);
                                    numArr[5] = bL;
                                    numArr[6] = Integer.valueOf(i);
                                    numArr[7] = this.cMX;
                                    v.i(str4, str5, numArr);
                                    if (be.kS(bL)) {
                                        this.cNb = str3;
                                        this.cNc = this.cyu;
                                    } else if (i >= 0 && i <= 16) {
                                        boolean dz = com.tencent.mm.sdk.platformtools.j.dz(bL, this.cMX);
                                        v.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", bL, this.cMX, Boolean.valueOf(dz));
                                        a(b, this.cyu, this.cyu, 0, null);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(13267, str2, Long.valueOf(this.aXd.field_msgSvrId), str3, Long.valueOf(this.aXd.field_createTime / 1000), this.aXd.field_talker, Integer.valueOf(3), Integer.valueOf(aQ));
                                        obj = 1;
                                    }
                                }
                                h hVar = new h();
                                hVar.field_mediaId = this.cMU;
                                hVar.field_fullpath = this.cMX;
                                hVar.field_fileType = this.cMV;
                                hVar.field_totalLen = this.cyu;
                                hVar.field_aesKey = str;
                                hVar.field_fileId = str2;
                                hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                                hVar.cFR = this.cNe;
                                hVar.field_chattype = m.dE(this.aXd.field_talker) ? 1 : 0;
                                v.i(this.TAG, "cdnautostart %s %b", "image_" + this.aXd.field_msgId, Boolean.valueOf(com.tencent.mm.modelcdntran.g.DZ().cFg.contains("image_" + this.aXd.field_msgId)));
                                if (com.tencent.mm.modelcdntran.g.DZ().cFg.contains("image_" + this.aXd.field_msgId)) {
                                    com.tencent.mm.modelcdntran.g.DZ().cFg.remove("image_" + this.aXd.field_msgId);
                                    hVar.field_autostart = true;
                                } else {
                                    hVar.field_autostart = false;
                                }
                                if (com.tencent.mm.modelcdntran.g.DZ().a(hVar, this.cNa)) {
                                    v.d(this.TAG, "add recv task");
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.report.service.g.iuh.a(111, 196, 1, false);
                                    v.e(this.TAG, "addRecvTask failed :%s", this.cMU);
                                    this.cMU = SQLiteDatabase.KeyEmpty;
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                v.d(this.TAG, "cdntra this img use cdn : %s", this.cMU);
                return 0;
            }
            v.d(this.TAG, "cdntra this img NOT USE CDN: %s", this.cMU);
            b.iT(SQLiteDatabase.KeyEmpty);
            b.bkU = 4096;
            n.GH().a(Long.valueOf(this.cMR), b);
            xgVar.mdA = b.offset;
            xgVar.mdB = this.cMS;
            xgVar.mdz = b.cyu;
            if (this.cMT != null) {
                this.cMT.Kc();
            }
            return a(eVar, this.cif, this);
        }
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 3 && i3 == -1 && !be.kS(this.cMU)) {
            v.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.cMU);
        } else if (i2 == 0 && i3 == 0) {
            xh xhVar = (xh) ((b) pVar).czl.czs;
            d b = n.GH().b(Long.valueOf(this.cMR));
            Object obj = null;
            if (xhVar.mdB <= 0) {
                v.e(this.TAG, "flood control, malformed data_len");
                obj = -1;
            } else if (xhVar.mfg == null || xhVar.mdB != xhVar.mfg.mQu) {
                v.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                obj = -1;
            } else if (xhVar.mdA < 0 || xhVar.mdA + xhVar.mdB > xhVar.mdz) {
                v.e(this.TAG, "flood control, malformed start pos");
                obj = -1;
            } else if (xhVar.mdA != b.offset) {
                v.e(this.TAG, "flood control, malformed start_pos");
                obj = -1;
            } else if (xhVar.mdz <= 0) {
                v.e(this.TAG, "flood control, malformed total_len");
                obj = -1;
            }
            if (obj != null) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 192, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cMV), Integer.valueOf(this.cyu - this.startOffset));
                this.cii.a(4, -1, SQLiteDatabase.KeyEmpty, this);
                return;
            }
            if (a(b, xhVar.mdz, xhVar.mdA, xhVar.mdB, xhVar.mfg.mQw.lVU) && a(this.czE, this.cii) < 0) {
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            }
        } else {
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 193, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cMV), Integer.valueOf(this.cyu - this.startOffset));
            }
            this.cii.a(i2, i3, str, this);
        }
    }

    private boolean a(final d dVar, int i, int i2, int i3, byte[] bArr) {
        String str;
        boolean z;
        dVar.fx(i);
        dVar.setOffset(i2 + i3);
        this.cMS = i3;
        if (bArr != null) {
            com.tencent.mm.a.e.e(this.cMX, bArr);
        }
        v.d(this.TAG, "onGYNetEnd : offset = " + dVar.offset + " totalLen = " + dVar.cyu + " stack:[%s]", be.bur());
        if (dVar.Go()) {
            String str2;
            str = this.cMX;
            if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
                str = SQLiteDatabase.KeyEmpty;
            } else {
                byte[] c = com.tencent.mm.a.e.c(str, 0, 2);
                if (c == null || c.length < 2) {
                    str = SQLiteDatabase.KeyEmpty;
                } else {
                    str2 = ".jpg";
                    byte b = c[0];
                    if (b < (byte) 0) {
                        b += FileUtils.S_IRUSR;
                    }
                    byte b2 = c[1];
                    if (b2 < (byte) 0) {
                        b2 += FileUtils.S_IRUSR;
                    }
                    str = (b == (byte) 66 && b2 == (byte) 77) ? ".bmp" : (b == (byte) -1 && b2 == (byte) -40) ? ".jpg" : (b == (byte) -119 && b2 == (byte) 80) ? ".png" : (b == (byte) 71 && b2 == (byte) 73) ? ".gif" : str2;
                }
            }
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            boolean checkIsImageLegal = MMBitmapFactory.checkIsImageLegal(this.cMX, decodeResultLogger);
            File file = new File(this.cMX);
            if (checkIsImageLegal) {
                str2 = n.GH().l(this.cMW, null, str);
                v.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", str, this.cMW, this.cMX, str2);
                file.renameTo(new File(str2));
                dVar.iQ(this.cMW + str);
                dVar.iP(FileOp.jV(str2));
                dVar.fB(this.cLy);
                str = str2;
                if (n.GH().a(Long.valueOf(this.cMR), dVar) >= 0) {
                    v.e(this.TAG, "onGYNetEnd : update img fail");
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                    return false;
                }
                if (this.cMP != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ j cNi;

                        public final void run() {
                            this.cNi.cMP.a(dVar.offset, dVar.cyu, this.cNi);
                        }
                    });
                }
                v.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(dVar.Go()), this.cMU);
                if (dVar.Go()) {
                    return true;
                }
                if (be.kS(this.cMU)) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cMV), Integer.valueOf(i - this.startOffset));
                }
                z = false;
                if (this.cMY > 0) {
                    z = n.GH().a(str, dVar.cLx, this.cMY, 1);
                }
                if (z) {
                    dVar.bNt = 1;
                    dVar.cLV = true;
                    ak.yW();
                    c.wJ().a(this.aXd.field_msgId, this.aXd);
                }
                n.GH().a(Long.valueOf(this.cMR), dVar);
                v.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.cMX, str, dVar.cLv, this.cNb);
                if (this.cMT != null) {
                    this.cMT.aq((long) dVar.cyu);
                }
                if (!be.kS(this.cNb) && this.cNc > 0) {
                    ak.yW().wM().p(this.cNb, this.cNc, str);
                }
                this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
                return false;
            }
            file.delete();
            if (decodeResultLogger.getDecodeResult() >= 2000) {
                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(this.cMX, 2, decodeResultLogger));
            }
        }
        str = null;
        if (n.GH().a(Long.valueOf(this.cMR), dVar) >= 0) {
            if (this.cMP != null) {
                ad.o(/* anonymous class already generated */);
            }
            v.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(dVar.Go()), this.cMU);
            if (dVar.Go()) {
                return true;
            }
            if (be.kS(this.cMU)) {
                com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.cMV), Integer.valueOf(i - this.startOffset));
            }
            z = false;
            if (this.cMY > 0) {
                z = n.GH().a(str, dVar.cLx, this.cMY, 1);
            }
            if (z) {
                dVar.bNt = 1;
                dVar.cLV = true;
                ak.yW();
                c.wJ().a(this.aXd.field_msgId, this.aXd);
            }
            n.GH().a(Long.valueOf(this.cMR), dVar);
            v.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.cMX, str, dVar.cLv, this.cNb);
            if (this.cMT != null) {
                this.cMT.aq((long) dVar.cyu);
            }
            ak.yW().wM().p(this.cNb, this.cNc, str);
            this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
            return false;
        }
        v.e(this.TAG, "onGYNetEnd : update img fail");
        this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
        return false;
    }
}
