package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.fb;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    public static String a(b bVar) {
        ez ezVar = new ez();
        ezVar.bdQ.type = 2;
        ezVar.bdQ.bdS = bVar.bdE;
        a.nhr.z(ezVar);
        return ezVar.bdR.path;
    }

    public static c cs(long j) {
        fb fbVar = new fb();
        fbVar.bek.aZa = j;
        a.nhr.z(fbVar);
        if (fbVar.bel.ret == 0) {
            v.w("MicroMsg.RecordFavLogic", "can not fetch FavItem");
            return null;
        }
        v.d("MicroMsg.RecordFavLogic", "fetch favitem localId %s, itemStatus %d", new Object[]{Long.valueOf(fbVar.bek.aZa), Integer.valueOf(fbVar.bel.field_itemStatus)});
        c cVar = new c();
        cVar.field_localId = fbVar.bek.aZa;
        cVar.field_id = fbVar.bel.field_id;
        cVar.field_fromUser = fbVar.bel.field_fromUser;
        cVar.field_toUser = fbVar.bel.field_toUser;
        cVar.field_favProto = fbVar.bel.field_favProto;
        cVar.field_realChatName = fbVar.bel.field_realChatName;
        cVar.field_type = fbVar.bel.field_type;
        cVar.field_itemStatus = fbVar.bel.field_itemStatus;
        return cVar;
    }
}
