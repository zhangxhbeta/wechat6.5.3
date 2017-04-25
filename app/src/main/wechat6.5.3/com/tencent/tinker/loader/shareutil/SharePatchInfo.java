package com.tencent.tinker.loader.shareutil;

import android.os.Build;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SharePatchInfo {
    public String pGR;
    public String pGS;
    public String pGT;

    public SharePatchInfo(String str, String str2, String str3) {
        this.pGR = str;
        this.pGS = str2;
        this.pGT = str3;
    }

    public static SharePatchInfo j(File file, File file2) {
        ShareFileLockHelper M;
        Throwable e;
        Throwable th;
        SharePatchInfo sharePatchInfo = null;
        if (!(file == null || file2 == null)) {
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                M = ShareFileLockHelper.M(file2);
                try {
                    sharePatchInfo = S(file);
                    try {
                        M.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
                    } catch (Throwable th2) {
                        e = th2;
                        if (M != null) {
                            try {
                                M.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Throwable e5) {
                th = e5;
                M = null;
                e = th;
                throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
            } catch (Throwable e52) {
                th = e52;
                M = null;
                e = th;
                if (M != null) {
                    M.close();
                }
                throw e;
            }
        }
        return sharePatchInfo;
    }

    public static boolean a(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            shareFileLockHelper = ShareFileLockHelper.M(file2);
            boolean a = a(file, sharePatchInfo);
            try {
                shareFileLockHelper.close();
                return a;
            } catch (IOException e) {
                return a;
            }
        } catch (Throwable e2) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e2);
        } catch (Throwable th) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    private static SharePatchInfo S(File file) {
        String property;
        Object e;
        Throwable th;
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        while (i < 2 && i2 == 0) {
            Closeable fileInputStream;
            int i3 = i + 1;
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    str3 = properties.getProperty("old");
                    str2 = properties.getProperty("new");
                    property = properties.getProperty("print");
                    SharePatchFileUtil.c(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        new StringBuilder("read property failed, e:").append(e);
                        SharePatchFileUtil.c(fileInputStream);
                        property = str;
                        if (str3 != null) {
                        }
                        str = property;
                        i = i3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                new StringBuilder("read property failed, e:").append(e);
                SharePatchFileUtil.c(fileInputStream);
                property = str;
                if (str3 != null) {
                }
                str = property;
                i = i3;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            if (str3 != null || r3 == null) {
                str = property;
                i = i3;
            } else if ((str3.equals(SQLiteDatabase.KeyEmpty) || SharePatchFileUtil.QB(str3)) && SharePatchFileUtil.QB(r3)) {
                str = property;
                i2 = 1;
                i = i3;
            } else {
                new StringBuilder("path info file  corrupted:").append(file.getAbsolutePath());
                str = property;
                i = i3;
            }
        }
        if (i2 != 0) {
            return new SharePatchInfo(str3, str2, str);
        }
        return null;
        SharePatchFileUtil.c(fileInputStream);
        throw th;
    }

    private static boolean a(File file, SharePatchInfo sharePatchInfo) {
        Closeable fileOutputStream;
        SharePatchInfo S;
        boolean z;
        Throwable th;
        if (file == null || sharePatchInfo == null) {
            return false;
        }
        new StringBuilder("rewritePatchInfoFile file path:").append(file.getAbsolutePath()).append(" , oldVer:").append(sharePatchInfo.pGR).append(", newVer:").append(sharePatchInfo.pGS);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        int i = 0;
        boolean z2 = false;
        while (i < 2 && !z2) {
            int i2 = i + 1;
            Properties properties = new Properties();
            properties.put("old", sharePatchInfo.pGR);
            properties.put("new", sharePatchInfo.pGS);
            properties.put("print", Build.FINGERPRINT);
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, "from old version:" + sharePatchInfo.pGR + " to new version:" + sharePatchInfo.pGS);
                    SharePatchFileUtil.c(fileOutputStream);
                } catch (Exception e) {
                    SharePatchFileUtil.c(fileOutputStream);
                    S = S(file);
                    if (S == null) {
                    }
                    z = false;
                    if (z) {
                        file.delete();
                    }
                    z2 = z;
                    i = i2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                fileOutputStream = null;
                SharePatchFileUtil.c(fileOutputStream);
                S = S(file);
                if (S == null) {
                }
                z = false;
                if (z) {
                    file.delete();
                }
                z2 = z;
                i = i2;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            S = S(file);
            if (S == null && S.pGR.equals(sharePatchInfo.pGR) && S.pGS.equals(sharePatchInfo.pGS)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                file.delete();
            }
            z2 = z;
            i = i2;
        }
        if (z2) {
            return true;
        }
        return false;
        SharePatchFileUtil.c(fileOutputStream);
        throw th;
    }
}
