package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@SuppressLint({"NewApi"})
public final class e {
    private static final int pyR = 4;
    public static String pyS = null;
    public static final a pyT = new a() {
        public final boolean g(File file, File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };

    public interface a {
        boolean g(File file, File file2);
    }

    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str);
    }

    public static boolean E(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        d(file, false);
        return file.mkdirs();
    }

    public static void F(File file) {
        d(file, false);
    }

    public static boolean G(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static FileOutputStream H(File file) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.exists() || parentFile.mkdirs())) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file);
    }

    private static File a(Context context, boolean z, String str) {
        String absolutePath;
        if (z) {
            File file = new File(context.getDir("tbs", 0), "core_private");
            absolutePath = (file.isDirectory() || file.mkdir()) ? file.getAbsolutePath() : null;
        } else {
            absolutePath = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
        }
        if (absolutePath == null) {
            return null;
        }
        file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        return file2;
    }

    public static String a(Context context, String str, int i, boolean z) {
        if (context == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e) {
        }
        switch (i) {
            case 1:
                return !str2.equals(SQLiteDatabase.KeyEmpty) ? str2 + "tencent" + File.separator + "tbs" + File.separator + str : str2;
            case 2:
                return !str2.equals(SQLiteDatabase.KeyEmpty) ? str2 + "tbs" + File.separator + "backup" + File.separator + str : str2;
            case 3:
                return !str2.equals(SQLiteDatabase.KeyEmpty) ? str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str : str2;
            case 4:
                if (str2.equals(SQLiteDatabase.KeyEmpty)) {
                    return bv(context, "backup");
                }
                str2 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                if (!z) {
                    return str2;
                }
                File file = new File(str2);
                if (file.exists() && file.canWrite()) {
                    return str2;
                }
                if (file.exists()) {
                    return bv(context, "backup");
                }
                file.mkdirs();
                return !file.canWrite() ? bv(context, "backup") : str2;
            case 5:
                return !str2.equals(SQLiteDatabase.KeyEmpty) ? str2 + "tencent" + File.separator + "tbs" + File.separator + str : str2;
            case 6:
                if (pyS != null) {
                    return pyS;
                }
                str2 = bv(context, "tbslog");
                pyS = str2;
                return str2;
            default:
                return SQLiteDatabase.KeyEmpty;
        }
    }

    public static FileLock a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            return tryLock.isValid() ? tryLock : null;
        } catch (OverlappingFileLockException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e) {
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
            }
        }
    }

    private static boolean a(File file, File file2, FileFilter fileFilter) {
        a aVar = pyT;
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return a(file, file2, fileFilter, aVar);
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file3 : listFiles) {
            if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
        }
        return z;
    }

    private static boolean a(File file, File file2, FileFilter fileFilter, a aVar) {
        Throwable th;
        FileChannel fileChannel = null;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return true;
        }
        FileChannel channel;
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (aVar == null || !aVar.g(file, file2)) {
                        d(file2, false);
                    } else {
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        return true;
                    }
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    d(parentFile, false);
                }
                if (parentFile.exists() || parentFile.mkdirs()) {
                    channel = new FileInputStream(file).getChannel();
                    try {
                        FileChannel channel2 = new FileOutputStream(file2).getChannel();
                        try {
                            long size = channel.size();
                            if (channel2.transferFrom(channel, 0, size) != size) {
                                F(file2);
                                if (channel != null) {
                                    channel.close();
                                }
                                if (channel2 != null) {
                                    channel2.close();
                                }
                                return false;
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            if (channel2 != null) {
                                channel2.close();
                            }
                            return true;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            fileChannel = channel;
                            channel = channel2;
                            th = th3;
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        FileChannel fileChannel2 = fileChannel;
                        fileChannel = channel;
                        channel = fileChannel2;
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        throw th;
                    }
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                return false;
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            channel = fileChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean a(InputStream inputStream, ZipEntry zipEntry, String str, String str2) {
        Throwable e;
        E(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                long size = zipEntry.getSize();
                zipEntry.getTime();
                if (n(str3, size, zipEntry.getCrc())) {
                    TbsLog.e("FileHelper", "file is different: " + str3);
                    return false;
                }
                if (!file.setLastModified(zipEntry.getTime())) {
                    TbsLog.e("FileHelper", "Couldn't set time for dst file " + file);
                }
                return true;
            } catch (IOException e2) {
                e = e2;
                try {
                    F(file);
                    throw new IOException("Couldn't write dst file " + file, e);
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            F(file);
            throw new IOException("Couldn't write dst file " + file, e);
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, b bVar) {
        Throwable th;
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            Object obj = null;
            Object obj2 = null;
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                if (name != null && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                    String substring = name.substring(name.lastIndexOf(47));
                    if (substring.endsWith(".so")) {
                        if (name.regionMatches(pyR, str2, 0, str2.length()) && name.charAt(pyR + str2.length()) == '/') {
                            obj = 1;
                        } else {
                            if (str3 != null) {
                                if (name.regionMatches(pyR, str3, 0, str3.length()) && name.charAt(pyR + str3.length()) == '/') {
                                    obj2 = 1;
                                    if (obj != null) {
                                    }
                                }
                            }
                            if (str4 != null && name.regionMatches(pyR, str4, 0, str4.length()) && name.charAt(pyR + str4.length()) == '/' && obj == null && r2 == null) {
                            }
                        }
                    }
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    try {
                        if (!bVar.a(inputStream, zipEntry, substring.substring(1))) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (zipFile != null) {
                                zipFile.close();
                            }
                            return false;
                        } else if (inputStream != null) {
                            inputStream.close();
                        } else {
                            continue;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    public static String ae(Context context, int i) {
        return a(context, context.getApplicationInfo().packageName, i, true);
    }

    private static int b(InputStream inputStream, OutputStream outputStream) {
        long j;
        if (inputStream != null) {
            byte[] bArr = new byte[4096];
            j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j += (long) read;
            }
        } else {
            j = -1;
        }
        return j > 2147483647L ? -1 : (int) j;
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        File a = a(context, z, str);
        if (a != null) {
            try {
                return new FileOutputStream(a);
            } catch (FileNotFoundException e) {
            }
        }
        return null;
    }

    private static File bNS() {
        try {
            return Environment.getExternalStorageDirectory();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean bNT() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            return false;
        }
    }

    public static File bNU() {
        File file = new File(bNS().getAbsolutePath() + "/.tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static String bv(Context context, String str) {
        String str2 = SQLiteDatabase.KeyEmpty;
        if (context == null) {
            return str2;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return applicationContext.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            try {
                return Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + applicationContext.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
            } catch (Exception e) {
                return SQLiteDatabase.KeyEmpty;
            }
        }
    }

    public static void d(File file, boolean z) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File d : listFiles) {
                    d(d, z);
                }
                if (!z) {
                    file.delete();
                }
            }
        }
    }

    public static boolean e(File file, File file2) {
        String path = file.getPath();
        final String path2 = file2.getPath();
        return a(path, Build.CPU_ABI, VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, k.ej("ro.product.cpu.upgradeabi", "armeabi"), new b() {
            public final boolean a(InputStream inputStream, ZipEntry zipEntry, String str) {
                try {
                    return e.a(inputStream, zipEntry, path2, str);
                } catch (Throwable e) {
                    throw new Exception("copyFileIfChanged Exception", e);
                }
            }
        });
    }

    public static boolean f(File file, File file2) {
        return a(file, file2, null);
    }

    public static boolean fY(Context context) {
        return VERSION.SDK_INT < 23 ? true : context != null ? context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 : false;
    }

    public static boolean fZ(Context context) {
        long bOj = t.bOj();
        boolean z = bOj >= i.fb(context).bMY();
        if (!z) {
            TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + bOj);
        }
        return z;
    }

    private static boolean n(String str, long j, long j2) {
        Throwable th;
        FileInputStream fileInputStream;
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            return true;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                TbsLog.i("FileHelper", file.getName() + ": crc = " + value + ", zipCrc = " + j2);
                if (value == j2) {
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return false;
                } else if (fileInputStream2 == null) {
                    return true;
                } else {
                    fileInputStream2.close();
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static byte[] n(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
