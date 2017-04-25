package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class aa extends c {
    private static final int bBc = "chatroomname".hashCode();
    private static final int bBd = "addtime".hashCode();
    private static final int bBe = "memberlist".hashCode();
    private static final int bBf = "displayname".hashCode();
    private static final int bBg = "chatroomnick".hashCode();
    private static final int bBh = "roomflag".hashCode();
    private static final int bBi = "roomowner".hashCode();
    private static final int bBj = "roomdata".hashCode();
    private static final int bBk = "isShowname".hashCode();
    private static final int bBl = "selfDisplayName".hashCode();
    private static final int bBm = "style".hashCode();
    private static final int bBn = "chatroomdataflag".hashCode();
    private static final int bBo = "modifytime".hashCode();
    private static final int bBp = "chatroomnotice".hashCode();
    private static final int bBq = "chatroomVersion".hashCode();
    private static final int bBr = "chatroomnoticeEditor".hashCode();
    private static final int bBs = "chatroomnoticePublishTime".hashCode();
    private static final int bBt = "chatroomLocalVersion".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bAK = true;
    private boolean bAL = true;
    private boolean bAM = true;
    private boolean bAN = true;
    private boolean bAO = true;
    private boolean bAP = true;
    private boolean bAQ = true;
    private boolean bAR = true;
    private boolean bAS = true;
    private boolean bAT = true;
    private boolean bAU = true;
    private boolean bAV = true;
    private boolean bAW = true;
    private boolean bAX = true;
    private boolean bAY = true;
    private boolean bAZ = true;
    private boolean bBa = true;
    private boolean bBb = true;
    public long field_addtime;
    public long field_chatroomLocalVersion;
    public int field_chatroomVersion;
    public int field_chatroomdataflag;
    public String field_chatroomname;
    public String field_chatroomnick;
    public String field_chatroomnotice;
    public String field_chatroomnoticeEditor;
    public long field_chatroomnoticePublishTime;
    public String field_displayname;
    public int field_isShowname;
    public String field_memberlist;
    public long field_modifytime;
    public byte[] field_roomdata;
    public int field_roomflag;
    public String field_roomowner;
    public String field_selfDisplayName;
    public int field_style;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bBc == hashCode) {
                    this.field_chatroomname = cursor.getString(i);
                    this.bAK = true;
                } else if (bBd == hashCode) {
                    this.field_addtime = cursor.getLong(i);
                } else if (bBe == hashCode) {
                    this.field_memberlist = cursor.getString(i);
                } else if (bBf == hashCode) {
                    this.field_displayname = cursor.getString(i);
                } else if (bBg == hashCode) {
                    this.field_chatroomnick = cursor.getString(i);
                } else if (bBh == hashCode) {
                    this.field_roomflag = cursor.getInt(i);
                } else if (bBi == hashCode) {
                    this.field_roomowner = cursor.getString(i);
                } else if (bBj == hashCode) {
                    this.field_roomdata = cursor.getBlob(i);
                } else if (bBk == hashCode) {
                    this.field_isShowname = cursor.getInt(i);
                } else if (bBl == hashCode) {
                    this.field_selfDisplayName = cursor.getString(i);
                } else if (bBm == hashCode) {
                    this.field_style = cursor.getInt(i);
                } else if (bBn == hashCode) {
                    this.field_chatroomdataflag = cursor.getInt(i);
                } else if (bBo == hashCode) {
                    this.field_modifytime = cursor.getLong(i);
                } else if (bBp == hashCode) {
                    this.field_chatroomnotice = cursor.getString(i);
                } else if (bBq == hashCode) {
                    this.field_chatroomVersion = cursor.getInt(i);
                } else if (bBr == hashCode) {
                    this.field_chatroomnoticeEditor = cursor.getString(i);
                } else if (bBs == hashCode) {
                    this.field_chatroomnoticePublishTime = cursor.getLong(i);
                } else if (bBt == hashCode) {
                    this.field_chatroomLocalVersion = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatroomname == null) {
            this.field_chatroomname = SQLiteDatabase.KeyEmpty;
        }
        if (this.bAK) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.bAL) {
            contentValues.put("addtime", Long.valueOf(this.field_addtime));
        }
        if (this.bAM) {
            contentValues.put("memberlist", this.field_memberlist);
        }
        if (this.bAN) {
            contentValues.put("displayname", this.field_displayname);
        }
        if (this.bAO) {
            contentValues.put("chatroomnick", this.field_chatroomnick);
        }
        if (this.bAP) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.bAQ) {
            contentValues.put("roomowner", this.field_roomowner);
        }
        if (this.bAR) {
            contentValues.put("roomdata", this.field_roomdata);
        }
        if (this.bAS) {
            contentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
        }
        if (this.bAT) {
            contentValues.put("selfDisplayName", this.field_selfDisplayName);
        }
        if (this.bAU) {
            contentValues.put("style", Integer.valueOf(this.field_style));
        }
        if (this.bAV) {
            contentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
        }
        if (this.bAW) {
            contentValues.put("modifytime", Long.valueOf(this.field_modifytime));
        }
        if (this.bAX) {
            contentValues.put("chatroomnotice", this.field_chatroomnotice);
        }
        if (this.bAY) {
            contentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
        }
        if (this.bAZ) {
            contentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
        }
        if (this.bBa) {
            contentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
        }
        if (this.bBb) {
            contentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
