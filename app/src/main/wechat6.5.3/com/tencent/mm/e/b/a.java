package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class a extends c {
    public static final String[] btd = new String[0];
    private static final int bti = "payMsgId".hashCode();
    private static final int btj = "insertmsg".hashCode();
    private static final int btk = "chatroom".hashCode();
    private static final int btl = "msgId".hashCode();
    private static final int btm = "rowid".hashCode();
    private boolean bte = true;
    private boolean btf = true;
    private boolean btg = true;
    private boolean bth = true;
    public String field_chatroom;
    public boolean field_insertmsg;
    public long field_msgId;
    public String field_payMsgId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bti == hashCode) {
                    this.field_payMsgId = cursor.getString(i);
                    this.bte = true;
                } else if (btj == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (btk == hashCode) {
                    this.field_chatroom = cursor.getString(i);
                } else if (btl == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bte) {
            contentValues.put("payMsgId", this.field_payMsgId);
        }
        if (this.btf) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.btg) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.bth) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
