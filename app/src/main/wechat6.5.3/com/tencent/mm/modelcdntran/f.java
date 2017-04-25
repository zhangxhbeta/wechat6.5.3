package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.e;
import com.tencent.mm.as.k;
import com.tencent.mm.as.m;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.hy;
import com.tencent.mm.e.a.jj;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements a {
    Map<String, i> cFD = new HashMap();
    Map<String, keep_SceneResult> cFE = new HashMap();
    Queue<String> cFa = new LinkedList();
    Map<String, i> cFb = new HashMap();
    Map<String, i> cFc = new HashMap();

    static /* synthetic */ void a(f fVar) {
        if (ak.uz()) {
            while (!fVar.cFa.isEmpty()) {
                String str = (String) fVar.cFa.poll();
                h hVar = (i) fVar.cFb.remove(str);
                if (hVar != null) {
                    hVar.field_startTime = be.Ni();
                    if (!hVar.cFQ) {
                        Object obj;
                        b jjVar;
                        int a;
                        boolean Eb;
                        boolean z;
                        n lp;
                        int i;
                        ak.yW();
                        if (((Integer) c.vf().get(a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                            v.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
                        } else {
                            String str2 = hVar.cFT;
                            int i2 = hVar.cFU;
                            String bL = ak.yW().wM().bL(str2, i2);
                            int aQ = i2 - e.aQ(bL);
                            if (!be.kS(bL) && aQ >= 0 && aQ <= 16) {
                                v.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", Integer.valueOf(i2), str2, bL);
                                j.dz(bL, hVar.field_fullpath);
                                a(p.lp(hVar.filename), i2, str2);
                                obj = 1;
                                if (obj == null) {
                                    jjVar = new jj();
                                    jjVar.bjO.bdn = 6;
                                    jjVar.bjO.mediaId = str;
                                    com.tencent.mm.sdk.c.a.nhr.z(jjVar);
                                } else {
                                    if (hVar.Eb()) {
                                        g.Ea();
                                        a = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.cFV, hVar.iplist);
                                    } else {
                                        g.Ea();
                                        a = CdnLogic.startVideoStreamingDownload(b.a(hVar), hVar.cFV);
                                    }
                                    v.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", hVar, Integer.valueOf(a));
                                    if (a == 0) {
                                        v.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + hVar.field_mediaId);
                                        Eb = hVar.Eb();
                                        z = hVar.cFV;
                                        if (Eb) {
                                            g.iuh.a(354, 210, 1, false);
                                            if (z) {
                                                g.iuh.a(354, 212, 1, false);
                                            } else {
                                                g.iuh.a(354, 211, 1, false);
                                            }
                                            g.iuh.h(13836, Integer.valueOf(200), Long.valueOf(be.Nh()), SQLiteDatabase.KeyEmpty);
                                        } else {
                                            g.iuh.a(354, 3, 1, false);
                                            if (z) {
                                                if (a == -21006) {
                                                    g.iuh.a(354, 106, 1, false);
                                                } else if (a != -20003) {
                                                    g.iuh.a(354, 107, 1, false);
                                                } else {
                                                    g.iuh.a(354, 108, 1, false);
                                                }
                                            } else if (a == -21006) {
                                                g.iuh.a(354, 100, 1, false);
                                            } else if (a != -20003) {
                                                g.iuh.a(354, 101, 1, false);
                                            } else {
                                                g.iuh.a(354, 102, 1, false);
                                            }
                                            g.iuh.h(13836, Integer.valueOf(100), Long.valueOf(be.Nh()), SQLiteDatabase.KeyEmpty);
                                        }
                                    } else {
                                        if (hVar.Eb()) {
                                            lp = p.lp(hVar.filename);
                                            if (lp != null) {
                                                i = lp.status;
                                                if (!(i == 120 || i == 122 || i == 121)) {
                                                    lp.status = 120;
                                                    lp.bkU = FileUtils.S_IRUSR;
                                                    k.KV().b(lp);
                                                }
                                            }
                                        }
                                        fVar.cFc.put(hVar.field_mediaId, hVar);
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            if (hVar.Eb()) {
                                g.Ea();
                                a = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.cFV, hVar.iplist);
                            } else {
                                g.Ea();
                                a = CdnLogic.startVideoStreamingDownload(b.a(hVar), hVar.cFV);
                            }
                            v.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", hVar, Integer.valueOf(a));
                            if (a == 0) {
                                if (hVar.Eb()) {
                                    lp = p.lp(hVar.filename);
                                    if (lp != null) {
                                        i = lp.status;
                                        lp.status = 120;
                                        lp.bkU = FileUtils.S_IRUSR;
                                        k.KV().b(lp);
                                    }
                                }
                                fVar.cFc.put(hVar.field_mediaId, hVar);
                            } else {
                                v.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + hVar.field_mediaId);
                                Eb = hVar.Eb();
                                z = hVar.cFV;
                                if (Eb) {
                                    g.iuh.a(354, 210, 1, false);
                                    if (z) {
                                        g.iuh.a(354, 212, 1, false);
                                    } else {
                                        g.iuh.a(354, 211, 1, false);
                                    }
                                    g.iuh.h(13836, Integer.valueOf(200), Long.valueOf(be.Nh()), SQLiteDatabase.KeyEmpty);
                                } else {
                                    g.iuh.a(354, 3, 1, false);
                                    if (z) {
                                        if (a == -21006) {
                                            g.iuh.a(354, 106, 1, false);
                                        } else if (a != -20003) {
                                            g.iuh.a(354, 108, 1, false);
                                        } else {
                                            g.iuh.a(354, 107, 1, false);
                                        }
                                    } else if (a == -21006) {
                                        g.iuh.a(354, 100, 1, false);
                                    } else if (a != -20003) {
                                        g.iuh.a(354, 102, 1, false);
                                    } else {
                                        g.iuh.a(354, 101, 1, false);
                                    }
                                    g.iuh.h(13836, Integer.valueOf(100), Long.valueOf(be.Nh()), SQLiteDatabase.KeyEmpty);
                                }
                            }
                        } else {
                            jjVar = new jj();
                            jjVar.bjO.bdn = 6;
                            jjVar.bjO.mediaId = str;
                            com.tencent.mm.sdk.c.a.nhr.z(jjVar);
                        }
                    }
                }
            }
        }
    }

    public final boolean a(final i iVar, boolean z) {
        if (iVar == null) {
            v.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            return false;
        } else if (be.kS(iVar.field_mediaId)) {
            v.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            return false;
        } else {
            v.i("MicroMsg.OnlineVideoService", "add download task : " + iVar.field_mediaId + "delay : " + z);
            if (iVar.field_fileId == null) {
                iVar.field_fileId = SQLiteDatabase.KeyEmpty;
            }
            if (iVar.field_aesKey == null) {
                iVar.field_aesKey = SQLiteDatabase.KeyEmpty;
            }
            iVar.cFQ = false;
            if (b(iVar.field_mediaId, null) || z) {
                ak.vA().f(new Runnable(this) {
                    final /* synthetic */ f cFG;

                    public final void run() {
                        this.cFG.cFa.add(iVar.field_mediaId);
                        this.cFG.cFb.put(iVar.field_mediaId, iVar);
                        f.a(this.cFG);
                    }
                }, 300);
            } else {
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ f cFG;

                    public final void run() {
                        this.cFG.cFa.add(iVar.field_mediaId);
                        this.cFG.cFb.put(iVar.field_mediaId, iVar);
                        f.a(this.cFG);
                    }
                });
            }
            return true;
        }
    }

    public final boolean b(final String str, final Object[] objArr) {
        boolean z = false;
        if (!be.kS(str)) {
            if (this.cFc.containsKey(str)) {
                z = true;
            }
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ f cFG;

                public final void run() {
                    i iVar = (i) this.cFG.cFc.remove(str);
                    keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult;
                    if (iVar != null) {
                        com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
                        g.Ea();
                        if (b.a(iVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult) == 0) {
                            f.a(objArr, com_tencent_mm_modelcdntran_keep_SceneResult, iVar);
                        } else {
                            v.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(b.a(iVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult)), iVar.field_mediaId);
                        }
                    } else {
                        iVar = (i) this.cFG.cFD.remove(str);
                        com_tencent_mm_modelcdntran_keep_SceneResult = (keep_SceneResult) this.cFG.cFE.remove(str);
                        if (!(iVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null)) {
                            f.a(objArr, com_tencent_mm_modelcdntran_keep_SceneResult, iVar);
                        }
                    }
                    this.cFG.cFb.remove(str);
                }
            });
        }
        v.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        if (((i) this.cFc.get(str)) == null) {
            v.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", str);
            return false;
        }
        g.Ea();
        v.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(b.isVideoDataAvailable(str, i, i2)));
        return b.isVideoDataAvailable(str, i, i2);
    }

    public static int requestVideoData(String str, int i, int i2, int i3) {
        g.Ea();
        v.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(b.requestVideoData(str, i, i2, i3)));
        return b.requestVideoData(str, i, i2, i3);
    }

    public final void onMoovReady(final String str, final int i, final int i2) {
        v.i("MicroMsg.OnlineVideoService", "onMoovReady");
        if (!be.kS(str)) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ f cFG;

                public final void run() {
                    i iVar = (i) this.cFG.cFc.get(str);
                    if (iVar == null) {
                        return;
                    }
                    if (m.kX(iVar.field_fullpath)) {
                        v.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + iVar.cFV);
                        if (iVar.cFV) {
                            f.requestVideoData(iVar.field_mediaId, 0, iVar.field_totalLen, 0);
                            g.iuh.a(354, 19, 1, false);
                            return;
                        }
                        return;
                    }
                    b jjVar = new jj();
                    jjVar.bjO.bdn = 1;
                    jjVar.bjO.aYJ = 0;
                    jjVar.bjO.mediaId = str;
                    jjVar.bjO.offset = i;
                    jjVar.bjO.length = i2;
                    com.tencent.mm.sdk.c.a.nhr.z(jjVar);
                    n lp = p.lp(iVar.filename);
                    if (lp != null) {
                        v.i("MicroMsg.OnlineVideoService", "on moov ready info: " + lp.getFileName() + " status : " + lp.status);
                        if (lp.status != 130 && lp.status != 122) {
                            lp = p.lp(iVar.filename);
                            if (lp != null) {
                                lp.status = 121;
                                lp.bkU = FileUtils.S_IRUSR;
                                k.KV().b(lp);
                            }
                            if (!iVar.cFV) {
                                v.i("MicroMsg.OnlineVideoService", "stop download video");
                                k.KY().Lp();
                                k.KY().run();
                            }
                        }
                    }
                }
            });
        }
    }

    public final void onDataAvailable(final String str, final int i, final int i2) {
        v.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!be.kS(str)) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ f cFG;

                public final void run() {
                    if (((i) this.cFG.cFc.get(str)) != null) {
                        b jjVar = new jj();
                        jjVar.bjO.bdn = 2;
                        jjVar.bjO.aYJ = 0;
                        jjVar.bjO.mediaId = str;
                        jjVar.bjO.offset = i;
                        jjVar.bjO.length = i2;
                        com.tencent.mm.sdk.c.a.nhr.z(jjVar);
                    }
                }
            });
        }
    }

    public final void onDownloadToEnd(final String str, final int i, final int i2) {
        v.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!be.kS(str)) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ f cFG;

                public final void run() {
                    i iVar = (i) this.cFG.cFc.get(str);
                    if (iVar != null) {
                        b jjVar = new jj();
                        jjVar.bjO.bdn = 3;
                        jjVar.bjO.aYJ = 0;
                        jjVar.bjO.mediaId = str;
                        jjVar.bjO.offset = i;
                        jjVar.bjO.length = i2;
                        com.tencent.mm.sdk.c.a.nhr.z(jjVar);
                        if (i == 0 && i2 >= iVar.cFU) {
                            f.a(p.lp(iVar.filename), iVar.cFU, iVar.cFT);
                        }
                    }
                }
            });
        }
    }

    public final int a(final String str, final keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (be.kS(str)) {
            v.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            return -1;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null && com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            v.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            return -2;
        } else {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ f cFG;

                public final void run() {
                    i iVar = (i) this.cFG.cFc.get(str);
                    if (iVar != null) {
                        n lp = p.lp(iVar.filename);
                        if (lp == null) {
                            v.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", iVar.filename);
                        } else if (iVar.cFR != null) {
                            iVar.cFR.a(str, 0, com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, iVar.field_onlycheckexist);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                                this.cFG.cFc.remove(str);
                            }
                        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                            if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == lp.cyu) {
                                v.i("MicroMsg.OnlineVideoService", "stream download finish.");
                            } else if (lp.status == 130 || lp.dhE <= com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                                v.i("MicroMsg.OnlineVideoService", "callback progress info " + com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength);
                                lp.dhI = be.Nh();
                                lp.dhE = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                                lp.bkU = 1040;
                                p.e(lp);
                                r0 = new jj();
                                r0.bjO.bdn = 5;
                                r0.bjO.mediaId = str;
                                r0.bjO.offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                                r0.bjO.length = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                                com.tencent.mm.sdk.c.a.nhr.z(r0);
                            } else {
                                v.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", Integer.valueOf(lp.dhE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                            }
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            v.i("MicroMsg.OnlineVideoService", "callback result info " + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode + ", filesize:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + ",recved:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != -10012) {
                                    p.lh(lp.getFileName());
                                }
                                boolean Eb = iVar.Eb();
                                int i = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                                boolean z = iVar.cFV;
                                if (Eb) {
                                    if (z) {
                                        if (i == -5103059) {
                                            g.iuh.a(354, 111, 1, false);
                                        } else if (i == -5103087) {
                                            g.iuh.a(354, 112, 1, false);
                                        } else if (i == -10012) {
                                            g.iuh.a(354, 113, 1, false);
                                        } else {
                                            g.iuh.a(354, 114, 1, false);
                                        }
                                    } else if (i == -5103059) {
                                        g.iuh.a(354, 116, 1, false);
                                    } else if (i == -5103087) {
                                        g.iuh.a(354, 117, 1, false);
                                    } else if (i == -10012) {
                                        g.iuh.a(354, 118, 1, false);
                                    } else {
                                        g.iuh.a(354, 119, 1, false);
                                    }
                                    g.iuh.h(13836, Integer.valueOf(MMGIFException.D_GIF_ERR_OPEN_FAILED), Long.valueOf(be.Nh()), Integer.valueOf(i));
                                } else {
                                    g.iuh.a(354, 213, 1, false);
                                    if (z) {
                                        g.iuh.a(354, 214, 1, false);
                                    } else {
                                        g.iuh.a(354, 215, 1, false);
                                    }
                                    g.iuh.h(13836, Integer.valueOf(201), Long.valueOf(be.Nh()), Integer.valueOf(i));
                                }
                            } else {
                                f.a(lp, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength, iVar.cFT);
                                this.cFG.cFD.put(iVar.field_mediaId, iVar);
                                this.cFG.cFE.put(iVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult);
                            }
                            r0 = new jj();
                            r0.bjO.bdn = 4;
                            r0.bjO.mediaId = str;
                            r0.bjO.offset = 0;
                            r0.bjO.aYJ = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                            r0.bjO.length = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                            com.tencent.mm.sdk.c.a.nhr.z(r0);
                            this.cFG.cFc.remove(str);
                        }
                    }
                }
            });
            if (this.cFc.get(str) != null) {
                return 1;
            }
            return 0;
        }
    }

    static void a(n nVar, int i, String str) {
        v.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", Integer.valueOf(i));
        if (nVar != null) {
            p.E(nVar.getFileName(), i);
            String fileName = nVar.getFileName();
            if (!be.kS(str)) {
                k.KV();
                fileName = o.lc(fileName);
                if (be.kS(str) || i <= 0 || be.kS(fileName)) {
                    v.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str, fileName);
                    return;
                }
                ak.yW().wM().p(str, i, fileName);
            }
        }
    }

    public static i a(com.tencent.mm.storage.ak akVar, String str, String str2, String str3, boolean z) {
        if (akVar == null) {
            v.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            return null;
        } else if (be.kS(str)) {
            v.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            return null;
        } else {
            n lp = p.lp(str3);
            if (lp == null) {
                v.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", str3);
                return null;
            }
            String a = d.a("snsvideo", (long) akVar.hrm, "sns", str);
            if (be.kS(a)) {
                v.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", str);
                return null;
            }
            i iVar = new i();
            iVar.filename = str3;
            iVar.field_fullpath = str2;
            iVar.field_mediaId = a;
            iVar.cFS = 2;
            iVar.cFV = z;
            iVar.cFX = lp.cFX;
            String str4 = SQLiteDatabase.KeyEmpty;
            if (akVar == null) {
                str4 = SQLiteDatabase.KeyEmpty;
            } else if (akVar.equals(com.tencent.mm.storage.ak.nvq)) {
                str4 = "album_friend";
            } else if (akVar.equals(com.tencent.mm.storage.ak.nvr)) {
                str4 = "album_self";
            } else if (akVar.equals(com.tencent.mm.storage.ak.nvs)) {
                str4 = "album_stranger";
            } else if (akVar.equals(com.tencent.mm.storage.ak.nvt)) {
                str4 = "profile_friend";
            } else if (akVar.equals(com.tencent.mm.storage.ak.nvu)) {
                str4 = "profile_stranger";
            } else if (akVar.equals(com.tencent.mm.storage.ak.nvv)) {
                str4 = "comment";
            } else if (akVar.equals(com.tencent.mm.storage.ak.nvp)) {
                str4 = "timeline";
            }
            if (!be.kS(str4)) {
                str4 = "&scene=" + str4;
            }
            r4 = new Object[5];
            ak.yW();
            r4[1] = com.tencent.mm.a.o.getString(c.ww());
            r4[2] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getNetTypeForStat(aa.getContext()));
            r4[3] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getStrength(aa.getContext()));
            r4[4] = str4;
            iVar.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", r4);
            iVar.url = str;
            long j = (long) com.tencent.mm.h.j.sU().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            v.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s", com.tencent.mm.h.j.sU().getValue("SnsSightDomainList"), Long.valueOf(j));
            if (j <= 0) {
                j = 259200;
            }
            boolean a2 = a(akVar, iVar.url, j, r4);
            try {
                iVar.host = new URL(iVar.url).getHost();
                List arrayList = new ArrayList();
                com.tencent.mm.network.b.a(a2, arrayList, iVar.host);
                iVar.iplist = new String[arrayList.size()];
                arrayList.toArray(iVar.iplist);
                return iVar;
            } catch (Throwable e) {
                v.a("MicroMsg.OnlineVideoService", e, "check can sns online video error taskInfo %s", iVar);
                return null;
            }
        }
    }

    private static boolean a(com.tencent.mm.storage.ak akVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (akVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || akVar.hrm == 0 || be.ax((long) akVar.hrm) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.OnlineVideoService", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    public static void a(Object[] objArr, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, i iVar) {
        if (iVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            v.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
            return;
        }
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        boolean Eb = iVar.Eb();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pInt2.value = 0;
        pInt.value = 0;
        p.a(iVar.field_fullpath, pInt, pInt2);
        int i = pInt.value * 1000;
        int i2 = pInt2.value;
        int i3 = 0;
        if (objArr != null) {
            intValue = ((Integer) objArr[0]).intValue() * 1000;
            intValue2 = ((Integer) objArr[1]).intValue();
            intValue3 = ((Integer) objArr[2]).intValue();
            int intValue7 = ((Integer) objArr[3]).intValue();
            intValue4 = ((Integer) objArr[4]).intValue();
            intValue5 = ((Integer) objArr[5]).intValue();
            intValue6 = ((Integer) objArr[6]).intValue();
            i3 = intValue7;
        } else {
            intValue5 = 0;
            intValue6 = 0;
            intValue = 0;
            intValue2 = 0;
            intValue3 = 0;
            intValue4 = 0;
        }
        int i4 = iVar.cFX;
        if (i4 <= 0) {
            if (Eb) {
                i4 = 10;
            } else {
                i4 = 31;
            }
        }
        int dP = com.tencent.mm.sdk.platformtools.ak.dP(aa.getContext());
        StringBuffer stringBuffer = new StringBuffer();
        if (Eb) {
            stringBuffer.append(iVar.field_fileId).append(",").append(iVar.field_aesKey).append(",");
        } else {
            stringBuffer.append(iVar.url).append(",").append(iVar.cFY).append(",");
        }
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength).append(",").append(i).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes).append(",");
        stringBuffer.append(intValue + ",").append(intValue2 + ",").append(intValue3 + ",");
        stringBuffer.append(i3 + ",").append(intValue4 + ",");
        stringBuffer.append(dP).append(",");
        stringBuffer.append(i4).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime).append(",");
        if (Eb) {
            stringBuffer.append(iVar.cFW).append(",");
            stringBuffer.append(iVar.bhN).append(",");
        } else {
            stringBuffer.append(0).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_httpStatusCode).append(",");
        }
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_enQueueTime).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCost).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestSize).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestDownloadSize).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCompleted ? 1 : 0).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_averageSpeed).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_averageConnectCost).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstConnectCost).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_netConnectTimes).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovRequestTimes).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCost).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovSize).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCompleted ? 1 : 0).append(",");
        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovFailReason).append(",");
        stringBuffer.append(intValue5).append(",");
        stringBuffer.append(intValue6).append(",");
        if (Eb) {
            stringBuffer.append(i2);
        } else {
            stringBuffer.append(i2).append(",");
            stringBuffer.append(iVar.cFW);
        }
        v.i("MicroMsg.OnlineVideoService", "report online video %d:%s", Integer.valueOf(Eb ? 13570 : 13790), stringBuffer.toString());
        g.iuh.Y(i3, r3);
        String str = iVar.cFW;
        intValue4 = iVar.bhN;
        String str2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        String str3 = iVar.cFT;
        long j = com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime;
        long j2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime;
        String str4 = iVar.field_fullpath;
        String[] strArr = com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps;
        String str5 = iVar.url;
        b hyVar = new hy();
        hyVar.bhL.bhM = str;
        hyVar.bhL.bhN = intValue4;
        hyVar.bhL.bhO = str2;
        hyVar.bhL.netType = dP;
        hyVar.bhL.bhP = str3;
        hyVar.bhL.startTime = j;
        hyVar.bhL.endTime = j2;
        hyVar.bhL.path = str4;
        hyVar.bhL.bhQ = strArr;
        hyVar.bhL.bhR = str5;
        com.tencent.mm.sdk.c.a.nhr.z(hyVar);
    }
}
