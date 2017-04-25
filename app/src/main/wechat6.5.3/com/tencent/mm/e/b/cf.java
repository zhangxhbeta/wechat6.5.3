package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;

public abstract class cf extends c {
    private static final int bFt = "desc".hashCode();
    private static final int bGM = "localId".hashCode();
    private static final int bHk = "toUser".hashCode();
    private static final int bPm = "oriMsgId".hashCode();
    private static final int bPn = "dataProto".hashCode();
    private static final int bPo = "favFrom".hashCode();
    public static final String[] btd = new String[0];
    private static final int btl = "msgId".hashCode();
    private static final int btm = "rowid".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int bvg = DownloadInfo.STATUS.hashCode();
    private static final int bxP = "title".hashCode();
    private boolean bFp = true;
    private boolean bGK = true;
    private boolean bGV = true;
    private boolean bPj = true;
    private boolean bPk = true;
    private boolean bPl = true;
    private boolean btV = true;
    private boolean bth = true;
    private boolean buP = true;
    private boolean bxL = true;
    public qf field_dataProto;
    public String field_desc;
    public String field_favFrom;
    public int field_localId;
    public long field_msgId;
    public long field_oriMsgId;
    public int field_status;
    public String field_title;
    public String field_toUser;
    public int field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGM == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.bGK = true;
                } else if (btl == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (bPm == hashCode) {
                    this.field_oriMsgId = cursor.getLong(i);
                } else if (bHk == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (bFt == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (bPn == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_dataProto = (qf) new qf().az(blob);
                        }
                    } catch (IOException e) {
                        v.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
                    }
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bPo == hashCode) {
                    this.field_favFrom = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGK) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.bth) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.bPj) {
            contentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.bGV) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.bFp) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.bPk && this.field_dataProto != null) {
            try {
                contentValues.put("dataProto", this.field_dataProto.toByteArray());
            } catch (IOException e) {
                v.e("MicroMsg.SDK.BaseRecordMessageInfo", e.getMessage());
            }
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.buP) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.bPl) {
            contentValues.put("favFrom", this.field_favFrom);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
