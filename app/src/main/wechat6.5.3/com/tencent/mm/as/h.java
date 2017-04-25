package com.tencent.mm.as;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class h extends f<f> {
    public static final String[] cic = new String[]{f.a(f.chq, "SightDraftInfo")};
    public d cie;

    public h(d dVar) {
        super(dVar, f.chq, "SightDraftInfo", null);
        this.cie = dVar;
    }

    public final f gv(int i) {
        Cursor rawQuery = this.cie.rawQuery("SELECT * FROM SightDraftInfo WHERE fileNameHash = ?", new String[]{String.valueOf(i)});
        if (rawQuery == null) {
            return null;
        }
        f fVar = new f();
        if (rawQuery.moveToFirst()) {
            fVar.b(rawQuery);
        }
        rawQuery.close();
        if (fVar.field_fileNameHash == i) {
            return fVar;
        }
        return null;
    }

    public final List<f> KM() {
        List linkedList = new LinkedList();
        String str = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
        Cursor rawQuery = this.cie.rawQuery(str, new String[]{"7"});
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    f fVar = new f();
                    fVar.b(rawQuery);
                    linkedList.add(fVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final int KN() {
        int i = 0;
        Cursor rawQuery = this.cie.rawQuery("SELECT COUNT(localId) FROM SightDraftInfo WHERE fileStatus = ? ", new String[]{"1"});
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final void KO() {
        if (1209600000 <= 0) {
            v.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
            this.cie.dF("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
            return;
        }
        v.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", Long.valueOf(be.Ni() - 1209600000));
        this.cie.dF("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < " + r0);
    }

    public final void KP() {
        this.cie.dF("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 6");
    }

    public final void KQ() {
        this.cie.dF("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
    }
}
