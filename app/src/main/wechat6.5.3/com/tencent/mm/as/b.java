package com.tencent.mm.as;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.as.a.c;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.protocal.c.no;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class b extends k implements j {
    String aST;
    int aYJ;
    String cMU;
    String cNb;
    int cNc;
    private a cNe;
    private com.tencent.mm.v.b cif;
    e cii;
    private ah cxS;
    int cyu;
    boolean dgn;
    n dgo;
    i dgp;
    int dgq;
    private boolean dgr;
    long dgs;
    private String mediaId;
    private int startOffset;
    long startTime;

    public final boolean ph() {
        boolean z = false;
        if (!be.kS(this.mediaId)) {
            if (this.dgn) {
                v.i("MicroMsg.NetSceneDownloadVideo", "cancel online video task.");
                g.DY().b(this.mediaId, null);
            } else {
                v.i("MicroMsg.NetSceneDownloadVideo", "cancel offline video task.");
                g.DZ().iq(this.mediaId);
            }
            z = true;
        }
        this.dgr = true;
        return z;
    }

    public b(String str) {
        this(str, false);
    }

    public b(String str, boolean z) {
        boolean z2 = false;
        this.dgo = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startOffset = 0;
        this.startTime = 0;
        this.cyu = 0;
        this.aYJ = 0;
        this.dgq = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.dgr = false;
        this.cNb = null;
        this.cNc = 0;
        this.dgs = 0;
        this.cNe = new a(this) {
            final /* synthetic */ b dgt;

            {
                this.dgt = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21006) {
                    v.d("MicroMsg.NetSceneDownloadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", this.dgt.cMU);
                    return 0;
                } else if (i != 0) {
                    p.lh(this.dgt.aST);
                    com.tencent.mm.plugin.report.service.g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.dgt.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.dgt.dgq), Integer.valueOf(this.dgt.cyu), SQLiteDatabase.KeyEmpty);
                    this.dgt.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.dgt);
                    return 0;
                } else {
                    this.dgt.dgo = p.lp(this.dgt.aST);
                    if (this.dgt.dgo == null || this.dgt.dgo.status == MMGIFException.D_GIF_ERR_EOF_TOO_SOON) {
                        v.i("MicroMsg.NetSceneDownloadVideo", "upload video info is null or has paused, status:%d", Integer.valueOf(this.dgt.dgo == null ? -1 : this.dgt.dgo.status));
                        this.dgt.ph();
                        this.dgt.cii.a(3, i, "upload video info is null or has paused, status" + r0, this.dgt);
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            v.i("MicroMsg.NetSceneDownloadVideo", "cdntra sceneResult.retCode:%d useTime:%d ", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(be.Ni() - this.dgt.dgs));
                            i iVar = this.dgt.dgp;
                            if (iVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                                v.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
                            } else if (iVar.field_smallVideoFlag == 1) {
                                v.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
                            } else if (!(iVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null)) {
                                v.i("MicroMsg.NetSceneDownloadVideo", "sceneResult.field_recvedBytes %d, time [%d, %d]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes), Long.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime), Long.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime));
                                g.DY();
                                f.a(null, com_tencent_mm_modelcdntran_keep_SceneResult, iVar);
                            }
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                p.lh(this.dgt.aST);
                                if (this.dgt.dgn) {
                                    com.tencent.mm.plugin.report.service.g.iuh.a(354, 13, 1, false);
                                }
                                this.dgt.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.dgt);
                            } else {
                                if (this.dgt.dgn) {
                                    com.tencent.mm.plugin.report.service.g.iuh.a(354, 12, 1, false);
                                }
                                this.dgt.gt(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.h(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.dgt.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.dgt.dgq), Integer.valueOf(this.dgt.cyu), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            c.a(this.dgt.dgo, 1);
                            this.dgt.dgp = null;
                        }
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == this.dgt.cyu) {
                        v.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                        return 0;
                    } else if (this.dgt.dgo.dhE <= com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength || this.dgt.dgn) {
                        this.dgt.dgo.dhI = be.Nh();
                        this.dgt.dgo.dhE = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                        this.dgt.dgo.bkU = 1040;
                        p.e(this.dgt.dgo);
                        v.d("MicroMsg.NetSceneDownloadVideo", "cdntra progresscallback id:%s finish:%d total:%d", this.dgt.cMU, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength));
                        return 0;
                    } else {
                        v.e("MicroMsg.NetSceneDownloadVideo", "cdnEndProc error oldpos:%d newpos:%d", Integer.valueOf(this.dgt.dgo.dhE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                        p.lh(this.dgt.aST);
                        this.dgt.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.dgt);
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
        this.cxS = new ah(new ah.a(this) {
            final /* synthetic */ b dgt;

            {
                this.dgt = r1;
            }

            public final boolean oU() {
                if (this.dgt.a(this.dgt.czE, this.dgt.cii) == -1) {
                    this.dgt.cii.a(3, -1, "doScene failed", this.dgt);
                }
                return false;
            }
        }, false);
        if (str != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        v.i("MicroMsg.NetSceneDownloadVideo", "NetSceneDownloadVideo:  file:" + str + " isCompleteOnlineVideo : " + z);
        this.aST = str;
        this.dgn = z;
    }

    private boolean KL() {
        v.d("MicroMsg.NetSceneDownloadVideo", "parseVideoMsgXML content:" + this.dgo.Lg());
        Map q = bf.q(this.dgo.Lg(), "msg");
        if (q == null) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 214, 1, false);
            v.w("MicroMsg.NetSceneDownloadVideo", "cdntra parse video recv xml failed");
            return false;
        }
        String str = (String) q.get(".msg.videomsg.$cdnvideourl");
        if (be.kS(str)) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 213, 1, false);
            v.w("MicroMsg.NetSceneDownloadVideo", "cdntra parse video recv xml failed");
            return false;
        }
        String str2 = (String) q.get(".msg.videomsg.$aeskey");
        this.cyu = Integer.valueOf((String) q.get(".msg.videomsg.$length")).intValue();
        String str3 = (String) q.get(".msg.videomsg.$fileparam");
        this.cMU = d.a("downvideo", this.dgo.dhH, this.dgo.Ld(), this.dgo.getFileName());
        if (be.kS(this.cMU)) {
            v.w("MicroMsg.NetSceneDownloadVideo", "cdntra genClientId failed not use cdn file:%s", this.dgo.getFileName());
            return false;
        }
        int i;
        Object obj;
        String Ld;
        int i2;
        NetworkInfo activeNetworkInfo;
        int subtype;
        String str4 = (String) q.get(".msg.videomsg.$md5");
        StringBuilder stringBuilder = new StringBuilder();
        k.KV();
        String stringBuilder2 = stringBuilder.append(o.lc(this.aST)).append(".tmp").toString();
        this.dgp = new i();
        this.dgp.filename = this.dgo.getFileName();
        this.dgp.cFT = str4;
        this.dgp.cFU = this.cyu;
        this.dgp.cFV = false;
        this.dgp.cFW = this.dgo.Ld();
        this.dgp.bhN = m.dE(this.dgo.Ld()) ? com.tencent.mm.model.i.el(this.dgo.Ld()) : 0;
        this.dgp.field_mediaId = this.cMU;
        this.dgp.field_fullpath = stringBuilder2;
        this.dgp.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.dgp.field_totalLen = this.cyu;
        this.dgp.field_aesKey = str2;
        this.dgp.field_fileId = str;
        this.dgp.field_priority = com.tencent.mm.modelcdntran.b.cEA;
        this.dgp.cFR = this.cNe;
        this.dgp.field_wxmsgparam = str3;
        this.dgp.field_chattype = m.dE(this.dgo.Ld()) ? 1 : 0;
        this.dgp.cFX = this.dgo.cFX;
        ak.yW();
        bx S = com.tencent.mm.model.c.wJ().S(this.dgo.Ld(), this.dgo.bmL);
        if (this.dgo.Ld().equals(S.field_talker)) {
            com.tencent.mm.model.aw.b fP = aw.fP(S.bNo);
            this.dgp.field_limitrate = fP == null ? 0 : fP.ctE / 8;
        }
        v.d("MicroMsg.NetSceneDownloadVideo", "limitrate:%d file:%s", Integer.valueOf(this.dgp.field_limitrate), this.dgo.getFileName());
        if (g.DZ().cFg.contains("video_" + this.dgo.dhL)) {
            g.DZ().cFg.remove("video_" + this.dgo.dhL);
            this.dgp.field_autostart = true;
        } else {
            this.dgp.field_autostart = false;
        }
        if (3 == this.dgo.dhR) {
            this.dgp.field_smallVideoFlag = 1;
        }
        if (!(be.kS(str4) || this.dgn)) {
            str2 = ak.yW().wM().bL(str4, this.cyu);
            int aQ = com.tencent.mm.a.e.aQ(str2);
            int i3 = this.cyu - aQ;
            k.KV();
            str3 = o.lc(this.aST);
            if (com.tencent.mm.a.e.aQ(str3) > 0) {
                v.w("MicroMsg.NetSceneDownloadVideo", "already copy dup file, but download again, something error here.");
                boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(str3);
                as wM = ak.yW().wM();
                int i4 = this.cyu;
                i = 0;
                if (!be.kS(str4)) {
                    i = wM.cie.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str4, String.valueOf(i4), "100"});
                }
                str3 = SQLiteDatabase.KeyEmpty;
                n lp = p.lp(this.aST);
                lp.dhE = 0;
                lp.bkU = 16;
                p.e(lp);
                v.w("MicroMsg.NetSceneDownloadVideo", "don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", Integer.valueOf(r8), Boolean.valueOf(deleteFile), Integer.valueOf(i));
                str2 = str3;
            }
            v.i("MicroMsg.NetSceneDownloadVideo", "MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", Integer.valueOf(this.cyu), str4, Integer.valueOf(aQ), str2, Integer.valueOf(i3), stringBuilder2, Integer.valueOf(r8));
            if (be.kS(str2)) {
                this.cNb = str4;
                this.cNc = this.cyu;
            } else if (i3 >= 0 && i3 <= 16) {
                v.i("MicroMsg.NetSceneDownloadVideo", "MediaCheckDuplicationStorage copy dup file now :%s -> %s", str2, stringBuilder2);
                com.tencent.mm.sdk.platformtools.j.dz(str2, stringBuilder2);
                gt(this.cyu);
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                Object[] objArr = new Object[7];
                objArr[0] = str;
                objArr[1] = Long.valueOf(this.dgo.bmL);
                objArr[2] = str4;
                objArr[3] = Long.valueOf(this.dgo.dhH);
                objArr[4] = this.dgo.Ld();
                objArr[5] = Integer.valueOf(3 != this.dgo.dhR ? 43 : 62);
                objArr[6] = Integer.valueOf(aQ);
                gVar.h(13267, objArr);
                obj = 1;
                if (obj == null) {
                    this.mediaId = this.dgp.field_mediaId;
                    this.dgs = be.Ni();
                    if (this.dgn) {
                        i iVar = this.dgp;
                        k.KV();
                        iVar.field_fullpath = o.lc(this.aST);
                        g.DY().a(this.dgp, false);
                    } else if (!g.DZ().a(this.dgp, -1)) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(111, 212, 1, false);
                        v.e("MicroMsg.NetSceneDownloadVideo", "cdntra addSendTask failed.");
                        this.cMU = SQLiteDatabase.KeyEmpty;
                        return false;
                    }
                }
                if (this.dgo.dhP != 1) {
                    this.dgo.dhP = 1;
                    this.dgo.bkU = 524288;
                    p.e(this.dgo);
                }
                if (3 != this.dgo.dhR) {
                    Ld = this.dgo.Ld();
                    if (!be.kS(Ld)) {
                        if (m.dE(Ld)) {
                            i2 = 0;
                        } else {
                            i2 = com.tencent.mm.model.i.el(Ld);
                        }
                        try {
                            activeNetworkInfo = ((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                            subtype = activeNetworkInfo.getSubtype();
                            if (activeNetworkInfo.getType() != 1) {
                                i = 1;
                            } else if (subtype != 13 || subtype == 15 || subtype == 14) {
                                i = 4;
                            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                                i = 3;
                            } else if (subtype == 1 || subtype == 2) {
                                i = 2;
                            } else {
                                i = 0;
                            }
                        } catch (Throwable e) {
                            v.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", be.e(e));
                            i = 0;
                        }
                        v.i("MicroMsg.NetSceneDownloadVideo", "dk12024 report:%s", Ld + "," + i2 + "," + str + "," + this.cyu + "," + i);
                        com.tencent.mm.plugin.report.service.g.iuh.Y(12024, str);
                    }
                }
                return true;
            }
        }
        obj = null;
        if (obj == null) {
            this.mediaId = this.dgp.field_mediaId;
            this.dgs = be.Ni();
            if (this.dgn) {
                i iVar2 = this.dgp;
                k.KV();
                iVar2.field_fullpath = o.lc(this.aST);
                g.DY().a(this.dgp, false);
            } else if (g.DZ().a(this.dgp, -1)) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 212, 1, false);
                v.e("MicroMsg.NetSceneDownloadVideo", "cdntra addSendTask failed.");
                this.cMU = SQLiteDatabase.KeyEmpty;
                return false;
            }
        }
        if (this.dgo.dhP != 1) {
            this.dgo.dhP = 1;
            this.dgo.bkU = 524288;
            p.e(this.dgo);
        }
        if (3 != this.dgo.dhR) {
            Ld = this.dgo.Ld();
            if (be.kS(Ld)) {
                if (m.dE(Ld)) {
                    i2 = 0;
                } else {
                    i2 = com.tencent.mm.model.i.el(Ld);
                }
                activeNetworkInfo = ((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                subtype = activeNetworkInfo.getSubtype();
                if (activeNetworkInfo.getType() != 1) {
                    if (subtype != 13) {
                    }
                    i = 4;
                } else {
                    i = 1;
                }
                v.i("MicroMsg.NetSceneDownloadVideo", "dk12024 report:%s", Ld + "," + i2 + "," + str + "," + this.cyu + "," + i);
                com.tencent.mm.plugin.report.service.g.iuh.Y(12024, str);
            }
        }
        return true;
    }

    final void gt(final int i) {
        StringBuilder stringBuilder = new StringBuilder();
        k.KV();
        File file = new File(stringBuilder.append(o.lc(this.aST)).append(".tmp").toString());
        k.KV();
        file.renameTo(new File(o.lc(this.aST)));
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ b dgt;

            public final void run() {
                Map q = bf.q(this.dgt.dgo.Lg(), "msg");
                if (q != null) {
                    o KV = k.KV();
                    k.KV();
                    KV.o(o.lc(this.dgt.aST), (String) q.get(".msg.videomsg.$cdnvideourl"), (String) q.get(".msg.videomsg.$aeskey"));
                }
                boolean E = p.E(this.dgt.aST, i);
                v.i("MicroMsg.NetSceneDownloadVideo", "ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d", this.dgt.aST, Long.valueOf(this.dgt.dgo.bmL), this.dgt.dgo.Le(), this.dgt.dgo.Ld(), Boolean.valueOf(E), this.dgt.cNb, Integer.valueOf(this.dgt.cNc));
                if (!be.kS(this.dgt.cNb) && this.dgt.cNc > 0) {
                    as wM = ak.yW().wM();
                    String str = this.dgt.cNb;
                    int i = this.dgt.cNc;
                    k.KV();
                    wM.p(str, i, o.lc(this.dgt.aST));
                }
                if (this.dgt.dgo.dhR == 3) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 38, (long) this.dgt.dgo.cyu, false);
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 40, (long) this.dgt.dgo.dhK, false);
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 41, 1, false);
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, m.dE(this.dgt.dgo.Ld()) ? 43 : 42, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 31, (long) this.dgt.dgo.cyu, false);
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 33, (long) this.dgt.dgo.dhK, false);
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, 34, 1, false);
                    com.tencent.mm.plugin.report.service.g.iuh.a(198, m.dE(this.dgt.dgo.Ld()) ? 36 : 35, 1, false);
                }
                this.dgt.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this.dgt);
            }
        });
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 1;
        this.cii = eVar2;
        this.dgo = p.lp(this.aST);
        if (this.dgo == null) {
            v.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.aST);
            this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
            return -1;
        }
        if (this.dgo != null && 3 == this.dgo.dhR) {
            this.dgq = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = be.Ni();
            this.startOffset = this.dgo.dhE;
        }
        if (KL()) {
            v.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.aST);
            return 0;
        } else if (this.dgo.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            v.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.dgo.status + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "]");
            this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
            return -1;
        } else {
            v.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "]  filesize:" + this.dgo.dhE + " file:" + this.dgo.cyu + " netTimes:" + this.dgo.dhM);
            if (!p.lg(this.aST)) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.dgo.dhM + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                return -1;
            } else if (this.dgo.bmL <= 0) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.dgo.bmL + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                return -1;
            } else if (this.dgo.dhE < 0 || this.dgo.cyu <= this.dgo.dhE || this.dgo.cyu <= 0) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.dgo.dhE + " total:" + this.dgo.cyu + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                return -1;
            } else {
                com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
                aVar.czn = new nn();
                aVar.czo = new no();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                aVar.czm = 150;
                aVar.czp = 40;
                aVar.czq = 1000000040;
                this.cif = aVar.Bv();
                nn nnVar = (nn) this.cif.czk.czs;
                nnVar.mcb = this.dgo.bmL;
                nnVar.mdA = this.dgo.dhE;
                nnVar.mdz = this.dgo.cyu;
                if (!com.tencent.mm.network.aa.bk(aa.getContext())) {
                    i = 2;
                }
                nnVar.mpt = i;
                return a(eVar, this.cif, this);
            }
        }
    }

    protected final int a(p pVar) {
        nn nnVar = (nn) ((com.tencent.mm.v.b) pVar).czk.czs;
        if (nnVar.mcb > 0 && nnVar.mdA >= 0 && nnVar.mdz > 0 && nnVar.mdz > nnVar.mdA) {
            return b.czU;
        }
        v.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
        p.lh(this.aST);
        return b.czV;
    }

    protected final int ul() {
        return 2500;
    }

    public final boolean BA() {
        boolean BA = super.BA();
        if (BA) {
            com.tencent.mm.plugin.report.service.g.iuh.a(111, 210, 1, false);
        }
        return BA;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.iuh.a(111, 211, 1, false);
        p.lh(this.aST);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (this.dgr) {
            v.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !be.kS(this.cMU)) {
            v.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.cMU);
        } else {
            no noVar = (no) ((com.tencent.mm.v.b) pVar).czl.czs;
            nn nnVar = (nn) ((com.tencent.mm.v.b) pVar).czk.czs;
            this.dgo = p.lp(this.aST);
            if (this.dgo == null) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.aST);
                this.aYJ = (0 - com.tencent.mm.compatible.util.g.sk()) - 10000;
                this.cii.a(i2, i3, str, this);
            } else if (this.dgo.status == MMGIFException.D_GIF_ERR_EOF_TOO_SOON) {
                v.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                this.cii.a(i2, i3, str, this);
            } else if (this.dgo.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.dgo.status + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                this.cii.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 208, 1, false);
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.dgq), Integer.valueOf(this.cyu - this.startOffset));
                this.cii.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 207, 1, false);
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i2 + " errCode:" + i3 + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                this.dgo.status = MMGIFException.D_GIF_ERR_EOF_TOO_SOON;
                p.e(this.dgo);
                this.cii.a(i2, i3, str, this);
            } else if (be.bl(noVar.mfg.mQw.lVU)) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.cii.a(i2, i3, str, this);
            } else if (noVar.mdA != nnVar.mdA) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + noVar.mdA + " reqStartPos:" + nnVar.mdA + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.cii.a(i2, i3, str, this);
            } else if (noVar.mdz != nnVar.mdz) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + noVar.mdz + " reqTotal:" + nnVar.mdz + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.cii.a(i2, i3, str, this);
            } else if (nnVar.mdz < noVar.mdA) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + noVar.mdz + " respStartPos:" + nnVar.mdA + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.cii.a(i2, i3, str, this);
            } else if (noVar.mcb != nnVar.mcb) {
                v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + noVar.mcb + " reqMsgId:" + nnVar.mcb + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                p.lh(this.aST);
                this.cii.a(i2, i3, str, this);
            } else {
                v.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + noVar.mfg.mQu + " reqStartPos:" + nnVar.mdA + " totallen:" + nnVar.mdz + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                k.KV();
                int a = o.a(o.lc(this.aST), nnVar.mdA, noVar.mfg.mQw.toByteArray());
                if (a < 0) {
                    v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                    p.lh(this.aST);
                    this.cii.a(i2, i3, str, this);
                } else if (a > this.dgo.cyu) {
                    v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a + " totalLen:" + this.dgo.cyu + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                    p.lh(this.aST);
                    this.cii.a(i2, i3, str, this);
                } else {
                    int sk;
                    String str2 = this.aST;
                    n lp = p.lp(str2);
                    if (lp == null) {
                        v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " getinfo failed: " + str2);
                        sk = 0 - com.tencent.mm.compatible.util.g.sk();
                    } else {
                        lp.dhE = a;
                        lp.dhI = be.Nh();
                        lp.bkU = 1040;
                        sk = 0;
                        if (lp.cyu > 0 && a >= lp.cyu) {
                            p.d(lp);
                            lp.status = 199;
                            lp.bkU |= FileUtils.S_IRUSR;
                            v.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a + " total:" + lp.cyu + " status:" + lp.status + " netTimes:" + lp.dhM);
                            sk = 1;
                        }
                        v.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.sm() + " file:" + str2 + " newsize:" + a + " total:" + lp.cyu + " status:" + lp.status);
                        if (!p.e(lp)) {
                            sk = 0 - com.tencent.mm.compatible.util.g.sk();
                        }
                    }
                    if (sk < 0) {
                        v.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + sk + " newOffset :" + a + " [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "] ");
                        this.cii.a(i2, i3, str, this);
                    } else if (sk == 1) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(this.dgq), Integer.valueOf(this.cyu - this.startOffset));
                        c.a(this.dgo, 1);
                        v.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.aST + "," + this.dgo.bmL + "," + this.dgo.Le() + "," + this.dgo.Ld() + "]");
                        this.cii.a(i2, i3, str, this);
                    } else if (this.dgr) {
                        this.cii.a(i2, i3, str, this);
                    } else {
                        this.cxS.ea(0);
                    }
                }
            }
        }
    }

    public final int getType() {
        return 150;
    }
}
