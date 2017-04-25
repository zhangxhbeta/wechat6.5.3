package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class p {
    public String aST = SQLiteDatabase.KeyEmpty;
    int bNn = 0;
    String bNo = SQLiteDatabase.KeyEmpty;
    public int bkU = -1;
    public String ble = SQLiteDatabase.KeyEmpty;
    public long bmL = 0;
    int cQM = 0;
    public String clientId = SQLiteDatabase.KeyEmpty;
    public int cyu = 0;
    public int dgC = 0;
    public String dhC = SQLiteDatabase.KeyEmpty;
    public int dhE = 0;
    public long dhH = 0;
    public long dhI = 0;
    public int dhL = 0;
    int dhM = 0;
    int diF = 0;
    String diy = SQLiteDatabase.KeyEmpty;
    public int djF = 0;
    long djG = 0;
    public int status = 0;

    public final boolean LC() {
        if (this.status == 5 || this.status == 6) {
            return true;
        }
        return false;
    }

    public final boolean LD() {
        if ((this.status <= 1 || this.status > 3) && this.status != 8) {
            return false;
        }
        return true;
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("FileName", this.aST);
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("User", this.ble);
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("MsgId", Long.valueOf(this.bmL));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("NetOffset", Integer.valueOf(this.dgC));
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("FileNowSize", Integer.valueOf(this.dhE));
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("TotalLen", Integer.valueOf(this.cyu));
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("Status", Integer.valueOf(this.status));
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("CreateTime", Long.valueOf(this.dhH));
        }
        if ((this.bkU & FileUtils.S_IRUSR) != 0) {
            contentValues.put("LastModifyTime", Long.valueOf(this.dhI));
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("ClientId", this.clientId);
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("VoiceLength", Integer.valueOf(this.djF));
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("MsgLocalId", Integer.valueOf(this.dhL));
        }
        if ((this.bkU & 4096) != 0) {
            contentValues.put("Human", this.dhC);
        }
        if ((this.bkU & 8192) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.dhM));
        }
        if ((this.bkU & 16384) != 0) {
            contentValues.put("reserved2", this.diy);
        }
        if ((this.bkU & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("MsgSource", this.bNo);
        }
        if ((this.bkU & 65536) != 0) {
            contentValues.put("MsgFlag", Integer.valueOf(this.bNn));
        }
        if ((this.bkU & 131072) != 0) {
            contentValues.put("MsgSeq", Integer.valueOf(this.cQM));
        }
        if ((this.bkU & 262144) != 0) {
            contentValues.put("MasterBufId", Long.valueOf(this.djG));
        }
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.aST = cursor.getString(0);
        this.ble = cursor.getString(1);
        this.bmL = cursor.getLong(2);
        this.dgC = cursor.getInt(3);
        this.dhE = cursor.getInt(4);
        this.cyu = cursor.getInt(5);
        this.status = cursor.getInt(6);
        this.dhH = cursor.getLong(7);
        this.dhI = cursor.getLong(8);
        this.clientId = cursor.getString(9);
        this.djF = cursor.getInt(10);
        this.dhL = cursor.getInt(11);
        this.dhC = cursor.getString(12);
        this.dhM = cursor.getInt(13);
        this.diy = cursor.getString(14);
        this.bNo = cursor.getString(15);
        this.bNn = cursor.getInt(16);
        this.cQM = cursor.getInt(17);
        this.djG = cursor.getLong(18);
    }
}
