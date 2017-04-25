package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class z extends c {
    private static final int bAA = "jump_type".hashCode();
    private static final int bAB = "url".hashCode();
    private static final int bAC = "buttonData".hashCode();
    private static final int bAD = "operData".hashCode();
    private static final int bAE = "report_scene".hashCode();
    private static final int bAF = "read_state".hashCode();
    private static final int bAG = "accept_buttons".hashCode();
    private static final int bAH = "consumed_box_id".hashCode();
    private static final int bAI = "jump_buttons".hashCode();
    private static final int bAJ = "logo_color".hashCode();
    private static final int bAt = "card_type".hashCode();
    private static final int bAu = "logo_url".hashCode();
    private static final int bAv = "time".hashCode();
    private static final int bAw = "card_id".hashCode();
    private static final int bAx = "card_tp_id".hashCode();
    private static final int bAy = "msg_id".hashCode();
    private static final int bAz = "msg_type".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bxP = "title".hashCode();
    private static final int bxQ = "description".hashCode();
    private boolean bAc = true;
    private boolean bAd = true;
    private boolean bAe = true;
    private boolean bAf = true;
    private boolean bAg = true;
    private boolean bAh = true;
    private boolean bAi = true;
    private boolean bAj = true;
    private boolean bAk = true;
    private boolean bAl = true;
    private boolean bAm = true;
    private boolean bAn = true;
    private boolean bAo = true;
    private boolean bAp = true;
    private boolean bAq = true;
    private boolean bAr = true;
    private boolean bAs = true;
    private boolean bxL = true;
    private boolean bxM = true;
    public String field_accept_buttons;
    public byte[] field_buttonData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public String field_consumed_box_id;
    public String field_description;
    public String field_jump_buttons;
    public int field_jump_type;
    public String field_logo_color;
    public String field_logo_url;
    public String field_msg_id;
    public int field_msg_type;
    public byte[] field_operData;
    public int field_read_state;
    public int field_report_scene;
    public int field_time;
    public String field_title;
    public String field_url;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bAt == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (bxQ == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (bAu == hashCode) {
                    this.field_logo_url = cursor.getString(i);
                } else if (bAv == hashCode) {
                    this.field_time = cursor.getInt(i);
                } else if (bAw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (bAx == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (bAy == hashCode) {
                    this.field_msg_id = cursor.getString(i);
                    this.bAh = true;
                } else if (bAz == hashCode) {
                    this.field_msg_type = cursor.getInt(i);
                } else if (bAA == hashCode) {
                    this.field_jump_type = cursor.getInt(i);
                } else if (bAB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (bAC == hashCode) {
                    this.field_buttonData = cursor.getBlob(i);
                } else if (bAD == hashCode) {
                    this.field_operData = cursor.getBlob(i);
                } else if (bAE == hashCode) {
                    this.field_report_scene = cursor.getInt(i);
                } else if (bAF == hashCode) {
                    this.field_read_state = cursor.getInt(i);
                } else if (bAG == hashCode) {
                    this.field_accept_buttons = cursor.getString(i);
                } else if (bAH == hashCode) {
                    this.field_consumed_box_id = cursor.getString(i);
                } else if (bAI == hashCode) {
                    this.field_jump_buttons = cursor.getString(i);
                } else if (bAJ == hashCode) {
                    this.field_logo_color = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bAc) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.bxM) {
            contentValues.put("description", this.field_description);
        }
        if (this.bAd) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.bAe) {
            contentValues.put("time", Integer.valueOf(this.field_time));
        }
        if (this.bAf) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.bAg) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.bAh) {
            contentValues.put("msg_id", this.field_msg_id);
        }
        if (this.bAi) {
            contentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
        }
        if (this.bAj) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.bAk) {
            contentValues.put("url", this.field_url);
        }
        if (this.bAl) {
            contentValues.put("buttonData", this.field_buttonData);
        }
        if (this.bAm) {
            contentValues.put("operData", this.field_operData);
        }
        if (this.bAn) {
            contentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
        }
        if (this.bAo) {
            contentValues.put("read_state", Integer.valueOf(this.field_read_state));
        }
        if (this.bAp) {
            contentValues.put("accept_buttons", this.field_accept_buttons);
        }
        if (this.bAq) {
            contentValues.put("consumed_box_id", this.field_consumed_box_id);
        }
        if (this.bAr) {
            contentValues.put("jump_buttons", this.field_jump_buttons);
        }
        if (this.bAs) {
            contentValues.put("logo_color", this.field_logo_color);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
