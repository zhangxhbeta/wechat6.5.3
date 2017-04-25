package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c {
    private String aST = SQLiteDatabase.KeyEmpty;
    private RandomAccessFile diw = null;

    public static class a {
        public int aUT = 0;
        public byte[] buf = null;
        public int dik = 0;
        public int ret = 0;
    }

    public c(String str) {
        this.aST = str;
    }

    public static int le(String str) {
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
    }

    public final void Lr() {
        if (this.diw != null) {
            try {
                this.diw.close();
                this.diw = null;
                v.d("MicroMsg.SpxFileOperator", "Close :" + this.aST);
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
        v.d("MicroMsg.SpxFileOperator", "Open file:" + this.diw + " mode:" + str);
        try {
            this.diw = new RandomAccessFile(this.aST, str);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.aST + "] failed:[" + e.getMessage() + "]");
            this.diw = null;
            return false;
        }
    }

    public final a rn(int i) {
        a aVar = new a();
        if (i < 0) {
            aVar.ret = -3;
        } else if (this.diw != null || lv("r")) {
            aVar.buf = new byte[6000];
            try {
                long length = this.diw.length();
                this.diw.seek((long) i);
                int read = this.diw.read(aVar.buf, 0, 6000);
                v.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.aST + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.diw.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                aVar.aUT = read;
                aVar.dik = read + i;
                aVar.ret = 0;
            } catch (Exception e) {
                v.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.aST + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                Lr();
                aVar.ret = -1;
            }
        } else {
            aVar.ret = -2;
        }
        return aVar;
    }
}
