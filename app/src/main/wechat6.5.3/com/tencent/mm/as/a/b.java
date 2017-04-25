package com.tencent.mm.as.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class b {
    public long dfL = -1;
    public long dfM = -1;
    public a dfN = null;

    public final long kQ(String str) {
        InputStream fileInputStream;
        Throwable e;
        Throwable th;
        long j = -1;
        if (d.kS(str)) {
            v.w("MicroMsg.AtomParsers", "calc moov atom location but filepath is null.");
        } else {
            File file = new File(str);
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    this.dfM = file.length();
                    a h = h(fileInputStream);
                    if (h == null) {
                        v.w("MicroMsg.AtomParsers", "has no atom, this file may be not mp4");
                    } else if (h.KG()) {
                        j = h.dfK;
                    } else if (h.KH()) {
                        v.w("MicroMsg.AtomParsers", "it is the final atom, but can not find moov atom.");
                    } else if (h.getSize() > 0) {
                        j = h.KI();
                    }
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.AtomParsers", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        v.a("MicroMsg.AtomParsers", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e22) {
                                v.a("MicroMsg.AtomParsers", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                        this.dfL = j;
                        v.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j + " file length : " + (file.length() / 1024) + " K file path: " + str);
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                v.a("MicroMsg.AtomParsers", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                fileInputStream = null;
                v.a("MicroMsg.AtomParsers", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.dfL = j;
                v.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j + " file length : " + (file.length() / 1024) + " K file path: " + str);
                return j;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            this.dfL = j;
            v.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j + " file length : " + (file.length() / 1024) + " K file path: " + str);
        }
        return j;
    }

    private a h(InputStream inputStream) {
        Throwable e;
        if (0 < 0) {
            v.w("MicroMsg.AtomParsers", "find Moov Atom, but parameter is error.");
            return null;
        }
        a aVar = null;
        a aVar2;
        try {
            if (inputStream.skip(0) < 0) {
                return null;
            }
            long j = 0;
            byte[] bArr = new byte[8];
            int read = inputStream.read(bArr, 0, 8);
            while (read >= 8) {
                try {
                    int k = d.k(bArr, 0);
                    int k2 = d.k(bArr, 4);
                    long j2 = 0;
                    if (k == 1) {
                        if (inputStream.read(bArr, 0, 8) < 8) {
                            break;
                        }
                        j2 = d.D(bArr);
                    }
                    this.dfN = aVar;
                    aVar2 = new a(k, j, k2, j2);
                    try {
                        if (aVar2.KG() || aVar2.KH()) {
                            return aVar2;
                        }
                        long j3;
                        if (k > 1) {
                            j3 = (long) (k - 8);
                            j += (long) k;
                        } else if (j2 <= 0) {
                            return aVar2;
                        } else {
                            j += j2;
                            j3 = (j2 - 8) - 8;
                        }
                        if (inputStream.skip(j3) < j3) {
                            return aVar2;
                        }
                        aVar = aVar2;
                        read = inputStream.read(bArr, 0, 8);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable e3) {
                    e = e3;
                    aVar2 = aVar;
                }
            }
            return aVar;
        } catch (Throwable e32) {
            e = e32;
            aVar2 = null;
            v.a("MicroMsg.AtomParsers", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return aVar2;
        }
    }
}
