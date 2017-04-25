package com.tencent.mm.plugin.scanner.history.a;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class b extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "ScanHistoryItem")};
    public d cie;

    public b(d dVar) {
        super(dVar, a.chq, "ScanHistoryItem", null);
        this.cie = dVar;
    }

    public final Cursor Kp() {
        return this.cie.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    }
}
