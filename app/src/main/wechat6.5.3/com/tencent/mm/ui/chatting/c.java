package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.o;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class c {
    static boolean a(Context context, a aVar) {
        if (aVar == null || context == null) {
            return false;
        }
        if (aVar.type == 3) {
            return g.l(context, 16);
        }
        if (aVar.type == 4) {
            return g.l(context, 8);
        }
        if (aVar.type == 5) {
            return g.l(context, 32);
        }
        if (aVar.type != 6) {
            return false;
        }
        Long FZ = b.a.FZ(aVar.coc);
        if (FZ != null) {
            return g.l(context, FZ.longValue());
        }
        return false;
    }

    static void a(final ChattingUI.a aVar, at atVar, String str) {
        String cf = aVar.cf(atVar.field_content, atVar.field_isSend);
        final Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", cf);
        intent.putExtra("Retr_MsgFromScene", 2);
        a dV = a.dV(cf);
        if (dV != null && 19 == dV.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (dV != null && 24 == dV.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (dV == null || 16 != dV.type) {
            intent.putExtra("Retr_Msg_Type", 2);
            cf = atVar.field_talker;
            String fz = o.fz(atVar.field_msgSvrId);
            intent.putExtra("reportSessionId", fz);
            o.b n = o.yx().n(fz, true);
            n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
            n.l("preUsername", str);
            n.l("preChatName", cf);
            if (dV != null && 33 == dV.type) {
                if (aVar.onl) {
                    n.l("fromScene", Integer.valueOf(2));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                } else {
                    n.l("fromScene", Integer.valueOf(1));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                }
                intent.putExtra("Retr_MsgFromUserName", str);
                intent.putExtra("Retr_MsgTalker", atVar.field_talker);
            }
            n.l("sendAppMsgScene", Integer.valueOf(1));
            com.tencent.mm.modelstat.o.a("adExtStr", n, atVar);
        } else {
            intent.putExtra("Retr_Msg_Type", 14);
        }
        intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
        if (dV == null || dV.type != 6) {
            aVar.startActivity(intent);
            return;
        }
        boolean z = dV.cof != 0 || dV.cob > 26214400;
        intent.putExtra("Retr_Big_File", z);
        com.tencent.mm.pluginsdk.model.app.b GD = l.GD(dV.aXa);
        if (GD != null) {
            File file = new File(GD.field_fileFullPath);
            if (file.exists() && file.length() == GD.field_totalLen) {
                aVar.startActivity(intent);
                return;
            } else if (GD.field_offset > 0 && GD.field_totalLen > GD.field_offset) {
                com.tencent.mm.ui.base.g.A(aVar.nDR.nEl, aVar.getString(2131232229), SQLiteDatabase.KeyEmpty);
                return;
            }
        }
        v.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", Integer.valueOf(dV.cob), dV.coi, be.KW(dV.cop));
        if (z) {
            intent.putExtra("Retr_Big_File", z);
            h hVar = new h();
            hVar.cFR = new h.a() {
                public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                    boolean z2 = true;
                    String str2 = "MicroMsg.AppMessageUtil";
                    String str3 = "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
                    Object[] objArr = new Object[7];
                    objArr[0] = str;
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
                    objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
                    objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo != null);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                        z2 = false;
                    }
                    objArr[5] = Boolean.valueOf(z2);
                    objArr[6] = Boolean.valueOf(z);
                    v.i(str2, str3, objArr);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck) {
                            aVar.startActivity(intent);
                        } else {
                            com.tencent.mm.ui.base.g.A(aVar.nDR.nEl, aVar.getString(2131232229), SQLiteDatabase.KeyEmpty);
                        }
                    }
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] i(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            hVar.field_mediaId = d.a("checkExist", be.Ni(), str, atVar.field_msgId);
            hVar.field_fileId = dV.coi;
            hVar.field_aesKey = dV.cop;
            hVar.field_filemd5 = dV.filemd5;
            hVar.field_fileType = com.tencent.mm.modelcdntran.b.cEC;
            hVar.field_talker = str;
            hVar.field_priority = com.tencent.mm.modelcdntran.b.cEA;
            hVar.field_svr_signature = SQLiteDatabase.KeyEmpty;
            hVar.field_onlycheckexist = true;
            v.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", Boolean.valueOf(com.tencent.mm.modelcdntran.g.DZ().b(hVar)), hVar.field_fileId, hVar.field_mediaId, be.KW(hVar.field_aesKey));
            if (!com.tencent.mm.modelcdntran.g.DZ().b(hVar)) {
                com.tencent.mm.ui.base.g.A(aVar.nDR.nEl, aVar.getString(2131232229), SQLiteDatabase.KeyEmpty);
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.g.A(aVar.nDR.nEl, aVar.getString(2131232229), SQLiteDatabase.KeyEmpty);
    }
}
