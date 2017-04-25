package com.tencent.mm.as.a;

import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.RandomAccessFile;

public final class f {
    private long dfR;
    private long dfS;
    private long dfV;
    private long[] dfW;
    public int dfX;
    private String filePath;

    public final boolean a(int i, int i2, PInt pInt, PInt pInt2) {
        if (i < 0) {
            i = 0;
        }
        int length = this.dfW.length;
        if (i >= length || i2 >= length) {
            i = length - 2;
            i2 = length - 1;
        }
        long j = this.dfW[i];
        long j2 = this.dfW[i2];
        if (i == 0) {
            pInt.value = 0;
            pInt2.value = (int) j2;
        } else {
            pInt.value = (int) j;
            pInt2.value = ((int) j2) - ((int) j);
        }
        return true;
    }

    public final int aR(int i, int i2) {
        int i3 = 0;
        if (this.dfW == null) {
            return 0;
        }
        long j = (long) (i + i2);
        int i4 = 0;
        while (i3 < this.dfW.length) {
            if (this.dfW[i3] == j) {
                i4 = i3;
                break;
            }
            if (this.dfW[i3] >= j) {
                if (this.dfW[i3] > j) {
                    break;
                }
            } else {
                i4 = i3;
            }
            i3++;
        }
        return i4;
    }

    public final boolean k(String str, long j) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        RandomAccessFile randomAccessFile2;
        this.filePath = null;
        this.dfW = null;
        this.dfX = 0;
        this.dfS = 0;
        this.dfR = 0;
        this.dfV = 0;
        this.filePath = str;
        this.dfV = j;
        File file = new File(this.filePath);
        if (!file.exists()) {
            return false;
        }
        try {
            byte[] bArr = new byte[8];
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                a a = a(randomAccessFile, bArr, this.dfV);
                while (a != null) {
                    v.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + a.dfK);
                    e b = h.b(randomAccessFile, bArr);
                    if (b == null || !b.a(randomAccessFile, bArr)) {
                        v.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
                        a = null;
                    } else {
                        int i;
                        if (b.dfT == ((long) e.dfO)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            long KI = a.KI() - randomAccessFile.getFilePointer();
                            v.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: " + KI);
                            a = a(randomAccessFile, bArr, KI);
                        } else {
                            this.dfR = b.dfR;
                            this.dfS = b.dfS;
                            v.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.dfR + " duration: " + this.dfS);
                            randomAccessFile.seek(b.dfU);
                            g gVar = (g) d.a(randomAccessFile, bArr, a.deM);
                            if (gVar != null) {
                                gVar.dfS = this.dfS;
                                gVar.dfR = this.dfR;
                                gVar.b(randomAccessFile);
                                this.dfW = gVar.dfW;
                                this.dfX = this.dfW.length - 2;
                            }
                        }
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable e2) {
                    v.a("MicroMsg.Mp4Parser", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                randomAccessFile2 = randomAccessFile;
            } catch (Throwable th) {
                e2 = th;
            }
        } catch (Exception e4) {
            e2 = e4;
            randomAccessFile2 = null;
            try {
                v.a("MicroMsg.Mp4Parser", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e2.toString());
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.Mp4Parser", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e5) {
                        v.a("MicroMsg.Mp4Parser", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th3) {
            e22 = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e22;
        }
    }

    private static h a(RandomAccessFile randomAccessFile, byte[] bArr, long j) {
        v.d("MicroMsg.Mp4Parser", "start to find trak atom.");
        if (d.a(randomAccessFile, j)) {
            return (h) d.a(randomAccessFile, bArr, a.deJ);
        }
        return null;
    }
}
