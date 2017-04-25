package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.e.b.bg;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class q extends bg {
    protected static a chq;

    protected final a tl() {
        return null;
    }

    public q(String str, byte[] bArr) {
        this.field_reqType = str;
        this.field_cache = bArr;
    }

    public q(Cursor cursor) {
        if (cursor != null) {
            b(cursor);
        }
    }

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "reqType";
        aVar.nmd.put("reqType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "reqType";
        aVar.bXK[1] = "cache";
        aVar.nmd.put("cache", "BLOB default '' ");
        stringBuilder.append(" cache BLOB default '' ");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }
}
