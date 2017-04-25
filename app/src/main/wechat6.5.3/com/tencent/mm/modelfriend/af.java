package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class af {
    int bkU = -1;
    public long cIA = 0;
    public int cIB = 0;
    int cIC = 0;
    public String cID = SQLiteDatabase.KeyEmpty;
    String cIE = SQLiteDatabase.KeyEmpty;
    String cIF = SQLiteDatabase.KeyEmpty;
    String cIG = SQLiteDatabase.KeyEmpty;
    String cIH = SQLiteDatabase.KeyEmpty;
    String cII = SQLiteDatabase.KeyEmpty;
    public String cIJ = SQLiteDatabase.KeyEmpty;
    String cIK = SQLiteDatabase.KeyEmpty;
    String cIL = SQLiteDatabase.KeyEmpty;
    public int cyA = 0;
    String cyx = SQLiteDatabase.KeyEmpty;
    String cyy = SQLiteDatabase.KeyEmpty;
    public int cyz = 0;
    public String username = SQLiteDatabase.KeyEmpty;

    public final void b(Cursor cursor) {
        this.cIA = cursor.getLong(0);
        int i = cursor.getInt(1);
        if (i == 65536) {
            this.cIB = 0;
        } else {
            this.cIB = i;
        }
        this.cIC = cursor.getInt(2);
        this.username = cursor.getString(3);
        this.cID = cursor.getString(4);
        this.cIE = cursor.getString(5);
        this.cIF = cursor.getString(6);
        this.cIG = cursor.getString(7);
        this.cIH = cursor.getString(8);
        this.cII = cursor.getString(9);
        this.cIJ = cursor.getString(10);
        this.cIK = cursor.getString(11);
        this.cIL = cursor.getString(12);
        this.cyx = cursor.getString(13);
        this.cyy = cursor.getString(14);
        this.cyz = cursor.getInt(15);
        this.cyA = cursor.getInt(16);
    }

    public final ContentValues FB() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("qq", Long.valueOf(this.cIA));
        }
        if ((this.bkU & 2) != 0) {
            int i = this.cIB;
            if (i == 0) {
                contentValues.put("wexinstatus", Integer.valueOf(65536));
            } else {
                contentValues.put("wexinstatus", Integer.valueOf(i));
            }
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("groupid", Integer.valueOf(this.cIC));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("nickname", FC());
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("pyinitial", this.cIE == null ? SQLiteDatabase.KeyEmpty : this.cIE);
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("quanpin", this.cIF == null ? SQLiteDatabase.KeyEmpty : this.cIF);
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("qqnickname", FD());
        }
        if ((this.bkU & FileUtils.S_IRUSR) != 0) {
            contentValues.put("qqpyinitial", FE());
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("qqquanpin", FF());
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("qqremark", FG());
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("qqremarkpyinitial", FH());
        }
        if ((this.bkU & 4096) != 0) {
            contentValues.put("qqremarkquanpin", FI());
        }
        if ((this.bkU & 16384) != 0) {
            contentValues.put("reserved2", this.cyy == null ? SQLiteDatabase.KeyEmpty : this.cyy);
        }
        if ((this.bkU & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.cyz));
        }
        if ((this.bkU & 65536) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.cyA));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }

    public final String FC() {
        return this.cID == null ? SQLiteDatabase.KeyEmpty : this.cID;
    }

    public final String FD() {
        return this.cIG == null ? SQLiteDatabase.KeyEmpty : this.cIG;
    }

    public final String FE() {
        return this.cIH == null ? SQLiteDatabase.KeyEmpty : this.cIH;
    }

    public final String FF() {
        return this.cII == null ? SQLiteDatabase.KeyEmpty : this.cII;
    }

    public final String FG() {
        return this.cIJ == null ? SQLiteDatabase.KeyEmpty : this.cIJ;
    }

    public final String FH() {
        return this.cIK == null ? SQLiteDatabase.KeyEmpty : this.cIK;
    }

    public final String FI() {
        return this.cIL == null ? SQLiteDatabase.KeyEmpty : this.cIL;
    }

    public final String getDisplayName() {
        if (FG() == null || FG().length() <= 0) {
            return FD();
        }
        return FG();
    }

    public final void FJ() {
        this.cyz |= 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("groupID\t:").append(this.cIC).append("\n");
        stringBuilder.append("qq\t:").append(this.cIA).append("\n");
        stringBuilder.append("username\t:").append(this.username).append("\n");
        stringBuilder.append("nickname\t:").append(this.cID).append("\n");
        stringBuilder.append("wexinStatus\t:").append(this.cIB).append("\n");
        stringBuilder.append("reserved3\t:").append(this.cyz).append("\n");
        stringBuilder.append("reserved4\t:").append(this.cyA).append("\n");
        return stringBuilder.toString();
    }
}
