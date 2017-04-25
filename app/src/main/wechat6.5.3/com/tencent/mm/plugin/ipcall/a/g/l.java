package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class l extends f<k> {
    public static final String[] cic = new String[]{f.a(k.chq, "IPCallRecord")};
    public static final String[] gIK = new String[]{"*", "rowid"};
    public d cie;

    public l(d dVar) {
        super(dVar, k.chq, "IPCallRecord", null);
        this.cie = dVar;
    }

    public final Cursor uO(String str) {
        return this.cie.query("IPCallRecord", gIK, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
    }

    public final Cursor cc(long j) {
        return this.cie.query("IPCallRecord", gIK, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc");
    }

    public final void a(k kVar) {
        if (kVar != null) {
            a(kVar.nmb, kVar);
        }
    }
}
