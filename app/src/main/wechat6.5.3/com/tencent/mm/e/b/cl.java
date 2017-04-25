package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cl extends c {
    private static final int bAw = "card_id".hashCode();
    private static final int bAx = "card_tp_id".hashCode();
    private static final int bFc = "app_id".hashCode();
    private static final int bHf = "updateSeq".hashCode();
    private static final int bRA = "itemIndex".hashCode();
    private static final int bRo = "from_username".hashCode();
    private static final int bRp = "consumer".hashCode();
    private static final int bRq = "share_time".hashCode();
    private static final int bRr = "local_updateTime".hashCode();
    private static final int bRs = "begin_time".hashCode();
    private static final int bRt = "end_time".hashCode();
    private static final int bRu = "block_mask".hashCode();
    private static final int bRv = "dataInfoData".hashCode();
    private static final int bRw = "cardTpInfoData".hashCode();
    private static final int bRx = "shareInfoData".hashCode();
    private static final int bRy = "shopInfoData".hashCode();
    private static final int bRz = "categoryType".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)"};
    private static final int btm = "rowid".hashCode();
    private static final int bvJ = "updateTime".hashCode();
    private static final int bvg = DownloadInfo.STATUS.hashCode();
    private boolean bAf = true;
    private boolean bAg = true;
    private boolean bEG = true;
    private boolean bGQ = true;
    private boolean bRb = true;
    private boolean bRc = true;
    private boolean bRd = true;
    private boolean bRe = true;
    private boolean bRf = true;
    private boolean bRg = true;
    private boolean bRh = true;
    private boolean bRi = true;
    private boolean bRj = true;
    private boolean bRk = true;
    private boolean bRl = true;
    private boolean bRm = true;
    private boolean bRn = true;
    private boolean buP = true;
    private boolean bvF = true;
    public String field_app_id;
    public long field_begin_time;
    public long field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_categoryType;
    public String field_consumer;
    public byte[] field_dataInfoData;
    public long field_end_time;
    public String field_from_username;
    public int field_itemIndex;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public long field_share_time;
    public byte[] field_shopInfoData;
    public int field_status;
    public long field_updateSeq;
    public long field_updateTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bAw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.bAf = true;
                } else if (bAx == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (bRo == hashCode) {
                    this.field_from_username = cursor.getString(i);
                } else if (bRp == hashCode) {
                    this.field_consumer = cursor.getString(i);
                } else if (bFc == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bRq == hashCode) {
                    this.field_share_time = cursor.getLong(i);
                } else if (bRr == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (bvJ == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (bRs == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (bRt == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (bHf == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (bRu == hashCode) {
                    this.field_block_mask = cursor.getLong(i);
                } else if (bRv == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (bRw == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (bRx == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (bRy == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (bRz == hashCode) {
                    this.field_categoryType = cursor.getInt(i);
                } else if (bRA == hashCode) {
                    this.field_itemIndex = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bAf) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.bAg) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.bRb) {
            contentValues.put("from_username", this.field_from_username);
        }
        if (this.bRc) {
            contentValues.put("consumer", this.field_consumer);
        }
        if (this.bEG) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.buP) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.bRd) {
            contentValues.put("share_time", Long.valueOf(this.field_share_time));
        }
        if (this.bRe) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.bvF) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.bRf) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.bRg) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.bGQ) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.bRh) {
            contentValues.put("block_mask", Long.valueOf(this.field_block_mask));
        }
        if (this.bRi) {
            contentValues.put("dataInfoData", this.field_dataInfoData);
        }
        if (this.bRj) {
            contentValues.put("cardTpInfoData", this.field_cardTpInfoData);
        }
        if (this.bRk) {
            contentValues.put("shareInfoData", this.field_shareInfoData);
        }
        if (this.bRl) {
            contentValues.put("shopInfoData", this.field_shopInfoData);
        }
        if (this.bRm) {
            contentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
        }
        if (this.bRn) {
            contentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
