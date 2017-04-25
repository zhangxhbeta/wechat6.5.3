package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends f<f> {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )"};
    public static final String[] cic = new String[]{f.a(f.chq, "shakemessage")};
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public g(d dVar) {
        super(dVar, f.chq, "shakemessage", btd);
        this.cie = dVar;
    }

    public final boolean a(f fVar) {
        if (fVar == null) {
            v.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b(fVar)) {
            return false;
        } else {
            Lf(fVar.nmb);
            return true;
        }
    }

    public final int Kw() {
        Cursor rawQuery = this.cie.rawQuery("select count(*) from " + getTableName() + " where status != 1", null);
        if (rawQuery.getCount() != 1) {
            rawQuery.close();
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        if (i > 0) {
            return i;
        }
        return 0;
    }
}
