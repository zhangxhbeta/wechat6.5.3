package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a implements b {
    private String aST = SQLiteDatabase.KeyEmpty;
    private RandomAccessFile diw = null;

    public a(String str) {
        this.aST = str;
    }

    public final void Lr() {
        if (this.diw != null) {
            try {
                this.diw.close();
                this.diw = null;
                v.d("MicroMsg.AmrFileOperator", "Close :" + this.aST);
            } catch (IOException e) {
            }
        }
    }

    private boolean lv(String str) {
        boolean z;
        Assert.assertTrue(this.aST.length() >= 0);
        if (this.diw == null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (str.equals("r") || str.equals("rw")) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        v.d("MicroMsg.AmrFileOperator", "Open file:" + this.diw + " mode:" + str);
        try {
            this.diw = new RandomAccessFile(this.aST, str);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.aST + "] failed:[" + e.getMessage() + "]");
            this.diw = null;
            return false;
        }
    }

    public final g aU(int i, int i2) {
        g gVar = new g();
        if (i < 0 || i2 <= 0) {
            gVar.ret = -3;
        } else if (this.diw != null || lv("r")) {
            int i3 = i + 6;
            gVar.buf = new byte[i2];
            try {
                long length = this.diw.length();
                this.diw.seek((long) i3);
                int read = this.diw.read(gVar.buf, 0, i2);
                v.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.aST + "] readOffset:" + i3 + " readRet:" + read + " fileNow:" + this.diw.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.aUT = read;
                gVar.dik = (read + i3) - 6;
                gVar.ret = 0;
            } catch (Exception e) {
                v.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.aST + "] Offset:" + i3 + "  failed:[" + e.getMessage() + "] ");
                Lr();
                gVar.ret = -1;
            }
        } else {
            gVar.ret = -2;
        }
        return gVar;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.diw == null && !lv("rw")) {
            return -1;
        }
        if (i2 == 0) {
            try {
                this.diw.write("#!AMR\n".getBytes(), 0, 6);
            } catch (Exception e) {
                v.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.aST + "] failed:[" + e.getMessage() + "]");
                Lr();
                return -2;
            }
        }
        int i3 = i2 + 6;
        try {
            this.diw.seek((long) i3);
            this.diw.write(bArr, 0, i);
            i3 += i;
            if (((int) this.diw.getFilePointer()) == i3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            int i4 = i3 - 6;
            if (i4 < 0) {
                z = false;
            }
            Assert.assertTrue(z);
            return i4;
        } catch (Exception e2) {
            v.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.aST + "] Offset:" + i3 + " failed:[" + e2.getMessage() + "]");
            Lr();
            return -3;
        }
    }

    public final int getFormat() {
        return 0;
    }
}
