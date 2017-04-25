package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public abstract class f extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buG = "scene".hashCode();
    private static final int buH = "ticket".hashCode();
    private static final int bul = "userName".hashCode();
    private boolean btQ = true;
    private boolean buE = true;
    private boolean buF = true;
    public int field_scene;
    public String field_ticket;
    public String field_userName;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[3];
        aVar.bXK = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "userName";
        aVar.nmd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "scene";
        aVar.nmd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "ticket";
        aVar.nmd.put("ticket", "TEXT");
        stringBuilder.append(" ticket TEXT");
        aVar.bXK[3] = "rowid";
        aVar.nme = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bul == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (buG == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (buH == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.btQ) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.buE) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.buF) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
