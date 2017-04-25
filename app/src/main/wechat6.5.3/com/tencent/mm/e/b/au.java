package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class au extends c {
    private static final int bAv = "time".hashCode();
    private static final int bGM = "localId".hashCode();
    private static final int bGN = "modItem".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)"};
    private static final int btm = "rowid".hashCode();
    private static final int buG = "scene".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private boolean bAe = true;
    private boolean bGK = true;
    private boolean bGL = true;
    private boolean btV = true;
    private boolean buE = true;
    public long field_localId;
    public qa field_modItem;
    public int field_scene;
    public long field_time;
    public int field_type;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "localId";
        aVar.nmd.put("localId", "LONG");
        stringBuilder.append(" localId LONG");
        stringBuilder.append(", ");
        aVar.bXK[1] = "modItem";
        aVar.nmd.put("modItem", "BLOB");
        stringBuilder.append(" modItem BLOB");
        stringBuilder.append(", ");
        aVar.bXK[2] = "time";
        aVar.nmd.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.bXK[3] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "scene";
        aVar.nmd.put("scene", "INTEGER default '1' ");
        stringBuilder.append(" scene INTEGER default '1' ");
        aVar.bXK[5] = "rowid";
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
                } else if (bGN == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (qa) new qa().az(blob);
                        }
                    } catch (IOException e) {
                        v.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
                    }
                } else if (bAv == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (buG == hashCode) {
                    this.field_scene = cursor.getInt(i);
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
        if (this.bGL && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e) {
                v.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
            }
        }
        if (this.bAe) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.buE) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
