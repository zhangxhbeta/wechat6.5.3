package com.tencent.mmdb;

import android.util.Base64;
import android.util.Pair;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDatabaseConfiguration;
import com.tencent.mmdb.database.SQLiteException;
import com.tencent.mmdb.database.SQLiteTrace;
import com.tencent.mmdb.support.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String TAG = "MMDB.DefaultDatabaseErrorHandler";

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        List list;
        Throwable th2;
        Log.e(TAG, "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
        if (sQLiteDatabase.isOpen()) {
            SQLiteTrace traceCallback = sQLiteDatabase.getTraceCallback();
            if (traceCallback != null) {
                traceCallback.onDatabaseCorrupted(sQLiteDatabase);
            }
            List list2 = null;
            try {
                list2 = sQLiteDatabase.getAttachedDbs();
                try {
                    sQLiteDatabase.close();
                } catch (SQLiteException e) {
                } catch (Throwable th3) {
                    th = th3;
                    list = r1;
                    th2 = th;
                    if (r0 == null) {
                        for (Pair pair : r0) {
                            deleteDatabaseFile((String) pair.second);
                        }
                    } else {
                        deleteDatabaseFile(sQLiteDatabase.getPath());
                    }
                    throw th2;
                }
            } catch (SQLiteException e2) {
            } catch (Throwable th32) {
                th = th32;
                list = list2;
                th2 = th;
                if (r0 == null) {
                    deleteDatabaseFile(sQLiteDatabase.getPath());
                } else {
                    while (r2.hasNext()) {
                        deleteDatabaseFile((String) pair.second);
                    }
                }
                throw th2;
            }
            if (r1 != null) {
                for (Pair pair2 : r1) {
                    deleteDatabaseFile((String) pair2.second);
                }
                return;
            }
            deleteDatabaseFile(sQLiteDatabase.getPath());
            return;
        }
        deleteDatabaseFile(sQLiteDatabase.getPath());
    }

    private void deleteDatabaseFile(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[4096];
                Log.e("MMDB.CorruptionDumper", ">>> DUMP CORRUPTED DATABASE <<<");
                int i = 0;
                while (i < 4096) {
                    int read = fileInputStream.read(bArr, i, 4096 - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                }
                Log.e("MMDB.CorruptionDumper", Base64.encodeToString(bArr, 0));
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                try {
                    Log.e("MMDB.CorruptionDumper", "Failed to dump database: " + str);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (!str.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH)) {
                    }
                    return;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileInputStream2 = fileInputStream;
                    th = th3;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            fileInputStream = null;
            Log.e("MMDB.CorruptionDumper", "Failed to dump database: " + str);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (!str.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH)) {
                return;
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        if (!str.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) && str.trim().length() != 0) {
            Log.e(TAG, "deleting the database file: " + str);
            try {
                renameTo(new File(str), new File(str + "err" + System.currentTimeMillis()));
            } catch (Exception e6) {
                Log.w(TAG, "delete failed: " + e6.getMessage());
            }
        }
    }

    private static final boolean renameTo(File file, File file2) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream = null;
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
            fileInputStream = new FileInputStream(file);
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
                    } catch (IOException e) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                    return true;
                } catch (Exception e3) {
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e5) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                fileOutputStream = null;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
