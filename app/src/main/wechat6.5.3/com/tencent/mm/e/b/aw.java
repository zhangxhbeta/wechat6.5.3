package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class aw extends c {
    private static final int bAv = "time".hashCode();
    private static final int bGM = "localId".hashCode();
    private static final int bHu = "tagContent".hashCode();
    private static final int bHv = "subtype".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)"};
    private static final int btm = "rowid".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int buv = "content".hashCode();
    private boolean bAe = true;
    private boolean bGK = true;
    private boolean bHs = true;
    private boolean bHt = true;
    private boolean btV = true;
    private boolean bua = true;
    public String field_content;
    public long field_localId;
    public int field_subtype;
    public String field_tagContent;
    public long field_time;
    public int field_type;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[6];
        aVar.bXK = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "localId";
        aVar.nmd.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "localId";
        aVar.bXK[1] = "content";
        aVar.nmd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "tagContent";
        aVar.nmd.put("tagContent", "TEXT");
        stringBuilder.append(" tagContent TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "time";
        aVar.nmd.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "subtype";
        aVar.nmd.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        aVar.bXK[6] = "rowid";
        aVar.nme = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGM == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.bGK = true;
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (bHu == hashCode) {
                    this.field_tagContent = cursor.getString(i);
                } else if (bAv == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bHv == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGK) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.bHs) {
            contentValues.put("tagContent", this.field_tagContent);
        }
        if (this.bAe) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.bHt) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
