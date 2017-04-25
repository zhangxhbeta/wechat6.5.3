package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.favorite.b.b;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class c {
    public ah aVA = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c fMt;

        {
            this.fMt = r1;
        }

        public final boolean oU() {
            try {
                this.fMt.Ge();
            } catch (Throwable e) {
                v.a("MicroMsg.FavCdnService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private Queue<com.tencent.mm.plugin.favorite.b.a> aVq = new LinkedList();
    private Map<String, com.tencent.mm.compatible.util.g.a> aVs = new HashMap();
    boolean aVu = false;
    boolean aVv = false;
    public int aVw = 0;
    long aVx = 0;
    public m cEZ = new com.tencent.mm.network.m.a(this) {
        final /* synthetic */ c fMt;

        {
            this.fMt = r1;
        }

        public final void cI(int i) {
            try {
                boolean isWifi = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());
                v.i("MicroMsg.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(this.fMt.fMm)});
                if (i == 4 || i == 6) {
                    c cVar;
                    if (this.fMt.fMm && !isWifi) {
                        com.tencent.mm.plugin.favorite.b.a aVar;
                        cVar = this.fMt;
                        v.v("MicroMsg.FavCdnService", "pauseAll");
                        Cursor rawQuery = h.alp().cie.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
                        if (rawQuery != null && rawQuery.moveToFirst()) {
                            while (rawQuery.moveToNext()) {
                                aVar = new com.tencent.mm.plugin.favorite.b.a();
                                aVar.b(rawQuery);
                                if (aVar.field_dataType != 2 && ((long) aVar.field_totalLen) > com.tencent.mm.plugin.favorite.b.v.amc()) {
                                    v.v("MicroMsg.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[]{aVar.field_dataId});
                                    aVar.field_status = 4;
                                    h.alp().a(aVar, "dataId");
                                    g.DZ().ip(aVar.field_dataId);
                                    c.d(h.alp().sL(aVar.field_dataId));
                                    cVar.tf(aVar.field_dataId);
                                }
                            }
                            rawQuery.close();
                        }
                        rawQuery = h.alp().cie.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
                        if (rawQuery != null && rawQuery.moveToFirst()) {
                            while (rawQuery.moveToNext()) {
                                aVar = new com.tencent.mm.plugin.favorite.b.a();
                                aVar.b(rawQuery);
                                if (aVar.field_dataType != 2 && ((long) aVar.field_totalLen) > com.tencent.mm.plugin.favorite.b.v.amb()) {
                                    v.v("MicroMsg.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[]{aVar.field_dataId});
                                    aVar.field_status = 4;
                                    h.alp().a(aVar, "dataId");
                                    g.DZ().iq(aVar.field_dataId);
                                    c.d(h.alp().sL(aVar.field_dataId));
                                    cVar.tf(aVar.field_dataId);
                                }
                            }
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    }
                    if (!this.fMt.fMm && isWifi) {
                        cVar = this.fMt;
                        v.i("MicroMsg.FavCdnService", "startAll");
                        h.alp().cie.dF("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
                        cVar.run();
                    }
                    this.fMt.fMm = isWifi;
                    return;
                }
                this.fMt.fMm = isWifi;
            } catch (Throwable e) {
                v.a("MicroMsg.FavCdnService", e, "", new Object[0]);
            }
        }
    };
    private com.tencent.mm.modelcdntran.h.a cNe = new com.tencent.mm.modelcdntran.h.a(this) {
        final /* synthetic */ c fMt;

        {
            this.fMt = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                v.d("MicroMsg.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
            }
            String str2 = "";
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                str2 = com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId;
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                str2 = com_tencent_mm_modelcdntran_keep_SceneResult.mediaId;
            }
            if (i == -21006 || i == -21005) {
                this.fMt.tf(str2);
                return 0;
            }
            com.tencent.mm.plugin.favorite.b.a sL = h.alp().sL(str2);
            if (sL == null) {
                v.e("MicroMsg.FavCdnService", "klem onCdnCallback info null");
                this.fMt.tf(str2);
                return 0;
            }
            if (i != 0) {
                v.w("MicroMsg.FavCdnService", "cdn transfer callback, startRet=%d", new Object[]{Integer.valueOf(i)});
                com.tencent.mm.plugin.report.service.g.iuh.h(10660, new Object[]{Integer.valueOf(sL.field_type), Integer.valueOf(i)});
                sL.field_status = 4;
                h.alp().a(sL, new String[0]);
                c.d(sL);
                this.fMt.tf(str2);
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                sL.field_offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                sL.field_totalLen = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                sL.field_status = 1;
                h.alp().a(sL, new String[0]);
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= 0) {
                    sL.field_status = 3;
                    if (1 == sL.field_type) {
                        String str3 = sL.field_path + ".temp";
                        String str4 = sL.field_path;
                        int i2 = sL.field_dataType;
                        if (!(str3 == null || str4 == null)) {
                            if (i2 == -2 && !c.te(str3) && c.bz(str3, str4)) {
                                v.v("MicroMsg.FavCdnService", "renameAndCopyFile write amr head ok!");
                            } else {
                                File file = new File(str3);
                                File file2 = new File(str4);
                                if (file.exists()) {
                                    boolean renameTo = file.renameTo(file2);
                                    v.v("MicroMsg.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[]{Boolean.valueOf(renameTo), str3, file2});
                                }
                            }
                        }
                    } else {
                        sL.field_cdnKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                        sL.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                    }
                    h.alp().a(sL, new String[0]);
                    c.a(this.fMt, sL, com_tencent_mm_modelcdntran_keep_SceneResult);
                    h.alp().b(sL, "dataId");
                    this.fMt.fMo.remove(sL.field_dataId);
                    v.i("MicroMsg.FavCdnService", "transfer done, mediaid=%s, md5=%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, str2});
                    v.d("MicroMsg.FavCdnService", "transfer done, completeInfo=%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
                } else {
                    v.e("MicroMsg.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                    if (-6101 != com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                        switch (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                            case -5103015:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 8, 1, true);
                                break;
                            case -21020:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 7, 1, true);
                                break;
                            case -21014:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 6, 1, true);
                                break;
                            case -21009:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 5, 1, true);
                                break;
                            case -21000:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 4, 1, true);
                                break;
                            case -10005:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 3, 1, true);
                                break;
                            case -10003:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 2, 1, true);
                                break;
                            default:
                                com.tencent.mm.plugin.report.service.g.iuh.a(141, 0, 1, true);
                                break;
                        }
                    }
                    sL.field_extFlag |= 1;
                    com.tencent.mm.plugin.report.service.g.iuh.a(141, 1, 1, true);
                    sL.field_status = 4;
                    com.tencent.mm.plugin.report.service.g.iuh.h(10660, new Object[]{Integer.valueOf(sL.field_type), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                    h.alp().a(sL, new String[0]);
                    c.d(sL);
                }
                this.fMt.tf(str2);
                com.tencent.mm.plugin.report.service.g.iuh.h(10625, new Object[]{Integer.valueOf(1), com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, "", com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo});
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    boolean fMm = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());
    Map<String, a> fMo = new HashMap();
    Set<String> fMp = new HashSet();
    int fMq = 0;
    boolean fMr = true;
    private Runnable fMs = new Runnable(this) {
        final /* synthetic */ c fMt;

        {
            this.fMt = r1;
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis() - this.fMt.aVx;
            if (this.fMt.aVv) {
                if (currentTimeMillis >= 300000) {
                    v.e("MicroMsg.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.fMt.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.fMt.aVv);
                } else {
                    return;
                }
            }
            v.i("MicroMsg.FavCdnService", "do run cdn job, wait time %d", new Object[]{Long.valueOf(currentTimeMillis)});
            this.fMt.aVu = false;
            this.fMt.aVv = true;
            this.fMt.fMq = 0;
            this.fMt.aVw = 3;
            this.fMt.aVA.ea(100);
        }

        public final String toString() {
            return super.toString() + "|run";
        }
    };

    private class a {
        int dph;
        final /* synthetic */ c fMt;
        long fMw;

        private a(c cVar) {
            this.fMt = cVar;
        }
    }

    static /* synthetic */ void a(c cVar, com.tencent.mm.plugin.favorite.b.a aVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        i bB = h.alu().bB(aVar.field_favLocalId);
        if (bB == null) {
            v.e("MicroMsg.FavCdnService", "klem onCdnTranFinish item info null!");
            return;
        }
        Iterator it = bB.field_favProto.mtR.iterator();
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (!aVar.field_dataId.equals(pwVar.luu)) {
                if (aVar.field_dataId.equals(com.tencent.mm.plugin.favorite.b.v.sX(pwVar.luu))) {
                    pwVar.Iz(aVar.field_cdnKey);
                    pwVar.Iy(aVar.field_cdnUrl);
                    bB.field_xml = i.b(bB);
                    h.alu().a(bB, "localId");
                    v.v("MicroMsg.FavCdnService", "klem onCdnTranFinish thumb key and url updated, md5:%s, cdnUrl:%s", new Object[]{aVar.field_dataId, aVar.field_cdnUrl});
                    break;
                }
            }
            pwVar.IB(aVar.field_cdnKey);
            pwVar.IA(aVar.field_cdnUrl);
            if (aVar.field_type == 0 && aVar.alv()) {
                v.v("MicroMsg.FavCdnService", "video stream, id:%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId});
                pwVar.IP(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId);
            }
            bB.field_xml = i.b(bB);
            h.alu().a(bB, "localId");
            v.v("MicroMsg.FavCdnService", "klem onCdnTranFinish data key and url updated, md5:%s, cdnUrl:%s", new Object[]{aVar.field_dataId, aVar.field_cdnUrl});
        }
        d(aVar);
    }

    public c() {
        ak.a(this.cEZ);
    }

    public final void cW(final boolean z) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ c fMt;

            public final void run() {
                this.fMt.fMr = z;
                this.fMt.fMq = 0;
            }
        });
    }

    public final void tc(final String str) {
        v.d("MicroMsg.FavCdnService", "add force job %s", new Object[]{str});
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ c fMt;

            public final void run() {
                this.fMt.fMp.add(str);
            }
        });
    }

    public final void run() {
        v.v("MicroMsg.FavCdnService", "run fav cdn server");
        ak.vA().btx().removeCallbacks(this.fMs);
        ak.vA().x(this.fMs);
    }

    final void Ge() {
        com.tencent.mm.plugin.favorite.b.a aVar;
        this.aVx = System.currentTimeMillis();
        if (!this.aVu && this.aVq.size() == 0) {
            if (f.sj()) {
                b alp = h.alp();
                Cursor rawQuery = alp.cie.rawQuery("select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1", null);
                List list;
                if (rawQuery == null) {
                    list = null;
                } else if (rawQuery.getCount() == 0) {
                    rawQuery.close();
                    list = null;
                } else {
                    list = new LinkedList();
                    while (rawQuery.moveToNext()) {
                        com.tencent.mm.plugin.favorite.b.a aVar2 = new com.tencent.mm.plugin.favorite.b.a();
                        aVar2.b(rawQuery);
                        list.add(aVar2);
                    }
                    rawQuery.close();
                }
                if (!(r0 == null || r0.size() == 0)) {
                    for (com.tencent.mm.plugin.favorite.b.a aVar3 : r0) {
                        if (this.aVs.containsKey(aVar3.field_dataId)) {
                            v.d("MicroMsg.FavCdnService", "File is Already running:" + aVar3.field_dataId);
                        } else {
                            this.aVq.add(aVar3);
                            this.aVs.put(aVar3.field_dataId, null);
                        }
                    }
                    v.d("MicroMsg.FavCdnService", "klem GetNeedRun procing:" + this.aVs.size() + ",send:" + this.aVq.size() + "]");
                    this.aVq.size();
                }
            } else {
                v.e("MicroMsg.FavCdnService", "klem getNeedRunInfo sdcard not available");
                pu();
            }
        }
        if (!this.aVu && this.aVq.size() <= 0) {
            pu();
            v.d("MicroMsg.FavCdnService", "klem No Data Any More , Stop Service");
        } else if (!this.aVu && this.aVq.size() > 0) {
            aVar3 = (com.tencent.mm.plugin.favorite.b.a) this.aVq.poll();
            if (aVar3 != null && !be.kS(aVar3.field_dataId)) {
                boolean z;
                com.tencent.mm.modelcdntran.h hVar;
                a aVar4 = (a) this.fMo.get(aVar3.field_dataId);
                if (aVar4 == null) {
                    aVar4 = new a();
                    aVar4.dph = 1;
                    aVar4.fMw = be.Ni();
                    this.fMo.put(aVar3.field_dataId, aVar4);
                } else if (be.Ni() - aVar4.fMw > 180000) {
                    aVar4.dph = 1;
                    aVar4.fMw = be.Ni();
                    this.fMo.put(aVar3.field_dataId, aVar4);
                } else if (aVar4.dph <= 3) {
                    aVar4.dph++;
                    this.fMo.put(aVar3.field_dataId, aVar4);
                } else {
                    v.w("MicroMsg.FavCdnService", "check favCDN:match transfer limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar3.field_favLocalId), aVar3.field_dataId, Integer.valueOf(aVar3.field_type), Integer.valueOf(aVar3.field_dataType)});
                    c(aVar3);
                    z = false;
                    if (!z) {
                        this.aVu = true;
                        if (aVar3 == null) {
                            v.d("MicroMsg.FavCdnService", "doTransfer, md5:%s", new Object[]{aVar3.field_dataId});
                            hVar = new com.tencent.mm.modelcdntran.h();
                            hVar.cFR = this.cNe;
                            hVar.field_mediaId = aVar3.field_dataId;
                            if (aVar3.field_type == 0) {
                                hVar.cFQ = true;
                                hVar.field_priority = com.tencent.mm.modelcdntran.b.cEz;
                                hVar.field_needStorage = true;
                                hVar.field_isStreamMedia = aVar3.alv();
                                hVar.field_fullpath = aVar3.field_path;
                                if (aVar3.alv()) {
                                    hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                                } else {
                                    hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                                }
                                hVar.field_force_aeskeycdn = true;
                                hVar.field_trysafecdn = false;
                                v.i("MicroMsg.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn)});
                                g.DZ().b(hVar);
                                return;
                            }
                            hVar.cFQ = false;
                            hVar.field_totalLen = aVar3.field_totalLen;
                            hVar.field_aesKey = aVar3.field_cdnKey;
                            hVar.field_fileId = aVar3.field_cdnUrl;
                            hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                            hVar.cFR = this.cNe;
                            hVar.field_fullpath = aVar3.field_path + ".temp";
                            hVar.field_needStorage = true;
                            hVar.field_isStreamMedia = aVar3.alv();
                            if (aVar3.alv()) {
                                hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            } else {
                                hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            }
                            g.DZ().a(hVar, -1);
                            d(aVar3);
                        }
                    } else if (this.fMq >= 10) {
                        pu();
                    } else {
                        this.aVA.ea(500);
                    }
                }
                if (aVar3.field_type == 0) {
                    v.i("MicroMsg.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar3.field_favLocalId), aVar3.field_dataId, Integer.valueOf(aVar3.field_type), Integer.valueOf(aVar3.field_dataType)});
                } else if (this.fMp.contains(aVar3.field_dataId) || com.tencent.mm.plugin.favorite.b.v.sY(aVar3.field_dataId)) {
                    v.i("MicroMsg.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar3.field_favLocalId), aVar3.field_dataId, Integer.valueOf(aVar3.field_type), Integer.valueOf(aVar3.field_dataType)});
                } else {
                    if (!com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                        v.i("MicroMsg.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar3.field_favLocalId), aVar3.field_dataId, Integer.valueOf(aVar3.field_type), Integer.valueOf(aVar3.field_dataType)});
                        c(aVar3);
                        z = false;
                    } else if (aVar3.field_type == 0) {
                        v.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar3.field_favLocalId), aVar3.field_dataId, Integer.valueOf(aVar3.field_type), Integer.valueOf(aVar3.field_dataType)});
                    } else if (!this.fMr) {
                        v.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar3.field_favLocalId), aVar3.field_dataId, Integer.valueOf(aVar3.field_type), Integer.valueOf(aVar3.field_dataType)});
                        this.fMq = 0;
                    } else if (this.fMq < 10) {
                        v.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[]{Integer.valueOf(10), Integer.valueOf(this.fMq), Integer.valueOf(aVar4.dph), Long.valueOf(aVar3.field_favLocalId), aVar3.field_dataId, Integer.valueOf(aVar3.field_type), Integer.valueOf(aVar3.field_dataType)});
                        if (aVar4.dph == 1) {
                            this.fMq++;
                        }
                    } else {
                        v.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[]{Integer.valueOf(10)});
                        z = false;
                    }
                    if (!z) {
                        this.aVu = true;
                        if (aVar3 == null) {
                            v.d("MicroMsg.FavCdnService", "doTransfer, md5:%s", new Object[]{aVar3.field_dataId});
                            hVar = new com.tencent.mm.modelcdntran.h();
                            hVar.cFR = this.cNe;
                            hVar.field_mediaId = aVar3.field_dataId;
                            if (aVar3.field_type == 0) {
                                hVar.cFQ = false;
                                hVar.field_totalLen = aVar3.field_totalLen;
                                hVar.field_aesKey = aVar3.field_cdnKey;
                                hVar.field_fileId = aVar3.field_cdnUrl;
                                hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                                hVar.cFR = this.cNe;
                                hVar.field_fullpath = aVar3.field_path + ".temp";
                                hVar.field_needStorage = true;
                                hVar.field_isStreamMedia = aVar3.alv();
                                if (aVar3.alv()) {
                                    hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                                } else {
                                    hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                                }
                                g.DZ().a(hVar, -1);
                                d(aVar3);
                            }
                            hVar.cFQ = true;
                            hVar.field_priority = com.tencent.mm.modelcdntran.b.cEz;
                            hVar.field_needStorage = true;
                            hVar.field_isStreamMedia = aVar3.alv();
                            hVar.field_fullpath = aVar3.field_path;
                            if (aVar3.alv()) {
                                hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            } else {
                                hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            }
                            hVar.field_force_aeskeycdn = true;
                            hVar.field_trysafecdn = false;
                            v.i("MicroMsg.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn)});
                            g.DZ().b(hVar);
                            return;
                        }
                    } else if (this.fMq >= 10) {
                        this.aVA.ea(500);
                    } else {
                        pu();
                    }
                }
                z = true;
                if (!z) {
                    this.aVu = true;
                    if (aVar3 == null) {
                        v.d("MicroMsg.FavCdnService", "doTransfer, md5:%s", new Object[]{aVar3.field_dataId});
                        hVar = new com.tencent.mm.modelcdntran.h();
                        hVar.cFR = this.cNe;
                        hVar.field_mediaId = aVar3.field_dataId;
                        if (aVar3.field_type == 0) {
                            hVar.cFQ = true;
                            hVar.field_priority = com.tencent.mm.modelcdntran.b.cEz;
                            hVar.field_needStorage = true;
                            hVar.field_isStreamMedia = aVar3.alv();
                            hVar.field_fullpath = aVar3.field_path;
                            if (aVar3.alv()) {
                                hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            } else {
                                hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            }
                            hVar.field_force_aeskeycdn = true;
                            hVar.field_trysafecdn = false;
                            v.i("MicroMsg.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn)});
                            g.DZ().b(hVar);
                            return;
                        }
                        hVar.cFQ = false;
                        hVar.field_totalLen = aVar3.field_totalLen;
                        hVar.field_aesKey = aVar3.field_cdnKey;
                        hVar.field_fileId = aVar3.field_cdnUrl;
                        hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                        hVar.cFR = this.cNe;
                        hVar.field_fullpath = aVar3.field_path + ".temp";
                        hVar.field_needStorage = true;
                        hVar.field_isStreamMedia = aVar3.alv();
                        if (aVar3.alv()) {
                            hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                        } else {
                            hVar.field_fileType = bE(aVar3.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                        }
                        g.DZ().a(hVar, -1);
                        d(aVar3);
                    }
                } else if (this.fMq >= 10) {
                    pu();
                } else {
                    this.aVA.ea(500);
                }
            }
        }
    }

    private static void c(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (1 == aVar.field_type) {
            aVar.field_status = 2;
        } else {
            aVar.field_status = 4;
        }
        h.alp().a(aVar, "dataId");
        d(aVar);
    }

    public final void pauseDownload(String str) {
        if (!be.kS(str) && this.aVs.containsKey(str)) {
            g.DZ().iq(str);
            v.v("MicroMsg.FavCdnService", "pause download md5%s", new Object[]{str});
            d(h.alp().sL(str));
            tf(str);
        }
    }

    public final void td(String str) {
        if (!be.kS(str)) {
            g.DZ().ip(str);
            v.v("MicroMsg.FavCdnService", "pause upload md5%s", new Object[]{str});
            d(h.alp().sL(str));
            tf(str);
        }
    }

    public final void pu() {
        this.aVq.clear();
        this.aVs.clear();
        this.aVv = false;
        this.aVu = false;
    }

    private static int bE(int i, int i2) {
        if ((i & 1) == 0) {
            return i2;
        }
        v.w("MicroMsg.FavCdnService", "NEED To Exchange Type, defType %d", new Object[]{Integer.valueOf(i2)});
        if (com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO == i2) {
            return com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE;
        }
        return com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO;
    }

    static boolean bz(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable e;
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[16384];
                    fileOutputStream.write("#!AMR\n".getBytes());
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    boolean z = true;
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.FavCdnService", e2, "", new Object[0]);
                        z = false;
                    }
                    try {
                        fileOutputStream.close();
                        return z;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.FavCdnService", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    fileInputStream2 = fileInputStream;
                    try {
                        v.a("MicroMsg.FavCdnService", e22, "", new Object[0]);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable e222) {
                                v.a("MicroMsg.FavCdnService", e222, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            v.a("MicroMsg.FavCdnService", e2222, "", new Object[0]);
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                v.a("MicroMsg.FavCdnService", e4, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                v.a("MicroMsg.FavCdnService", e5, "", new Object[0]);
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                v.a("MicroMsg.FavCdnService", e2222, "", new Object[0]);
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (Exception e7) {
            e2222 = e7;
            fileOutputStream = null;
            v.a("MicroMsg.FavCdnService", e2222, "", new Object[0]);
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            e2222 = th4;
            fileOutputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }

    static boolean te(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Throwable e2) {
                        v.a("MicroMsg.FavCdnService", e2, "", new Object[0]);
                        return false;
                    }
                }
                String str2 = new String(bArr);
                v.d("MicroMsg.FavCdnService", "head " + str2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
                boolean endsWith = str2.endsWith("#!AMR\n");
                try {
                    randomAccessFile.close();
                } catch (Throwable e3) {
                    v.a("MicroMsg.FavCdnService", e3, "", new Object[0]);
                }
                return endsWith;
            } catch (Exception e4) {
                e2 = e4;
                try {
                    v.a("MicroMsg.FavCdnService", e2, "", new Object[0]);
                    if (randomAccessFile != null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.FavCdnService", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e32) {
                            v.a("MicroMsg.FavCdnService", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            randomAccessFile = null;
            v.a("MicroMsg.FavCdnService", e22, "", new Object[0]);
            if (randomAccessFile != null) {
                return false;
            }
            randomAccessFile.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e22;
        }
    }

    final void tf(String str) {
        this.aVu = false;
        this.aVs.remove(str);
        if (this.aVw > 0) {
            Ge();
            return;
        }
        v.d("MicroMsg.FavCdnService", "klem stopFlag <= 0 , Stop Service");
        pu();
    }

    static void d(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar.field_type == 0) {
            e(aVar);
        } else if (aVar.field_type == 1) {
            f(aVar);
        }
    }

    public static void e(com.tencent.mm.plugin.favorite.b.a aVar) {
        int j = h.alp().j(aVar.field_favLocalId, 0);
        v.v("MicroMsg.FavCdnService", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(j), Long.valueOf(aVar.field_favLocalId)});
        i bB = h.alu().bB(aVar.field_favLocalId);
        if (bB == null) {
            v.e("MicroMsg.FavCdnService", "klem updateDownloadStatus iteminfo null");
        } else if (bB.alF()) {
            v.i("MicroMsg.FavCdnService", "klem updateUploadStatus waiting server upload skip.");
        } else if (aVar.field_status == 3 && j != aVar.field_status && bB.field_type == 18 && h.alp().sL(aVar.field_dataId).field_status == 3) {
            a(aVar, bB);
        } else {
            switch (j) {
                case 0:
                    return;
                case 1:
                    if (bB.alE()) {
                        h.alu().r(15, aVar.field_favLocalId);
                    } else {
                        h.alu().r(4, aVar.field_favLocalId);
                    }
                    v.i("MicroMsg.FavCdnService", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id), Integer.valueOf(bB.field_itemStatus)});
                    return;
                case 2:
                    h.alu().r(6, aVar.field_favLocalId);
                    v.i("MicroMsg.FavCdnService", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id), Integer.valueOf(bB.field_itemStatus)});
                    return;
                case 3:
                    if (bB.field_type == 18) {
                        a(aVar, bB);
                        return;
                    } else if (bB.alE()) {
                        h.alu().r(17, aVar.field_favLocalId);
                        v.i("MicroMsg.FavCdnService", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id), Integer.valueOf(bB.field_itemStatus)});
                        h.alm().run();
                        return;
                    } else {
                        h.alu().r(9, aVar.field_favLocalId);
                        v.i("MicroMsg.FavCdnService", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id), Integer.valueOf(bB.field_itemStatus)});
                        h.alk().run();
                        return;
                    }
                case 4:
                    if (bB.alE()) {
                        h.alu().r(16, aVar.field_favLocalId);
                    } else {
                        h.alu().r(6, aVar.field_favLocalId);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(bB.field_type), Integer.valueOf(-5), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.k(bB)), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.bG(bB.field_localId))});
                    v.i("MicroMsg.FavCdnService", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id), Integer.valueOf(bB.field_itemStatus)});
                    return;
                default:
                    return;
            }
        }
    }

    public static void f(com.tencent.mm.plugin.favorite.b.a aVar) {
        v.v("MicroMsg.FavCdnService", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(h.alp().j(aVar.field_favLocalId, 1)), Long.valueOf(aVar.field_favLocalId)});
        i bB = h.alu().bB(aVar.field_favLocalId);
        if (bB == null) {
            v.e("MicroMsg.FavCdnService", "klem updateDownloadStatus iteminfo null");
        } else if (bB.alF() || bB.alA() || bB.alB()) {
            v.i("MicroMsg.FavCdnService", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[]{Boolean.valueOf(bB.alF()), Boolean.valueOf(bB.alA()), Boolean.valueOf(bB.alB())});
        } else {
            switch (r0) {
                case 0:
                    v.i("MicroMsg.FavCdnService", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id)});
                    h.alu().r(10, aVar.field_favLocalId);
                    return;
                case 1:
                    com.tencent.mm.plugin.favorite.b.v.bH(bB.field_localId);
                    h.alu().r(7, aVar.field_favLocalId);
                    return;
                case 2:
                    v.i("MicroMsg.FavCdnService", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id)});
                    h.alu().r(8, aVar.field_favLocalId);
                    return;
                case 3:
                    v.i("MicroMsg.FavCdnService", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id)});
                    com.tencent.mm.plugin.report.service.g.iuh.h(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(bB.field_type), Integer.valueOf(0), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.k(bB)), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.bG(bB.field_localId))});
                    h.alu().r(10, aVar.field_favLocalId);
                    return;
                case 4:
                    v.i("MicroMsg.FavCdnService", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bB.field_id), Integer.valueOf(bB.field_itemStatus)});
                    com.tencent.mm.plugin.report.service.g.iuh.h(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(bB.field_type), Integer.valueOf(-5), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.k(bB)), Long.valueOf(com.tencent.mm.plugin.favorite.b.v.bG(bB.field_localId))});
                    h.alu().r(8, aVar.field_favLocalId);
                    return;
                default:
                    return;
            }
        }
    }

    private static void a(com.tencent.mm.plugin.favorite.b.a aVar, i iVar) {
        Iterator it = iVar.field_favProto.mtR.iterator();
        int i = 0;
        while (it.hasNext()) {
            pw pwVar = (pw) it.next();
            if (!(pwVar.aKG == 1 || pwVar.aKG == 6)) {
                int i2;
                if (be.kS(pwVar.mrS)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (i != 0) {
            return;
        }
        if (iVar.field_id > 0) {
            h.alu().r(17, aVar.field_favLocalId);
            h.alm().run();
            return;
        }
        h.alu().r(9, aVar.field_favLocalId);
        h.alk().run();
    }
}
