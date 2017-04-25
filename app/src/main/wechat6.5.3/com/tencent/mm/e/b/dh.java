package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public abstract class dh extends c {
    private static final int bWs = "occupation".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private boolean bWr = true;
    private boolean buI = true;
    public String field_appId;
    public long field_occupation;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appId";
        aVar.nmd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "appId";
        aVar.bXK[1] = "occupation";
        aVar.nmd.put("occupation", "LONG");
        stringBuilder.append(" occupation LONG");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.buI = true;
                } else if (bWs == hashCode) {
                    this.field_occupation = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bWr) {
            contentValues.put("occupation", Long.valueOf(this.field_occupation));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
