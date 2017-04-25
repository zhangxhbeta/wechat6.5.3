package com.tencent.mm.ae;

import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class g extends e {
    protected final at a(bm bmVar, String str, String str2, String str3) {
        f GH = n.GH();
        bx a = super.a(bmVar, str, str2, str3);
        if (a.field_msgId != 0) {
            return a;
        }
        long j = bmVar.mcb;
        d ah = GH.ah(j);
        if (ah.bmL == j) {
            FileOp.deleteFile(GH.l(ah.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
            FileOp.deleteFile(GH.l(ah.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
            FileOp.deleteFile(GH.l(ah.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty) + "hd");
            GH.cuX.delete("ImgInfo2", "msgSvrId=?", new String[]{String.valueOf(j)});
            if (ah.Gp()) {
                ah = GH.fC(ah.cLE);
                if (ah != null) {
                    FileOp.deleteFile(GH.l(ah.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                    FileOp.deleteFile(GH.l(ah.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                    FileOp.deleteFile(GH.l(ah.cLx, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty) + "hd");
                    GH.cuX.delete("ImgInfo2", "id=?", new String[]{ah.cLu});
                }
            }
        }
        if (bmVar.mbX != 2) {
            v.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
            return a;
        }
        byte[] bArr;
        int i;
        byte[] a2 = m.a(bmVar.mbY);
        if (q.dqp) {
            v.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
            bArr = null;
        } else {
            bArr = a2;
        }
        Map q = bf.q(a.field_content, "msg");
        long j2 = -1;
        if (!be.kS(a.field_content)) {
            Map q2;
            v.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", a.field_content);
            if (q == null) {
                com.tencent.mm.plugin.report.service.g.iuh.a(111, 190, 1, false);
            }
            if (q != null) {
                if (be.getInt((String) q.get(".msg.img.$hdlength"), 0) > 0) {
                    i = bmVar.mbX;
                    j = GH.a(bArr, bmVar.mcb, true, a.field_content, new PString(), new PInt(), new PInt());
                    q2 = bf.q(a.field_content, "msgoperation");
                    if (q2 != null) {
                        a.cP((String) q2.get(".msgoperation.expinfo.expidstr"));
                        a.dw(be.getInt((String) q2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                        v.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.bNx, Integer.valueOf(a.bNy));
                    }
                    j2 = j;
                }
            }
            j = -1;
            q2 = bf.q(a.field_content, "msgoperation");
            if (q2 != null) {
                a.cP((String) q2.get(".msgoperation.expinfo.expidstr"));
                a.dw(be.getInt((String) q2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                v.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.bNx, Integer.valueOf(a.bNy));
            }
            j2 = j;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        i = bmVar.mbX;
        j = GH.a(bArr, bmVar.mcb, false, a.field_content, pString, pInt, pInt2);
        if (j > 0) {
            a.cI(pString.value);
            a.dt(pInt.value);
            a.du(pInt2.value);
            if (j2 > 0) {
                ah = n.GH().b(Long.valueOf(j));
                ah.fy((int) j2);
                n.GH().a(Long.valueOf(j), ah);
            }
        }
        if (be.bl(bArr) && q != null) {
            String str4 = (String) q.get(".msg.img.$cdnthumbaeskey");
            final String str5 = (String) q.get(".msg.img.$cdnthumburl");
            final int i2 = be.getInt((String) q.get(".msg.img.$cdnthumblength"), 0);
            final String l = GH.l(com.tencent.mm.a.g.m(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", SQLiteDatabase.KeyEmpty);
            j = a.field_msgSvrId;
            v.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), str, str5, l);
            final long Ni = be.Ni();
            final String str6 = l + ".tmp";
            h hVar = new h();
            hVar.field_mediaId = d.a("downimgthumb", a.field_createTime, str, String.valueOf(j));
            hVar.field_fullpath = str6;
            hVar.field_fileType = b.MediaType_THUMBIMAGE;
            hVar.field_totalLen = i2;
            hVar.field_aesKey = str4;
            hVar.field_fileId = str5;
            hVar.field_priority = b.cEB;
            final String str7 = str;
            final bx bxVar = a;
            hVar.cFR = new a(this) {
                final /* synthetic */ g cMD;

                public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                    if (i != 0) {
                        v.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), str7, str5, l);
                        bxVar.dh(5);
                        ak.yW();
                        c.wJ().b(bxVar.field_msgSvrId, bxVar);
                        com.tencent.mm.plugin.report.service.g.iuh.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Ni), Long.valueOf(be.Ni()), Integer.valueOf(d.aO(aa.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(i2), SQLiteDatabase.KeyEmpty);
                        n.GH().Ls();
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                        return 0;
                    } else {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                            v.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(j), str7, str5, l);
                            bxVar.dh(5);
                            if (!be.kS(bxVar.field_talker)) {
                                ak.yW();
                                c.wJ().b(bxVar.field_msgSvrId, bxVar);
                            }
                        } else {
                            new File(str6).renameTo(new File(l));
                            bxVar.dh(6);
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            com.tencent.mm.sdk.platformtools.d.c(l, pInt, pInt2);
                            bxVar.dt(pInt.value);
                            bxVar.du(pInt2.value);
                            v.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(j), str7, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), str5, l);
                            if (!be.kS(bxVar.field_talker)) {
                                ak.yW();
                                c.wJ().b(bxVar.field_msgSvrId, bxVar);
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.a(198, 1, (long) i2, false);
                            com.tencent.mm.plugin.report.service.g.iuh.a(198, 2, 1, false);
                            com.tencent.mm.plugin.report.service.g.iuh.a(198, com.tencent.mm.model.m.dE(str7) ? 4 : 3, 1, false);
                        }
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                        Object[] objArr = new Object[16];
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            i = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                        }
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(Ni);
                        objArr[3] = Long.valueOf(be.Ni());
                        objArr[4] = Integer.valueOf(d.aO(aa.getContext()));
                        objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
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
            a.dh(4);
            com.tencent.mm.modelcdntran.g.DZ().a(hVar, -1);
        }
        return a;
    }

    public final void d(at atVar) {
        n.GH().k(atVar);
    }
}
