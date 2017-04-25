package com.tencent.mm.u;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class h {
    public int bBY = 0;
    public int bkU = -1;
    int cyB = 0;
    public String cyC = SQLiteDatabase.KeyEmpty;
    public String cyD = SQLiteDatabase.KeyEmpty;
    private int cyE = 0;
    int cyF = 0;
    public String username = SQLiteDatabase.KeyEmpty;

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.bBY = cursor.getInt(1);
        this.cyB = cursor.getInt(2);
        this.cyD = cursor.getString(3);
        this.cyC = cursor.getString(4);
        this.cyE = cursor.getInt(5);
        this.cyF = cursor.getInt(6);
    }

    public final ContentValues Bd() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("imgflag", Integer.valueOf(this.bBY));
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("lastupdatetime", Integer.valueOf(this.cyB));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("reserved1", Be());
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("reserved2", Bf());
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.cyE));
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.cyF));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }

    public final String Be() {
        return this.cyD == null ? SQLiteDatabase.KeyEmpty : this.cyD;
    }

    public final String Bf() {
        return this.cyC == null ? SQLiteDatabase.KeyEmpty : this.cyC;
    }

    public final void aP(boolean z) {
        this.cyE = z ? 1 : 0;
    }

    public final void Bg() {
        this.cyF = (int) (be.Nh() / 60);
        this.bkU |= 64;
    }
}
