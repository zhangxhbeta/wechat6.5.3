package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class af extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) "};
    private com.tencent.mm.bg.g cuX;

    public af(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean Q(String str, long j) {
        if (be.kS(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", str);
        contentValues.put("lastSeq", Long.valueOf(j));
        if (((int) this.cuX.replace("DeletedConversationInfo", "userName", contentValues)) == -1) {
            return false;
        }
        Lf(str);
        return true;
    }

    public final long Mu(String str) {
        if (be.kS(str)) {
            return 0;
        }
        Cursor rawQuery = this.cuX.rawQuery("select lastSeq from DeletedConversationInfo where userName = \"" + be.lZ(str) + "\"", null);
        if (rawQuery == null) {
            v.e("MicroMsg.DeletedConversationInfoStorage", "getLastSeq failed " + str);
            return 0;
        } else if (rawQuery.moveToFirst()) {
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        } else {
            rawQuery.close();
            return 0;
        }
    }
}
