package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ax extends c {
    private static final int bAB = "url".hashCode();
    private static final int bHF = "featureId".hashCode();
    private static final int bHG = "titlePY".hashCode();
    private static final int bHH = "titleShortPY".hashCode();
    private static final int bHI = "tag".hashCode();
    private static final int bHJ = "actionType".hashCode();
    private static final int bHK = "helpUrl".hashCode();
    private static final int bHL = "updateUrl".hashCode();
    private static final int bHM = "androidUrl".hashCode();
    private static final int bHN = "iconPath".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bxP = "title".hashCode();
    private boolean bAk = true;
    private boolean bHA = true;
    private boolean bHB = true;
    private boolean bHC = true;
    private boolean bHD = true;
    private boolean bHE = true;
    private boolean bHw = true;
    private boolean bHx = true;
    private boolean bHy = true;
    private boolean bHz = true;
    private boolean bxL = true;
    public int field_actionType;
    public String field_androidUrl;
    public int field_featureId;
    public String field_helpUrl;
    public String field_iconPath;
    public String field_tag;
    public String field_title;
    public String field_titlePY;
    public String field_titleShortPY;
    public String field_updateUrl;
    public String field_url;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bHF == hashCode) {
                    this.field_featureId = cursor.getInt(i);
                    this.bHw = true;
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (bHG == hashCode) {
                    this.field_titlePY = cursor.getString(i);
                } else if (bHH == hashCode) {
                    this.field_titleShortPY = cursor.getString(i);
                } else if (bHI == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (bHJ == hashCode) {
                    this.field_actionType = cursor.getInt(i);
                } else if (bAB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (bHK == hashCode) {
                    this.field_helpUrl = cursor.getString(i);
                } else if (bHL == hashCode) {
                    this.field_updateUrl = cursor.getString(i);
                } else if (bHM == hashCode) {
                    this.field_androidUrl = cursor.getString(i);
                } else if (bHN == hashCode) {
                    this.field_iconPath = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bHw) {
            contentValues.put("featureId", Integer.valueOf(this.field_featureId));
        }
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.bHx) {
            contentValues.put("titlePY", this.field_titlePY);
        }
        if (this.bHy) {
            contentValues.put("titleShortPY", this.field_titleShortPY);
        }
        if (this.bHz) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.bHA) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.bAk) {
            contentValues.put("url", this.field_url);
        }
        if (this.bHB) {
            contentValues.put("helpUrl", this.field_helpUrl);
        }
        if (this.bHC) {
            contentValues.put("updateUrl", this.field_updateUrl);
        }
        if (this.bHD) {
            contentValues.put("androidUrl", this.field_androidUrl);
        }
        if (this.bHE) {
            contentValues.put("iconPath", this.field_iconPath);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
