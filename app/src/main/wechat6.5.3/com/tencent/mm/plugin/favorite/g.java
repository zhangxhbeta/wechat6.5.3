package com.tencent.mm.plugin.favorite;

import com.tencent.mm.e.a.fb;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;

public final class g extends c<fb> {
    public g() {
        this.nhz = fb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fb fbVar = (fb) bVar;
        i bB = h.alu().bB(fbVar.bek.aZa);
        if (bB == null) {
            fbVar.bel.ret = 0;
        } else {
            fbVar.bel.field_id = bB.field_id;
            fbVar.bel.field_toUser = bB.field_toUser;
            fbVar.bel.field_fromUser = bB.field_fromUser;
            fbVar.bel.field_realChatName = bB.field_realChatName;
            fbVar.bel.field_itemStatus = bB.field_itemStatus;
            fbVar.bel.field_favProto = bB.field_favProto;
            fbVar.bel.field_type = bB.field_type;
        }
        return false;
    }
}
