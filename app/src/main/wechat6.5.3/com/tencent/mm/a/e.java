package com.tencent.mm.a;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileChannel;

public final class e {
    public static int a(String str, String str2, String str3, byte[] bArr) {
        return a(str, str2 + str3, bArr);
    }

    public static int a(String str, String str2, byte[] bArr) {
        Throwable e;
        if (bArr == null) {
            return -2;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2, true));
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                    return 0;
                } catch (Throwable e2) {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, str2, Integer.valueOf(bArr.length));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op appendBuf e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, str2, Integer.valueOf(bArr.length));
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e22) {
                            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, str2, Integer.valueOf(bArr.length));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.FileOperation", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op appendBuf close e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, str2, Integer.valueOf(bArr.length));
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op appendBuf e type:%s, e msg:%s, fileDir:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, str2, Integer.valueOf(bArr.length));
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            return -1;
        }
    }

    public static int e(String str, byte[] bArr) {
        Throwable e;
        if (bArr == null || bArr.length == 0) {
            return -2;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, true);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (Throwable e2) {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.FileOperation", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length));
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return -1;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }

    public static int a(String str, byte[] bArr, int i) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (bArr == null || bArr.length == 0 || bArr.length < i + 0) {
            return -2;
        }
        try {
            fileOutputStream = new FileOutputStream(str, true);
            try {
                fileOutputStream.write(bArr, 0, i);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (Throwable e2) {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.FileOperation", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return -1;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }

    public static int b(String str, byte[] bArr, int i) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        try {
            fileOutputStream = new FileOutputStream(str, false);
            try {
                fileOutputStream.write(bArr, 0, i);
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (Throwable e2) {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    return 0;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op writeFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.FileOperation", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op writeFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e4.getClass().getSimpleName(), e4.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op writeFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i));
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return -1;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }

    public static byte[] c(String str, int i, int i2) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                if (i2 == -1) {
                    i2 = (int) file.length();
                }
                if (i >= 0 && i2 > 0 && i + i2 <= ((int) file.length())) {
                    try {
                        randomAccessFile = new RandomAccessFile(str, "r");
                        try {
                            bArr = new byte[i2];
                            randomAccessFile.seek((long) i);
                            randomAccessFile.readFully(bArr);
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e2) {
                                v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            try {
                                v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Throwable e22) {
                                        v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                                        v.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                                    }
                                }
                                return bArr;
                            } catch (Throwable th2) {
                                th = th2;
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Throwable e222) {
                                        v.a("MicroMsg.FileOperation", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                        v.w("MicroMsg.FileOperation", "file op readFromFile close e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e4) {
                        e222 = e4;
                        randomAccessFile = null;
                        v.a("MicroMsg.FileOperation", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.w("MicroMsg.FileOperation", "file op readFromFile e type:%s, e msg:%s, fileName:%s, offset:%d, len:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(i2));
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return bArr;
                    } catch (Throwable e2222) {
                        randomAccessFile = null;
                        th = e2222;
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                }
            }
        }
        return bArr;
    }

    public static byte[] d(String str, int i, int i2) {
        int length;
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                bArr = new byte[length];
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Throwable e2) {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    return bArr;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e2.getClass().getSimpleName(), e2.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                    if (randomAccessFile != null) {
                        return bArr;
                    }
                    try {
                        randomAccessFile.close();
                        return bArr;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e22.getClass().getSimpleName(), e22.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                        return bArr;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e222) {
                            v.a("MicroMsg.FileOperation", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op readFromFileV2 close e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            randomAccessFile = null;
            v.a("MicroMsg.FileOperation", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op readFromFileV2 e type:%s, e msg:%s, fileName:%s, offset:%d, maxLen:%d", e222.getClass().getSimpleName(), e222.getMessage(), str, Integer.valueOf(i), Integer.valueOf(length));
            if (randomAccessFile != null) {
                return bArr;
            }
            randomAccessFile.close();
            return bArr;
        } catch (Throwable e2222) {
            randomAccessFile = null;
            th = e2222;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static int aQ(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    public static final void h(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            File file = new File(str + str2);
            File file2 = new File(str + str3);
            if (file.exists()) {
                file.renameTo(file2);
            }
        }
    }

    public static final boolean renameTo(File file, File file2) {
        OutputStream fileOutputStream;
        Throwable e;
        InputStream inputStream;
        int i = 0;
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            boolean z = false;
            while (i < listFiles.length) {
                File file3 = listFiles[i];
                z = renameTo(file3, new File(file2.getPath(), file3.getName()));
                if (z) {
                    file.delete();
                }
                i++;
            }
            return z;
        }
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    file.delete();
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e2.getClass().getSimpleName(), e2.getMessage(), file, file2);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22) {
                        v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e22.getClass().getSimpleName(), e22.getMessage(), file, file2);
                    }
                    return true;
                } catch (Exception e3) {
                    e22 = e3;
                    inputStream = fileInputStream;
                    try {
                        v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e22.getClass().getSimpleName(), e22.getMessage(), file, file2);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                v.a("MicroMsg.FileOperation", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e222.getClass().getSimpleName(), e222.getMessage(), file, file2);
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            v.a("MicroMsg.FileOperation", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e2222.getClass().getSimpleName(), e2222.getMessage(), file, file2);
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4) {
                                v.a("MicroMsg.FileOperation", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.w("MicroMsg.FileOperation", "file op renameTo close in e type:%s, e msg:%s, path:%s, newPath:%s", e4.getClass().getSimpleName(), e4.getMessage(), file, file2);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                v.a("MicroMsg.FileOperation", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.w("MicroMsg.FileOperation", "file op renameTo close out e type:%s, e msg:%s, path:%s, newPath:%s", e5.getClass().getSimpleName(), e5.getMessage(), file, file2);
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                inputStream = fileInputStream;
                v.a("MicroMsg.FileOperation", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e2222.getClass().getSimpleName(), e2222.getMessage(), file, file2);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (Exception e7) {
            e2222 = e7;
            inputStream = null;
            fileOutputStream = null;
            v.a("MicroMsg.FileOperation", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op renameTo e type:%s, e msg:%s, path:%s, newPath:%s", e2222.getClass().getSimpleName(), e2222.getMessage(), file, file2);
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            e2222 = th4;
            inputStream = null;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }

    public static final boolean aR(String str) {
        if (str != null && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static final boolean e(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                while (i < listFiles.length) {
                    e(listFiles[i]);
                    i++;
                }
            }
        }
        file.delete();
        return true;
    }

    public static final boolean f(File file) {
        return b.f(file);
    }

    public static final String aS(String str) {
        if (str == null || str.length() <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == name.length() - 1) {
            return SQLiteDatabase.KeyEmpty;
        }
        return name.substring(lastIndexOf + 1);
    }

    public static final String aT(String str) {
        if (str == null || str.length() <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        if (lastIndexOf == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        return name.substring(0, lastIndexOf);
    }

    public static final boolean aU(String str) {
        if (be.kS(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            return false;
        }
        String str2 = "/";
        for (int i = 0; i < split.length; i++) {
            if (!be.kS(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    return false;
                }
                if (!(file2.exists() || file2.mkdir())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static long p(String str, String str2) {
        FileChannel channel;
        Throwable e;
        Throwable th;
        FileChannel fileChannel = null;
        try {
            FileChannel channel2;
            channel = new FileInputStream(str).getChannel();
            try {
                channel2 = new FileOutputStream(str2).getChannel();
            } catch (Exception e2) {
                e = e2;
                fileChannel = channel;
                channel = null;
                try {
                    v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", e.getClass().getSimpleName(), e.getMessage(), str, str2);
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    e = th2;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                fileChannel = channel;
                channel = null;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw e;
            }
            try {
                channel2.transferFrom(channel, 0, channel.size());
                long size = channel.size();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e7) {
                    }
                }
                if (channel2 != null) {
                    try {
                        channel2.close();
                    } catch (IOException e8) {
                    }
                }
                return size;
            } catch (Throwable e9) {
                th = e9;
                fileChannel = channel;
                channel = channel2;
                e = th;
                v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.w("MicroMsg.FileOperation", "file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", e.getClass().getSimpleName(), e.getMessage(), str, str2);
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                return -1;
            } catch (Throwable e92) {
                th = e92;
                fileChannel = channel;
                channel = channel2;
                e = th;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw e;
            }
        } catch (Exception e10) {
            e = e10;
            channel = null;
            v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op copyFile e type:%s, e msg:%s, src:%s, dest:%s", e.getClass().getSimpleName(), e.getMessage(), str, str2);
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            return -1;
        } catch (Throwable th4) {
            e = th4;
            channel = null;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw e;
        }
    }

    public static String aV(String str) {
        BufferedReader bufferedReader;
        Throwable e;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read != -1) {
                        stringBuffer.append(String.valueOf(cArr, 0, read));
                    } else {
                        try {
                            break;
                        } catch (Throwable e2) {
                            v.a("MicroMsg.FileOperation", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op readFileAsString close e type:%s, e msg:%s, filePath:%s", e2.getClass().getSimpleName(), e2.getMessage(), str);
                        }
                    }
                }
                bufferedReader.close();
                return stringBuffer.toString();
            } catch (IOException e3) {
                e = e3;
                try {
                    v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.FileOperation", "file op readFileAsString e type:%s, e msg:%s, filePath:%s", e.getClass().getSimpleName(), e.getMessage(), str);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e22) {
                            v.a("MicroMsg.FileOperation", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.w("MicroMsg.FileOperation", "file op readFileAsString close e type:%s, e msg:%s, filePath:%s", e22.getClass().getSimpleName(), e22.getMessage(), str);
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.w("MicroMsg.FileOperation", "file op readFileAsString e type:%s, e msg:%s, filePath:%s", e.getClass().getSimpleName(), e.getMessage(), str);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    public static void c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.w("MicroMsg.FileOperation", "file op closeInputStream e type:%s, e msg:%s, stream:%s", e.getClass().getSimpleName(), e.getMessage(), inputStream);
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable e) {
                v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.w("MicroMsg.FileOperation", "file op closeOutputStream e type:%s, e msg:%s, stream:%s", e.getClass().getSimpleName(), e.getMessage(), outputStream);
            }
        }
    }

    public static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Throwable e) {
                v.a("MicroMsg.FileOperation", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.w("MicroMsg.FileOperation", "file op closeReader e type:%s, e msg:%s, reader:%s", e.getClass().getSimpleName(), e.getMessage(), reader);
            }
        }
    }

    public static void aW(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs() || !parentFile.isDirectory()) {
                v.e("MicroMsg.FileOperation", "mkParentDir mkdir error. %s", str);
            }
        }
    }
}
