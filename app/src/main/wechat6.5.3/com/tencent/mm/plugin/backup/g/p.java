package com.tencent.mm.plugin.backup.g;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class p implements l {
    public final int a(dx dxVar, boolean z, at atVar, String str, LinkedList<g> linkedList) {
        int length;
        String trim;
        switch (atVar.field_type) {
            case 1048625:
                length = be.kS(atVar.field_content) ? 0 : atVar.field_content.getBytes().length;
                if (atVar.field_content == null) {
                    return -1;
                }
                trim = ag.Mv(atVar.field_content).nva.trim();
                if (!g.pe(trim)) {
                    trim = atVar.field_content;
                    if (!g.pe(trim)) {
                        v.e("MicroMsg.MMBakItemAppMsg", "get xml error " + trim);
                        return 0;
                    }
                }
                if (!be.kS(trim)) {
                    arf com_tencent_mm_protocal_c_arf = new arf();
                    com_tencent_mm_protocal_c_arf.JF(be.ah(trim, SQLiteDatabase.KeyEmpty));
                    dxVar.mbW = com_tencent_mm_protocal_c_arf;
                    a dV = a.dV(trim);
                    String wY = b.Vd().wY();
                    trim = b.Vd().GH().w(atVar.field_imgPath, true);
                    String str2 = wY + dV.cod;
                    if (e.aQ(trim) <= 0) {
                        return -1;
                    }
                    length = (g.a(trim, dxVar, linkedList, 6, z, "_thumb", false, null) + length) + g.a(str2, dxVar, linkedList, 5, z, false, null);
                }
                return length;
            case 285212721:
            case 486539313:
                length = be.kS(atVar.field_content) ? 0 : atVar.field_content.getBytes().length;
                if (z) {
                    return length;
                }
                trim = a.oS(atVar.field_content);
                if (be.kS(trim)) {
                    return 0;
                }
                arf com_tencent_mm_protocal_c_arf2 = new arf();
                com_tencent_mm_protocal_c_arf2.JF(be.ah(trim, SQLiteDatabase.KeyEmpty));
                dxVar.mbW = com_tencent_mm_protocal_c_arf2;
                return length;
            default:
                return b(dxVar, z, atVar, str, linkedList);
        }
    }

    private static int b(dx dxVar, boolean z, at atVar, String str, LinkedList<g> linkedList) {
        int i;
        a dV;
        if (be.kS(atVar.field_content)) {
            i = 0;
        } else {
            i = atVar.field_content.getBytes().length;
        }
        String str2 = atVar.field_content;
        if (atVar.field_isSend != 1 && com.tencent.mm.plugin.backup.i.a.dE(atVar.field_talker)) {
            int indexOf = atVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = atVar.field_content.substring(indexOf + 1);
            }
        }
        str2 = be.KK(str2);
        if (str2 != null) {
            dV = a.dV(str2);
        } else {
            dV = null;
        }
        if (dV == null) {
            v.e("MicroMsg.MMBakItemAppMsg", "content is null");
            return 0;
        }
        v.d("MicroMsg.MMBakItemAppMsg", "content type " + dV.type);
        str2 = b.Vd().GH().w(atVar.field_imgPath, true);
        if (e.aR(str2)) {
            i += g.a(str2, dxVar, linkedList, 6, z, "_thumb", false, null);
        } else if (dV.type == 2) {
            return -1;
        }
        b Gu;
        switch (dV.type) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
                return i;
            case 2:
                if (be.kS(dV.aXa)) {
                    return i;
                }
                Gu = b.Vd().Wf().Gu(dV.aXa);
                if ((Gu == null || !Gu.bnj()) && (atVar.field_isSend != 1 || Gu == null || !Gu.field_isUpload)) {
                    return i;
                }
                str2 = Gu.field_fileFullPath;
                if (!e.aR(str2)) {
                    return i;
                }
                v.d("MicroMsg.MMBakItemAppMsg", "image " + str2);
                return i + g.a(str2, dxVar, linkedList, 8, z, false, null);
            case 6:
                b Gu2 = b.Vd().Wf().Gu(dV.aXa);
                if ((Gu2 == null || !Gu2.bnj()) && (atVar.field_isSend != 1 || Gu2 == null || !Gu2.field_isUpload)) {
                    return i;
                }
                v.d("MicroMsg.MMBakItemAppMsg", "full path " + Gu2.field_fileFullPath);
                if (!e.aR(Gu2.field_fileFullPath)) {
                    return i;
                }
                if (z) {
                    return i + g.a(Gu2.field_fileFullPath, dxVar, linkedList, 7, z, false, null);
                }
                if (((long) (dV.cob / 1024)) < b.UL().ebo || dV.filemd5 == null) {
                    return i + g.a(Gu2.field_fileFullPath, dxVar, linkedList, 7, z, false, null);
                }
                b.UL().ebs.add(Long.valueOf(atVar.field_msgSvrId));
                if (atVar.field_isSend == 1) {
                    str2 = atVar.field_talker;
                } else {
                    str2 = str;
                    str = atVar.field_talker;
                }
                b.UL().ebt.add(str + "_" + str2 + "_" + atVar.field_msgSvrId + "_backup");
                b.UL().ebu.add(dV.filemd5);
                g gVar = new g();
                i += g.a(Gu2.field_fileFullPath, dxVar, linkedList, 7, z, true, gVar);
                b.UL().ebr.put(Long.valueOf(atVar.field_msgSvrId), gVar);
                return i;
            case 7:
                Gu = b.Vd().Wf().Gu(dV.aXa);
                if ((Gu == null || !Gu.bnj()) && (atVar.field_isSend != 1 || Gu == null || !Gu.field_isUpload)) {
                    return i;
                }
                v.d("MicroMsg.MMBakItemAppMsg", "full path " + Gu.field_fileFullPath);
                if (e.aR(Gu.field_fileFullPath)) {
                    return i + g.a(Gu.field_fileFullPath, dxVar, linkedList, 7, z, false, null);
                }
                return i;
            case 19:
            case 24:
                com.tencent.mm.sdk.c.b khVar = new kh();
                khVar.blo.blq = dV.coC;
                khVar.blo.aYG = atVar.field_msgId;
                com.tencent.mm.sdk.c.a.nhr.z(khVar);
                v.i("MicroMsg.MMBakItemAppMsg", "pathList:%s", khVar.blp.blr);
                String[] split = khVar.blp.blr.split(":");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (e.aR(split[i2])) {
                        v.i("MicroMsg.MMBakItemAppMsg", "record file exit:%s, index:%d", split[i2], Integer.valueOf(i2));
                        i += g.a(split[i2], dxVar, linkedList, 7, z, "_fav." + i2, false, null);
                    }
                }
                return i;
            default:
                return i;
        }
    }

    public final int a(String str, dx dxVar, at atVar) {
        String str2 = dxVar.mbU.mQy;
        String str3 = dxVar.mbW.mQy;
        if (str3 == null) {
            return 0;
        }
        atVar.setContent(str3);
        if (atVar.field_isSend != 1 && com.tencent.mm.plugin.backup.i.a.dE(str2)) {
            int fK = com.tencent.mm.plugin.backup.i.a.fK(dxVar.mbW.mQy);
            if (fK != -1) {
                str3 = (dxVar.mbW.mQy + " ").substring(fK + 2).trim();
            }
        }
        String KK = be.KK(str3);
        a dV = a.dV(KK);
        if (dV == null) {
            v.e("MicroMsg.MMBakItemAppMsg", "parse app message failed, insert failed");
            return 0;
        } else if (dV.type == 2000) {
            atVar.setType(419430449);
            com.tencent.mm.plugin.backup.i.a.e(atVar);
            return 0;
        } else if (dV.type == 19 || dV.type == 24) {
            atVar.setType(l.h(dV.type, dV.aXx, dV.cov, dV.cow, dV.cpT));
            com.tencent.mm.plugin.backup.i.a.e(atVar);
            com.tencent.mm.sdk.c.b khVar = new kh();
            khVar.blo.blq = dV.coC;
            khVar.blo.aYG = atVar.field_msgId;
            com.tencent.mm.sdk.c.a.nhr.z(khVar);
            v.i("MicroMsg.MMBakItemAppMsg", "pathList:%s", khVar.blp.blr);
            String[] split = khVar.blp.blr.split(":");
            for (r2 = 0; r2 < split.length; r2++) {
                KK = g.a(dxVar, 7, "." + r2);
                if (!be.kS(KK)) {
                    v.i("MicroMsg.MMBakItemAppMsg", "record media exit:%s, index:%d", KK, Integer.valueOf(r2));
                    j.n(g.pc(KK), split[r2], false);
                }
            }
            return 0;
        } else {
            c fVar = new f();
            fVar.field_appId = dV.appId;
            z Vd = b.Vd();
            if (Vd.uin == 0) {
                throw new com.tencent.mm.model.b();
            }
            if (Vd.ekk.b(fVar, new String[0]) && fVar.field_appVersion < dV.bpy) {
                b.Vh().b(1, dV.appId);
            }
            atVar.setType(l.h(dV.type, dV.aXx, dV.cov, dV.cow, dV.cpT));
            byte[] d = g.d(dxVar, 6);
            if (d != null && atVar.field_msgId == 0) {
                str3 = b.Vd().GH().a(d, dV.type == 2, CompressFormat.PNG);
                v.d("MicroMsg.MMBakItemAppMsg", com.tencent.mm.compatible.util.g.sm() + " thumbData MsgInfo path:" + str3);
                if (!be.kS(str3)) {
                    atVar.cI(str3);
                    v.d("MicroMsg.MMBakItemAppMsg", "new thumbnail saved, path" + str3);
                }
            }
            str2 = g.a(dxVar, 8);
            r2 = g.c(dxVar, 8);
            if (be.kS(str2)) {
                str2 = g.a(dxVar, 7);
                r2 = g.c(dxVar, 7);
            }
            String pc = g.pc(str2);
            com.tencent.mm.plugin.backup.i.a.e(atVar);
            com.tencent.mm.q.a aVar = new com.tencent.mm.q.a();
            dV.a(aVar);
            aVar.field_msgId = atVar.field_msgId;
            z Vd2 = b.Vd();
            if (Vd2.uin == 0) {
                throw new com.tencent.mm.model.b();
            }
            Vd2.ekj.b(aVar);
            if (!be.kS(str2)) {
                au wJ = b.Vd().wJ();
                if (str.equals(dxVar.mbU.mQy)) {
                    str2 = dxVar.mbV.mQy;
                } else {
                    str2 = dxVar.mbU.mQy;
                }
                bx S = wJ.S(str2, dxVar.mcb);
                c Gu = b.Vd().Wf().Gu(dV.aXa);
                if (Gu == null) {
                    v.i("MicroMsg.MMBakItemAppMsg", "recover AppAttachInfo is null.");
                    long j = S.field_msgId;
                    a dV2 = a.dV(KK);
                    if (dV2 != null) {
                        str2 = com.tencent.mm.compatible.util.e.cge + "da_" + be.Ni();
                        if (!be.kS(dV2.coc)) {
                            str2 = str2 + "." + dV2.coc;
                        }
                        int i = dV2.sdkVer;
                        String str4 = dV2.appId;
                        String str5 = dV2.aXa;
                        int i2 = dV2.cob;
                        c bVar = new b();
                        bVar.field_fileFullPath = str2;
                        bVar.field_appId = str4;
                        bVar.field_sdkVer = (long) i;
                        bVar.field_mediaSvrId = str5;
                        bVar.field_totalLen = (long) i2;
                        bVar.field_status = 101;
                        bVar.field_isUpload = false;
                        bVar.field_createTime = be.Ni();
                        bVar.field_lastModifyTime = be.Nh();
                        bVar.field_msgInfoId = j;
                        bVar.field_netTimes = 0;
                        b.Vd().Wf().b(bVar);
                    }
                    Gu = b.Vd().Wf().Gu(dV.aXa);
                    if (!(dV.cob == 0 || r2 == 0)) {
                        if (r2 >= dV.cob) {
                            Gu.field_status = 199;
                        } else if (atVar.field_isSend == 1) {
                            Gu.field_status = 105;
                        } else {
                            Gu.field_status = 102;
                        }
                    }
                }
                long j2 = (long) r2;
                Gu.field_offset = j2;
                Gu.field_totalLen = j2;
                j.n(pc, Gu.field_fileFullPath, false);
                b.Vd().Wf().a(Gu, new String[0]);
            }
            return 0;
        }
    }
}
