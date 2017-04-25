package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class k extends c {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)"};
    private static final int btm = "rowid".hashCode();
    private static final int buG = "scene".hashCode();
    private static final int bvG = "recordId".hashCode();
    private static final int bvH = "brandId".hashCode();
    private static final int bvI = "versionType".hashCode();
    private static final int bvJ = "updateTime".hashCode();
    private boolean buE = true;
    private boolean bvC = true;
    private boolean bvD = true;
    private boolean bvE = true;
    private boolean bvF = true;
    public String field_brandId;
    public int field_recordId;
    public int field_scene;
    public long field_updateTime;
    public int field_versionType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvG == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.bvC = true;
                } else if (bvH == hashCode) {
                    this.field_brandId = cursor.getString(i);
                } else if (bvI == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (bvJ == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (buG == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bvC) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.bvD) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.bvE) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.bvF) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
