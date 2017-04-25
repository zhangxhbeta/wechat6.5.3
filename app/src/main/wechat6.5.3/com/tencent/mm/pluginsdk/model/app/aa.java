package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.nl;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class aa extends k implements j {
    int aYJ;
    long bao;
    at bmk;
    f cMP;
    public String cMU;
    private com.tencent.mm.modelcdntran.h.a cNe;
    private b cif;
    e cii;
    long iFb;
    public b lAG;
    private int lAJ;
    String lAK;
    public boolean lAL;
    private boolean lAM;
    public String mediaId;
    long startTime;
    private int type;

    public interface a {
        void bnw();
    }

    public aa(String str) {
        this(str, null, 0);
    }

    public aa(long j, String str, f fVar) {
        this(str, fVar, 0);
        this.bao = j;
    }

    public aa(b bVar) {
        this.lAG = null;
        this.iFb = -1;
        this.mediaId = SQLiteDatabase.KeyEmpty;
        this.bao = 0;
        this.bmk = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startTime = 0;
        this.lAJ = -1;
        this.lAK = SQLiteDatabase.KeyEmpty;
        this.type = 0;
        this.aYJ = 0;
        this.lAL = false;
        this.lAM = false;
        this.cNe = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ aa lAN;

            {
                this.lAN = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                String str2 = "MicroMsg.NetSceneDownloadAppAttach";
                String str3 = "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
                objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
                objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo == null);
                v.d(str2, str3, objArr);
                if (i == -21006) {
                    v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", this.lAN.cMU);
                    return 0;
                } else if (i != 0) {
                    l.dA(this.lAN.lAG.nmb);
                    g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.lAN.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), SQLiteDatabase.KeyEmpty);
                    this.lAN.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lAN);
                    return 0;
                } else {
                    this.lAN.lAG = am.Wf().dy(this.lAN.bao);
                    if (this.lAN.lAG == null) {
                        v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                        this.lAN.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lAN);
                        return 0;
                    }
                    v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy file status: %s, file rowId:%s", Long.valueOf(this.lAN.lAG.field_status), Long.valueOf(this.lAN.lAG.nmb));
                    if (this.lAN.lAG.field_status == 102) {
                        v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(this.lAN.lAG.field_status));
                        com.tencent.mm.modelcdntran.g.DZ().ip(this.lAN.cMU);
                        this.lAN.cii.a(3, i, "attach  has paused, status=" + this.lAN.lAG.field_status, this.lAN);
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                l.dA(this.lAN.lAG.nmb);
                                v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode));
                                this.lAN.cii.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, SQLiteDatabase.KeyEmpty, this.lAN);
                            } else {
                                new File(this.lAN.lAK).renameTo(new File(this.lAN.lAG.field_fileFullPath));
                                this.lAN.lAG.field_status = 199;
                                this.lAN.lAG.field_offset = this.lAN.lAG.field_totalLen;
                                am.Wf().a(this.lAN.lAG, new String[0]);
                                g.iuh.a(198, 45, this.lAN.lAG.field_totalLen, false);
                                g.iuh.a(198, 46, 1, false);
                                g.iuh.a(198, m.dE(this.lAN.bmk == null ? SQLiteDatabase.KeyEmpty : this.lAN.bmk.field_talker) ? 48 : 47, 1, false);
                                ak.yW();
                                at ek = c.wJ().ek(this.lAN.lAG.field_msgInfoId);
                                if (ek.field_status == 5) {
                                    ek.dh(3);
                                    ak.yW();
                                    c.wJ().a(ek.field_msgId, ek);
                                }
                                this.lAN.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this.lAN);
                            }
                            g.iuh.h(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.lAN.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.lAN.lAG.field_totalLen), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            if (this.lAN.cMP != null) {
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 lAO;

                                    {
                                        this.lAO = r1;
                                    }

                                    public final void run() {
                                        this.lAO.lAN.cMP.a((int) this.lAO.lAN.lAG.field_offset, (int) this.lAO.lAN.lAG.field_totalLen, this.lAO.lAN);
                                    }
                                });
                            }
                        }
                        return 0;
                    } else if (((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) == this.lAN.lAG.field_totalLen) {
                        v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                        return 0;
                    } else if (this.lAN.lAG.field_offset > ((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)) {
                        v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(this.lAN.lAG.field_offset), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                        l.dA(this.lAN.lAG.nmb);
                        this.lAN.cii.a(3, i, SQLiteDatabase.KeyEmpty, this.lAN);
                        return 0;
                    } else {
                        this.lAN.lAG.field_offset = (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                        am.Wf().a(this.lAN.lAG, new String[0]);
                        if (this.lAN.cMP != null) {
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 lAO;

                                {
                                    this.lAO = r1;
                                }

                                public final void run() {
                                    this.lAO.lAN.cMP.a((int) this.lAO.lAN.lAG.field_offset, (int) this.lAO.lAN.lAG.field_totalLen, this.lAO.lAN);
                                }
                            });
                        }
                        v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", this.lAN.cMU, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength));
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
        this.lAG = bVar;
        this.lAL = true;
        this.mediaId = this.lAG.field_mediaId;
        this.cMP = null;
        this.type = 0;
        if (bVar == null) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
            return;
        }
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new nl();
        aVar.czo = new nm();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.czm = 221;
        aVar.czp = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        aVar.czq = 1000000106;
        this.cif = aVar.Bv();
        v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", bVar.field_fileFullPath, Boolean.valueOf(true), be.bur());
    }

    public aa(String str, f fVar, int i) {
        this.lAG = null;
        this.iFb = -1;
        this.mediaId = SQLiteDatabase.KeyEmpty;
        this.bao = 0;
        this.bmk = null;
        this.cMU = SQLiteDatabase.KeyEmpty;
        this.startTime = 0;
        this.lAJ = -1;
        this.lAK = SQLiteDatabase.KeyEmpty;
        this.type = 0;
        this.aYJ = 0;
        this.lAL = false;
        this.lAM = false;
        this.cNe = /* anonymous class already generated */;
        this.mediaId = str;
        this.cMP = fVar;
        this.type = i;
        this.lAG = am.Wf().Gu(str);
        if (this.lAG == null) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + str);
            return;
        }
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new nl();
        aVar.czo = new nm();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.czm = 221;
        aVar.czp = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        aVar.czq = 1000000106;
        this.cif = aVar.Bv();
        v.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", Integer.valueOf(i), this.lAG.field_fileFullPath, Long.valueOf(this.lAG.field_type), this.lAG.field_signature, be.bur());
    }

    public final void bnv() {
        this.lAM = true;
        if (this.lAM) {
            com.tencent.mm.a.e.e(this.lAG.field_fileFullPath, "#!AMR\n".getBytes());
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (this.lAG == null) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.sm() + " get info failed mediaId:" + this.mediaId);
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            return -1;
        }
        ak.yW();
        this.bmk = c.wJ().ek(this.bao);
        if (this.bmk == null || this.bmk.field_msgId != this.bao) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.sm() + " get msginfo failed mediaId:%s  msgId:%d", this.mediaId, Long.valueOf(this.bao));
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            return -1;
        }
        Object obj;
        if (this.startTime == 0) {
            this.startTime = be.Ni();
            this.lAJ = (int) this.lAG.field_offset;
        }
        String str = this.bmk.field_content;
        if (m.dE(this.bmk.field_talker)) {
            int fK = aw.fK(this.bmk.field_content);
            if (fK != -1) {
                str = (this.bmk.field_content + " ").substring(fK + 2).trim();
            }
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(str));
        if (dV == null) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", this.mediaId);
            obj = null;
        } else {
            v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", Long.valueOf(this.bao), Long.valueOf(this.lAG.field_totalLen), this.lAG.field_fileFullPath, dV.coi, be.KW(dV.cop));
            if (be.kS(dV.coi) || be.kS(dV.cop)) {
                v.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", Long.valueOf(this.bao), dV.coi, be.KW(dV.cop));
                obj = null;
            } else {
                this.cMU = d.a("downattach", this.lAG.field_createTime, this.bmk.field_talker, this.iFb);
                if (be.kS(this.cMU)) {
                    v.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.iFb));
                    obj = null;
                } else {
                    this.lAK = this.lAG.field_fileFullPath + "_tmp";
                    h hVar = new h();
                    hVar.field_mediaId = this.cMU;
                    hVar.field_fullpath = this.lAK;
                    int i = (dV.cof != 0 || dV.cob > 26214400) ? com.tencent.mm.modelcdntran.b.cEC : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                    hVar.field_fileType = i;
                    hVar.field_totalLen = (int) this.lAG.field_totalLen;
                    hVar.field_aesKey = dV.cop;
                    hVar.field_fileId = dV.coi;
                    hVar.field_svr_signature = this.lAG.field_signature;
                    hVar.field_fake_bigfile_signature_aeskey = this.lAG.field_fakeAeskey;
                    hVar.field_fake_bigfile_signature = this.lAG.field_fakeSignature;
                    hVar.field_onlycheckexist = false;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                    hVar.cFR = this.cNe;
                    hVar.field_chattype = m.dE(this.bmk.field_talker) ? 1 : 0;
                    v.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", Integer.valueOf(hVar.field_fileType), hVar.field_fullpath, be.KW(hVar.field_aesKey), be.KW(hVar.field_svr_signature), be.KW(hVar.field_fake_bigfile_signature_aeskey), be.KW(hVar.field_fake_bigfile_signature), Boolean.valueOf(hVar.field_onlycheckexist));
                    if (com.tencent.mm.modelcdntran.g.DZ().a(hVar, -1)) {
                        if (this.lAG.field_isUseCdn != 1) {
                            this.lAG.field_isUseCdn = 1;
                            boolean a = am.Wf().a(this.lAG, new String[0]);
                            if (!a) {
                                v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:" + a);
                                this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        v.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.cMU = SQLiteDatabase.KeyEmpty;
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            v.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", this.mediaId);
            return 0;
        }
        if (this.lAG.field_status == 102) {
            this.lAG.field_status = 101;
            if (!this.lAL) {
                am.Wf().a(this.lAG, new String[0]);
            }
        }
        this.iFb = this.lAG.nmb;
        if (be.kS(this.lAG.field_mediaSvrId)) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            return -1;
        } else if (this.lAG.field_totalLen <= 0 || this.lAG.field_totalLen > 26214400) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.lAG.field_totalLen);
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            return -1;
        } else if (be.kS(this.lAG.field_fileFullPath)) {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            return -1;
        } else {
            i = com.tencent.mm.a.e.aQ(this.lAG.field_fileFullPath);
            if (this.lAM) {
                i -= 6;
                if (i <= 0) {
                    i = 0;
                }
            }
            if (((long) i) != this.lAG.field_offset) {
                v.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.lAG.field_offset);
                this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                return -1;
            }
            v.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", this.lAG.field_appId, this.lAG.field_mediaSvrId, Long.valueOf(this.lAG.field_sdkVer));
            nl nlVar = (nl) this.cif.czk.czs;
            nlVar.glj = this.lAG.field_appId;
            nlVar.mfo = this.lAG.field_mediaSvrId;
            nlVar.mcM = (int) this.lAG.field_sdkVer;
            nlVar.gln = com.tencent.mm.model.k.xF();
            nlVar.mdz = (int) this.lAG.field_totalLen;
            nlVar.mdA = (int) this.lAG.field_offset;
            nlVar.mdB = 0;
            if (this.type != 0) {
                nlVar.efm = this.type;
            } else {
                nlVar.efm = (int) this.lAG.field_type;
            }
            return a(eVar, this.cif, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !be.kS(this.cMU)) {
            v.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.cMU);
        } else if (i2 == 0 && i3 == 0) {
            nm nmVar = (nm) ((b) pVar).czl.czs;
            this.lAG.field_totalLen = (long) nmVar.mdz;
            if (!nmVar.mfo.equals(this.lAG.field_mediaSvrId)) {
                v.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else if (((long) nmVar.mdA) != this.lAG.field_offset) {
                v.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + nmVar.mdA);
                this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else if (((long) nmVar.mdB) + this.lAG.field_offset > this.lAG.field_totalLen) {
                v.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + nmVar.mdB + " off:" + this.lAG.field_offset + " total?:" + this.lAG.field_totalLen);
                this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else {
                byte[] a = com.tencent.mm.platformtools.m.a(nmVar.mfg);
                if (a == null || a.length == 0 || a.length != nmVar.mdB) {
                    v.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                    return;
                }
                int e = com.tencent.mm.a.e.e(this.lAG.field_fileFullPath, a);
                if (e != 0) {
                    v.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:" + e);
                    this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                    return;
                }
                b bVar = this.lAG;
                bVar.field_offset += (long) a.length;
                if (this.lAG.field_offset == this.lAG.field_totalLen) {
                    this.lAG.field_status = 199;
                }
                if (this.cMP != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ aa lAN;

                        {
                            this.lAN = r1;
                        }

                        public final void run() {
                            this.lAN.cMP.a((int) this.lAN.lAG.field_offset, (int) this.lAN.lAG.field_totalLen, this.lAN);
                        }
                    });
                }
                if (!(this.lAL ? true : am.Wf().a(this.lAG, new String[0]))) {
                    v.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:" + e);
                    this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                } else if (this.lAG.field_status == 199) {
                    g.iuh.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.lAG.field_totalLen - ((long) this.lAJ)));
                    this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
                } else if (this.lAG.field_status == 102) {
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                    this.aYJ = -20102;
                } else if (a(this.czE, this.cii) < 0) {
                    v.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                }
            }
        } else {
            v.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.aYJ = -10000 - com.tencent.mm.compatible.util.g.sk();
            if (i2 == 4) {
                g.iuh.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(com.tencent.mm.sdk.platformtools.aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0));
            }
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 221;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 400;
    }

    public final String getMediaId() {
        if (this.lAG == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return this.lAG.field_mediaSvrId;
    }
}
