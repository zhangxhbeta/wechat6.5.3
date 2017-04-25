package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ba extends c {
    private static final int bAB = "url".hashCode();
    private static final int bIB = "ssidmd5".hashCode();
    private static final int bIC = "ssid".hashCode();
    private static final int bID = "mid".hashCode();
    private static final int bIE = "connectState".hashCode();
    private static final int bIF = "expiredTime".hashCode();
    private static final int bIG = "wifiType".hashCode();
    private static final int bIH = "action".hashCode();
    private static final int bII = "showUrl".hashCode();
    private static final int bIJ = "showWordEn".hashCode();
    private static final int bIK = "showWordCn".hashCode();
    private static final int bIL = "showWordTw".hashCode();
    private static final int bIM = "mac".hashCode();
    private static final int bIN = "verifyResult".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bAk = true;
    private boolean bIA = true;
    private boolean bIo = true;
    private boolean bIp = true;
    private boolean bIq = true;
    private boolean bIr = true;
    private boolean bIs = true;
    private boolean bIt = true;
    private boolean bIu = true;
    private boolean bIv = true;
    private boolean bIw = true;
    private boolean bIx = true;
    private boolean bIy = true;
    private boolean bIz = true;
    public int field_action;
    public int field_connectState;
    public long field_expiredTime;
    public String field_mac;
    public String field_mid;
    public String field_showUrl;
    public String field_showWordCn;
    public String field_showWordEn;
    public String field_showWordTw;
    public String field_ssid;
    public String field_ssidmd5;
    public String field_url;
    public int field_verifyResult;
    public int field_wifiType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bIB == hashCode) {
                    this.field_ssidmd5 = cursor.getString(i);
                    this.bIo = true;
                } else if (bIC == hashCode) {
                    this.field_ssid = cursor.getString(i);
                } else if (bID == hashCode) {
                    this.field_mid = cursor.getString(i);
                } else if (bAB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (bIE == hashCode) {
                    this.field_connectState = cursor.getInt(i);
                } else if (bIF == hashCode) {
                    this.field_expiredTime = cursor.getLong(i);
                } else if (bIG == hashCode) {
                    this.field_wifiType = cursor.getInt(i);
                } else if (bIH == hashCode) {
                    this.field_action = cursor.getInt(i);
                } else if (bII == hashCode) {
                    this.field_showUrl = cursor.getString(i);
                } else if (bIJ == hashCode) {
                    this.field_showWordEn = cursor.getString(i);
                } else if (bIK == hashCode) {
                    this.field_showWordCn = cursor.getString(i);
                } else if (bIL == hashCode) {
                    this.field_showWordTw = cursor.getString(i);
                } else if (bIM == hashCode) {
                    this.field_mac = cursor.getString(i);
                } else if (bIN == hashCode) {
                    this.field_verifyResult = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bIo) {
            contentValues.put("ssidmd5", this.field_ssidmd5);
        }
        if (this.bIp) {
            contentValues.put("ssid", this.field_ssid);
        }
        if (this.bIq) {
            contentValues.put("mid", this.field_mid);
        }
        if (this.bAk) {
            contentValues.put("url", this.field_url);
        }
        if (this.bIr) {
            contentValues.put("connectState", Integer.valueOf(this.field_connectState));
        }
        if (this.bIs) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.bIt) {
            contentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
        }
        if (this.bIu) {
            contentValues.put("action", Integer.valueOf(this.field_action));
        }
        if (this.bIv) {
            contentValues.put("showUrl", this.field_showUrl);
        }
        if (this.bIw) {
            contentValues.put("showWordEn", this.field_showWordEn);
        }
        if (this.bIx) {
            contentValues.put("showWordCn", this.field_showWordCn);
        }
        if (this.bIy) {
            contentValues.put("showWordTw", this.field_showWordTw);
        }
        if (this.bIz) {
            contentValues.put("mac", this.field_mac);
        }
        if (this.bIA) {
            contentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
