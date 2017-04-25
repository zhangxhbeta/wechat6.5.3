package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class av extends c {
    private static final int bGM = "localId".hashCode();
    private static final int bHd = "id".hashCode();
    private static final int bHe = "localSeq".hashCode();
    private static final int bHf = "updateSeq".hashCode();
    private static final int bHg = "sourceId".hashCode();
    private static final int bHh = "itemStatus".hashCode();
    private static final int bHi = "sourceCreateTime".hashCode();
    private static final int bHj = "fromUser".hashCode();
    private static final int bHk = "toUser".hashCode();
    private static final int bHl = "realChatName".hashCode();
    private static final int bHm = "favProto".hashCode();
    private static final int bHn = "ext".hashCode();
    private static final int bHo = "edittime".hashCode();
    private static final int bHp = "tagProto".hashCode();
    private static final int bHq = "sessionId".hashCode();
    private static final int bHr = "datatotalsize".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)"};
    private static final int btm = "rowid".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int bur = "sourceType".hashCode();
    private static final int bvJ = "updateTime".hashCode();
    private static final int bxO = "xml".hashCode();
    private static final int bxU = "flag".hashCode();
    private boolean bGK = true;
    private boolean bGO = true;
    private boolean bGP = true;
    private boolean bGQ = true;
    private boolean bGR = true;
    private boolean bGS = true;
    private boolean bGT = true;
    private boolean bGU = true;
    private boolean bGV = true;
    private boolean bGW = true;
    private boolean bGX = true;
    private boolean bGY = true;
    private boolean bGZ = true;
    private boolean bHa = true;
    private boolean bHb = true;
    private boolean bHc = true;
    private boolean btV = true;
    private boolean btW = true;
    private boolean bvF = true;
    private boolean bxK = true;
    private boolean bxS = true;
    public long field_datatotalsize;
    public long field_edittime;
    public String field_ext;
    public qf field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public String field_sessionId;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public qn field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;
    public String field_xml;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[21];
        aVar.bXK = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "localId";
        aVar.nmd.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "localId";
        aVar.bXK[1] = "id";
        aVar.nmd.put("id", "INTEGER");
        stringBuilder.append(" id INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "localSeq";
        aVar.nmd.put("localSeq", "INTEGER");
        stringBuilder.append(" localSeq INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "updateSeq";
        aVar.nmd.put("updateSeq", "INTEGER");
        stringBuilder.append(" updateSeq INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "flag";
        aVar.nmd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "sourceId";
        aVar.nmd.put("sourceId", "TEXT");
        stringBuilder.append(" sourceId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "itemStatus";
        aVar.nmd.put("itemStatus", "INTEGER");
        stringBuilder.append(" itemStatus INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "sourceType";
        aVar.nmd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "sourceCreateTime";
        aVar.nmd.put("sourceCreateTime", "LONG");
        stringBuilder.append(" sourceCreateTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[10] = "updateTime";
        aVar.nmd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[11] = "fromUser";
        aVar.nmd.put("fromUser", "TEXT");
        stringBuilder.append(" fromUser TEXT");
        stringBuilder.append(", ");
        aVar.bXK[12] = "toUser";
        aVar.nmd.put("toUser", "TEXT");
        stringBuilder.append(" toUser TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "realChatName";
        aVar.nmd.put("realChatName", "TEXT");
        stringBuilder.append(" realChatName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "favProto";
        aVar.nmd.put("favProto", "BLOB");
        stringBuilder.append(" favProto BLOB");
        stringBuilder.append(", ");
        aVar.bXK[15] = "xml";
        aVar.nmd.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "ext";
        aVar.nmd.put("ext", "TEXT");
        stringBuilder.append(" ext TEXT");
        stringBuilder.append(", ");
        aVar.bXK[17] = "edittime";
        aVar.nmd.put("edittime", "LONG");
        stringBuilder.append(" edittime LONG");
        stringBuilder.append(", ");
        aVar.bXK[18] = "tagProto";
        aVar.nmd.put("tagProto", "BLOB");
        stringBuilder.append(" tagProto BLOB");
        stringBuilder.append(", ");
        aVar.bXK[19] = "sessionId";
        aVar.nmd.put("sessionId", "TEXT");
        stringBuilder.append(" sessionId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[20] = "datatotalsize";
        aVar.nmd.put("datatotalsize", "LONG");
        stringBuilder.append(" datatotalsize LONG");
        aVar.bXK[21] = "rowid";
        aVar.nme = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGM == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.bGK = true;
                } else if (bHd == hashCode) {
                    this.field_id = cursor.getInt(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bHe == hashCode) {
                    this.field_localSeq = cursor.getInt(i);
                } else if (bHf == hashCode) {
                    this.field_updateSeq = cursor.getInt(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (bHg == hashCode) {
                    this.field_sourceId = cursor.getString(i);
                } else if (bHh == hashCode) {
                    this.field_itemStatus = cursor.getInt(i);
                } else if (bur == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (bHi == hashCode) {
                    this.field_sourceCreateTime = cursor.getLong(i);
                } else if (bvJ == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (bHj == hashCode) {
                    this.field_fromUser = cursor.getString(i);
                } else if (bHk == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (bHl == hashCode) {
                    this.field_realChatName = cursor.getString(i);
                } else if (bHm == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_favProto = (qf) new qf().az(r0);
                        }
                    } catch (IOException e) {
                        v.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
                    }
                } else if (bxO == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (bHn == hashCode) {
                    this.field_ext = cursor.getString(i);
                } else if (bHo == hashCode) {
                    this.field_edittime = cursor.getLong(i);
                } else if (bHp == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_tagProto = (qn) new qn().az(r0);
                        }
                    } catch (IOException e2) {
                        v.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
                    }
                } else if (bHq == hashCode) {
                    this.field_sessionId = cursor.getString(i);
                } else if (bHr == hashCode) {
                    this.field_datatotalsize = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGK) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.bGO) {
            contentValues.put("id", Integer.valueOf(this.field_id));
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.bGP) {
            contentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
        }
        if (this.bGQ) {
            contentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
        }
        if (this.bxS) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.bGR) {
            contentValues.put("sourceId", this.field_sourceId);
        }
        if (this.bGS) {
            contentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
        }
        if (this.btW) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.bGT) {
            contentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
        }
        if (this.bvF) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.bGU) {
            contentValues.put("fromUser", this.field_fromUser);
        }
        if (this.bGV) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.bGW) {
            contentValues.put("realChatName", this.field_realChatName);
        }
        if (this.bGX && this.field_favProto != null) {
            try {
                contentValues.put("favProto", this.field_favProto.toByteArray());
            } catch (IOException e) {
                v.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
            }
        }
        if (this.bxK) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.bGY) {
            contentValues.put("ext", this.field_ext);
        }
        if (this.bGZ) {
            contentValues.put("edittime", Long.valueOf(this.field_edittime));
        }
        if (this.bHa && this.field_tagProto != null) {
            try {
                contentValues.put("tagProto", this.field_tagProto.toByteArray());
            } catch (IOException e2) {
                v.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
            }
        }
        if (this.bHb) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.bHc) {
            contentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
