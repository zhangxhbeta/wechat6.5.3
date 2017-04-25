package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bf extends c {
    private static final int bJA = "expireTime".hashCode();
    private static final int bJB = "showInMsgList".hashCode();
    private static final int bJC = "isRead".hashCode();
    private static final int bJD = "label".hashCode();
    private static final int bJE = "isHidden".hashCode();
    private static final int bJF = "weight".hashCode();
    private static final int bJy = "mergerId".hashCode();
    private static final int bJz = "gameMsgId".hashCode();
    private static final int btO = "rawXML".hashCode();
    public static final String[] btd = new String[0];
    private static final int btl = "msgId".hashCode();
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int byE = "msgType".hashCode();
    private boolean bJq = true;
    private boolean bJr = true;
    private boolean bJs = true;
    private boolean bJt = true;
    private boolean bJu = true;
    private boolean bJv = true;
    private boolean bJw = true;
    private boolean bJx = true;
    private boolean btK = true;
    private boolean btS = true;
    private boolean bth = true;
    private boolean buI = true;
    private boolean byq = true;
    public String field_appId;
    public long field_createTime;
    public long field_expireTime;
    public String field_gameMsgId;
    public boolean field_isHidden;
    public boolean field_isRead;
    public String field_label;
    public String field_mergerId;
    public long field_msgId;
    public int field_msgType;
    public String field_rawXML;
    public boolean field_showInMsgList;
    public String field_weight;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btl == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.bth = true;
                } else if (bJy == hashCode) {
                    this.field_mergerId = cursor.getString(i);
                } else if (bJz == hashCode) {
                    this.field_gameMsgId = cursor.getString(i);
                } else if (byE == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bJA == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bJB == hashCode) {
                    this.field_showInMsgList = cursor.getInt(i) != 0;
                } else if (bJC == hashCode) {
                    this.field_isRead = cursor.getInt(i) != 0;
                } else if (bJD == hashCode) {
                    this.field_label = cursor.getString(i);
                } else if (bJE == hashCode) {
                    this.field_isHidden = cursor.getInt(i) != 0;
                } else if (bJF == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (btO == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bth) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.bJq) {
            contentValues.put("mergerId", this.field_mergerId);
        }
        if (this.bJr) {
            contentValues.put("gameMsgId", this.field_gameMsgId);
        }
        if (this.byq) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.bJs) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bJt) {
            contentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
        }
        if (this.bJu) {
            contentValues.put("isRead", Boolean.valueOf(this.field_isRead));
        }
        if (this.field_label == null) {
            this.field_label = "";
        }
        if (this.bJv) {
            contentValues.put("label", this.field_label);
        }
        if (this.bJw) {
            contentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
        }
        if (this.field_weight == null) {
            this.field_weight = "";
        }
        if (this.bJx) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.btK) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
