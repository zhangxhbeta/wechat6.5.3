package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bo extends c {
    private static final int bLB = "ranknum".hashCode();
    private static final int bLC = "likecount".hashCode();
    private static final int bLD = "selfLikeState".hashCode();
    private static final int bLq = "rankID".hashCode();
    private static final int bLr = "appusername".hashCode();
    private static final int bLv = "score".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bLA = true;
    private boolean bLm = true;
    private boolean bLn = true;
    private boolean bLu = true;
    private boolean bLy = true;
    private boolean bLz = true;
    private boolean bzs = true;
    public String field_appusername;
    public int field_likecount;
    public String field_rankID;
    public int field_ranknum;
    public int field_score;
    public int field_selfLikeState;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bLq == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (bLr == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (bLB == hashCode) {
                    this.field_ranknum = cursor.getInt(i);
                } else if (bLv == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (bLC == hashCode) {
                    this.field_likecount = cursor.getInt(i);
                } else if (bLD == hashCode) {
                    this.field_selfLikeState = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bLm) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.bLn) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.bLy) {
            contentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
        }
        if (this.bLu) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.bLz) {
            contentValues.put("likecount", Integer.valueOf(this.field_likecount));
        }
        if (this.bLA) {
            contentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
