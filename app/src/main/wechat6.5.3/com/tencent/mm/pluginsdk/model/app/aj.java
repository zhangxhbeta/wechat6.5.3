package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bbo;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

public final class aj extends k implements j {
    a aXe = null;
    int aYJ = 0;
    String aZj;
    String cMU = SQLiteDatabase.KeyEmpty;
    int cNA = 0;
    keep_SceneResult cNB;
    c cND = new c<kv>(this) {
        final /* synthetic */ aj lBe;

        {
            this.lBe = r2;
            this.nhz = kv.class.getName().hashCode();
        }

        private boolean a(kv kvVar) {
            if (kvVar.bme.filePath.equals(this.lBe.lAG.field_fileFullPath)) {
                String str = SQLiteDatabase.KeyEmpty;
                try {
                    str = URLEncoder.encode(kvVar.bme.bfz, "UTF-8");
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneUploadAppAttach", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                if (this.lBe.cNA == 1) {
                    ak.yW();
                    bx ek = com.tencent.mm.model.c.wJ().ek(this.lBe.lAG.field_msgInfoId);
                    com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                    cVar.n("20toUser", this.lBe.toUser + ",");
                    cVar.n("21source", "4,");
                    cVar.n("22qrUrl", str + ",");
                    cVar.n("23md5", (this.lBe.cNB == null ? SQLiteDatabase.KeyEmpty : this.lBe.cNB.field_filemd5) + ",");
                    cVar.n("24cdnFileId", (this.lBe.cNB == null ? SQLiteDatabase.KeyEmpty : this.lBe.cNB.field_fileId) + ",");
                    cVar.n("25cdnAesKey", (this.lBe.cNB == null ? SQLiteDatabase.KeyEmpty : this.lBe.cNB.field_aesKey) + ",");
                    str = SQLiteDatabase.KeyEmpty;
                    if (ek.bvY()) {
                        a dV = a.dV(ek.field_content);
                        if (dV != null) {
                            str = dV.appId;
                        }
                    }
                    cVar.n("26appip", str + ",");
                    cVar.n("2toUsersCount", i.el(this.lBe.toUser) + ",");
                    v.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + cVar.JH());
                    n.aB(13628, cVar.toString());
                }
                com.tencent.mm.sdk.c.a.nhr.f(this.lBe.cND);
            }
            return false;
        }
    };
    private h.a cNe = new h.a(this) {
        final /* synthetic */ aj lBe;

        {
            this.lBe = r1;
        }

        public final int a(String str, final int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            String str2 = "MicroMsg.NetSceneUploadAppAttach";
            String str3 = "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
            Object[] objArr = new Object[7];
            objArr[0] = this.lBe.cMU;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
            objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
            objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo != null);
            objArr[5] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult != null);
            objArr[6] = Boolean.valueOf(z);
            v.d(str2, str3, objArr);
            am.Wf().b(this.lBe.iFb, this.lBe.lAG);
            if (i == -21005) {
                v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.lBe.cMU);
                return 0;
            } else if (i != 0) {
                l.dA(this.lBe.lAG.nmb);
                am.Wf().b(this.lBe.iFb, this.lBe.lAG);
                this.lBe.lAG.field_signature = SQLiteDatabase.KeyEmpty;
                r0 = am.Wf().a(this.lBe.lAG, new String[0]);
                v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Long.valueOf(this.lBe.iFb), Boolean.valueOf(r0));
                this.lBe.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lBe);
                g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.lBe.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), SQLiteDatabase.KeyEmpty);
                return 0;
            } else if (this.lBe.lAG.field_status == 105) {
                v.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", Long.valueOf(this.lBe.lAG.field_status), Long.valueOf(this.lBe.iFb));
                com.tencent.mm.modelcdntran.g.DZ().ip(this.lBe.cMU);
                this.lBe.cii.a(3, i, "attach  has paused, status" + this.lBe.lAG.field_status, this.lBe);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        l.dA(this.lBe.lAG.nmb);
                        am.Wf().b(this.lBe.iFb, this.lBe.lAG);
                        this.lBe.lAG.field_signature = SQLiteDatabase.KeyEmpty;
                        r0 = am.Wf().a(this.lBe.lAG, new String[0]);
                        v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(this.lBe.iFb), Boolean.valueOf(r0));
                        g.iuh.h(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.lBe.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.lBe.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.lBe);
                    } else {
                        v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), be.KW(this.lBe.lAG.field_signature));
                        if (!z) {
                            a(i, com_tencent_mm_modelcdntran_keep_SceneResult);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck) {
                            ak.vy().a(new y(this.lBe.aXe, this.lBe.lAG.field_fileFullPath, this.lBe.toUser, new y.a(this) {
                                final /* synthetic */ AnonymousClass1 lBg;

                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z = true;
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = be.KW(str2);
                                    objArr[2] = be.KW(str3);
                                    objArr[3] = be.KW(str4);
                                    objArr[4] = be.KW(str5);
                                    if (this.lBg.lBe.aXe != null) {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(this.lBg.lBe.cNm);
                                    v.i(str6, str7, objArr);
                                    if (!be.kS(str3)) {
                                        this.lBg.lBe.lAG.field_signature = str3;
                                        this.lBg.lBe.lAG.field_fakeAeskey = str4;
                                        this.lBg.lBe.lAG.field_fakeSignature = str5;
                                    }
                                    this.lBg.a(i, com_tencent_mm_modelcdntran_keep_SceneResult);
                                }
                            }), 0);
                        } else {
                            v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                            ak.vy().a(new y(null, this.lBe.lAG.field_fileFullPath, this.lBe.toUser, new y.a(this) {
                                final /* synthetic */ AnonymousClass1 lBg;

                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z = true;
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = be.KW(str2);
                                    objArr[2] = be.KW(str3);
                                    objArr[3] = be.KW(str4);
                                    objArr[4] = be.KW(str5);
                                    if (this.lBg.lBe.aXe != null) {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(this.lBg.lBe.cNm);
                                    v.i(str6, str7, objArr);
                                    if (!be.kS(str3)) {
                                        this.lBg.lBe.lAG.field_signature = str3;
                                        this.lBg.lBe.lAG.field_fakeAeskey = str4;
                                        this.lBg.lBe.lAG.field_fakeSignature = str5;
                                        this.lBg.lBe.lAG.field_lastModifyTime = be.Ni();
                                        if (this.lBg.lBe.aXe != null) {
                                            this.lBg.lBe.aXe.filemd5 = str;
                                            this.lBg.lBe.aXe.cop = str2;
                                            this.lBg.lBe.aXe.cob = (int) j;
                                            ak.yW();
                                            at ek = com.tencent.mm.model.c.wJ().ek(this.lBg.lBe.lAG.field_msgInfoId);
                                            ek.setContent(a.b(this.lBg.lBe.aXe));
                                            ak.yW();
                                            com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
                                        }
                                    }
                                    this.lBg.lBe.cNm = false;
                                    z = am.Wf().a(this.lBg.lBe.lAG, new String[0]);
                                    if (z) {
                                        ak.vA().x(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass2 lBh;

                                            {
                                                this.lBh = r1;
                                            }

                                            public final void run() {
                                                v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                                                this.lBh.lBg.lBe.a(this.lBh.lBg.lBe.czE, this.lBh.lBg.lBe.cii);
                                            }
                                        });
                                        return;
                                    }
                                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + z);
                                    this.lBg.lBe.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                                    this.lBg.lBe.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lBg.lBe);
                                }
                            }), 0);
                        }
                    }
                }
                return 0;
            } else if (this.lBe.lAG.field_offset > ((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)) {
                v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(this.lBe.lAG.field_offset), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                return 0;
            } else {
                this.lBe.lAG.field_lastModifyTime = be.Nh();
                this.lBe.lAG.field_offset = (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                r0 = am.Wf().a(this.lBe.lAG, new String[0]);
                if (r0) {
                    return 0;
                }
                v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + r0);
                this.lBe.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                this.lBe.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lBe);
                return 0;
            }
        }

        final void a(int i, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
            this.lBe.lAG.field_status = 199;
            boolean a = am.Wf().a(this.lBe.lAG, new String[0]);
            if (a) {
                l.n(this.lBe.lAG.field_msgInfoId, this.lBe.lAG.field_mediaSvrId);
                ak.vy().a(new ah(this.lBe.lAG.field_msgInfoId, true, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                    final /* synthetic */ AnonymousClass1 lBg;

                    public final void aS(int i, int i2) {
                        v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 4 && i2 == MMGIFException.D_GIF_ERR_READ_FAILED) {
                            ak.vA().x(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 lBi;

                                {
                                    this.lBi = r1;
                                }

                                public final void run() {
                                    this.lBi.lBg.lBe.cNm = false;
                                    this.lBi.lBg.lBe.lAG.field_createTime = be.Ni();
                                    this.lBi.lBg.lBe.lAG.field_lastModifyTime = be.Nh();
                                    this.lBi.lBg.lBe.lAG.field_offset = 0;
                                    this.lBi.lBg.lBe.lAG.field_status = 101;
                                    boolean a = am.Wf().a(this.lBi.lBg.lBe.lAG, new String[0]);
                                    v.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(this.lBi.lBg.lBe.cNm), Boolean.valueOf(a), Long.valueOf(this.lBi.lBg.lBe.lAG.field_createTime));
                                    this.lBi.lBg.lBe.a(this.lBi.lBg.lBe.czE, this.lBi.lBg.lBe.cii);
                                }
                            });
                            return;
                        }
                        g.iuh.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.lBg.lBe.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        if (i == 0 && i2 == 0) {
                            this.lBg.lBe.c(com_tencent_mm_modelcdntran_keep_SceneResult);
                        }
                        this.lBg.lBe.cii.a(i, i2, SQLiteDatabase.KeyEmpty, this.lBg.lBe);
                    }
                }, this.lBe.aZj, this.lBe.lAG), 0);
                return;
            }
            v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + a);
            this.lBe.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            this.lBe.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lBe);
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    boolean cNm = true;
    private boolean cNy = false;
    private com.tencent.mm.v.b cif;
    e cii;
    private String cod = null;
    long iFb = -1;
    b lAG = null;
    private boolean lBc = true;
    private long lBd = -1;
    long startTime = 0;
    String toUser;

    public aj(long j, String str, String str2) {
        this.iFb = j;
        this.cod = str;
        this.aZj = str2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bbo();
        aVar.czo = new bbp();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.czm = 220;
        aVar.czp = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
        aVar.czq = 1000000105;
        this.cif = aVar.Bv();
        v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", Long.valueOf(j), str, be.bur());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        this.lAG = new b();
        if (!am.Wf().b(this.iFb, this.lAG) || this.lAG == null) {
            v.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sm() + " summerbig get info failed rowid:" + this.iFb);
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            this.lAG = null;
            return -1;
        } else if (this.lAG.field_status != 101) {
            v.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sm() + " summerbig get field_status failed rowid:" + this.iFb + " status:" + this.lAG.field_status);
            return -1;
        } else {
            Object obj;
            if (this.startTime == 0) {
                this.startTime = be.Ni();
                this.lBd = this.lAG.field_offset;
            }
            v.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", Long.valueOf(this.iFb), this.lAG.field_fileFullPath, Long.valueOf(this.lAG.field_totalLen), Boolean.valueOf(this.lAG.field_isUpload), Integer.valueOf(this.lAG.field_isUseCdn), Long.valueOf(this.lAG.field_type));
            if (this.lAG.field_type == 8 || this.lAG.field_type == 9) {
                v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", Long.valueOf(this.lAG.field_type));
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.DZ();
                if (com.tencent.mm.modelcdntran.c.fk(4) || this.lAG.field_isUseCdn == 1) {
                    ak.yW();
                    bx ek = com.tencent.mm.model.c.wJ().ek(this.lAG.field_msgInfoId);
                    if (ek.field_msgId != this.lAG.field_msgInfoId) {
                        v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId:%d", Long.valueOf(this.lAG.field_msgInfoId));
                        this.toUser = null;
                        obj = null;
                    } else {
                        this.toUser = ek.field_talker;
                        String str = SQLiteDatabase.KeyEmpty;
                        if (!be.kS(ek.field_imgPath)) {
                            str = com.tencent.mm.ae.n.GH().iW(ek.field_imgPath);
                        }
                        int aQ = com.tencent.mm.a.e.aQ(str);
                        int aQ2 = com.tencent.mm.a.e.aQ(this.lAG.field_fileFullPath);
                        if (aQ >= b.cEP) {
                            v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(aQ));
                            obj = null;
                        } else {
                            this.cMU = d.a("upattach", this.lAG.field_createTime, ek.field_talker, this.iFb);
                            v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", Long.valueOf(this.lAG.field_createTime), this.cMU);
                            if (be.kS(this.cMU)) {
                                v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.iFb));
                                obj = null;
                            } else {
                                Object obj2;
                                h hVar = new h();
                                String str2 = ek.field_content;
                                if (m.dE(ek.field_talker)) {
                                    int fK = aw.fK(ek.field_content);
                                    if (fK != -1) {
                                        str2 = (ek.field_content + " ").substring(fK + 2).trim();
                                    }
                                }
                                this.aXe = a.dV(be.KK(str2));
                                if (this.aXe != null) {
                                    v.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", this.aXe.coi, be.KW(this.aXe.cop), this.aXe.filemd5, Integer.valueOf(this.aXe.type));
                                    hVar.field_fileId = this.aXe.coi;
                                    hVar.field_aesKey = this.aXe.cop;
                                    hVar.field_filemd5 = this.aXe.filemd5;
                                    obj2 = (this.aXe.cof != 0 || this.aXe.cob > 26214400) ? 1 : null;
                                } else {
                                    v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                    obj2 = null;
                                }
                                hVar.cFR = this.cNe;
                                hVar.field_mediaId = this.cMU;
                                hVar.field_fullpath = this.lAG.field_fileFullPath;
                                hVar.field_thumbpath = str;
                                hVar.field_fileType = obj2 != null ? b.cEC : b.MediaType_FILE;
                                hVar.field_svr_signature = obj2 != null ? be.ma(this.lAG.field_signature) : SQLiteDatabase.KeyEmpty;
                                hVar.field_onlycheckexist = obj2 != null ? be.kS(this.lAG.field_signature) : false;
                                hVar.field_fake_bigfile_signature_aeskey = this.lAG.field_fakeAeskey;
                                hVar.field_fake_bigfile_signature = this.lAG.field_fakeSignature;
                                hVar.field_talker = ek.field_talker;
                                hVar.field_priority = b.cEA;
                                hVar.field_totalLen = aQ2;
                                hVar.field_needStorage = false;
                                hVar.field_isStreamMedia = false;
                                hVar.field_enable_hitcheck = this.cNm;
                                hVar.field_chattype = m.dE(ek.field_talker) ? 1 : 0;
                                hVar.field_force_aeskeycdn = false;
                                hVar.field_trysafecdn = true;
                                v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", Long.valueOf(this.lAG.field_msgInfoId), hVar.field_fullpath, Integer.valueOf(aQ2), str, Integer.valueOf(aQ), this.cMU, Integer.valueOf(hVar.field_fileType), Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_onlycheckexist), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn), be.KW(hVar.field_aesKey), hVar.field_filemd5, be.KW(hVar.field_svr_signature), be.KW(hVar.field_fake_bigfile_signature_aeskey), be.KW(hVar.field_fake_bigfile_signature));
                                if (com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                                    if (this.lAG.field_isUseCdn != 1) {
                                        this.lAG.field_isUseCdn = 1;
                                        boolean a = am.Wf().a(this.lAG, new String[0]);
                                        if (!a) {
                                            v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:" + a);
                                            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                                            this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                                            obj = null;
                                        }
                                    }
                                    v.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", this.cMU);
                                    obj = 1;
                                } else {
                                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.cMU = SQLiteDatabase.KeyEmpty;
                                    obj = null;
                                }
                            }
                        }
                    }
                } else {
                    r2 = new Object[2];
                    com.tencent.mm.modelcdntran.g.DZ();
                    r2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(4));
                    r2[1] = Integer.valueOf(this.lAG.field_isUseCdn);
                    v.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", r2);
                    obj = null;
                }
            }
            if (obj != null) {
                v.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", Long.valueOf(this.iFb));
                return 0;
            } else if (this.lAG.field_netTimes > 3200) {
                l.dA(this.lAG.nmb);
                v.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sm() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.iFb);
                return -1;
            } else {
                b bVar = this.lAG;
                bVar.field_netTimes++;
                if (be.kS(this.lAG.field_appId)) {
                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                    if (this.lAG.field_type != 8) {
                        this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                        return -1;
                    }
                }
                if (be.kS(this.lAG.field_clientAppDataId)) {
                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                    return -1;
                } else if (this.lAG.field_totalLen <= 0 || this.lAG.field_totalLen > 26214400) {
                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.lAG.field_totalLen);
                    this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                    return -1;
                } else if (be.kS(this.lAG.field_fileFullPath)) {
                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                    return -1;
                } else if (com.tencent.mm.a.e.aQ(this.lAG.field_fileFullPath) > 26214400) {
                    v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    return -1;
                } else {
                    byte[] d;
                    if (be.kS(this.cod)) {
                        d = com.tencent.mm.a.e.d(this.lAG.field_fileFullPath, (int) this.lAG.field_offset, 8192);
                    } else {
                        d = com.tencent.mm.a.e.d(this.lAG.field_fileFullPath, (int) this.lAG.field_offset, WXMediaMessage.THUMB_LENGTH_LIMIT);
                    }
                    if (be.bl(d)) {
                        v.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                        return -1;
                    }
                    bbo com_tencent_mm_protocal_c_bbo = (bbo) this.cif.czk.czs;
                    com_tencent_mm_protocal_c_bbo.glj = this.lAG.field_appId;
                    com_tencent_mm_protocal_c_bbo.mcM = (int) this.lAG.field_sdkVer;
                    com_tencent_mm_protocal_c_bbo.mXu = this.lAG.field_clientAppDataId;
                    com_tencent_mm_protocal_c_bbo.efm = (int) this.lAG.field_type;
                    com_tencent_mm_protocal_c_bbo.gln = com.tencent.mm.model.k.xF();
                    com_tencent_mm_protocal_c_bbo.mdz = (int) this.lAG.field_totalLen;
                    com_tencent_mm_protocal_c_bbo.mdA = (int) this.lAG.field_offset;
                    if (this.cod == null || !this.lBc) {
                        com_tencent_mm_protocal_c_bbo.mdB = d.length;
                        com_tencent_mm_protocal_c_bbo.mfg = new are().ba(d);
                        if (this.cod != null) {
                            com_tencent_mm_protocal_c_bbo.mpI = this.cod;
                        }
                        return a(eVar, this.cif, this);
                    }
                    com_tencent_mm_protocal_c_bbo.mpI = this.cod;
                    com_tencent_mm_protocal_c_bbo.mdz = (int) this.lAG.field_totalLen;
                    com_tencent_mm_protocal_c_bbo.mdB = 0;
                    com_tencent_mm_protocal_c_bbo.mfg = new are().ba(new byte[0]);
                    this.lBc = false;
                    return a(eVar, this.cif, this);
                }
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !be.kS(this.cMU)) {
            v.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.cMU);
        } else if (i2 == 0 && i3 == 0) {
            bbp com_tencent_mm_protocal_c_bbp = (bbp) ((com.tencent.mm.v.b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_bbp.glj != null && this.cod == null && (!com_tencent_mm_protocal_c_bbp.glj.equals(this.lAG.field_appId) || !com_tencent_mm_protocal_c_bbp.mXu.equals(this.lAG.field_clientAppDataId))) {
                v.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else if (com_tencent_mm_protocal_c_bbp.mdz < 0 || ((long) com_tencent_mm_protocal_c_bbp.mdz) != this.lAG.field_totalLen || com_tencent_mm_protocal_c_bbp.mdA < 0 || ((long) com_tencent_mm_protocal_c_bbp.mdA) > this.lAG.field_totalLen) {
                v.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else {
                this.lAG.field_offset = (long) com_tencent_mm_protocal_c_bbp.mdA;
                this.lAG.field_mediaSvrId = l.GA(com_tencent_mm_protocal_c_bbp.mfo) ? com_tencent_mm_protocal_c_bbp.mfo : SQLiteDatabase.KeyEmpty;
                if (this.lAG.field_status == 105) {
                    v.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.lAG.field_mediaSvrId + "," + this.lAG.field_offset + "] ");
                    this.cii.a(i2, -1, SQLiteDatabase.KeyEmpty, this);
                    return;
                }
                if (this.lAG.field_offset == this.lAG.field_totalLen) {
                    if (be.kS(this.lAG.field_mediaSvrId)) {
                        v.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                        this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                        l.dA(this.lAG.nmb);
                        return;
                    }
                    this.lAG.field_status = 199;
                    g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Long.valueOf(this.lAG.field_totalLen - this.lBd));
                }
                boolean a = am.Wf().a(this.lAG, new String[0]);
                if (!a) {
                    v.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:" + a);
                    this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                    c(null);
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                } else if (this.lAG.field_status == 199) {
                    this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
                } else if (a(this.czE, this.cii) < 0) {
                    v.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                }
            }
        } else {
            v.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            if (i2 == 4) {
                g.iuh.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_FILE), Long.valueOf(this.lAG.field_totalLen - this.lBd));
            }
            this.cii.a(i2, i3, str, this);
        }
    }

    protected final int ul() {
        return 3200;
    }

    public final int getType() {
        return 220;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    final void c(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.lAG.field_type == 2) {
            com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100131");
            if (Ls.isValid()) {
                this.cNA = t.getInt((String) Ls.buX().get("needUploadData"), 1);
            }
            if (!this.cNy && this.cNA != 0) {
                this.cNB = com_tencent_mm_modelcdntran_keep_SceneResult;
                this.cNy = true;
                com.tencent.mm.sdk.c.b ktVar = new kt();
                com.tencent.mm.sdk.c.a.nhr.e(this.cND);
                ktVar.bmc.filePath = this.lAG.field_fileFullPath;
                com.tencent.mm.sdk.c.a.nhr.z(ktVar);
            }
        }
    }
}
