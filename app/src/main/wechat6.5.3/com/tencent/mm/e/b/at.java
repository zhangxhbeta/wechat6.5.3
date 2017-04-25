package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class at extends c {
    private static final int bGJ = "configId".hashCode();
    private static final int btA = Columns.VALUE.hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bGI = true;
    private boolean bts = true;
    public int field_configId;
    public String field_value;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "configId";
        aVar.nmd.put("configId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" configId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "configId";
        aVar.bXK[1] = Columns.VALUE;
        aVar.nmd.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
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
                if (bGJ == hashCode) {
                    this.field_configId = cursor.getInt(i);
                    this.bGI = true;
                } else if (btA == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGI) {
            contentValues.put("configId", Integer.valueOf(this.field_configId));
        }
        if (this.bts) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
