package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.ac;
import com.tencent.mm.e.a.f;
import com.tencent.mm.e.a.kn;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.e.a.p;
import com.tencent.mm.e.a.qe;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.e.a.r;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j implements d {
    a lAv = null;

    public interface a {
        void bnt();
    }

    public static String d(bm bmVar) {
        String a = m.a(bmVar.mbU);
        String a2 = m.a(bmVar.mbV);
        if (!be.kS(a) && !be.kS(a2)) {
            return dl(a, m.a(bmVar.mbW));
        }
        v.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
        return null;
    }

    public static String dl(String str, String str2) {
        if (be.kS(str2)) {
            return null;
        }
        if (com.tencent.mm.model.m.dE(str)) {
            int fK = aw.fK(str2);
            if (fK != -1) {
                str2 = (str2 + " ").substring(fK + 2).trim();
            }
        }
        return be.KK(str2);
    }

    public final b b(com.tencent.mm.v.d.a aVar) {
        v.d("MicroMsg.AppMessageExtension", "process add app message");
        bm bmVar = aVar.czu;
        String d = d(bmVar);
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(d);
        if (dV == null) {
            v.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            return null;
        } else if (dV.cpQ) {
            ak.yW();
            c.vf().set(352273, d);
            ak.yW();
            c.vf().set(352274, Long.valueOf(System.currentTimeMillis()));
            new a(d).bni();
            return null;
        } else {
            f Gz = am.bnB().Gz(dV.appId);
            String str = "MicroMsg.AppMessageExtension";
            String str2 = "check version appid:%s, msgVer:%d, appVer:%s";
            Object[] objArr = new Object[3];
            objArr[0] = dV.appId;
            objArr[1] = Integer.valueOf(dV.bpy);
            objArr[2] = Gz == null ? "null" : Integer.valueOf(Gz.field_appVersion);
            v.i(str, str2, objArr);
            if (Gz == null || Gz.field_appVersion < dV.bpy) {
                am.bnA().Gx(dV.appId);
            }
            b a = a(aVar, m.a(bmVar.mbW), dV);
            if (a.aXd == null) {
                return null;
            }
            bx bxVar = a.aXd;
            if (bxVar.bvZ() || bxVar.bwa()) {
                if (be.kS(dV.cqw)) {
                    return a;
                }
                com.tencent.mm.sdk.c.b rbVar = new rb();
                rbVar.bsO.blq = dV.cqw;
                com.tencent.mm.sdk.c.a.nhr.z(rbVar);
                return a;
            } else if (bxVar.field_type == 301989937) {
                return a;
            } else {
                if (bxVar.field_type == -1879048190) {
                    com.tencent.mm.sdk.c.b qfVar = new qf();
                    qfVar.bru.blq = d;
                    qfVar.bru.description = dV.description;
                    qfVar.bru.aXd = bxVar;
                    com.tencent.mm.sdk.c.a.nhr.z(qfVar);
                }
                if (bxVar.field_type == 49 && !be.kS(dV.canvasPageXml)) {
                    com.tencent.mm.sdk.c.b fVar = new f();
                    fVar.aWs.aWt = dV.canvasPageXml;
                    com.tencent.mm.sdk.c.a.nhr.z(fVar);
                }
                com.tencent.mm.q.a aVar2 = new com.tencent.mm.q.a();
                dV.a(aVar2);
                aVar2.field_msgId = bxVar.field_msgId;
                if (am.bnC().b(aVar2)) {
                    return a;
                }
                return null;
            }
        }
    }

    static String d(byte[] bArr, boolean z) {
        return n.GH().a(9, bArr, z, CompressFormat.PNG);
    }

    private b a(com.tencent.mm.v.d.a aVar, String str, com.tencent.mm.q.a.a aVar2) {
        String str2;
        int i;
        at atVar;
        com.tencent.mm.sdk.c.b acVar;
        String[] split;
        aw.b fP;
        b bVar;
        Map q;
        bm bmVar = aVar.czu;
        ak.yW();
        au wJ = c.wJ();
        ak.yW();
        ay wN = c.wN();
        String xF = k.xF();
        final String a = m.a(bmVar.mbU);
        String a2 = m.a(bmVar.mbV);
        Object obj = (wN.has(a) || xF.equals(a)) ? 1 : null;
        if (obj != null) {
            str2 = a2;
        } else {
            str2 = a;
        }
        at S = wJ.S(str2, bmVar.mcb);
        v.d("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId));
        if (S.field_msgId != 0) {
            if (S.field_createTime + 604800000 < aw.h(a, (long) bmVar.hNS)) {
                v.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId));
                aw.L(S.field_msgId);
                S.x(0);
            }
        }
        if (S.field_msgId == 0) {
            S = new at();
            S.y(bmVar.mcb);
            S.z(aw.h(a, (long) bmVar.hNS));
        }
        if (aVar2.cnY != null) {
            S.cP(aVar2.cnY.bNx);
            v.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", S.bNx);
        }
        S.setType(l.h(aVar2.type, aVar2.aXx, aVar2.cov, aVar2.cow, aVar2.cpT));
        str2 = (S.bvZ() || S.bwa()) ? aVar2.content : str;
        S.setContent(str2);
        if (S.bvZ()) {
            S.cM(aVar2.bNm);
        }
        if (bmVar.mbX == 2 && S.field_msgId == 0) {
            Object obj2;
            switch (S.field_type) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 == null) {
                final boolean z = aVar2.type == 2;
                byte[] a3 = m.a(bmVar.mbY);
                if (q.dqp) {
                    v.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a3 = null;
                }
                if (!be.bl(a3)) {
                    if (aVar2.type == 33) {
                        str2 = n.GH().a(a3, CompressFormat.PNG);
                    } else {
                        str2 = d(a3, z);
                    }
                    if (be.kS(str2)) {
                        v.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", S.field_content);
                    }
                    if (!be.kS(str2)) {
                        S.cI(str2);
                        v.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path" + str2);
                    }
                } else if (!be.kS(aVar2.coj) && !be.kS(aVar2.coq)) {
                    final long j = S.field_msgSvrId;
                    str2 = aVar2.coq;
                    final String str3 = aVar2.coj;
                    final int i2 = aVar2.cok;
                    v.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", Long.valueOf(S.field_msgSvrId), str2, Integer.valueOf(i2), str3, a, Boolean.valueOf(z));
                    final long Ni = be.Ni();
                    final int i3 = aVar2 != null ? aVar2.type : 0;
                    final String l = n.GH().l(be.Ni(), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                    h hVar = new h();
                    hVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", S.field_createTime, a, String.valueOf(j));
                    hVar.field_fullpath = l;
                    hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    hVar.field_totalLen = i2;
                    hVar.field_aesKey = str2;
                    hVar.field_fileId = str3;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.cEB;
                    hVar.cFR = new com.tencent.mm.modelcdntran.h.a(this) {
                        final /* synthetic */ j lAy;

                        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                            if (i != 0) {
                                v.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", Long.valueOf(S.field_msgSvrId), Integer.valueOf(i), str3);
                                g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Ni), Long.valueOf(be.Ni()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(i2), SQLiteDatabase.KeyEmpty);
                                return i;
                            } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                                return 0;
                            } else {
                                g gVar;
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                    v.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", Long.valueOf(S.field_msgSvrId), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), str3);
                                } else {
                                    String a;
                                    long j;
                                    byte[] c = e.c(l, 0, -1);
                                    if (i3 == 33) {
                                        a = n.GH().a(c, CompressFormat.PNG);
                                    } else {
                                        a = j.d(c, z);
                                    }
                                    if (!be.kS(a)) {
                                        S.cI(a);
                                        ak.yW();
                                        c.wJ().b(S.field_msgSvrId, S);
                                    }
                                    v.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", Long.valueOf(j), a, str3, a);
                                    g.iuh.a(198, 16, (long) i2, false);
                                    g.iuh.a(198, 17, 1, false);
                                    gVar = g.iuh;
                                    if (com.tencent.mm.model.m.dE(a)) {
                                        j = 19;
                                    } else {
                                        j = 18;
                                    }
                                    gVar.a(198, j, 1, false);
                                }
                                gVar = g.iuh;
                                Object[] objArr = new Object[16];
                                objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(Ni);
                                objArr[3] = Long.valueOf(be.Ni());
                                objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext()));
                                objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                objArr[6] = Integer.valueOf(i2);
                                objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? SQLiteDatabase.KeyEmpty : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                objArr[8] = SQLiteDatabase.KeyEmpty;
                                objArr[9] = SQLiteDatabase.KeyEmpty;
                                objArr[10] = SQLiteDatabase.KeyEmpty;
                                objArr[11] = SQLiteDatabase.KeyEmpty;
                                objArr[12] = SQLiteDatabase.KeyEmpty;
                                objArr[13] = SQLiteDatabase.KeyEmpty;
                                objArr[14] = SQLiteDatabase.KeyEmpty;
                                objArr[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? SQLiteDatabase.KeyEmpty : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                                gVar.h(10421, objArr);
                                n.GH().Ls();
                                return 0;
                            }
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] i(String str, byte[] bArr) {
                            return null;
                        }
                    };
                    com.tencent.mm.modelcdntran.g.DZ().a(hVar, -1);
                } else if (!be.kS(aVar2.thumburl)) {
                    v.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
                    str2 = com.tencent.mm.a.g.m((be.Ni()).getBytes());
                    xF = n.GH().iU(str2);
                    n.GH();
                    str2 = com.tencent.mm.ae.f.iV(str2);
                    com.tencent.mm.ae.a.a GL = n.GL();
                    String str4 = aVar2.thumburl;
                    com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
                    aVar3.cPu = xF;
                    aVar3.cPs = true;
                    GL.a(str4, null, aVar3.GU());
                    S.cI(str2);
                    v.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + xF);
                }
                if (obj == null) {
                    S.di(1);
                    S.cH(a2);
                    i = bmVar.eeO;
                    atVar = S;
                } else {
                    S.di(0);
                    S.cH(a);
                    if (bmVar.eeO <= 3) {
                        i = bmVar.eeO;
                        atVar = S;
                    } else {
                        i = 3;
                        atVar = S;
                    }
                }
                atVar.dh(i);
                if (aVar2.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN && aVar2.aXx == 1) {
                    if (!TextUtils.isEmpty(aVar2.cpN) || TextUtils.isEmpty(aVar2.cpO) || aVar2.cpP <= 0) {
                        v.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
                    } else {
                        v.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                        acVar = new ac();
                        acVar.aXB = new com.tencent.mm.e.a.ac.a();
                        acVar.aXB.aXD = aVar2.cpO;
                        acVar.aXB.aXC = aVar2.cpN;
                        acVar.aXB.aXE = aVar2.cpP;
                        com.tencent.mm.sdk.c.a.nhr.z(acVar);
                    }
                }
                if (aVar2.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
                    try {
                        if (!be.bP(aVar2.cpZ)) {
                            for (String str22 : aVar2.cpZ) {
                                split = str22.split(",");
                                if (split != null && split.length > 0) {
                                    str22 = split[0];
                                    if (!be.kS(str22) && str22.equals(k.xF())) {
                                        S.dr(S.field_flag | 8);
                                        v.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", e.getMessage());
                    }
                }
                S.cN(bmVar.mbZ);
                fP = aw.fP(bmVar.mbZ);
                if (fP != null) {
                    S.cO(fP.ctv);
                    S.cL(fP.ctu);
                }
                aw.a(S, aVar);
                if (S.field_msgId != 0) {
                    S.x(aw.e(S));
                    acVar = new r();
                    acVar.aXc.aXd = S;
                    acVar.aXc.aXe = aVar2;
                    com.tencent.mm.sdk.c.a.nhr.z(acVar);
                    bVar = new b(S, true);
                } else {
                    wJ.b(bmVar.mcb, S);
                    bVar = new b(S, false);
                }
                if (S.field_type == 301989937 && com.tencent.mm.model.m.fh(S.field_talker)) {
                    S.x(0);
                }
                if (S.bwh() && "notifymessage".equals(S.field_talker)) {
                    q = bf.q(S.field_content, "msg");
                    if (q != null) {
                        str22 = be.ma((String) q.get(".msg.fromusername"));
                        com.tencent.mm.sdk.c.b pVar = new p();
                        pVar.aWX.aWH = str22;
                        v.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", str22);
                        com.tencent.mm.sdk.c.a.nhr.z(pVar);
                    }
                }
                if (!be.kS(aVar2.cpS) && S.field_type == 436207665) {
                    acVar = new kn();
                    acVar.blP.blQ = S.field_msgId;
                    acVar.blP.blu = str;
                    com.tencent.mm.sdk.c.a.nhr.z(acVar);
                }
                if (aVar2.type == 2000 && !be.kS(aVar2.cph) && aVar2.cpe == 5) {
                    acVar = new kq();
                    acVar.blU.blV = aVar2.cph;
                    acVar.blU.bao = S.field_msgId;
                    com.tencent.mm.sdk.c.a.nhr.z(acVar);
                }
                return bVar;
            }
        }
        if (!be.kS(aVar2.thumburl)) {
            v.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
            str22 = com.tencent.mm.a.g.m((be.Ni()).getBytes());
            xF = n.GH().iU(str22);
            n.GH();
            str22 = com.tencent.mm.ae.f.iV(str22);
            GL = n.GL();
            str4 = aVar2.thumburl;
            aVar3 = new com.tencent.mm.ae.a.a.c.a();
            aVar3.cPu = xF;
            aVar3.cPs = true;
            GL.a(str4, null, aVar3.GU());
            S.cI(str22);
            v.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + xF);
        }
        if (obj == null) {
            S.di(0);
            S.cH(a);
            if (bmVar.eeO <= 3) {
                i = 3;
                atVar = S;
            } else {
                i = bmVar.eeO;
                atVar = S;
            }
        } else {
            S.di(1);
            S.cH(a2);
            i = bmVar.eeO;
            atVar = S;
        }
        atVar.dh(i);
        if (TextUtils.isEmpty(aVar2.cpN)) {
        }
        v.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
        if (aVar2.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
            if (be.bP(aVar2.cpZ)) {
                while (r5.hasNext()) {
                    split = str22.split(",");
                    str22 = split[0];
                    S.dr(S.field_flag | 8);
                    v.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                }
            }
        }
        S.cN(bmVar.mbZ);
        fP = aw.fP(bmVar.mbZ);
        if (fP != null) {
            S.cO(fP.ctv);
            S.cL(fP.ctu);
        }
        aw.a(S, aVar);
        if (S.field_msgId != 0) {
            wJ.b(bmVar.mcb, S);
            bVar = new b(S, false);
        } else {
            S.x(aw.e(S));
            acVar = new r();
            acVar.aXc.aXd = S;
            acVar.aXc.aXe = aVar2;
            com.tencent.mm.sdk.c.a.nhr.z(acVar);
            bVar = new b(S, true);
        }
        S.x(0);
        q = bf.q(S.field_content, "msg");
        if (q != null) {
            str22 = be.ma((String) q.get(".msg.fromusername"));
            com.tencent.mm.sdk.c.b pVar2 = new p();
            pVar2.aWX.aWH = str22;
            v.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", str22);
            com.tencent.mm.sdk.c.a.nhr.z(pVar2);
        }
        acVar = new kn();
        acVar.blP.blQ = S.field_msgId;
        acVar.blP.blu = str;
        com.tencent.mm.sdk.c.a.nhr.z(acVar);
        acVar = new kq();
        acVar.blU.blV = aVar2.cph;
        acVar.blU.bao = S.field_msgId;
        com.tencent.mm.sdk.c.a.nhr.z(acVar);
        return bVar;
    }

    public final void d(at atVar) {
        v.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + atVar.field_imgPath);
        com.tencent.mm.sdk.c.b qeVar = new qe();
        qeVar.brt.path = atVar.field_imgPath;
        com.tencent.mm.sdk.c.a.nhr.z(qeVar);
    }

    public final boolean a(final a aVar, String str, long j, String str2, final String str3, int i, String str4) {
        String l = n.GH().l("Note_" + str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        if (FileOp.aR(l)) {
            return false;
        }
        this.lAv = aVar;
        h hVar = new h();
        hVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", j, str4, str);
        hVar.field_fullpath = l;
        hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        hVar.field_totalLen = i;
        hVar.field_aesKey = str2;
        hVar.field_fileId = str3;
        hVar.field_priority = com.tencent.mm.modelcdntran.b.cEB;
        hVar.cFR = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ j lAy;

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                v.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", str, str3);
                if (i != 0) {
                    v.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", Integer.valueOf(i), str3);
                    return i;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                    return 0;
                } else {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        v.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), str3);
                    } else {
                        v.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", str3);
                    }
                    n.GH().Ls();
                    if (aVar != null) {
                        aVar.bnt();
                    }
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] i(String str, byte[] bArr) {
                return null;
            }
        };
        com.tencent.mm.modelcdntran.g.DZ().a(hVar, -1);
        return true;
    }
}
