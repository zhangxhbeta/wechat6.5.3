package com.tencent.mm.as;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class q implements d {
    public final b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String str;
        ak.yW();
        String str2 = (String) c.vf().get(2, SQLiteDatabase.KeyEmpty);
        String a = m.a(bmVar.mbV);
        String a2 = m.a(bmVar.mbU);
        ak.yW();
        boolean z = c.wN().has(a2) || str2.equals(a2);
        v.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", a2, a, str2, Boolean.valueOf(z));
        ak.yW();
        au wJ = c.wJ();
        if (str2.equals(a2)) {
            str = a;
        } else {
            str = a2;
        }
        bx S = wJ.S(str, bmVar.mcb);
        v.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId), Integer.valueOf(S.field_flag), Long.valueOf(S.field_msgSeq), aVar);
        if (S.field_msgId != 0 && S.field_createTime + 604800000 < aw.h(a2, (long) bmVar.hNS)) {
            v.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(bmVar.mcb), Long.valueOf(S.field_msgId));
            aw.L(S.field_msgId);
            S.x(0);
        }
        if (S.field_msgId != 0) {
            v.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", Long.valueOf(bmVar.mcb));
            return null;
        }
        String a3 = m.a(bmVar.mbW);
        n nVar = new n();
        if (z) {
            a2 = a;
        }
        nVar.ble = a2;
        nVar.dhH = (long) bmVar.hNS;
        nVar.bmL = bmVar.mcb;
        nVar.dhQ = bmVar.mbW.mQy;
        v.d("MicroMsg.VideoMsgExtension", "parseVideoMsgXML content:" + a3);
        Map q = bf.q(a3, "msg");
        if (q == null) {
            g.iuh.a(111, 216, 1, false);
            return null;
        }
        bx atVar = new at();
        atVar.cN(bmVar.mbZ);
        atVar.cO(aw.fQ(bmVar.mbZ));
        try {
            nVar.cyu = be.getInt((String) q.get(".msg.videomsg.$length"), 0);
            nVar.dhK = be.getInt((String) q.get(".msg.videomsg.$playlength"), 0);
            v.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", Integer.valueOf(nVar.cyu), Integer.valueOf(nVar.dhK));
            nVar.dhC = (String) q.get(".msg.videomsg.$fromusername");
            if (str2.equals(nVar.Le())) {
                nVar.dhC = a;
            }
            nVar.bnY = (String) q.get(".msg.statextstr");
            str2 = (String) q.get(".msg.videomsg.$cdnthumbaeskey");
            final String str3 = (String) q.get(".msg.videomsg.$cdnthumburl");
            final int i = be.getInt((String) q.get(".msg.videomsg.$cdnthumblength"), 0);
            int i2 = be.getInt((String) q.get(".msg.videomsg.$type"), 0);
            v.d("MicroMsg.VideoMsgExtension", "video msg exportType :" + i2);
            nVar.dhO = i2 == 44 ? 1 : 0;
            if (62 == bmVar.gll) {
                nVar.dhR = 3;
            } else if (i2 > 0) {
                nVar.dhR = 2;
            } else {
                nVar.dhR = 1;
            }
            a = be.ah((String) q.get(".msg.streamvideo.streamvideourl"), SQLiteDatabase.KeyEmpty);
            int i3 = be.getInt((String) q.get(".msg.streamvideo.streamvideototaltime"), 0);
            String ah = be.ah((String) q.get(".msg.streamvideo.streamvideotitle"), SQLiteDatabase.KeyEmpty);
            String ah2 = be.ah((String) q.get(".msg.streamvideo.streamvideowording"), SQLiteDatabase.KeyEmpty);
            String ah3 = be.ah((String) q.get(".msg.streamvideo.streamvideoweburl"), SQLiteDatabase.KeyEmpty);
            String ah4 = be.ah((String) q.get(".msg.streamvideo.streamvideoaduxinfo"), SQLiteDatabase.KeyEmpty);
            str = be.ah((String) q.get(".msg.streamvideo.streamvideopublishid"), SQLiteDatabase.KeyEmpty);
            if (nVar.dhT == null) {
                nVar.dhT = new ayk();
            }
            nVar.dhT.cqi = ah;
            nVar.dhT.mtD = i3;
            nVar.dhT.cqg = a;
            nVar.dhT.cqj = ah2;
            nVar.dhT.cqk = ah3;
            nVar.dhT.cqm = ah4;
            nVar.dhT.cqn = str;
            a = nVar.Le();
            ak.yW();
            if (a.equals((String) c.vf().get(2, SQLiteDatabase.KeyEmpty))) {
                return null;
            }
            str = (String) q.get(".msg.commenturl");
            q = bf.q(a3, "msgoperation");
            if (q != null) {
                atVar.cP((String) q.get(".msgoperation.expinfo.expidstr"));
                atVar.dw(be.getInt((String) q.get(".msgoperation.sightmsg.downloadcontroltype"), 0));
                v.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", atVar.bNx, Integer.valueOf(atVar.bNy));
            }
            a2 = o.lb(nVar.Le());
            nVar.aST = a2;
            atVar.y(nVar.bmL);
            atVar.cI(nVar.getFileName());
            atVar.z(aw.h(nVar.Ld(), nVar.dhH));
            atVar.cH(nVar.Ld());
            atVar.dh(bmVar.eeO);
            atVar.di(z ? 1 : 0);
            if (bmVar.gll == 62) {
                atVar.setType(62);
            } else {
                atVar.setType(43);
            }
            atVar.setContent(l.b(nVar.Le(), 0, false));
            atVar.cM(str);
            atVar.cN(bmVar.mbZ);
            aw.a((at) atVar, aVar);
            long e = aw.e(atVar);
            if (e <= 0) {
                g.iuh.a(111, 215, 1, false);
                v.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", Long.valueOf(e), Long.valueOf(nVar.bmL));
                return null;
            }
            nVar.dhL = (int) e;
            nVar.dhI = be.Nh();
            nVar.dhM = 0;
            nVar.status = MMGIFException.D_GIF_ERR_NOT_READABLE;
            v.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + nVar.getFileName() + "] size:" + nVar.cyu + " svrid:" + nVar.bmL + " timelen:" + nVar.dhK + " user:" + nVar.Ld() + " human:" + nVar.Le());
            if (k.KV().a(nVar)) {
                k.KV();
                a3 = o.ld(a2);
                byte[] a4 = m.a(bmVar.mbY);
                v.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", Integer.valueOf(be.bm(a4)));
                if (com.tencent.mm.platformtools.q.dqp) {
                    v.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a4 = null;
                }
                if (be.bl(a4)) {
                    final long j = nVar.bmL;
                    v.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), nVar.Ld(), str3, a3);
                    final long Ni = be.Ni();
                    ah = a3 + ".tmp";
                    h hVar = new h();
                    hVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downvideothumb", nVar.dhH, nVar.Ld(), String.valueOf(j));
                    hVar.field_fullpath = ah;
                    hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    hVar.field_totalLen = i;
                    hVar.field_aesKey = str2;
                    hVar.field_fileId = str3;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.cEB;
                    final n nVar2 = nVar;
                    hVar.cFR = new h.a(this) {
                        final /* synthetic */ q dim;

                        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                            if (i != 0) {
                                v.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), nVar2.Ld(), str3, a3);
                                g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Ni), Long.valueOf(be.Ni()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(i), SQLiteDatabase.KeyEmpty);
                                return i;
                            } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                                return 0;
                            } else {
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                    v.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(j), nVar2.Ld(), str3, a3);
                                } else {
                                    new File(ah).renameTo(new File(a3));
                                    v.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), nVar2.Ld(), str3, a3);
                                    if (nVar2.dhR == 3) {
                                        g.iuh.a(198, 6, (long) i, false);
                                        g.iuh.a(198, 7, 1, false);
                                        g.iuh.a(198, com.tencent.mm.model.m.dE(nVar2.Ld()) ? 9 : 8, 1, false);
                                    } else {
                                        g.iuh.a(198, 11, (long) i, false);
                                        g.iuh.a(198, 12, 1, false);
                                        g.iuh.a(198, com.tencent.mm.model.m.dE(nVar2.Ld()) ? 14 : 13, 1, false);
                                    }
                                }
                                g gVar = g.iuh;
                                Object[] objArr = new Object[16];
                                objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(Ni);
                                objArr[3] = Long.valueOf(be.Ni());
                                objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.aO(aa.getContext()));
                                objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                objArr[6] = Integer.valueOf(i);
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
                                k.KV().b(nVar2);
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
                } else {
                    o.a(a3, 0, a4);
                }
                if (atVar.bwo()) {
                    Object obj;
                    com.tencent.mm.modelcontrol.c.Eg();
                    if (atVar.bNy == 1) {
                        obj = 1;
                    } else if (atVar.bNy == 2) {
                        obj = null;
                    } else if (com.tencent.mm.modelcontrol.c.i(atVar)) {
                        str2 = j.sU().getValue("C2CSightNotAutoDownloadTimeRange");
                        v.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: " + str2);
                        if (com.tencent.mm.modelcontrol.b.iu(str2)) {
                            v.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
                            obj = null;
                        } else {
                            str2 = atVar.field_talker;
                            v.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: " + str2);
                            int i4 = be.getInt(j.sU().getValue("SIGHTSessionAutoLoadNetwork"), 1);
                            if (i4 == 3) {
                                v.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId));
                                obj = null;
                            } else if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                                v.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), atVar.field_imgPath);
                                ak.yW();
                                ab LX = c.wH().LX(str2);
                                if (LX == null || ((int) LX.chr) <= 0 || !((str2.endsWith("@chatroom") && LX.bCh == 0) || LX.tM())) {
                                    obj = 1;
                                } else {
                                    v.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
                                    obj = null;
                                }
                            } else if (com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
                                v.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), atVar.field_imgPath);
                                obj = null;
                            } else {
                                ak.yW();
                                ab LX2 = c.wH().LX(atVar.field_talker);
                                if (com.tencent.mm.model.m.dE(atVar.field_talker)) {
                                    if (LX2.bCh == 0) {
                                        v.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), atVar.field_imgPath);
                                        obj = null;
                                    } else if ((com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext()) || com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext())) && i4 == 1) {
                                        v.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), atVar.field_imgPath);
                                        obj = 1;
                                    } else {
                                        v.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
                                        obj = null;
                                    }
                                } else if (LX2.tM()) {
                                    v.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), atVar.field_imgPath);
                                    obj = null;
                                } else if ((com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext()) || com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext())) && i4 == 1) {
                                    v.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), atVar.field_imgPath);
                                    obj = 1;
                                } else {
                                    v.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
                                    obj = null;
                                }
                            }
                        }
                    } else {
                        v.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
                        obj = null;
                    }
                    if (obj != null) {
                        p.ll(atVar.field_imgPath);
                        com.tencent.mm.modelcdntran.g.DZ().cFg.add("video_" + atVar.field_msgId);
                    }
                }
                return new b(atVar, true);
            }
            v.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + nVar.getFileName());
            return null;
        } catch (Throwable e2) {
            g.iuh.a(111, 216, 1, false);
            v.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
            v.e("MicroMsg.VideoMsgExtension", "exception:%s", be.e(e2));
            return null;
        }
    }

    public final void d(at atVar) {
        if (atVar != null) {
            String str = atVar.field_imgPath;
            if (!be.kS(str) && k.KV().la(str)) {
                try {
                    k.KV();
                    new File(o.ld(str)).delete();
                    k.KV();
                    new File(o.lc(str)).delete();
                } catch (Exception e) {
                    v.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.sm() + " file:" + str + " msg:" + e.getMessage());
                }
            }
        }
    }
}
