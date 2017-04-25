package com.tencent.mm.model;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class bs {
    public static boolean cvI = false;
    private static bs cvL = null;
    private ArrayList<String> cvJ = new ArrayList();
    private String cvK = SQLiteDatabase.KeyEmpty;

    public bs(String str, boolean z) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        try {
            String format;
            this.cvK = str + "version_history.cfg";
            randomAccessFile = new RandomAccessFile(this.cvK, "rw");
            long length = randomAccessFile.length();
            v.i("MicroMsg.VersionHistory", "init fileLen:%d isNewAcc:%b curVer:0x%x path:%s", Long.valueOf(length), Boolean.valueOf(z), Integer.valueOf(d.lWh), this.cvK);
            if (length <= 0 || length > 10240) {
                randomAccessFile.seek(0);
                if (!z) {
                    format = String.format("%x", new Object[]{Integer.valueOf(536870913)});
                    randomAccessFile.write((format + "\n").getBytes());
                    this.cvJ.add(format);
                }
            } else {
                while (randomAccessFile.getFilePointer() < length) {
                    format = be.ah(randomAccessFile.readLine(), SQLiteDatabase.KeyEmpty);
                    if (format.length() != 8) {
                        v.e("MicroMsg.VersionHistory", "Read ver history failed , line len:%d path:%s", Integer.valueOf(format.length()), this.cvK);
                    } else {
                        try {
                            if (format.startsWith("2")) {
                                this.cvJ.add(format);
                            } else {
                                v.e("MicroMsg.VersionHistory", "Read ver history failed , line:%s %s", format, this.cvK);
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                }
            }
            format = String.format("%x", new Object[]{Integer.valueOf(d.lWh)});
            if (this.cvJ.size() == 0 || !format.equals(this.cvJ.get(this.cvJ.size() - 1))) {
                cvI = true;
                this.cvJ.add(format);
                randomAccessFile.seek(length);
                randomAccessFile.write((format + "\n").getBytes());
            }
            format = SQLiteDatabase.KeyEmpty;
            int i = 0;
            while (i < this.cvJ.size()) {
                String str2 = format + ((String) this.cvJ.get(i)) + ";";
                i++;
                format = str2;
            }
            v.i("MicroMsg.VersionHistory", "Read succ isupdate:%b ver:%s file:%s", Boolean.valueOf(cvI), format, this.cvK);
            try {
                randomAccessFile.close();
            } catch (Throwable e3) {
                v.a("MicroMsg.VersionHistory", e3, "Close Version History file failed.", SQLiteDatabase.KeyEmpty);
            }
        } catch (Exception e4) {
            e3 = e4;
            randomAccessFile = null;
            try {
                v.a("MicroMsg.VersionHistory", e3, "Open Version History file failed.", SQLiteDatabase.KeyEmpty);
                try {
                    randomAccessFile.close();
                } catch (Throwable e32) {
                    v.a("MicroMsg.VersionHistory", e32, "Close Version History file failed.", SQLiteDatabase.KeyEmpty);
                }
                if (cvL != null) {
                    return;
                }
                return;
            } catch (Throwable th) {
                e32 = th;
                try {
                    randomAccessFile.close();
                } catch (Throwable e5) {
                    v.a("MicroMsg.VersionHistory", e5, "Close Version History file failed.", SQLiteDatabase.KeyEmpty);
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            randomAccessFile = null;
            randomAccessFile.close();
            throw e32;
        }
        if (cvL != null && cvL != this && cvL.cvJ.size() < this.cvJ.size()) {
            cvL.cvJ = this.cvJ;
            j.n(this.cvK, cvL.cvK, false);
        }
    }

    public static void fZ(String str) {
        cvL = new bs(str, true);
    }

    public static String Af() {
        if (cvL == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        bs bsVar = cvL;
        String str = SQLiteDatabase.KeyEmpty;
        String str2 = str;
        for (int size = 4 >= bsVar.cvJ.size() ? 0 : bsVar.cvJ.size() - 4; size < bsVar.cvJ.size(); size++) {
            str2 = str2 + ((String) bsVar.cvJ.get(size)) + ";";
        }
        return str2;
    }
}
