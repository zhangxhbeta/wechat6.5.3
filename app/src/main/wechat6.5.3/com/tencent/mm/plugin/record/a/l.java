package com.tencent.mm.plugin.record.a;

import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;

public final class l extends f<k> {
    public static final String[] cic = new String[]{f.a(k.chq, "RecordMessageInfo")};
    d cie;

    public l(d dVar) {
        super(dVar, k.chq, "RecordMessageInfo", null);
        this.cie = dVar;
    }

    public final void oL(int i) {
        int delete = this.cie.delete("RecordMessageInfo", "localId=?", new String[]{String.valueOf(i)});
        v.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", new Object[]{Integer.valueOf(i), Integer.valueOf(delete)});
    }
}
