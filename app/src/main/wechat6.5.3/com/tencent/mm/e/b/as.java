package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class as extends c {
    private static final int bFj = "cdnUrl".hashCode();
    private static final int bGD = "dataId".hashCode();
    private static final int bGE = "favLocalId".hashCode();
    private static final int bGF = "cdnKey".hashCode();
    private static final int bGG = "path".hashCode();
    private static final int bGH = "extFlag".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)"};
    private static final int btm = "rowid".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int bvA = "dataType".hashCode();
    private static final int bve = "totalLen".hashCode();
    private static final int bvf = "offset".hashCode();
    private static final int bvg = DownloadInfo.STATUS.hashCode();
    private static final int bwW = "modifyTime".hashCode();
    private boolean bEN = true;
    private boolean bGA = true;
    private boolean bGB = true;
    private boolean bGC = true;
    private boolean bGy = true;
    private boolean bGz = true;
    private boolean btV = true;
    private boolean buN = true;
    private boolean buO = true;
    private boolean buP = true;
    private boolean bvx = true;
    private boolean bwA = true;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[12];
        aVar.bXK = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "dataId";
        aVar.nmd.put("dataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" dataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "dataId";
        aVar.bXK[1] = "favLocalId";
        aVar.nmd.put("favLocalId", "LONG");
        stringBuilder.append(" favLocalId LONG");
        stringBuilder.append(", ");
        aVar.bXK[2] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "cdnUrl";
        aVar.nmd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "cdnKey";
        aVar.nmd.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "totalLen";
        aVar.nmd.put("totalLen", "INTEGER");
        stringBuilder.append(" totalLen INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "offset";
        aVar.nmd.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = DownloadInfo.STATUS;
        aVar.nmd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "path";
        aVar.nmd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "dataType";
        aVar.nmd.put("dataType", "INTEGER");
        stringBuilder.append(" dataType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "modifyTime";
        aVar.nmd.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "extFlag";
        aVar.nmd.put("extFlag", "INTEGER default '0' ");
        stringBuilder.append(" extFlag INTEGER default '0' ");
        aVar.bXK[12] = "rowid";
        aVar.nme = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGD == hashCode) {
                    this.field_dataId = cursor.getString(i);
                    this.bGy = true;
                } else if (bGE == hashCode) {
                    this.field_favLocalId = cursor.getLong(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bFj == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (bGF == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (bve == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (bvf == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bGG == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (bvA == hashCode) {
                    this.field_dataType = cursor.getInt(i);
                } else if (bwW == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (bGH == hashCode) {
                    this.field_extFlag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGy) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.bGz) {
            contentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.bEN) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.bGA) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.buN) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.buO) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.buP) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.bGB) {
            contentValues.put("path", this.field_path);
        }
        if (this.bvx) {
            contentValues.put("dataType", Integer.valueOf(this.field_dataType));
        }
        if (this.bwA) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.bGC) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
