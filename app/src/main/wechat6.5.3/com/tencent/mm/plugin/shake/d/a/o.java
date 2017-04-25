package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class o extends f<n> {
    public static final String[] btd = new String[0];
    public static final String[] cic = new String[]{f.a(n.chq, "shaketvhistory")};
    public d cie;

    public o(d dVar) {
        super(dVar, n.chq, "shaketvhistory", cic);
        this.cie = dVar;
    }

    public final Cursor aOu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM shaketvhistory ORDER BY createtime").append(" DESC");
        return this.cie.rawQuery(stringBuilder.toString(), null);
    }
}
