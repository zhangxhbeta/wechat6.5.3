package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ax {
    public int bkU;
    public String name;
    public a nwC;
    public int nwD;
    public int status;

    public static class a {
        private String ble;
        private String bsI;

        public a(String str) {
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.ble = str.substring(0, indexOf);
                this.bsI = str.substring(indexOf);
                return;
            }
            this.ble = str;
            this.bsI = SQLiteDatabase.KeyEmpty;
        }

        public final String Nq(String str) {
            return this.bsI != null ? this.bsI : str;
        }
    }

    public ax() {
        this.bkU = 135;
        this.name = SQLiteDatabase.KeyEmpty;
        this.nwC = null;
        this.nwC = null;
        this.name = SQLiteDatabase.KeyEmpty;
        this.status = 0;
        this.nwD = 0;
    }

    public ax(String str, boolean z, int i) {
        this.bkU = 135;
        this.name = SQLiteDatabase.KeyEmpty;
        this.nwC = null;
        this.nwC = new a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.nwD = i;
    }

    public final void dN(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean aeX() {
        return (this.status & 1) != 0;
    }

    public final boolean bxf() {
        return (this.status & 2) != 0;
    }

    public final void b(Cursor cursor) {
        if ((this.bkU & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.nwC == null) {
                this.nwC = new a(this.name);
            }
        }
        if ((this.bkU & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            this.nwD = cursor.getInt(7);
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.nwD));
        }
        return contentValues;
    }
}
