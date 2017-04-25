package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class d {
    public static dx a(at atVar, boolean z, String str, PLong pLong, LinkedList<g> linkedList, boolean z2) {
        if (atVar.field_msgSvrId == 0) {
            v.e("MicroMsg.PackBckChatMsgLogic", "msg svr Id == 0" + atVar.field_talker + " " + atVar.field_type);
            return null;
        }
        int i;
        String str2;
        String str3;
        dx dxVar;
        dx dxVar2 = new dx();
        dxVar2.mcb = atVar.field_msgSvrId;
        dxVar2.mbZ = SQLiteDatabase.KeyEmpty;
        if (atVar.field_isSend == 1) {
            i = 2;
            str2 = atVar.field_talker;
            str3 = str;
            dxVar = dxVar2;
        } else {
            String str4 = atVar.field_talker;
            if (z2) {
                i = 3;
                str2 = str;
                str3 = str4;
                dxVar = dxVar2;
            } else {
                i = 4;
                str2 = str;
                str3 = str4;
                dxVar = dxVar2;
            }
        }
        dxVar.meO = i;
        dxVar2.meT = new are();
        dxVar2.meU = 0;
        dxVar2.meV = 0;
        dxVar2.mbZ = SQLiteDatabase.KeyEmpty;
        dxVar2.mbU = new arf().JF(str3);
        dxVar2.mbV = new arf().JF(str2);
        dxVar2.efm = l.tD(atVar.field_type);
        dxVar2.meP = (int) (atVar.field_createTime / 1000);
        dxVar2.meW = (int) atVar.field_msgSeq;
        dxVar2.meX = atVar.field_createTime;
        dxVar2.meY = atVar.field_flag;
        arf com_tencent_mm_protocal_c_arf = new arf();
        com_tencent_mm_protocal_c_arf.JF(be.ah(atVar.field_content, SQLiteDatabase.KeyEmpty));
        dxVar2.mbW = com_tencent_mm_protocal_c_arf;
        l lVar = b.if(l.tD(atVar.field_type));
        if (lVar == null) {
            v.d("MicroMsg.PackBckChatMsgLogic", "unknow type ");
            return null;
        }
        i = lVar.a(dxVar2, z, atVar, str, linkedList);
        if (i < 0) {
            return null;
        }
        pLong.value += (long) i;
        pLong.value += 60;
        return dxVar2;
    }
}
