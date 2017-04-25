package com.tencent.mm.as;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class n {
    public String aST = SQLiteDatabase.KeyEmpty;
    public int bkU = -1;
    public String ble = SQLiteDatabase.KeyEmpty;
    public long bmL = 0;
    public String bnY = SQLiteDatabase.KeyEmpty;
    public String bov = SQLiteDatabase.KeyEmpty;
    public int cFX = 0;
    String clientId = SQLiteDatabase.KeyEmpty;
    public int cyu = 0;
    public int dgC = 0;
    public String dgk = SQLiteDatabase.KeyEmpty;
    public long dgv = 0;
    public String dhC = SQLiteDatabase.KeyEmpty;
    public int dhE = 0;
    int dhF = 0;
    public int dhG = 0;
    public long dhH = 0;
    public long dhI = 0;
    public long dhJ = 0;
    public int dhK = 0;
    public int dhL = 0;
    public int dhM = 0;
    private int dhN = 0;
    public int dhO = 0;
    public int dhP = 0;
    public String dhQ = SQLiteDatabase.KeyEmpty;
    public int dhR = 0;
    public String dhS = SQLiteDatabase.KeyEmpty;
    public ayk dhT = new ayk();
    public ahn dhU = new ahn();
    public int status = 0;

    public static String kY(String str) {
        try {
            Map q = bf.q(str, "msg");
            if (q != null) {
                return (String) q.get(".msg.videomsg.$cdnvideourl");
            }
        } catch (Exception e) {
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final void b(Cursor cursor) {
        this.aST = cursor.getString(0);
        this.clientId = cursor.getString(1);
        this.bmL = cursor.getLong(2);
        this.dgC = cursor.getInt(3);
        this.dhE = cursor.getInt(4);
        this.cyu = cursor.getInt(5);
        this.dhF = cursor.getInt(6);
        this.dhG = cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.dhH = cursor.getLong(9);
        this.dhI = cursor.getLong(10);
        this.dhJ = cursor.getLong(11);
        this.dhK = cursor.getInt(12);
        this.dhL = cursor.getInt(13);
        this.dhM = cursor.getInt(14);
        this.dhN = cursor.getInt(15);
        this.ble = cursor.getString(16);
        this.dhC = cursor.getString(17);
        this.dhO = cursor.getInt(18);
        this.dhP = cursor.getInt(19);
        this.dgk = cursor.getString(20);
        this.dhQ = cursor.getString(21);
        this.dhR = cursor.getInt(22);
        this.dgv = cursor.getLong(23);
        this.dhS = cursor.getString(24);
        this.bov = cursor.getString(25);
        byte[] blob = cursor.getBlob(26);
        this.dhT = new ayk();
        try {
            this.dhT.az(blob);
        } catch (Throwable e) {
            v.a("MicroMsg.VideoInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        this.bnY = cursor.getString(27);
        this.cFX = cursor.getInt(28);
        blob = cursor.getBlob(29);
        this.dhU = new ahn();
        try {
            this.dhU.az(blob);
        } catch (Throwable e2) {
            v.a("MicroMsg.VideoInfo", e2, "setmmsightextinfo error", new Object[0]);
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("filename", getFileName());
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("clientid", this.clientId == null ? SQLiteDatabase.KeyEmpty : this.clientId);
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("msgsvrid", Long.valueOf(this.bmL));
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("netoffset", Integer.valueOf(this.dgC));
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("filenowsize", Integer.valueOf(this.dhE));
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.cyu));
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("thumbnetoffset", Integer.valueOf(this.dhF));
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("thumblen", Integer.valueOf(this.dhG));
        }
        if ((this.bkU & FileUtils.S_IRUSR) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("createtime", Long.valueOf(this.dhH));
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("lastmodifytime", Long.valueOf(this.dhI));
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("downloadtime", Long.valueOf(this.dhJ));
        }
        if ((this.bkU & 4096) != 0) {
            contentValues.put("videolength", Integer.valueOf(this.dhK));
        }
        if ((this.bkU & 8192) != 0) {
            contentValues.put("msglocalid", Integer.valueOf(this.dhL));
        }
        if ((this.bkU & 16384) != 0) {
            contentValues.put("nettimes", Integer.valueOf(this.dhM));
        }
        if ((this.bkU & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("cameratype", Integer.valueOf(this.dhN));
        }
        if ((this.bkU & 65536) != 0) {
            contentValues.put("user", Ld());
        }
        if ((this.bkU & 131072) != 0) {
            contentValues.put("human", Le());
        }
        if ((this.bkU & 262144) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.dhO));
        }
        if ((this.bkU & 524288) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.dhP));
        }
        if ((this.bkU & 1048576) != 0) {
            contentValues.put("reserved3", Lf());
        }
        if ((this.bkU & 2097152) != 0) {
            contentValues.put("reserved4", Lg());
        }
        if ((this.bkU & 4194304) != 0) {
            contentValues.put("videofuncflag", Integer.valueOf(this.dhR));
        }
        if ((this.bkU & 8388608) != 0) {
            contentValues.put("masssendid", Long.valueOf(this.dgv));
        }
        if ((this.bkU & 16777216) != 0) {
            contentValues.put("masssendlist", this.dhS);
        }
        if ((this.bkU & 33554432) != 0) {
            contentValues.put("videomd5", this.bov);
        }
        if ((this.bkU & 67108864) != 0) {
            contentValues.put("streamvideo", Lc());
        }
        if ((this.bkU & 134217728) != 0) {
            contentValues.put("statextstr", this.bnY);
        }
        if ((this.bkU & SQLiteDatabase.CREATE_IF_NECESSARY) != 0) {
            contentValues.put("downloadscene", Integer.valueOf(this.cFX));
        }
        if ((this.bkU & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            contentValues.put("mmsightextinfo", Li());
        }
        return contentValues;
    }

    private byte[] Lc() {
        byte[] bArr = new byte[0];
        try {
            bArr = this.dhT.toByteArray();
        } catch (Throwable e) {
            v.a("MicroMsg.VideoInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return bArr;
    }

    public final void gw(int i) {
        this.bkU = 1280;
    }

    public final String getFileName() {
        return this.aST == null ? SQLiteDatabase.KeyEmpty : this.aST;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String Ld() {
        return this.ble == null ? SQLiteDatabase.KeyEmpty : this.ble;
    }

    public final String Le() {
        return this.dhC == null ? SQLiteDatabase.KeyEmpty : this.dhC;
    }

    public final String Lf() {
        return this.dgk == null ? SQLiteDatabase.KeyEmpty : this.dgk;
    }

    public final String Lg() {
        return this.dhQ == null ? SQLiteDatabase.KeyEmpty : this.dhQ;
    }

    public final boolean Lh() {
        if (this.status == 199 || this.status == 199) {
            return true;
        }
        return false;
    }

    private byte[] Li() {
        byte[] bArr = new byte[0];
        try {
            bArr = this.dhU.toByteArray();
        } catch (Throwable e) {
            v.a("MicroMsg.VideoInfo", e, "getmmsightextinfo error", new Object[0]);
        }
        return bArr;
    }
}
