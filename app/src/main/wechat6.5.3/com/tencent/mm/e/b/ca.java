package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public abstract class ca extends c {
    private static final int bOA = "songAlbum".hashCode();
    private static final int bOB = "songAlbumType".hashCode();
    private static final int bOC = "songAlbumUrl".hashCode();
    private static final int bOD = "songHAlbumUrl".hashCode();
    private static final int bOE = "songAlbumLocalPath".hashCode();
    private static final int bOF = "songWifiUrl".hashCode();
    private static final int bOG = "songWapLinkUrl".hashCode();
    private static final int bOH = "songWebUrl".hashCode();
    private static final int bOI = "songMediaId".hashCode();
    private static final int bOJ = "songSnsAlbumUser".hashCode();
    private static final int bOK = "songSnsShareUser".hashCode();
    private static final int bOL = "songLyric".hashCode();
    private static final int bOM = "songBgColor".hashCode();
    private static final int bON = "songLyricColor".hashCode();
    private static final int bOO = "songFileLength".hashCode();
    private static final int bOP = "songWifiFileLength".hashCode();
    private static final int bOQ = "hideBanner".hashCode();
    private static final int bOq = "musicId".hashCode();
    private static final int bOr = "originMusicId".hashCode();
    private static final int bOs = "musicType".hashCode();
    private static final int bOt = "downloadedLength".hashCode();
    private static final int bOu = "wifiDownloadedLength".hashCode();
    private static final int bOv = "endFlag".hashCode();
    private static final int bOw = "wifiEndFlag".hashCode();
    private static final int bOx = "songId".hashCode();
    private static final int bOy = "songName".hashCode();
    private static final int bOz = "songSinger".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvJ = "updateTime".hashCode();
    private boolean bNP = true;
    private boolean bNQ = true;
    private boolean bNR = true;
    private boolean bNS = true;
    private boolean bNT = true;
    private boolean bNU = true;
    private boolean bNV = true;
    private boolean bNW = true;
    private boolean bNX = true;
    private boolean bNY = true;
    private boolean bNZ = true;
    private boolean bOa = true;
    private boolean bOb = true;
    private boolean bOc = true;
    private boolean bOd = true;
    private boolean bOe = true;
    private boolean bOf = true;
    private boolean bOg = true;
    private boolean bOh = true;
    private boolean bOi = true;
    private boolean bOj = true;
    private boolean bOk = true;
    private boolean bOl = true;
    private boolean bOm = true;
    private boolean bOn = true;
    private boolean bOo = true;
    private boolean bOp = true;
    private boolean buI = true;
    private boolean bvF = true;
    public String field_appId;
    public long field_downloadedLength;
    public int field_endFlag;
    public boolean field_hideBanner;
    public String field_musicId;
    public int field_musicType;
    public String field_originMusicId;
    public String field_songAlbum;
    public String field_songAlbumLocalPath;
    public int field_songAlbumType;
    public String field_songAlbumUrl;
    public int field_songBgColor;
    public long field_songFileLength;
    public String field_songHAlbumUrl;
    public int field_songId;
    public String field_songLyric;
    public int field_songLyricColor;
    public String field_songMediaId;
    public String field_songName;
    public String field_songSinger;
    public String field_songSnsAlbumUser;
    public String field_songSnsShareUser;
    public String field_songWapLinkUrl;
    public String field_songWebUrl;
    public long field_songWifiFileLength;
    public String field_songWifiUrl;
    public long field_updateTime;
    public long field_wifiDownloadedLength;
    public int field_wifiEndFlag;

    public static a pz() {
        a aVar = new a();
        aVar.ddU = new Field[29];
        aVar.bXK = new String[30];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "musicId";
        aVar.nmd.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "musicId";
        aVar.bXK[1] = "originMusicId";
        aVar.nmd.put("originMusicId", "TEXT");
        stringBuilder.append(" originMusicId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "musicType";
        aVar.nmd.put("musicType", "INTEGER");
        stringBuilder.append(" musicType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "downloadedLength";
        aVar.nmd.put("downloadedLength", "LONG");
        stringBuilder.append(" downloadedLength LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = "wifiDownloadedLength";
        aVar.nmd.put("wifiDownloadedLength", "LONG");
        stringBuilder.append(" wifiDownloadedLength LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = "endFlag";
        aVar.nmd.put("endFlag", "INTEGER");
        stringBuilder.append(" endFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "wifiEndFlag";
        aVar.nmd.put("wifiEndFlag", "INTEGER");
        stringBuilder.append(" wifiEndFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "updateTime";
        aVar.nmd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[8] = "songId";
        aVar.nmd.put("songId", "INTEGER");
        stringBuilder.append(" songId INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "songName";
        aVar.nmd.put("songName", "TEXT");
        stringBuilder.append(" songName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "songSinger";
        aVar.nmd.put("songSinger", "TEXT");
        stringBuilder.append(" songSinger TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "songAlbum";
        aVar.nmd.put("songAlbum", "TEXT");
        stringBuilder.append(" songAlbum TEXT");
        stringBuilder.append(", ");
        aVar.bXK[12] = "songAlbumType";
        aVar.nmd.put("songAlbumType", "INTEGER");
        stringBuilder.append(" songAlbumType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[13] = "songAlbumUrl";
        aVar.nmd.put("songAlbumUrl", "TEXT");
        stringBuilder.append(" songAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "songHAlbumUrl";
        aVar.nmd.put("songHAlbumUrl", "TEXT");
        stringBuilder.append(" songHAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[15] = "songAlbumLocalPath";
        aVar.nmd.put("songAlbumLocalPath", "TEXT");
        stringBuilder.append(" songAlbumLocalPath TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "songWifiUrl";
        aVar.nmd.put("songWifiUrl", "TEXT");
        stringBuilder.append(" songWifiUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[17] = "songWapLinkUrl";
        aVar.nmd.put("songWapLinkUrl", "TEXT");
        stringBuilder.append(" songWapLinkUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[18] = "songWebUrl";
        aVar.nmd.put("songWebUrl", "TEXT");
        stringBuilder.append(" songWebUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[19] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[20] = "songMediaId";
        aVar.nmd.put("songMediaId", "TEXT");
        stringBuilder.append(" songMediaId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[21] = "songSnsAlbumUser";
        aVar.nmd.put("songSnsAlbumUser", "TEXT");
        stringBuilder.append(" songSnsAlbumUser TEXT");
        stringBuilder.append(", ");
        aVar.bXK[22] = "songSnsShareUser";
        aVar.nmd.put("songSnsShareUser", "TEXT");
        stringBuilder.append(" songSnsShareUser TEXT");
        stringBuilder.append(", ");
        aVar.bXK[23] = "songLyric";
        aVar.nmd.put("songLyric", "TEXT");
        stringBuilder.append(" songLyric TEXT");
        stringBuilder.append(", ");
        aVar.bXK[24] = "songBgColor";
        aVar.nmd.put("songBgColor", "INTEGER");
        stringBuilder.append(" songBgColor INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[25] = "songLyricColor";
        aVar.nmd.put("songLyricColor", "INTEGER");
        stringBuilder.append(" songLyricColor INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[26] = "songFileLength";
        aVar.nmd.put("songFileLength", "LONG");
        stringBuilder.append(" songFileLength LONG");
        stringBuilder.append(", ");
        aVar.bXK[27] = "songWifiFileLength";
        aVar.nmd.put("songWifiFileLength", "LONG");
        stringBuilder.append(" songWifiFileLength LONG");
        stringBuilder.append(", ");
        aVar.bXK[28] = "hideBanner";
        aVar.nmd.put("hideBanner", "INTEGER");
        stringBuilder.append(" hideBanner INTEGER");
        aVar.bXK[29] = "rowid";
        aVar.nme = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bOq == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.bNP = true;
                } else if (bOr == hashCode) {
                    this.field_originMusicId = cursor.getString(i);
                } else if (bOs == hashCode) {
                    this.field_musicType = cursor.getInt(i);
                } else if (bOt == hashCode) {
                    this.field_downloadedLength = cursor.getLong(i);
                } else if (bOu == hashCode) {
                    this.field_wifiDownloadedLength = cursor.getLong(i);
                } else if (bOv == hashCode) {
                    this.field_endFlag = cursor.getInt(i);
                } else if (bOw == hashCode) {
                    this.field_wifiEndFlag = cursor.getInt(i);
                } else if (bvJ == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (bOx == hashCode) {
                    this.field_songId = cursor.getInt(i);
                } else if (bOy == hashCode) {
                    this.field_songName = cursor.getString(i);
                } else if (bOz == hashCode) {
                    this.field_songSinger = cursor.getString(i);
                } else if (bOA == hashCode) {
                    this.field_songAlbum = cursor.getString(i);
                } else if (bOB == hashCode) {
                    this.field_songAlbumType = cursor.getInt(i);
                } else if (bOC == hashCode) {
                    this.field_songAlbumUrl = cursor.getString(i);
                } else if (bOD == hashCode) {
                    this.field_songHAlbumUrl = cursor.getString(i);
                } else if (bOE == hashCode) {
                    this.field_songAlbumLocalPath = cursor.getString(i);
                } else if (bOF == hashCode) {
                    this.field_songWifiUrl = cursor.getString(i);
                } else if (bOG == hashCode) {
                    this.field_songWapLinkUrl = cursor.getString(i);
                } else if (bOH == hashCode) {
                    this.field_songWebUrl = cursor.getString(i);
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bOI == hashCode) {
                    this.field_songMediaId = cursor.getString(i);
                } else if (bOJ == hashCode) {
                    this.field_songSnsAlbumUser = cursor.getString(i);
                } else if (bOK == hashCode) {
                    this.field_songSnsShareUser = cursor.getString(i);
                } else if (bOL == hashCode) {
                    this.field_songLyric = cursor.getString(i);
                } else if (bOM == hashCode) {
                    this.field_songBgColor = cursor.getInt(i);
                } else if (bON == hashCode) {
                    this.field_songLyricColor = cursor.getInt(i);
                } else if (bOO == hashCode) {
                    this.field_songFileLength = cursor.getLong(i);
                } else if (bOP == hashCode) {
                    this.field_songWifiFileLength = cursor.getLong(i);
                } else if (bOQ == hashCode) {
                    this.field_hideBanner = cursor.getInt(i) != 0;
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bNP) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.bNQ) {
            contentValues.put("originMusicId", this.field_originMusicId);
        }
        if (this.bNR) {
            contentValues.put("musicType", Integer.valueOf(this.field_musicType));
        }
        if (this.bNS) {
            contentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
        }
        if (this.bNT) {
            contentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
        }
        if (this.bNU) {
            contentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
        }
        if (this.bNV) {
            contentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
        }
        if (this.bvF) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.bNW) {
            contentValues.put("songId", Integer.valueOf(this.field_songId));
        }
        if (this.bNX) {
            contentValues.put("songName", this.field_songName);
        }
        if (this.bNY) {
            contentValues.put("songSinger", this.field_songSinger);
        }
        if (this.bNZ) {
            contentValues.put("songAlbum", this.field_songAlbum);
        }
        if (this.bOa) {
            contentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
        }
        if (this.bOb) {
            contentValues.put("songAlbumUrl", this.field_songAlbumUrl);
        }
        if (this.bOc) {
            contentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
        }
        if (this.bOd) {
            contentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
        }
        if (this.bOe) {
            contentValues.put("songWifiUrl", this.field_songWifiUrl);
        }
        if (this.bOf) {
            contentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
        }
        if (this.bOg) {
            contentValues.put("songWebUrl", this.field_songWebUrl);
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bOh) {
            contentValues.put("songMediaId", this.field_songMediaId);
        }
        if (this.bOi) {
            contentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
        }
        if (this.bOj) {
            contentValues.put("songSnsShareUser", this.field_songSnsShareUser);
        }
        if (this.bOk) {
            contentValues.put("songLyric", this.field_songLyric);
        }
        if (this.bOl) {
            contentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
        }
        if (this.bOm) {
            contentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
        }
        if (this.bOn) {
            contentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
        }
        if (this.bOo) {
            contentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
        }
        if (this.bOp) {
            contentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
