package com.tencent.mm.plugin.backup.g;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public final class o implements l {
    private static boolean pe(String str) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        return bf.q(str, "msg") != null;
    }

    public final int a(dx dxVar, boolean z, at atVar, String str, LinkedList<g> linkedList) {
        int i;
        if (be.kS(atVar.field_content)) {
            i = 0;
        } else {
            i = atVar.field_content.getBytes().length;
        }
        String trim = ag.Mv(atVar.field_content).nva.trim();
        if (!pe(trim)) {
            trim = atVar.field_content;
            if (!pe(trim)) {
                trim = j.a(atVar, dxVar);
                if (atVar.field_isSend != 1 && a.dE(atVar.field_talker)) {
                    trim = atVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !pe(trim)) {
            v.d("MicroMsg.MMBakEmoji", "emoji error" + trim);
            return -1;
        }
        arf com_tencent_mm_protocal_c_arf = new arf();
        com_tencent_mm_protocal_c_arf.JF(be.ah(trim, SQLiteDatabase.KeyEmpty));
        dxVar.mbW = com_tencent_mm_protocal_c_arf;
        c NF = b.Vd().We().NF(atVar.field_imgPath);
        if (NF != null && NF.bxG()) {
            return i;
        }
        int i2;
        int a;
        if (NF == null) {
            i2 = i;
        } else if (TextUtils.isEmpty(NF.field_groupId)) {
            trim = b.Vd().wY() + NF.EB() + "_thumb";
            if (e.aQ(trim) < 0) {
                return -1;
            }
            i2 = i + g.a(trim, dxVar, linkedList, 4, z, "_thumb", false, null);
        } else {
            trim = b.Vd().wY() + NF.field_groupId + File.separator + NF.EB() + "_cover";
            if (e.aQ(trim) < 0) {
                return -1;
            }
            i2 = i + g.a(trim, dxVar, linkedList, 4, z, "_thumb", false, null);
        }
        if (NF != null) {
            if (TextUtils.isEmpty(NF.field_groupId) && NF.bxE()) {
                a = g.a(b.Vd().wY() + NF.EB(), dxVar, linkedList, 5, z, false, null) + i2;
                return a;
            }
            boolean exists = (NF.field_catalog == c.nwN || NF.field_catalog == c.nwQ || NF.field_catalog == c.nwP) ? true : new File(NF.iay + NF.field_groupId + File.separator + NF.EB()).exists();
            if (exists) {
                a = g.a(b.Vd().wY() + NF.field_groupId + File.separator + NF.EB(), dxVar, linkedList, 5, z, false, null) + i2;
                return a;
            }
        }
        a = i2;
        return a;
    }

    public final int a(String str, dx dxVar, at atVar) {
        boolean z = true;
        atVar.setContent(dxVar.mbW.mQy);
        String str2 = dxVar.mbU.mQy;
        String str3 = ((String) b.Vd().vf().get(2, null)).equals(str2) ? dxVar.mbV.mQy : str2;
        String str4 = dxVar.mbW.mQy;
        Map q = bf.q(str4, "msg");
        ai bn = j.a.bmr().bn(str4, str3);
        if (bn == null) {
            v.w("MicroMsg.MMBakEmoji", "EmojiMsgInfo is null");
            return -1;
        }
        c rg = j.a.bmr().rg(bn.aZy);
        if (rg == null) {
            v.w("MicroMsg.MMBakEmoji", "EmojiInfo is null");
            return -1;
        }
        if (q.get(".msg.emoji.$androidmd5") == null) {
            str3 = j.pl(bn.aZy);
            if (!be.kS(str3)) {
                bn.aZy = str3;
                v.d("MicroMsg.MMBakEmoji", "convert ip to android md5 %s", str3);
            }
        }
        str3 = (String) q.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(str3)) {
            bn.aZD = str3;
        }
        atVar.setType(47);
        atVar.cI(bn.aZy);
        str4 = bn.dhC;
        if (rg == null || rg.bnk() || rg.bxH()) {
            z = false;
        }
        atVar.setContent(ag.a(str4, 0, z, bn.aZy, false, SQLiteDatabase.KeyEmpty));
        if (rg == null || !rg.bxE()) {
            str4 = b.Vd().wY();
            if (TextUtils.isEmpty(str3)) {
                g.b(dxVar, 4, str4 + bn.aZy + "_thumb");
                g.b(dxVar, 5, str4 + bn.aZy);
            } else {
                File file = new File(str4 + str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                g.b(dxVar, 4, str4 + str3 + File.separator + bn.aZy + "_cover");
                g.b(dxVar, 5, str4 + str3 + File.separator + bn.aZy);
            }
            com.tencent.mm.sdk.h.c cVar = new c(str4);
            cVar.field_md5 = bn.aZy;
            cVar.field_svrid = bn.id;
            cVar.field_catalog = c.nwM;
            cVar.field_type = bn.nvg;
            cVar.field_size = bn.nvh;
            cVar.field_state = c.nwY;
            if (!TextUtils.isEmpty(str3)) {
                cVar.field_groupId = str3;
            }
            b.Vd().We().a(cVar);
        }
        v.d("MicroMsg.MMBakEmoji", "id " + a.e(atVar));
        return 0;
    }
}
