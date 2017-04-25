package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.a.iz;
import com.tencent.mm.plugin.record.a.i.a;
import com.tencent.mm.sdk.platformtools.v;

public final class e implements a {
    public final void a(int i, g gVar) {
        if (gVar != null) {
            v.d("MircoMsg.RecordInfoStorageProxy", "notify CdnChanged dataId: %s, status: %d", new Object[]{gVar.field_dataId, Integer.valueOf(gVar.field_status)});
            iz izVar = new iz();
            izVar.bjq.field_dataId = gVar.field_dataId;
            izVar.bjq.field_status = gVar.field_status;
            izVar.bjq.field_offset = gVar.field_offset;
            izVar.bjq.field_totalLen = gVar.field_totalLen;
            izVar.bjq.field_localId = gVar.field_localId;
            izVar.bjq.field_path = gVar.field_path;
            com.tencent.mm.sdk.c.a.nhr.z(izVar);
        }
    }
}
