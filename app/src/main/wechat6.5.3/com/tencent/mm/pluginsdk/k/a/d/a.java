package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class a {
    public static long Hj(String str) {
        if (be.kS(str)) {
            return 0;
        }
        File file = new File(str);
        if (file.isFile()) {
            return file.length();
        }
        return 0;
    }

    public static boolean t(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (be.bl(bArr)) {
            return false;
        }
        File file = new File(str);
        file.delete();
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    v.a("MicroMsg.ResDownloaderFileUtils", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                return true;
            } catch (FileNotFoundException e3) {
                e2 = e3;
                try {
                    v.a("MicroMsg.ResDownloaderFileUtils", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.ResDownloaderFileUtils", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.ResDownloaderFileUtils", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream2 = fileOutputStream;
                try {
                    v.a("MicroMsg.ResDownloaderFileUtils", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (fileOutputStream2 != null) {
                        return false;
                    }
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return false;
                    } catch (Throwable e222) {
                        v.a("MicroMsg.ResDownloaderFileUtils", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                } catch (Throwable th2) {
                    e222 = th2;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    }
                    throw e222;
                }
            }
        } catch (FileNotFoundException e6) {
            e222 = e6;
            fileOutputStream = null;
            v.a("MicroMsg.ResDownloaderFileUtils", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            return false;
        } catch (IOException e7) {
            e222 = e7;
            v.a("MicroMsg.ResDownloaderFileUtils", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (fileOutputStream2 != null) {
                return false;
            }
            fileOutputStream2.flush();
            fileOutputStream2.close();
            return false;
        }
    }

    public static byte[] Hk(String str) {
        Closeable fileInputStream;
        Closeable byteArrayOutputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException e2) {
                e = e2;
                byteArrayOutputStream = bArr;
                try {
                    v.a("MicroMsg.ResDownloaderFileUtils", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    e(fileInputStream);
                    e(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    e(fileInputStream);
                    e(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = bArr;
                v.a("MicroMsg.ResDownloaderFileUtils", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                e(fileInputStream);
                e(byteArrayOutputStream);
                return bArr;
            } catch (Throwable e4) {
                byteArrayOutputStream = bArr;
                th = e4;
                e(fileInputStream);
                e(byteArrayOutputStream);
                throw th;
            }
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                e(fileInputStream);
                e(byteArrayOutputStream);
            } catch (FileNotFoundException e5) {
                e4 = e5;
                v.a("MicroMsg.ResDownloaderFileUtils", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                e(fileInputStream);
                e(byteArrayOutputStream);
                return bArr;
            } catch (IOException e6) {
                e4 = e6;
                v.a("MicroMsg.ResDownloaderFileUtils", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                e(fileInputStream);
                e(byteArrayOutputStream);
                return bArr;
            }
        } catch (FileNotFoundException e7) {
            e4 = e7;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            v.a("MicroMsg.ResDownloaderFileUtils", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
            e(fileInputStream);
            e(byteArrayOutputStream);
            return bArr;
        } catch (IOException e8) {
            e4 = e8;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            v.a("MicroMsg.ResDownloaderFileUtils", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
            e(fileInputStream);
            e(byteArrayOutputStream);
            return bArr;
        } catch (Throwable e42) {
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            th = e42;
            e(fileInputStream);
            e(byteArrayOutputStream);
            throw th;
        }
        return bArr;
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                v.a("MicroMsg.ResDownloaderFileUtils", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.ResDownloaderFileUtils", String.format("%s close failed (%s)", new Object[]{closeable.getClass().getSimpleName(), e.getMessage()}));
            }
        }
    }

    public static boolean Hl(String str) {
        if (be.kS(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.delete()) {
            return true;
        }
        return false;
    }
}
