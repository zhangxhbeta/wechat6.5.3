package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class c implements b, b, e {
    m cEZ = new a(this) {
        final /* synthetic */ c cFh;

        {
            this.cFh = r1;
        }

        public final void cI(int i) {
            v.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", Integer.valueOf(i));
            if ((i == 4 || i == 6) && ak.uz()) {
                ak.vy().a(new e(), 0);
            }
        }
    };
    Queue<String> cFa = new LinkedList();
    Map<String, h> cFb = new HashMap();
    Map<String, h> cFc = new HashMap();
    Map<String, Integer> cFd = new HashMap();
    private String cFe = SQLiteDatabase.KeyEmpty;
    private long cFf = 0;
    public HashSet<String> cFg = new HashSet();

    public final void a(int i, j jVar, Object obj) {
        if (ak.uz()) {
            int n = be.n(obj, 0);
            v.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(n), jVar);
            ak.yW();
            if (jVar != com.tencent.mm.model.c.vf() || n <= 0) {
                v.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(n), jVar);
            } else if (n == 144385) {
                ak.vy().a(new e(), 0);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 379) {
            v.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            if (ak.uz()) {
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ c cFh;

                    {
                        this.cFh = r1;
                    }

                    public final void run() {
                        this.cFh.aY(true);
                    }

                    public final String toString() {
                        return super.toString() + "|onSceneEnd";
                    }
                });
            }
        }
    }

    public static boolean fk(int i) {
        ak.yW();
        v.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", Integer.valueOf(r0), Integer.valueOf(i), Integer.valueOf(be.a((Integer) com.tencent.mm.model.c.vf().get(144385, null), 0) & i), Boolean.valueOf(q.dqd));
        if (q.dqd) {
            return true;
        }
        return (r0 & i) > 0;
    }

    public c() {
        ak.a(this.cEZ);
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(this);
        }
        ak.vy().a(379, (e) this);
    }

    public final boolean a(final h hVar, final int i) {
        if (hVar == null) {
            v.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            return false;
        } else if (be.kS(hVar.field_mediaId)) {
            v.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            return false;
        } else {
            if (hVar.field_fileId == null) {
                hVar.field_fileId = SQLiteDatabase.KeyEmpty;
            }
            if (hVar.field_aesKey == null) {
                hVar.field_aesKey = SQLiteDatabase.KeyEmpty;
            }
            hVar.cFQ = false;
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ c cFh;

                public final void run() {
                    if (i != -1) {
                        this.cFh.cFd.put(hVar.field_mediaId, Integer.valueOf(i));
                    }
                    this.cFh.cFa.add(hVar.field_mediaId);
                    this.cFh.cFb.put(hVar.field_mediaId, hVar);
                    this.cFh.aY(false);
                }

                public final String toString() {
                    return super.toString() + "|addRecvTask";
                }
            });
            return true;
        }
    }

    public final boolean b(final h hVar) {
        if (be.kS(hVar.field_mediaId)) {
            v.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            return false;
        }
        if (hVar.field_fileId == null) {
            hVar.field_fileId = SQLiteDatabase.KeyEmpty;
        }
        if (hVar.field_aesKey == null) {
            hVar.field_aesKey = SQLiteDatabase.KeyEmpty;
        }
        hVar.cFQ = true;
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ c cFh;

            public final void run() {
                this.cFh.cFa.add(hVar.field_mediaId);
                this.cFh.cFb.put(hVar.field_mediaId, hVar);
                this.cFh.aY(false);
            }

            public final String toString() {
                return super.toString() + "|addSendTask";
            }
        });
        return true;
    }

    public final boolean ip(String str) {
        if (((h) this.cFc.remove(str)) != null) {
            g.Ea();
            b.ik(str);
            g.iuh.h(10769, Integer.valueOf(d.cFx), Integer.valueOf(r0.field_fileType), Long.valueOf(be.Ni() - r0.field_startTime));
        }
        this.cFb.remove(str);
        v.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(0));
        return true;
    }

    public final boolean iq(String str) {
        if (((h) this.cFc.remove(str)) != null) {
            g.Ea();
            b.il(str);
            g.iuh.h(10769, Integer.valueOf(d.cFw), Integer.valueOf(r0.field_fileType), Long.valueOf(be.Ni() - r0.field_startTime));
        }
        this.cFb.remove(str);
        this.cFd.remove(str);
        v.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(0));
        return true;
    }

    public final void aY(boolean z) {
        if (ak.uz()) {
            int i;
            if (!z) {
                if (g.Ea().cER == null) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    v.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                    ak.vy().a(new e(), 0);
                    return;
                }
            }
            c cVar = new c(g.Ea());
            String value = com.tencent.mm.h.j.sU().getValue("EnableCDNUploadImg");
            String value2 = com.tencent.mm.h.j.sU().getValue("EnableCDNVerifyConnect");
            String value3 = com.tencent.mm.h.j.sU().getValue("EnableCDNVideoRedirectOC");
            String value4 = com.tencent.mm.h.j.sU().getValue("EnableStreamUploadVideo");
            String value5 = com.tencent.mm.h.j.sU().getValue("C2COverloadDelaySeconds");
            String value6 = com.tencent.mm.h.j.sU().getValue("SNSOverloadDelaySeconds");
            try {
                if (!be.kS(value)) {
                    cVar.field_UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!be.kS(value2)) {
                    cVar.field_EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!be.kS(value3)) {
                    cVar.field_EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!be.kS(value4)) {
                    cVar.field_EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!be.kS(value5)) {
                    cVar.field_C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!be.kS(value6)) {
                    cVar.field_SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                g.DZ();
                cVar.field_EnableSafeCDN = fk(FileUtils.S_IRUSR) ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    value = com.tencent.mm.h.j.sU().getValue("ProgJPEGUploadSizeLimitWifi");
                    value2 = com.tencent.mm.h.j.sU().getValue("ProgJPEGUploadSizeLimit3G");
                    value3 = com.tencent.mm.h.j.sU().getValue("ProgJPEGDownloadSizeLimit");
                    value4 = com.tencent.mm.h.j.sU().getValue("ProgJPEGOnlyRecvPTL");
                    value5 = com.tencent.mm.h.j.sU().getValue("EnableJPEGDyncmicETL");
                    if (!be.kS(value)) {
                        cVar.field_WifiEtl = Integer.valueOf(value).intValue();
                    }
                    if (!be.kS(value2)) {
                        cVar.field_noWifiEtl = Integer.valueOf(value2).intValue();
                    }
                    if (!be.kS(value3)) {
                        cVar.field_Ptl = Integer.valueOf(value3).intValue();
                    }
                    if (!be.kS(value4)) {
                        cVar.field_onlyrecvPtl = Integer.valueOf(value4).intValue() != 0;
                    }
                    if (!be.kS(value5)) {
                        cVar.field_UseDynamicETL = Integer.valueOf(value5).intValue();
                    }
                }
                v.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", cVar);
                g.Ea();
                b.a(cVar);
            } catch (NumberFormatException e) {
                v.e("MicroMsg.CdnTransportService", e.toString());
            }
            if (q.dqC) {
                v.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                cVar.field_UseStreamCDN = q.dqy ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    cVar.field_onlysendETL = q.dqz;
                    cVar.field_onlyrecvPtl = q.dqA;
                    if (!be.kS(q.dqv)) {
                        cVar.field_WifiEtl = Integer.valueOf(q.dqv).intValue();
                    }
                    if (!be.kS(q.dqw)) {
                        cVar.field_noWifiEtl = Integer.valueOf(q.dqw).intValue();
                    }
                    if (!be.kS(q.dqx)) {
                        cVar.field_Ptl = Integer.valueOf(q.dqx).intValue();
                    }
                }
                cVar.field_EnableCDNVerifyConnect = q.dqD ? 1 : 0;
                cVar.field_EnableCDNVideoRedirectOC = q.dqE ? 1 : 0;
                v.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", cVar);
                g.Ea();
                b.a(cVar);
            }
            v.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", Integer.valueOf(this.cFa.size()));
            while (!this.cFa.isEmpty()) {
                h hVar = (h) this.cFb.remove((String) this.cFa.poll());
                if (hVar == null) {
                    v.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                    return;
                }
                v.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", hVar.field_mediaId, Boolean.valueOf(hVar.field_autostart), Integer.valueOf(hVar.field_chattype));
                hVar.field_startTime = be.Ni();
                String str;
                Object[] objArr;
                int startC2CUpload;
                if (hVar.cFQ) {
                    str = "MicroMsg.CdnTransportService";
                    value2 = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                    objArr = new Object[7];
                    if (hVar.field_fullpath == null) {
                        i = -1;
                    } else {
                        i = hVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i);
                    if (hVar.field_thumbpath == null) {
                        i = -1;
                    } else {
                        i = hVar.field_thumbpath.length();
                    }
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = be.KW(hVar.field_svr_signature);
                    objArr[3] = be.KW(hVar.field_aesKey);
                    objArr[4] = Integer.valueOf(hVar.field_fileType);
                    objArr[5] = hVar.field_mediaId;
                    objArr[6] = Boolean.valueOf(hVar.field_onlycheckexist);
                    v.i(str, value2, objArr);
                    if (hVar.field_fullpath == null) {
                        hVar.field_fullpath = SQLiteDatabase.KeyEmpty;
                    }
                    if (hVar.field_thumbpath == null) {
                        hVar.field_thumbpath = SQLiteDatabase.KeyEmpty;
                    }
                    g.Ea();
                    C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
                    c2CUploadRequest.fileKey = hVar.field_mediaId;
                    c2CUploadRequest.filePath = hVar.field_fullpath;
                    c2CUploadRequest.thumbfilePath = hVar.field_thumbpath;
                    c2CUploadRequest.fileSize = hVar.field_totalLen;
                    c2CUploadRequest.fileType = hVar.field_fileType;
                    c2CUploadRequest.forwardAeskey = hVar.field_aesKey;
                    c2CUploadRequest.forwardFileid = hVar.field_fileId;
                    c2CUploadRequest.midfileSize = hVar.field_midFileLength;
                    c2CUploadRequest.queueTimeoutSeconds = 0;
                    c2CUploadRequest.transforTimeoutSeconds = 0;
                    c2CUploadRequest.toUser = hVar.field_talker;
                    c2CUploadRequest.sendmsgFromCDN = hVar.field_sendmsg_viacdn;
                    c2CUploadRequest.chatType = hVar.field_chattype;
                    c2CUploadRequest.apptype = hVar.field_appType;
                    c2CUploadRequest.bizscene = hVar.field_bzScene;
                    c2CUploadRequest.checkExistOnly = hVar.field_onlycheckexist;
                    c2CUploadRequest.isSmallVideo = hVar.field_smallVideoFlag == 1;
                    c2CUploadRequest.isLargeSVideo = hVar.field_largesvideo;
                    c2CUploadRequest.isSnsAdVideo = hVar.field_advideoflag == 1;
                    c2CUploadRequest.isStorageMode = hVar.field_needStorage;
                    c2CUploadRequest.isStreamMedia = hVar.field_isStreamMedia;
                    c2CUploadRequest.enableHitCheck = hVar.field_enable_hitcheck;
                    c2CUploadRequest.forceNoSafeCdn = hVar.field_force_aeskeycdn;
                    c2CUploadRequest.trySafeCdn = hVar.field_trysafecdn;
                    c2CUploadRequest.midimgPath = hVar.field_midimgpath;
                    c2CUploadRequest.bigfileSignature = hVar.field_svr_signature;
                    if (be.kS(c2CUploadRequest.bigfileSignature)) {
                        c2CUploadRequest.bigfileSignature = SQLiteDatabase.KeyEmpty;
                    }
                    c2CUploadRequest.fakeBigfileSignature = hVar.field_fake_bigfile_signature;
                    if (be.kS(c2CUploadRequest.fakeBigfileSignature)) {
                        c2CUploadRequest.fakeBigfileSignature = SQLiteDatabase.KeyEmpty;
                    }
                    c2CUploadRequest.fakeBigfileSignatureAeskey = hVar.field_fake_bigfile_signature_aeskey;
                    if (be.kS(c2CUploadRequest.fakeBigfileSignatureAeskey)) {
                        c2CUploadRequest.fakeBigfileSignatureAeskey = SQLiteDatabase.KeyEmpty;
                    }
                    startC2CUpload = CdnLogic.startC2CUpload(c2CUploadRequest);
                    if (startC2CUpload != 0) {
                        v.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", Integer.valueOf(startC2CUpload), hVar.field_mediaId);
                        if (hVar.cFR != null) {
                            hVar.cFR.a(hVar.field_mediaId, startC2CUpload, null, null, hVar.field_onlycheckexist);
                        }
                    } else {
                        v.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", hVar.field_mediaId);
                        this.cFc.put(hVar.field_mediaId, hVar);
                    }
                } else {
                    str = "MicroMsg.CdnTransportService";
                    value2 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                    objArr = new Object[7];
                    if (hVar.field_fullpath == null) {
                        i = -1;
                    } else {
                        i = hVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i);
                    if (hVar.field_thumbpath == null) {
                        i = -1;
                    } else {
                        i = hVar.field_thumbpath.length();
                    }
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = hVar.field_svr_signature;
                    objArr[3] = hVar.field_aesKey;
                    objArr[4] = Integer.valueOf(hVar.field_fileType);
                    objArr[5] = hVar.field_mediaId;
                    objArr[6] = Boolean.valueOf(hVar.field_onlycheckexist);
                    v.i(str, value2, objArr);
                    g.Ea();
                    startC2CUpload = CdnLogic.startC2CDownload(b.a(hVar));
                    if (startC2CUpload != 0) {
                        v.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(startC2CUpload), hVar.field_mediaId);
                        if (hVar.cFR != null) {
                            hVar.cFR.a(hVar.field_mediaId, startC2CUpload, null, null, hVar.field_onlycheckexist);
                        }
                    } else {
                        v.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", hVar.field_mediaId);
                        this.cFc.put(hVar.field_mediaId, hVar);
                    }
                }
            }
        }
    }

    public final int a(final String str, final keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (be.kS(str)) {
            v.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
            return -1;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null && com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            v.e("MicroMsg.CdnTransportService", "cdn callback info all null");
            return -2;
        } else {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                v.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify));
            }
            this.cFf = be.Ni();
            this.cFe = str;
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ c cFh;

                public final void run() {
                    int i = 0;
                    h hVar = (h) this.cFh.cFc.get(str);
                    if (hVar == null) {
                        v.e("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", str);
                        return;
                    }
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                        com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId = str;
                        v.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify));
                    }
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        com_tencent_mm_modelcdntran_keep_SceneResult.mediaId = str;
                    }
                    if (hVar.cFR != null) {
                        long Ni = be.Ni();
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null || com_tencent_mm_modelcdntran_keep_ProgressInfo == null || com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify || com.tencent.mm.sdk.platformtools.ak.getNetWorkType(aa.getContext()) != -1) {
                            hVar.field_lastProgressCallbackTime = Ni;
                            hVar.cFR.a(str, 0, com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, hVar.field_onlycheckexist);
                        } else {
                            return;
                        }
                    }
                    keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo = com_tencent_mm_modelcdntran_keep_ProgressInfo;
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null || com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength) {
                        i = 1;
                    }
                    if (i != 0) {
                        this.cFh.cFd.remove(str);
                    }
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        this.cFh.cFc.remove(str);
                    }
                }

                public final String toString() {
                    return super.toString() + "|callback";
                }
            });
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (be.kS(str)) {
            v.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        h hVar = (h) this.cFc.get(str);
        if (hVar == null) {
            v.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", str);
        } else if (hVar.cFR != null) {
            hVar.cFR.a(str, byteArrayOutputStream);
        } else {
            v.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] i(String str, byte[] bArr) {
        if (be.kS(str)) {
            v.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        h hVar = (h) this.cFc.get(str);
        if (hVar == null) {
            v.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            return null;
        } else if (hVar.cFR != null) {
            return hVar.cFR.i(str, bArr);
        } else {
            v.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }
}
