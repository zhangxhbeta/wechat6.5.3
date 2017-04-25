package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class o {
    private int cGY;
    long dhH;
    public int jBI;
    private long jCm;
    public int jCn;
    public String jCo;
    private int jCp;
    private long jCq;
    public String jCr;
    public byte[] jCs;
    public int offset;
    public int type;
    private String userName;

    public final ContentValues aVb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqId", Long.valueOf(this.jCm));
        contentValues.put(Columns.TYPE, Integer.valueOf(this.type));
        contentValues.put("createTime", Long.valueOf(this.dhH));
        contentValues.put("userName", this.userName);
        contentValues.put("totallen", Integer.valueOf(this.jCn));
        contentValues.put("offset", Integer.valueOf(this.offset));
        contentValues.put("local_flag", Integer.valueOf(this.cGY));
        contentValues.put("tmp_path", this.jCo);
        contentValues.put("nums", Integer.valueOf(this.jCp));
        contentValues.put("try_times", Long.valueOf(this.jCq));
        contentValues.put("StrId", this.jCr);
        contentValues.put("upload_buf", this.jCs);
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.jBI = cursor.getInt(0);
        long j = cursor.getLong(1);
        this.jCm = j;
        this.jCr = i.cE(j);
        this.type = cursor.getInt(2);
        this.dhH = cursor.getLong(3);
        this.userName = cursor.getString(4);
        this.jCn = cursor.getInt(5);
        this.offset = cursor.getInt(6);
        this.cGY = cursor.getInt(7);
        this.jCo = cursor.getString(8);
        this.jCp = cursor.getInt(9);
        this.jCq = cursor.getLong(10);
        this.jCr = cursor.getString(11);
        this.jCs = cursor.getBlob(12);
    }

    public final void aVc() {
        this.cGY |= 4;
    }

    public final void aVd() {
        this.cGY &= -5;
    }
}
