package com.tencent.mm.as;

import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i {
    private static int aVy = 0;
    private ah aVA = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ i dgY;

        {
            this.dgY = r1;
        }

        public final boolean oU() {
            i.h(this.dgY);
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private boolean aVu = false;
    private boolean aVv = false;
    int aVw = 0;
    private com.tencent.mm.compatible.util.g.a aVz = new com.tencent.mm.compatible.util.g.a();
    private LinkedList<Long> dgS = new LinkedList();
    private Map<Long, com.tencent.mm.compatible.util.g.a> dgT = new HashMap();
    private Map<Long, String> dgU = new HashMap();
    private Object dgV = new Object();
    String dgW;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long dgX;
        final /* synthetic */ i dgY;

        AnonymousClass1(i iVar, long j) {
            this.dgY = iVar;
            this.dgX = j;
        }

        public final void run() {
            long j = 0;
            i.KR();
            this.dgY.aVu = false;
            this.dgY.dgW = SQLiteDatabase.KeyEmpty;
            if (this.dgX > 0 && this.dgY.dgT.get(Long.valueOf(this.dgX)) != null) {
                j = ((com.tencent.mm.compatible.util.g.a) this.dgY.dgT.get(Long.valueOf(this.dgX))).sn();
            }
            v.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.dgX + " time:" + j + " inCnt:" + i.aVy + " stop:" + this.dgY.aVw + " running:" + this.dgY.aVv + " sending:" + this.dgY.aVu);
            if (this.dgY.aVw > 0) {
                i.h(this.dgY);
            } else if (!this.dgY.aVu) {
                this.dgY.pu();
            }
            i.KS();
        }

        public final String toString() {
            return super.toString() + "|onSceneEnd";
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ long dgX;
        final /* synthetic */ i dgY;

        public AnonymousClass5(i iVar, long j) {
            this.dgY = iVar;
            this.dgX = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r0 = r10.dgY;
            r8 = r0.dgV;
            monitor-enter(r8);
            r0 = r10.dgY;	 Catch:{ all -> 0x00b1 }
            r0 = r0.dgU;	 Catch:{ all -> 0x00b1 }
            r2 = r10.dgX;	 Catch:{ all -> 0x00b1 }
            r1 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00b1 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x00b1 }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00b1 }
            r1 = "MicroMsg.SightMassSendService";
            r2 = "cancel item, massSendId %d, cdnClientId %s";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b1 }
            r4 = 0;
            r6 = r10.dgX;	 Catch:{ all -> 0x00b1 }
            r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00b1 }
            r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
            r4 = 1;
            r3[r4] = r0;	 Catch:{ all -> 0x00b1 }
            com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ all -> 0x00b1 }
            r1 = "done_upload_cdn_client_id";
            r1 = r1.equals(r0);	 Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0045;
        L_0x003a:
            r0 = "MicroMsg.SightMassSendService";
            r1 = "doing mass send cgi, ignore cancel!";
            com.tencent.mm.sdk.platformtools.v.w(r0, r1);	 Catch:{ all -> 0x00b1 }
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
        L_0x0044:
            return;
        L_0x0045:
            r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);	 Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x006d;
        L_0x004b:
            r1 = r10.dgY;	 Catch:{ all -> 0x00b1 }
            r1 = r1.dgU;	 Catch:{ all -> 0x00b1 }
            r2 = r10.dgX;	 Catch:{ all -> 0x00b1 }
            r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00b1 }
            r3 = "";
            r1.put(r2, r3);	 Catch:{ all -> 0x00b1 }
            r1 = com.tencent.mm.modelcdntran.g.DZ();	 Catch:{ all -> 0x00b1 }
            r1.ip(r0);	 Catch:{ all -> 0x00b1 }
            r0 = r10.dgY;	 Catch:{ all -> 0x00b1 }
            r2 = r10.dgX;	 Catch:{ all -> 0x00b1 }
            r1 = 0;
            r4 = 0;
            r0.b(r2, r1, r4);	 Catch:{ all -> 0x00b1 }
        L_0x006d:
            r0 = com.tencent.mm.as.k.KV();	 Catch:{ all -> 0x00b1 }
            r6 = r10.dgX;	 Catch:{ all -> 0x00b1 }
            r1 = r0.cuX;	 Catch:{ all -> 0x00b1 }
            r2 = "videoinfo2";
            r3 = "masssendid= ?";
            r4 = 1;
            r4 = new java.lang.String[r4];	 Catch:{ all -> 0x00b1 }
            r5 = 0;
            r9 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x00b1 }
            r4[r5] = r9;	 Catch:{ all -> 0x00b1 }
            r1 = r1.delete(r2, r3, r4);	 Catch:{ all -> 0x00b1 }
            if (r1 <= 0) goto L_0x00af;
        L_0x008b:
            r1 = new com.tencent.mm.as.o$a$a;	 Catch:{ all -> 0x00b1 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b1 }
            r3 = "DELETE_";
            r2.<init>(r3);	 Catch:{ all -> 0x00b1 }
            r2 = r2.append(r6);	 Catch:{ all -> 0x00b1 }
            r2 = r2.toString();	 Catch:{ all -> 0x00b1 }
            r3 = com.tencent.mm.as.o.a.b.did;	 Catch:{ all -> 0x00b1 }
            r4 = com.tencent.mm.as.o.a.c.dig;	 Catch:{ all -> 0x00b1 }
            r5 = 3;
            r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00b1 }
            r2 = r0.cye;	 Catch:{ all -> 0x00b1 }
            r2.bg(r1);	 Catch:{ all -> 0x00b1 }
            r0 = r0.cye;	 Catch:{ all -> 0x00b1 }
            r0.Ls();	 Catch:{ all -> 0x00b1 }
        L_0x00af:
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
            goto L_0x0044;
        L_0x00b1:
            r0 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.as.i.5.run():void");
        }
    }

    private final class a implements com.tencent.mm.modelcdntran.h.a, e {
        List<n> cwe;
        final /* synthetic */ i dgY;
        String dgZ;
        long dgv;
        n dgw;
        long startTime;

        private a(i iVar) {
            this.dgY = iVar;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            v.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.dgZ, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
            if (i == -21005) {
                v.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.dgZ);
                return 0;
            } else if (i != 0) {
                i.O(this.cwe);
                v.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", Long.valueOf(this.dgv), Integer.valueOf(i));
                g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(0), SQLiteDatabase.KeyEmpty);
                this.dgY.b(this.dgv, 3, i);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                v.v("MicroMsg.SightMassSendService", "progress length %d", Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                for (n nVar : this.cwe) {
                    nVar.dhI = be.Nh();
                    nVar.dgC = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                    nVar.bkU = 1032;
                    p.e(nVar);
                }
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        v.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, Long.valueOf(this.dgv));
                        i.O(this.cwe);
                        g.iuh.h(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.dgY.b(this.dgv, 3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                    } else {
                        v.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Long.valueOf(this.dgv));
                        v.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\" ") + "cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\"/></msg>");
                        for (n nVar2 : this.cwe) {
                            if (be.kS(nVar2.Lg())) {
                                nVar2.dhQ = r1;
                                nVar2.bkU = 2097152;
                                boolean e = p.e(nVar2);
                                v.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", Long.valueOf(this.dgv), nVar2.getFileName(), Boolean.valueOf(e));
                            }
                        }
                        synchronized (this.dgY.dgV) {
                            if (be.kS((String) this.dgY.dgU.get(Long.valueOf(this.dgv)))) {
                                v.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.dgv), (String) this.dgY.dgU.get(Long.valueOf(this.dgv)), this.dgZ);
                            } else {
                                v.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.dgv), (String) this.dgY.dgU.get(Long.valueOf(this.dgv)), this.dgZ);
                                this.dgY.dgU.put(Long.valueOf(this.dgv), "done_upload_cdn_client_id");
                                ak.vy().a(245, (e) this);
                                if (!ak.vy().a(new c(this.dgv, this.dgw, com_tencent_mm_modelcdntran_keep_SceneResult, this.dgZ), 0)) {
                                    v.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                    ak.vy().b(245, (e) this);
                                    this.dgY.b(this.dgv, 3, 0);
                                }
                            }
                        }
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ak.vy().b(245, (e) this);
            if (i == 4 && i2 == -22) {
                v.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i + " errCode:" + i2 + " massSendId:" + this.dgv);
                i.P(this.cwe);
                this.dgY.b(this.dgv, i, i2);
            } else if (i == 4 && i2 != 0) {
                v.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.dgv);
                i.O(this.cwe);
                this.dgY.b(this.dgv, i, i2);
            } else if (i == 0 && i2 == 0) {
                for (n nVar : this.cwe) {
                    nVar.dhI = be.Nh();
                    nVar.status = 199;
                    nVar.bkU = 1280;
                    if (p.e(nVar)) {
                        if (nVar == null) {
                            v.e("MicroMsg.VideoLogic", "video info is null");
                        } else if (nVar.dhL > 0) {
                            ak.yW();
                            at ek = c.wJ().ek((long) nVar.dhL);
                            int i3 = ek.field_type;
                            v.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", Integer.valueOf(i3));
                            if (43 == i3 || 62 == i3) {
                                ek.di(1);
                                ek.cH(nVar.Ld());
                                ek.y(nVar.bmL);
                                ek.dh(2);
                                ek.setContent(l.b(nVar.Le(), (long) nVar.dhK, false));
                                ak.yW();
                                c.wJ().a((long) nVar.dhL, ek);
                                v.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", Long.valueOf(ek.field_msgId));
                            }
                        } else {
                            bx atVar = new at();
                            atVar.cH(nVar.Ld());
                            atVar.setType(62);
                            atVar.di(1);
                            atVar.cI(nVar.getFileName());
                            atVar.dh(2);
                            atVar.z(aw.fN(nVar.Ld()));
                            nVar.dhL = (int) aw.e(atVar);
                            nVar.bkU = 8192;
                            p.e(nVar);
                            v.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", Long.valueOf(atVar.field_msgId));
                        }
                    }
                    v.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", Long.valueOf(this.dgv), nVar.getFileName(), Integer.valueOf(199));
                }
                ak.vA().x(new AnonymousClass1(this.dgY, this.dgv));
            } else {
                v.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.dgv);
                i.O(this.cwe);
                this.dgY.b(this.dgv, i, i2);
            }
        }
    }

    static /* synthetic */ int KR() {
        int i = aVy;
        aVy = i + 1;
        return i;
    }

    static /* synthetic */ int KS() {
        int i = aVy;
        aVy = i - 1;
        return i;
    }

    static /* synthetic */ void h(i iVar) {
        if (!iVar.aVu && iVar.dgS.isEmpty()) {
            List<n> Lj = k.KV().Lj();
            if (Lj.isEmpty()) {
                v.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (n nVar : Lj) {
                    if (iVar.dgT.containsKey(Long.valueOf(nVar.dgv))) {
                        v.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", nVar.getFileName(), Long.valueOf(nVar.dgv));
                    } else {
                        v.d("MicroMsg.SightMassSendService", "Get file:" + nVar.getFileName() + " status:" + nVar.status + " user" + nVar.Ld() + " human:" + nVar.Le() + " massSendId:" + nVar.dgv + " massSendList:" + nVar.dhS + " create:" + be.ec(nVar.dhH) + " last:" + be.ec(nVar.dhI) + " now:" + be.ec(currentTimeMillis) + " " + (currentTimeMillis - nVar.dhI));
                        if (nVar.status == 200) {
                            iVar.dgS.offer(Long.valueOf(nVar.dgv));
                            iVar.dgT.put(Long.valueOf(nVar.dgv), null);
                        }
                    }
                }
                v.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + iVar.dgT.size() + " [send:" + iVar.dgS.size() + "]");
                iVar.dgS.size();
            }
        }
        if (!iVar.aVu && iVar.dgS.isEmpty()) {
            iVar.pu();
            v.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        } else if (!iVar.aVu && iVar.dgS.size() > 0) {
            Long l = (Long) iVar.dgS.poll();
            v.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", l);
            if (l != null) {
                iVar.dgT.put(l, new com.tencent.mm.compatible.util.g.a());
                iVar.aVu = true;
                iVar.dgW = iVar.ar(l.longValue());
                if (iVar.dgW == null) {
                    iVar.aVu = false;
                    iVar.aVA.ea(10);
                    return;
                }
                iVar.dgU.put(l, iVar.dgW);
            }
        }
    }

    public static void O(List<n> list) {
        if (list != null && !list.isEmpty()) {
            for (n fileName : list) {
                p.lh(fileName.getFileName());
            }
        }
    }

    public static void P(List<n> list) {
        if (list != null && !list.isEmpty()) {
            for (n fileName : list) {
                p.li(fileName.getFileName());
            }
        }
    }

    private String ar(long j) {
        List<n> as = k.KV().as(j);
        if (as.isEmpty()) {
            v.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            return null;
        }
        n nVar;
        for (n nVar2 : as) {
            if (m.fo(nVar2.Ld())) {
                v.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", nVar2.Ld(), nVar2.dhS, Long.valueOf(j));
                return null;
            }
            com.tencent.mm.modelcdntran.g.DZ();
            if (!com.tencent.mm.modelcdntran.c.fk(2) && nVar2.dhP != 1) {
                r5 = new Object[4];
                com.tencent.mm.modelcdntran.g.DZ();
                r5[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fk(2));
                r5[1] = Integer.valueOf(nVar2.dhP);
                r5[2] = nVar2.dhS;
                r5[3] = Long.valueOf(j);
                v.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", r5);
                return null;
            }
        }
        if (as == null || as.isEmpty()) {
            nVar2 = null;
        } else {
            for (int i = 0; i < as.size(); i++) {
                n lp = p.lp(((n) as.get(i)).getFileName());
                if (lp != null) {
                    v.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", nVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(as.size()), Long.valueOf(j), nVar2.dhS);
                    as.remove(i);
                    as.add(i, lp);
                    nVar2 = lp;
                    break;
                }
                v.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", nVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(as.size()), Long.valueOf(j), nVar2.dhS);
            }
            nVar2 = null;
        }
        if (nVar2 == null) {
            v.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            return null;
        }
        String a = d.a("upvideo", nVar2.dhH, nVar2.dhS, nVar2.getFileName());
        if (be.kS(a)) {
            v.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", nVar2.getFileName(), Long.valueOf(nVar2.dgv), nVar2.dhS);
            return null;
        }
        String fileName = nVar2.getFileName();
        k.KV();
        String ld = o.ld(fileName);
        k.KV();
        fileName = o.lc(fileName);
        com.tencent.mm.modelcdntran.h.a aVar = new a();
        aVar.cwe = as;
        aVar.dgv = j;
        aVar.dgZ = a;
        aVar.startTime = be.Ni();
        aVar.dgw = nVar2;
        h hVar = new h();
        hVar.cFR = aVar;
        hVar.field_mediaId = a;
        hVar.field_fullpath = fileName;
        hVar.field_thumbpath = ld;
        hVar.field_fileType = b.MediaType_VIDEO;
        hVar.field_smallVideoFlag = 1;
        hVar.field_talker = nVar2.dhS;
        hVar.field_priority = b.cEA;
        hVar.field_needStorage = false;
        hVar.field_isStreamMedia = false;
        Map q = bf.q(nVar2.Lg(), "msg");
        if (q != null) {
            hVar.field_fileId = (String) q.get(".msg.videomsg.$cdnvideourl");
            hVar.field_aesKey = (String) q.get(".msg.videomsg.$aeskey");
        } else {
            v.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
            for (n nVar22 : as) {
                if (nVar22.dhP != 1) {
                    nVar22.dhP = 1;
                    nVar22.bkU = 524288;
                    boolean e = p.e(nVar22);
                    v.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", nVar22.getFileName(), Boolean.valueOf(e));
                }
            }
            return a;
        }
        v.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
        return null;
    }

    public final void b(long j, int i, int i2) {
        final long j2 = j;
        final int i3 = i;
        final int i4 = i2;
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i dgY;

            public final void run() {
                i.KR();
                this.dgY.aVu = false;
                this.dgY.dgW = SQLiteDatabase.KeyEmpty;
                long j = 0;
                if (j2 > 0 && this.dgY.dgT.get(Long.valueOf(j2)) != null) {
                    j = ((com.tencent.mm.compatible.util.g.a) this.dgY.dgT.get(Long.valueOf(j2))).sn();
                }
                v.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4));
                if (!(i3 == 0 && i4 == 0)) {
                    this.dgY.aVw = this.dgY.aVw - 1;
                }
                v.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", Integer.valueOf(i.aVy), Integer.valueOf(this.dgY.aVw), Boolean.valueOf(this.dgY.aVv), Boolean.valueOf(this.dgY.aVu));
                if (this.dgY.aVw > 0) {
                    i.h(this.dgY);
                } else if (!this.dgY.aVu) {
                    v.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
                    o KV = k.KV();
                    List k = this.dgY.dgS;
                    if (!(k == null || k.isEmpty())) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append('(');
                        for (int i = 0; i < k.size() - 1; i++) {
                            stringBuilder.append((Long) k.get(i));
                            stringBuilder.append(',');
                        }
                        Long l = (Long) k.get(k.size() - 1);
                        if (l != null) {
                            stringBuilder.append(l);
                        }
                        stringBuilder.append(')');
                        v.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + stringBuilder.toString());
                        KV.cuX.dF("videoinfo2", r0);
                    }
                    this.dgY.pu();
                }
                i.KS();
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    private void pu() {
        this.dgU.clear();
        this.dgT.clear();
        this.dgS.clear();
        this.aVu = false;
        this.aVv = false;
        v.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.aVz.sn());
    }
}
