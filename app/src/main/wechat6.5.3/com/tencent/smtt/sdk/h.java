package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

final class h {
    private static Context mContext = null;
    private static h pvZ = null;

    private h() {
    }

    static File bMT() {
        m.bNm();
        File file = new File(m.ft(mContext), "tbscoreinstall.txt");
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Properties bMU() {
        /*
        r1 = 0;
        r3 = bMT();	 Catch:{ Exception -> 0x001b, all -> 0x0025 }
        r2 = new java.util.Properties;	 Catch:{ Exception -> 0x001b, all -> 0x0025 }
        r2.<init>();	 Catch:{ Exception -> 0x001b, all -> 0x0025 }
        if (r3 == 0) goto L_0x003c;
    L_0x000c:
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0035, all -> 0x0025 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0035, all -> 0x0025 }
        r2.load(r0);	 Catch:{ Exception -> 0x0038, all -> 0x0030 }
    L_0x0014:
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0.close();	 Catch:{ IOException -> 0x002c }
    L_0x0019:
        r0 = r2;
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = move-exception;
        r0 = r1;
    L_0x001d:
        if (r1 == 0) goto L_0x001a;
    L_0x001f:
        r1.close();	 Catch:{ IOException -> 0x0023 }
        goto L_0x001a;
    L_0x0023:
        r1 = move-exception;
        goto L_0x001a;
    L_0x0025:
        r0 = move-exception;
    L_0x0026:
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r1.close();	 Catch:{ IOException -> 0x002e }
    L_0x002b:
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0019;
    L_0x002e:
        r1 = move-exception;
        goto L_0x002b;
    L_0x0030:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0026;
    L_0x0035:
        r0 = move-exception;
        r0 = r2;
        goto L_0x001d;
    L_0x0038:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x001d;
    L_0x003c:
        r0 = r1;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.h.bMU():java.util.Properties");
    }

    static synchronized h fa(Context context) {
        h hVar;
        synchronized (h.class) {
            mContext = context.getApplicationContext();
            if (pvZ == null) {
                pvZ = new h();
            }
            hVar = pvZ;
        }
        return hVar;
    }

    final int Qi(String str) {
        Properties bMU = bMU();
        return (bMU == null || bMU.getProperty(str) == null) ? -1 : Integer.parseInt(bMU.getProperty(str));
    }

    final int Qj(String str) {
        Properties bMU = bMU();
        return (bMU == null || bMU.getProperty(str) == null) ? 0 : Integer.parseInt(bMU.getProperty(str));
    }

    final String Qk(String str) {
        Properties bMU = bMU();
        return (bMU == null || bMU.getProperty(str) == null) ? null : bMU.getProperty(str);
    }

    final void cq(String str, int i) {
        ee(str, String.valueOf(i));
    }

    final void dG(int i, int i2) {
        cq("copy_core_ver", i);
        cq("copy_status", i2);
    }

    final void dH(int i, int i2) {
        cq("install_core_ver", i);
        cq("install_status", i2);
    }

    final void ee(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Properties bMU = bMU();
            if (bMU != null) {
                bMU.setProperty(str, str2);
                File bMT = bMT();
                if (bMT != null) {
                    fileOutputStream = new FileOutputStream(bMT);
                    try {
                        bMU.store(fileOutputStream, "update " + str + " and status!");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream2 = fileOutputStream;
                        th = th3;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                }
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }
}
