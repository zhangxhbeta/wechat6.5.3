package com.tencent.mm.as.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class d {
    public static boolean kR(String str) {
        Throwable e;
        if (kS(str)) {
            return false;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8];
                if (fileInputStream.read(bArr, 0, 8) < 8) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e2) {
                        v.a("MicroMsg.AtomUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                }
                int k = k(bArr, 0);
                if (k(bArr, 4) != a.dej || k <= 0) {
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.AtomUtil", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e222) {
                    v.a("MicroMsg.AtomUtil", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e222 = e3;
                try {
                    v.a("MicroMsg.AtomUtil", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (fileInputStream != null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (Throwable e2222) {
                        v.a("MicroMsg.AtomUtil", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e2222 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.AtomUtil", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    throw e2222;
                }
            }
        } catch (Exception e5) {
            e2222 = e5;
            fileInputStream = null;
            v.a("MicroMsg.AtomUtil", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (fileInputStream != null) {
                return false;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th2) {
            e2222 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e2222;
        }
    }

    public static boolean kS(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int kT(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i2 = (i2 << 8) | str.charAt(i);
            i++;
        }
        return i2;
    }

    public static int k(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((((bArr[i2] & WebView.NORMAL_MODE_ALPHA) << 16) | ((bArr[i] & WebView.NORMAL_MODE_ALPHA) << 24)) | ((bArr[i3] & WebView.NORMAL_MODE_ALPHA) << 8)) | (bArr[i3 + 1] & WebView.NORMAL_MODE_ALPHA);
    }

    public static long l(byte[] bArr, int i) {
        Object obj = new byte[8];
        Arrays.fill(obj, (byte) 0);
        System.arraycopy(bArr, i, obj, 4, 4);
        return D(obj);
    }

    public static long D(byte[] bArr) {
        return ((((((((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48)) | ((((long) bArr[2]) & 255) << 40)) | ((((long) bArr[3]) & 255) << 32)) | ((((long) bArr[4]) & 255) << 24)) | ((((long) bArr[5]) & 255) << 16)) | ((((long) bArr[6]) & 255) << 8)) | (((long) bArr[7]) & 255);
    }

    public static a a(RandomAccessFile randomAccessFile, byte[] bArr, int i) {
        try {
            int read = randomAccessFile.read(bArr);
            while (read >= 8) {
                int k = k(bArr, 0);
                int k2 = k(bArr, 4);
                if (k2 != i) {
                    if (k2 != a.deH && k2 != a.deL) {
                        if (!a(randomAccessFile, (long) (k - 8))) {
                            break;
                        }
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                } else {
                    long filePointer = randomAccessFile.getFilePointer() - ((long) read);
                    if (k2 == a.deJ) {
                        return new h(k, filePointer, k2, 0);
                    }
                    if (k2 == a.deK) {
                        return new e(k, filePointer, k2, 0);
                    }
                    return k2 == a.deM ? new g(k, filePointer, k2, 0) : new a(k, filePointer, k2, 0);
                }
            }
            return null;
        } catch (Throwable e) {
            v.a("MicroMsg.AtomUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.AtomUtil", "find Atom error: " + e.toString());
            return null;
        }
    }

    public static boolean a(RandomAccessFile randomAccessFile, long j) {
        long j2 = 0;
        while (j > 2147483647L) {
            j2 += (long) randomAccessFile.skipBytes(Integer.MAX_VALUE);
            j -= 2147483647L;
        }
        j2 += (long) randomAccessFile.skipBytes((int) j);
        if (j2 == j) {
            return true;
        }
        v.w("MicroMsg.AtomUtil", "can not skip.skip: " + j + " trueSkip : " + j2);
        return false;
    }
}
