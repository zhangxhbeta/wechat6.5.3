package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.e.a.it;
import com.tencent.mm.e.a.iu;
import com.tencent.mm.e.a.iz;
import com.tencent.mm.plugin.favorite.b.b.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.v;

public final class k implements a, g.a {
    private int fKJ;

    public final void b(a aVar) {
        if (aVar != null) {
            v.d("MircoMsg.FavItemInfoStorageProxy", "notify CdnChanged dataId: %s, status: %d", new Object[]{aVar.field_dataId, Integer.valueOf(aVar.field_status)});
            i bB = h.alu().bB(aVar.field_favLocalId);
            if (bB == null || bB.field_type != 18) {
                it itVar = new it();
                itVar.bjj.field_favLocalId = aVar.field_favLocalId;
                itVar.bjj.field_dataId = aVar.field_dataId;
                itVar.bjj.field_status = aVar.field_status;
                itVar.bjj.field_offset = aVar.field_offset;
                itVar.bjj.field_totalLen = aVar.field_totalLen;
                com.tencent.mm.sdk.c.a.nhr.z(itVar);
                return;
            }
            iz izVar = new iz();
            izVar.bjq.field_favLocalId = aVar.field_favLocalId;
            izVar.bjq.field_dataId = aVar.field_dataId;
            izVar.bjq.field_status = aVar.field_status;
            izVar.bjq.field_offset = aVar.field_offset;
            izVar.bjq.field_totalLen = aVar.field_totalLen;
            izVar.bjq.field_path = aVar.field_path;
            com.tencent.mm.sdk.c.a.nhr.z(izVar);
        }
    }

    public final void a(String str, i iVar) {
        v.d("MircoMsg.FavItemInfoStorageProxy", "on notify change event %s, favIDStr %s", new Object[]{str, String.valueOf(this.fKJ)});
        if (String.valueOf(this.fKJ).equals(str)) {
            iu iuVar = new iu();
            iuVar.bjk.bjl = this.fKJ;
            com.tencent.mm.sdk.c.a.nhr.z(iuVar);
        }
    }
}
