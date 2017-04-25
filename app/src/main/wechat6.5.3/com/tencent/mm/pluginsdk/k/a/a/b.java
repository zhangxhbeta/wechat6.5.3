package com.tencent.mm.pluginsdk.k.a.a;

import android.os.Looper;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.as;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.k.a.c.d;
import com.tencent.mm.pluginsdk.k.a.c.h;
import com.tencent.mm.pluginsdk.k.a.c.i;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.auz;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private final k lDa;
    private final d lgB;

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String dpu;
        final /* synthetic */ b lDb;
        final /* synthetic */ int lDd;
        final /* synthetic */ int lDe;
        final /* synthetic */ int lDn;
        final /* synthetic */ boolean lDo;

        AnonymousClass6(b bVar, int i, int i2, String str, int i3, boolean z) {
            this.lDb = bVar;
            this.lDd = i;
            this.lDe = i2;
            this.dpu = str;
            this.lDn = i3;
            this.lDo = z;
        }

        public final void run() {
            com.tencent.mm.sdk.c.b arVar = new ar();
            arVar.aYn.aYo = this.lDd;
            arVar.aYn.aYp = this.lDe;
            arVar.aYn.filePath = this.dpu;
            arVar.aYn.aYq = this.lDn;
            arVar.aYn.aYr = this.lDo;
            com.tencent.mm.sdk.c.a.nhr.z(arVar);
        }
    }

    private static final class b {
        private static final b lDs = new b();
    }

    public static final class a implements h {
        private final c lDp = new c<jx>(this) {
            final /* synthetic */ a lDr;

            {
                this.lDr = r2;
                this.nhz = jx.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                if (ak.uz() && !ak.uG()) {
                    long Nh = be.Nh();
                    ak.yW();
                    long a = be.a((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, null), 0);
                    if (a != 0 && a < Nh) {
                        p.WK();
                    }
                }
                return false;
            }
        };
        private final h lDq = new h();
        private final com.tencent.mm.model.bo.b lfU = new com.tencent.mm.model.bo.b(this) {
            final /* synthetic */ a lDr;

            {
                this.lDr = r1;
            }

            public final void a(com.tencent.mm.v.d.a aVar) {
                String a = m.a(aVar.czu.mbW);
                if (be.kS(a)) {
                    v.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
                    return;
                }
                v.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n" + a);
                if (!be.kS(a)) {
                    Map q = bf.q(a, "sysmsg");
                    j.q(0, 0);
                    String str = "MicroMsg.CheckResUpdateNewXmlParser";
                    String str2 = "parsed values.size = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = q == null ? "null" : String.valueOf(q.size());
                    v.i(str, str2, objArr);
                    if (q == null) {
                        j.q(0, 30);
                    } else {
                        j.q(0, 31);
                    }
                    if (q != null && q.size() > 0 && be.ma((String) q.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                        e.e(".sysmsg", "delete", q);
                        e.e(".sysmsg", "cache", q);
                        e.e(".sysmsg", "decrypt", q);
                    }
                }
            }
        };

        public final void biS() {
            com.tencent.mm.sdk.c.a.nhr.e(this.lDp);
            ak.yU().a("resourcemgr", this.lfU, true);
            p.WK();
        }

        public final void th() {
            com.tencent.mm.sdk.c.a.nhr.f(this.lDp);
            ak.yU().b("resourcemgr", this.lfU, true);
        }

        public final String Pa() {
            return "CheckResUpdate";
        }

        public final com.tencent.mm.pluginsdk.k.a.c.n.a c(l lVar) {
            if (lVar instanceof c) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
                return new d((c) lVar);
            }
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
            return null;
        }

        public final i biT() {
            return this.lDq;
        }
    }

    private b() {
        this.lDa = new k();
        this.lgB = new d(this) {
            final /* synthetic */ b lDb;

            {
                this.lDb = r1;
            }

            public final void a(String str, com.tencent.mm.pluginsdk.k.a.c.m mVar) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = " + str);
                r Hg = a.lED.Hg(str);
                if (Hg != null) {
                    j.q(Hg.field_reportId, 10);
                    j.q(Hg.field_reportId, 15);
                    if ((!Hg.field_fileCompress || Hg.field_fileEncrypt) && Hg.field_fileUpdated) {
                        j.a(Hg.field_resType, Hg.field_subType, Hg.field_url, be.getInt(Hg.field_fileVersion, 0), Hg.field_maxRetryTimes > Hg.field_retryTimes ? com.tencent.mm.pluginsdk.k.a.a.j.a.lDO : com.tencent.mm.pluginsdk.k.a.a.j.a.lDM, true, be.ma(Hg.field_groupId2).equals("NewXml"), false, Hg.field_sampleId);
                    }
                    if (Hg.field_fileCompress || Hg.field_fileEncrypt) {
                        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                        this.lDb.a(Hg);
                        return;
                    }
                    com.tencent.mm.sdk.c.b arVar = new ar();
                    arVar.aYn.filePath = Hg.field_filePath;
                    arVar.aYn.aYr = Hg.field_fileUpdated;
                    arVar.aYn.aYq = be.getInt(Hg.field_fileVersion, 0);
                    arVar.aYn.aYo = Hg.field_resType;
                    arVar.aYn.aYp = Hg.field_subType;
                    com.tencent.mm.sdk.c.a.nhr.a(arVar, Looper.getMainLooper());
                    Hg.field_fileUpdated = false;
                    a.lED.e(Hg);
                }
            }

            public final void b(String str, com.tencent.mm.pluginsdk.k.a.c.m mVar) {
                i.Ha(str);
                r Hg = a.lED.Hg(str);
                if (Hg != null) {
                    boolean z = true;
                    if (!(mVar == null || mVar.lEv == null)) {
                        if (mVar.lEv instanceof com.tencent.mm.pluginsdk.k.a.b.a) {
                            j.q(Hg.field_reportId, 7);
                            z = false;
                        } else if (mVar.lEv instanceof com.tencent.mm.pluginsdk.k.a.b.c) {
                            j.q(Hg.field_reportId, 16);
                            z = false;
                        }
                    }
                    if (z) {
                        j.q(Hg.field_reportId, 11);
                    }
                    j.q(Hg.field_reportId, 44);
                    j.a(Hg.field_resType, Hg.field_subType, Hg.field_url, be.getInt(Hg.field_fileVersion, 0), com.tencent.mm.pluginsdk.k.a.a.j.a.lDN, false, "NewXml".equalsIgnoreCase(Hg.field_groupId2), false, Hg.field_sampleId);
                }
            }

            public final void Ev(String str) {
                p bog = a.lED;
                if (!(bog.lfs ? bog.lEB.Ap(str) : false)) {
                    i.Ha(str);
                }
            }

            public final String Pa() {
                return "CheckResUpdate";
            }
        };
        a.lED.a("CheckResUpdate", this.lgB);
    }

    public static String cT(int i, int i2) {
        r Hg = a.lED.Hg(i.cU(i, i2));
        if (Hg == null) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        }
        v.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", Boolean.valueOf(Hg.field_deleted), Hg.field_filePath, Hg.field_md5, Boolean.valueOf(Hg.field_fileCompress), Boolean.valueOf(Hg.field_fileEncrypt), Hg.field_originalMd5);
        if (Hg.field_fileCompress || Hg.field_fileEncrypt) {
            String str;
            if (Hg.field_fileCompress) {
                str = Hg.field_filePath + ".decompressed";
            } else if (Hg.field_fileEncrypt) {
                str = Hg.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (be.kS(str)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", Integer.valueOf(i), Integer.valueOf(i2));
                return null;
            } else if (be.kS(Hg.field_originalMd5) || !be.ma(g.aX(str)).equals(Hg.field_originalMd5)) {
                v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", Integer.valueOf(i), Integer.valueOf(i2));
                return null;
            } else {
                v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                return str;
            }
        } else if (Hg.field_deleted || be.kS(Hg.field_filePath) || !be.ma(g.aX(Hg.field_filePath)).equals(Hg.field_md5)) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        } else {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", Integer.valueOf(i), Integer.valueOf(i2), Hg.field_filePath);
            return Hg.field_filePath;
        }
    }

    final void a(r rVar) {
        v.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + rVar.field_urlKey);
        k kVar = this.lDa;
        if (kVar.Hd(rVar.field_urlKey)) {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
            return;
        }
        kVar.a(new a(rVar.field_urlKey, rVar.field_resType, rVar.field_subType, be.getInt(rVar.field_fileVersion, 0), rVar.field_fileUpdated, rVar.field_filePath, rVar.field_fileEncrypt, rVar.field_fileCompress, rVar.field_encryptKey, rVar.field_keyVersion, rVar.field_eccSignature, rVar.field_originalMd5, be.ma(rVar.field_groupId2).equals("NewXml"), rVar.field_reportId, rVar.field_sampleId, rVar.field_url, rVar.field_maxRetryTimes, rVar.field_retryTimes));
    }

    final void a(int i, aqq com_tencent_mm_protocal_c_aqq, boolean z) {
        final String cU = i.cU(i, com_tencent_mm_protocal_c_aqq.mNI);
        if (com_tencent_mm_protocal_c_aqq.mPV == null) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            return;
        }
        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_aqq.mNI), Integer.valueOf(com_tencent_mm_protocal_c_aqq.mPV.mQe));
        j.q((long) com_tencent_mm_protocal_c_aqq.jho, 3);
        final int i2 = com_tencent_mm_protocal_c_aqq.mPV.mQe;
        final int i3 = com_tencent_mm_protocal_c_aqq.mNI;
        final int i4 = com_tencent_mm_protocal_c_aqq.jho;
        final String str = com_tencent_mm_protocal_c_aqq.mPX;
        final int i5 = i;
        final boolean z2 = z;
        a.lED.q(new Runnable(this) {
            final /* synthetic */ b lDb;

            public final void run() {
                r Hg = a.lED.Hg(cU);
                int i = i5;
                int i2 = i3;
                int i3 = i2;
                int i4 = i4;
                String str = str;
                boolean z = z2;
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record " + Hg);
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", Integer.valueOf(i3));
                boolean z2 = false;
                if (Hg == null) {
                    j.q((long) i4, 47);
                    j.q((long) i4, 22);
                    z2 = true;
                } else if (be.getInt(Hg.field_fileVersion, 0) <= i3) {
                    z2 = true;
                } else {
                    j.q(Hg.field_reportId, 47);
                    j.q(Hg.field_reportId, 22);
                }
                String cU = i.cU(i, i2);
                String GZ = i.GZ(cU);
                v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", Boolean.valueOf(z2), GZ);
                if (z2) {
                    a.lED.Hi(cU);
                    b.lDs.f(i, i2, 2, z);
                    if ((((com.tencent.mm.pluginsdk.k.a.d.a.Hl(GZ) & 1) & com.tencent.mm.pluginsdk.k.a.d.a.Hl(GZ + ".decompressed")) & com.tencent.mm.pluginsdk.k.a.d.a.Hl(GZ + ".decrypted")) != 0) {
                        if (Hg != null) {
                            j.q(Hg.field_reportId, 21);
                            j.a(Hg.field_resType, Hg.field_subType, i3, z, Hg.field_sampleId);
                        }
                    } else if (Hg != null) {
                        j.q(Hg.field_reportId, 22);
                        j.q(Hg.field_reportId, 47);
                    }
                    if (Hg == null) {
                        r rVar = new r();
                        rVar.field_urlKey = cU;
                        rVar.field_resType = i;
                        rVar.field_subType = i2;
                        rVar.field_deleted = true;
                        rVar.field_fileVersion = String.valueOf(i3);
                        rVar.field_reportId = (long) i4;
                        rVar.field_sampleId = str;
                        a.lED.e(rVar);
                        return;
                    }
                    Hg.field_deleted = true;
                    Hg.field_fileVersion = String.valueOf(i3);
                    a.lED.e(Hg);
                }
            }
        });
    }

    final void b(int i, aqq com_tencent_mm_protocal_c_aqq, boolean z) {
        String cU = i.cU(i, com_tencent_mm_protocal_c_aqq.mNI);
        if (com_tencent_mm_protocal_c_aqq.mPV == null) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(), resource.Info = null, return");
            return;
        }
        String str;
        String str2 = "MicroMsg.ResDownloader.CheckResUpdateHelper";
        String str3 = "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_aqq.mNI);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_aqq.mPV.mQe);
        if (com_tencent_mm_protocal_c_aqq.mPV.mQg == null) {
            str = "null";
        } else {
            str = String.valueOf(com_tencent_mm_protocal_c_aqq.mPV.mQg.size());
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_aqq.jho);
        objArr[6] = com_tencent_mm_protocal_c_aqq.mPX;
        objArr[7] = com_tencent_mm_protocal_c_aqq.mPV.glb;
        objArr[8] = com_tencent_mm_protocal_c_aqq.mPV.mQh;
        v.i(str2, str3, objArr);
        if (com_tencent_mm_protocal_c_aqq.mPV.mQg != null) {
            Iterator it = com_tencent_mm_protocal_c_aqq.mPV.mQg.iterator();
            while (it.hasNext()) {
                auz com_tencent_mm_protocal_c_auz = (auz) it.next();
                v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", Integer.valueOf(com_tencent_mm_protocal_c_auz.efl), com_tencent_mm_protocal_c_auz.mSx.brp());
            }
        }
        j.dP((long) com_tencent_mm_protocal_c_aqq.jho);
        if (!z) {
            j.q((long) com_tencent_mm_protocal_c_aqq.jho, 1);
        }
        if (com_tencent_mm_protocal_c_aqq.mjt != 0 && ((long) com_tencent_mm_protocal_c_aqq.mjt) <= be.Nh()) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", cU, Integer.valueOf(com_tencent_mm_protocal_c_aqq.mjt), Integer.valueOf(com_tencent_mm_protocal_c_aqq.mPV.mQe));
            j.q((long) com_tencent_mm_protocal_c_aqq.jho, 14);
            j.q((long) com_tencent_mm_protocal_c_aqq.jho, 44);
            j.a(i, com_tencent_mm_protocal_c_aqq.mNI, com_tencent_mm_protocal_c_aqq.mPV.glb, com_tencent_mm_protocal_c_aqq.mPV.mQe, com.tencent.mm.pluginsdk.k.a.a.j.a.lDQ, false, z, false, com_tencent_mm_protocal_c_aqq.mPX);
        } else if (be.kS(com_tencent_mm_protocal_c_aqq.mPV.glb) && com_tencent_mm_protocal_c_aqq.mPV.mQh == null) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
        } else {
            com.tencent.mm.pluginsdk.k.a.c.a.a aVar = new com.tencent.mm.pluginsdk.k.a.a.g.a(com_tencent_mm_protocal_c_aqq.mPV.glb);
            aVar.lCO = cU;
            aVar.aYo = i;
            aVar.aYp = com_tencent_mm_protocal_c_aqq.mNI;
            aVar.dby = (long) com_tencent_mm_protocal_c_aqq.mjt;
            aVar.aYq = com_tencent_mm_protocal_c_aqq.mPV.mQe;
            aVar.aZy = com_tencent_mm_protocal_c_aqq.mPV.mpI;
            aVar.lDu = a.tG(com_tencent_mm_protocal_c_aqq.mPV.mQf);
            aVar.lDv = a.tF(com_tencent_mm_protocal_c_aqq.mPV.mQf);
            aVar.lCW = (long) com_tencent_mm_protocal_c_aqq.jho;
            aVar.lCX = com_tencent_mm_protocal_c_aqq.mPX;
            aVar.lCY = com_tencent_mm_protocal_c_aqq.mPY > 0 ? com_tencent_mm_protocal_c_aqq.mPY : 3;
            aVar.lDw = com_tencent_mm_protocal_c_aqq.lDw;
            aVar.networkType = com_tencent_mm_protocal_c_aqq.mPZ;
            aVar.aYu = z;
            if (!be.bP(com_tencent_mm_protocal_c_aqq.mPV.mQg)) {
                aVar.lCT = ((auz) com_tencent_mm_protocal_c_aqq.mPV.mQg.get(0)).mSx.lVU;
            }
            if (!(com_tencent_mm_protocal_c_aqq.mPW == null || be.kS(com_tencent_mm_protocal_c_aqq.mPW.mQd))) {
                aVar.lCR = com_tencent_mm_protocal_c_aqq.mPW.mQd;
                aVar.lCS = com_tencent_mm_protocal_c_aqq.mPW.mQc;
            }
            if (com_tencent_mm_protocal_c_aqq.mPV.mQh != null && com_tencent_mm_protocal_c_aqq.mPV.mQh.lVU.length > 0) {
                aVar.lDt = com_tencent_mm_protocal_c_aqq.mPV.mQh.toByteArray();
            }
            aVar.lCU = com_tencent_mm_protocal_c_aqq.mPV.mQi;
            aVar.fileSize = (long) com_tencent_mm_protocal_c_aqq.mPV.moo;
            aVar.priority = com_tencent_mm_protocal_c_aqq.mDr;
            final g gVar = new g(aVar.url, aVar.lCO, aVar.aYq, aVar.networkType, aVar.lCY, aVar.dby, aVar.aZy, aVar.aYo, aVar.aYp, aVar.lCW, aVar.lCX, aVar.lCT, aVar.lCU, aVar.lDu, aVar.lDv, aVar.lCR, aVar.lCS, aVar.lDw, aVar.lDt, aVar.fileSize, aVar.aYu, aVar.aYr, aVar.priority);
            v.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", gVar.toString());
            final String str4 = cU;
            a.lED.q(new Runnable(this) {
                final /* synthetic */ b lDb;

                public final void run() {
                    a.a(a.lED.Hg(str4), gVar);
                }
            });
        }
    }

    final void c(int i, aqq com_tencent_mm_protocal_c_aqq, boolean z) {
        final String cU = i.cU(i, com_tencent_mm_protocal_c_aqq.mNI);
        if (com_tencent_mm_protocal_c_aqq.mPW == null) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
        } else if (be.kS(com_tencent_mm_protocal_c_aqq.mPW.mQd)) {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
        } else {
            v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_aqq.mNI), Integer.valueOf(com_tencent_mm_protocal_c_aqq.mPW.mQc));
            v.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", com_tencent_mm_protocal_c_aqq.mPW.mQd);
            j.q((long) com_tencent_mm_protocal_c_aqq.jho, 4);
            final String str = com_tencent_mm_protocal_c_aqq.mPV.mQi;
            final String str2 = com_tencent_mm_protocal_c_aqq.mPW.mQd;
            final int i2 = com_tencent_mm_protocal_c_aqq.mPW.mQc;
            final int i3 = com_tencent_mm_protocal_c_aqq.jho;
            final String str3 = com_tencent_mm_protocal_c_aqq.mPX;
            a.lED.q(new Runnable(this) {
                final /* synthetic */ b lDb;

                public final void run() {
                    r Hg = a.lED.Hg(cU);
                    String str = str;
                    String str2 = str2;
                    int i = i2;
                    int i2 = i3;
                    String str3 = str3;
                    if (Hg == null) {
                        Hg = new r();
                        Hg.field_keyVersion = i;
                        Hg.field_encryptKey = str2;
                        Hg.field_reportId = (long) i2;
                        Hg.field_sampleId = str3;
                        Hg.field_originalMd5 = str;
                        a.lED.e(Hg);
                        j.q((long) i2, 51);
                        j.q((long) i2, 45);
                    } else if (Hg.field_keyVersion < i) {
                        Hg.field_keyVersion = i;
                        Hg.field_encryptKey = str2;
                        Hg.field_reportId = (long) i2;
                        Hg.field_sampleId = str3;
                        if (be.kS(Hg.field_originalMd5)) {
                            Hg.field_originalMd5 = str;
                        }
                        a.lED.e(Hg);
                        b.a(Hg, true);
                    }
                }
            });
        }
    }

    final void a(int i, int i2, String str, int i3) {
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final int i6 = i3;
        a.lED.q(new Runnable(this) {
            final /* synthetic */ b lDb;

            public final void run() {
                b bVar = this.lDb;
                int i = i4;
                int i2 = i5;
                String str = str2;
                int i3 = i6;
                r Hg = a.lED.Hg(i.cU(i, i2));
                if (Hg != null) {
                    boolean z = Hg.field_fileUpdated;
                    Hg.field_fileUpdated = false;
                    a.lED.e(Hg);
                    if (i3 != be.getInt(Hg.field_fileVersion, 0)) {
                        return;
                    }
                    if (a.lED.handler == null) {
                        v.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
                    } else {
                        a.lED.handler.post(new AnonymousClass6(bVar, i, i2, str, i3, z));
                    }
                }
            }
        });
    }

    final void f(int i, int i2, int i3, boolean z) {
        if (a.lED.handler == null) {
            v.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
            return;
        }
        final int i4 = i3;
        final int i5 = i;
        final int i6 = i2;
        final boolean z2 = z;
        a.lED.handler.post(new Runnable(this) {
            final /* synthetic */ b lDb;

            public final void run() {
                com.tencent.mm.sdk.c.b asVar = new as();
                asVar.aYs.aYt = i4;
                asVar.aYs.aYo = i5;
                asVar.aYs.aYp = i6;
                asVar.aYs.aYu = z2;
                com.tencent.mm.sdk.c.a.nhr.z(asVar);
            }
        });
    }
}
